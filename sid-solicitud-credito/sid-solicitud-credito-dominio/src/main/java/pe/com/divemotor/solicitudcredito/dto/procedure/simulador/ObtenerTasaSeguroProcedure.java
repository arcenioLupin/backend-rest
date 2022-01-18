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
public class ObtenerTasaSeguroProcedure extends BaseProcedure {

    private String codCia;
    private String codTipoVeh;
    private String indTipoUso;
    private String codCliente;
    private Double tasaSeg;

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getCodTipoVeh() {
        return codTipoVeh;
    }

    public void setCodTipoVeh(String codTipoVeh) {
        this.codTipoVeh = codTipoVeh;
    }

    public String getIndTipoUso() {
        return indTipoUso;
    }

    public void setIndTipoUso(String indTipoUso) {
        this.indTipoUso = indTipoUso;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Double getTasaSeg() {
        return tasaSeg;
    }

    public void setTasaSeg(Double tasaSeg) {
        this.tasaSeg = tasaSeg;
    }

}
