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
public class DocumentoSolicitado {

    private String codDtipope;
    private String codTipope;
    private String descripcion;
    private String txtRutaDoc;

    public String getCodDtipope() {
        return codDtipope;
    }

    public void setCodDtipope(String codDtipope) {
        this.codDtipope = codDtipope;
    }

    public String getCodTipope() {
        return codTipope;
    }

    public void setCodTipope(String codTipope) {
        this.codTipope = codTipope;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTxtRutaDoc() {
        return txtRutaDoc;
    }

    public void setTxtRutaDoc(String txtRutaDoc) {
        this.txtRutaDoc = txtRutaDoc;
    }

}
