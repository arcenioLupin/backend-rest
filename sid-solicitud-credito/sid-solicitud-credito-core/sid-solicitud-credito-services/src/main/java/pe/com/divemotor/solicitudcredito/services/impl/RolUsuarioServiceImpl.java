/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.RolUsuarioDAO;
import pe.com.divemotor.solicitudcredito.dominio.RevisionPoderes;
import pe.com.divemotor.solicitudcredito.dominio.RolUsuarioJerarquia;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionEmpresaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarPersonasFacultadasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.RegistrarRolesUsuariosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolDatosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolUsuarioProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesPorUsuarioProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarUsuariosPorRolProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.JefesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.LegalRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioJerarquiaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioRegistraRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolesJefesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolesPorUsuarioRequest;
import pe.com.divemotor.solicitudcredito.dto.response.JefesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RevisionPoderesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioJerarquiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolesPorUsuarioListadoResponse;
import pe.com.divemotor.solicitudcredito.services.RolUsuarioService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author USER
 */
@Service
@Transactional
public class RolUsuarioServiceImpl implements RolUsuarioService {
    
 private final Logger LOGGER = Logger.getLogger(getClass()); 
 private RolUsuarioDAO rolUsuarioDAO;
 private Mapper mapper;
 
 
    @Autowired
    public void setRolUsuarioDAO(RolUsuarioDAO rolUsuarioDAO) {
        this.rolUsuarioDAO = rolUsuarioDAO;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
 
    
    @Override
    public RolUsuarioListadoResponse listarRolUsuario(HeaderParams headerParams, RolUsuarioRequest request) {
        LOGGER.info(":::listarRolUsuarios");
        ListarRolUsuarioProcedure parametros = mapper.map(headerParams, ListarRolUsuarioProcedure.class);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        
        String codAreaVta = request.getCodAreaVta();
        String codFilial = request.getCodFilial();
        String codSucursal = request.getCodSucursal();

        RolUsuarioListadoResponse response = new RolUsuarioListadoResponse();
        try {
            parametros.setCodAreaVta(codAreaVta);
            parametros.setCodFilial(codFilial);
            parametros.setCodSucursal(codSucursal);
            rolUsuarioDAO.listarRolUsuario(parametros);

            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());

            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new RolUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
    }    
 
 @Override
 public RolesPorUsuarioListadoResponse listarRolesPorUsuario (HeaderParams headerParams,RolesPorUsuarioRequest request){
    
     LOGGER.info(":::listarRolUsuarios");
     ListarRolesPorUsuarioProcedure parametros = mapper.map(headerParams, ListarRolesPorUsuarioProcedure.class);
     parametros.setCodUsuario(headerParams.getCodUsuario());
     parametros.setIdUsuario(headerParams.getIdUsuario());
     
     String nomUsuario = request.getNomUsuario();
     RolesPorUsuarioListadoResponse response = new RolesPorUsuarioListadoResponse();
        try {
            parametros.setNomUsuario(nomUsuario);
            rolUsuarioDAO.listarRolesPorUsuario(parametros);
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());
            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new RolesPorUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
   
 }
 
@Override
 public  RolesPorUsuarioListadoResponse listarRolesJefes (HeaderParams headerParams,RolesJefesRequest request){
    
     LOGGER.info(":::listarRolesJefes");
     ListarRolesJefesProcedure parametros = mapper.map(headerParams, ListarRolesJefesProcedure.class);
     parametros.setCodUsuario(headerParams.getCodUsuario());
     parametros.setIdUsuario(headerParams.getIdUsuario());
     
     String codRolUsuario = request.getCodRolUsuario();
     RolesPorUsuarioListadoResponse response = new RolesPorUsuarioListadoResponse();
        try {
            parametros.setCodRolUsuario(codRolUsuario);
            rolUsuarioDAO.listarRolesJefes(parametros);
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());
            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new RolesPorUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
   
 }

 @Override
 public JefesListadoResponse listarJefes (HeaderParams headerParams,JefesRequest request){
    
     LOGGER.info(":::listarJefes");
     ListarJefesProcedure parametros = mapper.map(headerParams, ListarJefesProcedure.class);
     parametros.setCodUsuario(headerParams.getCodUsuario());
     parametros.setIdUsuario(headerParams.getIdUsuario());
     
     String codRolJefe = request.getCodRolJefe();
     JefesListadoResponse response = new JefesListadoResponse();
        try {
            parametros.setCodRolJefe(codRolJefe);
            rolUsuarioDAO.listarJefes(parametros);
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setListado(parametros.getBusqueda());
            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new JefesListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;
   
 }
 
 @Override
 public RolUsuarioResponse registrarRolUsuario(HeaderParams headerParams,RolUsuarioRegistraRequest request){
 
     LOGGER.info(":::registrarRolesUsuariosJefes");
     RegistrarRolesUsuariosProcedure parametros = mapper.map(headerParams, RegistrarRolesUsuariosProcedure.class);
     parametros.setCodUsuario(headerParams.getCodUsuario());
     parametros.setIdUsuario(headerParams.getIdUsuario());
     
      String nomUsuario = request.getNomUsuario();
      String codRolUsuario = request.getCodRolUsuario();
      String nomUsuarioJefe = request.getNomUsuarioJefe();
      String nomUsuarioRemplazo =request.getNomUsuarioRemplazo()==null?"":request.getNomUsuarioRemplazo();
      
     RolUsuarioResponse response = new RolUsuarioResponse();
        try {
            parametros.setNomUsuario(nomUsuario);
            parametros.setCodRolUsuario(codRolUsuario);
            parametros.setNomUsuarioJefe(nomUsuarioJefe);
            parametros.setNomUsuarioRemplazo(nomUsuarioRemplazo);
            
            rolUsuarioDAO.registrarRolUsuario(parametros);
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());
                response.setCodigo(parametros.getCodigo());
                
            } else {
                throw new Exception(parametros.getMensaje());
            }

        } catch (Exception ex) {
            response = new RolUsuarioResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

 }
 
  @Override
    public RolUsuarioJerarquiaResponse listarRolesJerarquia(HeaderParams headerParams, RolUsuarioJerarquiaRequest request) throws Exception{
        ListarRolDatosProcedure parametros = mapper.map(headerParams, ListarRolDatosProcedure.class);
        mapper.map(request, parametros);
        parametros.setCoUsuario(request.getCoUsuario());
        parametros.setCodAreaVta(request.getCodAreaVta());
        parametros.setCodFilial(request.getCodFilial());
        parametros.setCodSucursal(request.getCodSucursal());
        
        rolUsuarioDAO.listarRolDatos(parametros);
        
        //Usuarios jefe de venta cod rol : 002
        ListarUsuariosPorRolProcedure parametros1 = mapper.map(headerParams, ListarUsuariosPorRolProcedure.class);
        mapper.map(request, parametros1);
       
        parametros1.setCodRolUsuaJefe("002");
        parametros1.setCodRolUsuario(request.getCodRolUsuario());
        rolUsuarioDAO.listarUsuariosPorRol(parametros1);
        
       //Usuarios gestor de crédito cod rol : 084
        ListarUsuariosPorRolProcedure parametros2 = mapper.map(headerParams, ListarUsuariosPorRolProcedure.class);
        mapper.map(request, parametros2);
       
        parametros2.setCodRolUsuaJefe("084");
        parametros2.setCodRolUsuario(request.getCodRolUsuario());
        rolUsuarioDAO.listarUsuariosPorRol(parametros2);
        
       //Usuarios Jefe De Adminsitración y Finanzas o Jefe de Crédito cod rol : 086
        ListarUsuariosPorRolProcedure parametros3 = mapper.map(headerParams, ListarUsuariosPorRolProcedure.class);
        mapper.map(request, parametros3);
       
        parametros3.setCodRolUsuaJefe("086");
        parametros3.setCodRolUsuario(request.getCodRolUsuario());
        rolUsuarioDAO.listarUsuariosPorRol(parametros3);
        
       //Usuarios Gerente de Finanzas ,Gerente Regional cod rol : 005
        ListarUsuariosPorRolProcedure parametros4 = mapper.map(headerParams, ListarUsuariosPorRolProcedure.class);
        mapper.map(request, parametros4);
       
        parametros4.setCodRolUsuaJefe("005");
        parametros4.setCodRolUsuario(request.getCodRolUsuario());
        rolUsuarioDAO.listarUsuariosPorRol(parametros4);
        
       //Usuarios GERENTE DE ADMINISTRACION Y FINANZAS cod rol : 087
        ListarUsuariosPorRolProcedure parametros5 = mapper.map(headerParams, ListarUsuariosPorRolProcedure.class);
        mapper.map(request, parametros5);
       
        parametros5.setCodRolUsuaJefe("087");
        parametros5.setCodRolUsuario(request.getCodRolUsuario());
        rolUsuarioDAO.listarUsuariosPorRol(parametros5);
        

        
        Integer statusQuery = parametros.getStatus();
        Integer statusQuery1 = parametros1.getStatus();
        Integer statusQuery2 = parametros2.getStatus();
        Integer statusQuery3 = parametros3.getStatus();
        Integer statusQuery4 = parametros4.getStatus();
        Integer statusQuery5 = parametros5.getStatus();        

        if (statusQuery.equals(1) && statusQuery1.equals(1) && statusQuery2.equals(1)
            && statusQuery3.equals(1)&& statusQuery4.equals(1)&& statusQuery5.equals(1)) {
            
            RolUsuarioJerarquiaResponse response = new RolUsuarioJerarquiaResponse();
            response.setListaRolDatosUsuario(parametros.getBusqueda());
            response.setListaJefesVenta(parametros1.getBusqueda());
            response.setListaGestorCredito(parametros2.getBusqueda());
            response.setListaJefesAdm(parametros3.getBusqueda());
            response.setListaGerFinReg(parametros4.getBusqueda());
            response.setListaGerAdmFin(parametros5.getBusqueda());
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    } 
    
}
