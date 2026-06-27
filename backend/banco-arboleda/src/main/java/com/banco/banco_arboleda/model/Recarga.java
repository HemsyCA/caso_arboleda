package com.banco.banco_arboleda.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recargas")
public class Recarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCelular;
    private String operador;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String estado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroCelular() { return numeroCelular; }
    public void setNumeroCelular(String n) { this.numeroCelular = n; }
    public String getOperador() { return operador; }
    public void setOperador(String o) { this.operador = o; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal m) { this.monto = m; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime f) { this.fecha = f; }
    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
}