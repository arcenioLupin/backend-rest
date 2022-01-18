/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author legutierrez
 */
public class ActualizarSolicitudCreditoRequest extends BaseRequest {
    private String codZona;
    private String codAreaVenta;
    private String codVendedor;
    private String codFilial;
    private String codSucursal;
    private String codSoliCred;
    private String codEstado;
    private String codPerso;
    private String numProfVeh;
    private String numTelfMovil;
    private String dirCorreo;
    private String obseCrea;
    private String tipoSoliCred;
    private String codRespFina;
    private String canPlazMes;
    private String codMonedaProf;
    private double valVtaTotFin;
    private String txtObserGestBanc;
    private String codEstadoAprob;
    private String flagActualiza;
    private String codUsuaSid;
    private String venFactura;//Req. 87567 E2.1 ID## avilca 16/06/2020
    private String codBanco; //Req. 87567 E1 ID 27 AVILCA 01/07/2020
    private String tFijo; //Req. 87567 E1 ID 27 AVILCA 01/07/2020

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getCodAreaVenta() {
        return codAreaVenta;
    }

    public void setCodAreaVenta(String codAreaVenta) {
        this.codAreaVenta = codAreaVenta;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }
    
    

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getCodPerso() {
        return codPerso;
    }

    public void setCodPerso(String codPerso) {
        this.codPerso = codPerso;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public String getNumTelfMovil() {
        return numTelfMovil;
    }

    public void setNumTelfMovil(String numTelfMovil) {
        this.numTelfMovil = numTelfMovil;
    }

    public String getDirCorreo() {
        return dirCorreo;
    }

    public void setDirCorreo(String dirCorreo) {
        this.dirCorreo = dirCorreo;
    }

    public String getObseCrea() {
        return obseCrea;
    }

    public void setObseCrea(String obseCrea) {
        this.obseCrea = obseCrea;
    }

    public String getTipoSoliCred() {
        return tipoSoliCred;
    }

    public void setTipoSoliCred(String tipoSoliCred) {
        this.tipoSoliCred = tipoSoliCred;
    }

    public String getCodRespFina() {
        return codRespFina;
    }

    public void setCodRespFina(String codRespFina) {
        this.codRespFina = codRespFina;
    }

    public String getCanPlazMes() {
        return canPlazMes;
    }

    public void setCanPlazMes(String canPlazMes) {
        this.canPlazMes = canPlazMes;
    }

    public String getCodMonedaProf() {
        return codMonedaProf;
    }

    public void setCodMonedaProf(String codMonedaProf) {
        this.codMonedaProf = codMonedaProf;
    }

    public double getValVtaTotFin() {
        return valVtaTotFin;
    }

    public void setValVtaTotFin(double valVtaTotFin) {
        this.valVtaTotFin = valVtaTotFin;
    }

    public String getTxtObserGestBanc() {
        return txtObserGestBanc;
    }

    public void setTxtObserGestBanc(String txtObserGestBanc) {
        this.txtObserGestBanc = txtObserGestBanc;
    }

    public String getCodEstadoAprob() {
        return codEstadoAprob;
    }

    public void setCodEstadoAprob(String codEstadoAprob) {
        this.codEstadoAprob = codEstadoAprob;
    }

    public String getFlagActualiza() {
        return flagActualiza;
    }

    public void setFlagActualiza(String flagActualiza) {
        this.flagActualiza = flagActualiza;
    }

    public String getCodUsuaSid() {
        return codUsuaSid;
    }

    public void setCodUsuaSid(String codUsuaSid) {
        this.codUsuaSid = codUsuaSid;
    }

    public String getVenFactura() {
        return venFactura;
    }

    public void setVenFactura(String venFactura) {
        this.venFactura = venFactura;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String gettFijo() {
        return tFijo;
    }

    public void settFijo(String tFijo) {
        this.tFijo = tFijo;
    }
       
}
