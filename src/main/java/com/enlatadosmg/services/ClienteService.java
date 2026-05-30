package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.structures.ArbolClientes;

@Service
public class ClienteService {

    private ArbolClientes arbolClientes;

    public ClienteService() {
        arbolClientes = new ArbolClientes();
    }

    public void insertarCliente(Cliente cliente) {
        arbolClientes.insertar(cliente);
    }

    public Cliente buscarCliente(long cui) {
        return arbolClientes.buscar(cui);
    }
    public String listarClientes() {
        return arbolClientes.listarInOrden();
    }
    public String generarDotClientes() {
        return arbolClientes.generarDot();
    }
}