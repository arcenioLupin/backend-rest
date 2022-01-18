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
public class OperacionLegal {
    
    //private int codFdorev;
    private int codDocrev;
    private String codTipope;
    private String descripcion;
    private String nomRevision;
    private String observacion;   
    private List<PersonaFacultada> personasFacultadas;
    private List<DocumentoRevision> documentos;
    /**
     * @return the codTipope
     */
    public String getCodTipope() {
        return codTipope;
    }

    /**
     * @param codTipope the codTipope to set
     */
    public void setCodTipope(String codTipope) {
        this.codTipope = codTipope;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the nomRevision
     */
    public String getNomRevision() {
        return nomRevision;
    }

    /**
     * @param nomRevision the nomRevision to set
     */
    public void setNomRevision(String nomRevision) {
        this.nomRevision = nomRevision;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * @return the personasFacultadas
     */
    public List<PersonaFacultada> getPersonasFacultadas() {
        return personasFacultadas;
}

    /**
     * @param personasFacultadas the personasFacultadas to set
     */
    public void setPersonasFacultadas(List<PersonaFacultada> personasFacultadas) {
        this.personasFacultadas = personasFacultadas;
    }

    /**
     * @return the documentos
     */
    public List<DocumentoRevision> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<DocumentoRevision> documentos) {
        this.documentos = documentos;
    }

    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }

  /*
    public int getCodFdorev() {
        return codFdorev;
    }

    public void setCodFdorev(int codFdorev) {
        this.codFdorev = codFdorev;
    }
    */
    
}
