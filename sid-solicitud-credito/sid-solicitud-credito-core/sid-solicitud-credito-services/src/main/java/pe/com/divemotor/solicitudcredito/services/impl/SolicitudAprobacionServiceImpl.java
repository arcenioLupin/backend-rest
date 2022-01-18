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
import pe.com.divemotor.solicitudcredito.dao.SolicitudAprobacionDAO;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLAval;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliaria;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantias;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLHipotecariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoFinanciamiento;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoGarantes;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoRefinanciamiento;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLPrincipal;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.FormatoRDLProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarHistorialAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarMotivosAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarPropuestaProcedure; 
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.request.FormatoRDLRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudAprobacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DatosAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FormatoRDLListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.HistorialAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MotivosAprobacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteFormatoRDLExcel;
import pe.com.divemotor.solicitudcredito.reporte.ReporteFormatoRDLMutuoExcel;
import pe.com.divemotor.solicitudcredito.reporte.ReporteFormatoRDLRefinanciamientoExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLExcelDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLGarantiasDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLGarantiasHipoAdicDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLGarantiasMobiAdicDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLInfoFinanciamiento;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLMutuoDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteFormatoRDLRefinanciamientoDataSource;
import pe.com.divemotor.solicitudcredito.services.SolicitudAprobacionService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author legutierrez
 */
@Service
@Transactional
public class SolicitudAprobacionServiceImpl implements SolicitudAprobacionService {

    private SolicitudAprobacionDAO solicitudAprobacionDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSolicitudAprobacionDAO(SolicitudAprobacionDAO solicitudAprobacionDAO) {
        this.solicitudAprobacionDAO = solicitudAprobacionDAO;
    }

    @Override
    public BaseResponse registrar(HeaderParams headerParams, SolicitudAprobacionRequest request) throws Exception {

        RegistrarAprobacionProcedure procedureParams = new RegistrarAprobacionProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudAprobacionDAO.registrarAprobacion(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            DatosAprobacionResponse response = new DatosAprobacionResponse(); // 90690 ivelasquez 21/09/2021
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getListaAprobacion()); // 90690 ivelasquez 21/09/2021
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse actualizar(HeaderParams headerParams, ActualizarSolicitudAprobacionRequest request) throws Exception {

        ActualizarSolicitudAprobacionProcedure procedureParams = new ActualizarSolicitudAprobacionProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudAprobacionDAO.actualizarSolicitudApro(procedureParams);

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
    public FormatoRDLListadoResponse listaFormatoRDL(HeaderParams headerParams, FormatoRDLRequest request) throws Exception {
        FormatoRDLProcedure parametros = new FormatoRDLProcedure();
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        solicitudAprobacionDAO.listarFormatoRDL(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            FormatoRDLListadoResponse response = new FormatoRDLListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setListaAvales(parametros.getListaAvales());
            response.setListaGarantiasMob(parametros.getListaGarantiasMob());
            response.setListaGarantiasMobAdic(parametros.getListaGarantiasMobAdic());
            response.setListaGarantiasHipAdic(parametros.getListaGarantiasHipAdic());
            response.setListaGarantias(parametros.getListaGarantias());
            response.setListaInfoRefinanciamiento(parametros.getListaInfoRefinanciamiento());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public ReporteResponse exportarFormatoRDL(HeaderParams headerParams, String codSoliCred) throws Exception {

        ReporteFormatoRDLExcelDataSource request = new ReporteFormatoRDLExcelDataSource();
        ReporteFormatoRDLExcel reporte = new ReporteFormatoRDLExcel();

        FormatoRDLProcedure parametrosFormatoRDL = mapper.map(headerParams, FormatoRDLProcedure.class);
        parametrosFormatoRDL.setCodSoliCred(codSoliCred);
        solicitudAprobacionDAO.listarFormatoRDL(parametrosFormatoRDL);

        if (parametrosFormatoRDL.getBusqueda().size() > 0) {
            FormatoRDLPrincipal datosPrincipales = parametrosFormatoRDL.getBusqueda().get(0);
            request.setTitulo(datosPrincipales.getTitulo());
            request.setIndNuevoUsado(datosPrincipales.getIndNuevoUsado());
            request.setNomEmpresa(datosPrincipales.getNomEmpresa());
            request.setCodClie(datosPrincipales.getCodClie());
            request.setNomPerso(datosPrincipales.getNomPerso());
            request.setNumDocu(datosPrincipales.getNumDocu());
            request.setDirDomicilio(datosPrincipales.getDirDomicilio());
            request.setDistrito(datosPrincipales.getDistrito());
            request.setProvincia(datosPrincipales.getProvincia());
            request.setDepartamento(datosPrincipales.getDepartamento());
            request.setNomBanco(datosPrincipales.getNomBanco());
            request.setMarca(datosPrincipales.getMarca());
            request.setValAnoFab(datosPrincipales.getValAnoFab());
            request.setModelo(datosPrincipales.getModelo());
            request.setChasis(datosPrincipales.getChasis());
            request.setMotor(datosPrincipales.getMotor());
            request.setPlaca(datosPrincipales.getPlaca());
            request.setTea(datosPrincipales.getTea());
            request.setPeriGracia(datosPrincipales.getPeriGracia());
            request.setValIntPerGra(datosPrincipales.getValIntPerGra());
            request.setTipoSeguro(datosPrincipales.getTipoSeguro());
            request.setCanPlazMes(datosPrincipales.getCanPlazMes());
            request.setNomRespoFina(datosPrincipales.getNomRespoFina());
            request.setCodClasifSbsClie(datosPrincipales.getCodClasifSbsClie());
            //NUEVOS CAMPOS PARA CHECK LIST
            request.setIndInfo(datosPrincipales.getIndInfo());
            request.setTipoPersona(datosPrincipales.getTipoPersona());
            request.setIndNroOpe(datosPrincipales.getIndNroOpe());
            request.setPeriGracSinInt(datosPrincipales.getPeriGracSinInt());
            request.setDiasPeriGrac(datosPrincipales.getDiasPeriGrac());
            request.setFecFirmaCont(datosPrincipales.getFecFirmaCont());
            request.setFecEntreLeg(datosPrincipales.getFecEntreLeg());
            request.setTipoVeh(datosPrincipales.getTipoVeh());
            //
        }

        if (parametrosFormatoRDL.getListaAvales().size() > 0) {
            FormatoRDLAval datosAvales = parametrosFormatoRDL.getListaAvales().get(0);
            // SE AGREGO TIPO PERS AVAL
            request.setTipoPersAval(datosAvales.getTipoPersAval());
            //
            request.setNomPersAval(datosAvales.getNomPersAval());
            request.setDoiAval(datosAvales.getDoi());
            request.setDireccionAval(datosAvales.getDireccion());
            request.setDistritoAval(datosAvales.getDistrito());
            request.setProvinciaAval(datosAvales.getProvincia());
            request.setDepartamentoAval(datosAvales.getDepartamento());
            request.setValMontoFianzaAval(datosAvales.getValMontoFianza());
        }
        
        // SE AGREGA DATOS PARA GARANTE
        if (parametrosFormatoRDL.getListaInfoGarantes().size() > 0) {
            FormatoRDLInfoGarantes datosGarantes = parametrosFormatoRDL.getListaInfoGarantes().get(0);
            request.setTipoPersGarante(datosGarantes.getTipoPersGarante());   
            request.setNomPersGarante(datosGarantes.getNomPersGarante());
            request.setDoiGarante(datosGarantes.getDoiGarante());
            request.setDireccionGarante(datosGarantes.getDireccionGarante());
            request.setDistritoGarante(datosGarantes.getDistritoGarante());
            request.setProvinciaGarante(datosGarantes.getProvinciaGarante());
            request.setDepartamentoGarante(datosGarantes.getDepartamentoGarante());
        }

        if (parametrosFormatoRDL.getListaGarantiasMob().size() > 0) {
            FormatoRDLGarantiaMobiliaria datosGarMobi = parametrosFormatoRDL.getListaGarantiasMob().get(0);
            request.setGarantiaPropiaMobi(datosGarMobi.getGarantiaPropia().equals("SI"));
            request.setGarantiaAjenaMobi(datosGarMobi.getGarantiaAjena().equals("SI"));
            request.setIndTipoBienMobi(datosGarMobi.getIndTipoBien());
            request.setOtorganteMobi(datosGarMobi.getOtorgante().equals("DEUDOR"));
            request.setNroPlacaMobi(datosGarMobi.getNroPlaca());
        }

        if (parametrosFormatoRDL.getListaGarantiasMobAdic().size() > 0) {
            FormatoRDLGarantiaMobiliariaAdicional datosGarMobiAdic = parametrosFormatoRDL.getListaGarantiasMobAdic().get(0);
            request.setGarantiaPropiaMobiAdic(datosGarMobiAdic.getGarantiaPropia().equals("SI"));
            request.setGarantiaAjenaMobiAdic(datosGarMobiAdic.getGarantiaAjena().equals("SI"));
            request.setIndTipoBienMobiAdic(datosGarMobiAdic.getIndTipoBien());
            request.setOtorganteMobiAdic(datosGarMobiAdic.getOtorgante().equals("DEUDOR"));
            request.setNroPlacaMobiAdic(datosGarMobiAdic.getNroPlaca());
        }

        if (parametrosFormatoRDL.getListaGarantiasHipAdic().size() > 0) {
            FormatoRDLHipotecariaAdicional datosGarHipoAdic = parametrosFormatoRDL.getListaGarantiasHipAdic().get(0);
            request.setOtorganteHipoAdic(datosGarHipoAdic.getOtorgante().equals("DEUDOR"));
            request.setDireccionHipoAdic(datosGarHipoAdic.getDireccion());
            request.setDistritoHipoAdic(datosGarHipoAdic.getDistrito());
            request.setProvinciaHipoAdic(datosGarHipoAdic.getProvincia());
            request.setDepartamentoHipoAdic(datosGarHipoAdic.getDepartamento());
            request.setValMontOtorHipoAdic(datosGarHipoAdic.getValMontOtorHip());
            request.setValRealizGarHipoAdic(datosGarHipoAdic.getValRealizGar());
            request.setCodRangoGarHipoAdic(datosGarHipoAdic.getCodRangoGar());
            request.setDesTipoActividadHipoAdic(datosGarHipoAdic.getDesTipoActividad());
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
    public ReporteResponse exportarFormatoRDLRefinanciamiento(HeaderParams headerParams, String codSoliCred) throws Exception {
        
        ReporteFormatoRDLRefinanciamientoDataSource request = new ReporteFormatoRDLRefinanciamientoDataSource();
        ReporteFormatoRDLRefinanciamientoExcel reporte = new ReporteFormatoRDLRefinanciamientoExcel();

        FormatoRDLProcedure parametrosFormatoRDL = mapper.map(headerParams, FormatoRDLProcedure.class);
        parametrosFormatoRDL.setCodSoliCred(codSoliCred);
        solicitudAprobacionDAO.listarFormatoRDL(parametrosFormatoRDL);
        
        List<ReporteFormatoRDLGarantiasDataSource> listadoGarantias = new ArrayList<>();
        
        if (parametrosFormatoRDL.getBusqueda().size() > 0){
            FormatoRDLPrincipal datosPrincipales = parametrosFormatoRDL.getBusqueda().get(0);
            request.setNomEmpresa(datosPrincipales.getNomEmpresa());
            request.setCodClie(datosPrincipales.getCodClie());
            request.setNomPerso(datosPrincipales.getNomPerso());
            request.setNumDocu(datosPrincipales.getNumDocu());
            request.setDirDomicilio(datosPrincipales.getDirDomicilio());
            request.setDistrito(datosPrincipales.getDistrito());
            request.setProvincia(datosPrincipales.getProvincia());
            request.setDepartamento(datosPrincipales.getDepartamento());
        }
        
        if (parametrosFormatoRDL.getListaGarantias().size() > 0) {
            for(FormatoRDLGarantias objGarantias : parametrosFormatoRDL.getListaGarantias()){
                ReporteFormatoRDLGarantiasDataSource garantias = new ReporteFormatoRDLGarantiasDataSource();
                garantias.setOtorgante(objGarantias.getOtorgante() != null &&objGarantias.getOtorgante().equals("D"));
                garantias.setNroPlaca(objGarantias.getNroPlaca());
                garantias.setNumTituloRpv(objGarantias.getNumTituloRpv());
                garantias.setNroPartida(objGarantias.getNroPartida());
                garantias.setIndRegMob(objGarantias.getIndRegMob() != null && objGarantias.getIndRegMob().equals("S"));
                garantias.setIndRegJur(objGarantias.getIndRegJur() != null && objGarantias.getIndRegJur().equals("S"));
                garantias.setTxtInfoModGar(objGarantias.getTxtInfoModGar());
                garantias.setIndRatifica(objGarantias.getIndRatifica() != null && objGarantias.getIndRatifica().equals("S"));
                garantias.setValNvoMonto(objGarantias.getValNvoMonto());
                garantias.setValNvoVal(objGarantias.getValNvoVal());
                listadoGarantias.add(garantias);
            }
        }
        
        request.setListaGarantias(listadoGarantias);
        
        if (parametrosFormatoRDL.getListaInfoRefinanciamiento().size() > 0) {
            FormatoRDLInfoRefinanciamiento datosRefinanciamiento = parametrosFormatoRDL.getListaInfoRefinanciamiento().get(0);
            request.setValPorcTeaSigv(datosRefinanciamiento.getValPorcTeaSigv());
            request.setValPrimaSeg(datosRefinanciamiento.getValPrimaSeg());
            request.setCanPlazMeses(datosRefinanciamiento.getCanPlazMeses());
            request.setIndTipPerGra(datosRefinanciamiento.getIndTipPerGra());
            request.setCanLetPerGra(datosRefinanciamiento.getCanLetPerGra());
            request.setCanPlazMesesRestante(datosRefinanciamiento.getCanPlazMesesRestante());
            request.setValLetraInicial(datosRefinanciamiento.getValLetraInicial());
            request.setValLetraFinal(datosRefinanciamiento.getValLetraFinal());
            request.setValTotalLetr(datosRefinanciamiento.getValTotalLetr());
            request.setFecVencInicial(datosRefinanciamiento.getFecVencInicial());
            request.setFecVencFinal(datosRefinanciamiento.getFecVencFinal());
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
    public ReporteResponse exportarFormatoRDLMutuo(HeaderParams headerParams, String codSoliCred) throws Exception {
        
        ReporteFormatoRDLMutuoDataSource request = new ReporteFormatoRDLMutuoDataSource();
        ReporteFormatoRDLMutuoExcel reporte = new ReporteFormatoRDLMutuoExcel();

        FormatoRDLProcedure parametrosFormatoRDL = mapper.map(headerParams, FormatoRDLProcedure.class);
        parametrosFormatoRDL.setCodSoliCred(codSoliCred);
        solicitudAprobacionDAO.listarFormatoMutuo(parametrosFormatoRDL);
        
        List<ReporteFormatoRDLGarantiasMobiAdicDataSource> listadoGarantiasMobiAdic = new ArrayList<>();
        List<ReporteFormatoRDLGarantiasHipoAdicDataSource> listadoGarantiasHipoAdic = new ArrayList<>();
        
        if (parametrosFormatoRDL.getBusqueda().size() > 0) {
            FormatoRDLPrincipal datosPrincipales = parametrosFormatoRDL.getBusqueda().get(0);
            request.setTitulo(datosPrincipales.getTitulo());
            request.setIndNuevoUsado(datosPrincipales.getIndNuevoUsado());
            request.setNomEmpresa(datosPrincipales.getNomEmpresa());
            request.setCodClie(datosPrincipales.getCodClie());
            request.setNomPerso(datosPrincipales.getNomPerso());
            request.setNumDocu(datosPrincipales.getNumDocu());
            request.setDirDomicilio(datosPrincipales.getDirDomicilio());
            request.setDistrito(datosPrincipales.getDistrito());
            request.setProvincia(datosPrincipales.getProvincia());
            request.setDepartamento(datosPrincipales.getDepartamento());
            request.setTea(datosPrincipales.getTea());
            request.setPeriGracia(datosPrincipales.getPeriGracia());
            request.setNomRespoFina(datosPrincipales.getNomRespoFina());
            request.setCodClasifSbsClie(datosPrincipales.getCodClasifSbsClie());
            //NUEVOS CAMPOS PARA CHECK LIST
            request.setIndInfo(datosPrincipales.getIndInfo());
            request.setTipoPersona(datosPrincipales.getTipoPersona());
            request.setIndNroOpe(datosPrincipales.getIndNroOpe());
            request.setPeriGracSinInt(datosPrincipales.getPeriGracSinInt());
            request.setDiasPeriGrac(datosPrincipales.getDiasPeriGrac());
            request.setFecFirmaCont(datosPrincipales.getFecFirmaCont());
            request.setFecEntreLeg(datosPrincipales.getFecEntreLeg());
            request.setTipoVeh(datosPrincipales.getTipoVeh());
            request.setInfoDetMutuo(datosPrincipales.getInfoDetMutuo());
            request.setNomBancoMutuo(datosPrincipales.getNomBancoMutuo());
        }
        
        if (parametrosFormatoRDL.getListaAvales().size() > 0) {
            FormatoRDLAval datosAvales = parametrosFormatoRDL.getListaAvales().get(0);
            // SE AGREGO TIPO PERS AVAL
            request.setTipoPersAval(datosAvales.getTipoPersAval());
            //
            request.setNomPersAval(datosAvales.getNomPersAval());
            request.setDoiAval(datosAvales.getDoi());
            request.setDireccionAval(datosAvales.getDireccion());
            request.setDistritoAval(datosAvales.getDistrito());
            request.setProvinciaAval(datosAvales.getProvincia());
            request.setDepartamentoAval(datosAvales.getDepartamento());
            request.setValMontoFianzaAval(datosAvales.getValMontoFianza());
        }
        
        if (parametrosFormatoRDL.getListaGarantiasMobAdic().size() > 0){
            for (FormatoRDLGarantiaMobiliariaAdicional objGarantiasMobiAdi : parametrosFormatoRDL.getListaGarantiasMobAdic()){
                ReporteFormatoRDLGarantiasMobiAdicDataSource garantiaMobiAdi = new ReporteFormatoRDLGarantiasMobiAdicDataSource();
                garantiaMobiAdi.setGarantiaPropia(objGarantiasMobiAdi.getGarantiaPropia().equals("SI"));
                garantiaMobiAdi.setGarantiaAjena(objGarantiasMobiAdi.getGarantiaAjena().equals("SI"));
                garantiaMobiAdi.setIndTipoBien(objGarantiasMobiAdi.getIndTipoBien());
                garantiaMobiAdi.setOtorgante(objGarantiasMobiAdi.getOtorgante().equals("DEUDOR"));
                garantiaMobiAdi.setNroPlaca(objGarantiasMobiAdi.getNroPlaca());
                listadoGarantiasMobiAdic.add(garantiaMobiAdi);
            }
        }
        
        request.setListaGarantiasMobiliariasAdic(listadoGarantiasMobiAdic);
        
        if (parametrosFormatoRDL.getListaGarantiasHipAdic().size() > 0){
            for (FormatoRDLHipotecariaAdicional objGarantiaHipoAdic : parametrosFormatoRDL.getListaGarantiasHipAdic()){
                ReporteFormatoRDLGarantiasHipoAdicDataSource garantiaHipoAdi = new ReporteFormatoRDLGarantiasHipoAdicDataSource();
                garantiaHipoAdi.setOtorgante(objGarantiaHipoAdic.getOtorgante().equals("DEUDOR"));
                garantiaHipoAdi.setDireccion(objGarantiaHipoAdic.getDireccion());
                garantiaHipoAdi.setDistrito(objGarantiaHipoAdic.getDistrito());
                garantiaHipoAdi.setProvincia(objGarantiaHipoAdic.getProvincia());
                garantiaHipoAdi.setDepartamento(objGarantiaHipoAdic.getDepartamento());
                garantiaHipoAdi.setValMontOtorHip(objGarantiaHipoAdic.getValMontOtorHip());
                garantiaHipoAdi.setValRealizGar(objGarantiaHipoAdic.getValRealizGar());
                garantiaHipoAdi.setCodRangoGar(objGarantiaHipoAdic.getCodRangoGar());
                garantiaHipoAdi.setDesTipoActividad(objGarantiaHipoAdic.getDesTipoActividad());
                listadoGarantiasHipoAdic.add(garantiaHipoAdi);
            }       
        }
        
        request.setListaGarantiasHipotecariasAdic(listadoGarantiasHipoAdic);
        
        byte[] excelByte = reporte.generarReporte(request);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
        
    }
    
    //ECUBAS <I>89642
    @Override
    public MotivosAprobacionResponse listarMotivosAprobacion(HeaderParams headerParams, String codSoliCred) throws Exception {
        /*
        ListarMotivosAprobacionProcedure procedureParams = new ListarMotivosAprobacionProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(codSoliCred, procedureParams);
        */
        
        ListarMotivosAprobacionProcedure procedureParams = mapper.map(headerParams, ListarMotivosAprobacionProcedure.class);
        procedureParams.setCodSoliCred(codSoliCred);        
        solicitudAprobacionDAO.listarMotivosAprobacion(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            MotivosAprobacionResponse response = new MotivosAprobacionResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }
    //ECUBAS <F>89642

    @Override
    public ReporteResponse exportarFormatoLeasing(HeaderParams headerParams, String codSoliCred) throws Exception {
        
        ReporteFormatoRDLMutuoDataSource request = new ReporteFormatoRDLMutuoDataSource();
        ReporteFormatoRDLMutuoExcel reporte = new ReporteFormatoRDLMutuoExcel();

        FormatoRDLProcedure parametrosFormatoRDL = mapper.map(headerParams, FormatoRDLProcedure.class);
        parametrosFormatoRDL.setCodSoliCred(codSoliCred);
        solicitudAprobacionDAO.listarFormatoLeasing(parametrosFormatoRDL);
        
        List<ReporteFormatoRDLGarantiasMobiAdicDataSource> listadoGarantiasMobiAdic = new ArrayList<>();
        List<ReporteFormatoRDLGarantiasHipoAdicDataSource> listadoGarantiasHipoAdic = new ArrayList<>();
        List<ReporteFormatoRDLInfoFinanciamiento> listadoInfoFinanciamiento = new ArrayList<>();
        
        if (parametrosFormatoRDL.getBusqueda().size() > 0) {
            FormatoRDLPrincipal datosPrincipales = parametrosFormatoRDL.getBusqueda().get(0);
            request.setTitulo(datosPrincipales.getTitulo());
            request.setIndNuevoUsado(datosPrincipales.getIndNuevoUsado());
            request.setNomEmpresa(datosPrincipales.getNomEmpresa());
            request.setCodClie(datosPrincipales.getCodClie());
            request.setNomPerso(datosPrincipales.getNomPerso());
            request.setNumDocu(datosPrincipales.getNumDocu());
            request.setDirDomicilio(datosPrincipales.getDirDomicilio());
            request.setDistrito(datosPrincipales.getDistrito());
            request.setProvincia(datosPrincipales.getProvincia());
            request.setDepartamento(datosPrincipales.getDepartamento());
            request.setTea(datosPrincipales.getTea());
            request.setPeriGracia(datosPrincipales.getPeriGracia());
            request.setNomRespoFina(datosPrincipales.getNomRespoFina());
            request.setCodClasifSbsClie(datosPrincipales.getCodClasifSbsClie());
            //NUEVOS CAMPOS PARA CHECK LIST
            request.setIndInfo(datosPrincipales.getIndInfo());
            request.setTipoPersona(datosPrincipales.getTipoPersona());
            request.setIndNroOpe(datosPrincipales.getIndNroOpe());
            request.setPeriGracSinInt(datosPrincipales.getPeriGracSinInt());
            request.setDiasPeriGrac(datosPrincipales.getDiasPeriGrac());
            request.setFecFirmaCont(datosPrincipales.getFecFirmaCont());
            request.setFecEntreLeg(datosPrincipales.getFecEntreLeg());
            request.setTipoVeh(datosPrincipales.getTipoVeh());
            request.setInfoDetMutuo(datosPrincipales.getInfoDetMutuo());
            request.setNomBancoMutuo(datosPrincipales.getNomBancoMutuo());
        }
        
        if (parametrosFormatoRDL.getListaAvales().size() > 0) {
            FormatoRDLAval datosAvales = parametrosFormatoRDL.getListaAvales().get(0);
            // SE AGREGO TIPO PERS AVAL
            request.setTipoPersAval(datosAvales.getTipoPersAval());
            //
            request.setNomPersAval(datosAvales.getNomPersAval());
            request.setDoiAval(datosAvales.getDoi());
            request.setDireccionAval(datosAvales.getDireccion());
            request.setDistritoAval(datosAvales.getDistrito());
            request.setProvinciaAval(datosAvales.getProvincia());
            request.setDepartamentoAval(datosAvales.getDepartamento());
            request.setValMontoFianzaAval(datosAvales.getValMontoFianza());
        }
        
        // SE AGREGA DATOS PARA GARANTE
        if (parametrosFormatoRDL.getListaInfoGarantes().size() > 0) {
            FormatoRDLInfoGarantes datosGarantes = parametrosFormatoRDL.getListaInfoGarantes().get(0);
            request.setTipoPersGarante(datosGarantes.getTipoPersGarante());   
            request.setNomPersGarante(datosGarantes.getNomPersGarante());
            request.setDoiGarante(datosGarantes.getDoiGarante());
            request.setDireccionGarante(datosGarantes.getDireccionGarante());
            request.setDistritoGarante(datosGarantes.getDistritoGarante());
            request.setProvinciaGarante(datosGarantes.getProvinciaGarante());
            request.setDepartamentoGarante(datosGarantes.getDepartamentoGarante());
        }
        
        // SE AGREGA UNA LISTA PARA INFORMACION DEL FINANCIAMIENTO
        if(parametrosFormatoRDL.getListaInfoRefinanciamiento().size() > 0) {
            for (FormatoRDLInfoFinanciamiento objInfoRefinan : parametrosFormatoRDL.getListaInformacionFinanciamiento()) {
                ReporteFormatoRDLInfoFinanciamiento infoFinanciamiento = new ReporteFormatoRDLInfoFinanciamiento();
                infoFinanciamiento.setInfoDetaOrigen(objInfoRefinan.getInfoDetaOrigen());
                infoFinanciamiento.setNroFactura(objInfoRefinan.getNroFactura());
                infoFinanciamiento.setFechaFactura(objInfoRefinan.getFechaFactura());
                infoFinanciamiento.setEmpresaBanco(objInfoRefinan.getEmpresaBanco());
                infoFinanciamiento.setMarcaVeh(objInfoRefinan.getMarcaVeh());
                infoFinanciamiento.setAnioVeh(objInfoRefinan.getAnioVeh());
                infoFinanciamiento.setModeloVeh(objInfoRefinan.getModeloVeh());
                infoFinanciamiento.setChasisVeh(objInfoRefinan.getChasisVeh());
                infoFinanciamiento.setMotorVeh(objInfoRefinan.getMotorVeh());
                infoFinanciamiento.setTipoVeh(objInfoRefinan.getTipoVeh());
                infoFinanciamiento.setPlacaVeh(objInfoRefinan.getPlacaVeh());
                listadoInfoFinanciamiento.add(infoFinanciamiento);
            }
        }
        
        request.setListaInformacionFinanciamiento(listadoInfoFinanciamiento);
        
        //----------------------------------------------------------------------
        
        if (parametrosFormatoRDL.getListaGarantiasMobAdic().size() > 0){
            for (FormatoRDLGarantiaMobiliariaAdicional objGarantiasMobiAdi : parametrosFormatoRDL.getListaGarantiasMobAdic()){
                ReporteFormatoRDLGarantiasMobiAdicDataSource garantiaMobiAdi = new ReporteFormatoRDLGarantiasMobiAdicDataSource();
                garantiaMobiAdi.setGarantiaPropia(objGarantiasMobiAdi.getGarantiaPropia().equals("SI"));
                garantiaMobiAdi.setGarantiaAjena(objGarantiasMobiAdi.getGarantiaAjena().equals("SI"));
                garantiaMobiAdi.setIndTipoBien(objGarantiasMobiAdi.getIndTipoBien());
                garantiaMobiAdi.setOtorgante(objGarantiasMobiAdi.getOtorgante().equals("DEUDOR"));
                garantiaMobiAdi.setNroPlaca(objGarantiasMobiAdi.getNroPlaca());
                listadoGarantiasMobiAdic.add(garantiaMobiAdi);
            }
        }
        
        request.setListaGarantiasMobiliariasAdic(listadoGarantiasMobiAdic);
        
        if (parametrosFormatoRDL.getListaGarantiasHipAdic().size() > 0){
            for (FormatoRDLHipotecariaAdicional objGarantiaHipoAdic : parametrosFormatoRDL.getListaGarantiasHipAdic()){
                ReporteFormatoRDLGarantiasHipoAdicDataSource garantiaHipoAdi = new ReporteFormatoRDLGarantiasHipoAdicDataSource();
                garantiaHipoAdi.setOtorgante(objGarantiaHipoAdic.getOtorgante().equals("DEUDOR"));
                garantiaHipoAdi.setDireccion(objGarantiaHipoAdic.getDireccion());
                garantiaHipoAdi.setDistrito(objGarantiaHipoAdic.getDistrito());
                garantiaHipoAdi.setProvincia(objGarantiaHipoAdic.getProvincia());
                garantiaHipoAdi.setDepartamento(objGarantiaHipoAdic.getDepartamento());
                garantiaHipoAdi.setValMontOtorHip(objGarantiaHipoAdic.getValMontOtorHip());
                garantiaHipoAdi.setValRealizGar(objGarantiaHipoAdic.getValRealizGar());
                garantiaHipoAdi.setCodRangoGar(objGarantiaHipoAdic.getCodRangoGar());
                garantiaHipoAdi.setDesTipoActividad(objGarantiaHipoAdic.getDesTipoActividad());
                listadoGarantiasHipoAdic.add(garantiaHipoAdi);
            }       
        }
        
        request.setListaGarantiasHipotecariasAdic(listadoGarantiasHipoAdic);
        
        byte[] excelByte = reporte.generarReporte(request);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
        
    }
    
    // <I> 90690 ivelasquez 21/09/2021
    @Override
    public HistorialAprobacionResponse listarHistorialAprobacion(HeaderParams headerParams, String codSoliCred) throws Exception {
        
        ListarHistorialAprobacionProcedure procedureParams = mapper.map(headerParams, ListarHistorialAprobacionProcedure.class);
        procedureParams.setCodSoliCred(codSoliCred);        
        solicitudAprobacionDAO.listarHistorialAprobacion(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            HistorialAprobacionResponse response = new HistorialAprobacionResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse listarSoliAprob(HeaderParams headerParams, SolicitudAprobacionRequest request) throws Exception {

        RegistrarAprobacionProcedure procedureParams = new RegistrarAprobacionProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudAprobacionDAO.listarSoliAprob(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            DatosAprobacionResponse response = new DatosAprobacionResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getListaAprobacion());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }       

    @Override
    public BaseResponse actualizarAprob(HeaderParams headerParams, ActualizarSolicitudAprobacionRequest request) throws Exception {

        ActualizarSolicitudAprobacionProcedure procedureParams = new ActualizarSolicitudAprobacionProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudAprobacionDAO.actualizarAprob(procedureParams);

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
    // <F> 90690 ivelasquez 21/09/2021
}
