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
public class RegistrarDocumentoRevisionProcedure extends BaseProcedure{
    private String codSolcre;
    private int codDdorev;
    private int codDdorevOut;
    private int codDocrevOut;
    private int codDocrev;
    private String codTipope;
    private String codOpeleg;
    private String indConforme;

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
     * @return the codDdorev
     */
    public int getCodDdorev() {
        return codDdorev;
    }

    /**
     * @param codDdorev the codDdorev to set
     */
    public void setCodDdorev(int codDdorev) {
        this.codDdorev = codDdorev;
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
     * @return the codOpeleg
     */
    public String getCodOpeleg() {
        return codOpeleg;
    }

    /**
     * @param codOpeleg the codOpeleg to set
     */
    public void setCodOpeleg(String codOpeleg) {
        this.codOpeleg = codOpeleg;
    }

    /**
     * @return the indConforme
     */
    public String getIndConforme() {
        return indConforme;
    }

    /**
     * @param indConforme the indConforme to set
     */
    public void setIndConforme(String indConforme) {
        this.indConforme = indConforme;
    }

    public int getCodDdorevOut() {
        return codDdorevOut;
    }

    public void setCodDdorevOut(int codDdorevOut) {
        this.codDdorevOut = codDdorevOut;
    }

    public int getCodDocrevOut() {
        return codDocrevOut;
    }

    public void setCodDocrevOut(int codDocrevOut) {
        this.codDocrevOut = codDocrevOut;
    }

    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }
    
    
    
}
