/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author legutierrez
 */
public class FormatoRDLGarantiaMobiliaria {

    private String garantiaPropia;
    private String garantiaAjena;
    private String indTipoBien;
    private String otorgante;
    private String nroPlaca;

    public String getGarantiaPropia() {
        return garantiaPropia;
    }

    public void setGarantiaPropia(String garantiaPropia) {
        this.garantiaPropia = garantiaPropia;
    }

    public String getGarantiaAjena() {
        return garantiaAjena;
    }

    public void setGarantiaAjena(String garantiaAjena) {
        this.garantiaAjena = garantiaAjena;
    }

    public String getIndTipoBien() {
        return indTipoBien;
    }

    public void setIndTipoBien(String indTipoBien) {
        this.indTipoBien = indTipoBien;
    }

    public String getOtorgante() {
        return otorgante;
    }

    public void setOtorgante(String otorgante) {
        this.otorgante = otorgante;
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca = nroPlaca;
    }

}
