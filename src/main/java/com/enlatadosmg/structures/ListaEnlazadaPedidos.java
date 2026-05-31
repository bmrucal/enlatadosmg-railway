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
        if (cabeza == null) {
            return "";
        }

        String resultado = "";
        NodoPedido actual = cabeza;

        while (actual != null) {
            resultado += "Pedido: "
                    + actual.pedido.getNumeroPedido()
                    + " Estado: "
                    + actual.pedido.getEstado()
                    + " Origen: "
                    + actual.pedido.getOrigen()
                    + " Destino: "
                    + actual.pedido.getDestino()
                    + " Cajas: "
                    + actual.pedido.getNumeroCajas()
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

    public String generarDot() {
        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("node [shape=box];\n");
        dot.append("rankdir=LR;\n");

        NodoPedido actual = cabeza;

        while (actual != null) {
            dot.append("pedido")
                    .append(actual.pedido.getNumeroPedido())
                    .append(" [label=\"Pedido: ")
                    .append(actual.pedido.getNumeroPedido())
                    .append("\\nEstado: ")
                    .append(actual.pedido.getEstado())
                    .append("\\nDestino: ")
                    .append(actual.pedido.getDestino())
                    .append("\\nCajas: ")
                    .append(actual.pedido.getNumeroCajas())
                    .append("\"];\n");

            if (actual.siguiente != null) {
                dot.append("pedido")
                        .append(actual.pedido.getNumeroPedido())
                        .append(" -> pedido")
                        .append(actual.siguiente.pedido.getNumeroPedido())
                        .append(";\n");
            }

            actual = actual.siguiente;
        }

        dot.append("}");

        return dot.toString();
    }
}