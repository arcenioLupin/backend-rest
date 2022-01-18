package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dto.procedure.evento.InsertarCreditoEventoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosProcedure;
import pe.com.divemotor.solicitudcredito.mapper.EventoMapper;
import pe.com.divemotor.solicitudcredito.dao.EventoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.EventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.GenerarPlantillaEventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosNotariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;

@Repository("eventoDAO")
public class EventoDAOImpl implements EventoDAO {

    private EventoMapper eventoMapper;

    @Autowired
    public void setEventoMapper(EventoMapper eventoMapper) {
        this.eventoMapper = eventoMapper;
    }

    @Override
    public void listar(ListarEventosProcedure parametros) {
        eventoMapper.listar(parametros);
    }
    
    @Override
    public void insertar(InsertarCreditoEventoProcedure parametros) {
        eventoMapper.insertar(parametros);
    }
    //inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    @Override
    public void listarEventoNotaria(ListarEventosNotariaProcedure parametros) {
       eventoMapper.listarEventoNotaria(parametros); 
    }
    
    @Override
    public void registrarEvenNota(EventoNotariaRegistroProcedure parametros) {
       eventoMapper.registrarEvenNota(parametros); 
    }

    @Override
    public GenericoResponse generarPlantillaEventoNotariaRegistro(GenerarPlantillaEventoNotariaRegistroProcedure parametros) throws Exception{
        eventoMapper.generarPlantillaEventoNotariaRegistro(parametros); 
          int statusQuery = parametros.getStatus();
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(parametros.getMensaje());
            response.setCodigo(parametros.getCodigo());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }
    //fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    
}