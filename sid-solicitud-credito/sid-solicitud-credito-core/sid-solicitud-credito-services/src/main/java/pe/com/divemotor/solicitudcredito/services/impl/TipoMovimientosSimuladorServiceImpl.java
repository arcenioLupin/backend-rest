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
import pe.com.divemotor.solicitudcredito.dao.TipoMovimientosSimuladorDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTipoMovimientosSimuladorProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSimuladorTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListarTipoMovimientosSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.response.TipoMovimientosSimuladorListadoResponse;
import pe.com.divemotor.solicitudcredito.services.TipoMovimientosSimuladorService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author ebarboza
 */
@Service
@Transactional
public class TipoMovimientosSimuladorServiceImpl implements TipoMovimientosSimuladorService {

    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    private TipoMovimientosSimuladorDAO tipoMovimientosSimuladorDAO;
    private Mapper mapper;

    @Autowired
    public void setTipoMovimientosSimuladorDAO(TipoMovimientosSimuladorDAO tipoMovimientosSimuladorDAO) {
        this.tipoMovimientosSimuladorDAO = tipoMovimientosSimuladorDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BaseResponse actualizarTipoMovimientosSimulador(HeaderParams headerParams, ActualizarTipoMovimientosSimuladorRequest request) throws Exception {
        RegistrarSimuladorTipoMovimientoProcedure parametros = mapper.map(headerParams, RegistrarSimuladorTipoMovimientoProcedure.class);

        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        int codIdSoliTipm = request.getCodIdSoliTipm() > 0 ? request.getCodIdSoliTipm() : 0;
        int codTipoMoviPago = request.getCodTipoMoviPago() > 0 ? request.getCodTipoMoviPago() : 0;
        int valMontoPago = request.getValMontoPago() > 0 ? request.getValMontoPago() : 0;
        parametros.setCodIdSoliTipm(codIdSoliTipm);
        parametros.setCodSoliCred(request.getCodSoliCred() == null ? null : request.getCodSoliCred());
        parametros.setCodTipoMoviPago(codTipoMoviPago);
        parametros.setFecMoviPago(request.getFecMoviPago() == null ? null : request.getFecMoviPago());
        parametros.setCodBanco(request.getCodBanco() == null ? null : request.getCodBanco());
        parametros.setCodMoneda(request.getCodMoneda() == null ? null : request.getCodMoneda());
        parametros.setValMontoPago(valMontoPago);
        parametros.setTxtNroDocumento(request.getTxtNroDocumento() == null ? null : request.getTxtNroDocumento());
        parametros.setIndInactivo(request.getIndInactivo() == null ? null : request.getIndInactivo());
        parametros.setIndTipoDocu(request.getIndTipoDocu() == null ? null : request.getIndTipoDocu());
        parametros.setCodEmpresaCargo(request.getCodEmpresaCargo() == null ? null : request.getCodEmpresaCargo());
        parametros.setFecCreaRegi(request.getFecCreaRegi() == null ? null : request.getFecCreaRegi());
        parametros.setCodUsuaCreaRegi(request.getCodUsuaCreaRegi() == null ? null : request.getCodUsuaCreaRegi());
        parametros.setFecModiRegi(request.getFecModiRegi() == null ? null : request.getFecModiRegi());
        parametros.setCodUsuaModiRegi(request.getCodUsuaModiRegi() == null ? null : request.getCodUsuaModiRegi());

        try {
            tipoMovimientosSimuladorDAO.actualizarTipoMovimientosSimulador(parametros);
        } catch (Exception e) {
            System.out.println(e);
        }

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
    
    @Transactional(readOnly = true)
    @Override
    public TipoMovimientosSimuladorListadoResponse listarPorCodSoliCred(HeaderPaginadoParams headerParams, ListarTipoMovimientosSimuladorRequest request) throws Exception {
        
        ListarTipoMovimientosSimuladorProcedure procedureParams = new ListarTipoMovimientosSimuladorProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        
        tipoMovimientosSimuladorDAO.listarPorCodSoliCred(procedureParams);
        
        Integer statusQuery = procedureParams.getStatus();
        
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)){
            TipoMovimientosSimuladorListadoResponse response = new TipoMovimientosSimuladorListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }

}

