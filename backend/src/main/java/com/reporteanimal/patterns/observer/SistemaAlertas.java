package com.reporteanimal.patterns.observer;

import com.reporteanimal.model.Ubicacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SistemaAlertas implements AlertaObservable {

    private final List<UsuarioObserver> observers = new ArrayList<>();

    private final Ubicacion origen;
    private final double radioKm = 1.0;

    public SistemaAlertas() {
        this.origen = new Ubicacion(-12.0464, -77.0428); // Lima default
    }

    @Override
    public void agregarObserver(UsuarioObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(UsuarioObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificar(String mensaje) {
        for (UsuarioObserver o : observers) {
            double distancia = origen.calcularDistanciaKm(o.getUbicacion());
            if (distancia <= radioKm) {
                o.recibirAlerta(mensaje);
            }
        }
    }
}