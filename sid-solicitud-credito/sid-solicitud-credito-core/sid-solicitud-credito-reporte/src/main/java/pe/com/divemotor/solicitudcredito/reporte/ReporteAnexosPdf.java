/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.commons.io.FileUtils;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteAnexosDataSource;


/**
 *
 * @author USER
 */
public class ReporteAnexosPdf {

    public ReporteAnexosPdf() {
        
        super();
    }

    public byte[] generarReporte(ReporteAnexosDataSource dataSource) throws Exception {
        
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream isReportePrincipal;
        JasperPrint jasperPrint = null;
        String pathLogo = "/reporte/imagen/logo_divemotor.jpg";
        if (dataSource.getCodTipSoliCred().equals("TC02"))
        {         
           isReportePrincipal = classLoader.getResourceAsStream("/reporte/pdf/reporteAnexos.jasper");            
           ObjectMapper objectMapper = new ObjectMapper();
           Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
           parameters.put("pathLogo", pathLogo);
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);
           // Siempre usar JREmptyDataSource
           jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());       
               
        }
        
        if(dataSource.getCodTipSoliCred().equals("TC01")){
        
          isReportePrincipal = classLoader.getResourceAsStream("/reporte/pdf/reporteAnexosContratoRD.jasper");            
          ObjectMapper objectMapper = new ObjectMapper();
          Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
          parameters.put("pathLogo", pathLogo);
          JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);
          // Siempre usar JREmptyDataSource
          jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource()); 
              
        }
        if(dataSource.getCodTipSoliCred().equals("TC03")){
        
          isReportePrincipal = classLoader.getResourceAsStream("/reporte/pdf/reporteAnexosContratoMutuo.jasper");            
          ObjectMapper objectMapper = new ObjectMapper();
          Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
          parameters.put("pathLogo", pathLogo);
          JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);
          // Siempre usar JREmptyDataSource
          jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource()); 
              
        }
        
        if(dataSource.getCodTipSoliCred().equals("TC04")){
        
          isReportePrincipal = classLoader.getResourceAsStream("/reporte/pdf/reporteAnexos_2.jasper");            
          ObjectMapper objectMapper = new ObjectMapper();
          Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
          parameters.put("pathLogo", pathLogo);
          JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);
          // Siempre usar JREmptyDataSource
          jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource()); 
              
        }
            
         //return JasperExportManager.exportReportToPdf(jasperPrint); 
         
            JRDocxExporter exporter = new JRDocxExporter();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();    
           exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
           exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
           exporter.exportReport(); 
           
           return baos.toByteArray();
                   
  
        
  
    }  
    
    
}
