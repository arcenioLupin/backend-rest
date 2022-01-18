/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author jaltamirano
 */
public class ActualizarProyeParamPresuProcedure extends BaseProcedure {

    private Long id;
    private String codTipoVta;
    private String codAreaVta;
    private Long codZona;
    private Long anio;
    private Long mes;
    private Double valorYTD;
    private Double valorReal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCodZona() {
        return codZona;
    }

    public void setCodZona(Long codZona) {
        this.codZona = codZona;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public Double getValorYTD() {
        return valorYTD;
    }

    public void setValorYTD(Double valorYTD) {
        this.valorYTD = valorYTD;
    }

    public Double getValorReal() {
        return valorReal;
    }

    public void setValorReal(Double valorReal) {
        this.valorReal = valorReal;
    }

}
