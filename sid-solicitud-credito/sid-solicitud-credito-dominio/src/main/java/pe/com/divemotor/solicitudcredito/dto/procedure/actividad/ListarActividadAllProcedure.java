/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.actividad;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ActividadAll;

/**
 *
 * @author ebarboza
 */
public class ListarActividadAllProcedure extends BasePaginadoProcedure<ActividadAll>{
    
    private String actActual;
    private String actSiguiente;
    private Integer retCantidad;

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
