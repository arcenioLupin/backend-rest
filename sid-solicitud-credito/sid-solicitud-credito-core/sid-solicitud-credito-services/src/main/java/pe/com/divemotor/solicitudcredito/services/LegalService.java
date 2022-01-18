/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.AnexosContratosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoSolicitadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudLegalResponse;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentosLegalesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.FianzaSolidariaFSNRequest;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaHipotecariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaMobiliariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.LegalRequest;
import pe.com.divemotor.solicitudcredito.dto.request.OperacionesLegalesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudLegalRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AnexosContratosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.AvalClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocLegalHipRegResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoRevisionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentosLegalesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EstadoLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EstructuraOperacionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaFSNResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaPNRegResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaPNResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaMobiliariaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaRegListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.LegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLegalSolcreListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PersonaFacultadaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RevisionPoderesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudLegalListadoResponse;

/**
 *
 * @author MGRASSO
 */
public interface LegalService {
    LegalListadoResponse listar(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    EstadoLegalListadoResponse listarEstados(HeaderPaginadoParams headerParams) throws Exception;
    DocumentosLegalesListadoResponse listarDocumentosLegales(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public BaseResponse actualizarCheckList(HeaderPaginadoParams headerParams, DocumentosLegalesRequest request)throws Exception;    
    public RevisionPoderesListadoResponse listarRevisionPoderes(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception; 
    public OperacionLegalListadoResponse listarOperacionesLegales(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public AvalClienteListadoResponse listarAvalCliente(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public DocumentoRevisionListadoResponse listarDocumentoRevision(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public BaseResponse registrarRevisionPoderes(HeaderPaginadoParams headerParams,OperacionesLegalesRequest request)throws Exception;
    public BaseResponse eliminarOperacionLegal(HeaderPaginadoParams headerParams, OperacionesLegalesRequest request) throws Exception;
    public OperacionLegalSolcreListadoResponse listarOperacionesLegalesSolcre(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public PersonaFacultadaListadoResponse listarPersonaFacultadaSolcre(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public EstructuraOperacionListadoResponse listarEstructuraOperaciones(HeaderPaginadoParams headerParams)throws Exception;
    public SolicitudLegalListadoResponse listarValidarSolicitud(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public SolicitudLegalResponse registarLegal(HeaderPaginadoParams headerParams, SolicitudLegalRequest request)throws Exception;
    public GarantiaListadoResponse listarGarantiaMobiliariaLegal(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public DocumentoListadoResponse listarDocumentosSolicitados(HeaderPaginadoParams headerParams,DocumentoSolicitadoRequest request)throws Exception;
    public GarantiaMobiliariaResponse registarGarantiaMobiliaria(HeaderPaginadoParams headerParams, GarantiaMobiliariaRequest request) throws Exception;
    public GarantiaListadoResponse listarGarantiaHipotecariaLegal(HeaderPaginadoParams headerParams, LegalRequest request)throws Exception;
    public GarantiaRegListadoResponse listarGarantiaHipotecariaReg(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public GarantiaRegListadoResponse listarGarantiaMobiliariaReg(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public GarantiaMobiliariaResponse registarGarantiaHipotecaria(HeaderPaginadoParams headerParams, GarantiaHipotecariaRequest request) throws Exception;
    public DocumentoListadoResponse listarDocumentosHip(HeaderPaginadoParams headerParams,DocumentoSolicitadoRequest request)throws Exception;
    public DocumentoRevisionListadoResponse listarDocumentoFianzaSolidariaPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public FianzaSolidariaPNResponse listarFianzasSolidariasPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public FianzaSolidariaPNResponse listarPropsAvalFSPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public FianzaSolidariaFSNResponse registrarFianzaSolidariaPN(HeaderPaginadoParams headerParams, FianzaSolidariaFSNRequest request) throws Exception;
    public FianzaSolidariaPNRegResponse listarFSNRegistradas(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public DocLegalHipRegResponse listaDocLegalHipRegistradas(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception;
    public AnexosContratosResponse listaAnexosContratos(HeaderPaginadoParams headerParams, AnexosContratosRequest request) throws Exception;
    public BaseResponse registrarRutaAnexo(HeaderPaginadoParams headerParams, AnexosContratosRequest request) throws Exception;
    public ReporteResponse generarAnexosPdf(HeaderParams headerParams, String codOper, String codSoliCred,String codTipSoliCred) throws Exception;
}
