package com.reporteanimal.patterns.adapter;

public class ImagenMetadata {

    private String etiqueta;
    private String descripcion;

    public ImagenMetadata(String etiqueta, String descripcion) {
        this.etiqueta = etiqueta;
        this.descripcion = descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }
}