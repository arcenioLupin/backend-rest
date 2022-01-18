/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CheckDocumentos;

/**
 *
 * @author USER
 */
public class ListarCheckDocumentoProcedure extends BasePaginadoProcedure<CheckDocumentos>{
    private String codSolcre;
    private String codOpeleg;

    /**
     * @return the codSolcre
     */
    public String getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSolcre to set
     */
    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

    /**
     * @return the codOpeleg
     */
    public String getCodOpeleg() {
        return codOpeleg;
    }

    /**
     * @param codOpeleg the codOpeleg to set
     */
    public void setCodOpeleg(String codOpeleg) {
        this.codOpeleg = codOpeleg;
    }
    
    
}
