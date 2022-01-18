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
import pe.com.divemotor.solicitudcredito.dao.InformacionSBSDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarInformacionSBSProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarInformacionSBSProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.InformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaInformacionSBSRequest;
import pe.com.divemotor.solicitudcredito.dto.response.InformacionSBSListadoResponse;
import pe.com.divemotor.solicitudcredito.services.InformacionSBSService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author legutierrez
 */

@Service
@Transactional
public class InformacionSBSServiceImpl implements InformacionSBSService{

    private InformacionSBSDAO informacionSBSDAO;
    private Mapper mapper;

    @Autowired
    public void setInformacionSBSDAO(InformacionSBSDAO informacionSBSDAO) {
        this.informacionSBSDAO = informacionSBSDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    
    @Override
    public BaseResponse registrar(HeaderParams headerParams, InformacionSBSRequest request) throws Exception {
        RegistrarInformacionSBSProcedure procedureParams = new RegistrarInformacionSBSProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        informacionSBSDAO.registrar(procedureParams);

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
    public InformacionSBSListadoResponse listar(HeaderPaginadoParams headerParams, ListaInformacionSBSRequest request) throws Exception {
        ListarInformacionSBSProcedure procedureParams = new ListarInformacionSBSProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        informacionSBSDAO.listar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            InformacionSBSListadoResponse response = new InformacionSBSListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
}
