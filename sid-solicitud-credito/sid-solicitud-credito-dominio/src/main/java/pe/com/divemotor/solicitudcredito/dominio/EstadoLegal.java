/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author MGRASSO
 */
public class EstadoLegal {
    
    private String codEstLeg;
    private String descripcion;

    /**
     * @return the codEstLeg
     */
    public String getCodEstLeg() {
        return codEstLeg;
    }

    /**
     * @param codEstLeg the codEstLeg to set
     */
    public void setCodEstLeg(String codEstLeg) {
        this.codEstLeg = codEstLeg;
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
    
    
}
