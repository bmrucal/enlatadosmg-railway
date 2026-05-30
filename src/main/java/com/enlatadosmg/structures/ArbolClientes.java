package com.enlatadosmg.structures;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.nodes.NodoCliente;

public class ArbolClientes {

    private NodoCliente raiz;

    public ArbolClientes() {
        raiz = null;
    }

    private int altura(NodoCliente nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoCliente nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    private NodoCliente rotarDerecha(NodoCliente y) {

        NodoCliente x = y.izquierda;
        NodoCliente temp = x.derecha;

        x.derecha = y;
        y.izquierda = temp;

        y.altura = maximo(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = maximo(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private NodoCliente rotarIzquierda(NodoCliente x) {

        NodoCliente y = x.derecha;
        NodoCliente temp = y.izquierda;

        y.izquierda = x;
        x.derecha = temp;

        x.altura = maximo(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = maximo(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    public void insertar(Cliente cliente) {
        raiz = insertarRecursivo(raiz, cliente);
    }

    private NodoCliente insertarRecursivo(NodoCliente actual, Cliente cliente) {

        if (actual == null) {
            return new NodoCliente(cliente);
        }

        if (cliente.getCui() < actual.cliente.getCui()) {
            actual.izquierda = insertarRecursivo(actual.izquierda, cliente);
        } else if (cliente.getCui() > actual.cliente.getCui()) {
            actual.derecha = insertarRecursivo(actual.derecha, cliente);
        } else {
            return actual;
        }

        actual.altura =
                1 + maximo(
                        altura(actual.izquierda),
                        altura(actual.derecha)
                );

        int balance = obtenerBalance(actual);

        // Caso izquierda izquierda
        if (balance > 1 && cliente.getCui() < actual.izquierda.cliente.getCui()) {
            return rotarDerecha(actual);
        }

        // Caso derecha derecha
        if (balance < -1 && cliente.getCui() > actual.derecha.cliente.getCui()) {
            return rotarIzquierda(actual);
        }

        // Caso izquierda derecha
        if (balance > 1 && cliente.getCui() > actual.izquierda.cliente.getCui()) {
            actual.izquierda = rotarIzquierda(actual.izquierda);
            return rotarDerecha(actual);
        }

        // Caso derecha izquierda
        if (balance < -1 && cliente.getCui() < actual.derecha.cliente.getCui()) {
            actual.derecha = rotarDerecha(actual.derecha);
            return rotarIzquierda(actual);
        }

        return actual;
    }

    public Cliente buscar(long cui) {

        NodoCliente encontrado = buscarRecursivo(raiz, cui);

        if (encontrado != null) {
            return encontrado.cliente;
        }

        return null;
    }

    private NodoCliente buscarRecursivo(NodoCliente actual, long cui) {

        if (actual == null) {
            return null;
        }

        if (actual.cliente.getCui() == cui) {
            return actual;
        }

        if (cui < actual.cliente.getCui()) {
            return buscarRecursivo(actual.izquierda, cui);
        }

        return buscarRecursivo(actual.derecha, cui);
    }

    public String listarInOrden() {

        StringBuilder datos = new StringBuilder();

        listarInOrdenRecursivo(raiz, datos);

        return datos.toString();
    }

    private void listarInOrdenRecursivo(
            NodoCliente actual,
            StringBuilder datos) {

        if (actual != null) {

            listarInOrdenRecursivo(actual.izquierda, datos);

            datos.append("CUI: ")
                 .append(actual.cliente.getCui())
                 .append(" Nombre: ")
                 .append(actual.cliente.getNombre())
                 .append("\n");

            listarInOrdenRecursivo(actual.derecha, datos);
        }
    }
    public String generarDot() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("node [shape=box];\n");

        generarDotRecursivo(raiz, dot);

        dot.append("}");

        return dot.toString();
    }

    private void generarDotRecursivo(NodoCliente actual, StringBuilder dot) {

        if (actual != null) {

            dot.append("cliente")
               .append(actual.cliente.getCui())
               .append(" [label=\"CUI: ")
               .append(actual.cliente.getCui())
               .append("\\nNombre: ")
               .append(actual.cliente.getNombre())
               .append("\\nAltura: ")
               .append(actual.altura)
               .append("\"];\n");

            if (actual.izquierda != null) {
                dot.append("cliente")
                   .append(actual.cliente.getCui())
                   .append(" -> cliente")
                   .append(actual.izquierda.cliente.getCui())
                   .append(";\n");
            }

            if (actual.derecha != null) {
                dot.append("cliente")
                   .append(actual.cliente.getCui())
                   .append(" -> cliente")
                   .append(actual.derecha.cliente.getCui())
                   .append(";\n");
            }

            generarDotRecursivo(actual.izquierda, dot);
            generarDotRecursivo(actual.derecha, dot);
        }
    }
}