/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.services.impl;

import com.documentitos.commons.CommonSvcImpl;
import com.documentitos.models.documentoDigitalizado;
import com.documentitos.projections.obtenerDocumentosProjection;
import com.documentitos.repositories.GeneralRepository;
import com.documentitos.repositories.documentoDigitalizadoRepository;
import com.documentitos.services.documentoDigitalizadoSvc;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yocary
 */
@Service
public class documentoDigitalizadoSvcImpl extends CommonSvcImpl<documentoDigitalizado, documentoDigitalizadoRepository> implements documentoDigitalizadoSvc {

    @Autowired
    private GeneralRepository repository;

    @Override
    public List<documentoDigitalizado> obtenerDocumentos(String fechaInicio, String fechaFin, String propietario) throws ParseException {
        return repository.obtenerDocumentos(fechaInicio, fechaFin, propietario);
    }
}
