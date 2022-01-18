/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
import pe.com.divemotor.solicitudcredito.services.RolUsuarioService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/api")
public class RolUsuarioController {
    
 private final Logger LOGGER = Logger.getLogger(getClass());
 private RolUsuarioService service;

 @Autowired
 public void setService(RolUsuarioService service) {
        this.service = service;
    }
 
    @ApiOperation(value = "Listado de usuarios asociados a una area de venta,sucursal y filial",
            notes = "Retorna el listado usuarios asociados a una area de venta,sucursal y filial."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LISTAR_USUARIO_AVTA_SUC_FIL")
    @RequestMapping(value = "/rolusuario/listarRolUsuario",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RolUsuarioListadoResponse listarRolUsuario(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute RolUsuarioRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        RolUsuarioListadoResponse response;

        try {

            response = service.listarRolUsuario(headerParams, request);

        } catch (Exception ex) {
            response = new RolUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }
    

    @ApiOperation(value = "Listado de roles por usuario",
            notes = "Retorna el listado de roles por usuario."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LIST_ROL_USUARIO")
    @RequestMapping(value = "/rolusuario/listarRolesPorUsuario",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RolesPorUsuarioListadoResponse listarRolesPorUsuario(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute RolesPorUsuarioRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        RolesPorUsuarioListadoResponse response;

        try {

            response = service.listarRolesPorUsuario(headerParams, request);

        } catch (Exception ex) {
            response = new RolesPorUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }
    
    @ApiOperation(value = "Listado de roles de jefes por rol usuario",
            notes = "Retorna el listado de roles de jefes por rol usuario."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LIST_ROL_USU_JEFE")
    @RequestMapping(value = "/rolusuario/listarRolesJefes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RolesPorUsuarioListadoResponse listarRolesJefes(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute RolesJefesRequest request
    ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        RolesPorUsuarioListadoResponse response;

        try {

            response = service.listarRolesJefes(headerParams, request);

        } catch (Exception ex) {
            response = new RolesPorUsuarioListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }     
    
   @ApiOperation(value = "Listado de jefes por rol",
            notes = "Retorna el listado de jefes por rol."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LIST_JEFE")
    @RequestMapping(value = "/rolusuario/listarJefes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JefesListadoResponse listarJefes(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute JefesRequest request
       ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        JefesListadoResponse response;
        try {
            
            response = service.listarJefes(headerParams, request);
            
        } catch (Exception ex) {
            response = new JefesListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }
     @ApiOperation(value = "Registra roles de usuarios y jefe",
            notes = "Registra roles de usuarios y jefe.")
    @RequestMapping(value = "/rolusuario/registrarRolesUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public RolUsuarioResponse registrarRolesUsuario(@ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codigoUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @RequestBody RolUsuarioRegistraRequest request) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codigoUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);
        RolUsuarioResponse response = null;

        try {
            response = service.registrarRolUsuario(headerParams, request);

        } catch (Exception ex) {
            response = new RolUsuarioResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }    
    
  @ApiOperation(value = "Listado de roles por jerarquia",
            notes = "Retorna el listado de roles por jerarquia."
            + "se utiliza el PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LIST_ROL_DATOS y "
                    + "PKG_SWEB_CRED_SOLI_MANT_ROLUSU.SP_LIST_ROL_USUARIOS ")
    @RequestMapping(value = "/rolusuario/listarRolesJerarquia",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RolUsuarioJerarquiaResponse listarRolesJerarquia(
            @ApiParam(value = "Código de Usuario")
            @RequestHeader(name = "codUsuario", required = false) String codUsuario,
            @ApiParam(value = "Id de Usuario")
            @RequestHeader(name = "idUsuario", required = false) Integer idUsuario,
            @ApiParam(value = "Token de Autorización", required = true)
            @RequestHeader("token") String token,
            @ModelAttribute RolUsuarioJerarquiaRequest request
       ) {

        HeaderParams headerParams = new HeaderParams();
        headerParams.setCodUsuario(codUsuario);
        headerParams.setIdUsuario(idUsuario);
        headerParams.setToken(token);

        RolUsuarioJerarquiaResponse response;
        try {
            
            response = service.listarRolesJerarquia(headerParams, request);
            
        } catch (Exception ex) {
            response = new RolUsuarioJerarquiaResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }    
}
