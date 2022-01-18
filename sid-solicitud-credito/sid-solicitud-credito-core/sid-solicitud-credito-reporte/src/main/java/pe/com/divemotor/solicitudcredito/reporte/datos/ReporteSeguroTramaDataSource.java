/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.ArrayList;
import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.TramaSeguro;

/**
 *
 * @author USER
 */
public class ReporteSeguroTramaDataSource {
    
    private List<TramaSeguro>listaGarantias;

    public List<TramaSeguro> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<TramaSeguro> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }
  
}
