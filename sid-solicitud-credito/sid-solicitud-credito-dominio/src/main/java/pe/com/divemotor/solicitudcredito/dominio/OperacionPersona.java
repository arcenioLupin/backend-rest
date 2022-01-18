/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author USER
 */
public class OperacionPersona {
    
    private String codDanleg;
    private String codCanleg;
    private String codDtipope;
    private String codTipope;
    private String descripcion;
    private String indConforme;

    /**
     * @return the codDanleg
     */
    public String getCodDanleg() {
        return codDanleg;
    }

    /**
     * @param codDanleg the codDanleg to set
     */
    public void setCodDanleg(String codDanleg) {
        this.codDanleg = codDanleg;
    }

    /**
     * @return the codCanleg
     */
    public String getCodCanleg() {
        return codCanleg;
    }

    /**
     * @param codCanleg the codCanleg to set
     */
    public void setCodCanleg(String codCanleg) {
        this.codCanleg = codCanleg;
    }

    /**
     * @return the codDtipope
     */
    public String getCodDtipope() {
        return codDtipope;
    }

    /**
     * @param codDtipope the codDtipope to set
     */
    public void setCodDtipope(String codDtipope) {
        this.codDtipope = codDtipope;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
