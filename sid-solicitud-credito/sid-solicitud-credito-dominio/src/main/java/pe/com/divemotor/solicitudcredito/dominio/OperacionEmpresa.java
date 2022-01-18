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
public class OperacionEmpresa {
    
    private String descripcion;
    private String nomPerso;

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
     * @return the nomPerso
     */
    public String getNomPerso() {
        return nomPerso;
    }

    /**
     * @param nomPerso the nomPerso to set
     */
    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }
}
