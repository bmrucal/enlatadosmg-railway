package com.enlatadosmg.services;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private Map<String, Integer> tokensActivos = new ConcurrentHashMap<>();

    public String generarToken(int idUsuario) {
        String token = UUID.randomUUID().toString();
        tokensActivos.put(token, idUsuario);
        return token;
    }

    public boolean esTokenValido(String token) {
        if (token == null || token.isBlank()) {
            return false;
        }

        return tokensActivos.containsKey(token);
    }

    public void cerrarSesion(String token) {
        tokensActivos.remove(token);
    }

    public Integer obtenerIdUsuario(String token) {
        return tokensActivos.get(token);
    }
}