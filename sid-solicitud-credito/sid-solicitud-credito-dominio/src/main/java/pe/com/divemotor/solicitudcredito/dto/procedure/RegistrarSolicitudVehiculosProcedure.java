/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author legutierrez
 */
public class RegistrarSolicitudVehiculosProcedure extends BaseProcedure {

    private String codSoliCred;
    private String codCia;
    private String codProv;
    private String numPedidoVeh;
    private String rutaVeh;
    private double canAsientos;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getNumPedidoVeh() {
        return numPedidoVeh;
    }

    public void setNumPedidoVeh(String numPedidoVeh) {
        this.numPedidoVeh = numPedidoVeh;
    }

    public String getRutaVeh() {
        return rutaVeh;
    }

    public void setRutaVeh(String rutaVeh) {
        this.rutaVeh = rutaVeh;
    }

    public double getCanAsientos() {
        return canAsientos;
    }

    public void setCanAsientos(double canAsientos) {
        this.canAsientos = canAsientos;
    }

}
