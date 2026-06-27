package com.banco.banco_arboleda.controller;

import com.banco.banco_arboleda.model.Pago;
import com.banco.banco_arboleda.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping("/deuda/{empresa}")
    public Map<String, BigDecimal> consultarDeuda(@PathVariable String empresa) {
        return Map.of("deuda", service.consultarDeuda(empresa));
    }

    @PostMapping("/pago")
    public ResponseEntity<Map<String, Object>> realizarPago(@RequestBody Pago pago) {
        try {
            Pago resultado = service.realizarPago(pago);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Pago realizado con éxito.",
                "id", resultado.getId(),
                "monto", resultado.getMonto()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "Error: " + e.getMessage()));
        }
    }
}