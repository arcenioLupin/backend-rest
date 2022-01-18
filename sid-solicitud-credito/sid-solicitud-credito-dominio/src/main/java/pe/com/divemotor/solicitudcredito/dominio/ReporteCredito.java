/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;
import java.util.Date;
/**
 *
 * @author egonzales
 */
public class ReporteCredito {
    private String codAreaVenta;//area de venta
    private String codClie;//cliente
    private String numFichaVtaVeh;//ficha de venta
    private Double totVenta;//total venta
    private String tipSoliCred;//Tipo de Operacion
    private Double valCi;//cuota inicial
    private Double valMonFin;//Monto financiado
    private Integer canPlazMes;//Plazo Credito en meses
    private Date fecVenc1raLet;//Fecha Vencimiento 1era Letra
    private Integer valPorcTeaSigv;//Valor del TEA sin incluir IGV
    private String desZona;

    public String getCodAreaVenta() {
        return codAreaVenta;
    }

    public void setCodAreaVenta(String codAreaVenta) {
        this.codAreaVenta = codAreaVenta;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNumFichaVtaVeh() {
        return numFichaVtaVeh;
    }

    public void setNumFichaVtaVeh(String numFichaVtaVeh) {
        this.numFichaVtaVeh = numFichaVtaVeh;
    }

    public Double getTotVenta() {
        return totVenta;
    }

    public void setTotVenta(Double totVenta) {
        this.totVenta = totVenta;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    

    

    public Double getValCi() {
        return valCi;
    }

    public void setValCi(Double valCi) {
        this.valCi = valCi;
    }

    public Double getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(Double valMonFin) {
        this.valMonFin = valMonFin;
    }

    public Integer getCanPlazMes() {
        return canPlazMes;
    }

    public void setCanPlazMes(Integer canPlazMes) {
        this.canPlazMes = canPlazMes;
    }

    public Date getFecVenc1raLet() {
        return fecVenc1raLet;
    }

    public void setFecVenc1raLet(Date fecVenc1raLet) {
        this.fecVenc1raLet = fecVenc1raLet;
    }

    public Integer getValPorcTeaSigv() {
        return valPorcTeaSigv;
    }

    public void setValPorcTeaSigv(Integer valPorcTeaSigv) {
        this.valPorcTeaSigv = valPorcTeaSigv;
    }

    public String getDesZona() {
        return desZona;
    }

    public void setDesZona(String desZona) {
        this.desZona = desZona;
    }
    
}
