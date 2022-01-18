/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.Date;

/**
 *
 * @author egonzales
 */
public class Actividad {
    private String  codSoliCred;
    private Integer codCredSoliActi;
    private String  codActiCred;
    private String  codUsuaEjec;
    private Date    fecUsuaEjec;
    private String  desActiCred;
    private Integer codCredSoliActiPend;
    private String codEtapCred;
    private Integer pendGen;
    private Integer cantidadRoles;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public Integer getCodCredSoliActi() {
        return codCredSoliActi;
    }

    public void setCodCredSoliActi(Integer codCredSoliActi) {
        this.codCredSoliActi = codCredSoliActi;
    }

    public String getCodActiCred() {
        return codActiCred;
    }

    public void setCodActiCred(String codActiCred) {
        this.codActiCred = codActiCred;
    }

    public String getCodUsuaEjec() {
        return codUsuaEjec;
    }

    public void setCodUsuaEjec(String codUsuaEjec) {
        this.codUsuaEjec = codUsuaEjec;
    }

    public Date getFecUsuaEjec() {
        return fecUsuaEjec;
    }

    public void setFecUsuaEjec(Date fecUsuaEjec) {
        this.fecUsuaEjec = fecUsuaEjec;
    }

    public String getDesActiCred() {
        return desActiCred;
    }

    public void setDesActiCred(String desActiCred) {
        this.desActiCred = desActiCred;
    }

    public Integer getCodCredSoliActiPend() {
        return codCredSoliActiPend;
    }

    public void setCodCredSoliActiPend(Integer codCredSoliActiPend) {
        this.codCredSoliActiPend = codCredSoliActiPend;
    }

    public String getCodEtapCred() {
        return codEtapCred;
    }

    public void setCodEtapCred(String codEtapCred) {
        this.codEtapCred = codEtapCred;
    }

    public Integer getPendGen() {
        return pendGen;
    }

    public void setPendGen(Integer pendGen) {
        this.pendGen = pendGen;
    }

    public Integer getCantidadRoles() {
        return cantidadRoles;
    }

    public void setCantidadRoles(Integer cantidadRoles) {
        this.cantidadRoles = cantidadRoles;
    }
    
    
    
}
