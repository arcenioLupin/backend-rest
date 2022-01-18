/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarFlujoCajaInfoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaDetalleProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.ListarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarFactorPorMesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarParametrosFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.fc.RegistrarProyeccionFlujoCajaProcedure;

/**
 *
 * @author mbardales
 */
public interface FlujoCajaMapper {
    
    void registrarParametrosFC (RegistrarParametrosFlujoCajaProcedure parametros);
    
    void registrarFactorPorMes (RegistrarFactorPorMesProcedure parametros);
    
    void registrarProyeccionFlujoCaja (RegistrarProyeccionFlujoCajaProcedure parametros);
    
    void listarParametrosFlujoCaja (ListarParametrosFlujoCajaProcedure parametros);
    
    void listarParametrosFlujoCajaDetalle (ListarParametrosFlujoCajaDetalleProcedure parametros);
    
    void listarFlujoCajaInfo(ListarFlujoCajaInfoProcedure parametros);
}
