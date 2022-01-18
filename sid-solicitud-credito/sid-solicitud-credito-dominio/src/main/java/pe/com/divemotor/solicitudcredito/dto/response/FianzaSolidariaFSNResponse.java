/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegalFSN;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoRevision;

/**
 *
 * @author USER
 */
public class FianzaSolidariaFSNResponse extends BaseResponse {
    
        private int codCanlegOut;
        private int codDanlegOut;
        private int codCanleg;
        private List<DocumentoLegalFSN> listCodDanlegOut;
        //I Req. 87567 E2.1 ID 127 avilca 24.01.2020
        private List<DocumentoRevision> documentosLegalesPN;
        private int codDocrevOut;
        //F Req. 87567 E2.1 ID 127 avilca 24.01.2020

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

    public List<DocumentoLegalFSN> getListCodDanlegOut() {
        return listCodDanlegOut;
    }

    public void setListCodDanlegOut(List<DocumentoLegalFSN> listCodDanlegOut) {
        this.listCodDanlegOut = listCodDanlegOut;
    }

    public int getCodCanleg() {
        return codCanleg;
    }

    public void setCodCanleg(int codCanleg) {
        this.codCanleg = codCanleg;
    }
//I Req. 87567 E2.1 ID 127 avilca 24.01.2020
    public List<DocumentoRevision> getDocumentosLegalesPN() {
        return documentosLegalesPN;
    }

    public void setDocumentosLegalesPN(List<DocumentoRevision> documentosLegalesPN) {
        this.documentosLegalesPN = documentosLegalesPN;
    }

    public int getCodDocrevOut() {
        return codDocrevOut;
    }

    public void setCodDocrevOut(int codDocrevOut) {
        this.codDocrevOut = codDocrevOut;
    }
  //F Req. 87567 E2.1 ID 127 avilca 24.01.2020        
}
