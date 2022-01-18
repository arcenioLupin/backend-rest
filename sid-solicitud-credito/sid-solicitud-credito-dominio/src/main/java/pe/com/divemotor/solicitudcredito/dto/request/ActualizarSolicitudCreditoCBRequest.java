/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

/**
 *
 * @author jaltamirano
 */
public class ActualizarSolicitudCreditoCBRequest {

    private String codSoliCred;
    private String codBanco;
    private String txtOficBanc;
    private String numFax;
    private String fecAprobCartBan;
    private String codMoneCartBanc;
    private double valMoneAprobBanc;
    private String txtNombEjecBanc;
    private String txtRutaCartBanc;
    private String numTeleFijoEjec;
    private String numCeluEjec;

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

    public String getCodMoneCartBanc() {
        return codMoneCartBanc;
    }

    public void setCodMoneCartBanc(String codMoneCartBanc) {
        this.codMoneCartBanc = codMoneCartBanc;
    }

    public double getValMoneAprobBanc() {
        return valMoneAprobBanc;
    }

    public void setValMoneAprobBanc(double valMoneAprobBanc) {
        this.valMoneAprobBanc = valMoneAprobBanc;
    }

    public String getTxtNombEjecBanc() {
        return txtNombEjecBanc;
    }

    public void setTxtNombEjecBanc(String txtNombEjecBanc) {
        this.txtNombEjecBanc = txtNombEjecBanc;
    }

    public String getTxtRutaCartBanc() {
        return txtRutaCartBanc;
    }

    public void setTxtRutaCartBanc(String txtRutaCartBanc) {
        this.txtRutaCartBanc = txtRutaCartBanc;
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

}
