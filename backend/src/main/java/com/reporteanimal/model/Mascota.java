package com.reporteanimal.model;

import com.reporteanimal.enums.Especie;
import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    private String raza;

    private String foto;

    @Column(length = 500)
    private String descripcion;

    public Mascota() {}

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Especie getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public String getFoto() { return foto; }
    public String getDescripcion() { return descripcion; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecie(Especie especie) { this.especie = especie; }
    public void setRaza(String raza) { this.raza = raza; }
    public void setFoto(String foto) { this.foto = foto; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}