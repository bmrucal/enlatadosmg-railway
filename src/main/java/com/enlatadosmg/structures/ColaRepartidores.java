package com.enlatadosmg.structures;

import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.nodes.NodoRepartidor;

public class ColaRepartidores {

    private NodoRepartidor frente;
    private NodoRepartidor fin;

    public ColaRepartidores() {
        frente = null;
        fin = null;
    }

    public void encolar(Repartidor repartidor) {

        NodoRepartidor nuevo = new NodoRepartidor(repartidor);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            return;
        }

        fin.siguiente = nuevo;
        fin = nuevo;
    }

    public Repartidor desencolar() {

        if (frente == null) {
            return null;
        }

        Repartidor repartidor = frente.repartidor;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return repartidor;
    }

    public Repartidor verFrente() {

        if (frente == null) {
            return null;
        }

        return frente.repartidor;
    }

    public Repartidor buscar(String cui) {

        NodoRepartidor actual = frente;

        while (actual != null) {

            if (actual.repartidor.getCui().equals(cui)) {
                return actual.repartidor;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public boolean actualizar(String cui, Repartidor nuevoRepartidor) {

        NodoRepartidor actual = frente;

        while (actual != null) {

            if (actual.repartidor.getCui().equals(cui)) {
                actual.repartidor.setNombre(nuevoRepartidor.getNombre());
                actual.repartidor.setApellidos(nuevoRepartidor.getApellidos());
                actual.repartidor.setLicencia(nuevoRepartidor.getLicencia());
                actual.repartidor.setTelefono(nuevoRepartidor.getTelefono());
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean eliminar(String cui) {

        if (frente == null) {
            return false;
        }

        if (frente.repartidor.getCui().equals(cui)) {
            frente = frente.siguiente;

            if (frente == null) {
                fin = null;
            }

            return true;
        }

        NodoRepartidor actual = frente;

        while (actual.siguiente != null) {

            if (actual.siguiente.repartidor.getCui().equals(cui)) {

                if (actual.siguiente == fin) {
                    fin = actual;
                }

                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public String listarRepartidores() {

        if (frente == null) {
            return "";
        }

        String resultado = "";
        NodoRepartidor actual = frente;

        while (actual != null) {

            resultado += "CUI: "
                    + actual.repartidor.getCui()
                    + " Nombre: "
                    + actual.repartidor.getNombre()
                    + " "
                    + actual.repartidor.getApellidos()
                    + " Licencia: "
                    + actual.repartidor.getLicencia()
                    + " Teléfono: "
                    + actual.repartidor.getTelefono()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
    public String generarDot() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("node [shape=box];\n");
        dot.append("rankdir=LR;\n");

        NodoRepartidor actual = frente;

        while (actual != null) {

            dot.append("repartidor")
                    .append(actual.repartidor.getCui())
                    .append(" [label=\"CUI: ")
                    .append(actual.repartidor.getCui())
                    .append("\\nNombre: ")
                    .append(actual.repartidor.getNombre())
                    .append(" ")
                    .append(actual.repartidor.getApellidos())
                    .append("\\nLicencia: ")
                    .append(actual.repartidor.getLicencia())
                    .append("\\nTeléfono: ")
                    .append(actual.repartidor.getTelefono())
                    .append("\"];\n");

            if (actual.siguiente != null) {
                dot.append("repartidor")
                        .append(actual.repartidor.getCui())
                        .append(" -> repartidor")
                        .append(actual.siguiente.repartidor.getCui())
                        .append(";\n");
            }

            actual = actual.siguiente;
        }

        dot.append("}");

        return dot.toString();
    }
}