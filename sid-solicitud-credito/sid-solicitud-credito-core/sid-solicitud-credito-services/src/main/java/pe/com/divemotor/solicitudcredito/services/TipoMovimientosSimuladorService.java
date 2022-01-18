/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import java.util.Map;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientosSimuladorListadoResponse;

/**
 *
 * @author ebarboza
 */
public interface TipoMovimientosSimuladorService {
    /*Req. 87567 E2.3 ID## EBARBOZA 27/01/2020*/
    
    
    BaseResponse actualizarTipoMovimientosSimulador(HeaderParams headerParams, ActualizarTipoMovimientosSimuladorRequest request) throws Exception;
    TipoMovimientosSimuladorListadoResponse listarPorCodSoliCred (HeaderPaginadoParams headerParams, ListarTipoMovimientosSimuladorRequest request) throws Exception;
}
