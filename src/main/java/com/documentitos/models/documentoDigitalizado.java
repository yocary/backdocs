/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.models;

/**
 *
 * @author yocary
 */
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "documento_digitalizado", schema = "documentitos")
public class documentoDigitalizado {

    private Long idDocumento;
    private Integer idUsuario;
    private String nombreDocumento;
    private String propietario;
    private String linkArchivo;
    private Date fechaElaboracion;
    private Date fechaIngreso;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Column(name = "id_usuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "nombre_documento", length = 100)
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @Column(name = "propietario", length = 50)
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Column(name = "link_archivo", length = 1000)
    public String getLinkArchivo() {
        return linkArchivo;
    }

    public void setLinkArchivo(String linkArchivo) {
        this.linkArchivo = linkArchivo;
    }

    @Column(name = "fecha_elaboracion")
    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_ingreso")
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
