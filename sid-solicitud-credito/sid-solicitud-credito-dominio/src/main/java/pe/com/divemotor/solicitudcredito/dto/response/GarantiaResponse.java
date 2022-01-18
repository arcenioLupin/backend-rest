/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.generico.dto.BaseResponse;

/**
 *
 * @author USER
 */
public class GarantiaResponse extends BaseResponse {
 
  private String codGarantiaOut;

    public String getCodGarantiaOut() {
        return codGarantiaOut;
    }

    public void setCodGarantiaOut(String codGarantiaOut) {
        this.codGarantiaOut = codGarantiaOut;
    }
  
  
}
