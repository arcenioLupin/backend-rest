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
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRegistroRequest;
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.EventoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EventoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EventoNotariaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.EventoService;

@RestController
@RequestMapping("/api")
public class EventoController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private EventoService eventoService;

    @Autowired
    public void setEventoService(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    
    @ApiOperation(value = "Listado de Eventos "
            + "de la solicitud",
            notes = "Retorna el listado de eventos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_EVENTO.sp_list_cred_soli_even")
    @RequestMapping(value = "/eventos/{codigo-solicitud}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EventoListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="fecItemEvenIni", required = false) String fecItemEvenIni,
            @RequestParam(value="fecItemEvenFin", required = false) String fecItemEvenFin,
            @ApiParam(value = "Indicador de paginado", required = true, defaultValue = "S") @RequestHeader String indPaginado,
            @ApiParam(value = "nroPag", required = true, defaultValue = "1") @RequestHeader String nroPag,
            @ApiParam(value = "Número de registro por página", required = true, defaultValue = "10") @RequestHeader String cantidadxPag

    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        int pagina = Integer.parseInt(nroPag);
        int cantidadxPagina = Integer.parseInt(cantidadxPag);

        EventoListadoResponse response = null;

        try {
            response = eventoService.listarEventos(headerParams,codSoliCred,fecItemEvenIni,fecItemEvenFin,pagina,cantidadxPagina);

        } catch (Exception ex) {
            response = new EventoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Registrar el evento de la solicitud "
            + "luego de formular un comentario",
            notes = "El evento es registrado "
            + "se utiliza el PKG_SWEB_CRED_SOLI_EVENTO.sp_inse_cred_soli_even")
    @RequestMapping(value = "/eventos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody EventoRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = eventoService.insertar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    //Req. 87567 E2.3 ID334 EBARBOZA 17/04/2020
    @ApiOperation(value = "Consulta el evento para notariar los documentos",
            notes = "El evento notariar documentos "
            + "se utiliza el pkg_sweb_cred_soli_evento.sp_list_even_notaria")
    @RequestMapping(value = "/eventos-notaria",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EventoNotariaListadoResponse listarEventoNotaria(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody EventoNotariaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        EventoNotariaListadoResponse response;

        try {
            response = eventoService.listarEventoNotaria(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new EventoNotariaListadoResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
     //Req. 87567 E2.3 ID334 EBARBOZA 21/04/2020
    @ApiOperation(value = "Registrar el evento notaria ",
            notes = "El evento es registrado "
            + "se utiliza el PKG_SWEB_CRED_SOLI_EVENTO.sp_inse_even_notaria")
    @RequestMapping(value = "/eventos-notaria-insert",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarEvenNota(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody EventoNotariaRegistroRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = eventoService.registrarEvenNota(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
