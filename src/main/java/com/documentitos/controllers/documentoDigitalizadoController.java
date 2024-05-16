/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.controllers;

import com.documentitos.commons.CommonController;
import com.documentitos.models.documentoDigitalizado;
import com.documentitos.services.documentoDigitalizadoSvc;
import com.documentitos.validator.documentoDigitalizadoValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 *
 * @author yocary
 */
@Api
@RestController
@RequestMapping("external/documentoDigitalizado")
@EnableEurekaClient
public class documentoDigitalizadoController extends CommonController<documentoDigitalizado, documentoDigitalizadoSvc, documentoDigitalizadoValidator> {

    @Autowired
    private documentoDigitalizadoSvc service;

    @GetMapping(path = "/obtenerDocumentos/{fechaInicio}/{fechaFin}/{propietario}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtiene datos de documentos enviando como parametro el id de la solicitud documentos")
    public ResponseEntity<?> obtenerDocumentos(@PathVariable(required = true) @ApiParam(value = "fechaInicio") String fechaInicio,
            @PathVariable(required = true) @ApiParam(value = "fechaFin") String fechaFin,
            @PathVariable(required = true) @ApiParam(value = "propietario") String propietario,
            @RequestHeader(name = "Accept-Languaje", required = false) Locale locale) throws ParseException {
        return ResponseEntity.ok(service.obtenerDocumentos(fechaInicio, fechaFin, propietario));
    }
}
