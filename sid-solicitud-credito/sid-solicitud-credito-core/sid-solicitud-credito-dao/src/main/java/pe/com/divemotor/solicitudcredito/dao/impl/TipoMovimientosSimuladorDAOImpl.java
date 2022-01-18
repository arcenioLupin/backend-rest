/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dao.TipoMovimientosSimuladorDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientosSimuladorProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSimuladorTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientosSimuladorListadoResponse;
import pe.com.divemotor.solicitudcredito.mapper.TipoMovimientosSimuladorMapper;

/**
 *
 * @author ebarboza
 */
@Repository
public class TipoMovimientosSimuladorDAOImpl implements TipoMovimientosSimuladorDAO {

    /*Req. 87567 E2.3 ID## EBARBOZA 27/01/2020*/
    TipoMovimientosSimuladorMapper tipoMovimientosSimuladorMapper;

    @Autowired
    public void setTipoMovimientosSimuladorMapper(TipoMovimientosSimuladorMapper tipoMovimientosSimuladorMapper) {
        this.tipoMovimientosSimuladorMapper = tipoMovimientosSimuladorMapper;
    }

    @Override
    public void actualizarTipoMovimientosSimulador(RegistrarSimuladorTipoMovimientoProcedure parametros) {

        try {
            tipoMovimientosSimuladorMapper.actualizarTipoMovimientosSimulador(parametros);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void listarPorCodSoliCred(ListarTipoMovimientosSimuladorProcedure parametros) {
        tipoMovimientosSimuladorMapper.listarPorCodSoliCred(parametros);
    }

}
