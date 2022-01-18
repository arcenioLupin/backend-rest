/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.ReporteVistaClienteDAO;
import pe.com.divemotor.solicitudcredito.dominio.GarantiasCredito;
import pe.com.divemotor.solicitudcredito.dominio.OperacionesCredito;
import pe.com.divemotor.solicitudcredito.dominio.ReporteVistaCliente;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.AmortizacionPorLetrtaOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.ListarReporteVistaClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.VistaClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.movimientos.WSInfoDetalleMovClieResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteVistaClienteExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteVistaClienteExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosVCService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class ReporteCreditosVCServiceImpl implements ReporteCreditosVCService {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private Mapper mapper;
    private ReporteVistaClienteDAO reporteVCDao;
    public static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    @Autowired
    private MessageSource messageSource;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setReporteVCDao(ReporteVistaClienteDAO reporteVCDao) {
        this.reporteVCDao = reporteVCDao;
    }

    @Override
    public ReporteVistaClienteListadoResponse listarCodigosOperacion(HeaderParams headerParams,
            VistaClienteRequest request) throws Exception {
        ListarReporteVistaClienteProcedure parametros = mapper.map(headerParams, ListarReporteVistaClienteProcedure.class);
        ListarReporteVistaClienteProcedure parametros2 = mapper.map(headerParams, ListarReporteVistaClienteProcedure.class);
        ListarReporteVistaClienteProcedure parametros3 = mapper.map(headerParams, ListarReporteVistaClienteProcedure.class);
        AmortizacionPorLetrtaOperacionesProcedure parametros4 = mapper.map(headerParams, AmortizacionPorLetrtaOperacionesProcedure.class);
        List<ReporteVistaCliente> listaRVC = new ArrayList<>();
        ReporteVistaCliente rvc = new ReporteVistaCliente();
        Double totalOperSaldoOriginal = 0.00;
        Double totalOperSaldoCapital = 0.00;
        Double totalValorComercial = 0.00;

        String codCliente = request.getCodCliente();
        String nombreCliente = request.getNombreCliente();
        String tipoDocumento = request.getTipoDocumento();
        String nroDocumento = request.getNroDocumento();
        String asesorComercial = "";
        String region = "";

        String nroCompañia = "";

        parametros.setCodCliente(codCliente);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        List<OperacionesCredito> listaOperaciones = new ArrayList<>();
        List<GarantiasCredito> listaGarantias = new ArrayList<>();

        ReporteVistaClienteListadoResponse response = new ReporteVistaClienteListadoResponse();
        RestTemplate restTemplate = new RestTemplate();
        WSInfoDetalleMovClieResponse jsonMovResponse = new WSInfoDetalleMovClieResponse();

        try {
            double totalGarantias =0.0;
            // HEADERS PARA LLAMAR AL SERVICIO MOVIMIENTOS X CLIENTE
            HttpHeaders headers = new HttpHeaders();
            headers.add("codUsuario", headerParams.getCodUsuario());
            headers.add("token", headerParams.getToken());
            headers.add("idUsuario", String.valueOf(headerParams.getIdUsuario()));
            HttpEntity entity = new HttpEntity<>(headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SAP_MOVIMIENTOS_CLI, null, null))
                    .queryParam("codClie", request.getCodClieSap());
            System.out.println(builder.toUriString());
            jsonMovResponse = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    WSInfoDetalleMovClieResponse.class).getBody();
            
            reporteVCDao.listarCodigosOperacion(parametros);
            
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());

                //codigos de operacion x cliente
                for (ReporteVistaCliente repoVC : parametros.getBusqueda()) {
                    String nroOperacion = repoVC.getNroOperacion();
                    if (!StringUtils.isEmpty(nroOperacion)) {
                         parametros3.setCodCliente(codCliente);
                        parametros3.setCodOperacion(nroOperacion);
                        reporteVCDao.listarGarantias(parametros3);

                        //Lista Garantias x Cliente
                        if (parametros3.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                            if (parametros3.getBusqueda() != null && parametros3.getBusqueda().size() > 0) {
                                for (ReporteVistaCliente repovcGara : parametros3.getBusqueda()) {
                                    GarantiasCredito garaCredito = new GarantiasCredito();
                                    garaCredito.setNroOperacion(repovcGara.getNroOperacion());
                                    garaCredito.setNroGarantia(repovcGara.getNroGarantia());
                                    garaCredito.setDesTipoGara(repovcGara.getTipoGarantia());
                                    garaCredito.setNroPoliza(repovcGara.getNroPoliza());
                                    garaCredito.setCodEstaPoliza(repovcGara.getCodEstaPoliza());
                                    garaCredito.setEstadoPoliza(repovcGara.getEstadoPoliza());
                                    garaCredito.setDivisaOrigen(repovcGara.getDivisaOrigen());
                                    garaCredito.setValorComercial(round(repovcGara.getValorComercial()!=null?repovcGara.getValorComercial():0, 2));
                                    garaCredito.setValorRealizacion(round(repovcGara.getValorRealizacion()!=null?repovcGara.getValorRealizacion():0, 2));
                                    totalGarantias = totalGarantias+round(repovcGara.getValorRealizacion()!=null?repovcGara.getValorRealizacion():0, 2);
                                    garaCredito.setFechaConstitucion(repovcGara.getFechaConstitucion());

                                    totalValorComercial = totalValorComercial + round(repovcGara.getValorComercial()!=null?repovcGara.getValorComercial():0, 2);

                                    listaGarantias.add(garaCredito);
                                }
                            }
                        }
                        
                        
                        parametros2.setCodCliente(codCliente);
                        parametros2.setCodOperacion(nroOperacion);
                        reporteVCDao.listarOperaciones(parametros2);

                        //Lista Operaciones x Cliente
                        if (parametros2.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                            if (parametros2.getBusqueda() != null && parametros2.getBusqueda().size() > 0) {
                                for (ReporteVistaCliente repoVC2 : parametros2.getBusqueda()) {
                                    String codMonDoc = ""; //divisaOrigen(tipoMoneda)

                                    // AsesorCoemrcial & Region
                                    asesorComercial = repoVC2.getAsesorComercial();
                                    region = repoVC2.getRegion();
                                    
                                    //codigos cia equivalencias
                                    if (!StringUtils.isEmpty(repoVC2.getNroCia()) && repoVC2.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVEIMPORT)) {//06
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVEIMPORT_SAP; //3000
                                    } else if (!StringUtils.isEmpty(repoVC2.getNroCia()) && repoVC2.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVECENTER)) {//09
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVECENTER_SAP; //3100
                                    }
                                    OperacionesCredito operCredito = new OperacionesCredito();
                                    operCredito.setNroOperacion(repoVC2.getNroOperacion());
                                    operCredito.setTipoOperacion(repoVC2.getTipoOperacion());
                                    operCredito.setFechaOtorgamiento(repoVC2.getFechaOtorgamiento());
                                    operCredito.setFechaVencimientoUL(repoVC2.getFechaVencimientoUL());
                                    operCredito.setPlazoDias(repoVC2.getPlazoDias());
                                    operCredito.setTea(StringUtils.isEmpty(repoVC2.getTea()) ? 0.00 : Double.parseDouble(repoVC2.getTea().replace(",", ".")));
                                    operCredito.setValMonFin(round(repoVC2.getValMonFin()!=null?repoVC2.getValMonFin():0.00,2));
                                    //Recorrer Movimientos por ClienteSAP, para obtener totales saldos por c/operacion
                                    if (jsonMovResponse != null && jsonMovResponse.getItems() != null) {

                                        for (WSInfoDetalleMovClieResponse.Items.Item it : jsonMovResponse.getItems().getItem()) {
                                            if (it.getClaseDoc().equals("LT") || it.getClaseDoc().equals("MT")) {
                                                if (StringUtils.isEmpty(it.getCodPago())) {
                                                    if (it.getCodRef1().equals(nroOperacion) && it.getCodSociedad().equals(nroCompañia)) {
                                                        //Acumulador SaldosTotales
                                                            parametros4.setCodSociedad(it.getCodSociedad());
                                                            parametros4.setCodRef1(it.getCodRef1());
                                                            parametros4.setNumRefer(it.getNumRefer());
                                                            reporteVCDao.amortizacionesPorLetraOperacion(parametros4);
                                                            if(parametros4.getBusqueda().get(0).getAmortizacion() != null){
                                                               totalOperSaldoOriginal = totalOperSaldoOriginal + round(parametros4.getBusqueda().get(0).getAmortizacion(),2);
                                                            }
                                                        //<Req. 87567 E2.1 ID## jquintanilla 27/02/2020>

                                                        if (!it.getImpMonDoc().contains("-")) {
                                                            //totalOperSaldoOriginal = totalOperSaldoOriginal + Double.parseDouble(it.getImpMonDoc());
                                                            if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                                                totalOperSaldoCapital = totalOperSaldoCapital + Double.parseDouble(it.getImpMonDoc());
                                                            }
                                                        }else{
                                                            it.setImpMonDoc(it.getImpMonDoc().replaceAll("-",""));
                                                         //totalOperSaldoOriginal = totalOperSaldoOriginal + Double.parseDouble(it.getImpMonDoc());
                                                            if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                                                totalOperSaldoCapital = totalOperSaldoCapital + Double.parseDouble(it.getImpMonDoc());
                                                            }

                                                        }

                                                        codMonDoc = it.getCodMonDoc();
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    operCredito.setDivisa(codMonDoc);
                                    //operCredito.setSaldoOriginal(round(totalOperSaldoOriginal, 2));
                                    //operCredito.setSaldoOriginal(repoVC2.getSaldoOriginal());
                                    //operCredito.setSaldoVigente(round(totalOperSaldoCapital, 2));
                                    operCredito.setSaldoOriginal(round(totalOperSaldoCapital, 2));
                                    operCredito.setSaldoVigente(round(totalOperSaldoOriginal, 2));
                                    operCredito.setStatus(totalOperSaldoOriginal > 0 ? Constantes.STATUS_VIGENTE : Constantes.STATUS_CERRADO);


                                    //<Req. 87567 E2.1 ID## jquintanilla 27/02/2020>
                                    operCredito.setRatioCoberturaGara(repoVC2.getRatioCoberturaGara());

                                    //operCredito.setRatioCoberturaGara(round(totalGarantias/totalOperSaldoCapital, 2));

                                    listaOperaciones.add(operCredito);
                                }
                            }
                        }

                    }
                }

                rvc.setCodCliente(codCliente);
                rvc.setNomCliente(nombreCliente);
                rvc.setTipoDocumento(tipoDocumento);
                rvc.setNroDocumento(nroDocumento);
                rvc.setAsesorComercial(asesorComercial);
                rvc.setRegion(region);
                rvc.setFechaReporte(sdf1.format(new Date()));
                rvc.setFechaReporteGen(sdf2.format(new Date()));
                rvc.setListaOperaciones(listaOperaciones);
                rvc.setListaGarantias(listaGarantias);
                rvc.setTotalSaldoVigenteOPER(round(totalOperSaldoOriginal, 2));
                rvc.setTotalValorComercialGARA(round(totalValorComercial, 2));
                listaRVC.add(rvc);

                response.setListado(listaRVC);

                //return response;
            } else {
                throw new Exception(parametros.getMensaje());

            }

        } catch (Exception ex) {
            response = new ReporteVistaClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @Override
    public ReporteVistaClienteResponse exportarVistaCliente(HeaderParams headerParams,
            ReporteVistaCliente reporteVC) throws Exception {
        ReporteVistaClienteExcelDataSource response = new ReporteVistaClienteExcelDataSource();
        ReporteVistaClienteExcel reporte = new ReporteVistaClienteExcel();

        byte[] excelByte = reporte.generarReporte(response, reporteVC);

        ReporteVistaClienteResponse reporteVCResponse = new ReporteVistaClienteResponse();
        reporteVCResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteVCResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteVCResponse.setReporteBytes(excelByte);
        reporteVCResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteVCResponse;

    }

    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
