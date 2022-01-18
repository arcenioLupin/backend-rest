/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

/**
 *
 * @author legutierrez
 */
public class SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem {

    private String razSoc;
    private double monDeuVen;
    private String numDocRep;
    private String numDiaVen;

    public String getRazSoc() {
        return razSoc;
    }

    public void setRazSoc(String razSoc) {
        this.razSoc = razSoc;
    }

    public double getMonDeuVen() {
        return monDeuVen;
    }

    public void setMonDeuVen(double monDeuVen) {
        this.monDeuVen = monDeuVen;
    }

    public String getNumDocRep() {
        return numDocRep;
    }

    public void setNumDocRep(String numDocRep) {
        this.numDocRep = numDocRep;
    }

    public String getNumDiaVen() {
        return numDiaVen;
    }

    public void setNumDiaVen(String numDiaVen) {
        this.numDiaVen = numDiaVen;
    }

}
