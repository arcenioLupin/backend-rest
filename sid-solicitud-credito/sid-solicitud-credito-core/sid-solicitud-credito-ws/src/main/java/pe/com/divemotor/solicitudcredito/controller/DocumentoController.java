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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.DocumentoService;

@RestController
@RequestMapping("/api")
public class DocumentoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private DocumentoService documentoService;

    @Autowired
    public void setDocumentoService(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }
    
    @ApiOperation(value = "Listado de Documentos "
            + "de la solicitud",
            notes = "Retorna el listado de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli")
    @RequestMapping(value = "/documentos/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indMancomunado", required = false) String indMancomunado,
            @RequestParam(value="codTipoPerso", required = false) String codTipoPerso,
            @RequestParam(value="codEstadoCivil", required = false) String codEstadoCivil
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listar(headerParams,codSoliCred,indMancomunado,codTipoPerso,codEstadoCivil);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    //-----I--90028:Dante Artica
    @ApiOperation(value = "Listado de Tipos de Documentos"
            + "de la solicitud",
            notes = "Retorna el listado de Tipos de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli_combo")
    @RequestMapping(value = "/documentos/tipos/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarTiposDocumeto(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indMancomunado", required = false) String indMancomunado,
            @RequestParam(value="codTipoPerso", required = false) String codTipoPerso,
            @RequestParam(value="codEstadoCivil", required = false) String codEstadoCivil
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listarTiposDocumeto(headerParams,codSoliCred,indMancomunado,codTipoPerso,codEstadoCivil);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
     @ApiOperation(value = "Listado de Documentos Anteriores"
            + "de la solicitud",
            notes = "Retorna el listado de documentos Anteriores"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_lista_adjuntos_anteriores")
    @RequestMapping(value = "/documentos/antes/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarAdjuntosAnteriores(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indMancomunado", required = false) String indMancomunado,
            @RequestParam(value="codTipoPerso", required = false) String codTipoPerso,
            @RequestParam(value="codEstadoCivil", required = false) String codEstadoCivil
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listarAdjuntosAnteriores(headerParams,codSoliCred,indMancomunado,codTipoPerso,codEstadoCivil);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
     
    //-----F--90028:Dante Artica
    
    @ApiOperation(value = "Actualiza la url en los documentos del usuario "
            + "luego de formular un comentario",
            notes = "El documento fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_act_docu_soli")
    @RequestMapping(value = "/documentos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DocumentoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = documentoService.actualizar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Actualiza la url en los documentos del usuario "
            + "luego de formular un comentario",
            notes = "El documento fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_act_docu_soli")
    @RequestMapping(value = "/documentos/eliminar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DocumentoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = documentoService.eliminar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Documentos "
            + "de la solicitud",
            notes = "Retorna el listado de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli")
    @RequestMapping(value = "/documentos/general/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarGeneral(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indMancomunado", required = false) String indMancomunado,
            @RequestParam(value="codTipoPerso", required = false) String codTipoPerso,
            @RequestParam(value="codEstadoCivil", required = false) String codEstadoCivil,
            @RequestParam(value="tipoDocu", required = false) String tipoDocu,
            @RequestParam(value="codProceso", required = false) String codProceso,
            @RequestParam(value="indTipoDocu", required = false) String indTipoDocu
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listarGeneral(headerParams,codSoliCred,indMancomunado,codTipoPerso,codEstadoCivil,tipoDocu,codProceso,indTipoDocu);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Actualiza la url en los documentos del usuario "
            + "luego de formular un comentario",
            notes = "El documento fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_act_docu_soli")
    @RequestMapping(value = "/documentos/general",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarGeneral(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DocumentoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = documentoService.actualizarGeneral(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Actualiza la url en los documentos del usuario "
            + "luego de formular un comentario",
            notes = "El documento fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_act_docu_soli")
    @RequestMapping(value = "/documentos/general/eliminar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminarGeneral(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DocumentoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = documentoService.eliminarGeneral(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Listado de información de documentos legales",
            notes = "Retorna el listado de información de documentos legales."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_DOCU.SP_LIST_DOCU")
    @RequestMapping(value = "/documentos/listarConsulta",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarConsulta(
    @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
    @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
    @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
    @ApiParam(value = "Número de la pagina a consultar", required = true) @RequestHeader String nroPag,
    @ApiParam(value = "Número de registro por página", required = true) @RequestHeader String cantidadxPag,
    @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
    @ModelAttribute DocumentoRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));

        DocumentoListadoResponse response;

        try {

            response = documentoService.listarConsulta(headerParams, request);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Actualización del Documento Legal ",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_DOCU.SP_ACT_DOCU")
    @RequestMapping(value = "/documentos/actualizarDocumento",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizarDocumento(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody DocumentoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = documentoService.actualizarDocumento(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
 @ApiOperation(value = "Listado de Documentos legales "
            + "de la solicitud",
            notes = "Retorna el listado de documentos legales"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_DOCU.SP_LIST_DOCU_LEGAL")
    @RequestMapping(value = "/documentos/legal/{ind-tipo-docu}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarDocLegales(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("ind-tipo-docu") String indTipoDocu
           
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listarDocLegales(headerParams,indTipoDocu);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }  
    
 @ApiOperation(value = "Listado de Documentos legales "
            + "de la solicitud",
            notes = "Retorna el listado de documentos legales asociados al tipo de documento"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_DOCU.SP_OBTIENE_DOCU_LEGAL")
    @RequestMapping(value = "/documentos/legalxcodlegal/{cod_doclegal}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DocumentoListadoResponse listarDocLegalesXCodLeg(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("cod_doclegal") String codDocLeg
           
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DocumentoListadoResponse response = null;

        try {
            response = documentoService.listarDocLegalesXCodLeg(headerParams,codDocLeg);

        } catch (Exception ex) {
            response = new DocumentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }        
}


