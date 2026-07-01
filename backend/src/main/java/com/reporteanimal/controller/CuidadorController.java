package com.reporteanimal.controller;

import com.reporteanimal.model.Usuario;
import com.reporteanimal.patterns.facade.SistemaMascotasFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CuidadorController {

    private final SistemaMascotasFacade facade;

    public CuidadorController(SistemaMascotasFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<Usuario> listar() {
        return facade.listarUsuarios();
    }
}