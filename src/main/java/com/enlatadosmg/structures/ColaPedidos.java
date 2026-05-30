package com.enlatadosmg.structures;

import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.nodes.NodoPedido;

public class ColaPedidos {

    private NodoPedido frente;
    private NodoPedido fin;

    public ColaPedidos() {
        this.frente = null;
        this.fin = null;
    }

    // AGREGAR A LA COLA
    public void encolar(Pedido pedido) {

        NodoPedido nuevo = new NodoPedido(pedido);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            return;
        }

        fin.siguiente = nuevo;
        fin = nuevo;
    }

    // SACAR DE LA COLA
    public Pedido desencolar() {

        if (frente == null) {
            return null;
        }

        Pedido pedido = frente.pedido;

        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return pedido;
    }

    // VER PRIMERO
    public Pedido verFrente() {

        if (frente == null) {
            return null;
        }

        return frente.pedido;
    }

    // VALIDAR VACÍA
    public boolean estaVacia() {
        return frente == null;
    }
}
