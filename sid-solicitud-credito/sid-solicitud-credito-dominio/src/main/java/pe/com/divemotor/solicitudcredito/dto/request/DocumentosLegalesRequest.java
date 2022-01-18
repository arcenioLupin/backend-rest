/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegal;

/**
 *
 * @author USER
 */
public class DocumentosLegalesRequest extends BaseRequest{
    
    private String codSolcre;
    private List<DocumentoLegal> listDocumentosLegalesJ;
    private List<DocumentoLegal> listDocumentosLegalesN;
    private List<DocumentoLegal> listDocumentosGarantiaI;
    private List<DocumentoLegal> listDocumentosGarantiaGM;
    private List<DocumentoLegal> listDocumentosAvalesN;
    private List<DocumentoLegal> listDocumentosAvalesJ;

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
     * @return the listDocumentosLegalesJ
     */
    public List<DocumentoLegal> getListDocumentosLegalesJ() {
        return listDocumentosLegalesJ;
    }

    /**
     * @param listDocumentosLegalesJ the listDocumentosLegalesJ to set
     */
    public void setListDocumentosLegalesJ(List<DocumentoLegal> listDocumentosLegalesJ) {
        this.listDocumentosLegalesJ = listDocumentosLegalesJ;
    }

    /**
     * @return the listDocumentosLegalesN
     */
    public List<DocumentoLegal> getListDocumentosLegalesN() {
        return listDocumentosLegalesN;
    }

    /**
     * @param listDocumentosLegalesN the listDocumentosLegalesN to set
     */
    public void setListDocumentosLegalesN(List<DocumentoLegal> listDocumentosLegalesN) {
        this.listDocumentosLegalesN = listDocumentosLegalesN;
    }

    /**
     * @return the listDocumentosGarantiaI
     */
    public List<DocumentoLegal> getListDocumentosGarantiaI() {
        return listDocumentosGarantiaI;
    }

    /**
     * @param listDocumentosGarantiaI the listDocumentosGarantiaI to set
     */
    public void setListDocumentosGarantiaI(List<DocumentoLegal> listDocumentosGarantiaI) {
        this.listDocumentosGarantiaI = listDocumentosGarantiaI;
    }

    /**
     * @return the listDocumentosGarantiaGM
     */
    public List<DocumentoLegal> getListDocumentosGarantiaGM() {
        return listDocumentosGarantiaGM;
    }

    /**
     * @param listDocumentosGarantiaGM the listDocumentosGarantiaGM to set
     */
    public void setListDocumentosGarantiaGM(List<DocumentoLegal> listDocumentosGarantiaGM) {
        this.listDocumentosGarantiaGM = listDocumentosGarantiaGM;
    }

    /** 
     * @return the listDocumentosAvalesN
     */
    public List<DocumentoLegal> getListDocumentosAvalesN() {
        return listDocumentosAvalesN;
    }

    /**
     * @param listDocumentosAvalesN the listDocumentosAvalesN to set
     */
    public void setListDocumentosAvalesN(List<DocumentoLegal> listDocumentosAvalesN) {
        this.listDocumentosAvalesN = listDocumentosAvalesN;
    }

    /**
     * @return the listDocumentosAvalesJ
     */
    public List<DocumentoLegal> getListDocumentosAvalesJ() {
        return listDocumentosAvalesJ;
    }

    /**
     * @param listDocumentosAvalesJ the listDocumentosAvalesJ to set
     */
    public void setListDocumentosAvalesJ(List<DocumentoLegal> listDocumentosAvalesJ) {
        this.listDocumentosAvalesJ = listDocumentosAvalesJ;
    }
    
    
}
