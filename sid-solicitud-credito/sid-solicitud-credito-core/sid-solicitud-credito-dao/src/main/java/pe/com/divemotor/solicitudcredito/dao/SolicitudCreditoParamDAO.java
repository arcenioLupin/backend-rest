/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.ListarFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoParamProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudCreditoParamProcedure;

/**
 *
 * @author legutierrez
 */
public interface SolicitudCreditoParamDAO {
    
    void registrar (RegistrarSolicitudCreditoParamProcedure parametros);
    
    void listar (ListarSolicitudCreditoParamProcedure parametros);
    
    void listarFlujoCaja (ListarFlujoCajaProcedure parametros);
}
