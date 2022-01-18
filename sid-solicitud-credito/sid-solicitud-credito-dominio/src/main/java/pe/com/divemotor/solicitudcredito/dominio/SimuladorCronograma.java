/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.io.Serializable;

/**
 *
 * @author phramirez
 */
public class SimuladorCronograma implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codNumeLetr;
    private String fecVenc;
    private Integer item;
    private Double saldoInicial;
    private Double capital;
    private Double interes;
    private Double cuota;
    private Double saldoFinal;
    private String fVcto;
    private Double igv;
    private Double seguro;
    private Double cobranzas;
    private Double interesMoratorio;
    private Double interesCompensatorio;
    private Double costoTraslado;
    
    private String numLetra;
    private Double igvSegVeh;

    public Integer getCodNumeLetr() {
        return codNumeLetr;
    }

    public void setCodNumeLetr(Integer codNumeLetr) {
        this.codNumeLetr = codNumeLetr;
    }

    public String getFecVenc() {
        return fecVenc;
    }

    public void setFecVenc(String fecVenc) {
        this.fecVenc = fecVenc;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
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

    public String getfVcto() {
        return fVcto;
    }

    public void setfVcto(String fVcto) {
        this.fVcto = fVcto;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

    public Double getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(Double cobranzas) {
        this.cobranzas = cobranzas;
    }

    public Double getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(Double interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public Double getInteresCompensatorio() {
        return interesCompensatorio;
    }

    public void setInteresCompensatorio(Double interesCompensatorio) {
        this.interesCompensatorio = interesCompensatorio;
    }

    public Double getCostoTraslado() {
        return costoTraslado;
    }

    public void setCostoTraslado(Double costoTraslado) {
        this.costoTraslado = costoTraslado;
    }

    /**
     * @return the numLetra
     */
    public String getNumLetra() {
        return numLetra;
    }

    /**
     * @param numLetra the numLetra to set
     */
    public void setNumLetra(String numLetra) {
        this.numLetra = numLetra;
    }

    /**
     * @return the igvSegVeh
     */
    public Double getIgvSegVeh() {
        return igvSegVeh;
    }

    /**
     * @param igvSegVeh the igvSegVeh to set
     */
    public void setIgvSegVeh(Double igvSegVeh) {
        this.igvSegVeh = igvSegVeh;
    }

    
    
    
}
