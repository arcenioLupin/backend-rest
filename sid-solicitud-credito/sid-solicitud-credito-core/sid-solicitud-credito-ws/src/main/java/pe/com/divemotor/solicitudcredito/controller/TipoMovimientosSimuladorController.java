/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
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
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientosSimuladorListadoResponse;
import pe.com.divemotor.solicitudcredito.services.TipoMovimientosSimuladorService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author ebarboza
 */
@RestController
@RequestMapping("/tipoMovimientosSumulador")
public class TipoMovimientosSimuladorController {

    /*Req. 87567 E2.3 ID## EBARBOZA 27/01/2020*/
    private final Logger LOGGER = Logger.getLogger(getClass());
    private Mapper mapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    private TipoMovimientosSimuladorService tipoMovimientosSimuladorService;

    @Autowired
    public void setTipoMovimientosSimuladorService(TipoMovimientosSimuladorService tipoMovimientosSimuladorService) {
        this.tipoMovimientosSimuladorService = tipoMovimientosSimuladorService;
    }

    @ApiOperation(value = "Actualización del Tipo de Mantenimiento en el Simulador",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_TMSIMU.SP_ACT_TIPO_MOVI")
    @RequestMapping(value = "/actualizarTipoMovimientosSimulador",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarTipoMovimientosSimulador(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarTipoMovimientosSimuladorRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;
         try {
            response = tipoMovimientosSimuladorService.actualizarTipoMovimientosSimulador(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
     @ApiOperation(value = "Listar tipo de movimiento",
            notes = "retorna los tipo de movimientos. Procedure PKG_SWEB_CRED_SOLI_MANT_TM.SP_LISTAR_TIPO_MOVIMIENTO.")
    @RequestMapping(value = "/listarPorCodSoliCred", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public TipoMovimientosSimuladorListadoResponse listarPorCodSoliCred(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListarTipoMovimientosSimuladorRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        TipoMovimientosSimuladorListadoResponse response = new TipoMovimientosSimuladorListadoResponse();

        try {
            response = tipoMovimientosSimuladorService.listarPorCodSoliCred(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

}
