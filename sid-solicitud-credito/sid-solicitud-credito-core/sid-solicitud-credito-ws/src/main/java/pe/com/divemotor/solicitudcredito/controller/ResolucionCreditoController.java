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
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosCorreoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.FormatoRDLRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenEjecutivoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FormatoRDLListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.HistorialAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MotivosAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenEjecutivoResponse;
import pe.com.divemotor.solicitudcredito.services.SolicitudAprobacionService;
import pe.com.divemotor.solicitudcredito.services.SolicitudCreditoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author legutierrez
 */

@RestController
@RequestMapping("/api")
public class ResolucionCreditoController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());

    private SolicitudCreditoService solicitudCreditoService;
    
    private SolicitudAprobacionService solicitudAprobacionService; 

    @Autowired
    public void setSolicitudCreditoService(SolicitudCreditoService solicitudCreditoService) {
        this.solicitudCreditoService = solicitudCreditoService;
    }

    @Autowired
    public void setSolicitudAprobacionService(SolicitudAprobacionService solicitudAprobacionService) {
        this.solicitudAprobacionService = solicitudAprobacionService;
    }
    
   
    @ApiOperation(value = "Envío de correo para aprobación de crédito",
            notes = "Se envia el correo para la aprobación de crédito")
    @RequestMapping(value = "/resolucion-correo",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse envioCorreo(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DatosCorreoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            
            response = solicitudCreditoService.solicitudAprobacion(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listar datos del resumen ejecutivo.",
            notes = "retorna datos del resumen ejecutivo. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_RESU_RESO_CRED.")
    @RequestMapping(value = "/resumen-ejecutivo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResumenEjecutivoResponse listarResumenEjecutivo(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ResumenEjecutivoRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        ResumenEjecutivoResponse response = new ResumenEjecutivoResponse();

        try {
            response = solicitudCreditoService.listarResumenEjecutivo(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    @ApiOperation(value = "Exportar resumen Ejecutivo", notes = "Exportar "
            + "resumen ejecutivo para los clientes")
    @RequestMapping(value = "/pdf/exportar-resumen-ejecutivo", method = RequestMethod.GET)
    public ReporteResponse exportarResumenEjecutivo(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred,
            @ApiParam(value = "Tipo de Solicitud de Crédito")
            @RequestParam(name = "tipSoliCred", required = false) String tipSoliCred
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = solicitudCreditoService.exportarResumenEjecutivo(headerParams, codSoliCred, tipSoliCred);
            

        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
    
    @ApiOperation(value = "Registrar los vehiculos asignados a una solicitud de"
            + " de crédito",
            notes = "Registro de vehiculos de la solicitud de crédito"
            + "se utiliza el PKG_SWEB_CRED_SOLI.SP_INSE_CRED_SOLI_APROB")
    @RequestMapping(value = "/solicitar-aprobacion",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody SolicitudAprobacionRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = solicitudAprobacionService.registrar(headerParams, request);
        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        } 

        return response;
    }
    
    
    @ApiOperation(value = "Actualizar solicitud de aprobación",
            notes = "Actualizacion de datos de solicitud de aprobación"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_ACTU_CRED_SOLI_APROB")
    @RequestMapping(value = "/solicitar-aprobacion",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "910") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarSolicitudAprobacionRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = solicitudAprobacionService.actualizar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listar datos del Formato RDL.",
            notes = "retorna datos del Formato RDL. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_FORMATO_RECON_DEUDA.")
    @RequestMapping(value = "/formato-rdl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public FormatoRDLListadoResponse listarDatosFormatoLegal(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute FormatoRDLRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        FormatoRDLListadoResponse response = new FormatoRDLListadoResponse();

        try {
            response = solicitudAprobacionService.listaFormatoRDL(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Exportar formato RDL", notes = "Exportar "
            + "formato RDL contratos para Legal")
    @RequestMapping(value = "/excel/exportar-formato-rdl", method = RequestMethod.GET)
    public ReporteResponse exportarFormatoRDL(
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
            response = solicitudAprobacionService.exportarFormatoRDL(headerParams, codSoliCred);
        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
    
    
    @ApiOperation(value = "Exportar formato RDL Refinanciamiento", notes = "Exportar "
            + "formato RDL refinanciamiento para Legal")
    @RequestMapping(value = "/excel/exportar-formato-rdl-refinan", method = RequestMethod.GET)
    public ReporteResponse exportarFormatoRDLRefinanciamiento(
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
            response = solicitudAprobacionService.exportarFormatoRDLRefinanciamiento(headerParams, codSoliCred);
        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
    
    
    @ApiOperation(value = "Exportar formato RDL Mutuo", notes = "Exportar "
            + "formato RDL Mutuo para Legal")
    @RequestMapping(value = "/excel/exportar-formato-rdl-mutuo", method = RequestMethod.GET)
    public ReporteResponse exportarFormatoRDLMutuo(
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
            response = solicitudAprobacionService.exportarFormatoRDLMutuo(headerParams, codSoliCred);
        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
    
    //ECUBAS <I>89642
    @ApiOperation(value = "Listar",
            notes = "retorna datos. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_MOTIVOS_APROBACION")
    @RequestMapping(value = "/consultar-motivos-aprobacion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public MotivosAprobacionResponse consultarMotivosAprobacion(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestParam(name = "codSoliCred", required = false)  String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        MotivosAprobacionResponse response = new MotivosAprobacionResponse();

        try {
            response = solicitudAprobacionService.listarMotivosAprobacion(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    //ECUBAS <F>89642
    
    // <I> 90690 ivelasquez 21/09/2021
    @ApiOperation(value = "Listar",
            notes = "retorna datos. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_CRED_SOLI_APROB_HIS")
    @RequestMapping(value = "/consultar-historial-aprobacion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public HistorialAprobacionResponse consultarHistorialAprobacion(

            @ApiParam(value = "C�digo de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorizaci�n", required = true)
            @RequestHeader("token") String token,
            @RequestParam(name = "codSoliCred", required = false)  String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        HistorialAprobacionResponse response = new HistorialAprobacionResponse();

        try {
            response = solicitudAprobacionService.listarHistorialAprobacion(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listar solicitud de aprobación",
            notes = "Listar de datos de solicitud de aprobación"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_LISTA_CRED_SOLI_APROB")
    @RequestMapping(value = "/listar_soli_aprob",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse listarSoliAprob(
             @ApiParam(value = "C�digo de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorizaci�n", required = true)
            @RequestHeader("token") String token,
            @RequestBody SolicitudAprobacionRequest request
        ) {

            HeaderParams headerParams = new HeaderParams();
            headerParams.setCodUsuario(codUsuario);

            BaseResponse response;

            try {
                response = solicitudAprobacionService.listarSoliAprob(headerParams, request);
            } catch (Exception ex) {
                String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
                LOGGER.error(codigoError, ex);
                response = new BaseResponse();
                response.setEstadoTrama(codigoError);
            } 

            return response;
        }
    
        
    @ApiOperation(value = "Actualizar solicitud de aprobación personal",
            notes = "Actualizacion de datos de solicitud de aprobación"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_ACTUALIZA_CRED_SOLI_APROB")
    @RequestMapping(value = "/actu-solicitar-aprobacion",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarAprobacion(
            @ApiParam(value = "C�digo de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "910") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorizaci�n")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarSolicitudAprobacionRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = solicitudAprobacionService.actualizarAprob(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    // <F> 90690 ivelasquez 21/09/2021
}
