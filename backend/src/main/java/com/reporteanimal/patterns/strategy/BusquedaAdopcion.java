package com.reporteanimal.patterns.strategy;

import com.reporteanimal.model.Mascota;

import java.util.List;

public class BusquedaAdopcion implements BusquedaStrategy {

    @Override
    public List<Mascota> buscar(List<Mascota> mascotas, String criterio) {
        return mascotas;
    }
}