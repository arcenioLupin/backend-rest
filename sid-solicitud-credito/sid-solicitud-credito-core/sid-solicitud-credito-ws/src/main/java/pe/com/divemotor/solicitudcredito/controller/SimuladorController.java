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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;

import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.CalculaTasaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ConsultaSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.CuadrarCronogramaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorSapRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CompaniaSeguroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorConceptoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorCronogramaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorGastoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorPropuestaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasaSeguroResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasasListadoResponse;
import pe.com.divemotor.solicitudcredito.services.SimuladorService;

@RestController
@RequestMapping("/api")
public class SimuladorController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    private SimuladorService simuladorService;

    @Autowired
    public void setSimuladorService(SimuladorService simuladorService) {
        this.simuladorService = simuladorService;
    }

    @ApiOperation(value = "Listado de Compañias de Seguro",
            notes = "Retorna el listado de compañias de seguro que se "
            + "ingresaran al simulador "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_comp_segu")
    @RequestMapping(value = "/simuladores/companias-seguro",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CompaniaSeguroListadoResponse listarCompaniaSeguro(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Compañia de Seguro")
            @RequestParam(name = "codCiaSeg", required = false) String codCiaSeg
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        CompaniaSeguroListadoResponse response = null;

        try {
            response = simuladorService.listarCompaniaSeguro(headerParams, codCiaSeg);

        } catch (Exception ex) {
            response = new CompaniaSeguroListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listado de Proformas",
            notes = "Retorna el listado de proformas asociadas a "
            + "la solicitud de credito, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_PROFORMA.sp_list_cred_soli_proforma")
    @RequestMapping(value = "/simuladores/proformas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProformaListadoResponse listarProforma(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Solicitud de Crédito")
            @RequestParam(name = "codSoliCred", required = false) String codSoliCred
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        ProformaListadoResponse response = null;

        try {
            response = simuladorService.listarProforma(headerParams, codSoliCred);

        } catch (Exception ex) {
            response = new ProformaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listado de Conceptos",
            notes = "Retorna el listado de conceptos a utilizar en la sección "
            + "de gastos que se ingresaran al simulador, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_maes_conc_letr")
    @RequestMapping(value = "/simuladores/conceptos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SimuladorConceptoListadoResponse listarSimuladorConcepto(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Concepto")
            @RequestParam(name = "codConcCol", required = true, defaultValue = "0") Integer codConcCol,
            @ApiParam(value = "Indicador de Obligatorio")
            @RequestParam(name = "indConcOblig", required = false) String indConcOblig
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SimuladorConceptoListadoResponse response = null;

        try {
            response = simuladorService.listarSimuladorConcepto(headerParams, codConcCol, indConcOblig);

        } catch (Exception ex) {
            response = new SimuladorConceptoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Registrar simulador de cuotas",
            notes = "Registro de la simulación de cuotas para la solicitud "
            + "de crédito, "
            + "se utilizan los procedures PKG_SWEB_CRED_SOLI_SIMULADOR.sp_inse_para_simulador"
            + ", PKG_SWEB_CRED_SOLI_SIMULADOR.sp_inse_para_gasto"
            + ", PKG_SWEB_CRED_SOLI_SIMULADOR.sp_gene_crono")
    @RequestMapping(value = "/simuladores",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SimuladorRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = simuladorService.registrar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
   @ApiOperation(value = "Simulador sap",
            notes = "Simulador sap de prueba para solicitud"
            + "de crédito, "
            + "se utilizan los procedures pkg_sweb_cred_simulador_sap.sp_inse_para_simulador")
    @RequestMapping(value = "/simulador-proforma",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarSap(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SimuladorSapRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = simuladorService.registrarSap(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }    

    @ApiOperation(value = "Modificar simulador de cuotas",
            notes = "Se realizara el cuadre de los cambios realizados en las cuotas "
            + "y se registrara el nuevo cronograma, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_cuad_crono")
    @RequestMapping(value = "/simuladores",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse cuadrar(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody CuadrarCronogramaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = simuladorService.cuadrar(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Ver cronograma del simulador",
            notes = "Retorna el ultimo cronograma de cuotas generado para "
            + "la solicitud de credito o proforma, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_crono")
    @RequestMapping(value = "/simuladores",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SimuladorCronogramaListadoResponse listarCronograma(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos del Simulador", required = true)
            @ModelAttribute ConsultaSimuladorRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SimuladorCronogramaListadoResponse response = null;

        try {
            response = simuladorService.listarCronograma(headerParams, request);

        } catch (Exception ex) {
            response = new SimuladorCronogramaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Exportar cronograma", notes = "Exportar cronograma de cuotas")
    @RequestMapping(value = "/simuladores/excel/cronograma", method = RequestMethod.GET)
    public ReporteResponse exportarCronograma(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos del Simulador", required = true)
            @ModelAttribute ConsultaSimuladorRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = simuladorService.exportarCronograma(headerParams, request);

        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Exportar propuesta", notes = "Exportar propuesta "
            + "de crédito otorgado incluido cronograma de cuotas")
    @RequestMapping(value = "/simuladores/pdf/propuesta", method = RequestMethod.GET)
    public ReporteResponse exportarPropuesta(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos del Simulador", required = true)
            @ModelAttribute ConsultaSimuladorRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        ReporteResponse response;

        try {
            response = simuladorService.exportarPropuesta(headerParams, request);

        } catch (Exception ex) {
            response = new ReporteResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }

    @ApiOperation(value = "Obtener Tasa de Seguro",
            notes = "Retorna la tasa de seguro correspondiente al tipo de "
            + "vehiculo especificado en la proforma, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_obt_tasa_seg")
    @RequestMapping(value = "/simuladores/tasas-seguro",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TasaSeguroResponse obtenerTasaSeguro(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de Compañia")
            @RequestParam(name = "codCia", required = true) String codCia,
            @ApiParam(value = "Tipo de Vehiculo")
            @RequestParam(name = "codTipoVeh", required = true) String codTipoVeh,
            @ApiParam(value = "Tipo de Uso")
            @RequestParam(name = "indTipoUso", required = false) String indTipoUso,
            @ApiParam(value = "Código de Cliente")
            @RequestParam(name = "codCliente", required = false) String codCliente
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        TasaSeguroResponse response = null;

        try {
            response = simuladorService.obtenerTasaSeguro(headerParams, codCia, codTipoVeh, indTipoUso, codCliente);

        } catch (Exception ex) {
            response = new TasaSeguroResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
    
   @ApiOperation(value = "Calcula Tasa según el seguro",
            notes = "Retorna la tasa de seguro correspondiente al monto del seguro "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_calc_tasa_seg")
    @RequestMapping(value = "/simuladores/tasa/seguro",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TasaSeguroResponse calculaTasa(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos para el cálculo de la tasa", required = true)
            @ModelAttribute CalculaTasaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        TasaSeguroResponse response = null;

        try {
            response = simuladorService.calculaTasa(headerParams, request);

        } catch (Exception ex) {
            response = new TasaSeguroResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }


    @ApiOperation(value = "Mostrar propuesta",
            notes = "Retorna la información de la propuesta "
            + "del crédito solicitado, se utiliza "
            + "el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_propuesta")
    @RequestMapping(value = "/simuladores/propuestas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SimuladorPropuestaListadoResponse listarPropuesta(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos del Simulador", required = true)
            @ModelAttribute ConsultaSimuladorRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SimuladorPropuestaListadoResponse response = null;

        try {
            response = simuladorService.listarPropuesta(headerParams, request);

        } catch (Exception ex) {
            response = new SimuladorPropuestaListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Mostrar Gastos",
            notes = "Retorna la información de los gastos "
            + "registrados en el simulador, se utiliza "
            + "el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_gasto")
    @RequestMapping(value = "/simuladores/gastos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SimuladorGastoListadoResponse listarGasto(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Datos del Simulador", required = true)
            @ModelAttribute ConsultaSimuladorRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        SimuladorGastoListadoResponse response = null;

        try {
            response = simuladorService.listarGasto(headerParams, request);

        } catch (Exception ex) {
            response = new SimuladorGastoListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Listado de Tasas",
            notes = "Retorna el listado de tasas a utilizar en la sección "
            + "de Simulación, "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_list_tasas")
    @RequestMapping(value = "/simuladores/tasas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TasasListadoResponse listarTasas(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ApiParam(value = "Código de empresa")
            @RequestParam(name = "noCia", required = false) String noCia,
            @ApiParam(value = "Código de moneda")
            @RequestParam(name = "moneda", required = false) String moneda
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        TasasListadoResponse response = null;

        try {
            response = simuladorService.listarTasas(headerParams, noCia, moneda);

        } catch (Exception ex) {
            response = new TasasListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @ApiOperation(value = "Registrar proformas de ficha de venta",
            notes = "Registra las proformas restantes que esten asociadas con la ficha de venta, "
            + "a partir de la relación proforma y solicitud de crédito "
            + "se utiliza el procedure PKG_SWEB_CRED_SOLI_SIMULADOR.sp_inse_para_proforma")
    @RequestMapping(value = "/simuladores/proformas",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse registrarProforma(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización")
            @RequestHeader(name = "token", required = false) String token,
            @RequestBody SimuladorProformaRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);

        BaseResponse response;

        try {
            response = simuladorService.registrarProforma(headerParams, request);

        } catch (Exception ex) {
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response = new BaseResponse();
            response.setEstadoTrama(codigoError);
        }

        return response;
    }
}
