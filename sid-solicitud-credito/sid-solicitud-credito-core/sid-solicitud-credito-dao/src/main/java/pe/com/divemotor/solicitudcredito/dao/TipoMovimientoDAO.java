/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.IsTipoMovimientoOperacionExisteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientoProcedure;

/**
 *
 * @author eudo.barboza
 */
public interface TipoMovimientoDAO {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
     void listar (ListarTipoMovimientoProcedure parametros);
     void listarTodos (ListarTipoMovimientoProcedure parametros);
     void IsTipoMovimientoOperacionExiste(IsTipoMovimientoOperacionExisteProcedure parametros);
     void actualizarTipoMovimiento (ActualizarTipoMovimientoProcedure parametros);
}
