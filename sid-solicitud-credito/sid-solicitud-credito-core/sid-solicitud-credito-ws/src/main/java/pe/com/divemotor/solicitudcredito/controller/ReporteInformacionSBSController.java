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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteInformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteInformacionSBSResponse;

import pe.com.divemotor.solicitudcredito.services.ReporteInformacionSBSService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author legutierrez
 */
@RestController
@RequestMapping("/api")
public class ReporteInformacionSBSController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ReporteInformacionSBSService reporteInformacionSBSService;

    @Autowired
    public void setReporteInformacionSBSService(ReporteInformacionSBSService reporteInformacionSBSService) {
        this.reporteInformacionSBSService = reporteInformacionSBSService;
    }

    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de Informacion SBS")
    @RequestMapping(value = "/excel/informacion-sbs", method = RequestMethod.GET)
    public ReporteInformacionSBSResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute ReporteInformacionSBSRequest request
    ) {

        ReporteInformacionSBSResponse response;

        try {
            HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
            headerParams.setCodUsuario(codUsuario);
            headerParams.setIdUsuario(idUsuario);
            headerParams.setToken(token);

            response = reporteInformacionSBSService.exportarReporte(headerParams, request);

        } catch (Exception ex) {
            response = new ReporteInformacionSBSResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

}
