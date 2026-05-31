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

    @GetMapping
    public String listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{numeroPedido}")
    public Pedido buscarPedido(@PathVariable int numeroPedido) {
        return pedidoService.buscarPedido(numeroPedido);
    }

    @GetMapping("/siguiente")
    public Pedido verSiguiente() {
        return pedidoService.verSiguiente();
    }

    @PutMapping("/{numeroPedido}/completar")
    public String completarPedido(@PathVariable int numeroPedido) {

        boolean completado = pedidoService.completarPedido(numeroPedido);

        if (completado) {
            return "Pedido completado correctamente";
        }

        return "Pedido no encontrado";
    }

    @DeleteMapping
    public Pedido atenderPedido() {
        return pedidoService.atenderPedido();
    }
}