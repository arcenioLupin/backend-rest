/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.IsTipoMovimientoOperacionExisteRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.IsTipoMovimientoOperacionExisteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientoListadoResponse;

/**
 *
 * @author eudo.barboza
 */
public interface TipoMovimientoService {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    TipoMovimientoListadoResponse listar (HeaderPaginadoParams headerParams, ListaTipoMovimientoRequest request) throws Exception;
    TipoMovimientoListadoResponse listarTodos (HeaderPaginadoParams headerParams) throws Exception;
    IsTipoMovimientoOperacionExisteResponse IsTipoMovimientoOperacionExiste (HeaderPaginadoParams headerParams,IsTipoMovimientoOperacionExisteRequest request ) throws Exception;
    BaseResponse actualizarTipoMovimiento(HeaderParams headerParams, ActualizarTipoMovimientoRequest request) throws Exception;
}
