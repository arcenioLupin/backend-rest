/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class InsertarResumenFinancieroMaturityProcedure extends BaseProcedure {
    
    private String codSoliCred;
    private String codcliente;
    private Integer valMatuAnoProy;
    private Integer indice;
    private String codmoneeeff;
    private double valmatuamordeudactu;
    private double valmatuamordeudnuev;
    private double valmatugastfinadeudactu;
    private double valmatugastfinadeudnuev;
    private double valmatuservdeud;
    private double valmatuebitdaproy;
    private double valmatucashflowproy;
    private double valmatufactebitdasdeu;
    private double valmatufactcashfsdeu;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public Integer getValMatuAnoProy() {
        return valMatuAnoProy;
    }

    public void setValMatuAnoProy(Integer valMatuAnoProy) {
        this.valMatuAnoProy = valMatuAnoProy;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getCodmoneeeff() {
        return codmoneeeff;
    }

    public void setCodmoneeeff(String codmoneeeff) {
        this.codmoneeeff = codmoneeeff;
    }

    public double getValmatuamordeudactu() {
        return valmatuamordeudactu;
    }

    public void setValmatuamordeudactu(double valmatuamordeudactu) {
        this.valmatuamordeudactu = valmatuamordeudactu;
    }

    public double getValmatuamordeudnuev() {
        return valmatuamordeudnuev;
    }

    public void setValmatuamordeudnuev(double valmatuamordeudnuev) {
        this.valmatuamordeudnuev = valmatuamordeudnuev;
    }

    public double getValmatugastfinadeudactu() {
        return valmatugastfinadeudactu;
    }

    public void setValmatugastfinadeudactu(double valmatugastfinadeudactu) {
        this.valmatugastfinadeudactu = valmatugastfinadeudactu;
    }

    public double getValmatugastfinadeudnuev() {
        return valmatugastfinadeudnuev;
    }

    public void setValmatugastfinadeudnuev(double valmatugastfinadeudnuev) {
        this.valmatugastfinadeudnuev = valmatugastfinadeudnuev;
    }

    public double getValmatuservdeud() {
        return valmatuservdeud;
    }

    public void setValmatuservdeud(double valmatuservdeud) {
        this.valmatuservdeud = valmatuservdeud;
    }

    public double getValmatuebitdaproy() {
        return valmatuebitdaproy;
    }

    public void setValmatuebitdaproy(double valmatuebitdaproy) {
        this.valmatuebitdaproy = valmatuebitdaproy;
    }

    public double getValmatucashflowproy() {
        return valmatucashflowproy;
    }

    public void setValmatucashflowproy(double valmatucashflowproy) {
        this.valmatucashflowproy = valmatucashflowproy;
    }

    public double getValmatufactebitdasdeu() {
        return valmatufactebitdasdeu;
    }

    public void setValmatufactebitdasdeu(double valmatufactebitdasdeu) {
        this.valmatufactebitdasdeu = valmatufactebitdasdeu;
    }

    public double getValmatufactcashfsdeu() {
        return valmatufactcashfsdeu;
    }

    public void setValmatufactcashfsdeu(double valmatufactcashfsdeu) {
        this.valmatufactcashfsdeu = valmatufactcashfsdeu;
    }
    
    
    
    
}
