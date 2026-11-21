package com.santofimio.paquetes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santofimio.paquetes.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Consulta automática para filtrar reservas por su estado (PENDIENTE, APROBADA, CANCELADA)
    List<Reserva> findByEstado(String estado);
    
}