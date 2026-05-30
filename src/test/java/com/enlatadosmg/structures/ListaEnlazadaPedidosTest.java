package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.models.Vehiculo;

public class ListaEnlazadaPedidosTest {

    @Test
    public void testInsertarYBuscarPedido() {

        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

        Cliente cliente = new Cliente(
                123L,
                "Brayan",
                "Rucal",
                "5555-5555",
                "Guatemala"
        );

        Repartidor repartidor = new Repartidor(
                456L,
                "Carlos",
                "Lopez",
                "A",
                "4444-4444"
        );

        Vehiculo vehiculo = new Vehiculo(
                "P123ABC",
                "Toyota",
                "Hilux",
                "Rojo",
                2020
        );

        Pedido pedido = new Pedido(
                1,
                "Guatemala",
                "Escuintla",
                "25/05/2026 10:00",
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        lista.insertar(pedido);

        Pedido encontrado = lista.buscar(1);

        assertNotNull(encontrado);
        assertEquals("Escuintla", encontrado.getDestino());
        assertEquals("Pendiente", encontrado.getEstado());
    }

    @Test
    public void testCompletarPedido() {

        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

        Cliente cliente = new Cliente(
                123L,
                "Brayan",
                "Rucal",
                "5555-5555",
                "Guatemala"
        );

        Repartidor repartidor = new Repartidor(
                456L,
                "Carlos",
                "Lopez",
                "A",
                "4444-4444"
        );

        Vehiculo vehiculo = new Vehiculo(
                "P123ABC",
                "Toyota",
                "Hilux",
                "Rojo",
                2020
        );

        Pedido pedido = new Pedido(
                1,
                "Guatemala",
                "Escuintla",
                "25/05/2026 10:00",
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        lista.insertar(pedido);

        boolean completado = lista.completarPedido(1);

        Pedido encontrado = lista.buscar(1);

        assertTrue(completado);
        assertEquals("Completado", encontrado.getEstado());
    }
}