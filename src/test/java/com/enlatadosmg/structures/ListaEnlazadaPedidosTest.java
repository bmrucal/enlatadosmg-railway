package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Pedido;

public class ListaEnlazadaPedidosTest {

    @Test
    public void testInsertarYBuscarPedido() {
        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

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

        lista.insertar(p1);
        lista.insertar(p2);

        Pedido encontrado = lista.buscar(102);

        assertNotNull(encontrado);
        assertEquals(102, encontrado.getNumeroPedido());
        assertEquals("Quetzaltenango", encontrado.getDestino());
    }

    @Test
    public void testBuscarPedidoNoExistente() {
        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

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

        lista.insertar(p1);

        Pedido encontrado = lista.buscar(999);

        assertNull(encontrado);
    }

    @Test
    public void testListarPedidos() {
        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

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

        lista.insertar(p1);
        lista.insertar(p2);

        String listado = lista.listarPedidos();

        assertTrue(listado.contains("101"));
        assertTrue(listado.contains("102"));
        assertTrue(listado.contains("Pendiente"));
        assertTrue(listado.contains("Escuintla"));
        assertTrue(listado.contains("Quetzaltenango"));
    }

    @Test
    public void testCompletarPedido() {
        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

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

        lista.insertar(p1);

        boolean completado = lista.completarPedido(101);
        Pedido encontrado = lista.buscar(101);

        assertTrue(completado);
        assertNotNull(encontrado);
        assertEquals("Completado", encontrado.getEstado());
    }

    @Test
    public void testCompletarPedidoNoExistente() {
        ListaEnlazadaPedidos lista = new ListaEnlazadaPedidos();

        boolean completado = lista.completarPedido(999);

        assertFalse(completado);
    }
}