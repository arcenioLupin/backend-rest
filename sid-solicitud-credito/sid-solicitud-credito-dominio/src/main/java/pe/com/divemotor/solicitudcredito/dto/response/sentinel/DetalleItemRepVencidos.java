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
public class DetalleItemRepVencidos {
    
    private String docVenNom;
    private double docVenDeuTot;
    private String docVenDiaAtr;
    private String razSoc;
    private double monDeuVen;
    private String numDocRep;
    private String numDiaVen;

    public String getDocVenNom() {
        return docVenNom;
    }

    public void setDocVenNom(String docVenNom) {
        this.docVenNom = docVenNom;
    }

    public double getDocVenDeuTot() {
        return docVenDeuTot;
    }

    public void setDocVenDeuTot(double docVenDeuTot) {
        this.docVenDeuTot = docVenDeuTot;
    }

    public String getDocVenDiaAtr() {
        return docVenDiaAtr;
    }

    public void setDocVenDiaAtr(String docVenDiaAtr) {
        this.docVenDiaAtr = docVenDiaAtr;
    }

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
