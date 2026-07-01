package com.reporteanimal.patterns.template;

import com.reporteanimal.model.Mascota;
import com.reporteanimal.model.Reporte;
import com.reporteanimal.model.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorReporteTemplateTest {

    static class ProcesadorMock extends ProcesadorReporte {

        boolean validado = false;
        boolean persistido = false;
        boolean notificado = false;

        @Override
        protected void validar(Reporte reporte) {
            validado = true;
        }

        @Override
        protected void asignarEstadoInicial(Reporte reporte) {}

        @Override
        protected void persistir(Reporte reporte) {
            persistido = true;
        }

        @Override
        protected void notificar(Reporte reporte) {
            notificado = true;
        }
    }

    @Test
    void debeEjecutarFlujoCompletoTemplate() {

        ProcesadorMock procesador = new ProcesadorMock();

        Reporte reporte = new Reporte(
                new Mascota(),
                new Ubicacion(-12.04, -77.03),
                false
        );

        procesador.procesar(reporte);

        assertTrue(procesador.validado);
        assertTrue(procesador.persistido);
        assertTrue(procesador.notificado);
    }
}