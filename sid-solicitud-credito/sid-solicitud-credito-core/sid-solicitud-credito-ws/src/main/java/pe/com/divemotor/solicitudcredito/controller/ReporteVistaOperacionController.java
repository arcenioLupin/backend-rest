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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.VistaOperacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionResponse;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosVOService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class ReporteVistaOperacionController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ReporteCreditosVOService service;

    @Autowired
    public void setService(ReporteCreditosVOService service) {
        this.service = service;
    }

    @ApiOperation(value = "Listado de información operacional de la solicitud",
            notes = "Retorna el listado de información operacional."
            + "se utiliza el PKG_SWEB_CRED_REPO_VO.SP_LIST_CRED_SOLI_VO")
    @RequestMapping(value = "/reporteVO",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReporteVistaOperacionListadoResponse listar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestParam(value = "codOperacion", required = false) String codOperacion
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ReporteVistaOperacionListadoResponse response = null;
        
        try {            
            response = service.listar(headerParams, codOperacion);

        } catch (Exception ex) {
            response = new ReporteVistaOperacionListadoResponse();
            response.setMensaje(ex.getMessage());
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(ex.getMessage(), ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de vista operacion")
    @RequestMapping(value = "/excel/reporteVO", method = RequestMethod.GET)
    public ReporteVistaOperacionResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute VistaOperacionRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteVistaOperacionResponse response;

        try {
            response = service.exportarVistaOperacion(headerParams, request);

        } catch (Exception ex) {
            response = new ReporteVistaOperacionResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

}
