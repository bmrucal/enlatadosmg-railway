package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Cliente;

public class ArbolClientesTest {

    @Test
    public void testInsertarYBuscarCliente() {
        ArbolClientes arbol = new ArbolClientes();

        Cliente cliente1 = new Cliente(300L, "Brayan", "Rucal", "5555-5555", "Guatemala");
        Cliente cliente2 = new Cliente(200L, "Carlos", "Lopez", "4444-4444", "Escuintla");
        Cliente cliente3 = new Cliente(500L, "Maria", "Perez", "3333-3333", "Peten");

        arbol.insertar(cliente1);
        arbol.insertar(cliente2);
        arbol.insertar(cliente3);

        Cliente encontrado = arbol.buscar(200L);

        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNombre());
        assertEquals("Lopez", encontrado.getApellido());
    }

    @Test
    public void testBuscarClienteNoExistente() {
        ArbolClientes arbol = new ArbolClientes();

        Cliente encontrado = arbol.buscar(999L);

        assertNull(encontrado);
    }

    @Test
    public void testActualizarCliente() {
        ArbolClientes arbol = new ArbolClientes();

        Cliente cliente = new Cliente(100L, "Ana", "Lopez", "1111-1111", "Guatemala");
        arbol.insertar(cliente);

        Cliente actualizado = new Cliente(100L, "Ana Maria", "Garcia", "2222-2222", "Mixco");

        boolean resultado = arbol.actualizar(100L, actualizado);
        Cliente encontrado = arbol.buscar(100L);

        assertTrue(resultado);
        assertNotNull(encontrado);
        assertEquals("Ana Maria", encontrado.getNombre());
        assertEquals("Garcia", encontrado.getApellido());
        assertEquals("2222-2222", encontrado.getTelefono());
        assertEquals("Mixco", encontrado.getDireccion());
    }

    @Test
    public void testActualizarClienteNoExistente() {
        ArbolClientes arbol = new ArbolClientes();

        Cliente actualizado = new Cliente(100L, "Ana", "Lopez", "1111-1111", "Guatemala");

        boolean resultado = arbol.actualizar(999L, actualizado);

        assertFalse(resultado);
    }

    @Test
    public void testEliminarCliente() {
        ArbolClientes arbol = new ArbolClientes();

        arbol.insertar(new Cliente(300L, "Brayan", "Rucal", "5555-5555", "Guatemala"));
        arbol.insertar(new Cliente(200L, "Carlos", "Lopez", "4444-4444", "Escuintla"));
        arbol.insertar(new Cliente(500L, "Maria", "Perez", "3333-3333", "Peten"));

        boolean eliminado = arbol.eliminar(200L);

        assertTrue(eliminado);
        assertNull(arbol.buscar(200L));
        assertNotNull(arbol.buscar(300L));
        assertNotNull(arbol.buscar(500L));
    }

    @Test
    public void testEliminarClienteNoExistente() {
        ArbolClientes arbol = new ArbolClientes();

        arbol.insertar(new Cliente(300L, "Brayan", "Rucal", "5555-5555", "Guatemala"));

        boolean eliminado = arbol.eliminar(999L);

        assertFalse(eliminado);
    }

    @Test
    public void testListarClientes() {
        ArbolClientes arbol = new ArbolClientes();

        arbol.insertar(new Cliente(300L, "Brayan", "Rucal", "5555-5555", "Guatemala"));
        arbol.insertar(new Cliente(200L, "Carlos", "Lopez", "4444-4444", "Escuintla"));

        String listado = arbol.listarInOrden();

        assertTrue(listado.contains("300"));
        assertTrue(listado.contains("200"));
        assertTrue(listado.contains("Brayan"));
        assertTrue(listado.contains("Carlos"));
    }

    @Test
    public void testGenerarDotClientes() {
        ArbolClientes arbol = new ArbolClientes();

        arbol.insertar(new Cliente(300L, "Brayan", "Rucal", "5555-5555", "Guatemala"));

        String dot = arbol.generarDot();

        assertTrue(dot.contains("digraph G"));
        assertTrue(dot.contains("cliente300"));
        assertTrue(dot.contains("Brayan"));
    }
}