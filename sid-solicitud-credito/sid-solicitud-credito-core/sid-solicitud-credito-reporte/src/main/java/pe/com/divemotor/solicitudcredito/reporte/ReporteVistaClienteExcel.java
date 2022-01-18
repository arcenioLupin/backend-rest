/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.FileUtils;
import pe.com.divemotor.solicitudcredito.dominio.ReporteVistaCliente;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteVistaClienteExcelDataSource;

/**
 *
 * @author jaltamirano
 */
public class ReporteVistaClienteExcel {

    public ReporteVistaClienteExcel() {
        super();
    }
    
    public byte[] generarReporte(ReporteVistaClienteExcelDataSource dataSource, ReporteVistaCliente reporteVC) throws Exception{
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream isReportePrincipal = classLoader.getResourceAsStream("/reporte/excel/reporteVistaCliente.jasper");
        InputStream pathLogo = classLoader.getResourceAsStream("/reporte/imagen/logo_divemotor.jpg");
                
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parameters = objectMapper.convertValue(reporteVC, Map.class);
        parameters.put("pathLogo", pathLogo);
        
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);

        // Siempre usar JREmptyDataSource
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(listaItems));
        File outFile = File.createTempFile("dive", ".xls");

        JRExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, outFile);
        exporter.exportReport();

        byte[] result = FileUtils.readFileToByteArray(outFile);
        outFile.delete();

        return result;
    }
}
