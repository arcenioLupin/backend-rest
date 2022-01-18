/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class RegistrarFianzaSolidariaFSNProcedure extends BaseProcedure {
    
    private int    codCanleg;
    private String codSoliCred;
    private String propietario;
    private String tipoBien;
    private String nombrePersona;
    private String apPaternoPersona;
    private String apMaternoPersona;
    private String nombreConyuge;
    private String apPaternoConyuge;
    private String apMaternoConyuge;
    private String tipoDocPersona;
    private String nroDocPersona;
    private String tipoDocConyuge;
    private String nroDocConyuge;
    private String opinionLegal;
    private String observacion1;
    private String observacion2;
    private int codCanlegOut; 
    //I Req. 87567 E2.1 ID 127 avilca 24.01.2020
    private int codDocrev;
    private int codDocrevOut;
    //F Req. 87567 E2.1 ID 127 avilca 24.01.2020
    public int getCodCanleg() {
        return codCanleg;
    }

    public void setCodCanleg(int codCanleg) {
        this.codCanleg = codCanleg;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApPaternoPersona() {
        return apPaternoPersona;
    }

    public void setApPaternoPersona(String apPaternoPersona) {
        this.apPaternoPersona = apPaternoPersona;
    }

    public String getApMaternoPersona() {
        return apMaternoPersona;
    }

    public void setApMaternoPersona(String apMaternoPersona) {
        this.apMaternoPersona = apMaternoPersona;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public String getApPaternoConyuge() {
        return apPaternoConyuge;
    }

    public void setApPaternoConyuge(String apPaternoConyuge) {
        this.apPaternoConyuge = apPaternoConyuge;
    }

    public String getApMaternoConyuge() {
        return apMaternoConyuge;
    }

    public void setApMaternoConyuge(String apMaternoConyuge) {
        this.apMaternoConyuge = apMaternoConyuge;
    }

    public String getTipoDocPersona() {
        return tipoDocPersona;
    }

    public void setTipoDocPersona(String tipoDocPersona) {
        this.tipoDocPersona = tipoDocPersona;
    }

    public String getNroDocPersona() {
        return nroDocPersona;
    }

    public void setNroDocPersona(String nroDocPersona) {
        this.nroDocPersona = nroDocPersona;
    }

    public String getTipoDocConyuge() {
        return tipoDocConyuge;
    }

    public void setTipoDocConyuge(String tipoDocConyuge) {
        this.tipoDocConyuge = tipoDocConyuge;
    }

    public String getNroDocConyuge() {
        return nroDocConyuge;
    }

    public void setNroDocConyuge(String nroDocConyuge) {
        this.nroDocConyuge = nroDocConyuge;
    }

    public String getOpinionLegal() {
        return opinionLegal;
    }

    public void setOpinionLegal(String opinionLegal) {
        this.opinionLegal = opinionLegal;
    }

    public String getObservacion1() {
        return observacion1;
    }

    public void setObservacion1(String observacion1) {
        this.observacion1 = observacion1;
    }

    public String getObservacion2() {
        return observacion2;
    }

    public void setObservacion2(String observacion2) {
        this.observacion2 = observacion2;
    }

    public int getCodCanlegOut() {
        return codCanlegOut;
    }

    public void setCodCanlegOut(int codCanlegOut) {
        this.codCanlegOut = codCanlegOut;
    }

 //I Req. 87567 E2.1 ID 127 avilca 24.01.2020   
    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }

    public int getCodDocrevOut() {
        return codDocrevOut;
    }

    public void setCodDocrevOut(int codDocrevOut) {
        this.codDocrevOut = codDocrevOut;
    } 
//F Req. 87567 E2.1 ID 127 avilca 24.01.2020    
}
