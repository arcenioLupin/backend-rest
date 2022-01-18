/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.InformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaInformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.response.InformacionSBSListadoResponse;

/**
 *
 * @author legutierrez
 */
public interface InformacionSBSService {
    
    BaseResponse registrar (HeaderParams headerParams, InformacionSBSRequest request) throws Exception;
    
    InformacionSBSListadoResponse listar(HeaderPaginadoParams headerParams, ListaInformacionSBSRequest request) throws Exception;
}
