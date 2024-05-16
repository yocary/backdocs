/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.repositories;

import com.documentitos.models.documentoDigitalizado;
import com.documentitos.projections.obtenerDocumentosProjection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yocary
 */
public interface documentoDigitalizadoRepository extends CrudRepository<documentoDigitalizado, Object> {

    @Query(value = "select * from documentitos.documento_digitalizado dd where fecha_elaboracion = ?1 and fecha_ingreso = ?2 \n"
            + "and propietario = ?3 ; ",
            nativeQuery = true)
    public List<obtenerDocumentosProjection> obtenerDocumentos(Date fechaElaboracion, Date fechaIngreso, String propietario);
}
