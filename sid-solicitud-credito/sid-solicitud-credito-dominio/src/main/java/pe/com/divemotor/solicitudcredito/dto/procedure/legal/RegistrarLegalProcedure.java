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
public class RegistrarLegalProcedure extends BaseProcedure{
    
    private String codSoliCred;
    private int codSolcre;
    private String codClie;
    private String codEstope;
    private String fechaSolcre;
    private String fechaRevision;
    private String fechaCaduca;
    private String codEstleg;
    private String nroExpediente;
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
    public int getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSolcre to set
     */
    public void setCodSolcre(int codSolcre) {
        this.codSolcre = codSolcre;
    }

    /**
     * @return the codClie
     */
    public String getCodClie() {
        return codClie;
    }

    /**
     * @param codClie the codClie to set
     */
    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    /**
     * @return the codEstope
     */
    public String getCodEstope() {
        return codEstope;
    }

    /**
     * @param codEstope the codEstope to set
     */
    public void setCodEstope(String codEstope) {
        this.codEstope = codEstope;
    }

    /**
     * @return the fechaSolcre
     */
    public String getFechaSolcre() {
        return fechaSolcre;
    }

    /**
     * @param fechaSolcre the fechaSolcre to set
     */
    public void setFechaSolcre(String fechaSolcre) {
        this.fechaSolcre = fechaSolcre;
    }

    /**
     * @return the fechaRevision
     */
    public String getFechaRevision() {
        return fechaRevision;
    }

    /**
     * @param fechaRevision the fechaRevision to set
     */
    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    /**
     * @return the fechaCaduca
     */
    public String getFechaCaduca() {
        return fechaCaduca;
    }

    /**
     * @param fechaCaduca the fechaCaduca to set
     */
    public void setFechaCaduca(String fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
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
