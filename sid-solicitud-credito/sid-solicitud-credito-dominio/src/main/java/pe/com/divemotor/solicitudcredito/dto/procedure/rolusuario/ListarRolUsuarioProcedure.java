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
public class ListarRolUsuarioProcedure extends BasePaginadoProcedure<RolUsuario> {
    
    private String codAreaVta;
    private String codFilial;
    private String codSucursal;

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }
    
    
    
}
