package com.enlatadosmg.models;

public class PedidoRequest {

    private String origen;
    private String destino;
    private long cuiCliente;
    private int cantidadCajas;

    public PedidoRequest() {
    }

    public PedidoRequest(String origen, String destino, long cuiCliente, int cantidadCajas) {
        this.origen = origen;
        this.destino = destino;
        this.cuiCliente = cuiCliente;
        this.cantidadCajas = cantidadCajas;
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

    public long getCuiCliente() {
        return cuiCliente;
    }

    public void setCuiCliente(long cuiCliente) {
        this.cuiCliente = cuiCliente;
    }

    public int getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(int cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }
}