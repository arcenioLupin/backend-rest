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
import pe.com.divemotor.solicitudcredito.dao.VehiculosDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarIndiVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarVehiculosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudVehiculosProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarIndiVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaVehiculosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.VehiculosListadoResponse;
import pe.com.divemotor.solicitudcredito.services.VehiculosService;
import pe.com.divemotor.solicitudcredito.util.Constantes;


/**
 *
 * @author legutierrez
 */
@Service
@Transactional
public class VehiculosServiceImpl implements VehiculosService{
    
    private VehiculosDAO vehiculosDAO;
    private Mapper mapper;

    @Autowired
    public void setVehiculosDAO(VehiculosDAO vehiculosDAO) {
        this.vehiculosDAO = vehiculosDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public VehiculosListadoResponse listar(HeaderPaginadoParams headerParams, ListaVehiculosRequest request) throws Exception {
        
        ListarVehiculosProcedure procedureParams = new ListarVehiculosProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        vehiculosDAO.listar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            VehiculosListadoResponse response = new VehiculosListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse registrar(HeaderParams headerParams, SolicitudVehiculoRequest request) throws Exception {
        RegistrarSolicitudVehiculosProcedure procedureParams = new RegistrarSolicitudVehiculosProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred()!=null? request.getCodSoliCred() : "");
        procedureParams.setCodCia(request.getCodCia()!=null? request.getCodCia() : "");
        procedureParams.setCodProv(request.getCodProv()!=null? request.getCodProv() : "");
        procedureParams.setNumPedidoVeh(request.getNumPedidoVeh()!=null? request.getNumPedidoVeh() : "");
        procedureParams.setRutaVeh(request.getRutaVeh()!=null? request.getRutaVeh() : "");
        procedureParams.setCanAsientos(request.getCanAsientos()!=0? request.getCanAsientos() : 0);
                
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        vehiculosDAO.registrar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodigo());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response; 
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    @Override
    public BaseResponse actualizar(HeaderParams headerParams, ActualizarIndiVehiculoRequest request) throws Exception {
        ActualizarIndiVehiculoProcedure procedureParams = new ActualizarIndiVehiculoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        vehiculosDAO.actualizar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

    
    
    
    
}
