/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.FacturaAnexo;

/**
 *
 * @author USER
 */
public class ListarFacturasAnexosProcedure extends BasePaginadoProcedure<FacturaAnexo> {
    
    private String codOper;
    private String codSoliCred;//< Req. 87567 E2.1 ID## avilca 01/12/2020>

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }
      
}
