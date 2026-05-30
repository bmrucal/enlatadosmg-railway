package com.enlatadosmg.structures;

import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.nodes.NodoPedido;

public class ListaEnlazadaPedidos {

    private NodoPedido cabeza;

    public ListaEnlazadaPedidos() {
        cabeza = null;
    }

    public void insertar(Pedido pedido) {

        NodoPedido nuevo = new NodoPedido(pedido);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoPedido actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    public Pedido buscar(int numeroPedido) {

        NodoPedido actual = cabeza;

        while (actual != null) {

            if (actual.pedido.getNumeroPedido() == numeroPedido) {
                return actual.pedido;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public String listarPedidos() {

        String resultado = "";

        NodoPedido actual = cabeza;

        while (actual != null) {

            resultado += "Pedido: "
                    + actual.pedido.getNumeroPedido()
                    + " Estado: "
                    + actual.pedido.getEstado()
                    + " Destino: "
                    + actual.pedido.getDestino()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }

    public boolean completarPedido(int numeroPedido) {

        Pedido pedido = buscar(numeroPedido);

        if (pedido == null) {
            return false;
        }

        pedido.setEstado("Completado");

        return true;
    }
}