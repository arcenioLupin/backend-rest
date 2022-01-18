/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author USER
 */
public class RolUsuarioRegistraRequest extends BaseRequest {
    
    private String nomUsuario;
    private String codRolUsuario;
    private String nomUsuarioJefe;
    private String nomUsuarioRemplazo;  

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getCodRolUsuario() {
        return codRolUsuario;
    }

    public void setCodRolUsuario(String codRolUsuario) {
        this.codRolUsuario = codRolUsuario;
    }

    public String getNomUsuarioJefe() {
        return nomUsuarioJefe;
    }

    public void setNomUsuarioJefe(String nomUsuarioJefe) {
        this.nomUsuarioJefe = nomUsuarioJefe;
    }

    public String getNomUsuarioRemplazo() {
        return nomUsuarioRemplazo;
    }

    public void setNomUsuarioRemplazo(String nomUsuarioRemplazo) {
        this.nomUsuarioRemplazo = nomUsuarioRemplazo;
    }
    
    
    
}
