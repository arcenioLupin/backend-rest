/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.PersonaFacultada;

/**
 *
 * @author USER
 */
public class ListarPersonaFacultadaSolcreProcedure extends BasePaginadoProcedure<PersonaFacultada>{
    private String codDocrev;

    /**
     * @return the codDocrev
     */
    public String getCodDocrev() {
        return codDocrev;
    }

    /**
     * @param codDocrev the codDocrev to set
     */
    public void setCodDocrev(String codDocrev) {
        this.codDocrev = codDocrev;
    }
    
    
}
