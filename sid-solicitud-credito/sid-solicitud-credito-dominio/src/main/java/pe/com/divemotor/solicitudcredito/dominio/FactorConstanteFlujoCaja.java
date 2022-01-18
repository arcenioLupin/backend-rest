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
public class FactorConstanteFlujoCaja {

    private String valMes;
    private String valAnio;
    private String codParaFact;
    private Double valPara;
    private Double valFactAjust;

    public String getValMes() {
        return valMes;
    }

    public void setValMes(String valMes) {
        this.valMes = valMes;
    }

    public String getValAnio() {
        return valAnio;
    }

    public void setValAnio(String valAnio) {
        this.valAnio = valAnio;
    }

    public String getCodParaFact() {
        return codParaFact;
    }

    public void setCodParaFact(String codParaFact) {
        this.codParaFact = codParaFact;
    }

    public Double getValPara() {
        return valPara;
    }

    public void setValPara(Double valPara) {
        this.valPara = valPara;
    }

    public Double getValFactAjust() {
        return valFactAjust;
    }

    public void setValFactAjust(Double valFactAjust) {
        this.valFactAjust = valFactAjust;
    }

}
