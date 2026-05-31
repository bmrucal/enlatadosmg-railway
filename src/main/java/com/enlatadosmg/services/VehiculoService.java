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

    public String listarVehiculos() {
        return colaVehiculos.listarVehiculos();
    }

    public Vehiculo buscarVehiculo(String placa) {
        return colaVehiculos.buscar(placa);
    }

    public boolean actualizarVehiculo(String placa, Vehiculo vehiculo) {
        return colaVehiculos.actualizar(placa, vehiculo);
    }

    public boolean eliminarVehiculo(String placa) {
        return colaVehiculos.eliminar(placa);
    }
    public String generarDotVehiculos() {
        return colaVehiculos.generarDot();
    }

    public Vehiculo verSiguiente() {
        return colaVehiculos.verFrente();
    }

    public Vehiculo sacarVehiculo() {
        return colaVehiculos.desencolar();
    }
}