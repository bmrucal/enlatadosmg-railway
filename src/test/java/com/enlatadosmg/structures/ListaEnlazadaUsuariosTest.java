package com.enlatadosmg.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.enlatadosmg.models.Usuario;

public class ListaEnlazadaUsuariosTest {

    @Test
    public void testInsertarYBuscarUsuario() {

        ListaEnlazadaUsuarios lista = new ListaEnlazadaUsuarios();

        Usuario usuario = new Usuario(
                1,
                "Brayan",
                "Rucal",
                "1234"
        );

        lista.insertar(usuario);

        Usuario encontrado = lista.buscar(1);

        assertNotNull(encontrado);
        assertEquals("Brayan", encontrado.getNombre());
    }

    @Test
    public void testEliminarUsuario() {

        ListaEnlazadaUsuarios lista = new ListaEnlazadaUsuarios();

        Usuario usuario = new Usuario(
                1,
                "Brayan",
                "Rucal",
                "1234"
        );

        lista.insertar(usuario);

        boolean eliminado = lista.eliminar(1);

        Usuario encontrado = lista.buscar(1);

        assertTrue(eliminado);
        assertNull(encontrado);
    }

    @Test
    public void testListarUsuarios() {

        ListaEnlazadaUsuarios lista = new ListaEnlazadaUsuarios();

        Usuario usuario1 = new Usuario(1, "Brayan", "Rucal", "1234");
        Usuario usuario2 = new Usuario(2, "Carlos", "Lopez", "5678");

        lista.insertar(usuario1);
        lista.insertar(usuario2);

        String resultado = lista.listarUsuarios();

        assertTrue(resultado.contains("Brayan"));
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("ID: 1"));
        assertTrue(resultado.contains("ID: 2"));
    }

    @Test
    public void testActualizarUsuario() {

        ListaEnlazadaUsuarios lista =
                new ListaEnlazadaUsuarios();

        Usuario usuario = new Usuario(
                1,
                "Brayan",
                "Rucal",
                "1234"
        );

        lista.insertar(usuario);

        Usuario actualizado = new Usuario(
                1,
                "Brayan Actualizado",
                "Rucal",
                "9999"
        );

        boolean resultado =
                lista.actualizar(1, actualizado);

        Usuario encontrado = lista.buscar(1);

        assertTrue(resultado);

        assertEquals(
                "Brayan Actualizado",
                encontrado.getNombre()
        );

        assertEquals(
                "9999",
                encontrado.getPassword()
        );
    }
}