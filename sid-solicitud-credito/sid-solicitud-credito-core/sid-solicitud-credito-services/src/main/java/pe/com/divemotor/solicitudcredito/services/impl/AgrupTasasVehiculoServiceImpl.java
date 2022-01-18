/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.AgrupTasasVehiculoDAO;
import pe.com.divemotor.solicitudcredito.dominio.AgrupTasasVehiculo;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ActualizarAgrupTasasVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoDetProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo.ListarAgrupTasasVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.AgrupTasasVehiculoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AgrupTasasVehiculoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.AgrupTasasVehiculoService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class AgrupTasasVehiculoServiceImpl implements AgrupTasasVehiculoService {

    private AgrupTasasVehiculoDAO dao;
    private Mapper mapper;

    @Autowired
    public void setDao(AgrupTasasVehiculoDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AgrupTasasVehiculoListadoResponse listarAgrupaciones(HeaderPaginadoParams headerParams, AgrupTasasVehiculoRequest request) throws Exception {
        ListarAgrupTasasVehiculoProcedure parametros1 = mapper.map(headerParams, ListarAgrupTasasVehiculoProcedure.class);
        ListarAgrupTasasVehiculoDetProcedure parametros2 = mapper.map(headerParams, ListarAgrupTasasVehiculoDetProcedure.class);
        Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
        parametros1.setLiminf(limites.get("liminf"));
        parametros1.setLimsup(limites.get("limsup"));

        String codCia = request.getCodCia();
        parametros1.setCodCia(codCia);

        List<AgrupTasasVehiculo> listaAgrupacion = new ArrayList<>();

        dao.listarAgrupaciones(parametros1);

        if (parametros1.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
            AgrupTasasVehiculoListadoResponse response = new AgrupTasasVehiculoListadoResponse();

            if (parametros1.getBusqueda() != null && parametros1.getBusqueda().size() > 0) {
                for (AgrupTasasVehiculo agrup : parametros1.getBusqueda()) {
                    parametros2.setCodAgruVeh(agrup.getCodAgruVeh());
                    dao.listarAgrupacionesDetail(parametros2);
                    if (parametros2.getBusqueda() != null && parametros2.getBusqueda().size() > 0) {
                        agrup.setListaTipoVehi(parametros2.getBusqueda());
                    }
                    listaAgrupacion.add(agrup);
                }
            }
            response.setEstadoTrama(String.valueOf(parametros1.getStatus()));
            response.setMensaje(parametros1.getMensaje());
            response.setListado(listaAgrupacion);
            response.setCantidad(parametros1.getCantidad());
            int numerodePaginas = Util.determinarNroPaginas(response.getCantidad(), headerParams.getCantidadxPag());
            response.setCantidadPaginas(numerodePaginas);
            return response;
        } else {
            throw new Exception(parametros1.getMensaje());
        }

    }

    @Override
    public AgrupTasasVehiculoListadoResponse listarAgrupacionesDetail(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseResponse actualizarAgrupacion(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception {
        ActualizarAgrupTasasVehiculoProcedure parametros = new ActualizarAgrupTasasVehiculoProcedure();
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        dao.actualizarAgrupaciones(parametros);

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
    
    @Override
    public BaseResponse actualizarAgrupacionDetalle(HeaderParams headerParams, AgrupTasasVehiculoRequest request) throws Exception {
        ActualizarAgrupTasasVehiculoProcedure parametros = new ActualizarAgrupTasasVehiculoProcedure();
        mapper.map(headerParams, parametros);
        mapper.map(request, parametros);
        dao.actualizarAgrupacionesDetalle(parametros);

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
