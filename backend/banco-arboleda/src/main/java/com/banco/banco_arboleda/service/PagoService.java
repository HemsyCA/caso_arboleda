package com.banco.banco_arboleda.service;
import com.banco.banco_arboleda.model.Pago;
import com.banco.banco_arboleda.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class PagoService {

    @Autowired
    private PagoRepository repository;

    private static final Map<String, BigDecimal> DEUDAS = Map.of(
        "Luz Star", new BigDecimal("50"),
        "Agua Sin Filtro", new BigDecimal("20")
    );

    public BigDecimal consultarDeuda(String empresa) {
        return DEUDAS.getOrDefault(empresa, BigDecimal.ZERO);
    }

    public Pago realizarPago(Pago pago) {
        if (!pago.getCodigoRecibo().matches("\\d{8}"))
            throw new IllegalArgumentException("El código de recibo debe tener 8 dígitos");

        if (!DEUDAS.containsKey(pago.getEmpresa()))
            throw new IllegalArgumentException("Empresa no válida");

        pago.setMonto(DEUDAS.get(pago.getEmpresa()));
        pago.setFecha(LocalDateTime.now());
        pago.setEstado("EXITOSA");
        return repository.save(pago);
    }
}