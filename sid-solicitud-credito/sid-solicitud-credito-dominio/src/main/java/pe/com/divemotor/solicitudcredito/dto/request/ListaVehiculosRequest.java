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
public class ListaVehiculosRequest extends BaseRequest {

    private String codSoliCred;
    private String indConsulta;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndConsulta() {
        return indConsulta;
    }

    public void setIndConsulta(String indConsulta) {
        this.indConsulta = indConsulta;
    }

}
