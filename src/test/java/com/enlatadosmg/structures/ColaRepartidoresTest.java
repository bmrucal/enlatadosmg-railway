package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Repartidor;

public class ColaRepartidoresTest {

    @Test
    public void testEncolarYVerFrente() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        Repartidor r2 = new Repartidor("200", "Carlos", "Lopez", "B", "5555-2222");

        cola.encolar(r1);
        cola.encolar(r2);

        Repartidor frente = cola.verFrente();

        assertNotNull(frente);
        assertEquals("100", frente.getCui());
        assertEquals("Luis", frente.getNombre());
    }

    @Test
    public void testDesencolarFIFO() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        Repartidor r2 = new Repartidor("200", "Carlos", "Lopez", "B", "5555-2222");

        cola.encolar(r1);
        cola.encolar(r2);

        Repartidor primero = cola.desencolar();
        Repartidor segundo = cola.desencolar();

        assertEquals("100", primero.getCui());
        assertEquals("200", segundo.getCui());
        assertNull(cola.desencolar());
    }

    @Test
    public void testBuscarRepartidor() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        Repartidor r2 = new Repartidor("200", "Carlos", "Lopez", "B", "5555-2222");

        cola.encolar(r1);
        cola.encolar(r2);

        Repartidor encontrado = cola.buscar("200");

        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNombre());
        assertEquals("Lopez", encontrado.getApellidos());
        assertNull(cola.buscar("999"));
    }

    @Test
    public void testActualizarRepartidor() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        cola.encolar(r1);

        Repartidor actualizado = new Repartidor("100", "Luis Alberto", "Mendez", "C", "5555-9999");

        boolean resultado = cola.actualizar("100", actualizado);
        Repartidor encontrado = cola.buscar("100");

        assertTrue(resultado);
        assertNotNull(encontrado);
        assertEquals("Luis Alberto", encontrado.getNombre());
        assertEquals("Mendez", encontrado.getApellidos());
        assertEquals("C", encontrado.getLicencia());
        assertEquals("5555-9999", encontrado.getTelefono());
    }

    @Test
    public void testEliminarRepartidor() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        Repartidor r2 = new Repartidor("200", "Carlos", "Lopez", "B", "5555-2222");

        cola.encolar(r1);
        cola.encolar(r2);

        boolean eliminado = cola.eliminar("100");

        assertTrue(eliminado);
        assertNull(cola.buscar("100"));
        assertNotNull(cola.buscar("200"));
    }

    @Test
    public void testListarRepartidores() {
        ColaRepartidores cola = new ColaRepartidores();

        Repartidor r1 = new Repartidor("100", "Luis", "Garcia", "A", "5555-1111");
        cola.encolar(r1);

        String listado = cola.listarRepartidores();

        assertTrue(listado.contains("100"));
        assertTrue(listado.contains("Luis"));
        assertTrue(listado.contains("Garcia"));
        assertTrue(listado.contains("A"));
    }
}