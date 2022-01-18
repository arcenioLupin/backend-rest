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
public class RevisionPoderes {
    
    private List<OperacionEmpresa> listOperacionEmpresa;
    private List<PersonaFacultada> listPersonaFacultada;
    private List<OperacionPersona> listOperacionPersona;

    /**
     * @return the listOperacionEmpresa
     */
    public List<OperacionEmpresa> getListOperacionEmpresa() {
        return listOperacionEmpresa;
    }

    /**
     * @param listOperacionEmpresa the listOperacionEmpresa to set
     */
    public void setListOperacionEmpresa(List<OperacionEmpresa> listOperacionEmpresa) {
        this.listOperacionEmpresa = listOperacionEmpresa;
    }

    /**
     * @return the listPersonaFacultada
     */
    public List<PersonaFacultada> getListPersonaFacultada() {
        return listPersonaFacultada;
    }

    /**
     * @param listPersonaFacultada the listPersonaFacultada to set
     */
    public void setListPersonaFacultada(List<PersonaFacultada> listPersonaFacultada) {
        this.listPersonaFacultada = listPersonaFacultada;
    }

    /**
     * @return the listOperacionPersona
     */
    public List<OperacionPersona> getListOperacionPersona() {
        return listOperacionPersona;
    }

    /**
     * @param listOperacionPersona the listOperacionPersona to set
     */
    public void setListOperacionPersona(List<OperacionPersona> listOperacionPersona) {
        this.listOperacionPersona = listOperacionPersona;
    }
    
    
}
