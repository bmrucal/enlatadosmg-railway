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

        return balancearNodo(actual);
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

    public boolean actualizar(long cui, Cliente clienteActualizado) {
        Cliente cliente = buscar(cui);

        if (cliente == null) {
            return false;
        }

        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setApellido(clienteActualizado.getApellido());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setDireccion(clienteActualizado.getDireccion());

        return true;
    }

    public boolean eliminar(long cui) {
        if (buscar(cui) == null) {
            return false;
        }

        raiz = eliminarRecursivo(raiz, cui);
        return true;
    }

    private NodoCliente eliminarRecursivo(NodoCliente actual, long cui) {
        if (actual == null) {
            return null;
        }

        if (cui < actual.cliente.getCui()) {
            actual.izquierda = eliminarRecursivo(actual.izquierda, cui);
        } else if (cui > actual.cliente.getCui()) {
            actual.derecha = eliminarRecursivo(actual.derecha, cui);
        } else {
            if (actual.izquierda == null || actual.derecha == null) {
                NodoCliente temp = null;

                if (actual.izquierda != null) {
                    temp = actual.izquierda;
                } else if (actual.derecha != null) {
                    temp = actual.derecha;
                }

                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            }

            NodoCliente sucesor = obtenerMinimo(actual.derecha);
            actual.cliente = sucesor.cliente;
            actual.derecha = eliminarRecursivo(actual.derecha, sucesor.cliente.getCui());
        }

        return balancearNodo(actual);
    }

    private NodoCliente obtenerMinimo(NodoCliente nodo) {
        NodoCliente actual = nodo;

        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }

        return actual;
    }

    private NodoCliente balancearNodo(NodoCliente actual) {
        if (actual == null) {
            return null;
        }

        actual.altura = 1 + maximo(
                altura(actual.izquierda),
                altura(actual.derecha)
        );

        int balance = obtenerBalance(actual);

        if (balance > 1 && obtenerBalance(actual.izquierda) >= 0) {
            return rotarDerecha(actual);
        }

        if (balance > 1 && obtenerBalance(actual.izquierda) < 0) {
            actual.izquierda = rotarIzquierda(actual.izquierda);
            return rotarDerecha(actual);
        }

        if (balance < -1 && obtenerBalance(actual.derecha) <= 0) {
            return rotarIzquierda(actual);
        }

        if (balance < -1 && obtenerBalance(actual.derecha) > 0) {
            actual.derecha = rotarDerecha(actual.derecha);
            return rotarIzquierda(actual);
        }

        return actual;
    }

    public String listarInOrden() {
        StringBuilder datos = new StringBuilder();
        listarInOrdenRecursivo(raiz, datos);
        return datos.toString();
    }

    private void listarInOrdenRecursivo(NodoCliente actual, StringBuilder datos) {
        if (actual != null) {
            listarInOrdenRecursivo(actual.izquierda, datos);

            datos.append("CUI: ")
                    .append(actual.cliente.getCui())
                    .append(" Nombre: ")
                    .append(actual.cliente.getNombre())
                    .append(" ")
                    .append(actual.cliente.getApellido())
                    .append(" Teléfono: ")
                    .append(actual.cliente.getTelefono())
                    .append(" Dirección: ")
                    .append(actual.cliente.getDireccion())
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
                    .append(" ")
                    .append(actual.cliente.getApellido())
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