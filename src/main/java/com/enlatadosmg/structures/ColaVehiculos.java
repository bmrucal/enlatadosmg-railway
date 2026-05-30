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

    // ENCOLAR
    public void encolar(Vehiculo vehiculo) {

        NodoVehiculo nuevo =
                new NodoVehiculo(vehiculo);

        if (fin == null) {

            frente = nuevo;
            fin = nuevo;

            return;
        }

        fin.siguiente = nuevo;

        fin = nuevo;
    }

    // DESENCOLAR
    public Vehiculo desencolar() {

        if (frente == null) {
            return null;
        }

        Vehiculo vehiculo =
                frente.vehiculo;

        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return vehiculo;
    }

    // VER FRENTE
    public Vehiculo verFrente() {

        if (frente == null) {
            return null;
        }

        return frente.vehiculo;
    }

    // LISTAR
    public String listarVehiculos() {

        String resultado = "";

        NodoVehiculo actual = frente;

        while (actual != null) {

            resultado +=
                    "PLACA: "
                    + actual.vehiculo.getPlaca()
                    + " MARCA: "
                    + actual.vehiculo.getMarca()
                    + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
}