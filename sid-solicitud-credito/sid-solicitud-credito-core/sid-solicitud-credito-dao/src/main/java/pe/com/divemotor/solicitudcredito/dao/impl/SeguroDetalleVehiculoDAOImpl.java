/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.SeguroDetalleVehiculoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroDetalleVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.SeguroDetalleVehiculoMapper;

/**
 *
 * @author MGrasso
 */
@Repository
public class SeguroDetalleVehiculoDAOImpl implements SeguroDetalleVehiculoDAO{
    
    private SeguroDetalleVehiculoMapper seguroDetalleVehiculoMapper;
    
    @Autowired
    public void setSeguroDetalleVehiculoMapper(SeguroDetalleVehiculoMapper seguroDetalleVehiculoMapper) {
        this.seguroDetalleVehiculoMapper = seguroDetalleVehiculoMapper;
    }
    
    @Override
    public void listar(ListarSeguroDetalleVehiculoProcedure parametros) {
        seguroDetalleVehiculoMapper.listar(parametros);
    }
}
