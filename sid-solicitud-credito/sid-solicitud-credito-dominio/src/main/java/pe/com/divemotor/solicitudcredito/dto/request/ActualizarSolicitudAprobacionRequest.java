/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author legutierrez
 */
public class ActualizarSolicitudAprobacionRequest extends BaseRequest {

    private String codSoliCred;
    private String valorEstado;
    private String txtComentario;
    private String ind_nivel;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getValorEstado() {
        return valorEstado;
    }

    public void setValorEstado(String valorEstado) {
        this.valorEstado = valorEstado;
    }

    public String getTxtComentario() {
        return txtComentario;
    }

    public void setTxtComentario(String txtComentario) {
        this.txtComentario = txtComentario;
    }

    /**
     * @return the ind_nivel
     */
    public String getInd_nivel() {
        return ind_nivel;
    }

    /**
     * @param ind_nivel the ind_nivel to set
     */
    public void setInd_nivel(String ind_nivel) {
        this.ind_nivel = ind_nivel;
    }

}
