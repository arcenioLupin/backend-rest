/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.TipoMovimientoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.IsTipoMovimientoOperacionExisteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.TipoMovimientoMapper;

/**
 *
 * @author eudo.barboza
 */
@Repository
public class TipoMovimientoDAOImpl implements TipoMovimientoDAO {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    TipoMovimientoMapper tipoMovimientoMapper;

    @Autowired
    public void setTipoMovimientoMapper(TipoMovimientoMapper tipoMovimientoMapper) {
        this.tipoMovimientoMapper = tipoMovimientoMapper;
    }
    
    
    
    @Override
    public void listar(ListarTipoMovimientoProcedure parametros) {
        tipoMovimientoMapper.listar(parametros);
    }
    
    @Override
    public void listarTodos(ListarTipoMovimientoProcedure parametros) {
        tipoMovimientoMapper.listarTodos(parametros);
    }
    
     @Override
    public void IsTipoMovimientoOperacionExiste(IsTipoMovimientoOperacionExisteProcedure parametros) {
        tipoMovimientoMapper.IsTipoMovimientoOperacionExiste(parametros);
    }
    
    @Override
    public void actualizarTipoMovimiento(ActualizarTipoMovimientoProcedure parametros) {
        tipoMovimientoMapper.actualizarTipoMovimiento(parametros);
    }
    
}
