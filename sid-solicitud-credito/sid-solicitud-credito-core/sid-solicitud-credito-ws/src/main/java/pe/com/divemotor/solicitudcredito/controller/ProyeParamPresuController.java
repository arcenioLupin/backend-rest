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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ProyeParamPresuService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class ProyeParamPresuController {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private ProyeParamPresuService service;

    @Autowired
    public void setService(ProyeParamPresuService service) {
        this.service = service;
    }

    @ApiOperation(value = "Listado de Proyecciones de Parametros",
            notes = "Retorna el listado Proyecciones de Parametros."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_PROYE.SP_LIST_PROYE_PP")
    @RequestMapping(value = "/proyeccion/listarProyeccion",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProyeccionListadoResponse listarProyeccion(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ProyeccionRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ProyeccionListadoResponse response;

        try {

            response = service.listarProyeccion(headerParams, request);

        } catch (Exception ex) {
            response = new ProyeccionListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @ApiOperation(value = "Actualización del KPIs ",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_PROYE.SP_ACT_PROYE_PP")
    @RequestMapping(value = "/proyeccion/actualizarProyeccion",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ProyeccionRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = service.actualizarProyeccion(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

}
