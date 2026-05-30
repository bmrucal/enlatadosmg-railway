package com.enlatadosmg.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlatadosmg.services.TokenService;
import com.enlatadosmg.services.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AuthController(UsuarioService usuarioService, TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> datos) {

        Map<String, Object> respuesta = new HashMap<>();

        try {
            int id = Integer.parseInt(datos.get("id"));
            String password = datos.get("password");

            boolean loginCorrecto = usuarioService.validarLogin(id, password);

            if (loginCorrecto) {
                String token = tokenService.generarToken(id);

                respuesta.put("mensaje", "Login correcto");
                respuesta.put("token", token);
                respuesta.put("idUsuario", id);

                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("mensaje", "Usuario o contraseña incorrectos");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
            }

        } catch (Exception e) {
            respuesta.put("mensaje", "Datos inválidos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {

        Map<String, Object> respuesta = new HashMap<>();

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            respuesta.put("mensaje", "Token no enviado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
        }

        String token = authorizationHeader.replace("Bearer ", "");
        tokenService.cerrarSesion(token);

        respuesta.put("mensaje", "Sesión cerrada correctamente");
        return ResponseEntity.ok(respuesta);
    }
}
