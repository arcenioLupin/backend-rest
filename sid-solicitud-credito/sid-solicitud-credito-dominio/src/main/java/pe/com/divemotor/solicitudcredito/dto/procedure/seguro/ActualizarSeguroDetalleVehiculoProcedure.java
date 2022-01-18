/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class ActualizarSeguroDetalleVehiculoProcedure extends BaseProcedure{
    
    //private String codSoliCred;
    //private String numPedidoVeh;
    private String numPlacaVeh;
    private String codUsuaModReg;
    private String codGarantia;


    /**
     * @return the numPlacaVeh
     */
    public String getNumPlacaVeh() {
        return numPlacaVeh;
    }

    /**
     * @param numPlacaVeh the numPlacaVeh to set
     */
    public void setNumPlacaVeh(String numPlacaVeh) {
        this.numPlacaVeh = numPlacaVeh;
    }

    /**
     * @return the codUsuaModReg
     */
    public String getCodUsuaModReg() {
        return codUsuaModReg;
    }

    /**
     * @param codUsuaModReg the codUsuaModReg to set
     */
    public void setCodUsuaModReg(String codUsuaModReg) {
        this.codUsuaModReg = codUsuaModReg;
    }

    public String getCodGarantia() {
        return codGarantia;
    }

    public void setCodGarantia(String codGarantia) {
        this.codGarantia = codGarantia;
    }
    
    
    
}
