/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion.ListarReporteVistaOperacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion.ListarSolicitudCreditoVOProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ReporteVistaOperacionMapper {

    public void listar(ListarReporteVistaOperacionProcedure parametros);
    
    public void listarSolcreByCodOper(ListarSolicitudCreditoVOProcedure parametros);

}
