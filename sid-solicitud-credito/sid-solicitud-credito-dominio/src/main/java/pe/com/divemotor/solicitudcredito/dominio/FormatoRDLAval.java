/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author legutierrez
 */
public class FormatoRDLAval {

    private String tipoPersAval;
    private String nomPersAval;
    private String doi;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private String valMontoFianza;
    
    public String getNomPersAval() {
        return nomPersAval;
    }

    public void setNomPersAval(String nomPersAval) {
        this.nomPersAval = nomPersAval;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getValMontoFianza() {
        return valMontoFianza;
    }

    public void setValMontoFianza(String valMontoFianza) {
        this.valMontoFianza = valMontoFianza;
    }

    /**
     * @return the tipoPersAval
     */
    public String getTipoPersAval() {
        return tipoPersAval;
    }

    /**
     * @param tipoPersAval the tipoPersAval to set
     */
    public void setTipoPersAval(String tipoPersAval) {
        this.tipoPersAval = tipoPersAval;
    }

}
