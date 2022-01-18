/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author jaltamirano
 */
public class SolicitudCreditoVO {

    private String codSoliCred;
    private String codOperRel;
    private String codOperOrig;
    private String codClie;
    private String codClieSap;

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

    public String getCodOperOrig() {
        return codOperOrig;
    }

    public void setCodOperOrig(String codOperOrig) {
        this.codOperOrig = codOperOrig;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodClieSap() {
        return codClieSap;
    }

    public void setCodClieSap(String codClieSap) {
        this.codClieSap = codClieSap;
    }

}
