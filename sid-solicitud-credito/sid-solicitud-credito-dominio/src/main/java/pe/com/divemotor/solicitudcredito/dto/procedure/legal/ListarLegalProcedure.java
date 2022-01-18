/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Legal;

/**
 *
 * @author USER
 */
public class ListarLegalProcedure extends BasePaginadoProcedure<Legal>{
    
    private String codSoliCred;
    private String codSolcre;
    private String nroExpediente;
    private String nomPerso;
    private String codEstLeg;
    private String noCia;

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
    
    
    
}
