package com.banco.banco_arboleda.service;

import com.banco.banco_arboleda.model.Recarga;
import com.banco.banco_arboleda.repository.RecargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecargaService {

    @Autowired
    private RecargaRepository repository;

    public Recarga realizarRecarga(Recarga recarga) {
        if (!recarga.getNumeroCelular().matches("\\d{7,12}"))
            throw new IllegalArgumentException("Número de celular inválido");

        List<String> operadoresValidos = List.of("Claro", "Movistar", "Entel", "Bitel");
        if (!operadoresValidos.contains(recarga.getOperador()))
            throw new IllegalArgumentException("Operador no válido");

        if (recarga.getMonto() == null || recarga.getMonto().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Monto inválido");

        recarga.setFecha(LocalDateTime.now());
        recarga.setEstado("EXITOSA");
        return repository.save(recarga);
    }
}