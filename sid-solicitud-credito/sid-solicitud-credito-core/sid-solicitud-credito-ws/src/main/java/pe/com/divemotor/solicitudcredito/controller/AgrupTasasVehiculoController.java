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
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.AgrupTasasVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AgrupTasasVehiculoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.AgrupTasasVehiculoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class AgrupTasasVehiculoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private AgrupTasasVehiculoService service;

    @Autowired
    public void setService(AgrupTasasVehiculoService service) {
        this.service = service;
    }

    @ApiOperation(value = "Listado de información de agrupamiento de tasas por vehiculo",
            notes = "Retorna el listado de información de agrupamiento de tasas por vehiculo."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_AGRUP.SP_LIST_AGRUP_TASAS_VEHI")
    @RequestMapping(value = "/tasasvehi/listarAgrupaciones",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AgrupTasasVehiculoListadoResponse listarAgrupaciones(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
            @ApiParam(value = "Número de la pagina a consultar", required = true) @RequestHeader String nroPag,
            @ApiParam(value = "Número de registro por página", required = true) @RequestHeader String cantidadxPag,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute AgrupTasasVehiculoRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));

        AgrupTasasVehiculoListadoResponse response;

        try {

            response = service.listarAgrupaciones(headerParams, request);

        } catch (Exception ex) {
            response = new AgrupTasasVehiculoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Actualización de información de agrupamiento de tasas por vehiculo",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_AGRUP.SP_ACT_AGRUP")
    @RequestMapping(value = "/tasasvehi/actualizarAgrupacion",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarAgrupacion(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody AgrupTasasVehiculoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = service.actualizarAgrupacion(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

       @ApiOperation(value = "Actualización de información del detalle de agrupamiento de tasas por vehiculo",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_AGRUP.SP_ACT_DETALLE")
    @RequestMapping(value = "/tasasvehi/actualizarAgrupacionDetalle",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarAgrupacionDetalle(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody AgrupTasasVehiculoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = service.actualizarAgrupacionDetalle(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

}
