/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;

/**
 *
 * @author USER
 */
public class RolUsuarioJerarquia {
    

    private List<RolDatosUsuario> listaRolDatosUsuario;
    private List<RolUsuario> listaJefesVenta;
    private List<RolUsuario> listaGestorCredito;
    private List<RolUsuario> listaJefesAdm;
    private List<RolUsuario> listaGerFinReg;
    private List<RolUsuario> listaGerAdmFin;
    

    public List<RolDatosUsuario> getListaRolDatosUsuario() {
        return listaRolDatosUsuario;
    }

    public void setListaRolDatosUsuario(List<RolDatosUsuario> listaRolDatosUsuario) {
        this.listaRolDatosUsuario = listaRolDatosUsuario;
    }

    

    public List<RolUsuario> getListaJefesVenta() {
        return listaJefesVenta;
    }

    public void setListaJefesVenta(List<RolUsuario> listaJefesVenta) {
        this.listaJefesVenta = listaJefesVenta;
    }

    public List<RolUsuario> getListaGestorCredito() {
        return listaGestorCredito;
    }

    public void setListaGestorCredito(List<RolUsuario> listaGestorCredito) {
        this.listaGestorCredito = listaGestorCredito;
    }

    public List<RolUsuario> getListaJefesAdm() {
        return listaJefesAdm;
    }

    public void setListaJefesAdm(List<RolUsuario> listaJefesAdm) {
        this.listaJefesAdm = listaJefesAdm;
    }

    public List<RolUsuario> getListaGerFinReg() {
        return listaGerFinReg;
    }

    public void setListaGerFinReg(List<RolUsuario> listaGerFinReg) {
        this.listaGerFinReg = listaGerFinReg;
    }

    public List<RolUsuario> getListaGerAdmFin() {
        return listaGerAdmFin;
    }

    public void setListaGerAdmFin(List<RolUsuario> listaGerAdmFin) {
        this.listaGerAdmFin = listaGerAdmFin;
    }
    
    
    
}
