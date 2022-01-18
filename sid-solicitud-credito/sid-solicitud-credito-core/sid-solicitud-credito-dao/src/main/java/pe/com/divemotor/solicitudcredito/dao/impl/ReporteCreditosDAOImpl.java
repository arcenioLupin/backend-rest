package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;
import pe.com.divemotor.solicitudcredito.mapper.DocumentoMapper;
import pe.com.divemotor.solicitudcredito.dao.DocumentoDAO;
import pe.com.divemotor.solicitudcredito.dao.ReporteCreditosDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.reporteCreditos.ListarReporteCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ReporteCreditosMapper;

@Repository
public class ReporteCreditosDAOImpl implements ReporteCreditosDAO {

    private ReporteCreditosMapper reporteCreditosMapper;

    @Autowired
    public void setReporteCreditosMapper(ReporteCreditosMapper reporteCreditosMapper) {
        this.reporteCreditosMapper = reporteCreditosMapper;
    }

    @Override
    public void listar(ListarReporteCreditosProcedure parametros) {
        reporteCreditosMapper.listar(parametros);
    }
    
}
    