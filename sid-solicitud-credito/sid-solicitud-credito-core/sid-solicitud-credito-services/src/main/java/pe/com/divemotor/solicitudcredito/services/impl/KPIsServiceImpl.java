/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.KPIsDAO;
import pe.com.divemotor.solicitudcredito.dominio.KPIs;
import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ActualizarKPIsProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.kpis.ListarKPIsProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.KPIsRequest;
import pe.com.divemotor.solicitudcredito.dto.response.KPIsListadoResponse;
import pe.com.divemotor.solicitudcredito.services.KPIsService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class KPIsServiceImpl implements KPIsService {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private KPIsDAO dao;
    private Mapper mapper;

    @Autowired
    public void setDao(KPIsDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public KPIsListadoResponse listarKPIs(HeaderParams headerParams, KPIsRequest request) throws Exception {
        LOGGER.info(":::listarKPIs");
        ListarKPIsProcedure parametros = mapper.map(headerParams, ListarKPIsProcedure.class);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        String codZona = request.getCodZona();
        String periodo = request.getPeriodo();

        KPIsListadoResponse response = new KPIsListadoResponse();
        try {
            parametros.setCodZona(codZona);
            parametros.setPeriodo(periodo);
            dao.listarKPIs(parametros);

            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());

            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new KPIsListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @Override
    public BaseResponse actualizarKPIs(HeaderParams headerParams, KPIsRequest request) throws Exception {
        ActualizarKPIsProcedure parametros = mapper.map(headerParams, ActualizarKPIsProcedure.class);

        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        for (KPIs kpis: request.getListaKpis()) {
            parametros.setId(Long.parseLong(kpis.getCodKpi()));
            parametros.setDescripcion(kpis.getDesKpi());
            parametros.setValor(Double.parseDouble(kpis.getValKpi()));
            parametros.setPeriodo(Long.parseLong(kpis.getAnio()));
            
            dao.actualizarKPIs(parametros);
            
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

}
