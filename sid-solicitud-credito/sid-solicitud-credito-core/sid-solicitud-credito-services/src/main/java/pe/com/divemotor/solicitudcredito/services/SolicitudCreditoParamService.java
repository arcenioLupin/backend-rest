/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.FlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoParamResponse;

/**
 *
 * @author legutierrez
 */
public interface SolicitudCreditoParamService {
    
    BaseResponse registrar (HeaderParams headerParams, SolicitudCreditoParamRequest request) throws Exception;
    
    SolicitudCreditoParamResponse listar (HeaderPaginadoParams headerParams, ListaSolicitudCreditoParamRequest request) throws Exception;
     
    FlujoCajaResponse listarFlujoCaja (HeaderPaginadoParams headerParams, FlujoCajaRequest request) throws Exception;
}