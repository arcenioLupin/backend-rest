/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Seguro;

/**
 *
 * @author juan.quintanilla
 */
public class VencimientoSeguroProcedure extends BasePaginadoProcedure<Seguro>{

    private String diasConsulta;
    private String fecConsulta;

    public String getDiasConsulta() {
        return diasConsulta;
    }

    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public String getFecConsulta() {
        return fecConsulta;
    }

    public void setFecConsulta(String fecConsulta) {
        this.fecConsulta = fecConsulta;
    }
    
}
