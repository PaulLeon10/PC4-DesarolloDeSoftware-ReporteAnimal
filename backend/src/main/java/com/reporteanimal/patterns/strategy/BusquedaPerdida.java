package com.reporteanimal.patterns.strategy;

import com.reporteanimal.model.Mascota;

import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPerdida implements BusquedaStrategy {

    @Override
    public List<Mascota> buscar(List<Mascota> mascotas, String criterio) {

        return mascotas.stream()
                .filter(m -> (m.getNombre() != null
                        && m.getNombre().toLowerCase().contains(criterio.toLowerCase()))
                        || (m.getDescripcion() != null
                        && m.getDescripcion().toLowerCase().contains(criterio.toLowerCase())))
                .collect(Collectors.toList());
    }
}