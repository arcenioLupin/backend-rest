/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarIndiVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaVehiculosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.VehiculosListadoResponse;

/**
 *
 * @author legutierrez
 */
public interface VehiculosService {
    
    VehiculosListadoResponse listar (HeaderPaginadoParams headerParams, ListaVehiculosRequest request) throws Exception;
    
    BaseResponse registrar (HeaderParams headerParams, SolicitudVehiculoRequest request) throws Exception;
    
    BaseResponse actualizar (HeaderParams headerParams, ActualizarIndiVehiculoRequest request) throws Exception;
}
