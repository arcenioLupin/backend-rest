/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SolicitudCreditoCB;

/**
 *
 * @author jaltamirano
 */
public class ListarSolicitudCreditoCBProcedure extends BasePaginadoProcedure<SolicitudCreditoCB> {

    private String codSoliCred;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

}
