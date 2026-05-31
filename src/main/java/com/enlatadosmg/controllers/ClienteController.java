package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public String insertarCliente(@RequestBody Cliente cliente) {
        clienteService.insertarCliente(cliente);
        return "Cliente insertado correctamente";
    }

    @GetMapping
    public String listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{cui}")
    public Cliente buscarCliente(@PathVariable long cui) {
        return clienteService.buscarCliente(cui);
    }

    @PutMapping("/{cui}")
    public String actualizarCliente(
            @PathVariable long cui,
            @RequestBody Cliente cliente) {

        boolean actualizado = clienteService.actualizarCliente(cui, cliente);

        if (actualizado) {
            return "Cliente actualizado correctamente";
        }

        return "Cliente no encontrado";
    }

    @DeleteMapping("/{cui}")
    public String eliminarCliente(@PathVariable long cui) {
        boolean eliminado = clienteService.eliminarCliente(cui);

        if (eliminado) {
            return "Cliente eliminado correctamente";
        }

        return "Cliente no encontrado";
    }
}