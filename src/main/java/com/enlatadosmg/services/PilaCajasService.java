package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.structures.PilaCajas;

@Service
public class PilaCajasService {

    private PilaCajas pilaCajas;

    public PilaCajasService() {
        pilaCajas = new PilaCajas();
    }

    public void agregarCaja(Caja caja) {
        pilaCajas.push(caja);
    }

    public Caja sacarCaja() {
        return pilaCajas.pop();
    }

    public Caja verCima() {
        return pilaCajas.verCima();
    }
}