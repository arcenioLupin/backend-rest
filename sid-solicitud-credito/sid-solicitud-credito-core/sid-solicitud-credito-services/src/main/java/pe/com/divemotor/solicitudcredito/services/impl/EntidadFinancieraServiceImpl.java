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
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.EntidadFinancieraDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.cartabanco.ListarEntidadFinancieraProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.EntidadFinancieraListadoResponse;
import pe.com.divemotor.solicitudcredito.services.EntidadFinancieraService;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class EntidadFinancieraServiceImpl implements EntidadFinancieraService {

    private EntidadFinancieraDAO entidadFinancieraDAO;
    private Mapper mapper;

    @Autowired
    public void setEntidadFinancieraDAO(EntidadFinancieraDAO entidadFinancieraDAO) {
        this.entidadFinancieraDAO = entidadFinancieraDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EntidadFinancieraListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception {
        ListarEntidadFinancieraProcedure parametros = mapper.map(headerParams, ListarEntidadFinancieraProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.entidadFinancieraDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EntidadFinancieraListadoResponse response = new EntidadFinancieraListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

}
