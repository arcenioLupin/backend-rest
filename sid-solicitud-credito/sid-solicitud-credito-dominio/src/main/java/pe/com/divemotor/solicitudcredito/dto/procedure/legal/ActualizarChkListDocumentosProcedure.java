/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class ActualizarChkListDocumentosProcedure extends BaseProcedure{
    
    private String codSolcre;
    private String codDocleg;
    private String indOblig;
    private String codEstleg;
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
     * @return the codDocleg
     */
    public String getCodDocleg() {
        return codDocleg;
    }

    /**
     * @param codDocleg the codDocleg to set
     */
    public void setCodDocleg(String codDocleg) {
        this.codDocleg = codDocleg;
    }

    /**
     * @return the indOblig
     */
    public String getIndOblig() {
        return indOblig;
    }

    /**
     * @param indOblig the indOblig to set
     */
    public void setIndOblig(String indOblig) {
        this.indOblig = indOblig;
    }

    /**
     * @return the codEstleg
     */
    public String getCodEstleg() {
        return codEstleg;
    }

    /**
     * @param codEstleg the codEstleg to set
     */
    public void setCodEstleg(String codEstleg) {
        this.codEstleg = codEstleg;
    }
    
    
    
}
