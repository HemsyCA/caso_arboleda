package com.banco.banco_arboleda.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cuenta;
    private String empresa;
    private String codigoRecibo;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String estado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCuenta() { return cuenta; }
    public void setCuenta(String c) { this.cuenta = c; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String e) { this.empresa = e; }
    public String getCodigoRecibo() { return codigoRecibo; }
    public void setCodigoRecibo(String c) { this.codigoRecibo = c; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal m) { this.monto = m; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime f) { this.fecha = f; }
    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
}