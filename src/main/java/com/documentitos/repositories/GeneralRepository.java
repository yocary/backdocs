/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.repositories;

import com.documentitos.models.documentoDigitalizado;
import com.documentitos.projections.obtenerDocumentosProjection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yocary
 */
@Repository
public class GeneralRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
        public List<documentoDigitalizado> obtenerDocumentos(String fechaInicio, String fechaFin, String propietario) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date pFechaInicio = sdf.parse(fechaInicio);
        Date pFechaFin = sdf.parse(fechaFin);

        String query = "select * from documentitos.documento_digitalizado dd where fecha_ingreso between :pFechaInicio and   :pFechaFin " 
            + "and propietario =:propietario";
        Query q = entityManager.createNativeQuery(query, documentoDigitalizado.class);
        q.setParameter("pFechaInicio", pFechaInicio);
        q.setParameter("pFechaFin", pFechaFin);
        q.setParameter("propietario", propietario);
        return q.getResultList();
    }
        


}
