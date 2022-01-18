package pe.com.divemotor.solicitudcredito.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dto.request
        .AutorizacionExcepcionalActualizarEstadoRequest;

import pe.com.divemotor.solicitudcredito.dto.response.EstadoSeguimientoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.EstadoSeguimientoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;

@RestController
@RequestMapping("/autorizacion-excepcional")
public class EstadoSeguimientoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private EstadoSeguimientoService estadoSeguimientoService;

    @ApiOperation(value = "Listado de Estados de Seguimiento de "
            + "una Autorización Excepcional",
            notes = "Retorna el listado de estados de seguimiento de "
                    + "una autorización excepcional, "
                    + "se utiliza el SP PKG_SWEB_FIVE_PROC_AUT_EXCEP.SP_LIST_ESTADO_SEGI_AUTO")
    @RequestMapping(value = "/estado/seguimiento"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EstadoSeguimientoListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        EstadoSeguimientoListadoResponse response = null;

        try {
            response = estadoSeguimientoService.listarEstados(headerParams);

        } catch (Exception ex) {
            response = new EstadoSeguimientoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Actualizar de Estados de Seguimiento de "
            + "una Autorización Excepcional",
            notes = "La autorización excepcional puede ser actualizada a los "
                    + "estados de CERRADO, ANULADO, REFACTURADO y PENDIENTE, "
                    + "se utiliza el SP PKG_SWEB_FIVE_PROC_AUT_EXCEP.SP_ACTU_SEG_SOL_EXCEP")    
    @RequestMapping(value = "/{codigoSolicitud}/estado/seguimiento"
            , method = RequestMethod.PUT
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse actualizar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codigoUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización") 
            @RequestHeader(name = "token", required = false) String token,
            @PathVariable(value = "codigoSolicitud") String codigoSolicitud,
            @RequestBody AutorizacionExcepcionalActualizarEstadoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        request.setCodigoSolicitud(codigoSolicitud);

        BaseResponse response;

        try {
            response = estadoSeguimientoService.actualizarEstado(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @Autowired
    public void setEstadoSeguimientoService(EstadoSeguimientoService estadoSeguimientoService) {
        this.estadoSeguimientoService = estadoSeguimientoService;
    }

}
