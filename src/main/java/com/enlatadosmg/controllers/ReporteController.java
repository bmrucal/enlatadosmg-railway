package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.services.ClienteService;
import com.enlatadosmg.services.PedidoService;
import com.enlatadosmg.services.PilaCajasService;
import com.enlatadosmg.services.RepartidorService;
import com.enlatadosmg.services.UsuarioService;
import com.enlatadosmg.services.VehiculoService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PilaCajasService pilaCajasService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private RepartidorService repartidorService;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/usuarios")
    public String reporteUsuarios() {
        return usuarioService.generarDotUsuarios();
    }

    @GetMapping("/cajas")
    public String reporteCajas() {
        return pilaCajasService.generarDotCajas();
    }

    @GetMapping("/clientes")
    public String reporteClientes() {
        return clienteService.generarDotClientes();
    }

    @GetMapping("/repartidores")
    public String reporteRepartidores() {
        return repartidorService.generarDotRepartidores();
    }

    @GetMapping("/vehiculos")
    public String reporteVehiculos() {
        return vehiculoService.generarDotVehiculos();
    }

    @GetMapping("/pedidos")
    public String reportePedidos() {
        return pedidoService.generarDotPedidos();
    }

    @GetMapping("/todos")
    public String reporteTodos() {

        StringBuilder reportes = new StringBuilder();

        reportes.append("===== REPORTE USUARIOS =====\n");
        reportes.append(usuarioService.generarDotUsuarios());
        reportes.append("\n\n");

        reportes.append("===== REPORTE CAJAS =====\n");
        reportes.append(pilaCajasService.generarDotCajas());
        reportes.append("\n\n");

        reportes.append("===== REPORTE CLIENTES =====\n");
        reportes.append(clienteService.generarDotClientes());
        reportes.append("\n\n");

        reportes.append("===== REPORTE REPARTIDORES =====\n");
        reportes.append(repartidorService.generarDotRepartidores());
        reportes.append("\n\n");

        reportes.append("===== REPORTE VEHICULOS =====\n");
        reportes.append(vehiculoService.generarDotVehiculos());
        reportes.append("\n\n");

        reportes.append("===== REPORTE PEDIDOS =====\n");
        reportes.append(pedidoService.generarDotPedidos());

        return reportes.toString();
    }
    @GetMapping("/general")
    public String reporteGeneral() {

        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("graph [rankdir=LR, bgcolor=\"white\"];\n");
        dot.append("node [shape=box, style=\"rounded,filled\", color=\"#6200EE\", fillcolor=\"#EDE7F6\", fontname=\"Arial\"];\n");
        dot.append("edge [color=\"#555555\", arrowsize=0.8];\n");

        dot.append("titulo [label=\"ESTRUCTURA GENERAL\\nENLATADOS MG\", shape=box, fillcolor=\"#D1C4E9\", fontsize=18];\n");

        dot.append("usuarios [label=\"Lista enlazada de usuarios\\nUsuarios del sistema\", fillcolor=\"#E3F2FD\"];\n");
        dot.append("almacen [label=\"Pila de cajas\\nAlmacén LIFO\", fillcolor=\"#E8F5E9\"];\n");
        dot.append("cajasPedido [label=\"Lista simple\\nCajas por pedido\", fillcolor=\"#FFF3E0\"];\n");
        dot.append("clientes [label=\"Árbol AVL de clientes\\nLlave: CUI\", fillcolor=\"#F3E5F5\"];\n");
        dot.append("repartidores [label=\"Cola de repartidores\\nFIFO\", fillcolor=\"#E0F7FA\"];\n");
        dot.append("vehiculos [label=\"Cola de vehículos\\nFIFO\", fillcolor=\"#FCE4EC\"];\n");
        dot.append("pedidos [label=\"Lista enlazada de pedidos\", fillcolor=\"#FFFDE7\"];\n");
        dot.append("pedido [label=\"PEDIDO\\nNúmero, origen, destino, fecha, estado\", fillcolor=\"#FFE0B2\", color=\"#E65100\"];\n");

        dot.append("titulo -> pedido [style=invis];\n");

        dot.append("usuarios -> pedidos [label=\"gestiona\"];\n");
        dot.append("almacen -> cajasPedido [label=\"pop cajas\"];\n");
        dot.append("cajasPedido -> pedido [label=\"cajas asignadas\"];\n");
        dot.append("clientes -> pedido [label=\"cliente asociado\"];\n");
        dot.append("repartidores -> pedido [label=\"repartidor asignado\"];\n");
        dot.append("vehiculos -> pedido [label=\"vehículo asignado\"];\n");
        dot.append("pedido -> pedidos [label=\"se almacena\"];\n");

        dot.append("pedido -> repartidores [label=\"al completar vuelve a cola\", style=dashed];\n");
        dot.append("pedido -> vehiculos [label=\"al completar vuelve a cola\", style=dashed];\n");

        dot.append("{ rank=same; almacen; cajasPedido; pedido; pedidos; }\n");
        dot.append("{ rank=same; clientes; repartidores; vehiculos; usuarios; }\n");

        dot.append("}\n");

        return dot.toString();
    }
}