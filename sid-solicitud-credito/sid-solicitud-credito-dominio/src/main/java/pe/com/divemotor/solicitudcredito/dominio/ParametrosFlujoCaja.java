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
public class ParametrosFlujoCaja {

    private String codParaFc;
    private String indTipoFc;
    private String indTipo;
    private Double valPara;
    private Integer nroRuta;
    private String valTxt;

    public String getValTxt() {
        return valTxt;
    }

    public void setValTxt(String valTxt) {
        this.valTxt = valTxt;
    }

    public String getCodParaFc() {
        return codParaFc;
    }

    public void setCodParaFc(String codParaFc) {
        this.codParaFc = codParaFc;
    }

    public String getIndTipoFc() {
        return indTipoFc;
    }

    public void setIndTipoFc(String indTipoFc) {
        this.indTipoFc = indTipoFc;
    }

    public String getIndTipo() {
        return indTipo;
    }

    public void setIndTipo(String indTipo) {
        this.indTipo = indTipo;
    }

    public Double getValPara() {
        return valPara;
    }

    public void setValPara(Double valPara) {
        this.valPara = valPara;
    }

    public Integer getNroRuta() {
        return nroRuta;
    }

    public void setNroRuta(Integer nroRuta) {
        this.nroRuta = nroRuta;
    }

}
