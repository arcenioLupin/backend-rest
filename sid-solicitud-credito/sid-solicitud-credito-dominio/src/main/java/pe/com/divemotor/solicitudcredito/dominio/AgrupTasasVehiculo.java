/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author jaltamirano
 */
public class AgrupTasasVehiculo extends BaseRequest{

    private Integer codAgruVeh;
    private String desAgruVeh;
    private Double valTasaBru;
    private Double valGrossUp;
    private Double valTasaFina;
    private String codCia;
    private String desCia;
    private List<AgrupTasasVehiculoDetail> listaTipoVehi;

    public Integer getCodAgruVeh() {
        return codAgruVeh;
    }

    public void setCodAgruVeh(Integer codAgruVeh) {
        this.codAgruVeh = codAgruVeh;
    }

    public String getDesAgruVeh() {
        return desAgruVeh;
    }

    public void setDesAgruVeh(String desAgruVeh) {
        this.desAgruVeh = desAgruVeh;
    }

    public Double getValTasaBru() {
        return valTasaBru;
    }

    public void setValTasaBru(Double valTasaBru) {
        this.valTasaBru = valTasaBru;
    }

    public Double getValGrossUp() {
        return valGrossUp;
    }

    public void setValGrossUp(Double valGrossUp) {
        this.valGrossUp = valGrossUp;
    }

    public Double getValTasaFina() {
        return valTasaFina;
    }

    public void setValTasaFina(Double valTasaFina) {
        this.valTasaFina = valTasaFina;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getDesCia() {
        return desCia;
    }

    public void setDesCia(String desCia) {
        this.desCia = desCia;
    }

    public List<AgrupTasasVehiculoDetail> getListaTipoVehi() {
        return listaTipoVehi;
    }

    public void setListaTipoVehi(List<AgrupTasasVehiculoDetail> listaTipoVehi) {
        this.listaTipoVehi = listaTipoVehi;
    }

}
