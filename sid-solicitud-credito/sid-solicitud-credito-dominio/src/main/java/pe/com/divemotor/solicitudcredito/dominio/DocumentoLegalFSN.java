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
public class DocumentoLegalFSN {
    
    private int codDocrev;
    private int codDdorev;
    private String codTipope;
    private String codOpeleg;
    private String descripcion;
    private String utiliza;
    private String indConforme;

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

    public String getCodTipope() {
        return codTipope;
    }

    public void setCodTipope(String codTipope) {
        this.codTipope = codTipope;
    }

    public String getCodOpeleg() {
        return codOpeleg;
    }

    public void setCodOpeleg(String codOpeleg) {
        this.codOpeleg = codOpeleg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUtiliza() {
        return utiliza;
    }

    public void setUtiliza(String utiliza) {
        this.utiliza = utiliza;
    }

    public String getIndConforme() {
        return indConforme;
    }

    public void setIndConforme(String indConforme) {
        this.indConforme = indConforme;
    }

   
    
}
