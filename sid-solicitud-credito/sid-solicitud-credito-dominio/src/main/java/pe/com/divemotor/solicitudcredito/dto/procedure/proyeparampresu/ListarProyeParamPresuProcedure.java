/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ProyeParamPresu;

/**
 *
 * @author jaltamirano
 */
public class ListarProyeParamPresuProcedure extends BasePaginadoProcedure<ProyeParamPresu> {

    private String codTipoVta;
    private String codAreaVta;
    private String codZona;
    private String periodo;

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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
