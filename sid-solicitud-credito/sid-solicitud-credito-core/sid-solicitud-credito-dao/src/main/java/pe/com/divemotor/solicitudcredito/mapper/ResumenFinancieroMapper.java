package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroMaturityProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.ListarResumenFinancieroProcedure;

public interface ResumenFinancieroMapper {

    void listar(ListarResumenFinancieroProcedure parametros);
    
    public void insertar(InsertarResumenFinancieroProcedure parametros);
    
    public void insertarMaturity(InsertarResumenFinancieroMaturityProcedure parametros);
    
    void listarRangos(ListarResumenFinancieroProcedure parametros);
}
