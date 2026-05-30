package com.enlatadosmg.nodes;

import com.enlatadosmg.models.Usuario;

public class NodoUsuario {

    public Usuario usuario;
    public NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }
}