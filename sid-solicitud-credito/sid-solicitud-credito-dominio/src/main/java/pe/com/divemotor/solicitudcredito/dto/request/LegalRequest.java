/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author USER
 */
public class LegalRequest extends BaseRequest{
    
    private String codSoliCred;
    private String codSolcre;
    private String nroExpediente;
    private String nomPerso;
    private String codEstLeg;
    private String noCia;
    private String ordTitdoc;
    private String indTipoDocu;
    private String codTipope;
    private String codDocrev;
    private String codCanleg;
    //I Req. 87567 E2.1 ID 127 avilca 21/01/2020
    private String codPerAval;
    //F Req. 87567 E2.1 ID 127 avilca 21/01/2020
    /**
     * @return the codSoliCred
     */
    public String getCodSoliCred() {
        return codSoliCred;
    }

    /**
     * @param codSoliCred the codSoliCred to set
     */
    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
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

    /**
     * @return the nroExpediente
     */
    public String getNroExpediente() {
        return nroExpediente;
    }

    /**
     * @param nroExpediente the nroExpediente to set
     */
    public void setNroExpediente(String nroExpediente) {
        this.nroExpediente = nroExpediente;
    }

    /**
     * @return the nomPerso
     */
    public String getNomPerso() {
        return nomPerso;
    }

    /**
     * @param nomPerso the nomPerso to set
     */
    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }

    /**
     * @return the codEstLeg
     */
    public String getCodEstLeg() {
        return codEstLeg;
    }

    /**
     * @param codEstLeg the codEstLeg to set
     */
    public void setCodEstLeg(String codEstLeg) {
        this.codEstLeg = codEstLeg;
    }

    /**
     * @return the noCia
     */
    public String getNoCia() {
        return noCia;
    }

    /**
     * @param noCia the noCia to set
     */
    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

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
     * @return the codTipope
     */
    public String getCodTipope() {
        return codTipope;
    }

    /**
     * @param codTipope the codTipope to set
     */
    public void setCodTipope(String codTipope) {
        this.codTipope = codTipope;
    }

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

    public String getCodCanleg() {
        return codCanleg;
    }

    public void setCodCanleg(String codCanleg) {
        this.codCanleg = codCanleg;
    }
    //I Req. 87567 E2.1 ID 127 avilca 21/01/2020
    public String getCodPerAval() {
        return codPerAval;
    }

    public void setCodPerAval(String codPerAval) {
        this.codPerAval = codPerAval;
    }
    //F Req. 87567 E2.1 ID 127 avilca 21/01/2020
}
