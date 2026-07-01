package com.reporteanimal.patterns.strategy;

import com.reporteanimal.model.Mascota;

import java.util.List;
import java.util.stream.Collectors;

public class BusquedaVenta implements BusquedaStrategy {

    @Override
    public List<Mascota> buscar(List<Mascota> mascotas, String criterio) {

        return mascotas.stream()
                .filter(m -> m.getRaza() != null
                        && m.getRaza().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
    }
}