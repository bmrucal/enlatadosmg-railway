package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Vehiculo;
import com.enlatadosmg.services.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public String agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.agregarVehiculo(vehiculo);
        return "Vehiculo agregado correctamente";
    }

    @GetMapping("/siguiente")
    public Vehiculo verSiguiente() {
        return vehiculoService.verSiguiente();
    }

    @GetMapping
    public String listarVehiculos() {
        return vehiculoService.listarVehiculos();
    }

    @DeleteMapping
    public Vehiculo sacarVehiculo() {
        return vehiculoService.sacarVehiculo();
    }
}