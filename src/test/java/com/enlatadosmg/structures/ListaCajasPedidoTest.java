package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Caja;

public class ListaCajasPedidoTest {

    @Test
    public void testInsertarYContarCajas() {

        ListaCajasPedido lista = new ListaCajasPedido();

        Caja caja1 = new Caja(1, "25/05/2026");
        Caja caja2 = new Caja(2, "25/05/2026");

        lista.insertar(caja1);
        lista.insertar(caja2);

        int total = lista.contarCajas();

        assertEquals(2, total);
    }

    @Test
    public void testListarCajas() {

        ListaCajasPedido lista = new ListaCajasPedido();

        Caja caja1 = new Caja(1, "25/05/2026");

        lista.insertar(caja1);

        String resultado = lista.listarCajas();

        assertTrue(resultado.contains("Caja: 1"));
    }
}