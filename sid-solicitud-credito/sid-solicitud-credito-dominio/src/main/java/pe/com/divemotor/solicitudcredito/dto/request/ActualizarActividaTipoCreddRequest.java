/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.ActividadEtapa;

/**
 * Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
 * @author ebarboza
 */
public class ActualizarActividaTipoCreddRequest {
    
    private List<ActividadEtapa> listaActividadEtapa;

    public List<ActividadEtapa> getListaActividadEtapa() {
        return listaActividadEtapa;
    }

    public void setListaActividadEtapa(List<ActividadEtapa> listaActividadEtapa) {
        this.listaActividadEtapa = listaActividadEtapa;
    }

     public Integer getLongitudListActividadTipo(){
         return this.listaActividadEtapa.size();
     }
}
