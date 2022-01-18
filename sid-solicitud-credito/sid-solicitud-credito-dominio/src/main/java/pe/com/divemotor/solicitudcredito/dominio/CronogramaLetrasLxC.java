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
public class CronogramaLetrasLxC {

    private String noLetra;
    private String nroSec;
    private String indCuotaExt;
    private Double saldoInicial;
    private Double amortizacion;
    private Double intereses;
    private Double igv;
    private Double isc;
    private Double seguro;
    private Double cuota;
    private Double saldoFinal;
    private String fechaVenc;

    public String getNoLetra() {
        return noLetra;
    }

    public void setNoLetra(String noLetra) {
        this.noLetra = noLetra;
    }

    public String getNroSec() {
        return nroSec;
    }

    public void setNroSec(String nroSec) {
        this.nroSec = nroSec;
    }

    public String getIndCuotaExt() {
        return indCuotaExt;
    }

    public void setIndCuotaExt(String indCuotaExt) {
        this.indCuotaExt = indCuotaExt;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(Double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public Double getIntereses() {
        return intereses;
    }

    public void setIntereses(Double intereses) {
        this.intereses = intereses;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getIsc() {
        return isc;
    }

    public void setIsc(Double isc) {
        this.isc = isc;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(String fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

}
