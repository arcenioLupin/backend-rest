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
public class DocLegalHipReg {

    private int codDanleg;
    private int codCanleg;
    private int codDtipope;
    private int codTipope;
    private String indOk;
    private String observacion;
    private int codDanlegOut;
    private String descripcion;
    private String txtRutaDoc;

    public int getCodDanleg() {
        return codDanleg;
    }

    public void setCodDanleg(int codDanleg) {
        this.codDanleg = codDanleg;
    }

    public int getCodCanleg() {
        return codCanleg;
    }

    public void setCodCanleg(int codCanleg) {
        this.codCanleg = codCanleg;
    }

    public int getCodDtipope() {
        return codDtipope;
    }

    public void setCodDtipope(int codDtipope) {
        this.codDtipope = codDtipope;
    }

    public int getCodTipope() {
        return codTipope;
    }

    public void setCodTipope(int codTipope) {
        this.codTipope = codTipope;
    }

    public int getCodDanlegOut() {
        return codDanlegOut;
    }

    public void setCodDanlegOut(int codDanlegOut) {
        this.codDanlegOut = codDanlegOut;
    }

    public String getIndOk() {
        return indOk;
    }

    public void setIndOk(String indOk) {
        this.indOk = indOk;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
