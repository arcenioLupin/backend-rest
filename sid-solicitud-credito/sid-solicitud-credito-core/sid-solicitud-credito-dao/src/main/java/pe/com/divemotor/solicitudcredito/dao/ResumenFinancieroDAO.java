package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroMaturityProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.ListarResumenFinancieroProcedure;
//import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;

public interface ResumenFinancieroDAO {

    public void listar(ListarResumenFinancieroProcedure parametros);
    
    public void insertar(InsertarResumenFinancieroProcedure parametros);
    
    public void insertarMaturity(InsertarResumenFinancieroMaturityProcedure parametros);    
    
    public void listarRangos(ListarResumenFinancieroProcedure parametros);
}
