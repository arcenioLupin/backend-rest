package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoCBProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarGestionBancaria;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDatosResolucionCreditosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudCreditoSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarClienteCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarClienteMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoCBProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDatosSolicitudHOProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarParamRegSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarPermisosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarResumenEjecutivoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarRolesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ObtenerResponsableSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarHistoricoOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudHistoricoProcedure;

public interface SolicitudCreditoMapper {

    void registrar(RegistrarProcedure parametros);

    void listar(ListarSolicitudCreditoProcedure parametros);

    void listarSoliCartaBanco(ListarSolicitudCreditoCBProcedure parametros);

    public void listarSoliSuscripNotaria(ListarSolicitudCreditoSNProcedure parametros);
    
    void actualizar(ActualizarSolicitudCreditoProcedure parametros);

    void actualizarGestionBancaria(ActualizarGestionBancaria parametros);

    void actualizarCartaBanco(ActualizarSolicitudCreditoCBProcedure parametros);

    public void actualizarSoliSuscripNotaria(ActualizarSolicitudCreditoSNProcedure parametros);
    
    void listarDatosSolicitudHO(ListarDatosSolicitudHOProcedure parametros);

    void listarDatosSolicitudRC(ListarDatosResolucionCreditosProcedure parametros);
    
    void listarResumenEjecutivo(ListarResumenEjecutivoProcedure parametros);
    
    void listarPermisos(ListarPermisosProcedure parametros);
    
    void listarRoles(ListarRolesProcedure parametros);
    
    void registrarSolicitudHistorico (RegistrarSolicitudHistoricoProcedure parametros);
    
    void registrarHistoricoOperaciones (RegistrarHistoricoOperacionesProcedure parametros);
   
    void obtenerResponsablesSolcre (ObtenerResponsableSolcreProcedure parametros);//<89783>
 
    void listarParametrosRegistroSolcre(ListarParamRegSolcreProcedure parametros);//Req. 87567 E2.1 ID:9 AVILCA 12/05/2020
    
    void listarClienteCreditos(ListarClienteCreditoProcedure parametros);//Req. 87567 E2.1 ID:9 AVILCA 10/02/2021

    void listarClienteMovimientos(ListarClienteMovimientoProcedure parametros);//Req. 87567 E2.1 ID:9 AVILCA 10/02/2021
}
