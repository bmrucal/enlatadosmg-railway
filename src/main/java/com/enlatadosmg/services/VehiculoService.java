package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Vehiculo;
import com.enlatadosmg.structures.ColaVehiculos;

@Service
public class VehiculoService {

    private ColaVehiculos colaVehiculos;

    public VehiculoService() {
        colaVehiculos = new ColaVehiculos();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        colaVehiculos.encolar(vehiculo);
    }

    public Vehiculo sacarVehiculo() {
        return colaVehiculos.desencolar();
    }

    public Vehiculo verSiguiente() {
        return colaVehiculos.verFrente();
    }

    public String listarVehiculos() {
        return colaVehiculos.listarVehiculos();
    }
}