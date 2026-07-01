package com.reporteanimal.patterns.observer;

import com.reporteanimal.model.Ubicacion;

public interface UsuarioObserver {

    Ubicacion getUbicacion();

    void recibirAlerta(String mensaje);
}