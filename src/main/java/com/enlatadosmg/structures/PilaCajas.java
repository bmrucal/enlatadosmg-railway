package com.enlatadosmg.structures;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.nodes.NodoCaja;

public class PilaCajas {

    private NodoCaja cima;

    public PilaCajas() {
        this.cima = null;
    }

    // PUSH
    public void push(Caja caja) {

        NodoCaja nuevo = new NodoCaja(caja);

        nuevo.siguiente = cima;

        cima = nuevo;
    }

    // POP
    public Caja pop() {

        if (cima == null) {
            return null;
        }

        Caja caja = cima.caja;

        cima = cima.siguiente;

        return caja;
    }

    // VER CIMA
    public Caja verCima() {

        if (cima == null) {
            return null;
        }

        return cima.caja;
    }

    // VALIDAR VACIA
    public boolean estaVacia() {
        return cima == null;
    }
}
