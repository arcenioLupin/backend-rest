/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;


import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientosSimuladorProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSimuladorTipoMovimientoProcedure;


 /*
 * @author eudo.barboza
 */
public interface TipoMovimientosSimuladorMapper {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    void actualizarTipoMovimientosSimulador (RegistrarSimuladorTipoMovimientoProcedure parametros);
    void listarPorCodSoliCred (ListarTipoMovimientosSimuladorProcedure parametros);
    
}
