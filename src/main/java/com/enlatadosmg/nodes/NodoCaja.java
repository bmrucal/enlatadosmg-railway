package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Caja;

public class NodoCaja {

    public Caja caja;
    public NodoCaja siguiente;

    public NodoCaja(Caja caja) {
        this.caja = caja;
        this.siguiente = null;
    }
}