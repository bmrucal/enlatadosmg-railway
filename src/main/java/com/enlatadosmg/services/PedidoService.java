package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.structures.ColaPedidos;

@Service
public class PedidoService {

    private ColaPedidos colaPedidos;

    public PedidoService() {
        colaPedidos = new ColaPedidos();
    }

    public void agregarPedido(Pedido pedido) {
        colaPedidos.encolar(pedido);
    }

    public Pedido atenderPedido() {
        return colaPedidos.desencolar();
    }

    public Pedido verSiguiente() {
        return colaPedidos.verFrente();
    }
}