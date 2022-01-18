/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.fc;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseProcedure;
import pe.com.divemotor.solicitudcredito.dominio.FactorPorMesFlujoCaja;

/**
 *
 * @author mbardales
 */
public class RegistrarFactorPorMesProcedure extends BaseProcedure {

    private String codSoliCred;
    private String noCia;
    private Double factorConstanteFijoIngreso;
    private String indFacFijoVariableIngresos;
    private Double factorConstanteFijoEgreso;
    private String indFacFijoVariableEgresos;
    private String fecIniFactIngr;
    private String fecFinFactIngr;
    private String fecIniFactEgre;
    private String fecFinFactEgre;
    private List<FactorPorMesFlujoCaja> factoresPorMes;
    private String indiFlujCaja;
    private Integer cantRutas;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public Double getFactorConstanteFijoIngreso() {
        return factorConstanteFijoIngreso;
    }

    public void setFactorConstanteFijoIngreso(Double factorConstanteFijoIngreso) {
        this.factorConstanteFijoIngreso = factorConstanteFijoIngreso;
    }

    public String getIndFacFijoVariableIngresos() {
        return indFacFijoVariableIngresos;
    }

    public void setIndFacFijoVariableIngresos(String indFacFijoVariableIngresos) {
        this.indFacFijoVariableIngresos = indFacFijoVariableIngresos;
    }

    public Double getFactorConstanteFijoEgreso() {
        return factorConstanteFijoEgreso;
    }

    public void setFactorConstanteFijoEgreso(Double factorConstanteFijoEgreso) {
        this.factorConstanteFijoEgreso = factorConstanteFijoEgreso;
    }

    public String getIndFacFijoVariableEgresos() {
        return indFacFijoVariableEgresos;
    }

    public void setIndFacFijoVariableEgresos(String indFacFijoVariableEgresos) {
        this.indFacFijoVariableEgresos = indFacFijoVariableEgresos;
    }

    public String getFecIniFactIngr() {
        return fecIniFactIngr;
    }

    public void setFecIniFactIngr(String fecIniFactIngr) {
        this.fecIniFactIngr = fecIniFactIngr;
    }

    public String getFecFinFactIngr() {
        return fecFinFactIngr;
    }

    public void setFecFinFactIngr(String fecFinFactIngr) {
        this.fecFinFactIngr = fecFinFactIngr;
    }

    public String getFecIniFactEgre() {
        return fecIniFactEgre;
    }

    public void setFecIniFactEgre(String fecIniFactEgre) {
        this.fecIniFactEgre = fecIniFactEgre;
    }

    public String getFecFinFactEgre() {
        return fecFinFactEgre;
    }

    public void setFecFinFactEgre(String fecFinFactEgre) {
        this.fecFinFactEgre = fecFinFactEgre;
    }

    public List<FactorPorMesFlujoCaja> getFactoresPorMes() {
        return factoresPorMes;
    }

    public void setFactoresPorMes(List<FactorPorMesFlujoCaja> factoresPorMes) {
        this.factoresPorMes = factoresPorMes;
    }

    public String getIndiFlujCaja() {
        return indiFlujCaja;
    }

    public void setIndiFlujCaja(String indiFlujCaja) {
        this.indiFlujCaja = indiFlujCaja;
    }

    public Integer getCantRutas() {
        return cantRutas;
    }

    public void setCantRutas(Integer cantRutas) {
        this.cantRutas = cantRutas;
    }

}
