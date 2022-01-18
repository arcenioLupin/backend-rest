/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDocumentosRelacionadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarRepresentanteLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarReprogramacionOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposDocumentosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarCronogramaLetrasLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarOperacionLxCRegistradaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.RegistrarOperacionLxCProcedure;

/**
 *
 * @author mbardales
 */
public interface OperacionLxCMapper {
    
    void listar (ListarDocumentosRelacionadosProcedure parametros);
    
    void listarTiposDocumentos (ListarTiposDocumentosLxCProcedure parametros);
    
    void listarTiposGastos (ListarTiposGastosLxCProcedure parametros);
    
    void listarGastos (ListarGastosLxCProcedure parametros);
    
    void listarRepresentanteLegal (ListarRepresentanteLegalProcedure parametros);
    
    void listarReprogramacionOperaciones (ListarReprogramacionOperacionesProcedure parametros);
    
    void registrarOperacionLxC (RegistrarOperacionLxCProcedure parametros);
    
    void listarOperacionLxCRegistrado (ListarOperacionLxCRegistradaProcedure parametros);
    
    void listarCronogramaLetrasLxC (ListarCronogramaLetrasLxCProcedure parametros);
}
