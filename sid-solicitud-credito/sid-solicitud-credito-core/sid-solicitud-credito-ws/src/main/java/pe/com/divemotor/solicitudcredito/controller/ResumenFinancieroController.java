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
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroMaturityRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenFinancieroListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ResumenFinancieroService;

@RestController
@RequestMapping("/api")
public class ResumenFinancieroController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ResumenFinancieroService resumenFinancieroService;

    @Autowired
    public void setResumenFinancieroService(ResumenFinancieroService resumenFinancieroService) {
        this.resumenFinancieroService = resumenFinancieroService;
    }
    
  @ApiOperation(value = "Listado de estados financieros "
            + "de los últimos 4 años",
            notes = "Listado de estados financieros de los últimos 4 años"
                    + "se utiliza el PKG_SWEB_CRED_SOLI_FINANCIERO.sp_list_resumen")
    @RequestMapping(value = "/resumenFinanciero/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public ResumenFinancieroListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="codcliente", required = false) String codcliente
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ResumenFinancieroListadoResponse response = null;

        try {
            response = resumenFinancieroService.listar(headerParams,codSoliCred,codcliente);

        } catch (Exception ex) {
            response = new ResumenFinancieroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
     
  @ApiOperation(value = "Listado de estados financieros "
            + "en un rango de años",
            notes = "Listado de estados financieros en un rango de años "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_FINANCIERO.sp_list_resumen_rango")
    @RequestMapping(value = "/resumenFinancieroRango/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public ResumenFinancieroListadoResponse listarRangos(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="codcliente", required = false) String codcliente,
            @RequestParam(value="anioInf", required = false) String anioInf,
            @RequestParam(value="anioSup", required = false) String anioSup
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ResumenFinancieroListadoResponse response = null;

        try {
            response = resumenFinancieroService.listarRangos(headerParams,codSoliCred,codcliente,anioSup,anioInf);

        } catch (Exception ex) {
            response = new ResumenFinancieroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }     
    
    @ApiOperation(value = "Actualiza los estados financieros "
            + "por año",
            notes = "El Estado financiero fue actualizado "+
                    "Se utiliza el PKG_SWEB_CRED_SOLI_FINANCIERO.sp_ins_resumen")
    @RequestMapping(value = "/resumenFinanciero",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ResumenFinancieroRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = resumenFinancieroService.insertar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
   
    @ApiOperation(value = "Actualiza la sección de maturity en el Resumen Financiero",
            notes = "Maturity fue actualizado "+
                    "Se utilizar el PKG_SWEB_CRED_SOLI_FINANCIERO.sp_ins_resumen_maturity")
    @RequestMapping(value = "/resumenFinancieroMaturity",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarMaturity(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody ResumenFinancieroMaturityRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = resumenFinancieroService.insertarMaturity(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }    
    
}
