/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.generico.dto.BaseResponse;

/**
 *
 * @author USER
 */
public class SolicitudLegalResponse extends BaseResponse{
    
    private int codSolcre;

    /**
     * @return the codSolcre
     */
    public int getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSolcre to set
     */
    public void setCodSolcre(int codSolcre) {
        this.codSolcre = codSolcre;
    }
    
    
}
