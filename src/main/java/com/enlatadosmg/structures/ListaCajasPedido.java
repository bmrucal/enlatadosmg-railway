package com.enlatadosmg.structures;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.nodes.NodoCaja;

public class ListaCajasPedido {

    private NodoCaja cabeza;

    public ListaCajasPedido() {
        cabeza = null;
    }

    public void insertar(Caja caja) {

        NodoCaja nuevo = new NodoCaja(caja);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoCaja actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    public int contarCajas() {

        int contador = 0;

        NodoCaja actual = cabeza;

        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }

    public String listarCajas() {

        String resultado = "";

        NodoCaja actual = cabeza;

        while (actual != null) {

            resultado += "Caja: "
                    + actual.caja.getCorrelativo()
                    + " Fecha: "
                    + actual.caja.getFechaIngreso()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
    public String generarDot() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("rankdir=LR;\n");
        dot.append("node [shape=box];\n");

        NodoCaja actual = cabeza;

        while (actual != null) {

            dot.append("caja")
               .append(actual.caja.getCorrelativo())
               .append(" [label=\"Caja: ")
               .append(actual.caja.getCorrelativo())
               .append("\\nFecha: ")
               .append(actual.caja.getFechaIngreso())
               .append("\"];\n");

            if (actual.siguiente != null) {
                dot.append("caja")
                   .append(actual.caja.getCorrelativo())
                   .append(" -> caja")
                   .append(actual.siguiente.caja.getCorrelativo())
                   .append(";\n");
            }

            actual = actual.siguiente;
        }

        dot.append("}");

        return dot.toString();
    }
}