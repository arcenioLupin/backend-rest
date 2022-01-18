/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.cliente;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author jaltamirano
 */
public class ActualizarGarantiaProcedure extends BaseProcedure {

    private String codSoliCred;
    private String codGarantia;
    private String codClie;
    private String codCia;
    private String codClieSap;
    private String codOperacion;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodGarantia() {
        return codGarantia;
    }

    public void setCodGarantia(String codGarantia) {
        this.codGarantia = codGarantia;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getCodClieSap() {
        return codClieSap;
    }

    public void setCodClieSap(String codClieSap) {
        this.codClieSap = codClieSap;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

}
