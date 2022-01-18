/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

/**
 *
 * @author phramirez
 */
public class ReporteCronogramaExcelDataSource {

    private String nroLetras;
    private List<SimuladorCronograma> cronograma;
    private String totMonFin;
    private String totAmortizacion;
    private String totSegFin;
    private String totInteres;
    private String totCuotas;
    private Boolean hasSeguro;
    private Boolean hasCobranzas;
    private Boolean hasInteresMoratorio;
    private Boolean hasInteresCompensatorio;
    private Boolean hasCostoTraslado;

    public String getNroLetras() {
        return nroLetras;
    }

    public void setNroLetras(String nroLetras) {
        this.nroLetras = nroLetras;
    }

    public List<SimuladorCronograma> getCronograma() {
        return cronograma;
    }

    public void setCronograma(List<SimuladorCronograma> cronograma) {
        this.cronograma = cronograma;
    }

    public String getTotMonFin() {
        return totMonFin;
    }

    public void setTotMonFin(String totMonFin) {
        this.totMonFin = totMonFin;
    }

    public String getTotAmortizacion() {
        return totAmortizacion;
    }

    public void setTotAmortizacion(String totAmortizacion) {
        this.totAmortizacion = totAmortizacion;
    }

    public String getTotSegFin() {
        return totSegFin;
    }

    public void setTotSegFin(String totSegFin) {
        this.totSegFin = totSegFin;
    }

    public String getTotInteres() {
        return totInteres;
    }

    public void setTotInteres(String totInteres) {
        this.totInteres = totInteres;
    }

    public String getTotCuotas() {
        return totCuotas;
    }

    public void setTotCuotas(String totCuotas) {
        this.totCuotas = totCuotas;
    }

    public Boolean getHasSeguro() {
        return hasSeguro;
    }

    public void setHasSeguro(Boolean hasSeguro) {
        this.hasSeguro = hasSeguro;
    }

    public Boolean getHasCobranzas() {
        return hasCobranzas;
    }

    public void setHasCobranzas(Boolean hasCobranzas) {
        this.hasCobranzas = hasCobranzas;
    }

    public Boolean getHasInteresMoratorio() {
        return hasInteresMoratorio;
    }

    public void setHasInteresMoratorio(Boolean hasInteresMoratorio) {
        this.hasInteresMoratorio = hasInteresMoratorio;
    }

    public Boolean getHasInteresCompensatorio() {
        return hasInteresCompensatorio;
    }

    public void setHasInteresCompensatorio(Boolean hasInteresCompensatorio) {
        this.hasInteresCompensatorio = hasInteresCompensatorio;
    }

    public Boolean getHasCostoTraslado() {
        return hasCostoTraslado;
    }

    public void setHasCostoTraslado(Boolean hasCostoTraslado) {
        this.hasCostoTraslado = hasCostoTraslado;
    }

}
