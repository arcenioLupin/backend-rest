package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.SimuladorDAO;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorGasto;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorPropuesta;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorTotal;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.CalculaTasaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarTasasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.GenerarCronogramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.GenerarPlantillaCambioTasaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarCompaniaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarCronogramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarProformaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarPropuestaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarSimuladorConceptoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarSimuladorGastoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ObtenerTasaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorGastoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorProformaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorSapProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.CalculaTasaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ConsultaSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.CuadrarCronogramaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorSapRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CompaniaSeguroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorConceptoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorCronogramaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorGastoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorPropuestaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasaSeguroResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasasListadoResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteCronogramaExcel;
import pe.com.divemotor.solicitudcredito.reporte.ReportePropuestaPdf;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteCronogramaExcelDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReportePropuestaPdfDataSource;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.solicitudcredito.services.SimuladorService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

@Service
@Transactional
public class SimuladorServiceImpl implements SimuladorService {

    private SimuladorDAO simuladorDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSimuladorDAO(SimuladorDAO simuladorDAO) {
        this.simuladorDAO = simuladorDAO;
    }

    @Resource(name = "mailServices")
    MailServices mailServices;

    @Override
    public CompaniaSeguroListadoResponse listarCompaniaSeguro(HeaderParams headerParams, String codCiaSeg) throws Exception {
        ListarCompaniaSeguroProcedure parametros = mapper.map(headerParams, ListarCompaniaSeguroProcedure.class);
        parametros.setCodCiaSeg(codCiaSeg);
        simuladorDAO.listarCompaniaSeguro(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            CompaniaSeguroListadoResponse response = new CompaniaSeguroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public ProformaListadoResponse listarProforma(HeaderParams headerParams, String codSoliCred) throws Exception {
        ListarProformaProcedure parametros = mapper.map(headerParams, ListarProformaProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        simuladorDAO.listarProforma(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ProformaListadoResponse response = new ProformaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public SimuladorConceptoListadoResponse listarSimuladorConcepto(HeaderParams headerParams, Integer codConcCol, String indConcOblig) throws Exception {
        ListarSimuladorConceptoProcedure parametros = mapper.map(headerParams, ListarSimuladorConceptoProcedure.class);
        parametros.setCodConcCol(codConcCol);
        parametros.setIndConcOblig(indConcOblig);
        simuladorDAO.listarSimuladorConcepto(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SimuladorConceptoListadoResponse response = new SimuladorConceptoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public BaseResponse registrar(HeaderParams headerParams, SimuladorRequest request) throws Exception {
        RegistrarSimuladorProcedure procedureParams = new RegistrarSimuladorProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        simuladorDAO.registrarSimulador(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());

            for (SimuladorGasto gasto : request.getGastos()) {
                if (gasto.getCodConcCol() != null && gasto.getCodConcCol() > 0) {
                    RegistrarSimuladorGastoProcedure simuladorGastoProcedureParams = new RegistrarSimuladorGastoProcedure();
                    mapper.map(headerParams, simuladorGastoProcedureParams);
                    mapper.map(gasto, simuladorGastoProcedureParams);
                    simuladorGastoProcedureParams.setCodSimu(procedureParams.getCodigo());
                    simuladorDAO.registrarSimuladorGasto(simuladorGastoProcedureParams);

                    if (simuladorGastoProcedureParams.getStatus().equals(Constantes.ESTADO_TRAMA_ERROR_PROCEDURE)) {
                        throw new Exception(procedureParams.getMensaje());
                    }
                }
            }

            GenerarCronogramaProcedure cronogramaProcedureParams = new GenerarCronogramaProcedure();
            mapper.map(headerParams, cronogramaProcedureParams);
            cronogramaProcedureParams.setCodSimu(procedureParams.getCodigo());
            cronogramaProcedureParams.setCodTipCred(procedureParams.getIndTipSeg());
            cronogramaProcedureParams.setMonVta(procedureParams.getValMonFin());
            cronogramaProcedureParams.setPorcCuoIni(procedureParams.getValPorcCI());
            cronogramaProcedureParams.setPeriodicidad(procedureParams.getCodPerCredSol());
            cronogramaProcedureParams.setPrimaSeg(procedureParams.getValPrimaSeg());
            cronogramaProcedureParams.setNroCuotas(procedureParams.getCanTotLet());
            cronogramaProcedureParams.setPlazMes(procedureParams.getCanPlazMeses());
            cronogramaProcedureParams.setPorcCB(procedureParams.getValPorcCuoBal());
            cronogramaProcedureParams.setCodTipPgra(procedureParams.getIndTipPerGra());
            cronogramaProcedureParams.setValDiasPgra(procedureParams.getValDiasPerGra());
            cronogramaProcedureParams.setValMonIntPgra(procedureParams.getValIntPerGra());
            simuladorDAO.generarCronograma(cronogramaProcedureParams);

            if (cronogramaProcedureParams.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                boolean isTasaSegDif = (request.getValTasaSeg() != null
                        && request.getValTasaSeg() < request.getValTasaOriSeg());
                if (isTasaSegDif) {
                    GenerarPlantillaCambioTasaSeguroProcedure procedureParamsMail
                            = new GenerarPlantillaCambioTasaSeguroProcedure();
                    mapper.map(procedureParams, procedureParamsMail);
                    enviarCorreo(procedureParamsMail);
                }
            } else {
                throw new Exception(procedureParams.getMensaje());
            }

            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
    @Override
    public BaseResponse registrarSap(HeaderParams headerParams, SimuladorSapRequest request) throws Exception {
        RegistrarSimuladorSapProcedure procedureParams = new RegistrarSimuladorSapProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        simuladorDAO.registrarSimuladorSap(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());

            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }    

    @Override
    public SimuladorCronogramaListadoResponse cuadrar(HeaderParams headerParams, CuadrarCronogramaRequest request) throws Exception {
        ListarCronogramaProcedure parametros = new ListarCronogramaProcedure();
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        simuladorDAO.cuadrarCronograma(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO)
                || statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SimuladorCronogramaListadoResponse response = new SimuladorCronogramaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setListadoColumna(parametros.getListadoColumna());
            response.setTotal(parametros.getTotal());
            response.setProceso(parametros.getProceso());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public SimuladorCronogramaListadoResponse listarCronograma(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception {
        ListarCronogramaProcedure parametros = mapper.map(headerParams, ListarCronogramaProcedure.class);
        mapper.map(request, parametros);
        simuladorDAO.listarCronograma(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SimuladorCronogramaListadoResponse response = new SimuladorCronogramaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setListadoColumna(parametros.getListadoColumna());
            response.setTotal(parametros.getTotal());
            response.setProceso(parametros.getProceso());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public ReporteResponse exportarCronograma(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception {
        ReporteCronogramaExcelDataSource requestReport = new ReporteCronogramaExcelDataSource();
        ReporteCronogramaExcel reporte = new ReporteCronogramaExcel();
        SimuladorTotal total = new SimuladorTotal();

        ListarCronogramaProcedure parametros = mapper.map(headerParams, ListarCronogramaProcedure.class);
        mapper.map(request, parametros);
        simuladorDAO.listarCronograma(parametros);

        requestReport.setNroLetras(String.valueOf(parametros.getBusqueda().size()));
        requestReport.setCronograma(parametros.getBusqueda());
        total = parametros.getTotal().get(0);
        requestReport.setTotAmortizacion(String.valueOf(total.getTotAmortizacion()));
        requestReport.setTotCuotas(String.valueOf(total.getTotCuotas()));
        requestReport.setTotInteres(String.valueOf(total.getTotInteres()));
        requestReport.setTotMonFin(String.valueOf(total.getTotMonFin()));
        requestReport.setTotSegFin(String.valueOf(total.getTotSegFin()));
        requestReport.setHasSeguro(parametros.getBusqueda().get(0).getSeguro() != null);
        requestReport.setHasCobranzas(parametros.getBusqueda().get(0).getCobranzas() != null);
        requestReport.setHasInteresCompensatorio(parametros.getBusqueda().get(0).getInteresCompensatorio() != null);
        requestReport.setHasInteresMoratorio(parametros.getBusqueda().get(0).getInteresMoratorio() != null);
        requestReport.setHasCostoTraslado(parametros.getBusqueda().get(0).getCostoTraslado() != null);

        byte[] excelByte = reporte.generarReporte(requestReport);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
    }

    @Override
    public ReporteResponse exportarPropuesta(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception {
        ReportePropuestaPdfDataSource requestReport = new ReportePropuestaPdfDataSource();
        ReportePropuestaPdf reporte = new ReportePropuestaPdf();

        ListarPropuestaProcedure parametrosPropuesta = mapper.map(headerParams, ListarPropuestaProcedure.class);
        mapper.map(request, parametrosPropuesta);
        simuladorDAO.listarPropuesta(parametrosPropuesta);

        ListarCronogramaProcedure parametrosCronograma = mapper.map(headerParams, ListarCronogramaProcedure.class);
        mapper.map(request, parametrosCronograma);
        simuladorDAO.listarCronograma(parametrosCronograma);

        SimuladorPropuesta propuesta = parametrosPropuesta.getBusqueda().get(0);
        requestReport.setCliente(propuesta.getCliente());
        requestReport.setTipSoliCred(propuesta.getTipSoliCred());
        requestReport.setNomMoneda(propuesta.getNomMoneda());
        requestReport.setDesMoneda(propuesta.getDesMoneda());
        requestReport.setTipUsoVeh(propuesta.getTipUsoVeh());
        requestReport.setValTotal(String.valueOf(propuesta.getValTotal()));
        requestReport.setValCI(String.valueOf(propuesta.getValCI()));
        requestReport.setValMonFin(String.valueOf(propuesta.getValMonFin()));
        requestReport.setCanPlazMeses(propuesta.getCanPlazMeses());
        requestReport.setPerCredSol(propuesta.getPerCredSol());
        requestReport.setCanDiasVenc1raLetr(propuesta.getCanDiasVenc1raLetr());
        requestReport.setCanTotLet(propuesta.getCanTotLet());
        requestReport.setValPorcTea(String.valueOf(propuesta.getValPorcTea()));
        requestReport.setValIntPerGra(String.valueOf(propuesta.getValIntPerGra()));
        requestReport.setValMontLetr(String.valueOf(propuesta.getValMontLetr()));
        requestReport.setValCuoBal(String.valueOf(propuesta.getValCuoBal()));
        requestReport.setValGastAdm(String.valueOf(propuesta.getValGastAdm()));
        requestReport.setValGarantia(String.valueOf(propuesta.getValGarantia()));
        requestReport.setIndGPS(propuesta.getIndGPS());
        requestReport.setTxtOtrCond(propuesta.getTxtOtrCond());
        SimuladorCronograma cronograma = parametrosCronograma.getBusqueda().get(0);
        requestReport.setHasSeguro(cronograma.getSeguro() != null);
        requestReport.setHasCobranzas(cronograma.getCobranzas() != null);
        requestReport.setHasInteresCompensatorio(cronograma.getInteresCompensatorio() != null);
        requestReport.setHasInteresMoratorio(cronograma.getInteresMoratorio() != null);
        requestReport.setHasCostoTraslado(cronograma.getCostoTraslado() != null);
        requestReport.setCronograma(parametrosCronograma.getBusqueda());
        requestReport.setGarantias(propuesta.getGarantias());
        requestReport.setSeguros(propuesta.getSeguros());

        byte[] excelByte = reporte.generarReporte(requestReport, request.getFlagDatos());

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
    }

    @Override
    public TasaSeguroResponse obtenerTasaSeguro(HeaderParams headerParams, String codCia, String codTipoVeh, String indTipoUso, String codCliente) throws Exception {
        ObtenerTasaSeguroProcedure parametros = mapper.map(headerParams, ObtenerTasaSeguroProcedure.class);
        parametros.setCodCia(codCia);
        parametros.setCodTipoVeh(codTipoVeh);
        parametros.setIndTipoUso(indTipoUso);
        parametros.setCodCliente(codCliente);
        simuladorDAO.obtenerTasaSeguro(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            TasaSeguroResponse response = new TasaSeguroResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setTasaSeg(parametros.getTasaSeg());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }
    
    @Override
    public TasaSeguroResponse calculaTasa(HeaderParams headerParams,CalculaTasaRequest request) throws Exception {
        CalculaTasaProcedure parametros = mapper.map(headerParams, CalculaTasaProcedure.class);
        parametros.setPrimaSeg(request.getPrimaSeg());
        parametros.setPlazoMeses(request.getPlazoMeses());
        parametros.setMontoVta(request.getMontoVta());
        parametros.setPorcIgv(request.getPorcIgv());
        simuladorDAO.calculaTasa(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            TasaSeguroResponse response = new TasaSeguroResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setTasaSeg(parametros.getTasaSeg());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    private GenericoResponse enviarCorreo(GenerarPlantillaCambioTasaSeguroProcedure procedureParams) throws Exception {
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;

        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codUsuario", procedureParams.getCodUsuario());
        parametrosEmail.put("idUsuario", procedureParams.getIdUsuario());
        genericoResponse = mailServices.envioCorreos(parametrosEmail, Constantes.COD_PLANTILLA_REFERENCIA_PROCESO_CAMBIO_TASA_SEGURO);

        return genericoResponse;
    }

    @Override
    public SimuladorPropuestaListadoResponse listarPropuesta(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception {
        ListarPropuestaProcedure parametros = mapper.map(headerParams, ListarPropuestaProcedure.class);
        mapper.map(request, parametros);
        simuladorDAO.listarPropuesta(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SimuladorPropuestaListadoResponse response = new SimuladorPropuestaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public SimuladorGastoListadoResponse listarGasto(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception {
        ListarSimuladorGastoProcedure parametros = mapper.map(headerParams, ListarSimuladorGastoProcedure.class);
        mapper.map(request, parametros);
        simuladorDAO.listarGasto(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SimuladorGastoListadoResponse response = new SimuladorGastoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public TasasListadoResponse listarTasas(HeaderParams headerParams, String noCia, String moneda) throws Exception {
        ListarTasasProcedure parametros = mapper.map(headerParams, ListarTasasProcedure.class);
        parametros.setNoCia(noCia);
        parametros.setMoneda(moneda);

        simuladorDAO.listarTasas(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            TasasListadoResponse response = new TasasListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public BaseResponse registrarProforma(HeaderParams headerParams, SimuladorProformaRequest request) throws Exception {
        RegistrarSimuladorProformaProcedure procedureParams = new RegistrarSimuladorProformaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        simuladorDAO.registrarSimuladorProforma(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
        }
