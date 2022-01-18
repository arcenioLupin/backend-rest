/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.RegistrarRolesUsuariosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolDatosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolUsuarioProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarUsuariosPorRolProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesPorUsuarioProcedure;

/**
 *
 * @author USER
 */
public interface RolUsuarioMapper {
    
   public void listarRolUsuario (ListarRolUsuarioProcedure parametros); 
   
   public void listarRolesPorUsuario (ListarRolesPorUsuarioProcedure parametros);
   
   public void listarRolesJefes (ListarRolesJefesProcedure parametros);
   
   public void listarJefes (ListarJefesProcedure parametros);
   
   public void registrarRolUsuario (RegistrarRolesUsuariosProcedure parametros);
   
   public void listarRolDatos (ListarRolDatosProcedure parametros);
   
   public void listarUsuariosPorRol (ListarUsuariosPorRolProcedure parametros); 
    
}
