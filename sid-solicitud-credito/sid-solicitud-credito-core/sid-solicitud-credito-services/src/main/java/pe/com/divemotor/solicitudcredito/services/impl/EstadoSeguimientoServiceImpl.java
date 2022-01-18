package pe.com.divemotor.solicitudcredito.services.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.divemotor.solicitudcredito.dao.EstadoSeguimientoDAO;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ActualizarEstadoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ListarEstadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.AutorizacionExcepcionalActualizarEstadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EstadoSeguimientoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.EstadoSeguimientoService;
import pe.com.divemotor.generico.dto.HeaderParams;

@Service
@Transactional
public class EstadoSeguimientoServiceImpl implements EstadoSeguimientoService {

    private EstadoSeguimientoDAO estadoSeguimientoDAO;
    private Mapper mapper;

    @Transactional(readOnly = true)
    @Override
    public EstadoSeguimientoListadoResponse listarEstados(HeaderParams headerParams) throws Exception {

        ListarEstadosProcedure parametros = mapper.map(headerParams, ListarEstadosProcedure.class);

        estadoSeguimientoDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EstadoSeguimientoListadoResponse response = new EstadoSeguimientoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }

    @Override
    public BaseResponse actualizarEstado(HeaderParams headerParams, AutorizacionExcepcionalActualizarEstadoRequest request) throws Exception {
        ActualizarEstadoProcedure procedureParams = new ActualizarEstadoProcedure();
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        estadoSeguimientoDAO.actualizarEstado(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setEstadoSeguimientoDAO(EstadoSeguimientoDAO estadoSeguimientoDAO) {
        this.estadoSeguimientoDAO = estadoSeguimientoDAO;
    }

}
