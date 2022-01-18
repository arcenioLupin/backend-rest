/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.generico.dto.BaseResponse;

/**
 *
 * @author phramirez
 */
public class TasaSeguroResponse extends BaseResponse {

    private Double tasaSeg;

    public Double getTasaSeg() {
        return tasaSeg;
    }

    public void setTasaSeg(Double tasaSeg) {
        this.tasaSeg = tasaSeg;
    }

}
