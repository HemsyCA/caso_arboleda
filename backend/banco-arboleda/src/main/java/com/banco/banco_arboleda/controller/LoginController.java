package com.banco.banco_arboleda.controller;

import com.banco.banco_arboleda.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        boolean valido = service.validar(body.get("usuario"), body.get("clave"));
        if (valido) {
            return ResponseEntity.ok(Map.of("mensaje", "Acceso concedido"));
        }
        return ResponseEntity.status(401).body(Map.of("mensaje", "Usuario o clave incorrectos"));
    }
}