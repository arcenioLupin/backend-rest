package pe.com.divemotor.solicitudcredito.reporte;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReportePropuestaPdfDataSource;

/**
 *
 * @author phramirez
 */
public class ReportePropuestaPdf {

    public ReportePropuestaPdf() {
        super();
    }

    public byte[] generarReporte(ReportePropuestaPdfDataSource dataSource, String flagDatos) throws Exception {

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream isReportePrincipal = classLoader.getResourceAsStream("/reporte/pdf/reportePropuesta.jasper");
        
        InputStream pathLogo = classLoader.getResourceAsStream("/reporte/imagen/logo_divemotor.jpg");
        InputStream pathMarcas = classLoader.getResourceAsStream("/reporte/imagen/marcas_divemotor.jpg");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
        parameters.put("pathLogo", pathLogo);
        parameters.put("pathMarcas", pathMarcas);
        parameters.put("flagDatos", flagDatos);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);

        // Siempre usar JREmptyDataSource
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
