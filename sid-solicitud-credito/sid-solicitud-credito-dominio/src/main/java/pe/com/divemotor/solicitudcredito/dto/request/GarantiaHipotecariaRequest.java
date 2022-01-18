/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegalSolicitado;
import pe.com.divemotor.solicitudcredito.dominio.Persona;

/**
 *
 * @author USER
 */
public class GarantiaHipotecariaRequest extends BaseRequest {
    
    private int    codCanleg;
    private String codSoliCred;
    private String tipoPersona;
    private String propietario;
    private String ubicacion;
    private String areaMetro;
    private String tipMedida;
    private String parRegistral;
    private String sedRegistral;
    private String asiento;   
    private String tipoBien;   
    private String opinionLegal;
    private String observacion1;
    private String observacion2;
    private List<Persona> listaPersonas;
    private List<DocumentoLegalSolicitado> listaDocumentosLegales;

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

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAreaMetro() {
        return areaMetro;
    }

    public void setAreaMetro(String areaMetro) {
        this.areaMetro = areaMetro;
    }

    public String getTipMedida() {
        return tipMedida;
    }

    public void setTipMedida(String tipMedida) {
        this.tipMedida = tipMedida;
    }

    public String getParRegistral() {
        return parRegistral;
    }

    public void setParRegistral(String parRegistral) {
        this.parRegistral = parRegistral;
    }

    public String getSedRegistral() {
        return sedRegistral;
    }

    public void setSedRegistral(String sedRegistral) {
        this.sedRegistral = sedRegistral;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
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

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public List<DocumentoLegalSolicitado> getListaDocumentosLegales() {
        return listaDocumentosLegales;
    }

    public void setListaDocumentosLegales(List<DocumentoLegalSolicitado> listaDocumentosLegales) {
        this.listaDocumentosLegales = listaDocumentosLegales;
    }
    
    
    
}
