package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.ActividadEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividaTipoCredProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividadProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadAllProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesPorTipoCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesProcedure;

public interface ActividadMapper {

    void listar(ListarActividadesProcedure parametros);
    //InicioReq. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    void listarActividadesEtapa(ListarActividadesEtapaProcedure parametros);
    
    void listarActividadesEtapaAll(ListarActividadAllProcedure parametros);

    public void crearActividaEtapa(ActividadEtapaProcedure parametros);
    
    public void actualizarActividad(ActualizarActividadProcedure parametros);
    
    public void actualizarActividadTipoCred(ActualizarActividaTipoCredProcedure parametros);
    
    // BUSQUEDA DE ACTIVIDADES POR TIPO DE CREDITO
    void listarActividadesPorTipoCredito(ListarActividadesPorTipoCreditoProcedure parametros);
    
}//Fin Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
