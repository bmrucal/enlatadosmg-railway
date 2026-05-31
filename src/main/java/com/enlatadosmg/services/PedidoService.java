package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.structures.ColaPedidos;
import com.enlatadosmg.structures.ListaEnlazadaPedidos;

@Service
public class PedidoService {

    private ColaPedidos colaPedidos;
    private ListaEnlazadaPedidos listaPedidos;

    public PedidoService() {
        colaPedidos = new ColaPedidos();
        listaPedidos = new ListaEnlazadaPedidos();
    }

    public void agregarPedido(Pedido pedido) {
        colaPedidos.encolar(pedido);
        listaPedidos.insertar(pedido);
    }

    public Pedido atenderPedido() {
        return colaPedidos.desencolar();
    }

    public Pedido verSiguiente() {
        return colaPedidos.verFrente();
    }

    public String listarPedidos() {
        return listaPedidos.listarPedidos();
    }

    public Pedido buscarPedido(int numeroPedido) {
        return listaPedidos.buscar(numeroPedido);
    }

    public boolean completarPedido(int numeroPedido) {
        return listaPedidos.completarPedido(numeroPedido);
    }
}