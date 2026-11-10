package com.lavandus.app.model;

import java.time.LocalDate;

public class SolicitudServicio {
    private Long id;
    private String razonSocialCliente;
    private double kilosEstimados;
    private String tipoPrenda;
    private LocalDate fechaRecoleccion;
    private String estado;
    private double totalLiquidado;

    public SolicitudServicio() {}

    public SolicitudServicio(Long id, String razonSocialCliente, double kilosEstimados,
                             String tipoPrenda, LocalDate fechaRecoleccion) {
        this.id = id;
        this.razonSocialCliente = razonSocialCliente;
        this.kilosEstimados = kilosEstimados;
        this.tipoPrenda = tipoPrenda;
        this.fechaRecoleccion = fechaRecoleccion;
        this.estado = "Registrada";
        this.totalLiquidado = calcularCosto(kilosEstimados, tipoPrenda);
    }

    public double calcularCosto(double kilos, String tipo) {
        double tarifaBase = 1200.0; // Precio base por kg industrial
        if ("Hospitalario".equalsIgnoreCase(tipo)) {
            tarifaBase = 1600.0; // Proceso desinfección termoquímica
        } else if ("Manteleria".equalsIgnoreCase(tipo)) {
            tarifaBase = 1350.0;
        }
        return kilos * tarifaBase;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRazonSocialCliente() { return razonSocialCliente; }
    public void setRazonSocialCliente(String razonSocialCliente) { this.razonSocialCliente = razonSocialCliente; }

    public double getKilosEstimados() { return kilosEstimados; }
    public void setKilosEstimados(double kilosEstimados) {
        this.kilosEstimados = kilosEstimados;
        this.totalLiquidado = calcularCosto(this.kilosEstimados, this.tipoPrenda);
    }

    public String getTipoPrenda() { return tipoPrenda; }
    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
        this.totalLiquidado = calcularCosto(this.kilosEstimados, this.tipoPrenda);
    }

    public LocalDate getFechaRecoleccion() { return fechaRecoleccion; }
    public void setFechaRecoleccion(LocalDate fechaRecoleccion) { this.fechaRecoleccion = fechaRecoleccion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotalLiquidado() { return totalLiquidado; }
}