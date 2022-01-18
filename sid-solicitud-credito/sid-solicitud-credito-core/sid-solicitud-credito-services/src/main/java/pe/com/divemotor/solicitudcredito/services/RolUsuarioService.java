/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.JefesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioJerarquiaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioRegistraRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolUsuarioRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolesJefesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.RolesPorUsuarioRequest;
import pe.com.divemotor.solicitudcredito.dto.response.JefesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioJerarquiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolUsuarioResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RolesPorUsuarioListadoResponse;

/**
 *
 * @author USER
 */
public interface RolUsuarioService {
    
  public RolUsuarioListadoResponse listarRolUsuario(HeaderParams headerParams,RolUsuarioRequest request);    
  public RolesPorUsuarioListadoResponse listarRolesPorUsuario (HeaderParams headerParams,RolesPorUsuarioRequest request);
  public RolesPorUsuarioListadoResponse listarRolesJefes (HeaderParams headerParams,RolesJefesRequest request);    
  public JefesListadoResponse listarJefes (HeaderParams headerParams,JefesRequest request); 
  public RolUsuarioResponse registrarRolUsuario(HeaderParams headerParams,RolUsuarioRegistraRequest request);
  public RolUsuarioJerarquiaResponse listarRolesJerarquia(HeaderParams headerParams, RolUsuarioJerarquiaRequest request) throws Exception;
}
