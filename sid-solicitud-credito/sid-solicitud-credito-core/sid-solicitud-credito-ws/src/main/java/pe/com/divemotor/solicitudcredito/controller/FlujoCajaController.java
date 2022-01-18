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
import pe.com.divemotor.solicitudcredito.dto.request.FactorPorMesFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaDetalleRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaInfoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaDetalleListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.services.FlujoCajaService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author mbardales
 */
@RestController
@RequestMapping("/api")
public class FlujoCajaController {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private FlujoCajaService flujoCajaService;

    @Autowired
    public void setFlujoCajaService(FlujoCajaService flujoCajaService) {
        this.flujoCajaService = flujoCajaService;
    }

    @ApiOperation(value = "Registrar Parametros de Flujo de Caja",
            notes = "Registro general de parametros de Flujo de Caja"
            + "se utiliza el PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_INSE_PARAM_CAMIONES")
    @RequestMapping(value = "/parametrosFlujoCaja",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarParametros(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ParametrosFlujoCajaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setIdUsuario(idUsuario);
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = flujoCajaService.registrarParametrosFC(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Registrar Factores por mes",
            notes = "Registro general de factores por mes de Flujo de Caja"
            + "se utiliza el PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_INSE_FACT_MES")
    @RequestMapping(value = "/factoresPorMes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarFactorPorMes(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody FactorPorMesFlujoCajaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setIdUsuario(idUsuario);
        headerParams.setCodUsuario(codUsuario);//<I Req. 87567 E2.1 ID## avilca 05/02/2021>

        BaseResponse response;

        try {
            response = flujoCajaService.registrarFactorPorMes(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Registrar proyección y Listar Cobertura de Flujo de Caja",
            notes = "retorna la lista de Cobertura de Flujo de Caja. "
            + "Procedure PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_CALC_PROY_CAMI.")
    @RequestMapping(value = "/proyeccionFlujoCaja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ProyeccionFlujoCajaListadoResponse proyeccionFlujoCaja(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ProyeccionFlujoCajaRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setToken(token);

        ProyeccionFlujoCajaListadoResponse response = null;

        try {
            response = flujoCajaService.registrarProyeccionFlujoCaja(headerParams, request);

        } catch (Exception ex) {
            response = new ProyeccionFlujoCajaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar parametros de Flujo de Caja",
            notes = "retorna los datos de los parametros de Flujo de Caja de Camiones, InterUrb. Urbano"
            + "Procedure PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_LIST_PARA_FC.")
    @RequestMapping(value = "/parametrosFlujoCaja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ParametrosFlujoCajaListadoResponse listarParametros(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaParametrosFlujoCajaRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        ParametrosFlujoCajaListadoResponse response = new ParametrosFlujoCajaListadoResponse();

        try {
            response = flujoCajaService.listarParametrosFlujoCaja(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar detalle de los parametros de Flujo de Caja",
            notes = "retorna el detalle de los parametros de Flujo de Caja de Camiones, InterUrb. Urbano"
            + "Procedure PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_REPO_FLUJ_CAJA.")
    @RequestMapping(value = "/parametrosFlujoCajaDetalle", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ParametrosFlujoCajaDetalleListadoResponse listarParametrosDetalleFC(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaParametrosFlujoCajaDetalleRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        ParametrosFlujoCajaDetalleListadoResponse response = new ParametrosFlujoCajaDetalleListadoResponse();

        try {
            response = flujoCajaService.listarParametrosFlujoCajaDetalle(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Exportar Reporte Flujo Caja", notes = "Exportar "
            + "Parametros de Ingreso, Egreso y Cobertura de Flujo de Caja")
    @RequestMapping(value = "/excel/parametrosFlujoCaja", method = RequestMethod.GET)
    public ReporteResponse exportarFlujoCaja(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred,
            @ApiParam(value = "Código de tipo FC")
            @RequestParam(name = "indTipoFc", required = false) String indTipoFc
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = flujoCajaService.exportarReporteFlujoCajaCamiones(headerParams, codSoliCred, indTipoFc);

        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Mostrar información general de Flujo de Caja",
            notes = "retorna el detalle de los flujos de Caja de Camiones, InterUrb. Urbano"
            + "Procedure PKG_SWEB_CRED_SOLI_FLUJO_CAJA.SP_OBTE_INFO_FC.")
    @RequestMapping(value = "/flujos-caja",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FlujoCajaInfoResponse listarFlujoCajaInfo(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        FlujoCajaInfoResponse response = new FlujoCajaInfoResponse();

        try {
            response = flujoCajaService.listarFlujoCajaInfo(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
}
