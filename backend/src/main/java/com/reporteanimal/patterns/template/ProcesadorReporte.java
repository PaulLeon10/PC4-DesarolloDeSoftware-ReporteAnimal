package com.reporteanimal.patterns.template;

import com.reporteanimal.model.Reporte;

public abstract class ProcesadorReporte {

    public final void procesar(Reporte reporte) {
        validar(reporte);
        asignarEstadoInicial(reporte);
        persistir(reporte);
        notificar(reporte);
    }

    protected abstract void validar(Reporte reporte);

    protected abstract void asignarEstadoInicial(Reporte reporte);

    protected abstract void persistir(Reporte reporte);

    protected abstract void notificar(Reporte reporte);
}