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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ClienteService;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosVCService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class ClienteController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ClienteService service;
    
    private ReporteCreditosVCService vcservice;

  
    @Autowired
    public void setService(ClienteService service) {
        this.service = service;
    }
    
    @Autowired
    public void setVcservice(ReporteCreditosVCService vcservice) {
        this.vcservice = vcservice;
    }
    
    @ApiOperation(value = "Listado de información del cliente",
            notes = "Retorna el listado de información del cliente."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.SP_LIST_CLIENTES")
    @RequestMapping(value = "/consultaClie",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClienteListadoResponse consultaClie(
    @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
    @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
    @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
    @ApiParam(value = "Número de la pagina a consultar", required = true) @RequestHeader String nroPag,
    @ApiParam(value = "Número de registro por página", required = true) @RequestHeader String cantidadxPag,
    @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
    @ModelAttribute ClienteRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));

        ClienteListadoResponse response;

        try {

            response = service.listarClientes(headerParams, request);

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
  @ApiOperation(value = "Listado de todos los clientes",
            notes = "Retorna el listado de todos los clientes."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.SP_LIST_TODOS_CLIENTES")
    @RequestMapping(value = "/consultaTodosClie",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClienteListadoResponse consultaTodosClie(
    @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
    @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
    //@ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
    //@ApiParam(value = "Número de la pagina a consultar", required = true) @RequestHeader String nroPag,
    //@ApiParam(value = "Número de registro por página", required = true) @RequestHeader String cantidadxPag,
    @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
    @ModelAttribute ClienteRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIndPaginado("0");
        headerParams.setNroPag(0);
        headerParams.setCantidadxPag(0);

        ClienteListadoResponse response;

        try {
             
            response = service.listarTodosClientes(headerParams, request);

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }    
    
    @ApiOperation(value = "Listado de información de la solicitud referente al cliente",
            notes = "Retorna el listado de información de la solicitud referente al cliente."
            + "se utiliza el PKG_SWEB_CRED_REPO_VC.SP_LIST_CRED_SOLI_VC")
    @RequestMapping(value = "/getDetallePorCliente",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClienteListadoResponse getDetallePorCliente(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ClienteRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        
        ClienteListadoResponse response = new ClienteListadoResponse();
        
        try {
            
            response = service.getDetalleInfoCliente(headerParams, request);
            
        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de operaciones del cliente",
            notes = "Retorna el listado de operaciones referente al cliente."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.SP_LIST_OPERS")
    @RequestMapping(value = "/getOperacionesPorCliente",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClienteListadoResponse getOperacionesPorCliente(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ClienteRequest request
    ) {
        
        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        
        ClienteListadoResponse response = new ClienteListadoResponse();

        try {

            response = service.listarOperacionesPorCliente(headerParams, request);

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
        
        
    }
    
    
    @ApiOperation(value = "Listado de garantias del cliente",
            notes = "Retorna el listado de garantias referente al cliente."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.SP_LIST_GARAN")
    @RequestMapping(value = "/getGarantiasPorCliente",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClienteListadoResponse getGarantiasPorCliente(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ClienteRequest request
    ) {
        
        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        
        ClienteListadoResponse response = new ClienteListadoResponse();

        try {

            response = service.listarGarantiasPorCliente(headerParams, request);

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Valida que la Garantia del Cliente, cubra la deuda adquirida",
            notes = "No se utiliza procedimiento alguno")
    @RequestMapping(value = "/validarGarantiaCliente",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse validarGarantiaCliente(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ClienteRequest request
    ) {
        
        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        
        BaseResponse response = new BaseResponse();

        try {

            response = service.validarGarantiaCliente(headerParams, request);

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Actualiza el estado de una garantía Hipotecaria/Mobiliaria de un cliente ",
            notes = "Se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.SP_ACT_GARANTIA")
    @RequestMapping(value = "/updateGarantia",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse updateGarantia(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ClienteRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = service.updateGarantia(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    /*@ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte del cliente")
    @RequestMapping(value = "/excel/reporteClie", method = RequestMethod.GET)
    public ClienteResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S")
            @RequestHeader String indPaginado,
            @ApiParam(value = "Número de la pagina a consultar", required = true, defaultValue = "1")
            @RequestHeader String nroPag,
            @ApiParam(value = "Número de registro por página", required = true, defaultValue = "10")
            @RequestHeader String cantidadxPag,
            @ModelAttribute ClienteRequest request
    ) {
        ClienteListadoResponse response = null;

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setIndPaginado(indPaginado);
        headerParams.setNroPag(Integer.parseInt(nroPag));
        headerParams.setCantidadxPag(Integer.parseInt(cantidadxPag));

        ClienteResponse clienteResponse = new ClienteResponse();

        try {
            response = service.listarClientes(headerParams, request);
            clienteResponse = service.exportarCliente(headerParams, response.getListado().get(0));

        } catch (Exception ex) {
            clienteResponse = new ClienteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            clienteResponse.setEstadoTrama(codigoError);
        }
        return clienteResponse;
    }*/

    /* Req. Obs Consulta Cliente MBardales 16/10/2020 */
    @ApiOperation(value = "Listado paises " ,
            notes = "Retorna el listado de paises "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.sp_listado_paises")
    @RequestMapping(value = "/cliente/paises/{tipo}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarPaises(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = service.listarPaises(headerParams, tipo);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado filiales por zona " ,
            notes = "Retorna el listado de filiales por zona "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.sp_listado_departamentos")
    @RequestMapping(value = "/cliente/departamentos/{tipo}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarDepartamentos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = service.listarDepartamentos(headerParams, tipo);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado filiales por zona " ,
            notes = "Retorna el listado de filiales por zona "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.sp_listado_provincias")
    @RequestMapping(value = "/cliente/provincias/{tipo}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarProvincias(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = service.listarProvincias(headerParams, tipo);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado filiales por zona " ,
            notes = "Retorna el listado de filiales por zona "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_CLIE.sp_listado_distritos")
    @RequestMapping(value = "/cliente/distritos/{tipo}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarDistritos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = service.listarDistritos(headerParams, tipo);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
