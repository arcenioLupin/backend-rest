/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.agrupTasasVehiculo;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author jaltamirano
 */
public class ActualizarAgrupTasasVehiculoProcedure extends BaseProcedure {

    private Integer codAgruVeh;
    private String desAgruVeh;
    private Double valTasaBru;
    private Double valGrossUp;
    private Double valTasaFina;
    private String codCia;
    private String desCia;
    private String indInactivo;
    //Campos para detalle de Aprupación
    private Integer codTipoVehAgru;
    private Integer codTipoVeh;
    private Integer codAgruVehSeg;
    private String  codTipoUso;
    

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

    public Integer getCodTipoVeh() {
        return codTipoVeh;
    }

    public void setCodTipoVeh(Integer codTipoVeh) {
        this.codTipoVeh = codTipoVeh;
    }

    public Integer getCodAgruVehSeg() {
        return codAgruVehSeg;
    }

    public void setCodAgruVehSeg(Integer codAgruVehSeg) {
        this.codAgruVehSeg = codAgruVehSeg;
    }

    public String getCodTipoUso() {
        return codTipoUso;
    }

    public void setCodTipoUso(String codTipoUso) {
        this.codTipoUso = codTipoUso;
    }

    
}
