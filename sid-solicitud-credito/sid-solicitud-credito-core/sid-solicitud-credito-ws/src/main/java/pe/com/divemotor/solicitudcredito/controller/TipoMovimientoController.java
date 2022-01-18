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
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.IsTipoMovimientoOperacionExisteRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaVehiculosRequest;
import pe.com.divemotor.solicitudcredito.dto.response.IsTipoMovimientoOperacionExisteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.VehiculosListadoResponse;
import pe.com.divemotor.solicitudcredito.services.TipoMovimientoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author eudo.barboza
 */
@RestController
@RequestMapping("/tipoMovimiento")
public class TipoMovimientoController {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private TipoMovimientoService tipoMovimientoService;

    @Autowired
    public void setTipoMovimientoService(TipoMovimientoService tipoMovimientoService) {
        this.tipoMovimientoService = tipoMovimientoService;
    }
    
    @ApiOperation(value = "Listar tipo de movimiento",
            notes = "retorna los tipo de movimientos. Procedure PKG_SWEB_CRED_SOLI_MANT_TM.SP_LISTAR_TIPO_MOVIMIENTO.")
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public TipoMovimientoListadoResponse listar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaTipoMovimientoRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        TipoMovimientoListadoResponse response = new TipoMovimientoListadoResponse();

        try {
            response = tipoMovimientoService.listar(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
     @ApiOperation(value = "Listar tipo de movimientos",
            notes = "retorna todos los tipo de movimientos. Procedure PKG_SWEB_CRED_SOLI_MANT_TM.SP_LISTAR_TIPO_MOVIMIENTO.")
    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public TipoMovimientoListadoResponse listarTodos(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        TipoMovimientoListadoResponse response = new TipoMovimientoListadoResponse();

        try {
            response = tipoMovimientoService.listarTodos(headerParams);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listar tipo de movimientos",
            notes = "retorna todos los tipo de movimientos. Procedure PKG_SWEB_CRED_SOLI_MANT_TM.SP_LISTAR_TIPO_MOVIMIENTO.")
    @RequestMapping(value = "/isTipoMovOper", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public IsTipoMovimientoOperacionExisteResponse isTipoMovOper(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute IsTipoMovimientoOperacionExisteRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        IsTipoMovimientoOperacionExisteResponse response = new IsTipoMovimientoOperacionExisteResponse();

        try {
            response = tipoMovimientoService.IsTipoMovimientoOperacionExiste(headerParams,request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
   @ApiOperation(value = "Actualización del Tipo de Mantenimiento",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_TM.SP_ACT_TIPO_MOVI")
    @RequestMapping(value = "/actualizarTipoMovimiento",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarDocumento(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarTipoMovimientoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = tipoMovimientoService.actualizarTipoMovimiento(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
}
