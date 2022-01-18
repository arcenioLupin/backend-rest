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
import pe.com.divemotor.solicitudcredito.dao.ProyeParamPresuDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ActualizarProyeParamPresuProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ListarProyeParamPresuProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ProyeccionRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProyeccionListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ProyeParamPresuService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class ProyeParamPresuServiceImpl implements ProyeParamPresuService {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private ProyeParamPresuDAO dao;
    private Mapper mapper;

    @Autowired
    public void setDao(ProyeParamPresuDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProyeccionListadoResponse listarProyeccion(HeaderParams headerParams, ProyeccionRequest request) {
        LOGGER.info(":::listarKPIs");
        ListarProyeParamPresuProcedure parametros = mapper.map(headerParams, ListarProyeParamPresuProcedure.class);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        String codTipoVta = request.getCodTipoVta();
        String codAreaVta = request.getCodAreaVta();
        String codZona = request.getCodZona();
        String periodo = request.getAnio();

        ProyeccionListadoResponse response = new ProyeccionListadoResponse();
        try {
            parametros.setCodTipoVta(codTipoVta);
            parametros.setCodAreaVta(codAreaVta);
            parametros.setCodZona(codZona);
            parametros.setPeriodo(periodo);
            dao.listarProyeccion(parametros);

            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());

            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new ProyeccionListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }

    @Override
    public BaseResponse actualizarProyeccion(HeaderParams headerParams, ProyeccionRequest request) throws Exception {
        ActualizarProyeParamPresuProcedure parametros = mapper.map(headerParams, ActualizarProyeParamPresuProcedure.class);

        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        String id = request.getCodigo();
        String codTipoVta = request.getCodTipoVta();
        String codAreaVta = request.getCodAreaVta();
        String codZona = request.getCodZona();
        String anio = request.getAnio();
        String mes = request.getMes();
        String valorReal = request.getValorReal();
        String valorProyectado = request.getValorYTD();
        

        parametros.setId(Long.parseLong(id));
        parametros.setCodTipoVta(codTipoVta);
        parametros.setCodAreaVta(codAreaVta);
        parametros.setCodZona(Long.parseLong(codZona));
        parametros.setAnio(Long.parseLong(anio));
        parametros.setMes(Long.parseLong(mes));
        parametros.setValorReal(Double.parseDouble(valorReal));
        parametros.setValorYTD(Double.parseDouble(valorProyectado));

        dao.actualizarProyeccion(parametros);

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
