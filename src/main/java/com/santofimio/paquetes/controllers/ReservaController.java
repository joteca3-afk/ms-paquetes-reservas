package com.santofimio.paquetes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santofimio.paquetes.models.Reserva;
import com.santofimio.paquetes.models.dto.ReservaDTO;
import com.santofimio.paquetes.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "2. Reservas", description = "Endpoints para la gestión de solicitudes de viaje y cupos")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    @Operation(summary = "Solicitar una reserva", description = "El turista registra su solicitud aceptando términos y condiciones. Queda en estado PENDIENTE.")
    public ResponseEntity<Reserva> registrarReserva(@RequestBody ReservaDTO dto) {
        Reserva nuevaReserva = reservaService.crearReserva(dto);
        return ResponseEntity.ok(nuevaReserva);
    }

    @GetMapping
    @Operation(summary = "Ver todas las reservas", description = "Uso exclusivo de administración y agencias para auditoría")
    public ResponseEntity<List<Reserva>> listarTodas() {
        return ResponseEntity.ok(reservaService.obtenerTodas());
    }

    @PatchMapping("/{id}/estado")
    @Operation(summary = "Aprobar o Cancelar una reserva", description = "Permite a la agencia cambiar el estado a 'APROBADA' o 'CANCELADA'")
    public ResponseEntity<Reserva> actualizarEstado(
            @PathVariable Long id, 
            @RequestParam String nuevoEstado) {
        Reserva reservaActualizada = reservaService.cambiarEstado(id, nuevoEstado);
        return ResponseEntity.ok(reservaActualizada);
    }
}