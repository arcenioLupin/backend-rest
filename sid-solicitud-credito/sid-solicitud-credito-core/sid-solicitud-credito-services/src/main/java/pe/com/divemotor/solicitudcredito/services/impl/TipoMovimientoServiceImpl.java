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
import pe.com.divemotor.solicitudcredito.dao.TipoMovimientoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarIndiVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.IsTipoMovimientoOperacionExisteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarIndiVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.IsTipoMovimientoOperacionExisteRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaTipoMovimientoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaVehiculosRequest;
import pe.com.divemotor.solicitudcredito.dto.response.IsTipoMovimientoOperacionExisteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.TipoMovimientoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author eudo.barboza
 */
@Service
@Transactional
public class TipoMovimientoServiceImpl implements TipoMovimientoService {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    private TipoMovimientoDAO tipoMovimientoDAO;
    private Mapper mapper;
    
    @Autowired
    public void setTipoMovimientoDAO(TipoMovimientoDAO tipoMovimientoDAO) {
        this.tipoMovimientoDAO = tipoMovimientoDAO;
    }
    
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    
    @Transactional(readOnly = true)
    @Override
    public TipoMovimientoListadoResponse listar(HeaderPaginadoParams headerParams, ListaTipoMovimientoRequest request) throws Exception {
        
        ListarTipoMovimientoProcedure procedureParams = new ListarTipoMovimientoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        tipoMovimientoDAO.listar(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            TipoMovimientoListadoResponse response = new TipoMovimientoListadoResponse();
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
    public TipoMovimientoListadoResponse listarTodos(HeaderPaginadoParams headerParams) throws Exception {
        
        ListarTipoMovimientoProcedure procedureParams = new ListarTipoMovimientoProcedure();
        mapper.map(headerParams, procedureParams);
      
        tipoMovimientoDAO.listarTodos(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            TipoMovimientoListadoResponse response = new TipoMovimientoListadoResponse();
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
    public IsTipoMovimientoOperacionExisteResponse IsTipoMovimientoOperacionExiste(HeaderPaginadoParams headerParams, IsTipoMovimientoOperacionExisteRequest request) throws Exception {
       IsTipoMovimientoOperacionExisteProcedure procedureParams = new IsTipoMovimientoOperacionExisteProcedure();
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        //mapper.map(headerParams, procedureParams);
      
        tipoMovimientoDAO.IsTipoMovimientoOperacionExiste(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            IsTipoMovimientoOperacionExisteResponse response = new IsTipoMovimientoOperacionExisteResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
    @Override
    public BaseResponse actualizarTipoMovimiento(HeaderParams headerParams, ActualizarTipoMovimientoRequest request) throws Exception {
        ActualizarTipoMovimientoProcedure parametros = mapper.map(headerParams, ActualizarTipoMovimientoProcedure.class);

        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        
            
        Integer CodTipoMov = request.getCodTipoMov();
        String CodUsuaModi = request.getCodUsuaModi();
        String CodUsuaRegi = request.getCodUsuaRegi();
        String FecCreaRegi = request.getFecCreaRegi();
        String IndInactivo = request.getIndInactivo();
        String IndNatuTipoMovi = request.getIndNatuTipoMovi();
        String TxtDescTipoMovi = request.getTxtDescTipoMovi();
        
           
        parametros.setCodTipoMov(CodTipoMov);
        parametros.setCodUsuaModi(CodUsuaModi);
        parametros.setCodUsuaRegi(CodUsuaRegi);
        parametros.setFecCreaRegi(FecCreaRegi);
        parametros.setIndInactivo(IndInactivo);
        parametros.setIndNatuTipoMovi(IndNatuTipoMovi);
        parametros.setTxtDescTipoMovi(TxtDescTipoMovi);
       
        tipoMovimientoDAO.actualizarTipoMovimiento(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    
}
