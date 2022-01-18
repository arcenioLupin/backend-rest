/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.AgrupTasasVehiculo;

/**
 *
 * @author jaltamirano
 */
public class ListarAgrupTasasVehiculoProcedure extends BasePaginadoProcedure<AgrupTasasVehiculo> {

    private String codCia;

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

}
