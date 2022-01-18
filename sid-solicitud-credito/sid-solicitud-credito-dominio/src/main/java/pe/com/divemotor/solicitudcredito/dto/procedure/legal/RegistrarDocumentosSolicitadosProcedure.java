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
public class RegistrarDocumentosSolicitadosProcedure extends BaseProcedure {
    
    private int    codDanleg;
    private int    codCanleg;
    private int    codDtipope;
    private int    codTipope;
    private String indConforme;
    private String observacion;
    private int    codDanlegOut;
    private int    codCanlegOut;
    


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

    public String getIndConforme() {
        return indConforme;
    }

    public void setIndConforme(String indConforme) {
        this.indConforme = indConforme;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCodDanlegOut() {
        return codDanlegOut;
    }

    public void setCodDanlegOut(int codDanlegOut) {
        this.codDanlegOut = codDanlegOut;
    }

    public int getCodCanlegOut() {
        return codCanlegOut;
    }

    public void setCodCanlegOut(int codCanlegOut) {
        this.codCanlegOut = codCanlegOut;
    }

    
}
