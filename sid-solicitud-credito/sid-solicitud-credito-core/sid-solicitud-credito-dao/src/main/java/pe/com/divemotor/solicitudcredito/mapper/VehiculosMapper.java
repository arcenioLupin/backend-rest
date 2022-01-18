/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarIndiVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarVehiculosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudVehiculosProcedure;

/**
 *
 * @author legutierrez
 */
public interface VehiculosMapper {
    
    void listar (ListarVehiculosProcedure parametros);
    
    void registrar (RegistrarSolicitudVehiculosProcedure parametros);
    
    void actualizar(ActualizarIndiVehiculoProcedure parametros);
}
