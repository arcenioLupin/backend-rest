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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroDetalleVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroDetalleVehiculoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.SeguroDetalleVehiculoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author Mgrasso
 */
@RestController
@RequestMapping("/api")
public class SeguroDetalleVehiculoController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    private SeguroDetalleVehiculoService seguroDetalleVehiculoService;

    @Autowired
    public void setSeguroDetalleVehiculoService(SeguroDetalleVehiculoService seguroDetalleVehiculoService) {
        this.seguroDetalleVehiculoService = seguroDetalleVehiculoService;
    }
    
            @ApiOperation(value = "Listar Detalle de vehiculos para seguro",
            notes = "retorna una lista de vehiculos para seguros de solicitudes de crédito en base a los filtros. Procedure PKG_SWEB_CRED_SOLI_SEGURO.SP_LIST_SOLI_CRED_SEGURO_DET.")
    @RequestMapping(value = "/seguroDetalleVehiculo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public SeguroDetalleVehiculoListadoResponse listar(@ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @RequestParam("codSoliCred") String codSoliCred) {
        
        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        SeguroDetalleVehiculoRequest request=new SeguroDetalleVehiculoRequest();
        request.setCodSoliCred(codSoliCred);
        SeguroDetalleVehiculoListadoResponse response = null;

        try {
            response = seguroDetalleVehiculoService.listar(headerParams,request);

        } catch (Exception ex) {
            response = new SeguroDetalleVehiculoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    
    }
}
