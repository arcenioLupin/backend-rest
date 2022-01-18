/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;

/**
 *
 * @author USER
 */
public class DatosAnexos {
    
    private String  nomCia;
    private String  nomBanco;
    private String  marca;
    private String  modelo;
    private String  nomMoneda;
    private String  montoCi;
    private String  montoFin;
    private String  descMoneda;
    private String  montoLetrasFin;
    private String  montoLetrasCi;
    private String  numFactura;
    private String  tipoVeh;
    private String  numMotor;
    private String  numChasis;
    private String  numPlaca;
    private String montoGM;
    private String montoLetrasGM;
    private String valorGM;
    private String montoLetrasValorGM;
    private String tipSoliCred;
    private String codTipSoliCred;
    
    // PARA LEASING 
    private String detaLeasingUno;
    private String detaListFact;
    private String detaNotaCred;

    public String getNomCia() {
        return nomCia;
    }

    public void setNomCia(String nomCia) {
        this.nomCia = nomCia;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNomMoneda() {
        return nomMoneda;
    }

    public void setNomMoneda(String nomMoneda) {
        this.nomMoneda = nomMoneda;
    }

    public String getMontoCi() {
        return montoCi;
    }

    public void setMontoCi(String montoCi) {
        this.montoCi = montoCi;
    }

    public String getMontoFin() {
        return montoFin;
    }

    public void setMontoFin(String montoFin) {
        this.montoFin = montoFin;
    }

    public String getDescMoneda() {
        return descMoneda;
    }

    public void setDescMoneda(String descMoneda) {
        this.descMoneda = descMoneda;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getMontoLetrasFin() {
        return montoLetrasFin;
    }

    public void setMontoLetrasFin(String montoLetrasFin) {
        this.montoLetrasFin = montoLetrasFin;
    }

    public String getMontoLetrasCi() {
        return montoLetrasCi;
    }

    public void setMontoLetrasCi(String montoLetrasCi) {
        this.montoLetrasCi = montoLetrasCi;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getMontoGM() {
        return montoGM;
    }

    public void setMontoGM(String montoGM) {
        this.montoGM = montoGM;
    }

    public String getMontoLetrasGM() {
        return montoLetrasGM;
    }

    public void setMontoLetrasGM(String montoLetrasGM) {
        this.montoLetrasGM = montoLetrasGM;
    }

    public String getValorGM() {
        return valorGM;
    }

    public void setValorGM(String valorGM) {
        this.valorGM = valorGM;
    }

    public String getMontoLetrasValorGM() {
        return montoLetrasValorGM;
    }

    public void setMontoLetrasValorGM(String montoLetrasValorGM) {
        this.montoLetrasValorGM = montoLetrasValorGM;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getCodTipSoliCred() {
        return codTipSoliCred;
    }

    public void setCodTipSoliCred(String codTipSoliCred) {
        this.codTipSoliCred = codTipSoliCred;
    }

    /**
     * @return the detaLeasingUno
     */
    public String getDetaLeasingUno() {
        return detaLeasingUno;
    }

    /**
     * @param detaLeasingUno the detaLeasingUno to set
     */
    public void setDetaLeasingUno(String detaLeasingUno) {
        this.detaLeasingUno = detaLeasingUno;
    }

    /**
     * @return the detaListFact
     */
    public String getDetaListFact() {
        return detaListFact;
    }

    /**
     * @param detaListFact the detaListFact to set
     */
    public void setDetaListFact(String detaListFact) {
        this.detaListFact = detaListFact;
    }

    /**
     * @return the detaNotaCred
     */
    public String getDetaNotaCred() {
        return detaNotaCred;
    }

    /**
     * @param detaNotaCred the detaNotaCred to set
     */
    public void setDetaNotaCred(String detaNotaCred) {
        this.detaNotaCred = detaNotaCred;
    }

}
