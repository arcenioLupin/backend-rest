/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.EntidadFinancieraListadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface EntidadFinancieraService {
    
    public EntidadFinancieraListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception;
    
}
