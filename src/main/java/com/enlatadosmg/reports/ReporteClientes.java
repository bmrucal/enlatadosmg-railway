package com.enlatadosmg.reports;

import java.io.FileWriter;

public class ReporteClientes {

    public void generarReporte(String contenidoDot) {

        try {

            FileWriter archivo =
                    new FileWriter("reporte_clientes.dot");

            archivo.write(contenidoDot);
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
    }
}