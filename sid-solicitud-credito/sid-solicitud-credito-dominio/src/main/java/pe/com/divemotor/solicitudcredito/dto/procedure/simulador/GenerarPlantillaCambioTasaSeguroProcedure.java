/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author phramirez
 */
public class GenerarPlantillaCambioTasaSeguroProcedure extends BaseProcedure {

    private String codSoliCred;
    private String destinatarios;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

}
