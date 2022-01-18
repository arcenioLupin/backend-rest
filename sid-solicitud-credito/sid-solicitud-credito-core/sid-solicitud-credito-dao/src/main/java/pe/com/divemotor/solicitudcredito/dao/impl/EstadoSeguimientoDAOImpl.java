package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dao.EstadoSeguimientoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ActualizarEstadoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ListarEstadosProcedure;
import pe.com.divemotor.solicitudcredito.mapper.EstadoSeguimientoMapper;

@Repository
public class EstadoSeguimientoDAOImpl implements EstadoSeguimientoDAO {

    private EstadoSeguimientoMapper estadoSeguimientoMapper;

    @Override
    public void listar(ListarEstadosProcedure parametros) {
        estadoSeguimientoMapper.listarEstados(parametros);
    }

    @Override
    public void actualizarEstado(ActualizarEstadoProcedure parametros) {
        estadoSeguimientoMapper.actualizarEstado(parametros);

    }

    @Autowired
    public void setEstadoSeguimientoMapper(EstadoSeguimientoMapper estadoSeguimientoMapper) {
        this.estadoSeguimientoMapper = estadoSeguimientoMapper;
    }

}
