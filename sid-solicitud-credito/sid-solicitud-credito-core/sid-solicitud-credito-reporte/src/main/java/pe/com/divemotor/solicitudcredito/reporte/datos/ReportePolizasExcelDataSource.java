/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.Seguro;

/**
 *
 * @author USER
 */
public class ReportePolizasExcelDataSource {
    private List<Seguro> polizas;

    /**
     * @return the polizas
     */
    public List<Seguro> getPolizas() {
        return polizas;
    }

    /**
     * @param polizas the polizas to set
     */
    public void setPolizas(List<Seguro> polizas) {
        this.polizas = polizas;
    }
  
}
