/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author phramirez
 */
public class SimuladorGasto {

    private Integer codCredSimuGast;
    private Integer codConcCol;
    private String desConcCol;
    private String codSimu;
    private Double valMonTotal;
    private String indFin;
    private Double valMonPer;
    private String codMoneda;

    public Integer getCodCredSimuGast() {
        return codCredSimuGast;
    }

    public void setCodCredSimuGast(Integer codCredSimuGast) {
        this.codCredSimuGast = codCredSimuGast;
    }

    public Integer getCodConcCol() {
        return codConcCol;
    }

    public void setCodConcCol(Integer codConcCol) {
        this.codConcCol = codConcCol;
    }

    public String getDesConcCol() {
        return desConcCol;
    }

    public void setDesConcCol(String desConcCol) {
        this.desConcCol = desConcCol;
    }    
    
    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }

    public Double getValMonTotal() {
        return valMonTotal;
    }

    public void setValMonTotal(Double valMonTotal) {
        this.valMonTotal = valMonTotal;
    }

    public String getIndFin() {
        return indFin;
    }

    public void setIndFin(String indFin) {
        this.indFin = indFin;
    }

    public Double getValMonPer() {
        return valMonPer;
    }

    public void setValMonPer(Double valMonPer) {
        this.valMonPer = valMonPer;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

}
