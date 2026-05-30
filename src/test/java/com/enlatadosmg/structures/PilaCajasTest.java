package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Caja;

public class PilaCajasTest {

    @Test
    public void testPushYPop() {

        PilaCajas pila = new PilaCajas();

        Caja caja1 = new Caja(1, "25/05/2026");
        Caja caja2 = new Caja(2, "25/05/2026");

        pila.push(caja1);
        pila.push(caja2);

        Caja extraida = pila.pop();

        assertEquals(2, extraida.getCorrelativo());
    }

    @Test
    public void testVerCima() {

        PilaCajas pila = new PilaCajas();

        Caja caja1 = new Caja(1, "25/05/2026");

        pila.push(caja1);

        Caja cima = pila.verCima();

        assertEquals(1, cima.getCorrelativo());
    }
}