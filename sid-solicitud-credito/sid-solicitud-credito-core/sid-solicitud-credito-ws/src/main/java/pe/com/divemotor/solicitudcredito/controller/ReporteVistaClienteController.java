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
import pe.com.divemotor.solicitudcredito.dto.request.VistaClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteResponse;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosVCService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@RestController
@RequestMapping("/api")
public class ReporteVistaClienteController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private ReporteCreditosVCService service;
    
    @Autowired
    public void setService(ReporteCreditosVCService service) {
        this.service = service;
    }
    
    @ApiOperation(value = "Listado de información de la solicitud referente al cliente",
            notes = "Retorna el listado de información de la solicitud referente al cliente."
            + "se utiliza el PKG_SWEB_CRED_REPO_VC.SP_LIST_CRED_SOLI_VC")
    @RequestMapping(value = "/reporteVC",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReporteVistaClienteListadoResponse listar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute VistaClienteRequest request
    ) {
        
        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        
        ReporteVistaClienteListadoResponse response = null;
        
        try {
            
            response = service.listarCodigosOperacion(headerParams, request);
            
        } catch (Exception ex) {
            response = new ReporteVistaClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        
        return response;
    }
    
    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de vista cliente")
    @RequestMapping(value = "/excel/reporteVC", method = RequestMethod.GET)
    public ReporteVistaClienteResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute VistaClienteRequest request
    ) {
        ReporteVistaClienteListadoResponse response = null;
        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        ReporteVistaClienteResponse rvcResponse;
        
        try {
            
            response = service.listarCodigosOperacion(headerParams, request);
            rvcResponse = service.exportarVistaCliente(headerParams, response.getListado().get(0));
            
        } catch (Exception ex) {
            rvcResponse = new ReporteVistaClienteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            rvcResponse.setEstadoTrama(codigoError);
        }
        return rvcResponse;
    }
    
}
