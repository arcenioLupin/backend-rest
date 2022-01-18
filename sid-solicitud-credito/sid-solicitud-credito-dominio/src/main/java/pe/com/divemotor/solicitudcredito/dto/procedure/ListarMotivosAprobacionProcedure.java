/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.generico.dto.BaseProcedure;
import pe.com.divemotor.solicitudcredito.dominio.MotivosAprobacion;

/**
 *
 * @author //ECUBAS <I>89642S
 */
public class ListarMotivosAprobacionProcedure  extends BasePaginadoProcedure<MotivosAprobacion> {
    private String codSoliCred;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }
}
