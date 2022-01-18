/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.rolusuario;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.RolUsuario;


/**
 *
 * @author USER
 */
public class ListarUsuariosPorRolProcedure extends BasePaginadoProcedure<RolUsuario> {
    
    private String codRolUsuaJefe;
    private String codRolUsuario;

    public String getCodRolUsuaJefe() {
        return codRolUsuaJefe;
    }

    public void setCodRolUsuaJefe(String codRolUsuaJefe) {
        this.codRolUsuaJefe = codRolUsuaJefe;
    }

    public String getCodRolUsuario() {
        return codRolUsuario;
    }

    public void setCodRolUsuario(String codRolUsuario) {
        this.codRolUsuario = codRolUsuario;
    }
    
    
    
    
    
}
