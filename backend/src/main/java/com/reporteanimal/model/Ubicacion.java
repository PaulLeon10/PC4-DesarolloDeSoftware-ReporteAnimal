package com.reporteanimal.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ubicacion {

    private double latitud;
    private double longitud;

    public Ubicacion() {
    }

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * Calcula distancia entre dos puntos usando Haversine
     */
    public double calcularDistanciaKm(Ubicacion otra) {

        final double RADIO_TIERRA = 6371.0;

        double lat1 = Math.toRadians(this.latitud);
        double lon1 = Math.toRadians(this.longitud);

        double lat2 = Math.toRadians(otra.latitud);
        double lon2 = Math.toRadians(otra.longitud);

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(deltaLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIO_TIERRA * c;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}