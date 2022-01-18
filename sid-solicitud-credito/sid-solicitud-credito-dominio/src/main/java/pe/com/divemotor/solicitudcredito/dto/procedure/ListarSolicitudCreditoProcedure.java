/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SolicitudCredito;

/**
 *
 * @author legutierrez
 */
public class ListarSolicitudCreditoProcedure extends BasePaginadoProcedure<SolicitudCredito> {

    private String codSoliCred;
    private String nroProforma;
    private String fecIni;
    private String fecFin;
    private String codAreaVta;
    private String tipSoliCred;
    private String codClie;
    private String codPersSoli;
    private String codRespFina;
    private String codEstado;
    private String codEmpr;
    private String codZona;
    private String rucCliente;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNroProforma() {
        return nroProforma;
    }

    public void setNroProforma(String nroProforma) {
        this.nroProforma = nroProforma;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodPersSoli() {
        return codPersSoli;
    }

    public void setCodPersSoli(String codPersSoli) {
        this.codPersSoli = codPersSoli;
    }

    public String getCodRespFina() {
        return codRespFina;
    }

    public void setCodRespFina(String codRespFina) {
        this.codRespFina = codRespFina;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getCodEmpr() {
        return codEmpr;
    }

    public void setCodEmpr(String codEmpr) {
        this.codEmpr = codEmpr;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }    

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

}
