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
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.AvalRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AvalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.AvalService;

@RestController
@RequestMapping("/api")
public class AvalController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private AvalService avalService;

    @Autowired
    public void setAvalService(AvalService avalService) {
        this.avalService = avalService;
    }
    
    @ApiOperation(value = "Listado de Avales de la solicitud",
            notes = "Retorna el listado de documentos se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_list_aval")
    @RequestMapping(value = "/avales/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AvalListadoResponse listar(
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

        AvalListadoResponse response = null;

        try {
            response = avalService.listar(headerParams,codSoliCred);

        } catch (Exception ex) {
            response = new AvalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Avales Historicos x solicitud",
            notes = "Retorna el listado históricos. Se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_list_aval_histo")
    @RequestMapping(value = "/avales/historico/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AvalListadoResponse listarAvalesHistorico(
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

        AvalListadoResponse response = null;

        try {
            response = avalService.listarAvalesHistorico(headerParams,codSoliCred);

        } catch (Exception ex) {
            response = new AvalListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Paises del aval",
            notes = "Retorna el listado de paises, se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_listado_paises")
    @RequestMapping(value = "/avales/paises"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PaisListadoResponse listarPaises(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @RequestParam(value="codigoCia", required = false) String codigoCia
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        PaisListadoResponse response = null;

        try {
            response = avalService.listarPaises(headerParams, codigoCia);

        } catch (Exception ex) {
            response = new PaisListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Listado de Departamentos del aval",
            notes = "Retorna el listado de departamentos, se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_listado_departamentos")
    @RequestMapping(value = "/avales/departamentos"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DepartamentoListadoResponse listarDepartamentos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            //@PathVariable("codigo-pais") String codPais
            @RequestParam(value="codigoPais", required = false) String codigoPais
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DepartamentoListadoResponse response = null;

        try {
            response = avalService.listarDepartamentos(headerParams,codigoPais);

        } catch (Exception ex) {
            response = new DepartamentoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listado de Provincias del aval",
            notes = "Retorna el listado de provincias por departamento, se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_listado_provincias")
    @RequestMapping(value = "/avales/provincias"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProvinciaListadoResponse listarProvincias(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @RequestParam(value="codigoDepartamento", required = false) String codigoDepartamento
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ProvinciaListadoResponse response = null;

        try {
            response = avalService.listarProvincias(headerParams,codigoDepartamento);

        } catch (Exception ex) {
            response = new ProvinciaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Distritos del aval",
            notes = "Retorna el listado de distritos por departamento y provincia, se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_listado_distritos")
    @RequestMapping(value = "/avales/distritos"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DistritoListadoResponse listarDistritos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @RequestParam(value="codigoProvincia", required = false) String codigoProvincia
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DistritoListadoResponse response = null;

        try {
            response = avalService.listarDistritos(headerParams, codigoProvincia);

        } catch (Exception ex) {
            response = new DistritoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Actualiza la url en los avales del usuario luego de formular un comentario",
            notes = "El aval fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_act_docu_soli")
    @RequestMapping(value = "/avales",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody AvalRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = avalService.insertar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Actualiza los avales elimandolos "
            + "luego de formular un comentario",
            notes = "El aval fue eliminado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_AVAL.sp_eli_aval_soli")
    @RequestMapping(value = "/avales/eliminar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody AvalRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = avalService.eliminar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Elimina un aval actualizando su respectiva solicitud de credito con estado ind_inactivo['S'] ",
            notes = "El aval fue eliminado. Se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_eli_by_aval")
    @RequestMapping(value = "/avales/eliminarbyaval",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminarbyaval(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody AvalRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = avalService.eliminarbyaval(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
