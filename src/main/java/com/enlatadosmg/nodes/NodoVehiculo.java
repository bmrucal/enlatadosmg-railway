package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Vehiculo;

public class NodoVehiculo {

    public Vehiculo vehiculo;
    public NodoVehiculo siguiente;

    public NodoVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.siguiente = null;
    }
}