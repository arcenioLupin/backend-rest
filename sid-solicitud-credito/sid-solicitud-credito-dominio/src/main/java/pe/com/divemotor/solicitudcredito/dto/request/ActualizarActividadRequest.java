/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.ActividadAll;

/**
 *
 * @author ebarboza
 */
public class ActualizarActividadRequest extends BaseRequest {
    
    private List<ActividadAll> listaActividad;
   
    public List<ActividadAll> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(List<ActividadAll> listaActividad) {
        this.listaActividad = listaActividad;
    }
    
    public Integer getLongitudLista(){
        return this.listaActividad.size();
    }
  
}
