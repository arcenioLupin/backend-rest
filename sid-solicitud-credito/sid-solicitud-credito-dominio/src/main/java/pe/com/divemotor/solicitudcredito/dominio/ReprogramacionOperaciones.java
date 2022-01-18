/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author mbardales
 */
public class ReprogramacionOperaciones {
    
    private String numOperacion;
    private String moneda;
    private Double monto;
    private Integer nroLetras;
    private Double tea;
    private String fechaPrimVenc;
    private String estado;

    public String getNumOperacion() {
        return numOperacion;
    }

    public void setNumOperacion(String numOperacion) {
        this.numOperacion = numOperacion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getNroLetras() {
        return nroLetras;
    }

    public void setNroLetras(Integer nroLetras) {
        this.nroLetras = nroLetras;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public String getFechaPrimVenc() {
        return fechaPrimVenc;
    }

    public void setFechaPrimVenc(String fechaPrimVenc) {
        this.fechaPrimVenc = fechaPrimVenc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
