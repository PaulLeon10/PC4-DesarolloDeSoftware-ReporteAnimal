package com.reporteanimal.patterns.state;

import com.reporteanimal.model.Reporte;

public class EstadoAvistado implements EstadoReporte {

    @Override
    public void siguiente(Reporte reporte) {
        reporte.setEstadoActual(new EstadoResuelto());
    }

    @Override
    public String nombre() {
        return "AVISTADO";
    }
}