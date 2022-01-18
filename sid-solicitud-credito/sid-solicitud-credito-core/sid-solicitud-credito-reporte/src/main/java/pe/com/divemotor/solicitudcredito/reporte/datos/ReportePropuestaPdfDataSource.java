package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

/**
 *
 * @author phramirez
 */
public class ReportePropuestaPdfDataSource {

    private String cliente;
    private String tipSoliCred;
    private String nomMoneda;
    private String desMoneda;
    private String tipUsoVeh;
    private String valTotal;
    private String valCI;
    private String valMonFin;
    private Integer canPlazMeses;
    private String perCredSol;
    private Integer canDiasVenc1raLetr;
    private Integer canTotLet;
    private String valPorcTea;
    private String valIntPerGra;
    private String valMontLetr;
    private String valCuoBal;
    private String valGastAdm;
    private String valGarantia;
    private String indGPS;
    private String txtOtrCond;
    private Boolean hasSeguro;
    private Boolean hasCobranzas;
    private Boolean hasInteresMoratorio;
    private Boolean hasInteresCompensatorio;
    private Boolean hasCostoTraslado;
    private List<SimuladorCronograma> cronograma;
    private String garantias;//<Req. 87567 E2.1 ID## avilca 28/12/2020>
    private String seguros;//<Req. 87567 E2.1 ID## avilca 28/12/2020>

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getNomMoneda() {
        return nomMoneda;
    }

    public void setNomMoneda(String nomMoneda) {
        this.nomMoneda = nomMoneda;
    }

    public String getDesMoneda() {
        return desMoneda;
    }

    public void setDesMoneda(String desMoneda) {
        this.desMoneda = desMoneda;
    }

    public String getTipUsoVeh() {
        return tipUsoVeh;
    }

    public void setTipUsoVeh(String tipUsoVeh) {
        this.tipUsoVeh = tipUsoVeh;
    }

    public String getValTotal() {
        return valTotal;
    }

    public void setValTotal(String valTotal) {
        this.valTotal = valTotal;
    }

    public String getValCI() {
        return valCI;
    }

    public void setValCI(String valCI) {
        this.valCI = valCI;
    }

    public String getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(String valMonFin) {
        this.valMonFin = valMonFin;
    }

    public Integer getCanPlazMeses() {
        return canPlazMeses;
    }

    public void setCanPlazMeses(Integer canPlazMeses) {
        this.canPlazMeses = canPlazMeses;
    }

    public String getPerCredSol() {
        return perCredSol;
    }

    public void setPerCredSol(String perCredSol) {
        this.perCredSol = perCredSol;
    }

    public Integer getCanDiasVenc1raLetr() {
        return canDiasVenc1raLetr;
    }

    public void setCanDiasVenc1raLetr(Integer canDiasVenc1raLetr) {
        this.canDiasVenc1raLetr = canDiasVenc1raLetr;
    }

    public Integer getCanTotLet() {
        return canTotLet;
    }

    public void setCanTotLet(Integer canTotLet) {
        this.canTotLet = canTotLet;
    }

    public String getValPorcTea() {
        return valPorcTea;
    }

    public void setValPorcTea(String valPorcTea) {
        this.valPorcTea = valPorcTea;
    }

    public String getValIntPerGra() {
        return valIntPerGra;
    }

    public void setValIntPerGra(String valIntPerGra) {
        this.valIntPerGra = valIntPerGra;
    }

    public String getValMontLetr() {
        return valMontLetr;
    }

    public void setValMontLetr(String valMontLetr) {
        this.valMontLetr = valMontLetr;
    }

    public String getValCuoBal() {
        return valCuoBal;
    }

    public void setValCuoBal(String valCuoBal) {
        this.valCuoBal = valCuoBal;
    }

    public String getValGastAdm() {
        return valGastAdm;
    }

    public void setValGastAdm(String valGastAdm) {
        this.valGastAdm = valGastAdm;
    }

    public String getValGarantia() {
        return valGarantia;
    }

    public void setValGarantia(String valGarantia) {
        this.valGarantia = valGarantia;
    }

    public String getIndGPS() {
        return indGPS;
    }

    public void setIndGPS(String indGPS) {
        this.indGPS = indGPS;
    }

    public Boolean getHasSeguro() {
        return hasSeguro;
    }

    public void setHasSeguro(Boolean hasSeguro) {
        this.hasSeguro = hasSeguro;
    }

    public Boolean getHasCobranzas() {
        return hasCobranzas;
    }

    public void setHasCobranzas(Boolean hasCobranzas) {
        this.hasCobranzas = hasCobranzas;
    }

    public Boolean getHasInteresMoratorio() {
        return hasInteresMoratorio;
    }

    public void setHasInteresMoratorio(Boolean hasInteresMoratorio) {
        this.hasInteresMoratorio = hasInteresMoratorio;
    }

    public Boolean getHasInteresCompensatorio() {
        return hasInteresCompensatorio;
    }

    public void setHasInteresCompensatorio(Boolean hasInteresCompensatorio) {
        this.hasInteresCompensatorio = hasInteresCompensatorio;
    }

    public Boolean getHasCostoTraslado() {
        return hasCostoTraslado;
    }

    public void setHasCostoTraslado(Boolean hasCostoTraslado) {
        this.hasCostoTraslado = hasCostoTraslado;
    }

    public List<SimuladorCronograma> getCronograma() {
        return cronograma;
    }

    public void setCronograma(List<SimuladorCronograma> cronograma) {
        this.cronograma = cronograma;
    }

    public String getTxtOtrCond() {
        return txtOtrCond;
    }

    public void setTxtOtrCond(String txtOtrCond) {
        this.txtOtrCond = txtOtrCond;
    }

    public String getGarantias() {
        return garantias;
    }

    public void setGarantias(String garantias) {
        this.garantias = garantias;
    }

    public String getSeguros() {
        return seguros;
    }

    public void setSeguros(String seguros) {
        this.seguros = seguros;
    }
    
}
