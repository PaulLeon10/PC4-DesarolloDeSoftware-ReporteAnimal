package com.reporteanimal.patterns.state;

import com.reporteanimal.model.Reporte;

public class EstadoActivo implements EstadoReporte {

    @Override
    public void siguiente(Reporte reporte) {
        reporte.setEstadoActual(new EstadoAvistado());
    }

    @Override
    public String nombre() {
        return "ACTIVO";
    }
}