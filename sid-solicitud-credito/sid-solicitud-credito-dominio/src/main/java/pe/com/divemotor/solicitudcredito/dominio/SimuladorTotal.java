/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author phramirez
 */
public class SimuladorTotal {

    private Double totMonFin;
    private Double totAmortizacion;
    private Double totSegFin;
    private Double totInteres;
    private Double totCuotas;

    public Double getTotMonFin() {
        return totMonFin;
    }

    public void setTotMonFin(Double totMonFin) {
        this.totMonFin = totMonFin;
    }

    public Double getTotAmortizacion() {
        return totAmortizacion;
    }

    public void setTotAmortizacion(Double totAmortizacion) {
        this.totAmortizacion = totAmortizacion;
    }

    public Double getTotSegFin() {
        return totSegFin;
    }

    public void setTotSegFin(Double totSegFin) {
        this.totSegFin = totSegFin;
    }

    public Double getTotInteres() {
        return totInteres;
    }

    public void setTotInteres(Double totInteres) {
        this.totInteres = totInteres;
    }

    public Double getTotCuotas() {
        return totCuotas;
    }

    public void setTotCuotas(Double totCuotas) {
        this.totCuotas = totCuotas;
    }

}
