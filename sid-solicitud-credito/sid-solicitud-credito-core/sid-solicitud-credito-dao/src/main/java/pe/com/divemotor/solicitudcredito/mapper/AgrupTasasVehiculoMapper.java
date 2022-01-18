/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ActualizarAgrupTasasVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoDetProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoProcedure;

/**
 *
 * @author jaltamirano
 */
public interface AgrupTasasVehiculoMapper {

    public void listarAgrupaciones(ListarAgrupTasasVehiculoProcedure parametros);

    public void listarAgrupacionesDetail(ListarAgrupTasasVehiculoDetProcedure parametros);

    public void actualizarAgrupaciones(ActualizarAgrupTasasVehiculoProcedure parametros);
    
    public void actualizarAgrupacionesDetalle(ActualizarAgrupTasasVehiculoProcedure parametros);

}
