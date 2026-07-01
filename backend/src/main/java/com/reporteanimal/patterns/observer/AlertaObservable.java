package com.reporteanimal.patterns.observer;

public interface AlertaObservable {

    void agregarObserver(UsuarioObserver observer);

    void removerObserver(UsuarioObserver observer);

    void notificar(String mensaje);
}