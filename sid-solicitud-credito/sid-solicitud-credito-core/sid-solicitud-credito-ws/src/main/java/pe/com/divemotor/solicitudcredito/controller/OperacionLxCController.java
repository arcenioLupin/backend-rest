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
import pe.com.divemotor.solicitudcredito.services.OperacionLxCService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author mbardales
 */

@RestController
@RequestMapping("/api")
public class OperacionLxCController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    private OperacionLxCService operacionLxCService;

    @Autowired
    public void setOperacionLxCService(OperacionLxCService operacionLxCService) {
        this.operacionLxCService = operacionLxCService;
    }
    
    @ApiOperation(value = "Listar Documentos Relacionados LxC",
            notes = "retorna una lista de documentos relacionados LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_DOCU_RELA.")
    @RequestMapping(value = "/operacionLxC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DocumentosRelacionadosListadoResponse listar(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaDocumentosRelacionadosRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        DocumentosRelacionadosListadoResponse response = null;

        try {
            response = operacionLxCService.listar(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentosRelacionadosListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Listar los tipos de Documentos de LxC",
            notes = "retorna una lista de los tipos de documentos de LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_TIPO_DOCU.")
    @RequestMapping(value = "/tiposDocumentosLxC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public TiposDocumentosLxCListadoResponse listarTiposDocumentosLxC (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaTiposDocumentosLxCRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        TiposDocumentosLxCListadoResponse response = null;

        try {
            response = operacionLxCService.listarTiposDocumentos(headerParams, request);

        } catch (Exception ex) {
            response = new TiposDocumentosLxCListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listar los tipos de Gastos de LxC",
            notes = "retorna una lista de los tipos de Gastos de LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_TIPO_GASTO.")
    @RequestMapping(value = "/tiposGastosLxC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public TiposGastosLxCListadoResponse listarTiposGastosLxC (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaTiposDocumentosLxCRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        TiposGastosLxCListadoResponse response = null;

        try {
            response = operacionLxCService.listarTiposGastos(headerParams, request);

        } catch (Exception ex) {
            response = new TiposGastosLxCListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listar los de Gastos de LxC por letras",
            notes = "retorna una lista de Gastos de LxC por letras. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_GASTOS.")
    @RequestMapping(value = "/gastosLxC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GastosLxCListadoResponse listarGastosLxC (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaGastosLxCRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        GastosLxCListadoResponse response = null;

        try {
            response = operacionLxCService.listarGastos(headerParams, request);

        } catch (Exception ex) {
            response = new GastosLxCListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listar los Representantes Legal",
            notes = "retorna una lista de Representantes Legal de LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_REPRE_LEGAL.")
    @RequestMapping(value = "/representanteLegal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public RepresentanteLegalListadoResponse listarRepresentanteLegal (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaRepresentanteLegalRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        RepresentanteLegalListadoResponse response = null;

        try {
            response = operacionLxCService.listarRepresentanteLegal(headerParams, request);

        } catch (Exception ex) {
            response = new RepresentanteLegalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Listar los Reprogramaciones de Operaciones",
            notes = "retorna una lista de Reprogramaciones de Operaciones de LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_REPRO_OPER.")
    @RequestMapping(value = "/reprogramacionesOperaciones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ReprogramacionOperacionesListadoResponse listarReprogramacionesOperaciones (
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") 
            @RequestHeader String indPaginado,
            @ApiParam(value = "Número de la pagina a consultar", required = true, defaultValue = "1") 
            @RequestHeader String nroPag,
            @ApiParam(value = "Número de registro por página", required = true, defaultValue = "10") 
            @RequestHeader String cantidadxPag,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaReprogramacionOperacionesRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));
        headerParams.setToken(token);
        ReprogramacionOperacionesListadoResponse response = null;

        try {
            response = operacionLxCService.listarReprogramacionOperaciones(headerParams, request);

        } catch (Exception ex) {
            response = new ReprogramacionOperacionesListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Registrar Operación LxC",
            notes = "Registro general de la Operación LxC"
            + "se utiliza el PKG_SWEB_CRED_LXC.SP_GUARDAR_OP")
    @RequestMapping(value = "/operacionLxC",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody OperacionLxCRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = operacionLxCService.registrarOperacionLxC(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Listar los datos Registrados de Operacion LxC",
            notes = "retorna las listas de los datos LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_OPER_REGI.")
    @RequestMapping(value = "/operacionLxCRegistrado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public OperacionLxCRegistradaListadoResponse listarOperacionLxC (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaOperacionLxCRegistradaRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        OperacionLxCRegistradaListadoResponse response = null;

        try {
            response = operacionLxCService.listarOperacionLxCRegistrado(headerParams, request);

        } catch (Exception ex) {
            response = new OperacionLxCRegistradaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Listar las letras del Cronograma LxC",
            notes = "retorna las letras del cronograma LxC. "
                    + "Procedure PKG_SWEB_CRED_SOLI_LXC.SP_LIST_CRONO_LXC.")
    @RequestMapping(value = "/cronogramaLetrasLxC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public CronogramaLetrasLxCResponse listarCronogramaLetrasLxC (@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaCronogramaLetrasLxCRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);
        CronogramaLetrasLxCResponse response = null;

        try {
            response = operacionLxCService.listarCronogramaLetrasLxC(headerParams, request);

        } catch (Exception ex) {
            response = new CronogramaLetrasLxCResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Exportar cronograma Letras LxC", notes = "Exportar "
            + "Cronograma LxC Pdf")
    @RequestMapping(value = "/pdf/exportarCronogramaLxc", method = RequestMethod.GET)
    public ReporteResponse exportarCronogramaLetrasLxC(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = operacionLxCService.exportarCronogramaLetrasLxC(headerParams, codSoliCred);

        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
}
