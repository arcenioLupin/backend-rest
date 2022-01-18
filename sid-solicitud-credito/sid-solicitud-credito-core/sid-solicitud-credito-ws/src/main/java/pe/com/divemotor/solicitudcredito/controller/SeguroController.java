/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.PolizaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReportePolizasResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroListadoResponse;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.solicitudcredito.services.SeguroService;

/**
 *
 * @author Mgrasso
 */
@RestController
@RequestMapping("/api")
public class SeguroController {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private SeguroService solicitudCreditoSeguroService;

    @Autowired
    public void setSolicitudCreditoSeguroService(SeguroService solicitudCreditoSeguroService) {
        this.solicitudCreditoSeguroService = solicitudCreditoSeguroService;
    }

    @ApiOperation(value = "Listar Seguros de solicitudes de crédito",
            notes = "retorna una lista de seguros de solicitudes de crédito en base a los filtros. Procedure PKG_SWEB_CRED_SOLI_SEGURO.SP_LIST_SOLI_CRED_SEGURO.")
    @RequestMapping(value = "/seguros", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SeguroListadoResponse listar(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute SeguroRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        SeguroListadoResponse response = null;

        try {
            response = solicitudCreditoSeguroService.listar(headerParams, request);

        } catch (Exception ex) {
            response = new SeguroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @ApiOperation(value = "Aprueba o Rechaza la tasa de seguro ingresada "
            + "en la solicitud de credito",
            notes = "La tasa fue aprobada o rechazada "
            + "Se utilizar el PKG_SWEB_CRED_SOLI_SEGURO.sp_actu_estado_soli_seg")
    @RequestMapping(value = "/seguros",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SeguroRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoSeguroService.actualizar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Actualiza los datos de la poliza de segudo "
            + "en la solicitud de credito",
            notes = "Se utilizar el PKG_SWEB_CRED_SOLI_SEGURO.SP_ACTU_DATOS_SOLI_SEG")
    @RequestMapping(value = "/seguros/actualizarPoliza",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarPoliza(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SeguroRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoSeguroService.actualizarPoliza(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar Polizas de Seguro",
            notes = "retorna una lista de seguros de solicitudes de crédito en base a los filtros. Procedure PKG_SWEB_CRED_SOLI_SEGURO.SP_LIST_SOLI_CRED_SEGURO.")
    @RequestMapping(value = "/polizas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public PolizaListadoResponse listarPoliza(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute SeguroRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        PolizaListadoResponse response = null;

        try {
            response = solicitudCreditoSeguroService.listarPoliza(headerParams, request);

        } catch (Exception ex) {
            response = new PolizaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de polizas")
    @RequestMapping(value = "/excel/polizas", method = RequestMethod.GET)
    public ReportePolizasResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Lista de polizas")
            @ModelAttribute SeguroRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReportePolizasResponse response;

        try {
            response = solicitudCreditoSeguroService.exportarPolizas(headerParams, request);

        } catch (Exception ex) {
            response = new ReportePolizasResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar polizas con fecha de vencimiento cercano",
    notes = "Notifica polizas proximo a vencer. Procedure PKG_SWEB_CRED_SOLI_SEGURO.SP_LIST_SOLI_CRED_VENC_SEGURO.")
    @RequestMapping(value = "/notificaVctoPolizas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public PolizaListadoResponse notificarVencimientoPolizas(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @ModelAttribute SeguroRequest request) {
        
        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        PolizaListadoResponse response = null;

        try {
            response = solicitudCreditoSeguroService.notificarVencimientoPolizas(headerParams, request);
        } catch (Exception ex) {
            response = new PolizaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    
}
