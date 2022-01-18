package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.dto.Item;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.FlujoCajaDAO;
import pe.com.divemotor.solicitudcredito.dao.GarantiaDAO;
import pe.com.divemotor.solicitudcredito.dao.SeguroDAO;
import pe.com.divemotor.solicitudcredito.dao.SolicitudCreditoDAO;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaGarantia;
import pe.com.divemotor.solicitudcredito.dominio.ResumenEjecutivo;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoCBProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarGestionBancaria;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.EnviarDatosCorreoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDatosResolucionCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarClienteCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarClienteMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoCBProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDatosSolicitudHOProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarParamRegSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarPermisosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarResumenEjecutivoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarRolesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ObtenerResponsableSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarHistoricoOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudHistoricoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroTramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoCBRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarGestionBancariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoSNRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ConsultaSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosCorreoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosSolicitudHORequest;
import pe.com.divemotor.solicitudcredito.dto.request.HistoricoOperacionesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaDatosResolucionRequestRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParamRegSolcreRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaRolesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListarClienteCreditosMovimientosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenEjecutivoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudHistoricoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DatosResolucionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DatosSolicitudHOResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteCreditosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteMovimientosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParamRegSolcreListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PermisosListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoCBListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoSNListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenEjecutivoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoListadoResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteResumenEjecutivoPdf;
import pe.com.divemotor.solicitudcredito.reporte.ReporteSeguroTramaExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteResumenEjecutivoPdfDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteSeguroTramaDataSource;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.solicitudcredito.services.SimuladorService;
import pe.com.divemotor.solicitudcredito.services.SolicitudCreditoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

@Service
@Transactional
public class SolicitudCreditoServiceImpl implements SolicitudCreditoService {

    private SolicitudCreditoDAO solicitudCreditoDAO;
    private SeguroDAO solicitudCreditoSeguroDAO;
    private FlujoCajaDAO flujoCajaDAO;
    private GarantiaDAO garantiaDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSolicitudCreditoDAO(SolicitudCreditoDAO solicitudCreditoDAO) {
        this.solicitudCreditoDAO = solicitudCreditoDAO;
    }

    @Autowired
    public void setFlujoCajaDAO(FlujoCajaDAO flujoCajaDAO) {
        this.flujoCajaDAO = flujoCajaDAO;
    }

    @Autowired
    public void setGarantiaDAO(GarantiaDAO garantiaDAO) {
        this.garantiaDAO = garantiaDAO;
    }

    
        @Autowired
    public void setSolicitudCreditoSeguroDAO(SeguroDAO solicitudCreditoSeguroDAO) {
        this.solicitudCreditoSeguroDAO = solicitudCreditoSeguroDAO;
    }


    @Resource(name = "mailServices")
    MailServices mailServices;

    SimuladorService simuladorService;

    @Autowired
    public void setSimuladorService(SimuladorService simuladorService) {
        this.simuladorService = simuladorService;
    }

    @Override
    public BaseResponse registrar(HeaderParams headerParams, SolicitudCreditoRequest request) throws Exception {
        RegistrarProcedure procedureParams = new RegistrarProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.registrar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        switch (statusQuery) {
            case Constantes.ESTADO_TRAMA_OK: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            case Constantes.ESTADO_TRAMA_ERROR_PROCEDURE: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            default:
                throw new Exception(procedureParams.getMensaje());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SolicitudCreditoListadoResponse listar(HeaderPaginadoParams headerParams, ListaSolicitudCreditoRequest request) throws Exception {

        ListarSolicitudCreditoProcedure procedureParams = new ListarSolicitudCreditoProcedure();
        Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
        procedureParams.setLiminf(limites.get("liminf"));
        procedureParams.setLimsup(headerParams.getCantidadxPag());

        procedureParams.setCodAreaVta(Util.ListToString(request.getListAreaVta()));
        procedureParams.setTipSoliCred(Util.ListToString(request.getListTipSoliCred()));
        procedureParams.setCodEmpr(Util.ListToString(request.getListCodEmpr()));
        procedureParams.setCodZona(Util.ListToString(request.getListCodZona()));         
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SolicitudCreditoListadoResponse response = new SolicitudCreditoListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            int numerodePaginas = Util.determinarNroPaginas(response.getCantidad(), headerParams.getCantidadxPag());
            response.setCantidadPaginas(numerodePaginas);
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Transactional(readOnly = true)
    @Override
    public SolicitudCreditoCBListadoResponse listarSoliCartaBanco(HeaderParams headerParams, String codSoliCred) throws Exception {

        ListarSolicitudCreditoCBProcedure procedureParams = mapper.map(headerParams, ListarSolicitudCreditoCBProcedure.class);
        procedureParams.setCodSoliCred(codSoliCred);
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setIdUsuario(headerParams.getIdUsuario());
        solicitudCreditoDAO.listarSoliCartaBanco(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SolicitudCreditoCBListadoResponse response = new SolicitudCreditoCBListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public BaseResponse actualizar(HeaderParams headerParams, ActualizarSolicitudCreditoRequest request) throws Exception {

        ActualizarSolicitudCreditoProcedure procedureParams = new ActualizarSolicitudCreditoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.actualizar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            if (request.getFlagActualiza().equals("GEST_BANC")
                    && request.getCodEstadoAprob().equals("EEJV01")) {
                this.enviarCorreo(procedureParams);
            }
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public BaseResponse actualizarGestion(HeaderParams headerParams, ActualizarGestionBancariaRequest request) throws Exception {
        ActualizarGestionBancaria procedureParams = new ActualizarGestionBancaria();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.actualiarGestionBancaria(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    private GenericoResponse enviarCorreo(ActualizarSolicitudCreditoProcedure procedureParams) throws Exception {
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;

        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codColaborador", procedureParams.getCodPerso());
        parametrosEmail.put("idUsuario", procedureParams.getIdUsuario());
        parametrosEmail.put("asunto", "");
        parametrosEmail.put("cuerpo", "");
        genericoResponse = mailServices.envioCorreos(parametrosEmail, "SOL_APROB");

        return genericoResponse;
    }

    @Override
    public BaseResponse actualizarCartaBanco(HeaderParams headerParams, ActualizarSolicitudCreditoCBRequest request) throws Exception {
        ActualizarSolicitudCreditoCBProcedure procedureParams = new ActualizarSolicitudCreditoCBProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.actualizarCartaBanco(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public SolicitudCreditoSNListadoResponse listarSoliSuscripNotaria(HeaderParams headerParams, String codSoliCred) throws Exception {
        ListarSolicitudCreditoSNProcedure procedureParams = mapper.map(headerParams, ListarSolicitudCreditoSNProcedure.class);
        procedureParams.setCodSoliCred(codSoliCred);
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setIdUsuario(headerParams.getIdUsuario());
        solicitudCreditoDAO.listarSoliSuscripNotaria(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SolicitudCreditoSNListadoResponse response = new SolicitudCreditoSNListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse actualizarSoliSuscripNotaria(HeaderParams headerParams, ActualizarSolicitudCreditoSNRequest request) throws Exception {
        ActualizarSolicitudCreditoSNProcedure procedureParams = new ActualizarSolicitudCreditoSNProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.actualizarSoliSuscripNotaria(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public DatosSolicitudHOResponse listarDatosSolicitudHO(HeaderPaginadoParams headerParams, DatosSolicitudHORequest request) throws Exception {
        ListarDatosSolicitudHOProcedure procedureParams = new ListarDatosSolicitudHOProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarDatosSolicitudHO(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            DatosSolicitudHOResponse response = new DatosSolicitudHOResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public DatosResolucionListadoResponse listarDatosSolicitudRC(HeaderPaginadoParams headerParams, ListaDatosResolucionRequestRequest request) throws Exception {
        ListarDatosResolucionCreditosProcedure procedureParams = new ListarDatosResolucionCreditosProcedure();
        mapper.map(headerParams, procedureParams);
        request.setTxtInfoAdic(Util.toUTF8(request.getTxtInfoAdic()));
        request.setTxtInfoOper(Util.toUTF8(request.getTxtInfoOper()));
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarDatosSolicitudRC(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            DatosResolucionListadoResponse response = new DatosResolucionListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public BaseResponse solicitudAprobacion(HeaderParams headerParams, DatosCorreoRequest request) throws Exception {

        EnviarDatosCorreoProcedure procedureParams = new EnviarDatosCorreoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        BaseResponse response = new BaseResponse();

        if (!procedureParams.getCodSoliCred().equals("")) {
            if (procedureParams.getTipoCorreo().equals("SOL_APROB_CRED")) {

                ReporteResponse reporteResponse;
                ConsultaSimuladorRequest requestSimulador = new ConsultaSimuladorRequest();
                requestSimulador.setCodSoliCred(request.getCodSoliCred());
                requestSimulador.setNumProfVeh(request.getNumProfVeh());
                requestSimulador.setFlagDatos("MUESTRA");
                reporteResponse = simuladorService.exportarPropuesta(headerParams, requestSimulador);

                GenericoResponse responseEnvio = this.enviarCorreo(headerParams, reporteResponse, procedureParams);
                response.setEstadoTrama(responseEnvio.getEstadoTrama());
                response.setMensaje(responseEnvio.getMensaje());

            } else if (procedureParams.getTipoCorreo().equals("SOL_APROB_CRED_USU")) {

                ReporteResponse reporteResponse;
                reporteResponse = this.exportarResumenEjecutivo(headerParams, request.getCodSoliCred(),request.getTipSoliCred());

                GenericoResponse responseEnvio = this.enviarCorreo(headerParams, reporteResponse, procedureParams);
                response.setEstadoTrama(responseEnvio.getEstadoTrama());
                response.setMensaje(responseEnvio.getMensaje());

            }
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    private GenericoResponse enviarCorreo(HeaderParams headerParams, ReporteResponse reporteResponse, EnviarDatosCorreoProcedure procedureParams) throws Exception {
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;

        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codCliente", procedureParams.getCodClie());
        parametrosEmail.put("estado", procedureParams.getEstado());
        parametrosEmail.put("observacion", procedureParams.getObservacion());
        parametrosEmail.put("idUsuario", headerParams.getIdUsuario());
        parametrosEmail.put("adjuntos", reporteResponse.getReporteBytes());
        genericoResponse = mailServices.envioCorreos(parametrosEmail, procedureParams.getTipoCorreo());

        return genericoResponse;
    }

    @Override
    public ResumenEjecutivoResponse listarResumenEjecutivo(HeaderPaginadoParams headerParams, ResumenEjecutivoRequest request) throws Exception {

        ListarResumenEjecutivoProcedure procedureParams = new ListarResumenEjecutivoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarResumenEjecutivo(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ResumenEjecutivoResponse response = new ResumenEjecutivoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public ReporteResponse exportarResumenEjecutivo(HeaderParams headerParams, String codSoliCred,String tipSoliCred) throws Exception {

        ReporteResumenEjecutivoPdfDataSource request = new ReporteResumenEjecutivoPdfDataSource();
        ReporteResumenEjecutivoPdf reporte = new ReporteResumenEjecutivoPdf();

        ListarResumenEjecutivoProcedure parametrosResumen = mapper.map(headerParams, ListarResumenEjecutivoProcedure.class);
        parametrosResumen.setCodSoliCred(codSoliCred);
        solicitudCreditoDAO.listarResumenEjecutivo(parametrosResumen);
        if (parametrosResumen.getBusqueda() != null && parametrosResumen.getBusqueda().size() > 0) {
        ResumenEjecutivo resumen = parametrosResumen.getBusqueda().get(0);
        request.setValPorCi(tipSoliCred.equals(Constantes.TIPO_CRED_FACT_CREDITO)?String.valueOf(((Float.parseFloat(resumen.getPrecTotal()) -Float.parseFloat(resumen.getMontoCred()))/Float.parseFloat(resumen.getPrecTotal())) * 100):resumen.getValPorCi());
        request.setValCi(tipSoliCred.equals(Constantes.TIPO_CRED_FACT_CREDITO)? String.valueOf(Float.parseFloat(resumen.getPrecTotal()) -Float.parseFloat(resumen.getMontoCred())):resumen.getValCi());
        request.setMontoCred(resumen.getMontoCred());
        request.setCanPlazMes(resumen.getCanPlazMes());
        request.setValPorcTeaSigv(resumen.getValPorcTeaSigv());
        request.setCanDiasVencPrimLetr(resumen.getCanDiasVencPrimLetr());
        request.setCanVehFin(resumen.getCanVehFin());
        request.setDesAreaVta(resumen.getDesAreaVta());
        request.setDesMarca(resumen.getDesMarca());
        request.setPrecTotal(resumen.getPrecTotal());
        request.setDescripcion(resumen.getDescripcion());
        request.setNroLetras(resumen.getNroLetras());
        request.setCodSociedad(resumen.getCodSociedad());
        request.setNomSociedad(resumen.getNomSociedad());
        request.setValAnoFab(resumen.getValAnoFab());
        request.setGps(resumen.getGps());
        request.setGpsDetalle(resumen.getGpsDetalle());
        request.setSeguro(resumen.getSeguro());
        request.setSeguroDetalle(resumen.getSeguro().equals("NO")?"":resumen.getSeguroDetalle());
        request.setNomCliente(resumen.getNomCliente());
        request.setCodClasifSbsClie(resumen.getCodClasifSbsClie());
        request.setValDeudActuClie(resumen.getValDeudActuClie());
        /* I Req.87567 E2.1 avilca 12/01/2021*/
        request.setValDeudaDeta((resumen.getValMutuo().equals("0") && resumen.getValDirecto().equals("0"))? "NO":"SI");
        /* F Req.87567 E2.1 avilca 12/01/2021*/
        request.setTxtInfoAdic(resumen.getTxtInfoAdic());
        request.setTxtInfoOper(resumen.getTxtInfoOper());
        request.setValMutuo(resumen.getValMutuo());
        request.setValDirecto(resumen.getValDirecto());
        request.setValMutuoDirecto(resumen.getValMutuoDirecto());
        request.setValGastAdmi(resumen.getValGastAdmi());
        request.setCodRespFina(resumen.getCodRespFina());
        request.setCanDiasFactCred(resumen.getCanDiasFactCred());//Req. 87567 E2.1 ID 36 avilca 16/06/2020
        request.setValLineaCredito(resumen.getValLineaCredito());//Req. 87567 E2.1 ID 36 avilca 19/02/2021
        }
        
        ListarParametrosFlujoCajaProcedure parametrosFlujoCaja = mapper.map(headerParams, ListarParametrosFlujoCajaProcedure.class);
        parametrosFlujoCaja.setCodSoliCred(codSoliCred);
        flujoCajaDAO.listarParametrosFlujoCaja(parametrosFlujoCaja);

        if (parametrosFlujoCaja.getListaValProyPorAnios() != null && parametrosFlujoCaja.getListaValProyPorAnios().size() > 0) {
            CoberturaFlujoCajaValAnios valAnios = parametrosFlujoCaja.getListaValProyPorAnios().get(0);
            request.setValRatioCober1(valAnios.getValAnio1());
            request.setValRatioCober2(valAnios.getValAnio2());
            request.setValRatioCober3(valAnios.getValAnio3());
            request.setValRatioCober4(valAnios.getValAnio4());
            request.setValRatioCober5(valAnios.getValAnio5());
            request.setValRatioCober6(valAnios.getValAnio6());
            request.setValRatioCober7(valAnios.getValAnio7());
            request.setValRatioCober8(valAnios.getValAnio8());
            request.setValRatioCober9(valAnios.getValAnio9());
            request.setValRatioCober10(valAnios.getValAnio10());
        }

        ListarCoberturaGarantiaProcedure parametrosCobertura = mapper.map(headerParams, ListarCoberturaGarantiaProcedure.class);
        parametrosCobertura.setCodSoliCred(codSoliCred);
        garantiaDAO.listarCoberturaGarantia(parametrosCobertura);
        List<String> lstAnios = new ArrayList<>();
        List<String> lstCoberGara = new ArrayList<>();
        if (parametrosCobertura.getBusqueda() != null && parametrosCobertura.getBusqueda().size() > 0) {

            for (int i = 0; i < parametrosCobertura.getBusqueda().size(); i++) {
                lstAnios.add(parametrosCobertura.getBusqueda().get(i).getAno());
                lstCoberGara.add(parametrosCobertura.getBusqueda().get(i).getRatio_cob());
            }

            request.setAnio1(lstAnios.size() > 0 ? lstAnios.get(0) : null);
            request.setAnio2(lstAnios.size() > 1 ? lstAnios.get(1) : null);
            request.setAnio3(lstAnios.size() > 2 ? lstAnios.get(2) : null);
            request.setAnio4(lstAnios.size() > 3 ? lstAnios.get(3) : null);
            request.setAnio5(lstAnios.size() > 4 ? lstAnios.get(4) : null);
            request.setAnio6(lstAnios.size() > 5 ? lstAnios.get(5) : null);
            request.setAnio7(lstAnios.size() > 6 ? lstAnios.get(6) : null);
            request.setAnio8(lstAnios.size() > 7 ? lstAnios.get(7) : null);
            request.setAnio9(lstAnios.size() > 8 ? lstAnios.get(8) : null);
            request.setAnio10(lstAnios.size() > 9 ? lstAnios.get(9) : null);

            request.setValCoberGara1(lstCoberGara.size() > 0 ? lstCoberGara.get(0) : null);
            request.setValCoberGara2(lstCoberGara.size() > 1 ? lstCoberGara.get(1) : null);
            request.setValCoberGara3(lstCoberGara.size() > 2 ? lstCoberGara.get(2) : null);
            request.setValCoberGara4(lstCoberGara.size() > 3 ? lstCoberGara.get(3) : null);
            request.setValCoberGara5(lstCoberGara.size() > 4 ? lstCoberGara.get(4) : null);
            request.setValCoberGara6(lstCoberGara.size() > 5 ? lstCoberGara.get(5) : null);
            request.setValCoberGara7(lstCoberGara.size() > 6 ? lstCoberGara.get(6) : null);
            request.setValCoberGara8(lstCoberGara.size() > 7 ? lstCoberGara.get(7) : null);
            request.setValCoberGara9(lstCoberGara.size() > 8 ? lstCoberGara.get(8) : null);
            request.setValCoberGara10(lstCoberGara.size() > 9 ? lstCoberGara.get(9) : null);
        }

        byte[] excelByte = reporte.generarReporte(request);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
    }

    @Override
    public PermisosListadoResponse listarPermisos(HeaderParams headerParams, String codSoliCred) throws Exception {
        ListarPermisosProcedure procedureParams = new ListarPermisosProcedure();
        mapper.map(headerParams, procedureParams);
        procedureParams.setCodSoliCred(codSoliCred);
        solicitudCreditoDAO.listarPermisos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            PermisosListadoResponse response = new PermisosListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public RolesListadoResponse listarRoles(HeaderPaginadoParams headerParams, ListaRolesRequest request) throws Exception {
        ListarRolesProcedure procedureParams = new ListarRolesProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarRoles(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            RolesListadoResponse response = new RolesListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse registrarSolicitudHistorico(HeaderParams headerParams, SolicitudHistoricoRequest request) throws Exception {

        RegistrarSolicitudHistoricoProcedure procedureParams = new RegistrarSolicitudHistoricoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.registrarSolicitudHistorico(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        switch (statusQuery) {
            case Constantes.ESTADO_TRAMA_OK: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            case Constantes.ESTADO_TRAMA_ERROR_NEGOCIO: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            default:
                throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public BaseResponse registrarHistoricoOperaciones(HeaderParams headerParams, HistoricoOperacionesRequest request) throws Exception {
        RegistrarHistoricoOperacionesProcedure procedureParams = new RegistrarHistoricoOperacionesProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.registrarHistoricoOperaciones(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        switch (statusQuery) {
            case Constantes.ESTADO_TRAMA_OK: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            case Constantes.ESTADO_TRAMA_ERROR_NEGOCIO: {
                BaseResponse response = new BaseResponse();
                response.setCodigo(procedureParams.getCodigo());
                response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
                response.setMensaje(procedureParams.getMensaje());
                return response;
            }
            default:
                throw new Exception(procedureParams.getMensaje());
        }
    }

 
    //<I-89783>
     @Override
    public SolicitudCreditoListadoResponse obtenerResponsablesSolcre(HeaderParams headerParams,String codSoliCred) throws Exception {        
        SolicitudCreditoListadoResponse response= new SolicitudCreditoListadoResponse(); 
        ObtenerResponsableSolcreProcedure procedureParams = new ObtenerResponsableSolcreProcedure();
        mapper.map(headerParams, procedureParams);
        procedureParams.setCodSoliCred(codSoliCred);        
        solicitudCreditoDAO.obtenerResponsablesSolcre(procedureParams);
    
        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje((procedureParams.getVendedor()+procedureParams.getResponsable()).toUpperCase());   
            return response;
        } else if (statusQuery.equals(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO)) {
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje("No existe registros para la busqueda !!");            
            return response;   
        }else{
            throw new Exception(procedureParams.getMensaje());
        }        
    }
    //<F-89783>

    
@Override
    public ReporteResponse exportarSeguroTrama(HeaderParams headerParams, String codSoliCred) throws Exception {

                ReporteSeguroTramaDataSource requestReport = new ReporteSeguroTramaDataSource();
                ReporteSeguroTramaExcel reporte = new ReporteSeguroTramaExcel();
                                               
                ListarSeguroTramaProcedure parametrosTrama = mapper.map(headerParams, ListarSeguroTramaProcedure.class);
                parametrosTrama.setCodSoliCred(codSoliCred);
                solicitudCreditoSeguroDAO.listarTramaSeguro(parametrosTrama);
                requestReport.setListaGarantias(parametrosTrama.getBusqueda());
                 
                byte[] excelByte = reporte.generarReporte(requestReport);
                
               ReporteResponse reporteResponse = new ReporteResponse();
               reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
               reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
               reporteResponse.setReporteBytes(excelByte);
               reporteResponse.setReporte(Base64.encodeBase64String(excelByte));
                
                return reporteResponse;
   }

//I Req. 87567 E2.1 ID:9 AVILCA 12/05/2020    
  @Override
    public ParamRegSolcreListadoResponse listarParametrosRegistroSolcre(HeaderPaginadoParams headerParams, ListaParamRegSolcreRequest request) throws Exception {
        ListarParamRegSolcreProcedure procedureParams = new ListarParamRegSolcreProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarParametrosRegistroSolcre(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ParamRegSolcreListadoResponse response = new ParamRegSolcreListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }  
  //F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020 
    
//I Req. 87567 E2.1 ID:9 AVILCA 10/02/2021    
  @Override
    public ListaClienteCreditosResponse listarClienteCreditos(HeaderPaginadoParams headerParams, ListarClienteCreditosMovimientosRequest request) throws Exception {
        ListarClienteCreditoProcedure procedureParams = new ListarClienteCreditoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarClienteCreditos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ListaClienteCreditosResponse response = new ListaClienteCreditosResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }  
    
 @Override
    public ListaClienteMovimientosResponse listarClienteMovimientos(HeaderPaginadoParams headerParams, ListarClienteCreditosMovimientosRequest request) throws Exception {
        ListarClienteMovimientoProcedure procedureParams = new ListarClienteMovimientoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoDAO.listarClienteMovimientos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ListaClienteMovimientosResponse response = new ListaClienteMovimientosResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }     
  //F Req. 87567 E2.1 ID:9 AVILCA 10/02/2021        
}

