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
public class GastosLxC {

    private String codGasto;
    private String desGasto;
    private String moneda;
    private String monto;

    public String getCodGasto() {
        return codGasto;
    }

    public void setCodGasto(String codGasto) {
        this.codGasto = codGasto;
    }

    public String getDesGasto() {
        return desGasto;
    }

    public void setDesGasto(String desGasto) {
        this.desGasto = desGasto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

}
