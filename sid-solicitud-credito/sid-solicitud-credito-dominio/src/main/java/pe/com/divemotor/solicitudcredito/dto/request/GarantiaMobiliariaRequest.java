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
public class GarantiaMobiliariaRequest extends BaseRequest {
    
    private int    codCanleg;
    private String codSoliCred;
    private String tipoPersona;
    private String propietario;
    private String marca;
    private String placa;
    private String modelo;
    private String anio;
    private String tipoBien;   
    private String opinionLegal;
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

    public void setTipoPersona(String tipPersona) {
        this.tipoPersona = tipPersona;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
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
