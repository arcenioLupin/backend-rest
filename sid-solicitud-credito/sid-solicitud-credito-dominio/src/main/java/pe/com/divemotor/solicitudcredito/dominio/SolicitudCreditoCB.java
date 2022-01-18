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
public class SolicitudCreditoCB {

    private String codSoliCred;
    private String codBanco;
    private String txtOficBanc;
    private String numFax;
    private String fecAprobCartBan;
    private String codMoneCartBan;
    private String valMoneAprobBanc;
    private String txtNombEjecBanc;
    private String txtRutaCartBan;
    private String numTeleFijoEjec;
    private String numCeluEjec;
    //<I Req. 87567 E2.1 Carta Banco avilca 21/02/2020>
    private String valMontSolGestBanc;
    private String direccionBanco;
    private String telefonoBanco;
    //<F Req. 87567 E2.1 Carta Banco avilca 21/02/2020>
    //<I Req. 87567 E2.1 Carta Banco avilca 18/05/2020>
    private String valMontoAprobado;
    //<F Req. 87567 E2.1 Carta Banco avilca 18/05/2020>
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getTxtOficBanc() {
        return txtOficBanc;
    }

    public void setTxtOficBanc(String txtOficBanc) {
        this.txtOficBanc = txtOficBanc;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }

    public String getFecAprobCartBan() {
        return fecAprobCartBan;
    }

    public void setFecAprobCartBan(String fecAprobCartBan) {
        this.fecAprobCartBan = fecAprobCartBan;
    }

    public String getCodMoneCartBan() {
        return codMoneCartBan;
    }

    public void setCodMoneCartBan(String codMoneCartBan) {
        this.codMoneCartBan = codMoneCartBan;
    }

    public String getValMoneAprobBanc() {
        return valMoneAprobBanc;
    }

    public void setValMoneAprobBanc(String valMoneAprobBanc) {
        this.valMoneAprobBanc = valMoneAprobBanc;
    }

    public String getTxtNombEjecBanc() {
        return txtNombEjecBanc;
    }

    public void setTxtNombEjecBanc(String txtNombEjecBanc) {
        this.txtNombEjecBanc = txtNombEjecBanc;
    }

    public String getTxtRutaCartBan() {
        return txtRutaCartBan;
    }

    public void setTxtRutaCartBan(String txtRutaCartBan) {
        this.txtRutaCartBan = txtRutaCartBan;
    }

    public String getNumTeleFijoEjec() {
        return numTeleFijoEjec;
    }

    public void setNumTeleFijoEjec(String numTeleFijoEjec) {
        this.numTeleFijoEjec = numTeleFijoEjec;
    }

    public String getNumCeluEjec() {
        return numCeluEjec;
    }

    public void setNumCeluEjec(String numCeluEjec) {
        this.numCeluEjec = numCeluEjec;
    }
   //<I Req. 87567 E2.1 Carta Banco avilca 21/02/2020>
    public String getValMontSolGestBanc() {
        return valMontSolGestBanc;
    }

    public void setValMontSolGestBanc(String valMontSolGestBanc) {
        this.valMontSolGestBanc = valMontSolGestBanc;
    }

    public String getDireccionBanco() {
        return direccionBanco;
    }

    public void setDireccionBanco(String direccionBanco) {
        this.direccionBanco = direccionBanco;
    }

    public String getTelefonoBanco() {
        return telefonoBanco;
    }

    public void setTelefonoBanco(String telefonoBanco) {
        this.telefonoBanco = telefonoBanco;
    }
 //<F Req. 87567 E2.1 Carta Banco avilca 21/02/2020>

    public String getValMontoAprobado() {
        return valMontoAprobado;
    }

    public void setValMontoAprobado(String valMontoAprobado) {
        this.valMontoAprobado = valMontoAprobado;
    }

}
