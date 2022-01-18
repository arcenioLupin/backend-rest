/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorConcepto;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorProceso;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorTotal;

/**
 *
 * @author phramirez
 */
public class SimuladorCronogramaListadoResponse extends ListadoResponse<SimuladorCronograma> {

    private List<SimuladorConcepto> listadoColumna;
    private List<SimuladorTotal> total;
    private List<SimuladorProceso> proceso;

    public List<SimuladorConcepto> getListadoColumna() {
        return listadoColumna;
    }

    public void setListadoColumna(List<SimuladorConcepto> listadoColumna) {
        this.listadoColumna = listadoColumna;
    }

    public List<SimuladorTotal> getTotal() {
        return total;
    }

    public void setTotal(List<SimuladorTotal> total) {
        this.total = total;
    }

    public List<SimuladorProceso> getProceso() {
        return proceso;
    }

    public void setProceso(List<SimuladorProceso> proceso) {
        this.proceso = proceso;
    }

}
