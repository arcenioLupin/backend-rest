/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.garantia;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author 90690 ivelasquez 21/09/2021
 */
public class ConsultarGarantiasProcedure extends BaseProcedure {
    
    private String codSoliCred;

    private Integer cantidad;
    
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
