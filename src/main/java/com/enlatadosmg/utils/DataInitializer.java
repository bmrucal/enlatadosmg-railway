package com.enlatadosmg.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enlatadosmg.services.CargaCsvService;
import com.enlatadosmg.services.UsuarioService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CargaCsvService cargaCsvService;
    private final UsuarioService usuarioService;

    public DataInitializer(CargaCsvService cargaCsvService, UsuarioService usuarioService) {
        this.cargaCsvService = cargaCsvService;
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (usuarioService.buscarUsuario(1) == null) {
            String resultado = cargaCsvService.cargarUsuarios();
            System.out.println("Carga inicial de usuarios: " + resultado);
        } else {
            System.out.println("Usuarios ya cargados. No se ejecutó carga inicial.");
        }
    }
}