package pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.RolPorUsuario;

/**
 *
 * @author USER
 */
public class ListarRolesJefesProcedure extends BasePaginadoProcedure<RolPorUsuario> {
    
    private String codRolUsuario;

    public String getCodRolUsuario() {
        return codRolUsuario;
    }

    public void setCodRolUsuario(String codRolUsuario) {
        this.codRolUsuario = codRolUsuario;
    }
    
    
    
}
