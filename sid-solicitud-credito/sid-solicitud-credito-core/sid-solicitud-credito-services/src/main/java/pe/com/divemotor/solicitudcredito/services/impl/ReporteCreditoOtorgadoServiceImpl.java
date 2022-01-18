/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.ReporteCreditoOtorgadoDAO;
import pe.com.divemotor.solicitudcredito.dominio.CreditoOtorgado;
import pe.com.divemotor.solicitudcredito.dominio.ReporteCreditoOtorgado;
import pe.com.divemotor.solicitudcredito.dto.procedure.creditoOtorgado.ListarReporteCreditoOtorgadoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteCreditoOtorgadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteCreditoOtorgadoExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteCreditoOtorgadoExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditoOtorgadoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class ReporteCreditoOtorgadoServiceImpl implements ReporteCreditoOtorgadoService {

    private Mapper mapper;
    private ReporteCreditoOtorgadoDAO reporteCODAO;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setReporteCODAO(ReporteCreditoOtorgadoDAO reporteCODAO) {
        this.reporteCODAO = reporteCODAO;
    }

    @Override
    public ReporteCreditoOtorgadoListadoResponse listarCreditoOtorgado(HeaderParams headerParams, ReporteCreditoOtorgadoRequest request) throws Exception {
        ListarReporteCreditoOtorgadoProcedure parametros = mapper.map(headerParams, ListarReporteCreditoOtorgadoProcedure.class);
        parametros.setCodAreaVenta(request.getCodAreaVenta());
        parametros.setCodRegion(request.getCodRegion());
        parametros.setCodTipoOperacion(request.getCodTipoOperacion());
        parametros.setFechaFactuInicio(request.getFechaFactuInicio());
        parametros.setFechaFactuFin(request.getFechaFactuFin());
        parametros.setOpAprobados(request.getOpAprobados());
        parametros.setCliente(request.getCliente());
        parametros.setRucCliente(request.getRucCliente());
        parametros.setFechaOpeInicio(request.getFechaOpeInicio());
        parametros.setFechaOpeFin(request.getFechaOpeFin());

        reporteCODAO.listarCreditoOtorgado(parametros);

        if (parametros.getStatus() == Constantes.ESTADO_TRAMA_OK) {
            ReporteCreditoOtorgadoListadoResponse response = new ReporteCreditoOtorgadoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }

    }

    @Override
    public ReporteCreditoOtorgadoResponse exportarCreditoOtorgado(HeaderParams headerParams, List<ReporteCreditoOtorgado> lista) throws Exception {

        ReporteCreditoOtorgadoExcelDataSource dataSource = new ReporteCreditoOtorgadoExcelDataSource();
        ReporteCreditoOtorgadoExcel reporte = new ReporteCreditoOtorgadoExcel();
        List<CreditoOtorgado> listaCreditoOtorgado = new ArrayList<>();
        ReporteCreditoOtorgado reporteCO = new ReporteCreditoOtorgado();
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formatea = new DecimalFormat("###,###.##",simbolo);

        for (ReporteCreditoOtorgado rco : lista) {
            CreditoOtorgado creditoOtorgado = new CreditoOtorgado();
            String segmento = rco.getSegmento() == null ? "N/A" : rco.getSegmento();//I Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
            creditoOtorgado.setAreaVenta(rco.getAreaVenta());
            creditoOtorgado.setCodCliente(rco.getCodCliente());
            creditoOtorgado.setCuotaInicial(formatea.format(Double.parseDouble(rco.getCuotaInicial() == null ? "0" : rco.getCuotaInicial())));
            creditoOtorgado.setFecha(rco.getFecha());
            creditoOtorgado.setMontoFinanciado(formatea.format(Double.parseDouble(rco.getMontoFinanciado() == null ? "0" : rco.getMontoFinanciado())));
            creditoOtorgado.setNomCliente(rco.getNomCliente());
            creditoOtorgado.setNroFichaVenta(rco.getNroFichaVenta());
            creditoOtorgado.setNroMeses(rco.getNroMeses());
            creditoOtorgado.setNroUnidades(rco.getNroUnidades());
            creditoOtorgado.setRegion(rco.getRegion());
            creditoOtorgado.setTipoOperacion(rco.getTipoOperacion());
            creditoOtorgado.setTipoPersona(rco.getTipoPersona());
            creditoOtorgado.setTotalVenta(formatea.format(Double.parseDouble(rco.getTotalVenta() == null ? "0" : rco.getTotalVenta() )));
            //I Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
            creditoOtorgado.setSegmento(segmento);
            creditoOtorgado.setSucursal(rco.getSucursal());
            creditoOtorgado.setOpCronograma(rco.getOpCronograma());
            creditoOtorgado.setCuotaInicialPorcentaje(rco.getCuotaInicialPorcentaje());
            creditoOtorgado.setVencimientoUltimaLetra(rco.getVencimientoUltimaLetra());
            creditoOtorgado.setVencimientoPrimeraLetra(rco.getVencimientoPrimeraLetra());
            creditoOtorgado.setTeaSinIgv(rco.getTeaSinIgv());
            creditoOtorgado.setGarantiasAdicionales(formatea.format(Double.parseDouble(rco.getGarantiasAdicionales() == null ? "0" : rco.getGarantiasAdicionales() )));
            creditoOtorgado.setRatioCobertura(rco.getRatioCobertura());
            creditoOtorgado.setGastosAdministrativos(rco.getGastosAdministrativos());
            creditoOtorgado.setSeguroDivemotor(rco.getSeguroDivemotor());
            creditoOtorgado.setNroSolicitud(rco.getNroSolicitud());
            creditoOtorgado.setEstadoSolicitud(rco.getEstadoSolicitud());
            creditoOtorgado.setEstadoOp(rco.getEstadoOp());
            //F Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
            //I Req. 87567 E2.1 ID:12 avilca 16/09/2020
            creditoOtorgado.setFechaOp(rco.getFechaOp());
            creditoOtorgado.setFechaAprobOp(rco.getFechaAprobOp());
            //F Req. 87567 E2.1 ID:12 avilca 16/09/2020
            creditoOtorgado.setUsuarioReg(rco.getUsuarioReg() == null?"":rco.getUsuarioReg());
            creditoOtorgado.setFechaReg(rco.getFechaReg() == null?"":rco.getFechaReg());
            creditoOtorgado.setUsuarioEval(rco.getUsuarioEval() == null?"":rco.getUsuarioEval());
            creditoOtorgado.setFechaEval(rco.getFechaEval() == null?"":rco.getFechaEval());
            creditoOtorgado.setUsuarioVig(rco.getUsuarioVig() == null?"":rco.getUsuarioVig());
            creditoOtorgado.setFechaVig(rco.getFechaVig() == null?"":rco.getFechaVig());
            creditoOtorgado.setUsuarioAprob(rco.getUsuarioAprob() == null?"":rco.getUsuarioAprob());
            creditoOtorgado.setFechaAprob(rco.getFechaAprob() == null?"":rco.getFechaAprob());
            creditoOtorgado.setNumRuc(rco.getNumRuc() == null ? "":rco.getNumRuc());
            creditoOtorgado.setDesFamiliaVeh(rco.getDesFamiliaVeh() == null?"": rco.getDesFamiliaVeh());
            creditoOtorgado.setDesTipoVeh(rco.getDesTipoVeh() == null?"": rco.getDesTipoVeh());
            creditoOtorgado.setNomMarca(rco.getNomMarca() == null?"": rco.getNomMarca());
            creditoOtorgado.setSumaValorRealiz(rco.getSumaValorRealiz() == null?"":formatea.format(Double.parseDouble(rco.getSumaValorRealiz() == null ? "0" : rco.getSumaValorRealiz())));
            creditoOtorgado.setUsuarioAprobNivel1(rco.getUsuarioAprobNivel1() == null? "":rco.getUsuarioAprobNivel1());
            creditoOtorgado.setFechaAprobNivel1(rco.getFechaAprobNivel1() == null?"": rco.getFechaAprobNivel1());
            creditoOtorgado.setUsuarioAprobNivel2(rco.getUsuarioAprobNivel2() == null? "":rco.getUsuarioAprobNivel2());
            creditoOtorgado.setFechaAprobNivel2(rco.getFechaAprobNivel2() == null?"": rco.getFechaAprobNivel2());  
            creditoOtorgado.setUsuarioAprobNivel3(rco.getUsuarioAprobNivel3() == null? "":rco.getUsuarioAprobNivel3());
            creditoOtorgado.setFechaAprobNivel3(rco.getFechaAprobNivel3() == null?"": rco.getFechaAprobNivel3());            
            creditoOtorgado.setUsuarioAprobNivel4(rco.getUsuarioAprobNivel4() == null? "":rco.getUsuarioAprobNivel4());
            creditoOtorgado.setFechaAprobNivel4(rco.getFechaAprobNivel4() == null?"": rco.getFechaAprobNivel4());            
            creditoOtorgado.setUsuarioAprobNivel5(rco.getUsuarioAprobNivel5() == null? "":rco.getUsuarioAprobNivel5());
            creditoOtorgado.setFechaAprobNivel5(rco.getFechaAprobNivel5() == null?"": rco.getFechaAprobNivel5());            
            creditoOtorgado.setUsuarioAprobNivel6(rco.getUsuarioAprobNivel6() == null? "":rco.getUsuarioAprobNivel6());
            creditoOtorgado.setFechaAprobNivel6(rco.getFechaAprobNivel6() == null?"": rco.getFechaAprobNivel6());  
            creditoOtorgado.setNivelesAprob(rco.getNivelesAprob() == null?"": rco.getNivelesAprob());
            creditoOtorgado.setValGastAdm(rco.getValGastAdm() == null? "":formatea.format(Double.parseDouble(rco.getValGastAdm() == null ? "0" : rco.getValGastAdm())));
            listaCreditoOtorgado.add(creditoOtorgado);
        }
        reporteCO.setListaCreditosOtorgados(listaCreditoOtorgado);

        byte[] excelByte = reporte.generarReporte(dataSource, reporteCO);

        ReporteCreditoOtorgadoResponse reporteCOResponse = new ReporteCreditoOtorgadoResponse();
        reporteCOResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteCOResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteCOResponse.setReporteBytes(excelByte);
        reporteCOResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteCOResponse;
    }

}
