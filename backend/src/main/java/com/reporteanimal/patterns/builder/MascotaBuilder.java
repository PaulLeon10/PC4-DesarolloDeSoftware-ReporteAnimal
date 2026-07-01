package com.reporteanimal.patterns.builder;

import com.reporteanimal.enums.Especie;
import com.reporteanimal.model.Mascota;

public class MascotaBuilder {

    private String nombre;
    private Especie especie;
    private String raza;
    private String foto;
    private String descripcion;

    public MascotaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public MascotaBuilder especie(Especie especie) {
        this.especie = especie;
        return this;
    }

    public MascotaBuilder raza(String raza) {
        this.raza = raza;
        return this;
    }

    public MascotaBuilder foto(String foto) {
        this.foto = foto;
        return this;
    }

    public MascotaBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Mascota build() {
        Mascota m = new Mascota();
        m.setNombre(nombre);
        m.setEspecie(especie);
        m.setRaza(raza);
        m.setFoto(foto);
        m.setDescripcion(descripcion);
        return m;
    }
}