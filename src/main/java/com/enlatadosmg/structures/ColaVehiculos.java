package com.enlatadosmg.structures;

import com.enlatadosmg.models.Vehiculo;
import com.enlatadosmg.nodes.NodoVehiculo;

public class ColaVehiculos {

    private NodoVehiculo frente;
    private NodoVehiculo fin;

    public ColaVehiculos() {
        frente = null;
        fin = null;
    }

    public void encolar(Vehiculo vehiculo) {
        NodoVehiculo nuevo = new NodoVehiculo(vehiculo);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            return;
        }

        fin.siguiente = nuevo;
        fin = nuevo;
    }

    public Vehiculo desencolar() {
        if (frente == null) {
            return null;
        }

        Vehiculo vehiculo = frente.vehiculo;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return vehiculo;
    }

    public Vehiculo verFrente() {
        if (frente == null) {
            return null;
        }

        return frente.vehiculo;
    }

    public Vehiculo buscar(String placa) {
        NodoVehiculo actual = frente;

        while (actual != null) {
            if (actual.vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return actual.vehiculo;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public boolean actualizar(String placa, Vehiculo nuevoVehiculo) {
        NodoVehiculo actual = frente;

        while (actual != null) {
            if (actual.vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                actual.vehiculo.setMarca(nuevoVehiculo.getMarca());
                actual.vehiculo.setModelo(nuevoVehiculo.getModelo());
                actual.vehiculo.setColor(nuevoVehiculo.getColor());
                actual.vehiculo.setAnio(nuevoVehiculo.getAnio());
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean eliminar(String placa) {
        if (frente == null) {
            return false;
        }

        if (frente.vehiculo.getPlaca().equalsIgnoreCase(placa)) {
            frente = frente.siguiente;

            if (frente == null) {
                fin = null;
            }

            return true;
        }

        NodoVehiculo actual = frente;

        while (actual.siguiente != null) {
            if (actual.siguiente.vehiculo.getPlaca().equalsIgnoreCase(placa)) {
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

    public String listarVehiculos() {
        if (frente == null) {
            return "";
        }

        String resultado = "";
        NodoVehiculo actual = frente;

        while (actual != null) {
            resultado += "Placa: "
                    + actual.vehiculo.getPlaca()
                    + " Marca: "
                    + actual.vehiculo.getMarca()
                    + " Modelo: "
                    + actual.vehiculo.getModelo()
                    + " Color: "
                    + actual.vehiculo.getColor()
                    + " Año: "
                    + actual.vehiculo.getAnio()
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

        NodoVehiculo actual = frente;

        while (actual != null) {

            dot.append("vehiculo")
                    .append(actual.vehiculo.getPlaca().replace("-", "_"))
                    .append(" [label=\"Placa: ")
                    .append(actual.vehiculo.getPlaca())
                    .append("\\nMarca: ")
                    .append(actual.vehiculo.getMarca())
                    .append("\\nModelo: ")
                    .append(actual.vehiculo.getModelo())
                    .append("\\nColor: ")
                    .append(actual.vehiculo.getColor())
                    .append("\\nAño: ")
                    .append(actual.vehiculo.getAnio())
                    .append("\"];\n");

            if (actual.siguiente != null) {
                dot.append("vehiculo")
                        .append(actual.vehiculo.getPlaca().replace("-", "_"))
                        .append(" -> vehiculo")
                        .append(actual.siguiente.vehiculo.getPlaca().replace("-", "_"))
                        .append(";\n");
            }

            actual = actual.siguiente;
        }

        dot.append("}");

        return dot.toString();
    }
}