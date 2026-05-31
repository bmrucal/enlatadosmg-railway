package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.models.PedidoRequest;
import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.models.Vehiculo;
import com.enlatadosmg.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public String crearPedido(@RequestBody PedidoRequest request) {
        return pedidoService.crearPedido(request);
    }

    @PostMapping("/manual")
    public String agregarPedidoManual(@RequestBody Pedido pedido) {
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

    @GetMapping("/{numeroPedido}/cajas")
    public String verCajasPedido(@PathVariable int numeroPedido) {
        return pedidoService.verCajasPedido(numeroPedido);
    }

    @GetMapping("/{numeroPedido}/cliente")
    public Cliente verClientePedido(@PathVariable int numeroPedido) {
        return pedidoService.verClientePedido(numeroPedido);
    }

    @GetMapping("/{numeroPedido}/repartidor")
    public Repartidor verRepartidorPedido(@PathVariable int numeroPedido) {
        return pedidoService.verRepartidorPedido(numeroPedido);
    }

    @GetMapping("/{numeroPedido}/vehiculo")
    public Vehiculo verVehiculoPedido(@PathVariable int numeroPedido) {
        return pedidoService.verVehiculoPedido(numeroPedido);
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