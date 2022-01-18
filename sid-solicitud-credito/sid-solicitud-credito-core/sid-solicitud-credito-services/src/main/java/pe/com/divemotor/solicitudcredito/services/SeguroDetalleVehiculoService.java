/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroDetalleVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroDetalleVehiculoListadoResponse;

/**
 *
 * @author Mgrasso
 */
public interface SeguroDetalleVehiculoService {
    SeguroDetalleVehiculoListadoResponse listar(HeaderPaginadoParams headerParams, SeguroDetalleVehiculoRequest request) throws Exception;
}
