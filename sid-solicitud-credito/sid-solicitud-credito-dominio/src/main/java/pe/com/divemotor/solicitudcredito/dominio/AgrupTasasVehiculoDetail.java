/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author jaltamirano
 */
public class AgrupTasasVehiculoDetail {

    private Integer codDetail;
    private Integer codAgruVeh;
    private Integer codTipoVeh;
    private String desTipoVeh;
    private String codTipoUso;
    private String desTipoUso;

    public Integer getCodDetail() {
        return codDetail;
    }

    public void setCodDetail(Integer codDetail) {
        this.codDetail = codDetail;
    }

    public Integer getCodAgruVeh() {
        return codAgruVeh;
    }

    public void setCodAgruVeh(Integer codAgruVeh) {
        this.codAgruVeh = codAgruVeh;
    }

    public Integer getCodTipoVeh() {
        return codTipoVeh;
    }

    public void setCodTipoVeh(Integer codTipoVeh) {
        this.codTipoVeh = codTipoVeh;
    }

    public String getDesTipoVeh() {
        return desTipoVeh;
    }

    public void setDesTipoVeh(String desTipoVeh) {
        this.desTipoVeh = desTipoVeh;
    }

    public String getCodTipoUso() {
        return codTipoUso;
    }

    public void setCodTipoUso(String codTipoUso) {
        this.codTipoUso = codTipoUso;
    }

    public String getDesTipoUso() {
        return desTipoUso;
    }

    public void setDesTipoUso(String desTipoUso) {
        this.desTipoUso = desTipoUso;
    }

}
