package com.enlatadosmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.enlatadosmg.models.Usuario;
import com.enlatadosmg.services.UsuarioService;
import com.enlatadosmg.services.CargaCsvService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargaCsvService cargaCsvService;

    // INSERTAR USUARIO
    @PostMapping
    public String insertarUsuario(@RequestBody Usuario usuario) {

        usuarioService.insertarUsuario(usuario);

        return "Usuario insertado correctamente";
    }

    // BUSCAR USUARIO
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable int id) {

        return usuarioService.buscarUsuario(id);
    }

    // LISTAR USUARIOS
    @GetMapping
    public String listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // ELIMINAR USUARIO
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable int id) {

        boolean eliminado = usuarioService.eliminarUsuario(id);

        if (eliminado) {
            return "Usuario eliminado correctamente";
        }

        return "Usuario no encontrado";
    }

    // ACTUALIZAR USUARIO
    @PutMapping("/{id}")
    public String actualizarUsuario(
            @PathVariable int id,
            @RequestBody Usuario usuario) {

        boolean actualizado =
                usuarioService.actualizarUsuario(id, usuario);

        if (actualizado) {
            return "Usuario actualizado correctamente";
        }

        return "Usuario no encontrado";
    }

    @PostMapping("/cargar-csv")
    public String cargarUsuariosCsv() {
        return cargaCsvService.cargarUsuarios();
    }
}