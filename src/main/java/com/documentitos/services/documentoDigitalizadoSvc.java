/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.services;

import com.documentitos.commons.CommonSvc;
import com.documentitos.models.documentoDigitalizado;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author yocary
 */
public interface documentoDigitalizadoSvc extends CommonSvc<documentoDigitalizado> {

    public List<documentoDigitalizado> obtenerDocumentos(String fechaInicio, String fechaFin, String propietario) throws ParseException;
}
