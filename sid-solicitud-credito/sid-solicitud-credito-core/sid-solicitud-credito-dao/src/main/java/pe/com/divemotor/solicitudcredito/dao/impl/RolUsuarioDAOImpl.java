/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.RolUsuarioDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.RegistrarRolesUsuariosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolDatosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolUsuarioProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarUsuariosPorRolProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesJefesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario.ListarRolesPorUsuarioProcedure;
import pe.com.divemotor.solicitudcredito.mapper.RolUsuarioMapper;

/**
 *
 * @author USER
 */
@Repository
public class RolUsuarioDAOImpl implements RolUsuarioDAO{
    
  private RolUsuarioMapper rolUsuarioMaper;
  
   @Autowired
    public void setRolUsuarioMaper(RolUsuarioMapper rolUsuarioMaper) {
        this.rolUsuarioMaper = rolUsuarioMaper;
    }
    
  @Override
  public void listarRolUsuario (ListarRolUsuarioProcedure parametros){  
    rolUsuarioMaper.listarRolUsuario(parametros);
  }  

  @Override
  public void listarRolesPorUsuario (ListarRolesPorUsuarioProcedure parametros){
    rolUsuarioMaper.listarRolesPorUsuario(parametros);
  } 
  
  @Override  
  public void listarRolesJefes (ListarRolesJefesProcedure parametros){
   rolUsuarioMaper.listarRolesJefes(parametros);
  }
  
  @Override  
  public void listarJefes (ListarJefesProcedure parametros){
   rolUsuarioMaper.listarJefes(parametros);
  }
  
  @Override 
  public void registrarRolUsuario (RegistrarRolesUsuariosProcedure parametros){
    rolUsuarioMaper.registrarRolUsuario(parametros);
  }  
  
  @Override
  public void listarRolDatos (ListarRolDatosProcedure parametros){
   rolUsuarioMaper.listarRolDatos(parametros);
  }
  
  @Override
  public void listarUsuariosPorRol (ListarUsuariosPorRolProcedure parametros){
   rolUsuarioMaper.listarUsuariosPorRol(parametros);
  }

}
