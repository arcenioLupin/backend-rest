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
public class SimuladorConcepto {

    private Integer codConcCol;
    private String desConc;
    private String indConcOblig;

    public int getCodConcCol() {
        return codConcCol;
    }

    public void setCodConcCol(int codConcCol) {
        this.codConcCol = codConcCol;
    }

    public String getDesConc() {
        return desConc;
    }

    public void setDesConc(String desConc) {
        this.desConc = desConc;
    }

    public String getIndConcOblig() {
        return indConcOblig;
    }

    public void setIndConcOblig(String indConcOblig) {
        this.indConcOblig = indConcOblig;
    }
}
