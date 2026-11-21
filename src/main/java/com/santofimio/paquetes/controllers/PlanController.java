package com.santofimio.paquetes.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santofimio.paquetes.models.PlanTuristico;
import com.santofimio.paquetes.models.dto.PlanDTO;
import com.santofimio.paquetes.service.PlanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/paquetes")
@Tag(name = "1. Paquetes Turísticos", description = "Endpoints para la gestión de planes turísticos en el Huila")
public class PlanController {

    private final PlanService planService;

    // Constructor para inicializar planService correctamente
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo plan turístico", description = "Las agencias locales registran sus paquetes de viaje (Aventura, Ecológico, etc.)")
    public ResponseEntity<PlanTuristico> crearPlan(@RequestBody PlanDTO dto) {
        PlanTuristico nuevoPlan = planService.guardarPlan(dto);
        return ResponseEntity.ok(nuevoPlan);
    }

    @GetMapping
    @Operation(summary = "Listar todos los planes", description = "Devuelve el catálogo completo de experiencias turísticas disponibles")
    public ResponseEntity<List<PlanTuristico>> listarTodos() {
        return ResponseEntity.ok(planService.obtenerTodos());
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar planes por municipio", description = "Permite filtrar los planes del Huila según el municipio seleccionado")
    public ResponseEntity<List<PlanTuristico>> buscarPorMunicipio(@RequestParam String municipio) {
        return ResponseEntity.ok(planService.buscarPorMunicipio(municipio));
    }
}