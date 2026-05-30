package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Cliente;

public class NodoCliente {

    public Cliente cliente;

    public NodoCliente izquierda;
    public NodoCliente derecha;

    public int altura;

    public NodoCliente(Cliente cliente) {

        this.cliente = cliente;

        this.izquierda = null;
        this.derecha = null;

        this.altura = 1;
    }
}