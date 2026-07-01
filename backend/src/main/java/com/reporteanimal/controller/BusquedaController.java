package com.reporteanimal.controller;

import com.reporteanimal.enums.IntencionBusqueda;
import com.reporteanimal.model.Mascota;
import com.reporteanimal.patterns.facade.SistemaMascotasFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busqueda")
public class BusquedaController {

    private final SistemaMascotasFacade facade;

    public BusquedaController(SistemaMascotasFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/mascotas")
    public List<Mascota> buscar(
            @RequestParam IntencionBusqueda intencion,
            @RequestBody List<Mascota> mascotas,
            @RequestParam String criterio
    ) {
        return facade.buscarMascotas(intencion, mascotas, criterio);
    }
}