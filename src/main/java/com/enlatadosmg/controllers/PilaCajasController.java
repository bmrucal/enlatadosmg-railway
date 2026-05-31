package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.services.PilaCajasService;

@RestController
@RequestMapping("/cajas")
public class PilaCajasController {

    @Autowired
    private PilaCajasService pilaCajasService;

    @PostMapping
    public String agregarCaja(@RequestBody Caja caja) {
        pilaCajasService.agregarCaja(caja);
        return "Caja agregada correctamente";
    }

    @PostMapping("/automatica")
    public Caja agregarCajaAutomatica() {
        return pilaCajasService.agregarCajaAutomatica();
    }

    @PostMapping("/generar/{cantidad}")
    public String generarCajas(@PathVariable int cantidad) {
        return pilaCajasService.generarCajas(cantidad);
    }

    @GetMapping
    public String listarCajas() {
        return pilaCajasService.listarCajas();
    }

    @GetMapping("/cima")
    public Caja verCima() {
        return pilaCajasService.verCima();
    }

    @GetMapping("/cantidad")
    public int contarCajas() {
        return pilaCajasService.contarCajas();
    }

    @DeleteMapping
    public Caja sacarCaja() {
        return pilaCajasService.sacarCaja();
    }
}