package com.enlatadosmg.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.structures.PilaCajas;

@Service
public class PilaCajasService {

    private PilaCajas pilaCajas;
    private int siguienteCorrelativo;

    public PilaCajasService() {
        pilaCajas = new PilaCajas();
        siguienteCorrelativo = 1;
    }

    public Caja agregarCajaAutomatica() {
        Caja caja = new Caja(
                siguienteCorrelativo,
                obtenerFechaActual()
        );

        pilaCajas.push(caja);
        siguienteCorrelativo++;

        return caja;
    }

    public String generarCajas(int cantidad) {
        if (cantidad <= 0) {
            return "La cantidad debe ser mayor a cero";
        }

        for (int i = 0; i < cantidad; i++) {
            agregarCajaAutomatica();
        }

        return cantidad + " cajas agregadas correctamente al almacén";
    }

    public void agregarCaja(Caja caja) {
        pilaCajas.push(caja);

        if (caja.getCorrelativo() >= siguienteCorrelativo) {
            siguienteCorrelativo = caja.getCorrelativo() + 1;
        }
    }

    public Caja sacarCaja() {
        return pilaCajas.pop();
    }

    public Caja verCima() {
        return pilaCajas.verCima();
    }

    public String listarCajas() {
        return pilaCajas.listarCajas();
    }

    public int contarCajas() {
        return pilaCajas.getTamanio();
    }
    
    public String generarDotCajas() {
        return pilaCajas.generarDot();
    }

    private String obtenerFechaActual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }
}