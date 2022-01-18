/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ReporteVistaClienteDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.AmortizacionPorLetrtaOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente.ListarReporteVistaClienteProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ReporteVistaClienteMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class ReporteVistaClienteDAOImpl implements ReporteVistaClienteDAO {
    
    private ReporteVistaClienteMapper reporteVCMapper;
    
    @Autowired
    public void setReporteVCMapper(ReporteVistaClienteMapper reporteVCMapper) {
        this.reporteVCMapper = reporteVCMapper;
    }
    
    @Override
    public void listarCodigosOperacion(ListarReporteVistaClienteProcedure parametros) {
        reporteVCMapper.listarCodigosOperacion(parametros);
    }
    
    @Override
    public void listarOperaciones(ListarReporteVistaClienteProcedure parametros) {
        reporteVCMapper.listarOperaciones(parametros);
    }
    
     @Override
        public void amortizacionesPorLetraOperacion(AmortizacionPorLetrtaOperacionesProcedure parametros) {
        reporteVCMapper.amortizacionesPorLetraOperacion(parametros);
    }
    
     @Override
    public void listarGarantias(ListarReporteVistaClienteProcedure parametros) {
        reporteVCMapper.listarGarantias(parametros);
    }

    

    
}
