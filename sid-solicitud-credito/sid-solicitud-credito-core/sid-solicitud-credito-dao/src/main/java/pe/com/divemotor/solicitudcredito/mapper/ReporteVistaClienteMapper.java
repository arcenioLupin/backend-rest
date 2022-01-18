/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.AmortizacionPorLetrtaOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.ListarReporteVistaClienteProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ReporteVistaClienteMapper {

    public void listarCodigosOperacion(ListarReporteVistaClienteProcedure parametros);

    public void listarOperaciones(ListarReporteVistaClienteProcedure parametros);
    
    public void amortizacionesPorLetraOperacion(AmortizacionPorLetrtaOperacionesProcedure parametros);

    public void listarGarantias(ListarReporteVistaClienteProcedure parametros);

}
