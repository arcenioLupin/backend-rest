/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author legutierrez
 */
public class ActualizarGestionBancaria extends BaseProcedure {

    private String codSoliCred;
    private String codBanco;
    private double valMontFin;
    private String codMoneSoli;
    private double valMontSolGestBanc;
    private double porcGestBanc;
    private String fecIngrGestBanc;
    private String fecIngrRiesGestBanc;
    private String fecAprobCartBan;
    private String fecResuGestBanc;
    private String codEstaGestBanc;
    private String txtObseGestBanc;
    private String codUsuario;//<Req. 87567 E2.1 ID## avilca 03/12/2020>

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public double getValMontFin() {
        return valMontFin;
    }

    public void setValMontFin(double valMontFin) {
        this.valMontFin = valMontFin;
    }

    public String getCodMoneSoli() {
        return codMoneSoli;
    }

    public void setCodMoneSoli(String codMoneSoli) {
        this.codMoneSoli = codMoneSoli;
    }

    public double getValMontSolGestBanc() {
        return valMontSolGestBanc;
    }

    public void setValMontSolGestBanc(double valMontSolGestBanc) {
        this.valMontSolGestBanc = valMontSolGestBanc;
    }

    public double getPorcGestBanc() {
        return porcGestBanc;
    }

    public void setPorcGestBanc(double porcGestBanc) {
        this.porcGestBanc = porcGestBanc;
    }

    public String getFecIngrGestBanc() {
        return fecIngrGestBanc;
    }

    public void setFecIngrGestBanc(String fecIngrGestBanc) {
        this.fecIngrGestBanc = fecIngrGestBanc;
    }

    public String getFecIngrRiesGestBanc() {
        return fecIngrRiesGestBanc;
    }

    public void setFecIngrRiesGestBanc(String fecIngrRiesGestBanc) {
        this.fecIngrRiesGestBanc = fecIngrRiesGestBanc;
    }

    public String getFecAprobCartBan() {
        return fecAprobCartBan;
    }

    public void setFecAprobCartBan(String fecAprobCartBan) {
        this.fecAprobCartBan = fecAprobCartBan;
    }

    public String getFecResuGestBanc() {
        return fecResuGestBanc;
    }

    public void setFecResuGestBanc(String fecResuGestBanc) {
        this.fecResuGestBanc = fecResuGestBanc;
    }

    public String getCodEstaGestBanc() {
        return codEstaGestBanc;
    }

    public void setCodEstaGestBanc(String codEstaGestBanc) {
        this.codEstaGestBanc = codEstaGestBanc;
    }

    public String getTxtObseGestBanc() {
        return txtObseGestBanc;
    }

    public void setTxtObseGestBanc(String txtObseGestBanc) {
        this.txtObseGestBanc = txtObseGestBanc;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }


}
