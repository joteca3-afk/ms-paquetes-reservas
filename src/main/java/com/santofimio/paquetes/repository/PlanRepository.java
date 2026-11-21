package com.santofimio.paquetes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santofimio.paquetes.models.PlanTuristico;

@Repository
public interface PlanRepository extends JpaRepository<PlanTuristico, Long> {
    
    // Consulta automática generada por Spring para buscar por municipio ignorando mayúsculas/minúsculas
    List<PlanTuristico> findByMunicipioIgnoreCase(String municipio);
    
}