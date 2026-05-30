package com.enlatadosmg.reports;

import java.io.FileWriter;

public class ReporteUsuarios {

    public void generarReporte(String contenidoDot) {

        try {

            FileWriter archivo =
                    new FileWriter("reporte_usuarios.dot");

            archivo.write(contenidoDot);
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
    }
}