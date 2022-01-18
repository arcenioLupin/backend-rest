package pe.com.divemotor.solicitudcredito.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.SolicitudCreditoDAO;
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
import pe.com.divemotor.solicitudcredito.mapper.SolicitudCreditoMapper;

@Repository
public class SolicitudCreditoDAOImpl implements SolicitudCreditoDAO {

    SolicitudCreditoMapper solicitudCreditoMapper;

    @Autowired
    public void setSoliicitudCreditoMapper(SolicitudCreditoMapper soliicitudCreditoMapper) {
        this.solicitudCreditoMapper = soliicitudCreditoMapper;
    }

    @Override
    public void registrar(RegistrarProcedure parametros) {
        solicitudCreditoMapper.registrar(parametros);
    }

    @Override
    public void listar(ListarSolicitudCreditoProcedure parametros) {
        solicitudCreditoMapper.listar(parametros);
    }

    @Override
    public void listarSoliCartaBanco(ListarSolicitudCreditoCBProcedure parametros) {
        solicitudCreditoMapper.listarSoliCartaBanco(parametros);
    }
    
    @Override
    public void listarSoliSuscripNotaria(ListarSolicitudCreditoSNProcedure parametros) {
        solicitudCreditoMapper.listarSoliSuscripNotaria(parametros);
    }
    
    @Override
    public void actualizar(ActualizarSolicitudCreditoProcedure parametros) {
        solicitudCreditoMapper.actualizar(parametros);
    }

    @Override
    public void actualiarGestionBancaria(ActualizarGestionBancaria parametros) {
        solicitudCreditoMapper.actualizarGestionBancaria(parametros);
    }

    @Override
    public void actualizarCartaBanco(ActualizarSolicitudCreditoCBProcedure parametros) {
        solicitudCreditoMapper.actualizarCartaBanco(parametros);
    }
    
    @Override
    public void actualizarSoliSuscripNotaria(ActualizarSolicitudCreditoSNProcedure parametros) {
        solicitudCreditoMapper.actualizarSoliSuscripNotaria(parametros);
    }
    
    @Override
    public void listarDatosSolicitudHO(ListarDatosSolicitudHOProcedure parametros) {
        solicitudCreditoMapper.listarDatosSolicitudHO(parametros);
    }

    @Override
    public void listarDatosSolicitudRC(ListarDatosResolucionCreditosProcedure parametros) {
        solicitudCreditoMapper.listarDatosSolicitudRC(parametros);
    }

    @Override
    public void listarResumenEjecutivo(ListarResumenEjecutivoProcedure parametros) {
        solicitudCreditoMapper.listarResumenEjecutivo(parametros);
    }

    @Override
    public void listarPermisos(ListarPermisosProcedure parametros) {
        solicitudCreditoMapper.listarPermisos(parametros);
    }

    @Override
    public void listarRoles(ListarRolesProcedure parametros) {
        solicitudCreditoMapper.listarRoles(parametros);
    }

    @Override
    public void registrarSolicitudHistorico(RegistrarSolicitudHistoricoProcedure parametros) {
       solicitudCreditoMapper.registrarSolicitudHistorico(parametros);
    }

    @Override
    public void registrarHistoricoOperaciones(RegistrarHistoricoOperacionesProcedure parametros) {
        solicitudCreditoMapper.registrarHistoricoOperaciones(parametros);
    }

    //<I-89783>
    @Override
    public void obtenerResponsablesSolcre(ObtenerResponsableSolcreProcedure parametros) {
         solicitudCreditoMapper.obtenerResponsablesSolcre(parametros);
    }
    //<F-89783>
    //I Req. 87567 E2.1 ID:9 AVILCA 12/05/2020
    @Override
    public void listarParametrosRegistroSolcre(ListarParamRegSolcreProcedure parametros) {
        solicitudCreditoMapper.listarParametrosRegistroSolcre(parametros);
    }
   //F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020   
    
   //I Req. 87567 E2.1 ID:9 AVILCA 10/02/2021
    @Override
    public void listarClienteCreditos(ListarClienteCreditoProcedure parametros) {
        solicitudCreditoMapper.listarClienteCreditos(parametros);
    }
    
    @Override
    public void listarClienteMovimientos(ListarClienteMovimientoProcedure parametros) {
        solicitudCreditoMapper.listarClienteMovimientos(parametros);
    }
   //F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020 
}
