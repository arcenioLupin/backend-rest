/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroDetalleVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarPolizaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.VencimientoSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroTramaProcedure;

/**
 *
 * @author Mgrasso
 */
public interface SeguroDAO {
    
    public void listar(ListarSeguroProcedure parametros);
    
    public void actualizar(ActualizarSeguroProcedure parametros);
    
    public void actualizarPlaca(ActualizarSeguroDetalleVehiculoProcedure parametros);
    
    public void actualizarPoliza(ActualizarSeguroProcedure parametros);
    
    public void listarPoliza(ListarPolizaProcedure parametros);
    
    public void vencimientoSeguro(VencimientoSeguroProcedure parametros);
    
    public void listarTramaSeguro(ListarSeguroTramaProcedure parametros);
}
