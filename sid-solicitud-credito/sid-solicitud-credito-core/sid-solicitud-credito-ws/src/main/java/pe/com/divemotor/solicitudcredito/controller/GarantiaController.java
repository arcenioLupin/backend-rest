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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CoberturaGarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaHistoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.GarantiaService;

@RestController
@RequestMapping("/api")
public class GarantiaController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private GarantiaService garantiaService;

    @Autowired
    public void setGarantiaService(GarantiaService documentoService) {
        this.garantiaService = documentoService;
    }
    
    @ApiOperation(value = "Listado de Garantias "
            + "de la solicitud",
            notes = "Retorna el listado de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli")
    @RequestMapping(value = "/garantias/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GarantiaListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indTipoGarantia", required = false) String indTipoGarantia
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        GarantiaListadoResponse response = null;

        try {
            response = garantiaService.listar(headerParams,codSoliCred,indTipoGarantia);

        } catch (Exception ex) {
            response = new GarantiaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Actualiza la garantia Hipotecaria o Inmobiliaria ",
            notes = "La  garantía fue actualizada "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_GARANTIA.sp_ins_gara_soli")
    @RequestMapping(value = "/garantias",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GarantiaResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody GarantiaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        GarantiaResponse response;

        try {
            response = garantiaService.insertar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new GarantiaResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Garantias "
            + "de la solicitud",
            notes = "Retorna el listado de garantias adicionales "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_GARANTIA.sp_list_garantia_histo")
    @RequestMapping(value = "/garantias/historico/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GarantiaHistoListadoResponse listarHistorico(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indTipoGarantia", required = false) String indTipoGarantia,
            @RequestParam(value="codCliente", required = false) String codCliente,
            @RequestParam(value="numPedidoVeh", required = false) String numPedidoVeh
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        GarantiaHistoListadoResponse response = null;

        try {
            response = garantiaService.listarHistorico(headerParams, codSoliCred, indTipoGarantia, codCliente, numPedidoVeh);

        } catch (Exception ex) {
            response = new GarantiaHistoListadoResponse();
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
    @RequestMapping(value = "/garantias/eliminar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody GarantiaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = garantiaService.eliminar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Elimina la garantia cambiando ind_inactivo='S' la solicitud selecccionada",
            notes = "El documento fue actualizado. Se utilizar el PKG_SWEB_CRED_SOLI_GARANTIA.sp_eli_by_gara")
    @RequestMapping(value = "/garantias/eliminarByGara",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse eliminarByGara(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody GarantiaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = garantiaService.eliminarByGara(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    
    @ApiOperation(value = "Listado de Paises del aval",
            notes = "Retorna el listado de paises, se utiliza el PKG_SWEB_CRED_SOLI_AVAL.sp_listado_paises")
    @RequestMapping(value = "/garantias/paises"
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
            response = garantiaService.listarPaises(headerParams, codigoCia);

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
    @RequestMapping(value = "/garantias/departamentos"
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
            response = garantiaService.listarDepartamentos(headerParams,codigoPais);

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
    @RequestMapping(value = "/garantias/provincias"
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
            response = garantiaService.listarProvincias(headerParams,codigoDepartamento);

        } catch (Exception ex) {
            response = new ProvinciaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listado de Distritos del aval",
            notes = "Retorna el listado de distritos por departamento y provincia, se utiliza el PKG_SWEB_CRED_SOLI_GARANTIA.sp_listado_distritos")
    @RequestMapping(value = "/garantias/distritos"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DistritoListadoResponse listarDistritos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @RequestParam(value="codigoProvincia", required = false) String codigoProvincia,
            // I Req. 87567 E2.1 ID avilca 03/06/2020
            @RequestParam(value="codigoDepartamento", required = false) String codigoDepartamento
            // F Req. 87567 E2.1 ID avilca 03/06/2020
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        DistritoListadoResponse response = null;

        try {
            // I Req. 87567 E2.1 ID avilca 03/06/2020
            response = garantiaService.listarDistritos(headerParams, codigoProvincia,codigoDepartamento);
            // F Req. 87567 E2.1 ID avilca 03/06/2020 
        } catch (Exception ex) {
            response = new DistritoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    // <I> 90690 ivelasquez 21/09/2021
    @ApiOperation(value = "Consultar Garantias de la solicitud",
            notes = "Retorna valor de existencia de garantia"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_GARANTIA.sp_count_garantias")
    @RequestMapping(value = "/consultar-garantias/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse consultarGarantias(
            @ApiParam(value = "Crédito de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorizaci�n", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        BaseResponse response;

        try {
            response = garantiaService.consultarGarantias(headerParams,codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    // <F> 90690 ivelasquez 21/09/2021
    // <I> 89645 ivelasquez 22/09/2021
    @ApiOperation(value = "Consultar Garantias de la solicitud",
            notes = "Retorna valor de existencia de garantia"
            + "se utiliza el PKG_SWEB_CRED_SOLI_GARANTIA.sp_list_cobergara_fc")
    @RequestMapping(value = "/lista-cobertura-garantias/{codigo-solicitud}",
             method = RequestMethod.GET,
             produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CoberturaGarantiaResponse listarCoberturaGarantias(
            @ApiParam(value = "Crédito de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorizaci�n", required = true)
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        CoberturaGarantiaResponse response = new CoberturaGarantiaResponse();

        try {
            response = garantiaService.listarCoberturaGarantia(headerParams, codSoliCred);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new CoberturaGarantiaResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    // <I> 89645 ivelasquez 22/09/2021
}
