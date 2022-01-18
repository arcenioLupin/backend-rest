/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.AnexosContratosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoSolicitadoRequest;
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
import pe.com.divemotor.solicitudcredito.services.LegalService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author Mgrasso
 */
@RestController
@RequestMapping("/api")
public class LegalController {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private LegalService legalService;

    @Autowired
    public void setLegalService(LegalService legalService) {
        this.legalService = legalService;
    }

    @ApiOperation(value = "Listar Solicitudes legales",
            notes = "retorna una lista de solicitudes de legales en base a los filtros. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_SOL_LEGAL.")
    @RequestMapping(value = "/legal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public LegalListadoResponse listar(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        LegalListadoResponse response = null;

        try {
            response = legalService.listar(headerParams, request);

        } catch (Exception ex) {
            response = new LegalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Estados legales",
            notes = "retorna una lista de estados legales. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_EST_LEGAL.")
    @RequestMapping(value = "/estadosLegales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public EstadoLegalListadoResponse listarEstados(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        EstadoLegalListadoResponse response = null;

        try {
            response = legalService.listarEstados(headerParams);

        } catch (Exception ex) {
            response = new EstadoLegalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Documentos legales para las solicitudes",
            notes = "retorna una lista de documentos legales, garantías y avales.")
    @RequestMapping(value = "/documentosLegales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentosLegalesListadoResponse listarDocumentosLegales(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocumentosLegalesListadoResponse response = null;

        try {
            response = legalService.listarDocumentosLegales(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentosLegalesListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualiza el checklist de documentos",
            notes = "retorna una lista de documentos legales, garantías y avales.")
    @RequestMapping(value = "/actualizarCheckList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse actualizarCheckList(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody DocumentosLegalesRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.actualizarCheckList(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Revisión de poderes",
            notes = "retorna una lista de revisión de poderes.")
    @RequestMapping(value = "/revisionPoderes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public RevisionPoderesListadoResponse listarRevisionPoderes(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        RevisionPoderesListadoResponse response = null;

        try {
            response = legalService.listarRevisionPoderes(headerParams, request);

        } catch (Exception ex) {
            response = new RevisionPoderesListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Operaciones legales",
            notes = "retorna una lista de operaciones legales . Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_SOL_LEGAL.")
    @RequestMapping(value = "/operacionesLegales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public OperacionLegalListadoResponse listarOperacionesLegales(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        OperacionLegalListadoResponse response = null;

        try {
            response = legalService.listarOperacionesLegales(headerParams, request);

        } catch (Exception ex) {
            response = new OperacionLegalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Avales y clientes",
            notes = "retorna una lista de operaciones legales . Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_AVAL_CLIENTE.")
    @RequestMapping(value = "/avalCliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AvalClienteListadoResponse listarAvalCliente(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        AvalClienteListadoResponse response = null;

        try {
            response = legalService.listarAvalCliente(headerParams, request);

        } catch (Exception ex) {
            response = new AvalClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Documentos a revisar",
            notes = "retorna una lista de documentos a revisar . Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_OPERACIONES_PERSONAS.")
    @RequestMapping(value = "/documentoRevision", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentoRevisionListadoResponse listarDocumentoRevision(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocumentoRevisionListadoResponse response = null;

        try {
            response = legalService.listarDocumentoRevision(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentoRevisionListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualiza los documentos a revisar",
            notes = "actualiza los documentos a revisar.")
    @RequestMapping(value = "/revisionPoderes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse registrarRevisionPoderes(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody OperacionesLegalesRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.registrarRevisionPoderes(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Inactiva operaciones legales",
            notes = "Inactiva operaciones legales.")
    @RequestMapping(value = "/eliminaOperacionesLegales", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse eliminarOperacionesLegales(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody OperacionesLegalesRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.eliminarOperacionLegal(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualiza los documentos a revisar en fianza solidaria.",
            notes = "actualiza los documentos a revisar en fianza solidaria.")
    @RequestMapping(value = "/revisionFianzaSolidariaPJ", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse revisionFianzaSolidariaPJ(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody OperacionesLegalesRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.registrarRevisionPoderes(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Operaciones legales por solicitud de credito",
            notes = "retorna una lista de operaciones legales . Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_OPELEGAL_SOLCRE.")
    @RequestMapping(value = "/listarOperacionesLegalesSolcre", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public OperacionLegalSolcreListadoResponse listarOperacionesLegalesSolcre(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        OperacionLegalSolcreListadoResponse response = null;

        try {
            response = legalService.listarOperacionesLegalesSolcre(headerParams, request);

        } catch (Exception ex) {
            response = new OperacionLegalSolcreListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las personas facultadas asociada a las operaciones legales",
            notes = "retorna una lista de personas facultada. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_PERFACULTADA_SOLCRE.")
    @RequestMapping(value = "/listarPersonaFacultadaSolcre", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public PersonaFacultadaListadoResponse listarPersonaFacultadaSolcre(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        PersonaFacultadaListadoResponse response = null;

        try {
            response = legalService.listarPersonaFacultadaSolcre(headerParams, request);

        } catch (Exception ex) {
            response = new PersonaFacultadaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar Estructura de operaciones",
            notes = "retorna una lista de estructura de operaciones. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_ESTRUCTURA_OPERACION.")
    @RequestMapping(value = "/estructuraOperaciones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public EstructuraOperacionListadoResponse listarEstructuraOperaciones(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        EstructuraOperacionListadoResponse response = null;

        try {
            response = legalService.listarEstructuraOperaciones(headerParams);

        } catch (Exception ex) {
            response = new EstructuraOperacionListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar la solicitud de crédito en caso de existir",
            notes = "retorna la solicitud de crédito en caso de existir. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_VALIDAR_SOLCRE.")
    @RequestMapping(value = "/validarSolicitudLegal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SolicitudLegalListadoResponse listarValidarSolicitud(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        SolicitudLegalListadoResponse response = null;

        try {
            response = legalService.listarValidarSolicitud(headerParams, request);

        } catch (Exception ex) {
            response = new SolicitudLegalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Registrar solicitud legal",
            notes = "Registra la solicitud legal.")
    @RequestMapping(value = "/registrarLegal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse registrarLegal(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody SolicitudLegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.registarLegal(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las garantias mobiliarias adicionales de legal",
            notes = "retorna una lista de garantias mobiliarias adicionales de legal. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_GARANTIA_MOBILIARIA.")
    @RequestMapping(value = "/listarGarantiaMobiliariaLegal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaListadoResponse listarGarantiaMobiliariaLegal(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaListadoResponse response = null;

        try {
            response = legalService.listarGarantiaMobiliariaLegal(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los documentos legales solicitados",
            notes = "retorna una lista de documentos legales solicitados. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_DOCUMENTO_SOLICITADO.")
    @RequestMapping(value = "/listarDocumentosSolicitados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentoListadoResponse listarDocumentosSolicitados(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute DocumentoSolicitadoRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocumentoListadoResponse response = null;

        try {
            response = legalService.listarDocumentosSolicitados(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Registrar garantía mobiliaria",
            notes = "Registra la garantía mobiliaria.")
    @RequestMapping(value = "/registrarGarantiaMobiliaria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaMobiliariaResponse registrarGarantiaMobiliaria(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody GarantiaMobiliariaRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaMobiliariaResponse response = null;

        try {
            response = legalService.registarGarantiaMobiliaria(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaMobiliariaResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las garantias hipotecarias adicionales de legal",
            notes = "retorna una lista de garantias hipotecarias adicionales de legal. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_GARANTIA_HIPOTECARIA.")
    @RequestMapping(value = "/listarGarantiaHipotecariaLegal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaListadoResponse listarGarantiaHipotecariaLegal(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaListadoResponse response = null;

        try {
            response = legalService.listarGarantiaHipotecariaLegal(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las garantias hipotecarias registradas de legal",
            notes = "retorna una lista de garantias hipotecarias registradas de legal. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_GARANTIA_HIPO_REG.")
    @RequestMapping(value = "/listarGarantiaHipotecariaReg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaRegListadoResponse listarGarantiaHipotecariaReg(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaRegListadoResponse response = null;

        try {
            response = legalService.listarGarantiaHipotecariaReg(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaRegListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las garantias mobiliarias registradas de legal",
            notes = "retorna una lista de garantias mobiliarias registradas de legal. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_GARANTIA_MOB_REG.")
    @RequestMapping(value = "/listarGarantiaMobiliariaReg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaRegListadoResponse listarGarantiaMobiliariaReg(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaRegListadoResponse response = null;

        try {
            response = legalService.listarGarantiaMobiliariaReg(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaRegListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Registrar garantía hipotecaria",
            notes = "Registra la garantía hipotecaia.")
    @RequestMapping(value = "/registrarGarantiaHipotecaria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GarantiaMobiliariaResponse registrarGarantiaMobiliaria(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody GarantiaHipotecariaRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        GarantiaMobiliariaResponse response = null;

        try {
            response = legalService.registarGarantiaHipotecaria(headerParams, request);

        } catch (Exception ex) {
            response = new GarantiaMobiliariaResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los documentos hipotecarios legales solicitados",
            notes = "retorna una lista de documentos hipotecarios legales solicitados. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_DOCUMENTOS_HIP.")
    @RequestMapping(value = "/listarDocumentosHip", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentoListadoResponse listarDocumentosHip(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute DocumentoSolicitadoRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocumentoListadoResponse response = null;

        try {
            response = legalService.listarDocumentosHip(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los documentos de fianza solidaria PN",
            notes = "Listar los documentos de fianza solidaria PN. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_DOCS_FSN.")
    @RequestMapping(value = "/listarDocumentoFianzaSolidariaPN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentoRevisionListadoResponse listarDocumentoFianzaSolidariaPN(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocumentoRevisionListadoResponse response = null;

        try {
            response = legalService.listarDocumentoFianzaSolidariaPN(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentoRevisionListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los fiadores en fianza solidaria PN",
            notes = "Listar los fiadores en fianza solidaria PN. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_FIANZAS_SOLIDARIAS")
    @RequestMapping(value = "/listarFianzasSolidariasPN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FianzaSolidariaPNResponse listarFianzasSolidariasPN(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        FianzaSolidariaPNResponse response = null;

        try {
            response = legalService.listarFianzasSolidariasPN(headerParams, request);

        } catch (Exception ex) {
            response = new FianzaSolidariaPNResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Listar los propietarios, avales en fianza solidaria PN",
            notes = "Listar los propietarios, avales  fianza solidaria PN. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_PROP_AVAL_FSPN")
    @RequestMapping(value = "/listarPropsAvalFSPN", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FianzaSolidariaPNResponse listarPropsAvalFSPN(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        FianzaSolidariaPNResponse response = null;

        try {
            response = legalService.listarPropsAvalFSPN(headerParams, request);

        } catch (Exception ex) {
            response = new FianzaSolidariaPNResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }


    @ApiOperation(value = "Registrar Fianza Solidaria PN",
            notes = "Registra la Fianza Solidaria PN.")
    @RequestMapping(value = "/registrarFianzaSolidariaPN", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FianzaSolidariaFSNResponse registrarFianzaSolidariaPN(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody FianzaSolidariaFSNRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        FianzaSolidariaFSNResponse response = null;

        try {
            response = legalService.registrarFianzaSolidariaPN(headerParams, request);

        } catch (Exception ex) {
            response = new FianzaSolidariaFSNResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar las fianzas solidarias PN registradas",
            notes = "Listar las fianzas solidarias PN registradas. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_FSN_REGISTRADAS.")
    @RequestMapping(value = "/listarFSNRegistradas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FianzaSolidariaPNRegResponse listarFSNRegistradas(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        FianzaSolidariaPNRegResponse response = null;

        try {
            response = legalService.listarFSNRegistradas(headerParams, request);

        } catch (Exception ex) {
            response = new FianzaSolidariaPNRegResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los documentos legales de Garantia Hipotecaria registradas",
            notes = "Listar los documentos legales de Garantia Hipotecaria registradas. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_DOCLEGAL_HIP_REG.")
    @RequestMapping(value = "/listarDocLegHipRegistradas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocLegalHipRegResponse listarDocLegHipRegistradas(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute LegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        DocLegalHipRegResponse response = null;

        try {
            response = legalService.listaDocLegalHipRegistradas(headerParams, request);

        } catch (Exception ex) {
            response = new DocLegalHipRegResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar los anexos y contratos asociados a la solicitud de crédito",
            notes = "Listar los anexos y contratos asociados a la solicitud de crédito. Procedure PKG_SWEB_CRED_SOLI_LEGAL.SP_LISTAR_ANEXOS_CONTRATOS.")
    @RequestMapping(value = "/listaAnexosContratos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AnexosContratosResponse listaAnexosContratos(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute AnexosContratosRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        AnexosContratosResponse response = null;

        try {
            response = legalService.listaAnexosContratos(headerParams, request);

        } catch (Exception ex) {
            response = new AnexosContratosResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Registrar ruta de anexos y contratos",
            notes = "Registrar ruta de anexos y contratos.")
    @RequestMapping(value = "/registrarRutaAnexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse registrarRutaAnexo(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody AnexosContratosRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        BaseResponse response = null;

        try {
            response = legalService.registrarRutaAnexo(headerParams, request);

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Genera anexo pdf en solicitud legal", notes = "Exportar "
            + "Genera anexo pdf en solicitud legal")
    @RequestMapping(value = "/pdf/generar-anexos", method = RequestMethod.GET)
    public ReporteResponse generarAnexosLegal(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de operación")
            @RequestParam(name = "codOper", required = false) String codOper,
            @ApiParam(value = "Código de solicitud de crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred,
            @ApiParam(value = "Código de tipo de crédito")
            @RequestParam(name = "codTipSoliCred", required = false) String codTipSoliCred
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = legalService.generarAnexosPdf(headerParams, codOper, codSoliCred, codTipSoliCred);
        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

}
