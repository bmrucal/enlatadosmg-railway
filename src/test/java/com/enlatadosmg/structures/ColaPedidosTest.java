package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Pedido;

public class ColaPedidosTest {

    @Test
    public void testEncolarYVerFrente() {
        ColaPedidos cola = new ColaPedidos();

        Pedido p1 = new Pedido(
                101,
                "Guatemala",
                "Escuintla",
                "2026-05-30 10:00",
                "Pendiente",
                null,
                null,
                null
        );

        Pedido p2 = new Pedido(
                102,
                "Guatemala",
                "Quetzaltenango",
                "2026-05-30 11:00",
                "Pendiente",
                null,
                null,
                null
        );

        cola.encolar(p1);
        cola.encolar(p2);

        Pedido frente = cola.verFrente();

        assertNotNull(frente);
        assertEquals(101, frente.getNumeroPedido());
        assertEquals("Escuintla", frente.getDestino());
        assertEquals("Pendiente", frente.getEstado());
    }

    @Test
    public void testDesencolarFIFO() {
        ColaPedidos cola = new ColaPedidos();

        Pedido p1 = new Pedido(
                101,
                "Guatemala",
                "Escuintla",
                "2026-05-30 10:00",
                "Pendiente",
                null,
                null,
                null
        );

        Pedido p2 = new Pedido(
                102,
                "Guatemala",
                "Quetzaltenango",
                "2026-05-30 11:00",
                "Pendiente",
                null,
                null,
                null
        );

        cola.encolar(p1);
        cola.encolar(p2);

        Pedido primero = cola.desencolar();
        Pedido segundo = cola.desencolar();

        assertNotNull(primero);
        assertNotNull(segundo);

        assertEquals(101, primero.getNumeroPedido());
        assertEquals(102, segundo.getNumeroPedido());

        assertNull(cola.desencolar());
    }

    @Test
    public void testVerFrenteColaVacia() {
        ColaPedidos cola = new ColaPedidos();

        assertNull(cola.verFrente());
    }

    @Test
    public void testDesencolarColaVacia() {
        ColaPedidos cola = new ColaPedidos();

        assertNull(cola.desencolar());
    }
}