/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.VehiculosDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarIndiVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarVehiculosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudVehiculosProcedure;
import pe.com.divemotor.solicitudcredito.mapper.VehiculosMapper;

/**
 *
 * @author legutierrez
 */
@Repository
public class VehiculosDAOImpl implements VehiculosDAO {

    VehiculosMapper vehiculosMapper;

    @Autowired
    public void setVehiculosMapper(VehiculosMapper vehiculosMapper) {
        this.vehiculosMapper = vehiculosMapper;
    }

    @Override
    public void listar(ListarVehiculosProcedure parametros) {
        vehiculosMapper.listar(parametros);
    }

    @Override
    public void registrar(RegistrarSolicitudVehiculosProcedure parametros) {
        vehiculosMapper.registrar(parametros);
    }

    @Override
    public void actualizar(ActualizarIndiVehiculoProcedure parametros) {
        vehiculosMapper.actualizar(parametros);
    }

}
