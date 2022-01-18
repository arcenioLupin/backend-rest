package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.evento.EventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.GenerarPlantillaEventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.InsertarCreditoEventoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosNotariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.ListarEventosProcedure;

public interface EventoMapper {

    void listar(ListarEventosProcedure parametros);
    
    void insertar(InsertarCreditoEventoProcedure parametros);
    // inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    void listarEventoNotaria(ListarEventosNotariaProcedure parametros);
    
    public void registrarEvenNota(EventoNotariaRegistroProcedure parametros);
    
    public void generarPlantillaEventoNotariaRegistro(GenerarPlantillaEventoNotariaRegistroProcedure parametros);
    // fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
}
