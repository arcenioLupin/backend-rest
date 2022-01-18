/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ActualizarKPIsProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ListarKPIsProcedure;

/**
 *
 * @author jaltamirano
 */
public interface KPIsDAO {
    
    void listarKPIs(ListarKPIsProcedure parametros);

    void actualizarKPIs(ActualizarKPIsProcedure parametros);
}
