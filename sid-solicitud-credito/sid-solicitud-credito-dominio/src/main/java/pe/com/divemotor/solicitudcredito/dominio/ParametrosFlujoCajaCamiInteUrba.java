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
public class ParametrosFlujoCajaCamiInteUrba {

    private String codCredParaFc;
    private String valPara;
    private Integer valNroRuta;
    private String valTxt;

    public String getValTxt() {
        return valTxt;
    }

    public void setValTxt(String valTxt) {
        this.valTxt = valTxt;
    }

    public String getCodCredParaFc() {
        return codCredParaFc;
    }

    public void setCodCredParaFc(String codCredParaFc) {
        this.codCredParaFc = codCredParaFc;
    }

    public String getValPara() {
        return valPara;
    }

    public void setValPara(String valPara) {
        this.valPara = valPara;
    }

    public Integer getValNroRuta() {
        return valNroRuta;
    }

    public void setValNroRuta(Integer valNroRuta) {
        this.valNroRuta = valNroRuta;
    }

}
