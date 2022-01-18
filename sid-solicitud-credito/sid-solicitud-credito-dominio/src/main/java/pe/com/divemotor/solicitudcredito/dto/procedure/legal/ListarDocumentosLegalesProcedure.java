/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegal;

/**
 *
 * @author MGRASSO
 */
public class ListarDocumentosLegalesProcedure extends BasePaginadoProcedure<DocumentoLegal>{
    private String codSolcre;
    private String ordTitdoc;
    private String indTipoDocu;

    /**
     * @return the ordTitdoc
     */
    public String getOrdTitdoc() {
        return ordTitdoc;
    }

    /**
     * @param ordTitdoc the ordTitdoc to set
     */
    public void setOrdTitdoc(String ordTitdoc) {
        this.ordTitdoc = ordTitdoc;
    }

    /**
     * @return the indTipoDocu
     */
    public String getIndTipoDocu() {
        return indTipoDocu;
    }

    /**
     * @param indTipoDocu the indTipoDocu to set
     */
    public void setIndTipoDocu(String indTipoDocu) {
        this.indTipoDocu = indTipoDocu;
    }

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
    
    
}
