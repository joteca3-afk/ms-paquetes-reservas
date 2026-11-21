package com.santofimio.paquetes.models.dto;

public class ReservaDTO {

    private Long planId;
    private String nombreTurista;
    private String documentoTurista;
    private String correoTurista;
    private Integer cantidadPersonas;
    private Boolean aceptaTerminos; // Requisito legal de tu SRS (Ley 1581)

    public ReservaDTO() {
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getNombreTurista() {
        return nombreTurista;
    }

    public void setNombreTurista(String nombreTurista) {
        this.nombreTurista = nombreTurista;
    }

    public String getDocumentoTurista() {
        return documentoTurista;
    }

    public void setDocumentoTurista(String documentoTurista) {
        this.documentoTurista = documentoTurista;
    }

    public String getCorreoTurista() {
        return correoTurista;
    }

    public void setCorreoTurista(String correoTurista) {
        this.correoTurista = correoTurista;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Boolean getAceptaTerminos() {
        return aceptaTerminos;
    }

    public void setAceptaTerminos(Boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }
}

