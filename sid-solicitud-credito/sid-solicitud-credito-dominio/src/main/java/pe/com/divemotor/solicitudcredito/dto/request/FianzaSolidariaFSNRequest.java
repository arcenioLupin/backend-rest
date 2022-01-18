/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegalFSN;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoRevision;
import pe.com.divemotor.solicitudcredito.dominio.Persona;

/**
 *
 * @author USER
 */
public class FianzaSolidariaFSNRequest extends BaseRequest {
    
    private int    codCanleg;
    private String codSoliCred;
    private String propietario;  
    private String tipoBien;   
    private String opinionLegal;
    private String observacion1;
    private String observacion2;
    private List<Persona> listaPersonas;
    //I Req. 87567 E2.1 ID 127 avilca 24.01.2020
    private List<DocumentoRevision> documentosLegalesPN;
    private String codSolcre;
    private int codDocrev;
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
    
   //I Req. 87567 E2.1 ID 127 avilca 24.01.2020
    public List<DocumentoRevision> getDocumentosLegalesPN() {
        return documentosLegalesPN;
    }

    public void setDocumentosLegalesPN(List<DocumentoRevision> documentosLegalesPN) {
        this.documentosLegalesPN = documentosLegalesPN;
    }

    public String getCodSolcre() {
        return codSolcre;
    }

    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }
   //F Req. 87567 E2.1 ID 127 avilca 24.01.2020
}
