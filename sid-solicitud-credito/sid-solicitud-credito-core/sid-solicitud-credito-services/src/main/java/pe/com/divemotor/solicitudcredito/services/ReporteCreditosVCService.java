/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dominio.ReporteVistaCliente;
import pe.com.divemotor.solicitudcredito.dto.request.VistaClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaClienteResponse;

/**
 *
 * @author jaltamirano
 */
public interface ReporteCreditosVCService {
    
    public ReporteVistaClienteListadoResponse listarCodigosOperacion(HeaderParams headerParams, 
                                                                     VistaClienteRequest request) throws Exception;

    public ReporteVistaClienteResponse exportarVistaCliente(HeaderParams headerParams, 
                                                            ReporteVistaCliente reporteVC) throws Exception;

    
}
