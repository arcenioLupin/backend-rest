/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author USER
 */
public class FacturaAnexo {
    
    private String numFactura;
    private String fechaFactura;
    private String monedaFactura;
    private int importeFactura;

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getMonedaFactura() {
        return monedaFactura;
    }

    public void setMonedaFactura(String monedaFactura) {
        this.monedaFactura = monedaFactura;
    }

    public int getImporteFactura() {
        return importeFactura;
    }

    public void setImporteFactura(int importeFactura) {
        this.importeFactura = importeFactura;
    }

   
}
