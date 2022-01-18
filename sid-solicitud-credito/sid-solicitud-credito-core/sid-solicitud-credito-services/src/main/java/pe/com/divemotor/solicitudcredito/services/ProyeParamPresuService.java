/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionListadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface ProyeParamPresuService {
    
    public ProyeccionListadoResponse listarProyeccion(HeaderParams headerParams, ProyeccionRequest request) throws Exception;

    public BaseResponse actualizarProyeccion(HeaderParams headerParams, ProyeccionRequest request) throws Exception;
    
}
