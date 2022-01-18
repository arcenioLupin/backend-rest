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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteCreditoOtorgadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoResponse;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditoOtorgadoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class ReporteCreditoOtorgadoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ReporteCreditoOtorgadoService service;

    @Autowired
    public void setService(ReporteCreditoOtorgadoService service) {
        this.service = service;
    }

    @ApiOperation(value = "Listado de información de los creditos otorgados a clentes",
            notes = "Retorna el listado de información de los creditos otorgados a clentes."
            + "se utiliza el PKG_SWEB_CRED_REPO_CO.SP_LIST_CRED_SOLI_CO")
    @RequestMapping(value = "/reporteCO",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReporteCreditoOtorgadoListadoResponse listar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ReporteCreditoOtorgadoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ReporteCreditoOtorgadoListadoResponse response = null;

        try {

            response = service.listarCreditoOtorgado(headerParams, request);

        } catch (Exception ex) {
            response = new ReporteCreditoOtorgadoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de credito otorgado")
    @RequestMapping(value = "/excel/reporteCO", method = RequestMethod.GET)
    public ReporteCreditoOtorgadoResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ReporteCreditoOtorgadoRequest request
    ) {
        ReporteCreditoOtorgadoListadoResponse response = null;
        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        ReporteCreditoOtorgadoResponse rcoResponse;

        try {

            response = service.listarCreditoOtorgado(headerParams, request);
            rcoResponse = service.exportarCreditoOtorgado(headerParams, response.getListado());

        } catch (Exception ex) {
            rcoResponse = new ReporteCreditoOtorgadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            rcoResponse.setEstadoTrama(codigoError);
        }
        return rcoResponse;
    }

}
