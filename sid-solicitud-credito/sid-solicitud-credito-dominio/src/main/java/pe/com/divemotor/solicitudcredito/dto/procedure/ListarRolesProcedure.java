/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Roles;

/**
 *
 * @author mbardales
 */
public class ListarRolesProcedure extends BasePaginadoProcedure<Roles> {

    private String codRol;
    private String codRolJefFi;
    private String nroProforma;
    private String codClie;
    private String codZona;
    //I Req. 87567 E2.1 ID## avilca 02/10/2020>
    private String codFilial;
    private String codAreaVta;
    //I Req. 87567 E2.1 ID## avilca 02/10/2020>
    private String flag;
    private String flagEdit;

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public String getCodRolJefFi() {
        return codRolJefFi;
    }

    public void setCodRolJefFi(String codRolJefFi) {
        this.codRolJefFi = codRolJefFi;
    }

    public String getNroProforma() {
        return nroProforma;
    }

    public void setNroProforma(String nroProforma) {
        this.nroProforma = nroProforma;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagEdit() {
        return flagEdit;
    }

    public void setFlagEdit(String flagEdit) {
        this.flagEdit = flagEdit;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }
    
    

}
