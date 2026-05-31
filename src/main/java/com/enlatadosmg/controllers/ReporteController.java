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
}