package pe.com.divemotor.solicitudcredito.services.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.ActividadDAO;
import pe.com.divemotor.solicitudcredito.dominio.ActividadAll;
import pe.com.divemotor.solicitudcredito.dominio.ActividadEtapa;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActividadEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividaTipoCredProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividadProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadAllProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesPorTipoCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.DocumentoService;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActividadEtapaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividaTipoCreddRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividadRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadAllListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadEtapaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadPorTipoCreditoResponse;
import pe.com.divemotor.solicitudcredito.services.ActividadService;
import pe.com.divemotor.solicitudcredito.util.Util;

@Service
@Transactional
public class ActividadServiceImpl implements ActividadService {

    private ActividadDAO actividadDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setActividadDAO(ActividadDAO actividadDAO) {
        this.actividadDAO = actividadDAO;
    }
    
    @Transactional(readOnly = true)
    @Override
    public ActividadListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception {
		
        ListarActividadesProcedure parametros = mapper.map(headerParams, ListarActividadesProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.actividadDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ActividadListadoResponse response = new ActividadListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setActActual(parametros.getActActual());
            response.setActSiguiente(parametros.getActSiguiente());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }

    @Override
    public ActividadEtapaListadoResponse listarActividadesEtapa(HeaderParams headerParams, String codActividad, String codEtapa) throws Exception {
        ListarActividadesEtapaProcedure parametros = mapper.map(headerParams, ListarActividadesEtapaProcedure.class);
        parametros.setCodActividad(codActividad);
        parametros.setCodEtapa(codEtapa);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.actividadDAO.listarActividadesEtapa(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ActividadEtapaListadoResponse response = new ActividadEtapaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setActActual(parametros.getActActual());
            response.setActSiguiente(parametros.getActSiguiente());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public ActividadAllListadoResponse listarActividadesEtapaAll(HeaderParams headerParams) throws Exception {
        ListarActividadAllProcedure parametros = mapper.map(headerParams, ListarActividadAllProcedure.class);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.actividadDAO.listarActividadesEtapaAll(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ActividadAllListadoResponse response = new ActividadAllListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setActActual(parametros.getActActual());
            response.setActSiguiente(parametros.getActSiguiente());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public BaseResponse crearActividaEtapa(HeaderParams headerParams, ActividadEtapaRequest request) throws Exception {
        ActividadEtapaProcedure procedureParams = new ActividadEtapaProcedure();
       
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        
        this.actividadDAO.crearActividaEtapa(procedureParams);

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
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public BaseResponse actualizarActividad(HeaderParams headerParams, ActualizarActividadRequest request) throws Exception {
       ActualizarActividadProcedure procedureParams = new ActualizarActividadProcedure();
       
        mapper.map(headerParams, procedureParams);
        //mapper.map(request, procedureParams);
       
                 if(request.getLongitudLista() > 0)
            for(ActividadAll actividad : request.getListaActividad()){
                procedureParams.setCodActiCred(actividad.getCodActiCred());
                procedureParams.setNumOrden(actividad.getNumOrden());
                procedureParams.setCodEtapCred(actividad.getCodEtapCred());
                procedureParams.setDesActiCred(actividad.getDesActiCred());
                procedureParams.setIndInactivo(actividad.getIndInactivo());
                procedureParams.setCodEstadoSoli(actividad.getCodEstadoSoli());
                procedureParams.setCodUsuaModiRegi(headerParams.getCodUsuario());
                this.actividadDAO.actualizarActividad(procedureParams);
            }
             
      
                
       

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
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public BaseResponse actualizarActividadTipoCred(HeaderParams headerParams, ActualizarActividaTipoCreddRequest request) throws Exception {
        ActualizarActividaTipoCredProcedure procedureParams = new ActualizarActividaTipoCredProcedure();
        mapper.map(headerParams, procedureParams);
        if(request.getLongitudListActividadTipo() > 0){
            for(ActividadEtapa actiTipoCred: request.getListaActividadEtapa()){
                if(actiTipoCred.getCodActiCred() != null){
               procedureParams.setCodActiCred(actiTipoCred.getCodActiCred());
               procedureParams.setCodTipo(actiTipoCred.getCodTipo());
               procedureParams.setAsignar(actiTipoCred.getAsignar());
               procedureParams.setOblig(actiTipoCred.getOblig());
               procedureParams.setCodUsuario(headerParams.getCodUsuario());
                this.actividadDAO.actualizarActividadTipoCred(procedureParams);
            }
              }
        }
         
        
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

    @Override
    public ActividadPorTipoCreditoResponse listarActividadPorTipoCredito(HeaderParams headerParams, String codActividad, String codEtapa, String codTipoCredito) throws Exception {
        ListarActividadesPorTipoCreditoProcedure parametros = mapper.map(headerParams, ListarActividadesPorTipoCreditoProcedure.class);
        parametros.setCodActividad(codActividad);
        parametros.setCodEtapa(codEtapa);
        parametros.setCodTipoCredito(codTipoCredito);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.actividadDAO.listarActividadesPorTipoCredito(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ActividadPorTipoCreditoResponse response = new ActividadPorTipoCreditoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }
    
}
