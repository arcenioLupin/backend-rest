/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.request.FormatoRDLRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FormatoRDLListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.HistorialAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MotivosAprobacionResponse;

/**
 *
 * @author legutierrez
 */
public interface SolicitudAprobacionService {
    
    BaseResponse registrar(HeaderParams headerParams, SolicitudAprobacionRequest request) throws Exception;
    
    BaseResponse actualizar(HeaderParams headerParams, ActualizarSolicitudAprobacionRequest request) throws Exception;
    
    FormatoRDLListadoResponse listaFormatoRDL (HeaderParams headerParams, FormatoRDLRequest request) throws Exception;
    
    ReporteResponse exportarFormatoRDL(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    ReporteResponse exportarFormatoRDLRefinanciamiento(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    ReporteResponse exportarFormatoRDLMutuo(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    ReporteResponse exportarFormatoLeasing(HeaderParams headerParams, String codSoliCred) throws Exception;

    MotivosAprobacionResponse listarMotivosAprobacion(HeaderParams headerParams, String codSoliCred) throws Exception;//ECUBAS <I>89642
    // <I> 90690 ivelasquez 21/09/2021
    HistorialAprobacionResponse listarHistorialAprobacion(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    BaseResponse listarSoliAprob(HeaderParams headerParams, SolicitudAprobacionRequest request) throws Exception;
    
    BaseResponse actualizarAprob(HeaderParams headerParams, ActualizarSolicitudAprobacionRequest request) throws Exception;
    // <F> 90690 ivelasquez 21/09/2021
}
