package pe.com.divemotor.solicitudcredito.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.divemotor.generico.dto.BaseResponse;


import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;

import pe.com.divemotor.solicitudcredito.dto.request.ActividadEtapaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividaTipoCreddRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividadRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadAllListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadEtapaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadPorTipoCreditoResponse;

import pe.com.divemotor.solicitudcredito.services.ActividadService;


@RestController
@RequestMapping("/api")
public class ActividadController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ActividadService actividadService;

    @Autowired
    public void setActividadService(ActividadService actividadService) {
        this.actividadService = actividadService;
    }
    
    @ApiOperation(value = "Listado de Documentos "
            + "de la solicitud",
            notes = "Retorna el listado de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli")
    @RequestMapping(value = "/actividades/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ActividadListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ActividadListadoResponse response = null;

        try {
            response = actividadService.listar(headerParams,codSoliCred);
        } catch (Exception ex) {
            response = new ActividadListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @ApiOperation(value = "Listado de actividades con sus etapa "
            + "de la solicitud",
            notes = "Retorna el listado de actividades con su etapa "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_list_actividad_etapa")
    @RequestMapping(value = "/actividades/{codigo-actividad}/etapa/{codigo-etapa}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ActividadEtapaListadoResponse listarActividadesEtapa(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-actividad") String codActividad,
            @PathVariable("codigo-etapa") String codEtapa
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ActividadEtapaListadoResponse response = null;

        try {
            response = actividadService.listarActividadesEtapa(headerParams,codActividad,codEtapa);
        } catch (Exception ex) {
            response = new ActividadEtapaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
   @ApiOperation(value = "Listado de actividades "
            + "de la solicitud",
            notes = "Retorna el listado de actividades "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_list_actividad_all")
    @RequestMapping(value = "/actividades-listAll"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ActividadAllListadoResponse listarActividadesEtapaAll(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ActividadAllListadoResponse response = null;

        try {
            response = actividadService.listarActividadesEtapaAll(headerParams);
        } catch (Exception ex) {
            response = new ActividadAllListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @ApiOperation(value = "Insertar una Actividad o Etapa Nueva",
            notes = "Este es parte del mantenimiento "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_inser_acti_etapa")
    @RequestMapping(value = "/crearActividaEtapa",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse crearActividaEtapa(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActividadEtapaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {

            response = actividadService.crearActividaEtapa(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @ApiOperation(value = "Actuliza las actividades",
            notes = "Este es parte del mantenimiento "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_actu_activ")
    @RequestMapping(value = "/actualizarActividad",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarActividad(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarActividadRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {

            response = actividadService.actualizarActividad(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @ApiOperation(value = "Actuliza las actividades con relacion a los tipo de credito",
            notes = "Este es parte del mantenimiento "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_actu_activ_tipo_cred")
    @RequestMapping(value = "/actualizarActividadTipoCred",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarActividadTipoCred(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarActividaTipoCreddRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {

            response = actividadService.actualizarActividadTipoCred(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    // BUSQUEDA DE ACTIVIDADES POR TIPO DE CREDITO MBARDALES 02/02/2021
    @ApiOperation(value = "Listado de actividades con sus etapa "
            + "de la solicitud por tipo de credito",
            notes = "Retorna el listado de actividades con su etapa por tipo de credito"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_ACTIVIDAD.sp_busqueda_act_eta_tip_cred")
    @RequestMapping(value = "/actividad/{codActividad}/etapa/{codEtapa}/codTipoCredito/{codTipoCredito}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ActividadPorTipoCreditoResponse listarActividadesPorTipoCredito(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codActividad") String codActividad,
            @PathVariable("codEtapa") String codEtapa,
            @PathVariable("codTipoCredito") String codTipoCredito
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ActividadPorTipoCreditoResponse response = null;

        try {
            response = actividadService.listarActividadPorTipoCredito(headerParams, codActividad, codEtapa, codTipoCredito);
        } catch (Exception ex) {
            response = new ActividadPorTipoCreditoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
