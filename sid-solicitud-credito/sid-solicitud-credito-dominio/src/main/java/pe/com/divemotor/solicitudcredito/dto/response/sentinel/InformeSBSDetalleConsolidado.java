/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

import java.util.List;

/**
 *
 * @author legutierrez
 */
public class InformeSBSDetalleConsolidado {

    private String nomRazSoc;
    private String condicionContribuyente;
    private String calificativo;

    private List<DetalleItemSBS12M> listaDetalleItemSBS12M;

    private List<DetalleItemProtestos> listaProtestosAceptantesSinRegu;
    private List<DetalleItemProtestos> listaProtestosGiradorSinRegu;
    private List<DetalleItemProtestos> listaProtestosAceptantesRegu;
    private List<DetalleItemProtestos> listaProtestosGiradorRegu;
    private List<DetalleItemRepVencidos> listaDetalleRepVencidos;

    public String getNomRazSoc() {
        return nomRazSoc;
    }

    public void setNomRazSoc(String nomRazSoc) {
        this.nomRazSoc = nomRazSoc;
    }

    public String getCondicionContribuyente() {
        return condicionContribuyente;
    }

    public void setCondicionContribuyente(String condicionContribuyente) {
        this.condicionContribuyente = condicionContribuyente;
    }

    public String getCalificativo() {
        return calificativo;
    }

    public void setCalificativo(String calificativo) {
        this.calificativo = calificativo;
    }

    public List<DetalleItemSBS12M> getListaDetalleItemSBS12M() {
        return listaDetalleItemSBS12M;
    }

    public void setListaDetalleItemSBS12M(List<DetalleItemSBS12M> listaDetalleItemSBS12M) {
        this.listaDetalleItemSBS12M = listaDetalleItemSBS12M;
    }

    public List<DetalleItemProtestos> getListaProtestosAceptantesSinRegu() {
        return listaProtestosAceptantesSinRegu;
    }

    public void setListaProtestosAceptantesSinRegu(List<DetalleItemProtestos> listaProtestosAceptantesSinRegu) {
        this.listaProtestosAceptantesSinRegu = listaProtestosAceptantesSinRegu;
    }

    public List<DetalleItemProtestos> getListaProtestosGiradorSinRegu() {
        return listaProtestosGiradorSinRegu;
    }

    public void setListaProtestosGiradorSinRegu(List<DetalleItemProtestos> listaProtestosGiradorSinRegu) {
        this.listaProtestosGiradorSinRegu = listaProtestosGiradorSinRegu;
    }

    public List<DetalleItemProtestos> getListaProtestosAceptantesRegu() {
        return listaProtestosAceptantesRegu;
    }

    public void setListaProtestosAceptantesRegu(List<DetalleItemProtestos> listaProtestosAceptantesRegu) {
        this.listaProtestosAceptantesRegu = listaProtestosAceptantesRegu;
    }

    public List<DetalleItemProtestos> getListaProtestosGiradorRegu() {
        return listaProtestosGiradorRegu;
    }

    public void setListaProtestosGiradorRegu(List<DetalleItemProtestos> listaProtestosGiradorRegu) {
        this.listaProtestosGiradorRegu = listaProtestosGiradorRegu;
    }

    public List<DetalleItemRepVencidos> getListaDetalleRepVencidos() {
        return listaDetalleRepVencidos;
    }

    public void setListaDetalleRepVencidos(List<DetalleItemRepVencidos> listaDetalleRepVencidos) {
        this.listaDetalleRepVencidos = listaDetalleRepVencidos;
    }

}
