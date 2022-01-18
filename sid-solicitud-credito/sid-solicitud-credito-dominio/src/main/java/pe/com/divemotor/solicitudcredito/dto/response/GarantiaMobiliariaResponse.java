/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegalSolicitado;

/**
 *
 * @author USER
 */
public class GarantiaMobiliariaResponse extends BaseResponse {
    
    private int codCanlegOut;
    private int codDanlegOut;
    private List<DocumentoLegalSolicitado> listCodDanlegOut;

    public int getCodCanlegOut() {
        return codCanlegOut;
    }

    public void setCodCanlegOut(int codCanlegOut) {
        this.codCanlegOut = codCanlegOut;
    }

    public int getCodDanlegOut() {
        return codDanlegOut;
    }

    public void setCodDanlegOut(int codDanlegOut) {
        this.codDanlegOut = codDanlegOut;
    }

    public List<DocumentoLegalSolicitado> getListCodDanlegOut() {
        return listCodDanlegOut;
    }

    public void setListCodDanlegOut(List<DocumentoLegalSolicitado> listCodDanlegOut) {
        this.listCodDanlegOut = listCodDanlegOut;
    }   
    
}
