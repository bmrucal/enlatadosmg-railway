package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlatadosmg.reports.ReporteUsuarios;
import com.enlatadosmg.services.UsuarioService;
import com.enlatadosmg.models.Caja;
import com.enlatadosmg.reports.ReporteCajasPedido;
import com.enlatadosmg.structures.ListaCajasPedido;
import com.enlatadosmg.reports.ReporteClientes;
import com.enlatadosmg.services.ClienteService;

@RestController
public class ReporteController {
	
	@Autowired
	private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/reportes/usuarios")
    public String generarReporteUsuarios() {

        String dot = usuarioService.generarDotUsuarios();

        ReporteUsuarios reporte = new ReporteUsuarios();

        reporte.generarReporte(dot);

        return "Reporte dinamico de usuarios generado correctamente";
    }
    @GetMapping("/reportes/cajas-pedido")
    public String generarReporteCajasPedido() {

        ListaCajasPedido lista = new ListaCajasPedido();

        lista.insertar(new Caja(1, "25/05/2026"));
        lista.insertar(new Caja(2, "25/05/2026"));
        lista.insertar(new Caja(3, "25/05/2026"));

        String dot = lista.generarDot();

        ReporteCajasPedido reporte = new ReporteCajasPedido();

        reporte.generarReporte(dot);

        return "Reporte de cajas por pedido generado correctamente";
    }
    @GetMapping("/reportes/clientes")
    public String generarReporteClientes() {

        String dot = clienteService.generarDotClientes();

        ReporteClientes reporte = new ReporteClientes();

        reporte.generarReporte(dot);

        return "Reporte de clientes generado correctamente";
    }
}