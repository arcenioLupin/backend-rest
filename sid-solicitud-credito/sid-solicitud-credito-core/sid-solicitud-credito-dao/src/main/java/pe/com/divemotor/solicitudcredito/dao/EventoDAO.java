package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ListarEstadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.EventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.GenerarPlantillaEventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.InsertarCreditoEventoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosNotariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;

public interface EventoDAO {

    void listar(ListarEventosProcedure parametros);
    
    void insertar(InsertarCreditoEventoProcedure parametros);
    // inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    void listarEventoNotaria(ListarEventosNotariaProcedure parametros);
    
    void registrarEvenNota(EventoNotariaRegistroProcedure parametros);
    
    GenericoResponse generarPlantillaEventoNotariaRegistro(GenerarPlantillaEventoNotariaRegistroProcedure parametros)throws Exception;
    //fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
}
