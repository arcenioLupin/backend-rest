/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.lxc;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Aval;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionados;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionadosTotales;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxC;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxCTotales;
import pe.com.divemotor.solicitudcredito.dominio.OperacionLxCRegistrado;

/**
 *
 * @author mbardales
 */
public class ListarOperacionLxCRegistradaProcedure extends BasePaginadoProcedure<DocumentosRelacionados> {

    private String codSoliCred;
    private List<DocumentosRelacionadosTotales> listadoTotalesDocuRela;
    private List<GastosLxC> gastos;
    private List<GastosLxCTotales> listaGastosLxCTotales;
    private List<Aval> avales;
    private List<OperacionLxCRegistrado> listaOperacionLxCRegistrado;
    private String tipoCreditoLxc;

    public String getTipoCreditoLxc() {
        return tipoCreditoLxc;
    }

    public void setTipoCreditoLxc(String tipoCreditoLxc) {
        this.tipoCreditoLxc = tipoCreditoLxc;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<DocumentosRelacionadosTotales> getListadoTotalesDocuRela() {
        return listadoTotalesDocuRela;
    }

    public void setListadoTotalesDocuRela(List<DocumentosRelacionadosTotales> listadoTotalesDocuRela) {
        this.listadoTotalesDocuRela = listadoTotalesDocuRela;
    }

    public List<GastosLxC> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastosLxC> gastos) {
        this.gastos = gastos;
    }

    public List<GastosLxCTotales> getListaGastosLxCTotales() {
        return listaGastosLxCTotales;
    }

    public void setListaGastosLxCTotales(List<GastosLxCTotales> listaGastosLxCTotales) {
        this.listaGastosLxCTotales = listaGastosLxCTotales;
    }

    public List<Aval> getAvales() {
        return avales;
    }

    public void setAvales(List<Aval> avales) {
        this.avales = avales;
    }

    public List<OperacionLxCRegistrado> getListaOperacionLxCRegistrado() {
        return listaOperacionLxCRegistrado;
    }

    public void setListaOperacionLxCRegistrado(List<OperacionLxCRegistrado> listaOperacionLxCRegistrado) {
        this.listaOperacionLxCRegistrado = listaOperacionLxCRegistrado;
    }

}
