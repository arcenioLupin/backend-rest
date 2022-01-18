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
public class ListarJefesProcedure extends BasePaginadoProcedure<RolUsuario> {
    
   private String codRolJefe;

    public String getCodRolJefe() {
        return codRolJefe;
    }

    public void setCodRolJefe(String codRolJefe) {
        this.codRolJefe = codRolJefe;
    }
   
   
    
}
