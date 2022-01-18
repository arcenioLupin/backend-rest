/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.ActividadAll;

/**
 *
 * @author ebarboza
 */
public class ActividadAllListadoResponse extends ListadoResponse<ActividadAll>{
    
    private String actActual;
    private String actSiguiente;

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
    
    
}
