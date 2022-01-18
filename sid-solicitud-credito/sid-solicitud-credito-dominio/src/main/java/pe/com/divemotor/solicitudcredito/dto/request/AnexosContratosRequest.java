/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author USER
 */
public class AnexosContratosRequest extends BaseRequest {
    
    private String codSoliCred;
    private String codOperRel;
    //I Req. 87567 E2.1 ID## avilca 16/10/2020 
    private String url;
    private String tipoDoc;
   //F Req. 87567 E2.1 ID## avilca 16/10/2020 
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
       
}
