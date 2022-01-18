/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SolicitudCreditoParam;

/**
 *
 * @author legutierrez
 */
public class ListarSolicitudCreditoParamProcedure extends BasePaginadoProcedure<SolicitudCreditoParam>{

    private String codCredSoli;

    public String getCodCredSoli() {
        return codCredSoli;
    }

    public void setCodCredSoli(String codCredSoli) {
        this.codCredSoli = codCredSoli;
    }

}
