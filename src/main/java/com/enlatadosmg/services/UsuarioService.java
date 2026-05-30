package com.enlatadosmg.services;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Usuario;
import com.enlatadosmg.structures.ListaEnlazadaUsuarios;

@Service
public class UsuarioService {

    private ListaEnlazadaUsuarios listaUsuarios;

    public UsuarioService() {
        listaUsuarios = new ListaEnlazadaUsuarios();
    }

    public void insertarUsuario(Usuario usuario) {
        listaUsuarios.insertar(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return listaUsuarios.buscar(id);
    }

    public String listarUsuarios() {
        return listaUsuarios.listarUsuarios();
    }

    public boolean eliminarUsuario(int id) {
        return listaUsuarios.eliminar(id);
    }

    public boolean actualizarUsuario(int id, Usuario usuario) {
        return listaUsuarios.actualizar(id, usuario);
    }

    public String generarDotUsuarios() {
        return listaUsuarios.generarDot();
    }

    // =====================================================
    // MÉTODO PARA LOGIN
    // =====================================================
    public boolean validarLogin(int id, String password) {
        Usuario usuarioEncontrado = listaUsuarios.buscar(id);

        if (usuarioEncontrado == null) {
            return false;
        }

        if (usuarioEncontrado.getPassword() == null) {
            return false;
        }

        return usuarioEncontrado.getPassword().equals(password);
    }
}