/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.AmortizacionPorLetrtaOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.ListarReporteVistaClienteProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ReporteVistaClienteDAO {
    
    void listarCodigosOperacion(ListarReporteVistaClienteProcedure parametros);
    
    void listarOperaciones(ListarReporteVistaClienteProcedure parametros);
    
    void amortizacionesPorLetraOperacion(AmortizacionPorLetrtaOperacionesProcedure parametros);

    void listarGarantias(ListarReporteVistaClienteProcedure parametros);
    
}
