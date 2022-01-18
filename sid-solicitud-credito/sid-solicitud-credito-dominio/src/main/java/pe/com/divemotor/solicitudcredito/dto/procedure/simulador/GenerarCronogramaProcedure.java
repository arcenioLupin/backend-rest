/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author phramirez
 */
public class GenerarCronogramaProcedure extends BaseProcedure {

    private String codSimu;
    private String codGruTipCred;
    private String codTipCred;
    private Double monVta;
    private Double porcCuoIni;
    private String periodicidad;
    private Double primaSeg;
    private Integer nroCuotas;
    private Integer plazMes;
    private Double porcCB;
    private String codGruTipPgra;
    private String codTipPgra;
    private Integer valDiasPgra;
    private Double valMonIntPgra;

    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }

    public String getCodGruTipCred() {
        return codGruTipCred;
    }

    public void setCodGruTipCred(String codGruTipCred) {
        this.codGruTipCred = codGruTipCred;
    }

    public String getCodTipCred() {
        return codTipCred;
    }

    public void setCodTipCred(String codTipCred) {
        this.codTipCred = codTipCred;
    }

    public Double getMonVta() {
        return monVta;
    }

    public void setMonVta(Double monVta) {
        this.monVta = monVta;
    }

    public Double getPorcCuoIni() {
        return porcCuoIni;
    }

    public void setPorcCuoIni(Double porcCuoIni) {
        this.porcCuoIni = porcCuoIni;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Double getPrimaSeg() {
        return primaSeg;
    }

    public void setPrimaSeg(Double primaSeg) {
        this.primaSeg = primaSeg;
    }

    public Integer getNroCuotas() {
        return nroCuotas;
    }

    public void setNroCuotas(Integer nroCuotas) {
        this.nroCuotas = nroCuotas;
    }

    public Integer getPlazMes() {
        return plazMes;
    }

    public void setPlazMes(Integer plazMes) {
        this.plazMes = plazMes;
    }

    public Double getPorcCB() {
        return porcCB;
    }

    public void setPorcCB(Double porcCB) {
        this.porcCB = porcCB;
    }

    public String getCodGruTipPgra() {
        return codGruTipPgra;
    }

    public void setCodGruTipPgra(String codGruTipPgra) {
        this.codGruTipPgra = codGruTipPgra;
    }

    public String getCodTipPgra() {
        return codTipPgra;
    }

    public void setCodTipPgra(String codTipPgra) {
        this.codTipPgra = codTipPgra;
    }

    public Integer getValDiasPgra() {
        return valDiasPgra;
    }

    public void setValDiasPgra(Integer valDiasPgra) {
        this.valDiasPgra = valDiasPgra;
    }

    public Double getValMonIntPgra() {
        return valMonIntPgra;
    }

    public void setValMonIntPgra(Double valMonIntPgra) {
        this.valMonIntPgra = valMonIntPgra;
    }

}
