package pe.com.divemotor.solicitudcredito.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoCBRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarGestionBancariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoSNRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosSolicitudHORequest;
import pe.com.divemotor.solicitudcredito.dto.request.HistoricoOperacionesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaDatosResolucionRequestRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParamRegSolcreRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaRolesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudHistoricoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DatosResolucionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoCBListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DatosSolicitudHOResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParamRegSolcreListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PermisosListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoSNListadoResponse;
import pe.com.divemotor.solicitudcredito.services.SolicitudCreditoService;
import pe.com.divemotor.generico.dto.Item;
import pe.com.divemotor.solicitudcredito.dto.request.ListarClienteCreditosMovimientosRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteCreditosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteMovimientosResponse;

@RestController
@RequestMapping("/api")
public class SolicitudCreditoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private SolicitudCreditoService solicitudCreditoService;

    @Autowired
    public void setSolicitudCreditoService(SolicitudCreditoService solicitudCreditoService) {
        this.solicitudCreditoService = solicitudCreditoService;
    }

    @ApiOperation(value = "Registrar solicitud de crédito",
            notes = "Registro basico de solicitud de crédito realizado "
            + "desde la proforma, "
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_INSE_CRED_SOLI")
    @RequestMapping(value = "/solicitudes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SolicitudCreditoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoService.registrar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar solicitudes de crédito",
            notes = "retorna una lista de solicitudes de crédito en base a los filtros. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_CRED_SOLI.")
    @RequestMapping(value = "/solicitudes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SolicitudCreditoListadoResponse listar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
            @ApiParam(value = "Número de la pagina a consultar", required = true, defaultValue = "1") @RequestHeader String nroPag,
            @ApiParam(value = "Número de registro por página", required = true, defaultValue = "10") @RequestHeader String cantidadxPag,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaSolicitudCreditoRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(Integer.parseInt(idUsuario));
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));

        SolicitudCreditoListadoResponse response = new SolicitudCreditoListadoResponse();

        try {
            response = solicitudCreditoService.listar(headerParams, request);
            
        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualizar solicitud de crédito",
            notes = "Actualizacion de datos de solicitud de crédito"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_UPDATE_CRED_SOLI")
    @RequestMapping(value = "/solicitudes",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarSolicitudCreditoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(Integer.valueOf(idUsuario));/* Req. 87567 E2.1 ID:20 avilca 10/06/2020*/
        request.setCodUsuaSid(codUsuario);//Req. 87567 E2.1 ID## avilca 16/06/2020
        BaseResponse response;

        try {
            response = solicitudCreditoService.actualizar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Actualizar solicitud de crédito",
            notes = "Actualizacion de datos de gestion bancaria"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_ACTU_GEST_BANC")
    @RequestMapping(value = "/solicitudes/actualizarGestion",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarGestionBancaria(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarGestionBancariaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoService.actualizarGestion(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar solicitudes de crédito carta banco",
            notes = "Retorna la solicitud de credito con su carta banco. Procedure PKG_SWEB_CRED_SOLI_CART_BANC.SP_LIST_CRED_SOLI_CB")
    @RequestMapping(value = "/solicitudesCB/{codigo-solicitud}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SolicitudCreditoCBListadoResponse listarSoliCartaBanco(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SolicitudCreditoCBListadoResponse response = new SolicitudCreditoCBListadoResponse();

        try {
            response = solicitudCreditoService.listarSoliCartaBanco(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualizar solicitud de crédito",
            notes = "Actualizacion de datos de la carta banco en la gestion bancaria. Procedure PKG_SWEB_CRED_SOLI_CART_BANC.SP_ACTU_CRED_SOLI_CB")
    @RequestMapping(value = "/solicitudes/actualizarCartaBanco",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarCartaBanco(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarSolicitudCreditoCBRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        BaseResponse response;

        try {
            response = solicitudCreditoService.actualizarCartaBanco(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar solicitudes de crédito ",
            notes = "Retorna la solicitud de credito con las fechas de los documentos suscritos en notaria. "
            + "Procedure PKG_SWEB_CRED_SOLI_SUSC_NOTA.SP_LIST_CRED_SOLI_SN")
    @RequestMapping(value = "/solicitudesSN/{codigo-solicitud}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SolicitudCreditoSNListadoResponse listarSoliSuscripNotaria(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SolicitudCreditoSNListadoResponse response = new SolicitudCreditoSNListadoResponse();

        try {
            response = solicitudCreditoService.listarSoliSuscripNotaria(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Actualizar solicitud de crédito",
            notes = "Actualizacion de las fechas de suscripcion de documentos en notaria"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI_SUSC_NOTA.SP_ACTU_CRED_SOLI_SN")
    @RequestMapping(value = "/solicitudesSN/actualizarSoliSuscripNotaria",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarSoliSuscripNotaria(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ActualizarSolicitudCreditoSNRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        BaseResponse response;

        try {
            response = solicitudCreditoService.actualizarSoliSuscripNotaria(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar datos de la solicitud para Historico de Oper.",
            notes = "retorna datos para el Historico de Operaciones. Procedure PKG_SWEB_CRED_SOLI.SP_DATOS_HIST_OPER.")
    @RequestMapping(value = "/datos-solicitud-ho", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DatosSolicitudHOResponse listarDatosSolicitudHO(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute DatosSolicitudHORequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        DatosSolicitudHOResponse response = new DatosSolicitudHOResponse();

        try {
            response = solicitudCreditoService.listarDatosSolicitudHO(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Listar datos de la solicitud para la resolucion de C.",
            notes = "retorna datos para la Resolucion de Creditos. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_CRED_SOLI_RESO_CRED.")
    @RequestMapping(value = "/datos-solicitud-rc",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public DatosResolucionListadoResponse listarDatosResolucion(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ")
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901")
            @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaDatosResolucionRequestRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        DatosResolucionListadoResponse response = new DatosResolucionListadoResponse();

        try {
            response = solicitudCreditoService.listarDatosSolicitudRC(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Permisos de usuario",
            notes = "Retorna lista de permisos asignados al "
            + "usuario para la gestión de crédito"
            + ", se utilizo el SP PKG_SWEB_CRED_SOLI.SP_LIST_PERM_USUA_SOLCRE")
    @RequestMapping(value = "/solicitudes/{codigo}/permisos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public PermisosListadoResponse listaPermisos(
            @ApiParam(value = "Código de Solicitud", required = true)
            @PathVariable("codigo") String codSoliCred,
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token
    ) {
        PermisosListadoResponse response = new PermisosListadoResponse();

        try {
            HeaderParams headerParams = new HeaderParams();
            headerParams.setCodUsuario(codUsuario);
            headerParams.setIdUsuario(idUsuario);
            headerParams.setToken(token);

            response = solicitudCreditoService.listarPermisos(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listar datos de los roles asignados",
            notes = "retorna datos de los usuarios por rol. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_ROLES.")
    @RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public RolesListadoResponse listarRoles(
            @ApiParam(value = "Código de usuario", required = false)
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true)
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaRolesRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        RolesListadoResponse response = new RolesListadoResponse();

        try {
            response = solicitudCreditoService.listarRoles(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    
    
    @ApiOperation(value = "Registrar la cabecera de solicitud historico",
            notes = "Registro basico de la cabecera de la solicitud historico "
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_INSE_CRED_SOLI_HIST")
    @RequestMapping(value = "/solicitudHistorico",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarSolicitudHistorico(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = true, defaultValue = "ACRUZ") String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = true) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SolicitudHistoricoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoService.registrarSolicitudHistorico(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Registrar detalle historico de operaciones",
            notes = "Registro basico del detalle de historico de operaciones "
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_INSE_CRED_HIST_OPE")
    @RequestMapping(value = "/historicoOperaciones",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarHistoricoOperaciones(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = true, defaultValue = "ACRUZ") String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = true) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody HistoricoOperacionesRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = solicitudCreditoService.registrarHistoricoOperaciones(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    //<I-89783>    
    @ApiOperation(value = "Obtener vendedor y responsable",
    notes = "retorna el vendedor y responsable en caso pertenezca a otro vendedor. Procedure PKG_SWEB_CRED_SOLI.SP_OBTEN_RESPONSABLES_SOLCRE")
    @RequestMapping(value = "/responsables/solicitudCredito", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse responsablesSolcre(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = true, defaultValue = "ACRUZ") String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = true) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred) {       
         BaseResponse response;
         HeaderParams headerParams = new HeaderParams();
        try {
            response = solicitudCreditoService.obtenerResponsablesSolcre(headerParams,codSoliCred);
        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
        }
        return response;
    }
   //<F-89783>    

//I Req. 87567 E2.1 ID:9 AVILCA 12/05/2020    
    @ApiOperation(value = "Listar parametros para registro de solicitud de crédito",
            notes = "retorna parametros para el registro de solicitud de crédito. Procedure PKG_SWEB_CRED_SOLI.sp_list_param_solcre.")
    @RequestMapping(value = "/listarParametrosRegistroSolcre", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ParamRegSolcreListadoResponse listarParametrosRegistroSolcre(
            @ApiParam(value = "Código de usuario", required = false)
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true)
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListaParamRegSolcreRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ParamRegSolcreListadoResponse response = new ParamRegSolcreListadoResponse();

        try {
            response = solicitudCreditoService.listarParametrosRegistroSolcre(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }  
//F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020  
    
//I Req. 87567 E2.1 ID:9 AVILCA 10/02/2021    
    @ApiOperation(value = "Listar información de créditos del cliente ",
            notes = "retorna información de créditos del cliente. Procedure PKG_SWEB_CRED_SOLI.sp_list_clie_creditos.")
    @RequestMapping(value = "/listarClienteCreditos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ListaClienteCreditosResponse listarClienteCreditos(
            @ApiParam(value = "Código de usuario", required = false)
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true)
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListarClienteCreditosMovimientosRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ListaClienteCreditosResponse response = new ListaClienteCreditosResponse();

        try {
            response = solicitudCreditoService.listarClienteCreditos(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    } 
    
 @ApiOperation(value = "Listar información de movimientos del cliente ",
            notes = "retorna información de movimientos del cliente. Procedure PKG_SWEB_CRED_SOLI.sp_list_clie_movimientos.")
    @RequestMapping(value = "/listarClienteMovimientos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ListaClienteMovimientosResponse listarClienteMovimientos(
            @ApiParam(value = "Código de usuario", required = false)
            @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true)
            @RequestHeader("idUsuario") Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ListarClienteCreditosMovimientosRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ListaClienteMovimientosResponse response = new ListaClienteMovimientosResponse();

        try {
            response = solicitudCreditoService.listarClienteMovimientos(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }      
//F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020   
    
}
