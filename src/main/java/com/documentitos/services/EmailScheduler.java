package com.documentitos.services;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.spi.AppenderAttachable;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailScheduler {

    private final EmailService emailService;
    private LocalDateTime lastExecutionTime; // Variable para almacenar el tiempo de la última ejecución
    
        private final Logger logger = (Logger) LoggerFactory.getLogger(EmailScheduler.class);


    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
        this.lastExecutionTime = LocalDateTime.now(); // Inicializar el tiempo de la última ejecución al momento de la creación del objeto
    }

    @Scheduled(cron = "0 */3 * * * *") // Ejecutar cada 3 minutos
    public void sendLogsByEmail() throws IOException {
        String subject = "Logs de la aplicación Documentitos";
        String logs = generateLogsContentForLast3Minutes();

  
            emailService.sendEmail(subject, logs);
            logger.info("LOGS ENVIADOS POR CORREO EXITOSAMENTE");

    }

    private String generateLogsContentForLast3Minutes() throws IOException {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);

        StringBuilder logsContent = new StringBuilder();

        if (rootLogger instanceof AppenderAttachable) {
            AppenderAttachable<ILoggingEvent> appenderAttachable = (AppenderAttachable<ILoggingEvent>) rootLogger;
            Iterator<Appender<ILoggingEvent>> appenderIterator = appenderAttachable.iteratorForAppenders();
            while (appenderIterator.hasNext()) {
                Appender<ILoggingEvent> appender = appenderIterator.next();
                if (appender instanceof ch.qos.logback.core.FileAppender) {
                    ch.qos.logback.core.FileAppender<ILoggingEvent> fileAppender = (ch.qos.logback.core.FileAppender<ILoggingEvent>) appender;
                    String logFileContent = readLogFileForTimeRange(new File(fileAppender.getFile()), lastExecutionTime, LocalDateTime.now());
                    logsContent.append(logFileContent);
                }
            }
        }

        // Actualizar el tiempo de la última ejecución al tiempo actual
        lastExecutionTime = LocalDateTime.now();

        return logsContent.toString();
    }

private LocalDateTime parseLogDateTime(String line) {
    // Definir el formato esperado para la fecha y hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    // Expresión regular para extraer la fecha y hora del mensaje
    String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    if (matcher.find()) {
        String dateTimeString = matcher.group();
        return LocalDateTime.parse(dateTimeString, formatter);
    } else {
        // La línea no contiene una fecha y hora válidas, puedes manejarla según tus requisitos
        // Por ejemplo, puedes ignorarla o registrar un mensaje de advertencia
        return null;
    }
}


private String readLogFileForTimeRange(File logFile, LocalDateTime startTime, LocalDateTime endTime) throws IOException {
    StringBuilder logContent = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            LocalDateTime logDateTime = parseLogDateTime(line);
            if (logDateTime != null && isWithinTimeRange(logDateTime, startTime, endTime)) {
                logContent.append(line).append(System.lineSeparator());
            }
        }
    }

    return logContent.toString();
}


    private boolean isWithinTimeRange(LocalDateTime dateTime, LocalDateTime startTime, LocalDateTime endTime) {
        return !dateTime.isBefore(startTime) && !dateTime.isAfter(endTime);
    }

}
