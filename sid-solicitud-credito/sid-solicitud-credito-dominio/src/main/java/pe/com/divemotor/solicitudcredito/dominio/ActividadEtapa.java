/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author ebarboza
 */
public class ActividadEtapa {
    
    private String codTipo;
    private String descripcion;
    private Character oblig;
    private Character opcional;
    private Character asignar;
    private String codActiCred;
    private String codEtapCred;
    private String desActiCred;
    private String numOrden;
    private String codEstadoSoli;
    private String descEstado;

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getOblig() {
        return oblig;
    }

    public void setOblig(Character oblig) {
        this.oblig = oblig;
    }

    public Character getOpcional() {
        return opcional;
    }

    public void setOpcional(Character opcional) {
        this.opcional = opcional;
    }

    public Character getAsignar() {
        return asignar;
    }

    public void setAsignar(Character asignar) {
        this.asignar = asignar;
    }

    public String getCodActiCred() {
        return codActiCred;
    }

    public void setCodActiCred(String codActiCred) {
        this.codActiCred = codActiCred;
    }

    public String getCodEtapCred() {
        return codEtapCred;
    }

    public void setCodEtapCred(String codEtapCred) {
        this.codEtapCred = codEtapCred;
    }

    public String getDesActiCred() {
        return desActiCred;
    }

    public void setDesActiCred(String desActiCred) {
        this.desActiCred = desActiCred;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public String getCodEstadoSoli() {
        return codEstadoSoli;
    }

    public void setCodEstadoSoli(String codEstadoSoli) {
        this.codEstadoSoli = codEstadoSoli;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
    
    
    
}
