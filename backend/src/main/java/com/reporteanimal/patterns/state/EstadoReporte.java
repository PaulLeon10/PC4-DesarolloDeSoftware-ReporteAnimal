package com.reporteanimal.patterns.state;

import com.reporteanimal.model.Reporte;

public interface EstadoReporte {

    void siguiente(Reporte reporte);

    String nombre();
}