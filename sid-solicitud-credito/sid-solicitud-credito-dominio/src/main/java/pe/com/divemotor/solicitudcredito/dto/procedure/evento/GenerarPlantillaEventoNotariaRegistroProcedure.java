/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.evento;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author ebarboza Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
 */
public class GenerarPlantillaEventoNotariaRegistroProcedure extends BaseProcedure{
    
    private String codSoliCred;
    private String codOperRel;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }
    
    
}
