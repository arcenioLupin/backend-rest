/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;

/**
 *
 * @author legutierrez
 */
public class ReporteFormatoRDLRefinanciamientoDataSource {

    private String nomEmpresa;
    private String codClie;
    private String nomPerso;
    private String numDocu;
    private String dirDomicilio;
    private String distrito;
    private String provincia;
    private String departamento;
    private List<ReporteFormatoRDLGarantiasDataSource> listaGarantias;
    private String valPorcTeaSigv;
    private String valPrimaSeg;
    private String canPlazMeses;
    private String indTipPerGra;
    private String canLetPerGra;
    private String canPlazMesesRestante;
    private String valLetraInicial;
    private String valLetraFinal;
    private String valTotalLetr;
    private String fecVencInicial;
    private String fecVencFinal;

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNomPerso() {
        return nomPerso;
    }

    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }

    public String getNumDocu() {
        return numDocu;
    }

    public void setNumDocu(String numDocu) {
        this.numDocu = numDocu;
    }

    public String getDirDomicilio() {
        return dirDomicilio;
    }

    public void setDirDomicilio(String dirDomicilio) {
        this.dirDomicilio = dirDomicilio;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<ReporteFormatoRDLGarantiasDataSource> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<ReporteFormatoRDLGarantiasDataSource> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }

    public String getValPorcTeaSigv() {
        return valPorcTeaSigv;
    }

    public void setValPorcTeaSigv(String valPorcTeaSigv) {
        this.valPorcTeaSigv = valPorcTeaSigv;
    }

    public String getValPrimaSeg() {
        return valPrimaSeg;
    }

    public void setValPrimaSeg(String valPrimaSeg) {
        this.valPrimaSeg = valPrimaSeg;
    }

    public String getCanPlazMeses() {
        return canPlazMeses;
    }

    public void setCanPlazMeses(String canPlazMeses) {
        this.canPlazMeses = canPlazMeses;
    }

    public String getIndTipPerGra() {
        return indTipPerGra;
    }

    public void setIndTipPerGra(String indTipPerGra) {
        this.indTipPerGra = indTipPerGra;
    }

    public String getCanLetPerGra() {
        return canLetPerGra;
    }

    public void setCanLetPerGra(String canLetPerGra) {
        this.canLetPerGra = canLetPerGra;
    }

    public String getCanPlazMesesRestante() {
        return canPlazMesesRestante;
    }

    public void setCanPlazMesesRestante(String canPlazMesesRestante) {
        this.canPlazMesesRestante = canPlazMesesRestante;
    }

    public String getValLetraInicial() {
        return valLetraInicial;
    }

    public void setValLetraInicial(String valLetraInicial) {
        this.valLetraInicial = valLetraInicial;
    }

    public String getValLetraFinal() {
        return valLetraFinal;
    }

    public void setValLetraFinal(String valLetraFinal) {
        this.valLetraFinal = valLetraFinal;
    }

    public String getValTotalLetr() {
        return valTotalLetr;
    }

    public void setValTotalLetr(String valTotalLetr) {
        this.valTotalLetr = valTotalLetr;
    }

    public String getFecVencInicial() {
        return fecVencInicial;
    }

    public void setFecVencInicial(String fecVencInicial) {
        this.fecVencInicial = fecVencInicial;
    }

    public String getFecVencFinal() {
        return fecVencFinal;
    }

    public void setFecVencFinal(String fecVencFinal) {
        this.fecVencFinal = fecVencFinal;
    }

}
