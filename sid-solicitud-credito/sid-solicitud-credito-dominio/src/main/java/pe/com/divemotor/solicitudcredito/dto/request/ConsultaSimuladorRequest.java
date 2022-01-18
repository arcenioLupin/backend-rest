package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

public class ConsultaSimuladorRequest extends BaseRequest {

    private String codSimu;
    private String codSoliCred;
    private String numProfVeh;
    private String tipSoliCred;
    private String codEmpr;
    private String codClie;
    private String codMoneda;
    private String flagDatos;

    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getCodEmpr() {
        return codEmpr;
    }

    public void setCodEmpr(String codEmpr) {
        this.codEmpr = codEmpr;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getFlagDatos() {
        return flagDatos;
    }

    public void setFlagDatos(String flagDatos) {
        this.flagDatos = flagDatos;
    }

}
