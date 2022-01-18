/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author ebarboza Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
 */
public class EventoNotariaRequest extends BaseRequest{
    
    private String codOperRel;

    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }
    
    
}
