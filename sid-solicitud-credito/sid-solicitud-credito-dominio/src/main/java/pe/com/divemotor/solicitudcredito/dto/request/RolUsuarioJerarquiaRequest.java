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
public class RolUsuarioJerarquiaRequest extends BaseRequest {
    
    private String coUsuario;
    private String codAreaVta;
    private String codSucursal;
    private String codFilial;
    private String codRolUsuaJefe;
    private String codRolUsuario;

    public String getCoUsuario() {
        return coUsuario;
    }

    public void setCoUsuario(String coUsuario) {
        this.coUsuario = coUsuario;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

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
