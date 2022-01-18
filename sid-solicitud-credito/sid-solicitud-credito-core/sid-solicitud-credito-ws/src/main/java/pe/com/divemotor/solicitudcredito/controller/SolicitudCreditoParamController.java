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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.FlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoParamResponse;
import pe.com.divemotor.solicitudcredito.services.SolicitudCreditoParamService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author legutierrez
 */

@RestController
@RequestMapping("/api")
public class SolicitudCreditoParamController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private SolicitudCreditoParamService solicitudCreditoParamService;

    @Autowired
    public void setSolicitudCreditoParamService(SolicitudCreditoParamService solicitudCreditoParamService) {
        this.solicitudCreditoParamService = solicitudCreditoParamService;
    }
    
    @ApiOperation(value = "Registrar parametros de la solicitud de crédito",
            notes = "Registro de parametros de la solicitud de crédito"
            + "se utiliza el PKG_SWEB_CRED_SOLI.SP_INSE_CRED_SOLI_PARAM_FC")
    @RequestMapping(value = "/parametros",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false, defaultValue = "ACRUZ") String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false, defaultValue = "901") Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SolicitudCreditoParamRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoParamService.registrar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listar parametros de solicitud de credito", 
            notes = "retorna los datos de los parametros de una solicitud de credito. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_CRED_SOLI_PARAM_FC.")
    @RequestMapping(value = "/parametros", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SolicitudCreditoParamResponse listar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaSolicitudCreditoParamRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        SolicitudCreditoParamResponse response = new SolicitudCreditoParamResponse();

        try {
            response = solicitudCreditoParamService.listar(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Listar el Flujo de Caja de solicitud de credito", 
            notes = "retorna los datos del Flujo de Caja de una solicitud de credito. Procedure PKG_SWEB_CRED_SOLI.SP_CALC_PROY_PARA_FC.")
    @RequestMapping(value = "/parametros/flujoCaja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FlujoCajaResponse listarFlujoCaja(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute FlujoCajaRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        FlujoCajaResponse response = new FlujoCajaResponse();

        try {
            response = solicitudCreditoParamService.listarFlujoCaja(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
}
