package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.AvalDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.EliminarAvalProcedure;

import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.InsertarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDepartamentosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDistritosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarPaisesAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarProvinciasAvalProcedure;
import pe.com.divemotor.solicitudcredito.mapper.AvalMapper;

@Repository
public class AvalDAOImpl implements AvalDAO {

    private AvalMapper avalMapper;

    @Autowired
    public void setAvalMapper(AvalMapper avalMapper) {
        this.avalMapper = avalMapper;
    }

    @Override
    public void insertar(InsertarAvalProcedure parametros) {
        avalMapper.insertar(parametros);
    }

    @Override
    public void eliminar(InsertarAvalProcedure parametros) {
        avalMapper.eliminar(parametros);
    }
    
    @Override
    public void eliminarbyaval(EliminarAvalProcedure parametros) {
        avalMapper.eliminarbyaval(parametros);
    }
    
    @Override
    public void listar(ListarAvalProcedure parametros) {
        avalMapper.listar(parametros);
    }
    
    @Override
    public void listarAvalesHistorico(ListarAvalProcedure parametros) {
        avalMapper.listarAvalesHistorico(parametros);
    }
    
    @Override
    public void listarPaises(ListarPaisesAvalProcedure parametros) throws Exception {
        avalMapper.listarPaises(parametros);
    }

    @Override
    public void listarDepartamentos(ListarDepartamentosAvalProcedure parametros) throws Exception {
        avalMapper.listarDepartamentos(parametros);
    }

    @Override
    public void listarProvincias(ListarProvinciasAvalProcedure parametros) throws Exception {
        avalMapper.listarProvincias(parametros);
    }

    @Override
    public void listarDistritos(ListarDistritosAvalProcedure parametros) throws Exception {
        avalMapper.listarDistritos(parametros);
    }

}
