/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author legutierrez
 */
public class Vehiculos {

    private String codCia;
    private String codProv;
    private String numPedidoVeh;
    private String numChasis;
    private String numPlacaVeh;
    private String numMotorVeh;
    private String desBaumuster;
    private String anoFabricacionVeh;
    private String tipoVehiculo;
    private String asientos;
    private String ruta;
    private boolean flagEditar;

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

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getNumPlacaVeh() {
        return numPlacaVeh;
    }

    public void setNumPlacaVeh(String numPlacaVeh) {
        this.numPlacaVeh = numPlacaVeh;
    }

    public String getNumMotorVeh() {
        return numMotorVeh;
    }

    public void setNumMotorVeh(String numMotorVeh) {
        this.numMotorVeh = numMotorVeh;
    }

    public String getDesBaumuster() {
        return desBaumuster;
    }

    public void setDesBaumuster(String desBaumuster) {
        this.desBaumuster = desBaumuster;
    }

    public String getAnoFabricacionVeh() {
        return anoFabricacionVeh;
    }

    public void setAnoFabricacionVeh(String anoFabricacionVeh) {
        this.anoFabricacionVeh = anoFabricacionVeh;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isFlagEditar() {
        return flagEditar;
    }

    public void setFlagEditar(boolean flagEditar) {
        this.flagEditar = flagEditar;
    }

}
