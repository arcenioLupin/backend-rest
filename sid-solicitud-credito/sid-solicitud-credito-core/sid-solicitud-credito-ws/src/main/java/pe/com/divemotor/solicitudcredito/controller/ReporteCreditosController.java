package pe.com.divemotor.solicitudcredito.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditosListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosService;

@RestController
@RequestMapping("/api")
public class ReporteCreditosController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private ReporteCreditosService reporteCreditosService;

    @Autowired
    public void setReporteCreditosService(ReporteCreditosService reporteCreditosService) {
        this.reporteCreditosService = reporteCreditosService;
    }
    
    @ApiOperation(value = "Listado de Documentos "
            + "de la solicitud",
            notes = "Retorna el listado de documentos "
                    + "se utiliza el PKG_SWEB_CRED_SOLI_DOCUMENTO.sp_list_docu_soli")
    @RequestMapping(value = "/reporteCreditos"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReporteCreditosListadoResponse listar(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @RequestParam(value="tipCred", required = false) String tipCred,
            @RequestParam(value="areaVta", required = false) String areaVta,
            @RequestParam(value="zona", required = false) String zona,
            @RequestParam(value="fechIni", required = false) String fechIni,
            @RequestParam(value="fechFin", required = false) String fechFin,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token/*,
            @PathVariable("codigo-solicitud") String codSoliCred,
            @RequestParam(value="indMancomunado", required = false) String indMancomunado,
            @RequestParam(value="codTipoPerso", required = false) String codTipoPerso,
            @RequestParam(value="codEstadoCivil", required = false) String codEstadoCivil*/
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ReporteCreditosListadoResponse response = null;

        try {
            response = reporteCreditosService.listar(headerParams,tipCred,areaVta,zona,fechIni,fechFin);

        } catch (Exception ex) {
            response = new ReporteCreditosListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
    @ApiOperation(value = "Exportar reporte excel", notes = "Exporta el reporte de cronograma de cuotas")
    @RequestMapping(value = "/excel/credito", method = RequestMethod.GET)
    public ReporteCreditoResponse exportarExcel(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestParam(value="tipCred", required = false) String tipCred,
            @RequestParam(value="areaVta", required = false) String areaVta,
            @RequestParam(value="zona", required = false) String zona,
            @RequestParam(value="fechIni", required = false) String fechIni,
            @RequestParam(value="fechFin", required = false) String fechFin,
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteCreditoResponse response;

        try {
            response = reporteCreditosService.exportarCreditos(headerParams,tipCred,areaVta,zona,fechIni,fechFin);

        } catch (Exception ex) {
            response = new ReporteCreditoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
    @ApiOperation(value = "Listado de items del combo "
            + "de la solicitud",
            notes = "Retorna el listado del combo escogido "
                    + "se utiliza el PKG_SWEB_CRED_MAESTRO.sp_list_maestro")
    @RequestMapping(value = "/maestro/{tipo}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarComboMaestro(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = reporteCreditosService.listarComboMaestro(headerParams,tipo);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
     @ApiOperation(value = "Listado filiales por zona " ,
            notes = "Retorna el listado de filiales por zona "
                    + "se utiliza el PKG_SWEB_CRED_MAESTRO.sp_list_filial_zona")
    @RequestMapping(value = "/maestro/filialZona/{tipo}/{codDepa}/{codProv}/{codDist}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MaestroListadoResponse listarFilialZona(
            @ApiParam(value = "Código de Usuario") 
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario") 
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) 
            @RequestHeader("token") String token,
            @PathVariable("tipo") String tipo,
            @PathVariable("codDepa") String codDepa,
            @PathVariable("codProv") String codProv,
            @PathVariable("codDist") String codDist
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        MaestroListadoResponse response = null;

        try {
            response = reporteCreditosService.listarFilialZona(headerParams,tipo, codDepa, codProv, codDist);

        } catch (Exception ex) {
            response = new MaestroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
