/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.actividad;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ActividadEtapa;

/**
 *
 * @author ebarboza
 */
public class ListarActividadesEtapaProcedure extends BasePaginadoProcedure<ActividadEtapa>{
    
    private String codActividad;
    private String codEtapa;
    private String actActual;
    private String actSiguiente;
    private Integer retCantidad;

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
    }

    public String getActActual() {
        return actActual;
    }

    public void setActActual(String actActual) {
        this.actActual = actActual;
    }

    public String getActSiguiente() {
        return actSiguiente;
    }

    public void setActSiguiente(String actSiguiente) {
        this.actSiguiente = actSiguiente;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }
    
    
    
}
