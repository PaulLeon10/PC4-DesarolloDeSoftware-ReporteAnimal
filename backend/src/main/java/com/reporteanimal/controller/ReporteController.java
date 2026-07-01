package com.reporteanimal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reporteanimal.model.Reporte;
import com.reporteanimal.patterns.facade.SistemaMascotasFacade;
import com.reporteanimal.patterns.template.ProcesadorReporte;
import com.reporteanimal.patterns.template.ReporteAnonimo;
import com.reporteanimal.patterns.template.ReporteTitular;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final SistemaMascotasFacade facade;
    private final ReporteAnonimo reporteAnonimo;
    private final ReporteTitular reporteTitular;

    public ReporteController(
            SistemaMascotasFacade facade,
            ReporteAnonimo reporteAnonimo,
            ReporteTitular reporteTitular
    ) {
        this.facade = facade;
        this.reporteAnonimo = reporteAnonimo;
        this.reporteTitular = reporteTitular;
    }

    @PostMapping("/registrar")
    public Reporte registrar(
            @RequestBody Reporte reporte,
            @RequestParam String tipo
    ) {

        ProcesadorReporte procesador =
                tipo.equals("anonimo")
                        ? reporteAnonimo
                        : reporteTitular;

        return facade.registrarReporte(procesador, reporte);
    }
}