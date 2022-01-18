package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.reporteCreditos.ListarReporteCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;

public interface ReporteCreditosDAO {

    void listar(ListarReporteCreditosProcedure parametros);
}
