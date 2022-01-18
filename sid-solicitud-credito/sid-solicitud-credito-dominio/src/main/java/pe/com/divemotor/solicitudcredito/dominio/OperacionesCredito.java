/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author jaltamirano
 */
public class OperacionesCredito {

    private String nroOperacion;
    private String codTipoOperacion;
    private String tipoOperacion;
    private String fechaOtorgamiento;
    private String fechaVencimientoUL;
    private String plazoDias;
    private String status;
    private String divisa;
    private Double saldoOriginal;
    private Double saldoVigente;
    private Double tea;
    private Double ratioCoberturaGara;
    private String rutaCartaBanco;
    private Double valMonFin;

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public String getCodTipoOperacion() {
        return codTipoOperacion;
    }

    public void setCodTipoOperacion(String codTipoOperacion) {
        this.codTipoOperacion = codTipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(String fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public String getFechaVencimientoUL() {
        return fechaVencimientoUL;
    }

    public void setFechaVencimientoUL(String fechaVencimientoUL) {
        this.fechaVencimientoUL = fechaVencimientoUL;
    }

    public String getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(String plazoDias) {
        this.plazoDias = plazoDias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Double getSaldoOriginal() {
        return saldoOriginal;
    }

    public void setSaldoOriginal(Double saldoOriginal) {
        this.saldoOriginal = saldoOriginal;
    }

    public Double getSaldoVigente() {
        return saldoVigente;
    }

    public void setSaldoVigente(Double saldoVigente) {
        this.saldoVigente = saldoVigente;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public Double getRatioCoberturaGara() {
        return ratioCoberturaGara;
    }

    public void setRatioCoberturaGara(Double ratioCoberturaGara) {
        this.ratioCoberturaGara = ratioCoberturaGara;
    }

    public String getRutaCartaBanco() {
        return rutaCartaBanco;
    }

    public void setRutaCartaBanco(String rutaCartaBanco) {
        this.rutaCartaBanco = rutaCartaBanco;
    }

    public Double getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(Double valMonFin) {
        this.valMonFin = valMonFin;
    }
    
    
}
