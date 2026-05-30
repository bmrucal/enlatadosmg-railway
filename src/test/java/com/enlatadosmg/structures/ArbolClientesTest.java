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
        Cliente cliente3 = new Cliente(500L, "Maria", "Perez", "3333-3333", "Petén");

        arbol.insertar(cliente1);
        arbol.insertar(cliente2);
        arbol.insertar(cliente3);

        Cliente encontrado =
                arbol.buscar(200L);

        assertNotNull(encontrado);

        assertEquals(
                "Carlos",
                encontrado.getNombre()
        );
    }
    
    @Test
    public void testBuscarClienteNoExistente() {

        ArbolClientes arbol = new ArbolClientes();

        Cliente encontrado = arbol.buscar(999L);

        assertNull(encontrado);
    }
}