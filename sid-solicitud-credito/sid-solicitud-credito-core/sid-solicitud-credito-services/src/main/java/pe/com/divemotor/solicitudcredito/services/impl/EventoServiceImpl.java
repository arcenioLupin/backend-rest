package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.InsertarCreditoEventoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.EventoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EventoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.services.EventoService;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.solicitudcredito.util.Util;
import pe.com.divemotor.solicitudcredito.dao.EventoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.EventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosNotariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRegistroRequest;
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EventoNotariaListadoResponse;

@Service
@Transactional
public class EventoServiceImpl implements EventoService {

    private EventoDAO eventoDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    @Resource(name = "mailServices")
    MailServices mailServices;

    @Transactional(readOnly = true)
    @Override
    public EventoListadoResponse listarEventos(HeaderParams headerParams, String codSoliCred, String fecItemEvenIni, String fecItemEvenFin, int pagina, int cantidadxPagina) throws Exception {

        ListarEventosProcedure parametros = mapper.map(headerParams, ListarEventosProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setFecItemEvenIni(fecItemEvenIni);
        parametros.setFecItemEvenFin(fecItemEvenFin);
        Map<String, Integer> limites = Util.determinarLimites(pagina, cantidadxPagina);
        parametros.setLiminf(limites.get("liminf"));
        parametros.setLimsup(limites.get("limsup"));
        parametros.setIndPaginado("S");

        this.eventoDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EventoListadoResponse response = new EventoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setCantidad(parametros.getRetCantidad());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }

    @Override
    public BaseResponse insertar(HeaderParams headerParams, EventoRequest request) throws Exception {
        InsertarCreditoEventoProcedure procedureParams = new InsertarCreditoEventoProcedure();
        procedureParams.setListCodUsu(Util.ListToString(request.getListDestinatarios()));
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        eventoDAO.insertar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            this.enviarCorreo(procedureParams);
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setCodigo(procedureParams.getCodItemEven().toString());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }

    }

    private GenericoResponse enviarCorreo(InsertarCreditoEventoProcedure procedureParams) throws Exception {
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;

        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codColaborador", procedureParams.getListCodUsu());
        parametrosEmail.put("idUsuario", procedureParams.getIdUsuario());
        parametrosEmail.put("asunto", procedureParams.getTxtAsun());
        parametrosEmail.put("cuerpo", procedureParams.getTxtComen());
        genericoResponse = mailServices.envioCorreos(parametrosEmail, "0");

        return genericoResponse;
    }
    // inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    private GenericoResponse enviarCorreoEventNota(EventoNotariaRegistroProcedure procedureParams) throws Exception {
        Map parametrosEmail = new HashMap();
        GenericoResponse genericoResponse = null;

        parametrosEmail.put("codSoliCred", procedureParams.getCodSoliCred());
        parametrosEmail.put("codOperRel", procedureParams.getCodOperRel());
        parametrosEmail.put("idUsuario", procedureParams.getIdUsuario());
        parametrosEmail.put("codUsuario", procedureParams.getCodUsuario());
        genericoResponse = mailServices.envioCorreos(parametrosEmail, "ENR");

        return genericoResponse;
    }
    
    public EventoNotariaListadoResponse listarEventoNotaria(HeaderParams headerParams,EventoNotariaRequest request)throws Exception{
        
        ListarEventosNotariaProcedure parametros = mapper.map(headerParams, ListarEventosNotariaProcedure.class);
        
        parametros.setCodOperRel(request.getCodOperRel());
        this.eventoDAO.listarEventoNotaria(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EventoNotariaListadoResponse  response = new EventoNotariaListadoResponse ();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
           
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    
    @Override
    public BaseResponse registrarEvenNota(HeaderParams headerParams, EventoNotariaRegistroRequest request) throws Exception {
        EventoNotariaRegistroProcedure procedureParams = new EventoNotariaRegistroProcedure();
       // procedureParams.setListCodUsu(Util.ListToString(request.getListDestinatarios()));
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        eventoDAO.registrarEvenNota(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            this.enviarCorreoEventNota(procedureParams);
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
           // response.setCodigo(procedureParams.getCodItemEven().toString());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }

    }
    // fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
}
