/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;
//EGH

/**
 *
 * @author egonzales
 */
public class CreditoSolicitudEventoDestino {

    private String correo;
    private Integer codigoSolicitudEvento;
    private Integer item;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getCodigoSolicitudEvento() {
        return codigoSolicitudEvento;
    }

    public void setCodigoSolicitudEvento(Integer codigoSolicitudEvento) {
        this.codigoSolicitudEvento = codigoSolicitudEvento;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

}
