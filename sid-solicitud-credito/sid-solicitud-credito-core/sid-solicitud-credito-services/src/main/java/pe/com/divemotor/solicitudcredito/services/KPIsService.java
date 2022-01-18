/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.KPIsRequest;
import pe.com.divemotor.solicitudcredito.dto.response.KPIsListadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface KPIsService {

    public KPIsListadoResponse listarKPIs(HeaderParams headerParams, KPIsRequest request) throws Exception;

    public BaseResponse actualizarKPIs(HeaderParams headerParams, KPIsRequest request) throws Exception;
}
