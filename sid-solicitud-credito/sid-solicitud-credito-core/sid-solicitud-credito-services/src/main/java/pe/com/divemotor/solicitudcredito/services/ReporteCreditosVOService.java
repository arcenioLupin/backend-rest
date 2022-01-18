/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.VistaOperacionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteVistaOperacionResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoVOListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.movimientos.WSInfoDetalleMovClieResponse;

/**
 *
 * @author jaltamirano
 */
public interface ReporteCreditosVOService {

    public ReporteVistaOperacionListadoResponse listar(HeaderParams headerParams, String codOperacion) throws Exception;

    public ReporteVistaOperacionResponse exportarVistaOperacion(HeaderParams headerParams, VistaOperacionRequest request) throws Exception;
}
