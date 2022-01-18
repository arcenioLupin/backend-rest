/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.FlujoCaja;

/**
 *
 * @author legutierrez
 */
public class ListarFlujoCajaProcedure extends BasePaginadoProcedure<FlujoCaja>{

    private String codCredSoli;
    private String codParamFc;

    public String getCodCredSoli() {
        return codCredSoli;
    }

    public void setCodCredSoli(String codCredSoli) {
        this.codCredSoli = codCredSoli;
    }

    public String getCodParamFc() {
        return codParamFc;
    }

    public void setCodParamFc(String codParamFc) {
        this.codParamFc = codParamFc;
    }

}
