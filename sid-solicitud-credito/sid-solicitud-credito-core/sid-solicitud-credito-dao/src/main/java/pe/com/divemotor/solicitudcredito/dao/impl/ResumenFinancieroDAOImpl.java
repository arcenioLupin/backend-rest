package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dao.ResumenFinancieroDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroMaturityProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.ListarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ResumenFinancieroMapper;

@Repository
public class ResumenFinancieroDAOImpl implements ResumenFinancieroDAO {

    private ResumenFinancieroMapper resumenFinancieroMapper;

    @Autowired
    public void setResumenFinancieroMapper(ResumenFinancieroMapper resumenFinancieroMapper) {
        this.resumenFinancieroMapper = resumenFinancieroMapper;
    }

    @Override
    public void listar(ListarResumenFinancieroProcedure parametros) {
        resumenFinancieroMapper.listar(parametros);
    }
    
    @Override
    public void insertar(InsertarResumenFinancieroProcedure parametros) {
        resumenFinancieroMapper.insertar(parametros);
    }

    @Override
    public void insertarMaturity(InsertarResumenFinancieroMaturityProcedure parametros) {
        resumenFinancieroMapper.insertarMaturity(parametros);
    }    
    
    @Override
    public void listarRangos(ListarResumenFinancieroProcedure parametros) {
        resumenFinancieroMapper.listarRangos(parametros);
    }
        
    
}
    