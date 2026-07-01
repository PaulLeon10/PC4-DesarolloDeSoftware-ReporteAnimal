package com.reporteanimal.model;

import com.reporteanimal.patterns.state.EstadoActivo;
import com.reporteanimal.patterns.state.EstadoReporte;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mascota mascota;

    @Embedded
    private Ubicacion ubicacion;

    private LocalDateTime fecha;

    private boolean anonimo;

    @Transient
    private EstadoReporte estadoActual = new EstadoActivo();

    public Reporte() {
        this.fecha = LocalDateTime.now();
    }

    public Reporte(Mascota mascota, Ubicacion ubicacion, boolean anonimo) {
        this.mascota = mascota;
        this.ubicacion = ubicacion;
        this.anonimo = anonimo;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    // Patron state

    public void siguienteEstado() {
        estadoActual.siguiente(this);
    }

    public String getEstado() {
        return estadoActual.nombre();
    }

    public void setEstadoActual(EstadoReporte estadoActual) {
        this.estadoActual = estadoActual;
    }
}