package com.enlatadosmg.structures;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.nodes.NodoCaja;

public class PilaCajas {

    private NodoCaja cima;
    private int tamanio;

    public PilaCajas() {
        this.cima = null;
        this.tamanio = 0;
    }

    public void push(Caja caja) {
        NodoCaja nuevo = new NodoCaja(caja);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    public Caja pop() {
        if (cima == null) {
            return null;
        }

        Caja caja = cima.caja;
        cima = cima.siguiente;
        tamanio--;

        return caja;
    }

    public Caja verCima() {
        if (cima == null) {
            return null;
        }

        return cima.caja;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String listarCajas() {
        if (cima == null) {
            return "";
        }

        String resultado = "";
        NodoCaja actual = cima;

        while (actual != null) {
            resultado += "Caja: "
                    + actual.caja.getCorrelativo()
                    + " Fecha ingreso: "
                    + actual.caja.getFechaIngreso()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
    public String generarDot() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("node [shape=box];\n");
        dot.append("rankdir=TB;\n");

        NodoCaja actual = cima;

        while (actual != null) {

            dot.append("caja")
                    .append(actual.caja.getCorrelativo())
                    .append(" [label=\"Caja: ")
                    .append(actual.caja.getCorrelativo())
                    .append("\\nFecha ingreso: ")
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
