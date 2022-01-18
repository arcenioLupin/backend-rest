package pe.com.divemotor.solicitudcredito.reporte;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.apache.commons.io.FileUtils;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteCronogramaExcelDataSource;

/**
 *
 * @author phramirez
 */
public class ReporteCronogramaExcel {

    public byte[] generarReporte(ReporteCronogramaExcelDataSource dataSource) throws Exception {

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream isReportePrincipal = classLoader.getResourceAsStream("/reporte/excel/reporteCronograma.jasper");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parameters = objectMapper.convertValue(dataSource, Map.class);
        parameters.put(JRParameter.IS_IGNORE_PAGINATION, true);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(isReportePrincipal);

        // Siempre usar JREmptyDataSource
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        File outFile = File.createTempFile("dive", ".xls");

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outFile));
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(true);
        configuration.setWhitePageBackground(false);
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        byte[] result = FileUtils.readFileToByteArray(outFile);
        outFile.delete();

        return result;
    }
}
