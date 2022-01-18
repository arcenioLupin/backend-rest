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
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarIndiVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaVehiculosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.VehiculosListadoResponse;
import pe.com.divemotor.solicitudcredito.services.VehiculosService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author legutierrez
 */

@RestController
@RequestMapping("/api")
public class VehiculosController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private VehiculosService vehiculosService;

    @Autowired
    public void setVehiculosService(VehiculosService vehiculosService) {
        this.vehiculosService = vehiculosService;
    }
    
    @ApiOperation(value = "Listar vehiculos para Generar Operaciones",
            notes = "retorna los vehiculos de una proforma. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_VEHICULOS.")
    @RequestMapping(value = "/vehiculos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public VehiculosListadoResponse listar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaVehiculosRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        VehiculosListadoResponse response = new VehiculosListadoResponse();

        try {
            response = vehiculosService.listar(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Registrar los vehiculos asignados a una solicitud de"
            + " de crédito",
            notes = "Registro de vehiculos de la solicitud de crédito"
            + "se utiliza el PKG_SWEB_CRED_SOLI.SP_INSE_SOLI_VEH")
    @RequestMapping(value = "/vehiculos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false, defaultValue = "ACRUZ") String codUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SolicitudVehiculoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = vehiculosService.registrar(headerParams, request);
        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        } 

        return response;
    }
    
    
    @ApiOperation(value = "Actualizar indicativo de Vehículos",
            notes = "Actualizacion de datos de la garantía de vehículos"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_ACTU_INDI_VEHICULO")
    @RequestMapping(value = "/vehiculos",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de usuario", required = true) @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarIndiVehiculoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = vehiculosService.actualizar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
}
