/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author jaltamirano
 */
public class ProyeccionRequest extends BaseRequest {

    private String codigo;
    private String codTipoVta;
    private String codAreaVta;
    private String codZona;
    private String anio;
    private String mes;
    private String valorYTD;
    private String valorReal;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodTipoVta() {
        return codTipoVta;
    }

    public void setCodTipoVta(String codTipoVta) {
        this.codTipoVta = codTipoVta;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getValorYTD() {
        return valorYTD;
    }

    public void setValorYTD(String valorYTD) {
        this.valorYTD = valorYTD;
    }

    public String getValorReal() {
        return valorReal;
    }

    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }

}
