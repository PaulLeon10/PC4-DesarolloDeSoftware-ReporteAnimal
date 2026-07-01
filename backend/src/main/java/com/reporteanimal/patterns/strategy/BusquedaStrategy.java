package com.reporteanimal.patterns.strategy;

import com.reporteanimal.model.Mascota;

import java.util.List;

public interface BusquedaStrategy {

    List<Mascota> buscar(List<Mascota> mascotas, String criterio);
}