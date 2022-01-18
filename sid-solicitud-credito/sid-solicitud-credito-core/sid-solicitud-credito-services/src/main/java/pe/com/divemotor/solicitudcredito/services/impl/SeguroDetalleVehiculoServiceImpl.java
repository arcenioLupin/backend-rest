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
import pe.com.divemotor.solicitudcredito.dao.SeguroDetalleVehiculoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroDetalleVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.SeguroDetalleVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.SeguroDetalleVehiculoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.SeguroDetalleVehiculoService;

/**
 *
 * @author Mgrasso
 */
@Service
@Transactional
public class SeguroDetalleVehiculoServiceImpl implements SeguroDetalleVehiculoService{
    private SeguroDetalleVehiculoDAO seguroDetalleVehiculoDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSeguroDetalleVehiculoDAO(SeguroDetalleVehiculoDAO seguroDetalleVehiculoDAO) {
        this.seguroDetalleVehiculoDAO = seguroDetalleVehiculoDAO;
    }
    
    @Transactional(readOnly = true)
    @Override
    public SeguroDetalleVehiculoListadoResponse listar(HeaderPaginadoParams headerParams, SeguroDetalleVehiculoRequest request) throws Exception {
        ListarSeguroDetalleVehiculoProcedure parametros = mapper.map(headerParams, ListarSeguroDetalleVehiculoProcedure.class);
        parametros.setCodSoliCred(request.getCodSoliCred());
        this.seguroDetalleVehiculoDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            SeguroDetalleVehiculoListadoResponse response = new SeguroDetalleVehiculoListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());  
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    
    }
    
}
