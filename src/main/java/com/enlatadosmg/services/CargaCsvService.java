package com.enlatadosmg.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Usuario;

@Service
public class CargaCsvService {

    private UsuarioService usuarioService;

    public CargaCsvService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String cargarUsuarios() {

        try {

            InputStream archivo =
                    getClass().getResourceAsStream("/csv/usuarios.csv");

            BufferedReader lector =
                    new BufferedReader(
                            new InputStreamReader(archivo)
                    );

            String linea;

            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(";");

                Usuario usuario = new Usuario(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        datos[3]
                );

                usuarioService.insertarUsuario(usuario);
            }

            lector.close();

            return "Usuarios cargados correctamente";

        } catch (Exception e) {

            return "Error: " + e.getMessage();
        }
    }
}