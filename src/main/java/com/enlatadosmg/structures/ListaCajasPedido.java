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

    public Caja buscarPorPosicion(int posicion) {
        NodoCaja actual = cabeza;
        int contador = 0;

        while (actual != null) {
            if (contador == posicion) {
                return actual.caja;
            }

            actual = actual.siguiente;
            contador++;
        }

        return null;
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
        if (cabeza == null) {
            return "";
        }

        String resultado = "";
        NodoCaja actual = cabeza;

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
}