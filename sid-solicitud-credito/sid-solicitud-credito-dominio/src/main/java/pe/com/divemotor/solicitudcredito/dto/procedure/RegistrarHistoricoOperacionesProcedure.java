/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author mbardales
 */
public class RegistrarHistoricoOperacionesProcedure extends BaseProcedure {

    private Integer codCredSoliHist;
    private String codCredSoli;
    private String codCia;
    private String codTipoCred;
    private String codOper;
    private String codMoneda;
    private double valMontoCred;
    private Integer canLetras;
    private double valTea;
    private double valSaldo;
    private String fecUltVenc;
    private String codEstadoOp;
    private String fecEmiOp;
    private double valPorcCi;
    private double valValGar;
    private double valPorcRatGar;
    private double valDiasMaxVenc;//<I Req. 87567 E2.1 ID## avilca 11/02/2021>
    private double valDiasVencProm;//<I Req. 87567 E2.1 ID## avilca 11/02/2021>
    private String codClie;

    public Integer getCodCredSoliHist() {
        return codCredSoliHist;
    }

    public void setCodCredSoliHist(Integer codCredSoliHist) {
        this.codCredSoliHist = codCredSoliHist;
    }

    public String getCodCredSoli() {
        return codCredSoli;
    }

    public void setCodCredSoli(String codCredSoli) {
        this.codCredSoli = codCredSoli;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getCodTipoCred() {
        return codTipoCred;
    }

    public void setCodTipoCred(String codTipoCred) {
        this.codTipoCred = codTipoCred;
    }

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public double getValMontoCred() {
        return valMontoCred;
    }

    public void setValMontoCred(double valMontoCred) {
        this.valMontoCred = valMontoCred;
    }

    public Integer getCanLetras() {
        return canLetras;
    }

    public void setCanLetras(Integer canLetras) {
        this.canLetras = canLetras;
    }

    public double getValTea() {
        return valTea;
    }

    public void setValTea(double valTea) {
        this.valTea = valTea;
    }

    public double getValSaldo() {
        return valSaldo;
    }

    public void setValSaldo(double valSaldo) {
        this.valSaldo = valSaldo;
    }

    public String getFecUltVenc() {
        return fecUltVenc;
    }

    public void setFecUltVenc(String fecUltVenc) {
        this.fecUltVenc = fecUltVenc;
    }

    public String getCodEstadoOp() {
        return codEstadoOp;
    }

    public void setCodEstadoOp(String codEstadoOp) {
        this.codEstadoOp = codEstadoOp;
    }

    public String getFecEmiOp() {
        return fecEmiOp;
    }

    public void setFecEmiOp(String fecEmiOp) {
        this.fecEmiOp = fecEmiOp;
    }

    public double getValPorcCi() {
        return valPorcCi;
    }

    public void setValPorcCi(double valPorcCi) {
        this.valPorcCi = valPorcCi;
    }

    public double getValValGar() {
        return valValGar;
    }

    public void setValValGar(double valValGar) {
        this.valValGar = valValGar;
    }

    public double getValPorcRatGar() {
        return valPorcRatGar;
    }

    public void setValPorcRatGar(double valPorcRatGar) {
        this.valPorcRatGar = valPorcRatGar;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public double getValDiasMaxVenc() {
        return valDiasMaxVenc;
    }

    public void setValDiasMaxVenc(double valDiasMaxVenc) {
        this.valDiasMaxVenc = valDiasMaxVenc;
    }

    public double getValDiasVencProm() {
        return valDiasVencProm;
    }

    public void setValDiasVencProm(double valDiasVencProm) {
        this.valDiasVencProm = valDiasVencProm;
    }

}
