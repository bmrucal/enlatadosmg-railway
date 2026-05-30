package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.models.Vehiculo;

public class ColaPedidosTest {

    @Test
    public void testEncolarYDesencolar() {

        ColaPedidos cola = new ColaPedidos();

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

        Pedido pedido1 = new Pedido(
                1,
                "Guatemala",
                "Escuintla",
                "25/05/2026 10:00",
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        Pedido pedido2 = new Pedido(
                2,
                "Guatemala",
                "Petén",
                "25/05/2026 11:00",
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        cola.encolar(pedido1);
        cola.encolar(pedido2);

        Pedido primero = cola.desencolar();

        assertEquals(1, primero.getNumeroPedido());
    }

    @Test
    public void testVerFrente() {

        ColaPedidos cola = new ColaPedidos();

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

        Pedido pedido1 = new Pedido(
                1,
                "Guatemala",
                "Escuintla",
                "25/05/2026 10:00",
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        cola.encolar(pedido1);

        Pedido frente = cola.verFrente();

        assertEquals(1, frente.getNumeroPedido());
    }
}