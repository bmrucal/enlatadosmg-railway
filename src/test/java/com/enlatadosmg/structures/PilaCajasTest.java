package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Caja;

public class PilaCajasTest {

    @Test
    public void testPushYVerCima() {
        PilaCajas pila = new PilaCajas();

        Caja c1 = new Caja(1, "2026-05-30 10:00:00");
        Caja c2 = new Caja(2, "2026-05-30 11:00:00");

        pila.push(c1);
        pila.push(c2);

        Caja cima = pila.verCima();

        assertNotNull(cima);
        assertEquals(2, cima.getCorrelativo());
        assertEquals("2026-05-30 11:00:00", cima.getFechaIngreso());
    }

    @Test
    public void testPopLIFO() {
        PilaCajas pila = new PilaCajas();

        Caja c1 = new Caja(1, "2026-05-30 10:00:00");
        Caja c2 = new Caja(2, "2026-05-30 11:00:00");
        Caja c3 = new Caja(3, "2026-05-30 12:00:00");

        pila.push(c1);
        pila.push(c2);
        pila.push(c3);

        Caja primeraSalida = pila.pop();
        Caja segundaSalida = pila.pop();
        Caja terceraSalida = pila.pop();

        assertEquals(3, primeraSalida.getCorrelativo());
        assertEquals(2, segundaSalida.getCorrelativo());
        assertEquals(1, terceraSalida.getCorrelativo());
        assertNull(pila.pop());
    }

    @Test
    public void testEstaVacia() {
        PilaCajas pila = new PilaCajas();

        assertTrue(pila.estaVacia());

        pila.push(new Caja(1, "2026-05-30 10:00:00"));

        assertFalse(pila.estaVacia());
    }

    @Test
    public void testTamanio() {
        PilaCajas pila = new PilaCajas();

        assertEquals(0, pila.getTamanio());

        pila.push(new Caja(1, "2026-05-30 10:00:00"));
        pila.push(new Caja(2, "2026-05-30 11:00:00"));

        assertEquals(2, pila.getTamanio());

        pila.pop();

        assertEquals(1, pila.getTamanio());
    }

    @Test
    public void testListarCajas() {
        PilaCajas pila = new PilaCajas();

        pila.push(new Caja(1, "2026-05-30 10:00:00"));
        pila.push(new Caja(2, "2026-05-30 11:00:00"));

        String listado = pila.listarCajas();

        assertTrue(listado.contains("Caja: 1"));
        assertTrue(listado.contains("Caja: 2"));
        assertTrue(listado.contains("Fecha ingreso"));
    }
}