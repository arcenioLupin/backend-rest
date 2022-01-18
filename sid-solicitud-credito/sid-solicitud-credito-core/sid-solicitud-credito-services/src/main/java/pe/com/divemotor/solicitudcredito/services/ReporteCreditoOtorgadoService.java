/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import java.util.List;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dominio.ReporteCreditoOtorgado;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteCreditoOtorgadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoOtorgadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface ReporteCreditoOtorgadoService {

    public ReporteCreditoOtorgadoListadoResponse listarCreditoOtorgado(HeaderParams headerParams,
            ReporteCreditoOtorgadoRequest request) throws Exception;

    public ReporteCreditoOtorgadoResponse exportarCreditoOtorgado(HeaderParams headerParams,
            List<ReporteCreditoOtorgado> lista) throws Exception;
}
