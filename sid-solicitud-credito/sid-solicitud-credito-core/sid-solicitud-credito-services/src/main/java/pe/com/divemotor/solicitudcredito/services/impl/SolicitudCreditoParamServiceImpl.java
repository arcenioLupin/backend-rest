/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.SolicitudCreditoParamDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoParamProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudCreditoParamProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.FlujoCajaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoParamRequest;
import pe.com.divemotor.solicitudcredito.dto.response.FlujoCajaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoParamResponse;
import pe.com.divemotor.solicitudcredito.services.SolicitudCreditoParamService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author legutierrez
 */
@Service
@Transactional
public class SolicitudCreditoParamServiceImpl implements SolicitudCreditoParamService {

    private SolicitudCreditoParamDAO solicitudCreditoParamDAO;
    private Mapper mapper;

    @Autowired
    public void setSolicitudCreditoParamDAO(SolicitudCreditoParamDAO solicitudCreditoParamDAO) {
        this.solicitudCreditoParamDAO = solicitudCreditoParamDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BaseResponse registrar(HeaderParams headerParams, SolicitudCreditoParamRequest request) throws Exception {
        RegistrarSolicitudCreditoParamProcedure procedureParams = new RegistrarSolicitudCreditoParamProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoParamDAO.registrar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SolicitudCreditoParamResponse listar(HeaderPaginadoParams headerParams, ListaSolicitudCreditoParamRequest request) throws Exception {
        ListarSolicitudCreditoParamProcedure procedureParams = new ListarSolicitudCreditoParamProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoParamDAO.listar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            SolicitudCreditoParamResponse response = new SolicitudCreditoParamResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public FlujoCajaResponse listarFlujoCaja(HeaderPaginadoParams headerParams, FlujoCajaRequest request) throws Exception {
        ListarFlujoCajaProcedure procedureParams = new ListarFlujoCajaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        solicitudCreditoParamDAO.listarFlujoCaja(procedureParams);

        Integer statusQuery = procedureParams.getStatus();

        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)
                || statusQuery.equals(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO)) {
            FlujoCajaResponse response = new FlujoCajaResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

}
