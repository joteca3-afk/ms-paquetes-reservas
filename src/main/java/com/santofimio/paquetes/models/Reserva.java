package com.santofimio.paquetes.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_id", nullable = false)
    private Long planId;

    @Column(name = "nombre_turista", nullable = false, length = 100)
    private String nombreTurista;

    @Column(name = "documento_turista", nullable = false, length = 30)
    private String documentoTurista;

    @Column(name = "correo_turista", nullable = false, length = 100)
    private String correoTurista;

    @Column(name = "cantidad_personas", nullable = false)
    private Integer cantidadPersonas;

    @Column(nullable = false, length = 30)
    private String estado; // PENDIENTE, APROBADA, CANCELADA

    @Column(name = "acepto_terminos_at", nullable = false)
    private LocalDateTime aceptoTerminosAt; // Para la Ley 1581 de Datos Personales (Habeas Data)

    // Constructor vacío obligatorio para JPA
    public Reserva() {
    }

    // Getters y Setters tradicionales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getAceptoTerminosAt() {
        return aceptoTerminosAt;
    }

    public void setAceptoTerminosAt(LocalDateTime aceptoTerminosAt) {
        this.aceptoTerminosAt = aceptoTerminosAt;
    }
}
