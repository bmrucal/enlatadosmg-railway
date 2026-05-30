package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Repartidor;

public class ColaRepartidoresTest {

    @Test
    public void testEncolarYDesencolar() {

        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor(
                1234567890101L,
                "Brayan",
                "Rucal",
                "A",
                "5555-5555"
        );

        Repartidor r2 = new Repartidor(
                2234567890101L,
                "Carlos",
                "Lopez",
                "B",
                "4444-4444"
        );

        cola.encolar(r1);
        cola.encolar(r2);

        Repartidor primero = cola.desencolar();

        assertEquals(1234567890101L, primero.getCui());
    }

    @Test
    public void testVerFrente() {

        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor(
                1234567890101L,
                "Brayan",
                "Rucal",
                "A",
                "5555-5555"
        );

        cola.encolar(r1);

        Repartidor frente = cola.verFrente();

        assertEquals("Brayan", frente.getNombre());
    }
}