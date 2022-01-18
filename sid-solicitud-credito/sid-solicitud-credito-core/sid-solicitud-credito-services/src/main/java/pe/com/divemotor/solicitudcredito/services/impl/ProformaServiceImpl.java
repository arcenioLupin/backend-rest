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
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dao.ProformaDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarProformaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ListaProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ProformaService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

@Service
@Transactional
public class ProformaServiceImpl implements ProformaService{

    private ProformaDAO proformaDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    
    @Autowired
    public void setProformaDAO(ProformaDAO proformaDAO) {
        this.proformaDAO = proformaDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public ProformaListadoResponse listar(HeaderPaginadoParams headerParams, ListaProformaRequest request) throws Exception {
        
        ListarProformaProcedure procedureParams = new ListarProformaProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        proformaDAO.listar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            ProformaListadoResponse response = new ProformaListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
}
