/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.AgrupTasasVehiculoDetail;

/**
 *
 * @author jaltamirano
 */
public class ListarAgrupTasasVehiculoDetProcedure extends BasePaginadoProcedure<AgrupTasasVehiculoDetail> {

    private Integer codAgruVeh;

    public Integer getCodAgruVeh() {
        return codAgruVeh;
    }

    public void setCodAgruVeh(Integer codAgruVeh) {
        this.codAgruVeh = codAgruVeh;
    }

}
