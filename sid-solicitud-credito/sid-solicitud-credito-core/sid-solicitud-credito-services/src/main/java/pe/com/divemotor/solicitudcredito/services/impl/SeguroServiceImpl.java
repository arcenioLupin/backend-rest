/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
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
import pe.com.divemotor.generico.dto.Adjunto;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroListadoResponse;
import pe.com.divemotor.solicitudcredito.dao.SeguroDAO;
import pe.com.divemotor.solicitudcredito.dominio.TramaSeguro;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroDetalleVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarPolizaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.VencimientoSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroTramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PolizaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReportePolizasResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReportePolizasExcel;
import pe.com.divemotor.solicitudcredito.reporte.ReporteSeguroTramaExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReportePolizasExcelDataSource;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteSeguroTramaDataSource;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.solicitudcredito.services.SeguroService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author Mgrasso
 */
@Service
@Transactional
public class SeguroServiceImpl implements SeguroService{

    private SeguroDAO solicitudCreditoSeguroDAO;
    private Mapper mapper;


    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSolicitudCreditoSeguroDAO(SeguroDAO solicitudCreditoSeguroDAO) {
        this.solicitudCreditoSeguroDAO = solicitudCreditoSeguroDAO;
    }
    
    @Resource(name = "mailServices")
    MailServices mailServices;
    
    @Transactional(readOnly = true)
    @Override
    public SeguroListadoResponse listar(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception {
        ListarSeguroProcedure parametros = mapper.map(headerParams, ListarSeguroProcedure.class);
        mapper.map(request, parametros);
        this.solicitudCreditoSeguroDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            SeguroListadoResponse response = new SeguroListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    
    }

    @Override
    public BaseResponse actualizar(HeaderParams headerParams, SeguroRequest request) throws Exception {
        ActualizarSeguroProcedure parametros = new ActualizarSeguroProcedure();
        parametros.setCodSoliCred(request.getCodSoliCred()!=null?request.getCodSoliCred():"");
        parametros.setIndRespAproTseg(request.getIndRespAproTseg()!=null?request.getIndRespAproTseg():"");
        parametros.setTxtObseRechTseg(request.getTxtObseRechTseg()!=null?request.getTxtObseRechTseg():"");
        parametros.setCodUsuaGestSeg(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
        
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        solicitudCreditoSeguroDAO.actualizar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ReporteResponse reporteResponse = new ReporteResponse();
            //I Req. 87567 E2.1 ID## avilca 06/10/2020>
            if(parametros.getIndRespAproTseg().equals("R")){
               this.enviarCorreo(parametros, reporteResponse, "SEG_RECH");  
            }else if(parametros.getIndRespAproTseg().equals("A")){               
              this.enviarCorreo(parametros, reporteResponse, "SEG_APRB");   
            }
            else{
              this.enviarCorreo(parametros, reporteResponse, "SEG_APROB");
            }
             //F Req. 87567 E2.1 ID## avilca 06/10/2020>
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
        
    }

    @Override
    public BaseResponse actualizarPoliza(HeaderParams headerParams, SeguroRequest request) throws Exception {
        ActualizarSeguroProcedure parametros = new ActualizarSeguroProcedure();
        
        parametros.setCodSoliCred(request.getCodSoliCred()!=null?request.getCodSoliCred():"");
        parametros.setNroPoliSeg(request.getNroPoliza()!=null?request.getNroPoliza():"");
        parametros.setFecInicVigePoli(request.getFecInicVigePoli()!=null?request.getFecInicVigePoli():null);
        parametros.setFecFinVigePoli(request.getFecFinVigePoli()!=null?request.getFecFinVigePoli():null);
        parametros.setFecPrimPagoPoliEndo(request.getFecPrimPagoPoliEndo()!=null?request.getFecPrimPagoPoliEndo():null);
        parametros.setFecUltiPagoPoliEndo(request.getFecUltiPagoPoliEndo()!=null?request.getFecUltiPagoPoliEndo():null);
        parametros.setTxtRutaPoliEndo(request.getTxtRutaPoliEndo()!=null?request.getTxtRutaPoliEndo():"");
        parametros.setTxtRutaFactura(request.getTxtRutaFactura() != null?request.getTxtRutaFactura():"");
        parametros.setCodUsuaGestSeg(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
        parametros.setFecActPoli(request.getFecActPoli() != null ? request.getFecActPoli(): "");
        //I Req. 87567 E2.1 ID## avilca 07/10/2020-->
        parametros.setCodCiaSeg(request.getCodCiaSeg() != null ? request.getCodCiaSeg(): "");
        parametros.setValPorcTeaSigv(request.getValPorcTeaSigv() != 0 ? request.getValPorcTeaSigv(): 0);
       //F Req. 87567 E2.1 ID## avilca 07/10/2020-->

        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        solicitudCreditoSeguroDAO.actualizarPoliza(parametros);
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(parametros.getCodigo());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            for (int i = 0; i < request.getListDetalleVehiculo().size(); i++) {
                ActualizarSeguroDetalleVehiculoProcedure parametros2= new ActualizarSeguroDetalleVehiculoProcedure();
                parametros2.setNumPlacaVeh(request.getListDetalleVehiculo().get(i).getNumPlacaVeh()!=null?request.getListDetalleVehiculo().get(i).getNumPlacaVeh():"");
                parametros2.setCodUsuaModReg(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
                parametros2.setCodGarantia(request.getListDetalleVehiculo().get(i).getCodGarantia() != null?request.getListDetalleVehiculo().get(i).getCodGarantia():"");
                mapper.map(headerParams, parametros2);
                mapper.map(request, parametros2);
                solicitudCreditoSeguroDAO.actualizarPlaca(parametros2);
                if (parametros2.getStatus().equals(Constantes.ESTADO_TRAMA_ERROR_PROCEDURE)) {
                    throw new Exception(parametros2.getMensaje());
                }
            } 
            if(request.getTipoAccion().equals("G") && request.getFecActPoli().isEmpty() ){

              ReporteResponse reporteResponse = exportarSeguroTrama(headerParams,request.getCodSoliCred());                
              this.enviarCorreo(parametros,reporteResponse, "SEG_APROB");
            }

            return response;
        }else if(statusQuery.equals(Constantes.ESTADO_TRAMA_PLAZO_VENCIDO)){
            BaseResponse response = new BaseResponse();
            response.setCodigo(parametros.getCodigo());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            return response;
        
        } else {
            throw new Exception(parametros.getMensaje());
        }
        
        
    }

    @Override
    public PolizaListadoResponse listarPoliza(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception {
        ListarPolizaProcedure parametros = mapper.map(headerParams, ListarPolizaProcedure.class);
        mapper.map(request, parametros);
        this.solicitudCreditoSeguroDAO.listarPoliza(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            PolizaListadoResponse response = new PolizaListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public ReportePolizasResponse exportarPolizas(HeaderPaginadoParams headerParams, SeguroRequest request) throws Exception{
        
            ReportePolizasResponse reporteResponse = new ReportePolizasResponse();
            ReportePolizasExcelDataSource reporteRequest = new ReportePolizasExcelDataSource();
            ReportePolizasExcel reporte = new ReportePolizasExcel();
            ListarPolizaProcedure parametros = mapper.map(headerParams, ListarPolizaProcedure.class);
            mapper.map(request, parametros);
            this.solicitudCreditoSeguroDAO.listarPoliza(parametros);
            reporteRequest.setPolizas(parametros.getBusqueda());
            byte[] excelByte = reporte.generarReporte(reporteRequest);

            reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
            reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
            reporteResponse.setReporteBytes(excelByte);
            reporteResponse.setReporte(Base64.encodeBase64String(excelByte));
           

        return reporteResponse;
    }
    
    private GenericoResponse enviarCorreo(ActualizarSeguroProcedure procedureParams, ReporteResponse reporteResponse, String tipoRefProc) throws Exception{
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;
        byte[] facturaBytes = null;
        
        if(procedureParams.getTxtRutaFactura() != null && !procedureParams.getTxtRutaFactura().equals("") ){
           facturaBytes = urlFileToArrayByte(new URL(procedureParams.getTxtRutaFactura()));
        }
        
        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codColaborador", procedureParams.getCodUsuaGestSeg());
        parametrosEmail.put("idUsuario", procedureParams.getIdUsuario());
        parametrosEmail.put("asunto", procedureParams.getMensaje());
        parametrosEmail.put("cuerpo", "Correo de prueba");
        parametrosEmail.put("adjuntos",facturaBytes);
        parametrosEmail.put("adjuntoTrama",reporteResponse.getReporteBytes());
        parametrosEmail.put("observacionRechazo", procedureParams.getTxtObseRechTseg());//I Req. 87567 E2.1 ID## avilca 07/10/2020
        genericoResponse = mailServices.envioCorreos(parametrosEmail, tipoRefProc);
        
        return genericoResponse;
    }

    @Override
    public PolizaListadoResponse notificarVencimientoPolizas(HeaderParams headerParams, SeguroRequest request) throws Exception {
        VencimientoSeguroProcedure parametros = new VencimientoSeguroProcedure();
        parametros.setDiasConsulta(request.getDiasConsulta()!=null?request.getDiasConsulta():"30");
        parametros.setCodUsuario(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
        
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        this.solicitudCreditoSeguroDAO.vencimientoSeguro(parametros);
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            List listDetalle = parametros.getBusqueda();
            for (Object listDetalle1 : listDetalle) {
                ActualizarSeguroProcedure parametroMail = new ActualizarSeguroProcedure();
                parametroMail.setCodSoliCred(request.getCodSoliCred()!=null?request.getCodSoliCred():"");
                parametroMail.setCodUsuaGestSeg(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
                parametroMail.setMensaje("asdasdasd");
                this.enviarCorreo(parametroMail, null, "SEG_VCTO");
            }
            PolizaListadoResponse response = new PolizaListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            //response.setListado(null);
            response.setListado(parametros.getBusqueda());
            return response;
            
            /*
                    ActualizarSeguroProcedure parametros = new ActualizarSeguroProcedure();
        parametros.setCodSoliCred(request.getCodSoliCred()!=null?request.getCodSoliCred():"");
        parametros.setNroPoliSeg(request.getNroPoliza()!=null?request.getNroPoliza():"");
        parametros.setFecInicVigePoli(request.getFecInicVigePoli()!=null?request.getFecInicVigePoli():null);
        parametros.setFecFinVigePoli(request.getFecFinVigePoli()!=null?request.getFecFinVigePoli():null);
        parametros.setFecPrimPagoPoliEndo(request.getFecPrimPagoPoliEndo()!=null?request.getFecPrimPagoPoliEndo():null);
        parametros.setFecUltiPagoPoliEndo(request.getFecUltiPagoPoliEndo()!=null?request.getFecUltiPagoPoliEndo():null);
        parametros.setTxtRutaPoliEndo(request.getTxtRutaPoliEndo()!=null?request.getTxtRutaPoliEndo():"");
        parametros.setCodUsuaGestSeg(request.getCodUsuaGestSeg()!=null?request.getCodUsuaGestSeg():"");
            
            */
            
            
            
           /*PolizaListadoResponse response = new BaseResponse();
            response.setCodigo(parametros.getCodigo());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            //this.enviarCorreo(parametros);
            return response;*/
           
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

 private byte[] urlFileToArrayByte(URL url) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    try {
        byte[] arregloBytes = new byte[4096];
        int bytesRead;
        InputStream stream = url.openStream();

        while ((bytesRead = stream.read(arregloBytes)) > 0) {
            outputStream.write(arregloBytes, 0, bytesRead);
        }

    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    return outputStream.toByteArray();
}   
 

 private ReporteResponse exportarSeguroTrama(HeaderParams headerParams, String codSoliCred) throws Exception {

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
          
}
