/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.KPIs;

/**
 *
 * @author jaltamirano
 */
public class KPIsRequest extends BaseRequest {

    private String codigo;
    private String descripcion;
    private String valor;
    private String codZona;
    private String periodo;
    private List<KPIs> listaKpis;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<KPIs> getListaKpis() {
        return listaKpis;
    }

    public void setListaKpis(List<KPIs> listaKpis) {
        this.listaKpis = listaKpis;
    }
    
    

}
