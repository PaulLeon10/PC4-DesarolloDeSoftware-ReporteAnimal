package com.reporteanimal.patterns.strategy;

import com.reporteanimal.enums.Especie;
import com.reporteanimal.model.Mascota;
import com.reporteanimal.patterns.builder.MascotaBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaStrategyTest {

    @Test
    void filtroVentaPorRaza() {

        BusquedaStrategy strategy = new BusquedaVenta();

        Mascota husky = new MascotaBuilder()
                .nombre("Luna")
                .especie(Especie.PERRO)
                .raza("Husky")
                .foto("")
                .descripcion("")
                .build();

        Mascota persa = new MascotaBuilder()
                .nombre("Milo")
                .especie(Especie.GATO)
                .raza("Persa")
                .foto("")
                .descripcion("")
                .build();

        List<Mascota> mascotas = List.of(husky, persa);

        List<Mascota> result = strategy.buscar(mascotas, "husky");

        assertEquals(1, result.size());
        assertEquals("Luna", result.get(0).getNombre());
    }

    @Test
    void filtroPerdidaPorNombre() {

        BusquedaStrategy strategy = new BusquedaPerdida();

        Mascota m1 = new MascotaBuilder()
                .nombre("Rocky")
                .especie(Especie.PERRO)
                .raza("Labrador")
                .foto("")
                .descripcion("se perdió en parque")
                .build();

        Mascota m2 = new MascotaBuilder()
                .nombre("Milo")
                .especie(Especie.GATO)
                .raza("Persa")
                .foto("")
                .descripcion("")
                .build();

        List<Mascota> mascotas = List.of(m1, m2);

        List<Mascota> result = strategy.buscar(mascotas, "rocky");

        assertEquals(1, result.size());
        assertEquals("Rocky", result.get(0).getNombre());
    }
}