package com.enlatadosmg.models;

import com.enlatadosmg.structures.ListaCajasPedido;

public class Pedido {

    private int numeroPedido;
    private String origen;
    private String destino;
    private String fechaHora;
    private String estado;
    private Cliente cliente;
    private Repartidor repartidor;
    private Vehiculo vehiculo;
    private ListaCajasPedido cajas;
    private int numeroCajas;

    public Pedido() {
        this.estado = "Pendiente";
        this.cajas = new ListaCajasPedido();
        this.numeroCajas = 0;
    }

    public Pedido(
            int numeroPedido,
            String origen,
            String destino,
            String fechaHora,
            String estado,
            Cliente cliente,
            Repartidor repartidor,
            Vehiculo vehiculo) {

        this.numeroPedido = numeroPedido;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.vehiculo = vehiculo;
        this.cajas = new ListaCajasPedido();
        this.numeroCajas = 0;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ListaCajasPedido getCajas() {
        return cajas;
    }

    public void setCajas(ListaCajasPedido cajas) {
        this.cajas = cajas;
    }

    public int getNumeroCajas() {
        return numeroCajas;
    }

    public void setNumeroCajas(int numeroCajas) {
        this.numeroCajas = numeroCajas;
    }
}