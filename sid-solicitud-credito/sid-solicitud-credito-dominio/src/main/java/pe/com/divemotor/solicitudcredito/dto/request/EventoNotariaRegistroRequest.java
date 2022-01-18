/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author ebarboza Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
 */
public class EventoNotariaRegistroRequest extends BaseRequest{
    
    private String codSoliCred;
    private String codOperRel;
    private String nroContrato;
    private String fecSuscCont;
    private String fecSuscAnex;
    private String fecSuscLetr;
    private String fecSuscGara;
    private String fecSuscAval;
    private String codEstado;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }
    
    public String getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(String nroContrato) {
        this.nroContrato = nroContrato;
    }

    public String getFecSuscCont() {
        return fecSuscCont;
    }

    public void setFecSuscCont(String fecSuscCont) {
        this.fecSuscCont = fecSuscCont;
    }

    public String getFecSuscAnex() {
        return fecSuscAnex;
    }

    public void setFecSuscAnex(String fecSuscAnex) {
        this.fecSuscAnex = fecSuscAnex;
    }

    public String getFecSuscLetr() {
        return fecSuscLetr;
    }

    public void setFecSuscLetr(String fecSuscLetr) {
        this.fecSuscLetr = fecSuscLetr;
    }

    public String getFecSuscGara() {
        return fecSuscGara;
    }

    public void setFecSuscGara(String fecSuscGara) {
        this.fecSuscGara = fecSuscGara;
    }

    public String getFecSuscAval() {
        return fecSuscAval;
    }

    public void setFecSuscAval(String fecSuscAval) {
        this.fecSuscAval = fecSuscAval;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }
    
    
}
