package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Pedido;

public class NodoPedido {

    public Pedido pedido;

    public NodoPedido siguiente;

    public NodoPedido(Pedido pedido) {

        this.pedido = pedido;

        this.siguiente = null;
    }
}