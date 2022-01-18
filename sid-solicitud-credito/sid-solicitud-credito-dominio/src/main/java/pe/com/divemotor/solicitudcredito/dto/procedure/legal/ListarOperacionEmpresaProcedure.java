/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.OperacionEmpresa;

/**
 *
 * @author USER
 */
public class ListarOperacionEmpresaProcedure extends BasePaginadoProcedure<OperacionEmpresa>{
    private String codSolcre;

    /**
     * @return the codSoliCred
     */
    public String getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSoliCred to set
     */
    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }
    
}
