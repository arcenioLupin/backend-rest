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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.EntidadFinancieraListadoResponse;
import pe.com.divemotor.solicitudcredito.services.EntidadFinancieraService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class BancoController {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private EntidadFinancieraService efService;

    @Autowired
    public void setEfService(EntidadFinancieraService efService) {
        this.efService = efService;
    }

    @ApiOperation(value = "Listado de Bancos para la CartaBanco de la solicitud",
           //<I Req. 87567 E2.1 Carta Banco avilca 21/02/2020>
           notes = "Retorna el listado de Bancos se utiliza el PKG_SWEB_GEST_CLIE.sp_list_enti_fina")
           //<F Req. 87567 E2.1 Carta Banco avilca 21/02/2020>
    @RequestMapping(value = "/bancos/{codigo-solicitud}",
             method = RequestMethod.GET,
             produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EntidadFinancieraListadoResponse listar(
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

        EntidadFinancieraListadoResponse response = null;

        try {
            response = efService.listar(headerParams, codSoliCred);

        } catch (Exception ex) {
            response = new EntidadFinancieraListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

}
