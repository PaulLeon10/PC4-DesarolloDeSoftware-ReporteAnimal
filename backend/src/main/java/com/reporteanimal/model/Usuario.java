package com.reporteanimal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String documentoIdentidad;

    // dueño, cuidador, ciudadano
    private String rol;

    // Observer: decide si recibir alertas o no
    private boolean alertasActivas;

    private double calificacion;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String documentoIdentidad, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.rol = rol;
        this.alertasActivas = false;
        this.calificacion = 0.0;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getRol() {
        return rol;
    }

    public boolean isAlertasActivas() {
        return alertasActivas;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setAlertasActivas(boolean alertasActivas) {
        this.alertasActivas = alertasActivas;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}