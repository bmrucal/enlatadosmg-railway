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

    @GetMapping
    public String listarVehiculos() {
        return vehiculoService.listarVehiculos();
    }

    @GetMapping("/{placa}")
    public Vehiculo buscarVehiculo(@PathVariable String placa) {
        return vehiculoService.buscarVehiculo(placa);
    }

    @PutMapping("/{placa}")
    public String actualizarVehiculo(
            @PathVariable String placa,
            @RequestBody Vehiculo vehiculo) {

        boolean actualizado = vehiculoService.actualizarVehiculo(placa, vehiculo);

        if (actualizado) {
            return "Vehiculo actualizado correctamente";
        }

        return "Vehiculo no encontrado";
    }

    @DeleteMapping("/{placa}")
    public String eliminarVehiculo(@PathVariable String placa) {
        boolean eliminado = vehiculoService.eliminarVehiculo(placa);

        if (eliminado) {
            return "Vehiculo eliminado correctamente";
        }

        return "Vehiculo no encontrado";
    }

    @GetMapping("/siguiente")
    public Vehiculo verSiguiente() {
        return vehiculoService.verSiguiente();
    }

    @DeleteMapping("/siguiente")
    public Vehiculo sacarVehiculo() {
        return vehiculoService.sacarVehiculo();
    }
}