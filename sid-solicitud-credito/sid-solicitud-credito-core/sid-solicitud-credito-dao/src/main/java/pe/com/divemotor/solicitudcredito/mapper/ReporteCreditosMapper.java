package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.reporteCreditos.ListarReporteCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;

public interface ReporteCreditosMapper {

    void listar(ListarReporteCreditosProcedure parametros);
}
