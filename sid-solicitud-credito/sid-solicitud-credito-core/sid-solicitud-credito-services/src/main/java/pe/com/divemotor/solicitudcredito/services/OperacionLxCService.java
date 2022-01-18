/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ListaCronogramaLetrasLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaDocumentosRelacionadosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaGastosLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaOperacionLxCRegistradaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaRepresentanteLegalRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaReprogramacionOperacionesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaTiposDocumentosLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.OperacionLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CronogramaLetrasLxCResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentosRelacionadosListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GastosLxCListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLxCRegistradaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RepresentanteLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReprogramacionOperacionesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TiposDocumentosLxCListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TiposGastosLxCListadoResponse;

/**
 *
 * @author mbardales
 */
public interface OperacionLxCService {
    
    DocumentosRelacionadosListadoResponse listar (HeaderPaginadoParams headerParams, ListaDocumentosRelacionadosRequest request) throws Exception;
    
    TiposDocumentosLxCListadoResponse listarTiposDocumentos (HeaderPaginadoParams headerParams, ListaTiposDocumentosLxCRequest request) throws Exception;
    
    TiposGastosLxCListadoResponse listarTiposGastos (HeaderPaginadoParams headerParams, ListaTiposDocumentosLxCRequest request) throws Exception;
    
    GastosLxCListadoResponse listarGastos (HeaderPaginadoParams headerParams, ListaGastosLxCRequest request) throws Exception;
    
    RepresentanteLegalListadoResponse listarRepresentanteLegal (HeaderPaginadoParams headerParams, ListaRepresentanteLegalRequest request) throws Exception;
    
    ReprogramacionOperacionesListadoResponse listarReprogramacionOperaciones (HeaderPaginadoParams headerParams, ListaReprogramacionOperacionesRequest request) throws Exception;
    
    DocumentosRelacionadosListadoResponse registrarOperacionLxC (HeaderParams headerParams, OperacionLxCRequest request) throws Exception;
    
    OperacionLxCRegistradaListadoResponse listarOperacionLxCRegistrado (HeaderParams headerParams, ListaOperacionLxCRegistradaRequest request) throws Exception;
    
    CronogramaLetrasLxCResponse listarCronogramaLetrasLxC (HeaderParams headerParams, ListaCronogramaLetrasLxCRequest request) throws Exception;
    
    ReporteResponse exportarCronogramaLetrasLxC (HeaderParams headerParams, String codSoliCred) throws Exception;
}
