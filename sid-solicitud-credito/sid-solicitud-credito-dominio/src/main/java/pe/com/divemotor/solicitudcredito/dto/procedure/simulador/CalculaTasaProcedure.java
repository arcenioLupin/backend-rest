/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author avilca
 */
public class CalculaTasaProcedure extends BaseProcedure {
    
    private Double primaSeg;
    private Integer plazoMeses;
    private Double montoVta;
    private Double porcIgv;
    private Double tasaSeg;

    public Double getPrimaSeg() {
        return primaSeg;
    }

    public void setPrimaSeg(Double primaSeg) {
        this.primaSeg = primaSeg;
    }

    public Integer getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(Integer plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public Double getMontoVta() {
        return montoVta;
    }

    public void setMontoVta(Double montoVta) {
        this.montoVta = montoVta;
    }

    public Double getPorcIgv() {
        return porcIgv;
    }

    public void setPorcIgv(Double porcIgv) {
        this.porcIgv = porcIgv;
    }

    public Double getTasaSeg() {
        return tasaSeg;
    }

    public void setTasaSeg(Double tasaSeg) {
        this.tasaSeg = tasaSeg;
    }
    
    

}
