/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;


import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteInformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteInformacionSBSResponse;

/**
 *
 * @author legutierrez
 */
public interface ReporteInformacionSBSService {
    
    public ReporteInformacionSBSResponse exportarReporte (HeaderParams headerParams, ReporteInformacionSBSRequest request) throws Exception;
}
