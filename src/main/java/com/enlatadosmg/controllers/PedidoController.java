package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public String agregarPedido(@RequestBody Pedido pedido) {

        pedidoService.agregarPedido(pedido);

        return "Pedido agregado correctamente";
    }

    @GetMapping("/siguiente")
    public Pedido verSiguiente() {

        return pedidoService.verSiguiente();
    }

    @DeleteMapping
    public Pedido atenderPedido() {

        return pedidoService.atenderPedido();
    }
}