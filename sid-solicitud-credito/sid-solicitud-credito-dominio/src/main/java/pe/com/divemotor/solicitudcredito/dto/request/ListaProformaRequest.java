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
public class ListaProformaRequest extends BaseRequest {

    private String codClie;
    private String numProfVeh;

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

}
