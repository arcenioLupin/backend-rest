/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author mbardales
 */
public class FactorPorMesFlujoCaja {

    private String fecMesIniRang;
    private String fecMesFinRang;
    private Double valFact;
    private String indIngrEgre;
    private Integer nroOrde;

    public String getFecMesIniRang() {
        return fecMesIniRang;
    }

    public void setFecMesIniRang(String fecMesIniRang) {
        this.fecMesIniRang = fecMesIniRang;
    }

    public String getFecMesFinRang() {
        return fecMesFinRang;
    }

    public void setFecMesFinRang(String fecMesFinRang) {
        this.fecMesFinRang = fecMesFinRang;
    }

    public Double getValFact() {
        return valFact;
    }

    public void setValFact(Double valFact) {
        this.valFact = valFact;
    }

    public String getIndIngrEgre() {
        return indIngrEgre;
    }

    public void setIndIngrEgre(String indIngrEgre) {
        this.indIngrEgre = indIngrEgre;
    }

    public Integer getNroOrde() {
        return nroOrde;
    }

    public void setNroOrde(Integer nroOrde) {
        this.nroOrde = nroOrde;
    }

}
