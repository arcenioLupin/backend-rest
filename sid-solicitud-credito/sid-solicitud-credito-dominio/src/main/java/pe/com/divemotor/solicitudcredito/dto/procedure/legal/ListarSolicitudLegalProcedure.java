/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SolicitudLegal;

/**
 *
 * @author USER
 */
public class ListarSolicitudLegalProcedure extends BasePaginadoProcedure<SolicitudLegal>{
    private String codSoliCred;

    /**
     * @return the codSoliCred
     */
    public String getCodSoliCred() {
        return codSoliCred;
    }

    /**
     * @param codSoliCred the codSoliCred to set
     */
    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }
    
    
}
