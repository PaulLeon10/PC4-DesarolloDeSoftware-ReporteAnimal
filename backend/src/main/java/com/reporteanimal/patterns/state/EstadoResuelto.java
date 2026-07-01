package com.reporteanimal.patterns.state;

import com.reporteanimal.model.Reporte;

public class EstadoResuelto implements EstadoReporte {

    @Override
    public void siguiente(Reporte reporte) {
    }

    @Override
    public String nombre() {
        return "RESUELTO";
    }
}