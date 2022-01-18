package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.List;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.MaestroDAO;
import pe.com.divemotor.solicitudcredito.dao.ReporteCreditosDAO;
import pe.com.divemotor.solicitudcredito.dominio.ReporteCredito;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.reporteCreditos.ListarReporteCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditosListadoResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteCreditoExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteCreditoExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.ReporteCreditosService;

@Service
@Transactional
public class ReporteCreditosServiceImpl implements ReporteCreditosService {

    private ReporteCreditosDAO reporteCreditosDAO;
    private MaestroDAO maestroDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setReporteCreditosDAO(ReporteCreditosDAO reporteCreditosDAO) {
        this.reporteCreditosDAO = reporteCreditosDAO;
    }
    
    @Autowired
    public void setMaestroDAO(MaestroDAO maestroDAO) {
        this.maestroDAO = maestroDAO;
    }
    
    @Transactional(readOnly = true)
    @Override
    public ReporteCreditosListadoResponse listar(HeaderParams headerParams,String tipCred,String areaVta,String zona,String fechIni,String fechFin) throws Exception {
		
        ListarReporteCreditosProcedure parametros = mapper.map(headerParams, ListarReporteCreditosProcedure.class);
        parametros.setTipCred(tipCred);
        parametros.setAreaVta(areaVta);
        parametros.setZona(zona);
        parametros.setFechIni(fechIni);
        parametros.setFechFin(fechFin);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.reporteCreditosDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ReporteCreditosListadoResponse response = new ReporteCreditosListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }

    @Override
    public ReporteCreditoResponse exportarCreditos(HeaderParams headerParams,String tipCred,String areaVta,String zona,String fechIni,String fechFin) throws Exception {
        ReporteCreditoExcelDataSource response = new ReporteCreditoExcelDataSource();
        ReporteCreditoExcel reporte = new ReporteCreditoExcel();

        ListarReporteCreditosProcedure parametros = mapper.map(headerParams, ListarReporteCreditosProcedure.class);
        parametros.setTipCred(tipCred);
        parametros.setAreaVta(areaVta);
        parametros.setZona(zona);
        parametros.setFechIni(fechIni);
        parametros.setFechFin(fechFin);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.reporteCreditosDAO.listar(parametros);
        Integer statusQuery = parametros.getStatus();
        List<ReporteCredito> listaItems = null;
        if (statusQuery.equals(1)) {
            listaItems = parametros.getBusqueda();
        }
        byte[] excelByte = reporte.generarReporte(response,listaItems);

        ReporteCreditoResponse reporteResponse = new ReporteCreditoResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;
    }
    
    @Transactional(readOnly = true)
    @Override
    public MaestroListadoResponse listarComboMaestro(HeaderParams headerParams,String tipo) throws Exception {
		
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        this.maestroDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
 @Transactional(readOnly = true)
    @Override
    public MaestroListadoResponse listarFilialZona(HeaderParams headerParams,String tipo, String codDepa, String codProv, String codDist) throws Exception {
		
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        parametros.setCodDepa(codDepa);
        parametros.setCodProv(codProv);
        parametros.setCodDist(codDist);
        this.maestroDAO.listarFilialZona(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }    
}
