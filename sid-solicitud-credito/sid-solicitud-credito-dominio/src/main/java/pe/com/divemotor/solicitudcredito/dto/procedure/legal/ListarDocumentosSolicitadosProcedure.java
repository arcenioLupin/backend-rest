/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Documento;

/**
 *
 * @author USER
 */
public class ListarDocumentosSolicitadosProcedure extends BasePaginadoProcedure<Documento> {

    private String codSolcre;

    public String getCodSolcre() {
        return codSolcre;
    }

    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

}
