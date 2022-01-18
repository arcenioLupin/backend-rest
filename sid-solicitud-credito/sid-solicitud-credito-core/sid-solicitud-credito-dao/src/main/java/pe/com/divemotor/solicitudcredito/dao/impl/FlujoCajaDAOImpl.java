/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.mapper.FlujoCajaMapper;
import pe.com.divemotor.solicitudcredito.dao.FlujoCajaDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarFlujoCajaInfoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaDetalleProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarFactorPorMesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarProyeccionFlujoCajaProcedure;

/**
 *
 * @author mbardales
 */
@Repository
public class FlujoCajaDAOImpl implements FlujoCajaDAO {

    private FlujoCajaMapper flujoCajaMapper;

    @Autowired
    public void setFlujoCajaMapper(FlujoCajaMapper flujoCajaMapper) {
        this.flujoCajaMapper = flujoCajaMapper;
    }

    @Override
    public void registrarParametrosFC(RegistrarParametrosFlujoCajaProcedure parametros) {
        this.flujoCajaMapper.registrarParametrosFC(parametros);
    }

    @Override
    public void registrarFactorPorMes(RegistrarFactorPorMesProcedure parametros) {
        this.flujoCajaMapper.registrarFactorPorMes(parametros);
    }

    @Override
    public void registrarProyeccionFlujoCaja(RegistrarProyeccionFlujoCajaProcedure parametros) {
        this.flujoCajaMapper.registrarProyeccionFlujoCaja(parametros);
    }

    @Override
    public void listarParametrosFlujoCaja(ListarParametrosFlujoCajaProcedure parametros) {
        this.flujoCajaMapper.listarParametrosFlujoCaja(parametros);
    }

    @Override
    public void listarParametrosFlujoCajaDetalle(ListarParametrosFlujoCajaDetalleProcedure parametros) {
        this.flujoCajaMapper.listarParametrosFlujoCajaDetalle(parametros);
    }

    @Override
    public void listarFlujoCajaInfo(ListarFlujoCajaInfoProcedure parametros) {
        this.flujoCajaMapper.listarFlujoCajaInfo(parametros);
    }

}
