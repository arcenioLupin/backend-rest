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
public class SimuladorProforma {

    private String codSoliCred;
    private String numProfVeh;
    private Integer canVehFin;
    private Double valVtaTotFin;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public Integer getCanVehFin() {
        return canVehFin;
    }

    public void setCanVehFin(Integer canVehFin) {
        this.canVehFin = canVehFin;
    }

    public Double getValVtaTotFin() {
        return valVtaTotFin;
    }

    public void setValVtaTotFin(Double valVtaTotFin) {
        this.valVtaTotFin = valVtaTotFin;
    }

}
