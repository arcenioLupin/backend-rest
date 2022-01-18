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
public class SolicitudCreditoSN {

    private String codSoliCred;
    private String txt_nro_contrato;
    private String fec_susc_anex;
    private String fec_susc_cont;
    private String fec_susc_letr;
    private String fec_sus_gara;
    private String fec_sus_aval;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTxt_nro_contrato() {
        return txt_nro_contrato;
    }

    public void setTxt_nro_contrato(String txt_nro_contrato) {
        this.txt_nro_contrato = txt_nro_contrato;
    }

    public String getFec_susc_anex() {
        return fec_susc_anex;
    }

    public void setFec_susc_anex(String fec_susc_anex) {
        this.fec_susc_anex = fec_susc_anex;
    }

    public String getFec_susc_cont() {
        return fec_susc_cont;
    }

    public void setFec_susc_cont(String fec_susc_cont) {
        this.fec_susc_cont = fec_susc_cont;
    }

    public String getFec_susc_letr() {
        return fec_susc_letr;
    }

    public void setFec_susc_letr(String fec_susc_letr) {
        this.fec_susc_letr = fec_susc_letr;
    }

    public String getFec_sus_gara() {
        return fec_sus_gara;
    }

    public void setFec_sus_gara(String fec_sus_gara) {
        this.fec_sus_gara = fec_sus_gara;
    }

    public String getFec_sus_aval() {
        return fec_sus_aval;
    }

    public void setFec_sus_aval(String fec_sus_aval) {
        this.fec_sus_aval = fec_sus_aval;
    }

}
