/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author ebarboza
 */
public class ActividadEtapaRequest extends BaseRequest {
    
    private String codActiCred;
    private String codEtapCred;
    private String desActiCred;
    private String indInactivo;
    private String codEstadoSoli;
    private String numOrden;
    private String fecCreaRegi;
    private String codUsuaCreaRegi;
    private String fecModiRegi;
    private String codUsuaModiRegi;

    public String getCodActiCred() {
        return codActiCred;
    }

    public void setCodActiCred(String codActiCred) {
        this.codActiCred = codActiCred;
    }

    public String getCodEtapCred() {
        return codEtapCred;
    }

    public void setCodEtapCred(String codEtapCred) {
        this.codEtapCred = codEtapCred;
    }

    public String getDesActiCred() {
        return desActiCred;
    }

    public void setDesActiCred(String desActiCred) {
        this.desActiCred = desActiCred;
    }

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }

    public String getCodEstadoSoli() {
        return codEstadoSoli;
    }

    public void setCodEstadoSoli(String codEstadoSoli) {
        this.codEstadoSoli = codEstadoSoli;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public String getFecCreaRegi() {
        return fecCreaRegi;
    }

    public void setFecCreaRegi(String fecCreaRegi) {
        this.fecCreaRegi = fecCreaRegi;
    }

    public String getCodUsuaCreaRegi() {
        return codUsuaCreaRegi;
    }

    public void setCodUsuaCreaRegi(String codUsuaCreaRegi) {
        this.codUsuaCreaRegi = codUsuaCreaRegi;
    }

    public String getFecModiRegi() {
        return fecModiRegi;
    }

    public void setFecModiRegi(String fecModiRegi) {
        this.fecModiRegi = fecModiRegi;
    }

    public String getCodUsuaModiRegi() {
        return codUsuaModiRegi;
    }

    public void setCodUsuaModiRegi(String codUsuaModiRegi) {
        this.codUsuaModiRegi = codUsuaModiRegi;
    }
    
    
    
}
