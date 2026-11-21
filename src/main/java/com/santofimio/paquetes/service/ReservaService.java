package com.santofimio.paquetes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santofimio.paquetes.models.Reserva;
import com.santofimio.paquetes.models.dto.ReservaDTO;
import com.santofimio.paquetes.repository.PlanRepository;
import com.santofimio.paquetes.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PlanRepository planRepository;

    public Reserva crearReserva(ReservaDTO dto) {
        if (dto.getAceptaTerminos() == null || !dto.getAceptaTerminos()) {
            throw new IllegalArgumentException("Es obligatorio aceptar los términos y condiciones (Ley 1581).");
        }

        if (!planRepository.existsById(dto.getPlanId())) {
            throw new IllegalArgumentException("El paquete turístico seleccionado no existe.");
        }

        Reserva reserva = new Reserva();
        reserva.setPlanId(dto.getPlanId());
        reserva.setNombreTurista(dto.getNombreTurista());
        reserva.setDocumentoTurista(dto.getDocumentoTurista());
        reserva.setCorreoTurista(dto.getCorreoTurista());
        reserva.setCantidadPersonas(dto.getCantidadPersonas());
        reserva.setEstado("PENDIENTE");
        reserva.setAceptoTerminosAt(LocalDateTime.now());

        return reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Reserva cambiarEstado(Long id, String nuevoEstado) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada con ID: " + id));
        
        reserva.setEstado(nuevoEstado.toUpperCase());
        return reservaRepository.save(reserva);
    }
}
