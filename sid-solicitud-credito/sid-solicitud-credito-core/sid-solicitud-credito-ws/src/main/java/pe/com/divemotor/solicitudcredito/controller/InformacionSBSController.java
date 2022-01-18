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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.InformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaInformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.response.InformacionSBSListadoResponse;
import pe.com.divemotor.solicitudcredito.services.InformacionSBSService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author legutierrez
 */

@RestController
@RequestMapping("/api")
public class InformacionSBSController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private InformacionSBSService informacionSBSService;

    @Autowired
    public void setInformacionSBSService(InformacionSBSService informacionSBSService) {
        this.informacionSBSService = informacionSBSService;
    }
    
    @ApiOperation(value = "Registrar la informacion SBS de un cliente",
            notes = "Registro de informacion SBS de un cliente segun solicitud"
            + "se utiliza el SP PKG_SWEB_CRED_SOLI.SP_INSE_INFO_SBS")
    @RequestMapping(value = "/informacionSBS",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody InformacionSBSRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);

        BaseResponse response;

        try {
            response = informacionSBSService.registrar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Listar la informacion SBS de una cliente", 
            notes = "retorna los datos de la informacion SBS de un cliente. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_INFO_SBS.")
    @RequestMapping(value = "/informacionSBS", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public InformacionSBSListadoResponse listar(
            @ApiParam(value = "Código de usuario", required = true) @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaInformacionSBSRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        InformacionSBSListadoResponse response = new InformacionSBSListadoResponse();

        try {
            response = informacionSBSService.listar(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
}
