package com.santofimio.paquetes.models.dto;

import java.math.BigDecimal;

public class PlanDTO {

     private String nombre;
    private String description;
    private String municipio;
    private BigDecimal precioBase;
    private String duracion;
    private String tipoTurismo;
    private Long idAgencia;

    public PlanDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipoTurismo() {
        return tipoTurismo;
    }

    public void setTipoTurismo(String tipoTurismo) {
        this.tipoTurismo = tipoTurismo;
    }

    public Long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }
}

