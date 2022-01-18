/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.OperacionLxCDAO;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCDatosGenerales;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCTotales;
import pe.com.divemotor.solicitudcredito.dto.procedure.EnviarDatosCorreoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDocumentosRelacionadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarRepresentanteLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarReprogramacionOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposDocumentosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarCronogramaLetrasLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarOperacionLxCRegistradaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.RegistrarOperacionLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ListaCronogramaLetrasLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaDocumentosRelacionadosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaGastosLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaOperacionLxCRegistradaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaRepresentanteLegalRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaReprogramacionOperacionesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaTiposDocumentosLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.request.OperacionLxCRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CronogramaLetrasLxCResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentosRelacionadosListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GastosLxCListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLxCRegistradaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RepresentanteLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReprogramacionOperacionesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TiposDocumentosLxCListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TiposGastosLxCListadoResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteCronogramaLetrasLxCPdf;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteCronogramaLetrasLxCPdfDataSource;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.solicitudcredito.services.OperacionLxCService;
import pe.com.divemotor.solicitudcredito.services.SolicitudAprobacionService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author mbardales
 */
@Service
@Transactional
public class OperacionLxCServiceImpl implements OperacionLxCService {

    private OperacionLxCDAO operacionLxCDAO;
    private Mapper mapper;

    @Autowired
    public void setOperacionLxCDAO(OperacionLxCDAO operacionLxCDAO) {
        this.operacionLxCDAO = operacionLxCDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    
   @Resource(name = "mailServices")
    MailServices mailServices;    
   
    private SolicitudAprobacionService solicitudAprobacionService; 

    @Autowired
    public void setSolicitudAprobacionService(SolicitudAprobacionService solicitudAprobacionService) {
        this.solicitudAprobacionService = solicitudAprobacionService;
    }

    @Override
    public DocumentosRelacionadosListadoResponse listar(HeaderPaginadoParams headerParams, ListaDocumentosRelacionadosRequest request) throws Exception {

        ListarDocumentosRelacionadosProcedure procedureParams = new ListarDocumentosRelacionadosProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            DocumentosRelacionadosListadoResponse response = new DocumentosRelacionadosListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setListadoTotalesDocuRela(procedureParams.getListadoTotalesDocuRela());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public TiposDocumentosLxCListadoResponse listarTiposDocumentos(HeaderPaginadoParams headerParams, ListaTiposDocumentosLxCRequest request) throws Exception {
        ListarTiposDocumentosLxCProcedure procedureParams = new ListarTiposDocumentosLxCProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarTiposDocumentos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            TiposDocumentosLxCListadoResponse response = new TiposDocumentosLxCListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public TiposGastosLxCListadoResponse listarTiposGastos(HeaderPaginadoParams headerParams, ListaTiposDocumentosLxCRequest request) throws Exception {
        ListarTiposGastosLxCProcedure procedureParams = new ListarTiposGastosLxCProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarTiposGastos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            TiposGastosLxCListadoResponse response = new TiposGastosLxCListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public GastosLxCListadoResponse listarGastos(HeaderPaginadoParams headerParams, ListaGastosLxCRequest request) throws Exception {
        ListarGastosLxCProcedure procedureParams = new ListarGastosLxCProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarGastos(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            GastosLxCListadoResponse response = new GastosLxCListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setListaGastosLxCTotales(procedureParams.getListaGastosLxCTotales());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public RepresentanteLegalListadoResponse listarRepresentanteLegal(HeaderPaginadoParams headerParams, ListaRepresentanteLegalRequest request) throws Exception {
        ListarRepresentanteLegalProcedure procedureParams = new ListarRepresentanteLegalProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarRepresentanteLegal(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            RepresentanteLegalListadoResponse response = new RepresentanteLegalListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public ReprogramacionOperacionesListadoResponse listarReprogramacionOperaciones(HeaderPaginadoParams headerParams, ListaReprogramacionOperacionesRequest request) throws Exception {
        
        ListarReprogramacionOperacionesProcedure procedureParams = new ListarReprogramacionOperacionesProcedure();
        Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
        procedureParams.setLiminf(limites.get("liminf"));
        procedureParams.setLimsup(limites.get("limsup"));
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarReprogramacionOperaciones(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            ReprogramacionOperacionesListadoResponse response = new ReprogramacionOperacionesListadoResponse();
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

    @Override
    public DocumentosRelacionadosListadoResponse registrarOperacionLxC(HeaderParams headerParams, OperacionLxCRequest request) throws Exception {
        RegistrarOperacionLxCProcedure procedureParams = new RegistrarOperacionLxCProcedure();        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.registrarOperacionLxC(procedureParams);

        Integer statusQuery = procedureParams.getStatus() == null? 0:procedureParams.getStatus();
        if (statusQuery == Constantes.ESTADO_TRAMA_OK) {
            DocumentosRelacionadosListadoResponse response = new DocumentosRelacionadosListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            
            //Enviar reporte de acuerdo al tipo de solcitud de crédito
             EnviarDatosCorreoProcedure procedureParamsCorreo = new EnviarDatosCorreoProcedure();
              mapper.map(headerParams, procedureParamsCorreo);
              mapper.map(request, procedureParamsCorreo);
            if(request.getCodTipoCred().equals(Constantes.TIPO_CRED_RDEUD)){
                
                ReporteResponse reporteResponse;
                reporteResponse = solicitudAprobacionService.exportarFormatoRDL(headerParams, request.getCodSoliCred());
                this.enviarCorreo(headerParams, reporteResponse, procedureParamsCorreo);
                response.setEstadoTrama(String.valueOf(1));
                response.setMensaje("Se envío el mensaje correctamente"); 
                
            }
            
            if(request.getCodTipoCred().equals(Constantes.TIPO_CRED_RDMUT)){
                
                ReporteResponse reporteResponse;
                reporteResponse = solicitudAprobacionService.exportarFormatoRDLMutuo(headerParams, request.getCodSoliCred());
                this.enviarCorreo(headerParams, reporteResponse, procedureParamsCorreo);
                response.setEstadoTrama(String.valueOf(1));
                response.setMensaje("Se envío el mensaje correctamente"); 
                
            }
            
            if(request.getCodTipoCred().equals(Constantes.TIPO_CRED_RDLEA)){
                
                ReporteResponse reporteResponse;
                reporteResponse = solicitudAprobacionService.exportarFormatoLeasing(headerParams, request.getCodSoliCred());
                this.enviarCorreo(headerParams, reporteResponse, procedureParamsCorreo);
                response.setEstadoTrama(String.valueOf(1));
                response.setMensaje("Se envío el mensaje correctamente");                
            }        

            

            return response;
        } 
         // --E2-1-87567-avilca-07/01/2020- Modficación Avales-Ini
         else if (statusQuery == Constantes.ESTADO_TRAMA_OPERACION_EXISTE){
           DocumentosRelacionadosListadoResponse response = new DocumentosRelacionadosListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
         }
        // --E2-1-87567-avilca-07/01/2020- Modficación Avales-Fin
        else {
            throw new Exception(procedureParams.getMensaje());
        }
        
    }

    @Override
    public OperacionLxCRegistradaListadoResponse listarOperacionLxCRegistrado(HeaderParams headerParams, ListaOperacionLxCRegistradaRequest request) throws Exception {
        ListarOperacionLxCRegistradaProcedure procedureParams = new ListarOperacionLxCRegistradaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarOperacionLxCRegistrado(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            OperacionLxCRegistradaListadoResponse response = new OperacionLxCRegistradaListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setListadoTotalesDocuRela(procedureParams.getListadoTotalesDocuRela());
            response.setGastos(procedureParams.getGastos());
            response.setListaGastosLxCTotales(procedureParams.getListaGastosLxCTotales());
            response.setAvales(procedureParams.getAvales());
            response.setListaOperacionLxCRegistrado(procedureParams.getListaOperacionLxCRegistrado());
            response.setTipoCreditoLxc(procedureParams.getTipoCreditoLxc());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public CronogramaLetrasLxCResponse listarCronogramaLetrasLxC(HeaderParams headerParams, ListaCronogramaLetrasLxCRequest request) throws Exception {
        
        ListarCronogramaLetrasLxCProcedure procedureParams = new ListarCronogramaLetrasLxCProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        operacionLxCDAO.listarCronogramaLetrasLxC(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            CronogramaLetrasLxCResponse response = new CronogramaLetrasLxCResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCronogramaTotales(procedureParams.getCronogramaTotales());
            response.setDatosGenerales(procedureParams.getDatosGenerales());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    
    }

    @Override
    public ReporteResponse exportarCronogramaLetrasLxC(HeaderParams headerParams, String codSoliCred) throws Exception {
        
        ReporteCronogramaLetrasLxCPdfDataSource response = new ReporteCronogramaLetrasLxCPdfDataSource();
        ReporteCronogramaLetrasLxCPdf reporte = new ReporteCronogramaLetrasLxCPdf();
        
        ListarCronogramaLetrasLxCProcedure parametrosCronograma = mapper.map(headerParams, ListarCronogramaLetrasLxCProcedure.class);
        parametrosCronograma.setCodSoliCred(codSoliCred);
        operacionLxCDAO.listarCronogramaLetrasLxC(parametrosCronograma);
        //<I Req. 87567 E2.1 ID 205 avilca 13/08/2020>
        response.setUsuario(parametrosCronograma.getCodUsuario());
        //<F Req. 87567 E2.1 ID 205 avilca 13/08/2020>
        if (parametrosCronograma.getBusqueda().size() > 0) {
            response.setCronogramaLetras(parametrosCronograma.getBusqueda());
        }
        
        if (parametrosCronograma.getCronogramaTotales().size() > 0) {
            CronogramaLetrasLxCTotales cronograma = parametrosCronograma.getCronogramaTotales().get(0);
            response.setTotalCuotas(cronograma.getTotalCuotas());
            response.setTotalFinanciado(cronograma.getTotalFinanciado());
            response.setTotalAmortizacion(cronograma.getTotalAmortizacion());
            response.setTotalInteres(cronograma.getTotalInteres());
            response.setTotalIgv(cronograma.getTotalIgv());
            response.setTotalIsc(cronograma.getTotalIsc());
            response.setTotalSeguro(cronograma.getTotalSeguro());
            response.setTotalCuota(cronograma.getTotalCuota());
        }
        
        if (parametrosCronograma.getDatosGenerales().size() > 0) {
            CronogramaLetrasLxCDatosGenerales datosGenerales = parametrosCronograma.getDatosGenerales().get(0);
            response.setNoCia(datosGenerales.getNoCia());
            response.setGrupo(datosGenerales.getGrupo());
            response.setCodOper(datosGenerales.getCodOper());
            response.setTea(datosGenerales.getTea());
            response.setEstado(datosGenerales.getEstado());
            response.setFechaCronograma(datosGenerales.getFechaCronograma());
            response.setMoneda(datosGenerales.getMoneda());
            response.setTipoCambio(datosGenerales.getTipoCambio());
            response.setNoCliente(datosGenerales.getNoCliente());
            response.setTotalFinanciar(datosGenerales.getTotalFinanciar());
            response.setNroCuotas(datosGenerales.getNroCuotas());
            response.setFechaActual(datosGenerales.getFechaActual());
            response.setNomCliente(datosGenerales.getNomCliente());
        }
        
        byte[] excelByte = reporte.generarReporte(response);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));
        
        return reporteResponse;
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

}
