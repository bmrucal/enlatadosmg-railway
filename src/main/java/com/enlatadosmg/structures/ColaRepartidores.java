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

        if (fin == null) {
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

    public String listarRepartidores() {

        String resultado = "";

        NodoRepartidor actual = frente;

        while (actual != null) {

            resultado += "CUI: "
                    + actual.repartidor.getCui()
                    + " Nombre: "
                    + actual.repartidor.getNombre()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
}