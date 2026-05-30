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

    @GetMapping("/cima")
    public Caja verCima() {

        return pilaCajasService.verCima();
    }

    @DeleteMapping
    public Caja sacarCaja() {

        return pilaCajasService.sacarCaja();
    }
}