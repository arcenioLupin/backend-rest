/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author USER
 */
public class DocumentoLegal {
    private String codDocleg;
    private String descripcion;
    private String indOblig;

    /**
     * @return the codDocleg
     */
    public String getCodDocleg() {
        return codDocleg;
    }

    /**
     * @param codDocleg the codDocleg to set
     */
    public void setCodDocleg(String codDocleg) {
        this.codDocleg = codDocleg;
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
     * @return the indOblig
     */
    public String getIndOblig() {
        return indOblig;
    }

    /**
     * @param indOblig the indOblig to set
     */
    public void setIndOblig(String indOblig) {
        this.indOblig = indOblig;
    }
    
    
}
