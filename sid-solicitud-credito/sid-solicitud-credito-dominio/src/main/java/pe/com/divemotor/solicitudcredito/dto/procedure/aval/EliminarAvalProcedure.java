/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.aval;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author jaltamirano
 */
public class EliminarAvalProcedure extends BaseProcedure {

    private String codSoliCred;
    private String codperaval;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodperaval() {
        return codperaval;
    }

    public void setCodperaval(String codperaval) {
        this.codperaval = codperaval;
    }

}
