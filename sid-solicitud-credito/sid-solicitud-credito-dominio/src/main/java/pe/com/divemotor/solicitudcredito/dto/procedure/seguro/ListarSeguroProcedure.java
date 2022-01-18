/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Seguro;


/**
 *
 * @author Mgrasso
 */
public class ListarSeguroProcedure extends BasePaginadoProcedure<Seguro>{

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
