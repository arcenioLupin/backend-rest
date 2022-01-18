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
public class CheckDocumentos {
    private int codDocrev;
    private int codDdorev;
    private String codOpeleg;
    private String codTipope;
    private String descripcion;
    private String utiliza;
    private String indConforme;

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
     * @return the utiliza
     */
    public String getUtiliza() {
        return utiliza;
    }

    /**
     * @param utiliza the utiliza to set
     */
    public void setUtiliza(String utiliza) {
        this.utiliza = utiliza;
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

    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }

    public int getCodDdorev() {
        return codDdorev;
    }

    public void setCodDdorev(int codDdorev) {
        this.codDdorev = codDdorev;
    }
   
}
