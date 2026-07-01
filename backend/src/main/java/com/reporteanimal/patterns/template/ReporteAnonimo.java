package com.reporteanimal.patterns.template;

import com.reporteanimal.model.Reporte;
import com.reporteanimal.patterns.observer.SistemaAlertas;
import com.reporteanimal.patterns.state.EstadoActivo;
import com.reporteanimal.repository.ReporteRepository;

import org.springframework.stereotype.Component;

@Component
public class ReporteAnonimo extends ProcesadorReporte {

    private final ReporteRepository reporteRepository;
    private final SistemaAlertas sistemaAlertas;

    public ReporteAnonimo(ReporteRepository reporteRepository, SistemaAlertas sistemaAlertas) {
        this.reporteRepository = reporteRepository;
        this.sistemaAlertas = sistemaAlertas;
    }


    @Override
    protected void validar(Reporte reporte) {

    if (reporte.getUbicacion() == null) {
        throw new IllegalArgumentException("Ubicación obligatoria");
    }

    double lat = reporte.getUbicacion().getLatitud();
    double lon = reporte.getUbicacion().getLongitud();

    if (lat == 0.0 && lon == 0.0) {
        throw new IllegalArgumentException("Ubicación inválida: coordenadas no pueden ser (0,0)");
    }

    if (lat < -90 || lat > 90) {
        throw new IllegalArgumentException("Latitud fuera de rango");
    }

    if (lon < -180 || lon > 180) {
        throw new IllegalArgumentException("Longitud fuera de rango");
    }
}
    @Override
    protected void asignarEstadoInicial(Reporte reporte) {
        reporte.setEstadoActual(new EstadoActivo());
    }

    @Override
    protected void persistir(Reporte reporte) {
        reporte.setAnonimo(true);
        reporteRepository.save(reporte);
    }

    @Override
    protected void notificar(Reporte reporte) {
        sistemaAlertas.notificar("Avistamiento anónimo registrado");
    }
}