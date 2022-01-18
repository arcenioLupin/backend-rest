/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author legutierrez
 */
public class ListaSolicitudCreditoRequest extends BaseRequest {

    private String codSoliCred;
    private String nroProforma;
    private String fecIni;
    private String fecFin;
    private List<String> listAreaVta;
    private List<String> listTipSoliCred;
    private String codClie;
    private String codPersSoli;
    private String codRespFina;
    private String codEstado;
    private List<String> listCodEmpr;
    private List<String> listCodZona;
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

    public List<String> getListAreaVta() {
        return listAreaVta;
    }

    public void setListAreaVta(List<String> listAreaVta) {
        this.listAreaVta = listAreaVta;
    }

    public List<String> getListTipSoliCred() {
        return listTipSoliCred;
    }

    public void setListTipSoliCred(List<String> listTipSoliCred) {
        this.listTipSoliCred = listTipSoliCred;
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

    public List<String> getListCodEmpr() {
        return listCodEmpr;
    }

    public void setListCodEmpr(List<String> listCodEmpr) {
        this.listCodEmpr = listCodEmpr;
    }

    public List<String> getListCodZona() {
        return listCodZona;
    }

    public void setListCodZona(List<String> listCodZona) {
        this.listCodZona = listCodZona;
    }
    
    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

}
