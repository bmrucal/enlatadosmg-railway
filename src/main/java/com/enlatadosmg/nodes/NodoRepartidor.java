package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Repartidor;

public class NodoRepartidor {

    public Repartidor repartidor;

    public NodoRepartidor siguiente;

    public NodoRepartidor(Repartidor repartidor) {

        this.repartidor = repartidor;

        this.siguiente = null;
    }
}