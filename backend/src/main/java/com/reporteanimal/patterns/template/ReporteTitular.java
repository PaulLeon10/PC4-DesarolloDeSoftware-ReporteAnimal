package com.reporteanimal.patterns.template;

import com.reporteanimal.model.Reporte;
import com.reporteanimal.patterns.observer.SistemaAlertas;
import com.reporteanimal.patterns.state.EstadoActivo;
import com.reporteanimal.repository.ReporteRepository;
import org.springframework.stereotype.Component;

@Component
public class ReporteTitular extends ProcesadorReporte {

    private final ReporteRepository reporteRepository;
    private final SistemaAlertas sistemaAlertas;

    public ReporteTitular(ReporteRepository reporteRepository, SistemaAlertas sistemaAlertas) {
        this.reporteRepository = reporteRepository;
        this.sistemaAlertas = sistemaAlertas;
    }

    @Override
    protected void validar(Reporte reporte) {
        if (reporte.getMascota() == null || reporte.getUbicacion() == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected void asignarEstadoInicial(Reporte reporte) {
        reporte.setEstadoActual(new EstadoActivo());
    }

    @Override
    protected void persistir(Reporte reporte) {
        reporteRepository.save(reporte);
    }

    @Override
    protected void notificar(Reporte reporte) {
        sistemaAlertas.notificar(
                "Nueva mascota perdida reportada: " +
                reporte.getMascota().getNombre()
        );
    }
}