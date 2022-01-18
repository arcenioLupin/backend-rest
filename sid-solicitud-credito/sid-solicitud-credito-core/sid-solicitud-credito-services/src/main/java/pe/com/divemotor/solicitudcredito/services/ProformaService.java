/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.ListaProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;

/**
 *
 * @author legutierrez
 */
public interface ProformaService {
    
    ProformaListadoResponse listar (HeaderPaginadoParams headerParams, ListaProformaRequest request) throws Exception;
}
