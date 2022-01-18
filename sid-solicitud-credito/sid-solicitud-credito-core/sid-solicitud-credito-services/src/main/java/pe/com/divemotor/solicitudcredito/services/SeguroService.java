/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.PolizaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReportePolizasResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroListadoResponse;

/**
 *
 * @author Mgrasso
 */
public interface SeguroService {
    SeguroListadoResponse listar(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception;
    BaseResponse actualizar(HeaderParams headerParams, SeguroRequest request) throws Exception;
    BaseResponse actualizarPoliza(HeaderParams headerParams, SeguroRequest request) throws Exception;
    PolizaListadoResponse listarPoliza(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception;
    public ReportePolizasResponse exportarPolizas(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception;
    public PolizaListadoResponse notificarVencimientoPolizas(HeaderParams headerParams, SeguroRequest request) throws Exception;
    
}
