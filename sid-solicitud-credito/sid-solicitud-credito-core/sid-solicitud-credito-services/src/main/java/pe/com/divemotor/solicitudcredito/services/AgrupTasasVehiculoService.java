/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.AgrupTasasVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AgrupTasasVehiculoListadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface AgrupTasasVehiculoService {

    public AgrupTasasVehiculoListadoResponse listarAgrupaciones(HeaderPaginadoParams headerParams, AgrupTasasVehiculoRequest request) throws Exception;
    
    public AgrupTasasVehiculoListadoResponse listarAgrupacionesDetail(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception;

    public BaseResponse actualizarAgrupacion(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception;
    
    public BaseResponse actualizarAgrupacionDetalle(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception;
}
