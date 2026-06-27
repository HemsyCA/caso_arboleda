package com.banco.banco_arboleda.controller;

import com.banco.banco_arboleda.model.Recarga;
import com.banco.banco_arboleda.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RecargaController {

    @Autowired
    private RecargaService service;

    @PostMapping("/recarga")
    public ResponseEntity<Map<String, Object>> realizarRecarga(@RequestBody Recarga recarga) {
        try {
            Recarga resultado = service.realizarRecarga(recarga);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Recarga realizada con éxito.",
                "id", resultado.getId(),
                "estado", resultado.getEstado()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                "mensaje", "Datos inválidos: " + e.getMessage()
            ));
        }
    }
}