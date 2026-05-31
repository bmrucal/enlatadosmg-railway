package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.structures.ColaRepartidores;

@Service
public class RepartidorService {

    private ColaRepartidores colaRepartidores;

    public RepartidorService() {
        colaRepartidores = new ColaRepartidores();
    }

    public void agregarRepartidor(Repartidor repartidor) {
        colaRepartidores.encolar(repartidor);
    }

    public String listarRepartidores() {
        return colaRepartidores.listarRepartidores();
    }

    public Repartidor buscarRepartidor(String cui) {
        return colaRepartidores.buscar(cui);
    }

    public boolean actualizarRepartidor(String cui, Repartidor repartidor) {
        return colaRepartidores.actualizar(cui, repartidor);
    }

    public boolean eliminarRepartidor(String cui) {
        return colaRepartidores.eliminar(cui);
    }

    public Repartidor verSiguiente() {
        return colaRepartidores.verFrente();
    }

    public Repartidor sacarRepartidor() {
        return colaRepartidores.desencolar();
    }
}