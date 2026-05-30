package com.enlatadosmg.models;

public class Repartidor {

    private long cui;
    private String nombre;
    private String apellido;
    private String licencia;
    private String telefono;

    public Repartidor(long cui, String nombre, String apellido, String licencia, String telefono) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.telefono = telefono;
    }

    public long getCui() {
        return cui;
    }

    public void setCui(long cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
