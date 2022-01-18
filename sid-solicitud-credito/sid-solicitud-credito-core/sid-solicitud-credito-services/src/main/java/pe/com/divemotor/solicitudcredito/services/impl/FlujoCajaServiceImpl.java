/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.FlujoCajaDAO;
import pe.com.divemotor.solicitudcredito.dao.GarantiaDAO;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCajaxAnio;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarFlujoCajaInfoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaDetalleProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarFactorPorMesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarProyeccionFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.FactorPorMesFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaDetalleRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ParametrosFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionFlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaInfoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaDetalleListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParametrosFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionFlujoCajaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteFlujoCajaCamionesExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFlujoCajaExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.FlujoCajaService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author mbardales
 */
@Service
@Transactional
public class FlujoCajaServiceImpl implements FlujoCajaService {

    private FlujoCajaDAO flujoCajaDAO;
    private GarantiaDAO garantiaDAO;
    private Mapper mapper;

    @Autowired
    public void setFlujoCajaDAO(FlujoCajaDAO flujoCajaDAO) {
        this.flujoCajaDAO = flujoCajaDAO;
    }

    @Autowired
    public void setGarantiaDAO(GarantiaDAO garantiaDAO) {
        this.garantiaDAO = garantiaDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BaseResponse registrarParametrosFC(HeaderParams headerParams, ParametrosFlujoCajaRequest request) throws Exception {

        RegistrarParametrosFlujoCajaProcedure procedureParams = new RegistrarParametrosFlujoCajaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        flujoCajaDAO.registrarParametrosFC(procedureParams);

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
    public BaseResponse registrarFactorPorMes(HeaderParams headerParams, FactorPorMesFlujoCajaRequest request) throws Exception {

        RegistrarFactorPorMesProcedure procedureParams = new RegistrarFactorPorMesProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        flujoCajaDAO.registrarFactorPorMes(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        switch (statusQuery) {
            case Constantes.ESTADO_TRAMA_OK:
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
    public ProyeccionFlujoCajaListadoResponse registrarProyeccionFlujoCaja(HeaderParams headerParams, ProyeccionFlujoCajaRequest request) throws Exception {

        RegistrarProyeccionFlujoCajaProcedure procedureParams = new RegistrarProyeccionFlujoCajaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        flujoCajaDAO.registrarProyeccionFlujoCaja(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK) || statusQuery.equals(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO)) {
            ProyeccionFlujoCajaListadoResponse response = new ProyeccionFlujoCajaListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setListaNroAnios(procedureParams.getListaNroAnios());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Override
    public ParametrosFlujoCajaListadoResponse listarParametrosFlujoCaja(HeaderParams headerParams, ListaParametrosFlujoCajaRequest request) throws Exception {

        ListarParametrosFlujoCajaProcedure procedureParams = new ListarParametrosFlujoCajaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        flujoCajaDAO.listarParametrosFlujoCaja(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ParametrosFlujoCajaListadoResponse response = new ParametrosFlujoCajaListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCabecerasUrbano(procedureParams.getCabecerasUrbano());
            response.setFactoresConstantesFlujoCajaIF(procedureParams.getFactoresConstantesFlujoCajaIF());
            response.setFactoresConstantesFlujoCajaEF(procedureParams.getFactoresConstantesFlujoCajaEF());         
            response.setFactoresPorMesFlujoCajaIF(procedureParams.getFactoresPorMesFlujoCajaIF());
            response.setFactoresPorMesFlujoCajaEF(procedureParams.getFactoresPorMesFlujoCajaEF());
            response.setListaAnios(procedureParams.getListaAnios());
            response.setListaValProyPorAnios(procedureParams.getListaValProyPorAnios());

            ListarParametrosFlujoCajaProcedure parametrosFlujoCaja = mapper.map(headerParams, ListarParametrosFlujoCajaProcedure.class);
            parametrosFlujoCaja.setCodSoliCred(request.getCodSoliCred());
            flujoCajaDAO.listarParametrosFlujoCaja(parametrosFlujoCaja);
            List<String> lstCoberFC = new ArrayList<>();

            if (parametrosFlujoCaja.getListaValProyPorAnios() != null && parametrosFlujoCaja.getListaValProyPorAnios().size() > 0) {
                CoberturaFlujoCajaValAnios valAnios = parametrosFlujoCaja.getListaValProyPorAnios().get(0);
                lstCoberFC.add(valAnios.getValAnio1());
                lstCoberFC.add(valAnios.getValAnio2());
                lstCoberFC.add(valAnios.getValAnio3());
                lstCoberFC.add(valAnios.getValAnio4());
                lstCoberFC.add(valAnios.getValAnio5());
                lstCoberFC.add(valAnios.getValAnio6());
                lstCoberFC.add(valAnios.getValAnio7());
                lstCoberFC.add(valAnios.getValAnio8());
                lstCoberFC.add(valAnios.getValAnio9());
                lstCoberFC.add(valAnios.getValAnio10());
                response.setLstCoberFC(lstCoberFC);
            }

            ListarCoberturaGarantiaProcedure parametrosCobertura = mapper.map(headerParams, ListarCoberturaGarantiaProcedure.class);
            parametrosCobertura.setCodSoliCred(request.getCodSoliCred());
            garantiaDAO.listarCoberturaGarantia(parametrosCobertura);
            List<String> lstAnios = new ArrayList<>();
            List<String> lstCoberGara = new ArrayList<>();
            if (parametrosCobertura.getBusqueda() != null && parametrosCobertura.getBusqueda().size() > 0) {

                for (int i = 0; i < parametrosCobertura.getBusqueda().size(); i++) {
                    lstAnios.add(parametrosCobertura.getBusqueda().get(i).getAno());
                    lstCoberGara.add(parametrosCobertura.getBusqueda().get(i).getRatio_cob());
                }
                response.setLstAnios(lstAnios);
                response.setLstCoberGara(lstCoberGara);

            }

            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public ParametrosFlujoCajaDetalleListadoResponse listarParametrosFlujoCajaDetalle(HeaderParams headerParams, ListaParametrosFlujoCajaDetalleRequest request) throws Exception {
        ListarParametrosFlujoCajaDetalleProcedure procedureParams = new ListarParametrosFlujoCajaDetalleProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        flujoCajaDAO.listarParametrosFlujoCajaDetalle(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ParametrosFlujoCajaDetalleListadoResponse response = new ParametrosFlujoCajaDetalleListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setListaEgresos(procedureParams.getListaEgresos());
            response.setListaDetalleFlujoCaja(procedureParams.getListaDetalleFlujoCaja());
            response.setListaProyectado(procedureParams.getListaProyectado());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public ReporteResponse exportarReporteFlujoCajaCamiones(HeaderParams headerParams, String codSoliCred, String indTipoFc) throws Exception {

        ReporteFlujoCajaExcelDataSource response = new ReporteFlujoCajaExcelDataSource();
        ReporteFlujoCajaCamionesExcel reporte = new ReporteFlujoCajaCamionesExcel();

        ListarParametrosFlujoCajaDetalleProcedure parametrosFC = new ListarParametrosFlujoCajaDetalleProcedure();
        parametrosFC.setCodSoliCred(codSoliCred);
        parametrosFC.setIndTipoFc(indTipoFc);
        flujoCajaDAO.listarParametrosFlujoCajaDetalle(parametrosFC);

        if (parametrosFC.getBusqueda().size() > 0) {
            response.setListaIngresos(parametrosFC.getBusqueda());
        }

        ParametrosFlujoCajaxAnio parametros = parametrosFC.getBusqueda().get(0);
        response.setHasAnio1Mes1(parametros.getAnio1Mes1() != null);
        response.setHasAnio1Mes2(parametros.getAnio1Mes2() != null);
        response.setHasAnio1Mes3(parametros.getAnio1Mes3() != null);
        response.setHasAnio1Mes4(parametros.getAnio1Mes4() != null);
        response.setHasAnio1Mes5(parametros.getAnio1Mes5() != null);
        response.setHasAnio1Mes6(parametros.getAnio1Mes6() != null);
        response.setHasAnio1Mes7(parametros.getAnio1Mes7() != null);
        response.setHasAnio1Mes8(parametros.getAnio1Mes8() != null);
        response.setHasAnio1Mes9(parametros.getAnio1Mes9() != null);
        response.setHasAnio1Mes10(parametros.getAnio1Mes10() != null);
        response.setHasAnio1Mes11(parametros.getAnio1Mes11() != null);
        response.setHasAnio1Mes12(parametros.getAnio1Mes12() != null);
        response.setHasAnio2Mes1(parametros.getAnio2Mes1() != null);
        response.setHasAnio2Mes2(parametros.getAnio2Mes2() != null);
        response.setHasAnio2Mes3(parametros.getAnio2Mes3() != null);
        response.setHasAnio2Mes4(parametros.getAnio2Mes4() != null);
        response.setHasAnio2Mes5(parametros.getAnio2Mes5() != null);
        response.setHasAnio2Mes6(parametros.getAnio2Mes6() != null);
        response.setHasAnio2Mes7(parametros.getAnio2Mes7() != null);
        response.setHasAnio2Mes8(parametros.getAnio2Mes8() != null);
        response.setHasAnio2Mes9(parametros.getAnio2Mes9() != null);
        response.setHasAnio2Mes10(parametros.getAnio2Mes10() != null);
        response.setHasAnio2Mes11(parametros.getAnio2Mes11() != null);
        response.setHasAnio2Mes12(parametros.getAnio2Mes12() != null);
        response.setHasAnio3Mes1(parametros.getAnio3Mes1() != null);
        response.setHasAnio3Mes2(parametros.getAnio3Mes2() != null);
        response.setHasAnio3Mes3(parametros.getAnio3Mes3() != null);
        response.setHasAnio3Mes4(parametros.getAnio3Mes4() != null);
        response.setHasAnio3Mes5(parametros.getAnio3Mes5() != null);
        response.setHasAnio3Mes6(parametros.getAnio3Mes6() != null);
        response.setHasAnio3Mes7(parametros.getAnio3Mes7() != null);
        response.setHasAnio3Mes8(parametros.getAnio3Mes8() != null);
        response.setHasAnio3Mes9(parametros.getAnio3Mes9() != null);
        response.setHasAnio3Mes10(parametros.getAnio3Mes10() != null);
        response.setHasAnio3Mes11(parametros.getAnio3Mes11() != null);
        response.setHasAnio3Mes12(parametros.getAnio3Mes12() != null);
        response.setHasAnio4Mes1(parametros.getAnio4Mes1() != null);
        response.setHasAnio4Mes2(parametros.getAnio4Mes2() != null);
        response.setHasAnio4Mes3(parametros.getAnio4Mes3() != null);
        response.setHasAnio4Mes4(parametros.getAnio4Mes4() != null);
        response.setHasAnio4Mes5(parametros.getAnio4Mes5() != null);
        response.setHasAnio4Mes6(parametros.getAnio4Mes6() != null);
        response.setHasAnio4Mes7(parametros.getAnio4Mes7() != null);
        response.setHasAnio4Mes8(parametros.getAnio4Mes8() != null);
        response.setHasAnio4Mes9(parametros.getAnio4Mes9() != null);
        response.setHasAnio4Mes10(parametros.getAnio4Mes10() != null);
        response.setHasAnio4Mes11(parametros.getAnio4Mes11() != null);
        response.setHasAnio4Mes12(parametros.getAnio4Mes12() != null);
        response.setHasAnio5Mes1(parametros.getAnio5Mes1() != null);
        response.setHasAnio5Mes2(parametros.getAnio5Mes2() != null);
        response.setHasAnio5Mes3(parametros.getAnio5Mes3() != null);
        response.setHasAnio5Mes4(parametros.getAnio5Mes4() != null);
        response.setHasAnio5Mes5(parametros.getAnio5Mes5() != null);
        response.setHasAnio5Mes6(parametros.getAnio5Mes6() != null);
        response.setHasAnio5Mes7(parametros.getAnio5Mes7() != null);
        response.setHasAnio5Mes8(parametros.getAnio5Mes8() != null);
        response.setHasAnio5Mes9(parametros.getAnio5Mes9() != null);
        response.setHasAnio5Mes10(parametros.getAnio5Mes10() != null);
        response.setHasAnio5Mes11(parametros.getAnio5Mes11() != null);
        response.setHasAnio5Mes12(parametros.getAnio5Mes12() != null);
        response.setHasAnio6Mes1(parametros.getAnio6Mes1() != null);
        response.setHasAnio6Mes2(parametros.getAnio6Mes2() != null);
        response.setHasAnio6Mes3(parametros.getAnio6Mes3() != null);
        response.setHasAnio6Mes4(parametros.getAnio6Mes4() != null);
        response.setHasAnio6Mes5(parametros.getAnio6Mes5() != null);
        response.setHasAnio6Mes6(parametros.getAnio6Mes6() != null);
        response.setHasAnio6Mes7(parametros.getAnio6Mes7() != null);
        response.setHasAnio6Mes8(parametros.getAnio6Mes8() != null);
        response.setHasAnio6Mes9(parametros.getAnio6Mes9() != null);
        response.setHasAnio6Mes10(parametros.getAnio6Mes10() != null);
        response.setHasAnio6Mes11(parametros.getAnio6Mes11() != null);
        response.setHasAnio6Mes12(parametros.getAnio6Mes12() != null);
        response.setHasAnio7Mes1(parametros.getAnio7Mes1() != null);
        response.setHasAnio7Mes2(parametros.getAnio7Mes2() != null);
        response.setHasAnio7Mes3(parametros.getAnio7Mes3() != null);
        response.setHasAnio7Mes4(parametros.getAnio7Mes4() != null);
        response.setHasAnio7Mes5(parametros.getAnio7Mes5() != null);
        response.setHasAnio7Mes6(parametros.getAnio7Mes6() != null);
        response.setHasAnio7Mes7(parametros.getAnio7Mes7() != null);
        response.setHasAnio7Mes8(parametros.getAnio7Mes8() != null);
        response.setHasAnio7Mes9(parametros.getAnio7Mes9() != null);
        response.setHasAnio7Mes10(parametros.getAnio7Mes10() != null);
        response.setHasAnio7Mes11(parametros.getAnio7Mes11() != null);
        response.setHasAnio7Mes12(parametros.getAnio7Mes12() != null);
        response.setHasAnio8Mes1(parametros.getAnio8Mes1() != null);
        response.setHasAnio8Mes2(parametros.getAnio8Mes2() != null);
        response.setHasAnio8Mes3(parametros.getAnio8Mes3() != null);
        response.setHasAnio8Mes4(parametros.getAnio8Mes4() != null);
        response.setHasAnio8Mes5(parametros.getAnio8Mes5() != null);
        response.setHasAnio8Mes6(parametros.getAnio8Mes6() != null);
        response.setHasAnio8Mes7(parametros.getAnio8Mes7() != null);
        response.setHasAnio8Mes8(parametros.getAnio8Mes8() != null);
        response.setHasAnio8Mes9(parametros.getAnio8Mes9() != null);
        response.setHasAnio8Mes10(parametros.getAnio8Mes10() != null);
        response.setHasAnio8Mes11(parametros.getAnio8Mes11() != null);
        response.setHasAnio8Mes12(parametros.getAnio8Mes12() != null);
        response.setHasAnio9Mes1(parametros.getAnio9Mes1() != null);
        response.setHasAnio9Mes2(parametros.getAnio9Mes2() != null);
        response.setHasAnio9Mes3(parametros.getAnio9Mes3() != null);
        response.setHasAnio9Mes4(parametros.getAnio9Mes4() != null);
        response.setHasAnio9Mes5(parametros.getAnio9Mes5() != null);
        response.setHasAnio9Mes6(parametros.getAnio9Mes6() != null);
        response.setHasAnio9Mes7(parametros.getAnio9Mes7() != null);
        response.setHasAnio9Mes8(parametros.getAnio9Mes8() != null);
        response.setHasAnio9Mes9(parametros.getAnio9Mes9() != null);
        response.setHasAnio9Mes10(parametros.getAnio9Mes10() != null);
        response.setHasAnio9Mes11(parametros.getAnio9Mes11() != null);
        response.setHasAnio9Mes12(parametros.getAnio9Mes12() != null);
        response.setHasAnio10Mes1(parametros.getAnio10Mes1() != null);
        response.setHasAnio10Mes2(parametros.getAnio10Mes2() != null);
        response.setHasAnio10Mes3(parametros.getAnio10Mes3() != null);
        response.setHasAnio10Mes4(parametros.getAnio10Mes4() != null);
        response.setHasAnio10Mes5(parametros.getAnio10Mes5() != null);
        response.setHasAnio10Mes6(parametros.getAnio10Mes6() != null);
        response.setHasAnio10Mes7(parametros.getAnio10Mes7() != null);
        response.setHasAnio10Mes8(parametros.getAnio10Mes8() != null);
        response.setHasAnio10Mes9(parametros.getAnio10Mes9() != null);
        response.setHasAnio10Mes10(parametros.getAnio10Mes10() != null);
        response.setHasAnio10Mes11(parametros.getAnio10Mes11() != null);
        response.setHasAnio10Mes12(parametros.getAnio10Mes12() != null);

        if (parametrosFC.getListaEgresos().size() > 0) {
            response.setListaEgresos(parametrosFC.getListaEgresos());
        }

        if (parametrosFC.getListaDetalleFlujoCaja().size() > 0) {        
            response.setListaFlujoCaja(parametrosFC.getListaDetalleFlujoCaja());
        }

        if (parametrosFC.getListaProyectado().size() > 0) {
            response.setListaProyectado(parametrosFC.getListaProyectado());
        }

        response.setComentarios(parametrosFC.getComentarios()== null ? "":parametrosFC.getComentarios());

        byte[] excelByte = reporte.generarReporte(response);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;

    }

    @Override
    public FlujoCajaInfoResponse listarFlujoCajaInfo(HeaderParams headerParams, String codSoliCred) throws Exception {
        ListarFlujoCajaInfoProcedure procedureParams = new ListarFlujoCajaInfoProcedure();
        mapper.map(headerParams, procedureParams);
        procedureParams.setCodSoliCred(codSoliCred);

        flujoCajaDAO.listarFlujoCajaInfo(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            FlujoCajaInfoResponse response = new FlujoCajaInfoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

}
