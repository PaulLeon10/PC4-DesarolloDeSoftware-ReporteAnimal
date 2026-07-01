package com.reporteanimal.patterns.factory;

import com.reporteanimal.enums.IntencionBusqueda;
import com.reporteanimal.patterns.strategy.*;

public class IntencionBusquedaFactory {

    public static BusquedaStrategy crear(IntencionBusqueda intencion) {

        return switch (intencion) {

            case ADOPCION -> new BusquedaAdopcion();

            case VENTA -> new BusquedaVenta();

            case VERIFICAR_PERDIDA -> new BusquedaPerdida();
        };
    }
}