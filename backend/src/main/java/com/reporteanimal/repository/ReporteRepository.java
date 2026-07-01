package com.reporteanimal.repository;

import com.reporteanimal.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}