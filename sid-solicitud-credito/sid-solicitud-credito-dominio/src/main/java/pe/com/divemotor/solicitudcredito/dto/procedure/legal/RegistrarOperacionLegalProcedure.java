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
public class RegistrarOperacionLegalProcedure extends BaseProcedure{
 
    private String codSolcre;
    private String nomRevision;
    private String observacion;
    private String codTipope;
    private int codDocrev;
    private int codDocrevOut;

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
     * @return the nomRevision
     */
    public String getNomRevision() {
        return nomRevision;
    }

    /**
     * @param nomRevision the nomRevision to set
     */
    public void setNomRevision(String nomRevision) {
        this.nomRevision = nomRevision;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
    public int getCodDocrev() {
        return codDocrev;
    }

    /**
     * @param codDocrev the coddocrev to set
     */
    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }

    public int getCodDocrevOut() {
        return codDocrevOut;
    }

    public void setCodDocrevOut(int codDocrevOut) {
        this.codDocrevOut = codDocrevOut;
    }
    
    
    
}
