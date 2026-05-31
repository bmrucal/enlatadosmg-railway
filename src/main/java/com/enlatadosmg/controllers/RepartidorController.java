package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.services.RepartidorService;

@RestController
@RequestMapping("/repartidores")
public class RepartidorController {

    @Autowired
    private RepartidorService repartidorService;

    @PostMapping
    public String agregarRepartidor(@RequestBody Repartidor repartidor) {
        repartidorService.agregarRepartidor(repartidor);
        return "Repartidor agregado correctamente";
    }

    @GetMapping
    public String listarRepartidores() {
        return repartidorService.listarRepartidores();
    }

    @GetMapping("/{cui}")
    public Repartidor buscarRepartidor(@PathVariable String cui) {
        return repartidorService.buscarRepartidor(cui);
    }

    @PutMapping("/{cui}")
    public String actualizarRepartidor(
            @PathVariable String cui,
            @RequestBody Repartidor repartidor) {

        boolean actualizado = repartidorService.actualizarRepartidor(cui, repartidor);

        if (actualizado) {
            return "Repartidor actualizado correctamente";
        }

        return "Repartidor no encontrado";
    }

    @DeleteMapping("/{cui}")
    public String eliminarRepartidor(@PathVariable String cui) {

        boolean eliminado = repartidorService.eliminarRepartidor(cui);

        if (eliminado) {
            return "Repartidor eliminado correctamente";
        }

        return "Repartidor no encontrado";
    }

    @GetMapping("/siguiente")
    public Repartidor verSiguiente() {
        return repartidorService.verSiguiente();
    }

    @DeleteMapping("/siguiente")
    public Repartidor sacarRepartidor() {
        return repartidorService.sacarRepartidor();
    }
}