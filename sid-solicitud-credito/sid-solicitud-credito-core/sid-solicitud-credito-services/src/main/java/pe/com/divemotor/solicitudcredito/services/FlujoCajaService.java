/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.FactorPorMesFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaDetalleRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaInfoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaDetalleListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;

/**
 *
 * @author mbardales
 */
public interface FlujoCajaService {
    
    BaseResponse registrarParametrosFC (HeaderParams headerParams, ParametrosFlujoCajaRequest request) throws Exception;
    
    BaseResponse registrarFactorPorMes (HeaderParams headerParams, FactorPorMesFlujoCajaRequest request) throws Exception;
    
    ProyeccionFlujoCajaListadoResponse registrarProyeccionFlujoCaja (HeaderParams headerParams, ProyeccionFlujoCajaRequest request) throws Exception;
    
    ParametrosFlujoCajaListadoResponse listarParametrosFlujoCaja (HeaderParams headerParams, ListaParametrosFlujoCajaRequest request) throws Exception;
    
    ParametrosFlujoCajaDetalleListadoResponse listarParametrosFlujoCajaDetalle (HeaderParams headerParams, ListaParametrosFlujoCajaDetalleRequest request) throws Exception;
    
    ReporteResponse exportarReporteFlujoCajaCamiones (HeaderParams headerParams, String codSoliCred, String indTipoFc) throws Exception;
    
    FlujoCajaInfoResponse listarFlujoCajaInfo(HeaderParams headerParams, String codSoliCred) throws Exception;
}
