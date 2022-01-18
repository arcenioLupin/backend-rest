/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

/**
 *
 * @author jaltamirano
 */
public class AgrupTasasVehiculoRequest {
    private Integer codAgruVeh;
    private String desAgruVeh;
    private Double valTasaBru;
    private Double valGrossUp;
    private Double valTasaFina;
    private String codCia;
    private String desCia;
    
    //Detail
    private Integer codDetail;
    //private Integer codAgruVeh;
    private Integer codTipoVeh;
    private String desTipoVeh;
    private String codTipoUso;
    private String desTipoUso;
    
    private String indInactivo;
    
    //Campos para detalle de Aprupación
    private Integer codTipoVehAgru;
    private Integer codAgruVehSeg;


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

    public Integer getCodDetail() {
        return codDetail;
    }

    public void setCodDetail(Integer codDetail) {
        this.codDetail = codDetail;
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

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }

    public Integer getCodTipoVehAgru() {
        return codTipoVehAgru;
    }

    public void setCodTipoVehAgru(Integer codTipoVehAgru) {
        this.codTipoVehAgru = codTipoVehAgru;
    }

    public Integer getCodAgruVehSeg() {
        return codAgruVehSeg;
    }

    public void setCodAgruVehSeg(Integer codAgruVehSeg) {
        this.codAgruVehSeg = codAgruVehSeg;
    }
    
    
}
