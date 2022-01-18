package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.mapper.GarantiaMapper;
import pe.com.divemotor.solicitudcredito.dao.GarantiaDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ConsultarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.InsertarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDepartamentosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDistritosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasHistoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarPaisesGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarProvinciasGarantiaProcedure;

@Repository
public class GarantiaDAOImpl implements GarantiaDAO {

    private GarantiaMapper garantiaMapper;

    @Autowired
    public void setGarantiaMapper(GarantiaMapper garantiaMapper) {
        this.garantiaMapper = garantiaMapper;
    }

    @Override
    public void listar(ListarGarantiasProcedure parametros) {
        garantiaMapper.listar(parametros);
    }
    
    @Override
    public void insertar(InsertarGarantiaProcedure parametros) {
        garantiaMapper.insertar(parametros);
    }
    
    @Override
    public void listarHistorico(ListarGarantiasHistoProcedure parametros) {
        garantiaMapper.listarHistorico(parametros);
    }
    
    @Override
    public void eliminar(InsertarGarantiaProcedure parametros) {
        garantiaMapper.eliminar(parametros);
    }
    
    @Override
    public void eliminarByGara(InsertarGarantiaProcedure parametros) {
        garantiaMapper.eliminarByGara(parametros);
    }
    
    @Override
    public void listarPaises(ListarPaisesGarantiaProcedure parametros) throws Exception {
        garantiaMapper.listarPaises(parametros);
    }

    @Override
    public void listarDepartamentos(ListarDepartamentosGarantiaProcedure parametros) throws Exception {
        garantiaMapper.listarDepartamentos(parametros);
    }

    @Override
    public void listarProvincias(ListarProvinciasGarantiaProcedure parametros) throws Exception {
        garantiaMapper.listarProvincias(parametros);
    }

    @Override
    public void listarDistritos(ListarDistritosGarantiaProcedure parametros) throws Exception {
        garantiaMapper.listarDistritos(parametros);
    }
    
    @Override
    public void listarCoberturaGarantia(ListarCoberturaGarantiaProcedure parametros) {
        garantiaMapper.listarCoberturaGarantia(parametros);
    }    
    // <I> 90690 ivelasquez 21/09/2021
    @Override
    public void consultarGarantias(ConsultarGarantiasProcedure parametros) {
        garantiaMapper.consultarGarantias(parametros);
    }
    // <F> 90690 ivelasquez 21/09/2021

}
    