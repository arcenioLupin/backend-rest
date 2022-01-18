package pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class RegistrarRolesUsuariosProcedure extends BaseProcedure {
    
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
