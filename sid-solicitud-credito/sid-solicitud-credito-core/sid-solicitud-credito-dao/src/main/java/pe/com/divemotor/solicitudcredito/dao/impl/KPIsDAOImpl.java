/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.KPIsDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ActualizarKPIsProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ListarKPIsProcedure;
import pe.com.divemotor.solicitudcredito.mapper.KPIsMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class KPIsDAOImpl implements KPIsDAO{
    
    private KPIsMapper mapper;
    
    @Autowired
    public void setMapper(KPIsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void listarKPIs(ListarKPIsProcedure parametros) {
        mapper.listarKPIs(parametros);
    }

    @Override
    public void actualizarKPIs(ActualizarKPIsProcedure parametros) {
        mapper.actualizarKPIs(parametros);
    }

    
    
    
}
