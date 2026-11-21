package com.santofimio.paquetes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santofimio.paquetes.models.PlanTuristico;
import com.santofimio.paquetes.models.dto.PlanDTO;
import com.santofimio.paquetes.repository.PlanRepository;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public PlanTuristico guardarPlan(PlanDTO dto) {
        PlanTuristico plan = new PlanTuristico();
        plan.setNombre(dto.getNombre());
        plan.setDescripcion(dto.getDescription());
        plan.setMunicipio(dto.getMunicipio());
        plan.setPrecioBase(dto.getPrecioBase());
        plan.setDuracion(dto.getDuracion());
        plan.setTipoTurismo(dto.getTipoTurismo());
        plan.setIdAgencia(dto.getIdAgencia());

        return planRepository.save(plan);
    }

    public List<PlanTuristico> obtenerTodos() {
        return planRepository.findAll();
    }

    public List<PlanTuristico> buscarPorMunicipio(String municipio) {
        return planRepository.findByMunicipioIgnoreCase(municipio);
    }
}
