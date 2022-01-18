/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.AgrupTasasVehiculoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ActualizarAgrupTasasVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoDetProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.AgrupTasasVehiculoMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class AgrupTasasVehiculoDAOImpl implements AgrupTasasVehiculoDAO {
    
    private AgrupTasasVehiculoMapper mapper;
    
    @Autowired
    public void setMapper(AgrupTasasVehiculoMapper mapper) {
        this.mapper = mapper;
    }
    
    @Override
    public void listarAgrupaciones(ListarAgrupTasasVehiculoProcedure parametros) {
        mapper.listarAgrupaciones(parametros);
    }
    
    @Override
    public void listarAgrupacionesDetail(ListarAgrupTasasVehiculoDetProcedure parametros) {
        mapper.listarAgrupacionesDetail(parametros);
    }
    
    @Override
    public void actualizarAgrupaciones(ActualizarAgrupTasasVehiculoProcedure parametros) {
        mapper.actualizarAgrupaciones(parametros);
    }
    
    @Override
    public void actualizarAgrupacionesDetalle(ActualizarAgrupTasasVehiculoProcedure parametros) {
        mapper.actualizarAgrupacionesDetalle(parametros);
    }    

    
    
}
