package com.enlatadosmg.structures;

import com.enlatadosmg.models.Usuario;
import com.enlatadosmg.nodes.NodoUsuario;

public class ListaEnlazadaUsuarios {

    private NodoUsuario cabeza;

    public ListaEnlazadaUsuarios() {
        this.cabeza = null;
    }

    // INSERTAR USUARIO
    public void insertar(Usuario usuario) {

        NodoUsuario nuevo = new NodoUsuario(usuario);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoUsuario actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // BUSCAR POR ID
    public Usuario buscar(int id) {

        NodoUsuario actual = cabeza;

        while (actual != null) {

            if (actual.usuario.getId() == id) {
                return actual.usuario;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // LISTAR USUARIOS
    public String listarUsuarios() {

        StringBuilder datos = new StringBuilder();

        NodoUsuario actual = cabeza;

        while (actual != null) {

            datos.append("ID: ")
                 .append(actual.usuario.getId())
                 .append(" Nombre: ")
                 .append(actual.usuario.getNombre())
                 .append("\n");

            actual = actual.siguiente;
        }

        return datos.toString();
    }

    // ELIMINAR USUARIO
    public boolean eliminar(int id) {

        if (cabeza == null) {
            return false;
        }

        if (cabeza.usuario.getId() == id) {
            cabeza = cabeza.siguiente;
            return true;
        }

        NodoUsuario actual = cabeza;

        while (actual.siguiente != null) {

            if (actual.siguiente.usuario.getId() == id) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // ACTUALIZAR USUARIO
    public boolean actualizar(int id, Usuario nuevoUsuario) {

        NodoUsuario actual = cabeza;

        while (actual != null) {

            if (actual.usuario.getId() == id) {
                actual.usuario.setNombre(nuevoUsuario.getNombre());
                actual.usuario.setApellido(nuevoUsuario.getApellido());
                actual.usuario.setPassword(nuevoUsuario.getPassword());
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }
 // GENERAR DOT PARA GRAPHVIZ
    public String generarDot() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("rankdir=LR;\n");
        dot.append("node [shape=box];\n");

        NodoUsuario actual = cabeza;

        while (actual != null) {

            dot.append("usuario")
               .append(actual.usuario.getId())
               .append(" [label=\"ID: ")
               .append(actual.usuario.getId())
               .append("\\nNombre: ")
               .append(actual.usuario.getNombre())
               .append("\"];\n");

            if (actual.siguiente != null) {
                dot.append("usuario")
                   .append(actual.usuario.getId())
                   .append(" -> usuario")
                   .append(actual.siguiente.usuario.getId())
                   .append(";\n");
            }

            actual = actual.siguiente;
        }

        dot.append("}");

        return dot.toString();
    }
}
