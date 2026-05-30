package com.enlatadosmg.models;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int anio;

    public Vehiculo(
            String placa,
            String marca,
            String modelo,
            String color,
            int anio) {

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}