package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarPermisosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudHistoricoProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoCBRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarGestionBancariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarSolicitudCreditoSNRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosCorreoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DatosSolicitudHORequest;
import pe.com.divemotor.solicitudcredito.dto.request.HistoricoOperacionesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaDatosResolucionRequestRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaParamRegSolcreRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaRolesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ListaSolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenEjecutivoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudCreditoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudHistoricoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DatosResolucionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoCBListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DatosSolicitudHOResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ParamRegSolcreListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PermisosListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenEjecutivoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudCreditoSNListadoResponse;
import pe.com.divemotor.generico.dto.Item;
import pe.com.divemotor.solicitudcredito.dto.request.ListarClienteCreditosMovimientosRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteCreditosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ListaClienteMovimientosResponse;

public interface SolicitudCreditoService {

    BaseResponse registrar(HeaderParams headerParams, SolicitudCreditoRequest request) throws Exception;

    SolicitudCreditoListadoResponse listar(HeaderPaginadoParams headerParams, ListaSolicitudCreditoRequest request) throws Exception;

    SolicitudCreditoCBListadoResponse listarSoliCartaBanco(HeaderParams headerParams, String codSoliCred) throws Exception;

    SolicitudCreditoSNListadoResponse listarSoliSuscripNotaria(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    BaseResponse actualizar(HeaderParams headerParams, ActualizarSolicitudCreditoRequest request) throws Exception;

    BaseResponse actualizarGestion(HeaderParams headerParams, ActualizarGestionBancariaRequest request) throws Exception;

    BaseResponse actualizarCartaBanco(HeaderParams headerParams, ActualizarSolicitudCreditoCBRequest request) throws Exception;

    BaseResponse actualizarSoliSuscripNotaria(HeaderParams headerParams, ActualizarSolicitudCreditoSNRequest request) throws Exception;
    
    DatosSolicitudHOResponse listarDatosSolicitudHO(HeaderPaginadoParams headerParams, DatosSolicitudHORequest request) throws Exception;

    DatosResolucionListadoResponse listarDatosSolicitudRC(HeaderPaginadoParams headerParams, ListaDatosResolucionRequestRequest request) throws Exception;
    
    BaseResponse solicitudAprobacion (HeaderParams headerParams, DatosCorreoRequest request) throws Exception;
    
    ResumenEjecutivoResponse listarResumenEjecutivo(HeaderPaginadoParams headerParams, ResumenEjecutivoRequest request) throws Exception;

    ReporteResponse exportarResumenEjecutivo(HeaderParams headerParams, String codSoliCred,String tipSoliCred) throws Exception;
    
    PermisosListadoResponse listarPermisos(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    RolesListadoResponse listarRoles(HeaderPaginadoParams headerParams, ListaRolesRequest request) throws Exception;
    
    BaseResponse registrarSolicitudHistorico (HeaderParams headerParams, SolicitudHistoricoRequest request) throws Exception;
    
    BaseResponse registrarHistoricoOperaciones (HeaderParams headerParams, HistoricoOperacionesRequest request) throws Exception;
    
    BaseResponse obtenerResponsablesSolcre(HeaderParams headerParams, String codSoliCred) throws Exception; //<89783>

    ReporteResponse exportarSeguroTrama(HeaderParams headerParams, String codSoliCred) throws Exception;
    //I Req. 87567 E2.1 ID:9 AVILCA 12/05/2020
    ParamRegSolcreListadoResponse listarParametrosRegistroSolcre(HeaderPaginadoParams headerParams, ListaParamRegSolcreRequest request) throws Exception;    
    //F Req. 87567 E2.1 ID:9 AVILCA 12/05/2020
    
    //I Req. 87567 E2.1 ID:9 AVILCA 10/02/2021
    ListaClienteCreditosResponse listarClienteCreditos(HeaderPaginadoParams headerParams, ListarClienteCreditosMovimientosRequest request) throws Exception;

    ListaClienteMovimientosResponse listarClienteMovimientos(HeaderPaginadoParams headerParams, ListarClienteCreditosMovimientosRequest request) throws Exception;    
    //F Req. 87567 E2.1 ID:9 AVILCA 10/02/2021
    
    
}