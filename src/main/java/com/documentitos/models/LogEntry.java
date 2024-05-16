/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.models;

import java.time.LocalDateTime;

/**
 *
 * @author yocary
 */
public class LogEntry {
    private LocalDateTime dateTime;
    private String logText;

    public LogEntry(LocalDateTime dateTime, String logText) {
        this.dateTime = dateTime;
        this.logText = logText;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLogText() {
        return logText;
    }
}

