/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author mbardales
 */
public class ParametrosFlujoCajaCabeceraUrbano {

    private Integer codRuta;
    private Integer valDiasTrabRuta;
    private Integer valNroVehRuta;
    private Double ValTotIngrUrbMes;
    private Double ValTotEgreUrbMes;

    public Integer getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(Integer codRuta) {
        this.codRuta = codRuta;
    }

    public Integer getValDiasTrabRuta() {
        return valDiasTrabRuta;
    }

    public void setValDiasTrabRuta(Integer valDiasTrabRuta) {
        this.valDiasTrabRuta = valDiasTrabRuta;
    }

    public Integer getValNroVehRuta() {
        return valNroVehRuta;
    }

    public void setValNroVehRuta(Integer valNroVehRuta) {
        this.valNroVehRuta = valNroVehRuta;
    }

    public Double getValTotIngrUrbMes() {
        return ValTotIngrUrbMes;
    }

    public void setValTotIngrUrbMes(Double ValTotIngrUrbMes) {
        this.ValTotIngrUrbMes = ValTotIngrUrbMes;
    }

    public Double getValTotEgreUrbMes() {
        return ValTotEgreUrbMes;
    }

    public void setValTotEgreUrbMes(Double ValTotEgreUrbMes) {
        this.ValTotEgreUrbMes = ValTotEgreUrbMes;
    }

}
