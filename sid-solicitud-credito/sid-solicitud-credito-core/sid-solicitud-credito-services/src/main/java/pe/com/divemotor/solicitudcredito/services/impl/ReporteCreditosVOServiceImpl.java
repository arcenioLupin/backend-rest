/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.ReporteVistaOperacionDAO;
import pe.com.divemotor.solicitudcredito.dominio.ReporteVistaOperacion;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion.ListarReporteVistaOperacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.VistaOperacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.movimientos.WSInfoDetalleMovClieResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteVistaOperacionExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteVistaOperacionExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosVOService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class ReporteCreditosVOServiceImpl implements ReporteCreditosVOService {

    private Mapper mapper;
    private ReporteVistaOperacionDAO reporteVODao;

    @Autowired
    private MessageSource messageSource;          
    
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setReporteVODao(ReporteVistaOperacionDAO reporteVODao) {
        this.reporteVODao = reporteVODao;
    }

    @Transactional(readOnly = true)
    @Override
    public ReporteVistaOperacionListadoResponse listar(HeaderParams headerParams, String codOperacion) throws Exception {

        ListarReporteVistaOperacionProcedure parametros = mapper.map(headerParams, ListarReporteVistaOperacionProcedure.class);
        parametros.setCodOperacion(codOperacion);
        this.reporteVODao.listar(parametros);

        Double saldoTotal = 0.00;
        Double saldoCapital = 0.00;
        Double ratioCobertura = 0.00;
        Double deudaVencTotalLetras = 0.00;
        Integer contLetrasVencidas = 0;
        String statusOperacion = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ReporteVistaOperacionListadoResponse response = new ReporteVistaOperacionListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setCantidad(parametros.getCantidad());

            Date hoy = new Date();

            //Lista que contiene la informacion de la operacion (listaRVO.size = 1)
            for (ReporteVistaOperacion rvo : parametros.getBusqueda()) {
                String nroOperacion = rvo.getCodOperRel();
                String nroCompañia = "";
                Integer totalLagDays = 0;
                if (rvo.getCodEmpresa().equals(Constantes.COD_SOCIEDAD_CIA_DIVEIMPORT)) {
                    nroCompañia = Constantes.COD_SOCIEDAD_DIVEIMPORT_SAP;
                } else if (rvo.getCodEmpresa().equals(Constantes.COD_SOCIEDAD_CIA_DIVECENTER)) {
                    nroCompañia = Constantes.COD_SOCIEDAD_DIVECENTER_SAP;
                }

                if (rvo.getCodClieSap() != null) {
                    RestTemplate restTemplate = new RestTemplate();
                    WSInfoDetalleMovClieResponse jsonResponse = new WSInfoDetalleMovClieResponse();

                    // HEADERS PARA LLAMAR AL SERVICIO MOVIMIENTOS X CLIENTE
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("codUsuario", (String) headerParams.getCodUsuario());
                    headers.add("token", (String) headerParams.getToken());
                    headers.add("idUsuario", String.valueOf(headerParams.getIdUsuario()));
                    HttpEntity entity = new HttpEntity<>(headers);

                    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SAP_MOVIMIENTOS_CLI, null, null))
                            .queryParam("codClie", rvo.getCodClieSap());

                    jsonResponse = restTemplate.exchange(
                            builder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            WSInfoDetalleMovClieResponse.class
                    ).getBody();

                    //Recorrer Movimientos por ClienteSAP, para obtener totales saldos por c/operacion
                    for (WSInfoDetalleMovClieResponse.Items.Item it : jsonResponse.getItems().getItem()) {
                        //Obtener fechas para calculo de saldosCapitales
                        Date fecVenc = null;
                        Date fecComp = null;
                        int lagDaysFecVenci = 0;
                        int lagDaysFecComp = 0;
                        if (StringUtils.isNotEmpty(it.getFecBase())) {
                            fecVenc = sdf.parse(it.getFecBase());
                        }
                        if (StringUtils.isNotEmpty(it.getFecComp())) {
                            fecComp = sdf.parse(it.getFecComp());
                        }

                        if (it.getClaseDoc().equals("LT") || it.getClaseDoc().equals("MT")) {                          
                            if (StringUtils.isEmpty(it.getCodPago())) {
                                if(StringUtils.isEmpty(it.getNumDocComp())){ 
                                  if (it.getCodRef1().equals(nroOperacion) && it.getCodSociedad().equals(nroCompañia)) {
                                    //Acumulador SaldosTotales
                                    //<Req. 87567 E2.1 ID## jquintanilla 26/02/2020>
                                    if(it.getCodICME().equals("D") ||it.getCodICME().equals("L")){
                                   
                                    if (it.getImpMonDoc().contains("-")) {
                                        it.setImpMonDoc(it.getImpMonDoc().replaceAll("-",""));
                                    }
                                    saldoTotal = saldoTotal + Double.parseDouble(it.getImpMonDoc());
                                    
                                    if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                        saldoCapital = saldoCapital + Double.parseDouble(it.getImpMonDoc());
                                        
                                        if (fecVenc != null) {
                                            lagDaysFecVenci = (int) ((fecVenc.getTime() - hoy.getTime()) / 86400000);
                                            if (lagDaysFecVenci <= 0) {
                                                contLetrasVencidas++;
                                                deudaVencTotalLetras = deudaVencTotalLetras + Double.parseDouble(it.getImpMonDoc());
                                            }
                                        }

                                    } else if (StringUtils.isNotEmpty(it.getNumDocComp()) && StringUtils.isNotEmpty(it.getFecComp())) {
                                        if (fecComp != null && fecVenc != null) {
                                            lagDaysFecComp = (int) ((fecComp.getTime() - fecVenc.getTime()) / 86400000);
                                            if (lagDaysFecComp > 0) {
                                                contLetrasVencidas++;
                                                deudaVencTotalLetras = deudaVencTotalLetras + Double.parseDouble(it.getImpMonDoc());
                                            }
                                        }
                                    }
                                  }
                                }
                            }
                          }
                        }
                        totalLagDays += (Math.abs(lagDaysFecVenci) + Math.abs(lagDaysFecComp));
                    }//end Bucle Movimientos
                }    

                if (saldoTotal == 0) {
                    statusOperacion = Constantes.STATUS_CERRADO;
                }
                if (saldoTotal > 0) {
                    statusOperacion = Constantes.STATUS_VIGENTE;
                }
                if (saldoCapital > 0) {
                    ratioCobertura = round((rvo.getValorRealizGarantias() / saldoCapital), 2);
                }

                rvo.setSaldoTotalPagar(round(saldoTotal, 2));
                rvo.setSaldoCapitalPagar(round(saldoCapital, 2));
                rvo.setNroLetrasVencidas(String.valueOf(contLetrasVencidas));
                rvo.setDiasAtrazo(String.valueOf(totalLagDays));
                rvo.setMontoDeudaVencida(round(deudaVencTotalLetras, 2));
                rvo.setEstadoOperacion(statusOperacion);
                rvo.setRatioCobertGarantias(ratioCobertura);

            }//end bucle response

            response.setListado(parametros.getBusqueda());

            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }

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

    @Override
    public ReporteVistaOperacionResponse exportarVistaOperacion(HeaderParams headerParams, VistaOperacionRequest request) throws Exception {
        ReporteVistaOperacionExcelDataSource response = new ReporteVistaOperacionExcelDataSource();
        ReporteVistaOperacionExcel reporte = new ReporteVistaOperacionExcel();
        ReporteVistaOperacion reporteVO = mapper.map(request, ReporteVistaOperacion.class);

        byte[] excelByte = reporte.generarReporte(response, reporteVO);

        ReporteVistaOperacionResponse reporteVOResponse = new ReporteVistaOperacionResponse();
        reporteVOResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteVOResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteVOResponse.setReporteBytes(excelByte);
        reporteVOResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteVOResponse;
    }

}
