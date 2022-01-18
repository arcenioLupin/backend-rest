/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author avilca
 */
public class SimuladorSapRequest extends BaseRequest {
    
    private Double valPorcCI;
    private Double valCI;
    private Double valMonFin;  
    private String fecVenc1raLet;
    private String codPerCredSol;
    private Integer canTotLet;
    private String tipoPeriodo;
    private String codMoneda;    
    private String tipSoliCred;
    private Double valTipoCambio;  
    private String orgaVenta; 
    private String canal;
    private String sector;   
    private String modelo;
    private String sku;
    private String tipoVehiculo;
    private Integer cantidad;  

    public Double getValPorcCI() {
        return valPorcCI;
    }

    public void setValPorcCI(Double valPorcCI) {
        this.valPorcCI = valPorcCI;
    }

    public Double getValCI() {
        return valCI;
    }

    public void setValCI(Double valCI) {
        this.valCI = valCI;
    }

    public Double getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(Double valMonFin) {
        this.valMonFin = valMonFin;
    }

    public String getFecVenc1raLet() {
        return fecVenc1raLet;
    }

    public void setFecVenc1raLet(String fecVenc1raLet) {
        this.fecVenc1raLet = fecVenc1raLet;
    }

    public String getCodPerCredSol() {
        return codPerCredSol;
    }

    public void setCodPerCredSol(String codPerCredSol) {
        this.codPerCredSol = codPerCredSol;
    }

    public Integer getCanTotLet() {
        return canTotLet;
    }

    public void setCanTotLet(Integer canTotLet) {
        this.canTotLet = canTotLet;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public Double getValTipoCambio() {
        return valTipoCambio;
    }

    public void setValTipoCambio(Double valTipoCambio) {
        this.valTipoCambio = valTipoCambio;
    }

    public String getOrgaVenta() {
        return orgaVenta;
    }

    public void setOrgaVenta(String orgaVenta) {
        this.orgaVenta = orgaVenta;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
           
}
