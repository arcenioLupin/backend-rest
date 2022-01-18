/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author phramirez
 */
public class SolicitudCredito {

    private String codSoliCred;
    private String txtObseCrea;
    private Integer canPlazMes;
    private String codAreaVta;
    private String desAreaVta;
    private String fecSoliCred;
    private String region;
    private String nombreZona;
    private String codZona;
    private String nombreSucursal;
    private String codSucursal;
    private String nombreVendedor;
    private String codVendedor;
    private String nombreFilial;
    private String codFilial;
    private String codClie;
    private String nomPerso;
    private String codEstadoCivil;
    private String codTipoPerso;
    private String tipoPerso;
    private String indMancomunado;
    private String numDocuIden;
    private String numRuc;
    private String dirCorreo;
    private String numTelfMovil;
    private String telefono; /* Req. 87567 E2.1 ID:20 AVILCA 15/05/2020*/ 
    private String tipSoliCred;
    private String desTipoSoliCred;
    private String codEstado;
    private String desEstado;
    private String fecAproClie;
    private String actActual;
    private String codPersSoli;
    private String desPersSoli;
    private String codRespFina;
    private String desRespFina;
    private String codEmpr;
    private String desNomEmpr;
    private String numProfVeh;
    private String valVtaTotFin;
    private String codMonedaProf;
    private String vendedor;
    private String numFichaVenta;
    private String codBanco;
    private String montoSolCred;
    private String valMontSolGestBanc;
    private String valPorcGestBanc;
    private String fecIngrGestBanc;
    private String fecIngrRiesGestBanc;
    private String fecAprobCartBan;
    private String fecResuGestBanc;
    private String codEstaGestBanc;
    private String txtObseGestBanc;
    private String indPagoContado;
    private String indCredAprobado;
    private String indBloqueoPestanias;
    private String indCredVehi;
    private String indGestBanc;
    private String estaGestBanc;
    private String canVehFin;
    private String valPreVeh;
    private String igv;
    private String ir;
    private String valParaNum;
    private String codOperRel;
    private String codOperOrig;
    private String canTotaLetr;
    private String valPorcTea;
    private String valPorcCI;
    private String codClieSap;
    private Double valCI;
    private Double valPagoContCI;
    private String fecVenc1raLet;
    private Integer canDiasVenc1raLetr;
    private String codPeriCredSoli;
    private String indTipoPeriGrac;
    private Double valDiasPeriGrac;
    private Integer canLetrPeriGrac;
    private Double valIntPerGra;
    private Double valPorcTEASIGV;
    private Double valPorcTEPSIGV;
    private String indGPS;
    private Double valPorcCuotBall;
    private Double valCuotBall;
    private String indTipoSegu;
    private String codCiaSeg;
    private String codTipUsoVeh;
    private Double valTasaSegu;
    private Double valPrimSeg;
    private String codTipoUnid;
    private Double valPorcGastAdmi;
    private Double valGastoAdmi;
    private Double tipoCambio;
    private String indCredRecha;
    private String fecUltiFecCrono;
    private String txtOtrCond;
    private Double valTipoCambio;
    /* I Req. 87567 E2.1 ID:20 AVILCA 12/06/2020*/ 
    private String venFactura;
    private String obseJv;
   /* F Req. 87567 E2.1 ID:20 AVILCA 12/06/2020*/ 
   private String canGaraSoli; /* Req. 87567 E2.1 ID:112 AVILCA 27/07/2020*/ 
   private String indRespAproTseg;
   private String indSinInt;
   
    public Double getValTipoCambio() {
        return valTipoCambio;
    }

    public void setValTipoCambio(Double valTipoCambio) {
        this.valTipoCambio = valTipoCambio;
    }
    

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTxtObseCrea() {
        return txtObseCrea;
    }

    public void setTxtObseCrea(String txtObseCrea) {
        this.txtObseCrea = txtObseCrea;
    }

    public Integer getCanPlazMes() {
        return canPlazMes;
    }

    public void setCanPlazMes(Integer canPlazMes) {
        this.canPlazMes = canPlazMes;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getDesAreaVta() {
        return desAreaVta;
    }

    public void setDesAreaVta(String desAreaVta) {
        this.desAreaVta = desAreaVta;
    }

    public String getFecSoliCred() {
        return fecSoliCred;
    }

    public void setFecSoliCred(String fecSoliCred) {
        this.fecSoliCred = fecSoliCred;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }
    
    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getNombreFilial() {
        return nombreFilial;
    }

    public void setNombreFilial(String nombreFilial) {
        this.nombreFilial = nombreFilial;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }
    
    

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNomPerso() {
        return nomPerso;
    }

    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }

    public String getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getCodTipoPerso() {
        return codTipoPerso;
    }

    public void setCodTipoPerso(String codTipoPerso) {
        this.codTipoPerso = codTipoPerso;
    }

    public String getTipoPerso() {
        return tipoPerso;
    }

    public void setTipoPerso(String tipoPerso) {
        this.tipoPerso = tipoPerso;
    }

    public String getIndMancomunado() {
        return indMancomunado;
    }

    public void setIndMancomunado(String indMancomunado) {
        this.indMancomunado = indMancomunado;
    }

    public String getNumDocuIden() {
        return numDocuIden;
    }

    public void setNumDocuIden(String numDocuIden) {
        this.numDocuIden = numDocuIden;
    }

    public String getNumRuc() {
        return numRuc;
    }

    public void setNumRuc(String numRuc) {
        this.numRuc = numRuc;
    }

    public String getDirCorreo() {
        return dirCorreo;
    }

    public void setDirCorreo(String dirCorreo) {
        this.dirCorreo = dirCorreo;
    }

    public String getNumTelfMovil() {
        return numTelfMovil;
    }

    public void setNumTelfMovil(String numTelfMovil) {
        this.numTelfMovil = numTelfMovil;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getDesTipoSoliCred() {
        return desTipoSoliCred;
    }

    public void setDesTipoSoliCred(String desTipoSoliCred) {
        this.desTipoSoliCred = desTipoSoliCred;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(String desEstado) {
        this.desEstado = desEstado;
    }

    public String getFecAproClie() {
        return fecAproClie;
    }

    public void setFecAproClie(String fecAproClie) {
        this.fecAproClie = fecAproClie;
    }

    public String getActActual() {
        return actActual;
    }

    public void setActActual(String actActual) {
        this.actActual = actActual;
    }

    public String getCodPersSoli() {
        return codPersSoli;
    }

    public void setCodPersSoli(String codPersSoli) {
        this.codPersSoli = codPersSoli;
    }

    public String getDesPersSoli() {
        return desPersSoli;
    }

    public void setDesPersSoli(String desPersSoli) {
        this.desPersSoli = desPersSoli;
    }

    public String getCodRespFina() {
        return codRespFina;
    }

    public void setCodRespFina(String codRespFina) {
        this.codRespFina = codRespFina;
    }

    public String getDesRespFina() {
        return desRespFina;
    }

    public void setDesRespFina(String desRespFina) {
        this.desRespFina = desRespFina;
    }

    public String getCodEmpr() {
        return codEmpr;
    }

    public void setCodEmpr(String codEmpr) {
        this.codEmpr = codEmpr;
    }

    public String getDesNomEmpr() {
        return desNomEmpr;
    }

    public void setDesNomEmpr(String desNomEmpr) {
        this.desNomEmpr = desNomEmpr;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public String getValVtaTotFin() {
        return valVtaTotFin;
    }

    public void setValVtaTotFin(String valVtaTotFin) {
        this.valVtaTotFin = valVtaTotFin;
    }

    public String getCodMonedaProf() {
        return codMonedaProf;
    }

    public void setCodMonedaProf(String codMonedaProf) {
        this.codMonedaProf = codMonedaProf;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNumFichaVenta() {
        return numFichaVenta;
    }

    public void setNumFichaVenta(String numFichaVenta) {
        this.numFichaVenta = numFichaVenta;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getMontoSolCred() {
        return montoSolCred;
    }

    public void setMontoSolCred(String montoSolCred) {
        this.montoSolCred = montoSolCred;
    }

    public String getValMontSolGestBanc() {
        return valMontSolGestBanc;
    }

    public void setValMontSolGestBanc(String valMontSolGestBanc) {
        this.valMontSolGestBanc = valMontSolGestBanc;
    }

    public String getValPorcGestBanc() {
        return valPorcGestBanc;
    }

    public void setValPorcGestBanc(String valPorcGestBanc) {
        this.valPorcGestBanc = valPorcGestBanc;
    }

    public String getFecIngrGestBanc() {
        return fecIngrGestBanc;
    }

    public void setFecIngrGestBanc(String fecIngrGestBanc) {
        this.fecIngrGestBanc = fecIngrGestBanc;
    }

    public String getFecIngrRiesGestBanc() {
        return fecIngrRiesGestBanc;
    }

    public void setFecIngrRiesGestBanc(String fecIngrRiesGestBanc) {
        this.fecIngrRiesGestBanc = fecIngrRiesGestBanc;
    }

    public String getFecAprobCartBan() {
        return fecAprobCartBan;
    }

    public void setFecAprobCartBan(String fecAprobCartBan) {
        this.fecAprobCartBan = fecAprobCartBan;
    }

    public String getFecResuGestBanc() {
        return fecResuGestBanc;
    }

    public void setFecResuGestBanc(String fecResuGestBanc) {
        this.fecResuGestBanc = fecResuGestBanc;
    }

    public String getCodEstaGestBanc() {
        return codEstaGestBanc;
    }

    public void setCodEstaGestBanc(String codEstaGestBanc) {
        this.codEstaGestBanc = codEstaGestBanc;
    }

    public String getTxtObseGestBanc() {
        return txtObseGestBanc;
    }

    public void setTxtObseGestBanc(String txtObseGestBanc) {
        this.txtObseGestBanc = txtObseGestBanc;
    }

    public String getIndPagoContado() {
        return indPagoContado;
    }

    public void setIndPagoContado(String indPagoContado) {
        this.indPagoContado = indPagoContado;
    }

    public String getIndCredAprobado() {
        return indCredAprobado;
    }

    public void setIndCredAprobado(String indCredAprobado) {
        this.indCredAprobado = indCredAprobado;
    }

    public String getIndBloqueoPestanias() {
        return indBloqueoPestanias;
    }

    public void setIndBloqueoPestanias(String indBloqueoPestanias) {
        this.indBloqueoPestanias = indBloqueoPestanias;
    }

    public String getIndCredVehi() {
        return indCredVehi;
    }

    public void setIndCredVehi(String indCredVehi) {
        this.indCredVehi = indCredVehi;
    }

    public String getIndGestBanc() {
        return indGestBanc;
    }

    public void setIndGestBanc(String indGestBanc) {
        this.indGestBanc = indGestBanc;
    }

    public String getEstaGestBanc() {
        return estaGestBanc;
    }

    public void setEstaGestBanc(String estaGestBanc) {
        this.estaGestBanc = estaGestBanc;
    }

    public String getCanVehFin() {
        return canVehFin;
    }

    public void setCanVehFin(String canVehFin) {
        this.canVehFin = canVehFin;
    }

    public String getValPreVeh() {
        return valPreVeh;
    }

    public void setValPreVeh(String valPreVeh) {
        this.valPreVeh = valPreVeh;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getValParaNum() {
        return valParaNum;
    }

    public void setValParaNum(String valParaNum) {
        this.valParaNum = valParaNum;
    }

    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }

    public String getCodOperOrig() {
        return codOperOrig;
    }

    public void setCodOperOrig(String codOperOrig) {
        this.codOperOrig = codOperOrig;
    }

    public String getCanTotaLetr() {
        return canTotaLetr;
    }

    public void setCanTotaLetr(String canTotaLetr) {
        this.canTotaLetr = canTotaLetr;
    }

    public String getValPorcTea() {
        return valPorcTea;
    }

    public void setValPorcTea(String valPorcTea) {
        this.valPorcTea = valPorcTea;
    }

    public String getValPorcCI() {
        return valPorcCI;
    }

    public void setValPorcCI(String valPorcCI) {
        this.valPorcCI = valPorcCI;
    }

    public String getCodClieSap() {
        return codClieSap;
    }

    public void setCodClieSap(String codClieSap) {
        this.codClieSap = codClieSap;
    }

    public Double getValCI() {
        return valCI;
    }

    public void setValCI(Double valCI) {
        this.valCI = valCI;
    }

    public Double getValPagoContCI() {
        return valPagoContCI;
    }

    public void setValPagoContCI(Double valPagoContCI) {
        this.valPagoContCI = valPagoContCI;
    }

    public String getFecVenc1raLet() {
        return fecVenc1raLet;
    }

    public void setFecVenc1raLet(String fecVenc1raLet) {
        this.fecVenc1raLet = fecVenc1raLet;
    }

    public Integer getCanDiasVenc1raLetr() {
        return canDiasVenc1raLetr;
    }

    public void setCanDiasVenc1raLetr(Integer canDiasVenc1raLetr) {
        this.canDiasVenc1raLetr = canDiasVenc1raLetr;
    }

    public String getCodPeriCredSoli() {
        return codPeriCredSoli;
    }

    public void setCodPeriCredSoli(String codPeriCredSoli) {
        this.codPeriCredSoli = codPeriCredSoli;
    }

    public String getIndTipoPeriGrac() {
        return indTipoPeriGrac;
    }

    public void setIndTipoPeriGrac(String indTipoPeriGrac) {
        this.indTipoPeriGrac = indTipoPeriGrac;
    }

    public Double getValDiasPeriGrac() {
        return valDiasPeriGrac;
    }

    public void setValDiasPeriGrac(Double valDiasPeriGrac) {
        this.valDiasPeriGrac = valDiasPeriGrac;
    }

    public Integer getCanLetrPeriGrac() {
        return canLetrPeriGrac;
    }

    public void setCanLetrPeriGrac(Integer canLetrPeriGrac) {
        this.canLetrPeriGrac = canLetrPeriGrac;
    }

    public Double getValIntPerGra() {
        return valIntPerGra;
    }

    public void setValIntPerGra(Double valIntPerGra) {
        this.valIntPerGra = valIntPerGra;
    }

    public Double getValPorcTEASIGV() {
        return valPorcTEASIGV;
    }

    public void setValPorcTEASIGV(Double valPorcTEASIGV) {
        this.valPorcTEASIGV = valPorcTEASIGV;
    }

    public Double getValPorcTEPSIGV() {
        return valPorcTEPSIGV;
    }

    public void setValPorcTEPSIGV(Double valPorcTEPSIGV) {
        this.valPorcTEPSIGV = valPorcTEPSIGV;
    }

    public String getIndGPS() {
        return indGPS;
    }

    public void setIndGPS(String indGPS) {
        this.indGPS = indGPS;
    }

    public Double getValPorcCuotBall() {
        return valPorcCuotBall;
    }

    public void setValPorcCuotBall(Double valPorcCuotBall) {
        this.valPorcCuotBall = valPorcCuotBall;
    }

    public Double getValCuotBall() {
        return valCuotBall;
    }

    public void setValCuotBall(Double valCuotBall) {
        this.valCuotBall = valCuotBall;
    }

    public String getIndTipoSegu() {
        return indTipoSegu;
    }

    public void setIndTipoSegu(String indTipoSegu) {
        this.indTipoSegu = indTipoSegu;
    }

    public String getCodCiaSeg() {
        return codCiaSeg;
    }

    public void setCodCiaSeg(String codCiaSeg) {
        this.codCiaSeg = codCiaSeg;
    }

    public String getCodTipUsoVeh() {
        return codTipUsoVeh;
    }

    public void setCodTipUsoVeh(String codTipUsoVeh) {
        this.codTipUsoVeh = codTipUsoVeh;
    }

    public Double getValTasaSegu() {
        return valTasaSegu;
    }

    public void setValTasaSegu(Double valTasaSegu) {
        this.valTasaSegu = valTasaSegu;
    }

    public Double getValPrimSeg() {
        return valPrimSeg;
    }

    public void setValPrimSeg(Double valPrimSeg) {
        this.valPrimSeg = valPrimSeg;
    }

    public String getCodTipoUnid() {
        return codTipoUnid;
    }

    public void setCodTipoUnid(String codTipoUnid) {
        this.codTipoUnid = codTipoUnid;
    }

    public Double getValPorcGastAdmi() {
        return valPorcGastAdmi;
    }

    public void setValPorcGastAdmi(Double valPorcGastAdmi) {
        this.valPorcGastAdmi = valPorcGastAdmi;
    }

    public Double getValGastoAdmi() {
        return valGastoAdmi;
    }

    public void setValGastoAdmi(Double valGastoAdmi) {
        this.valGastoAdmi = valGastoAdmi;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getIndCredRecha() {
        return indCredRecha;
    }

    public void setIndCredRecha(String indCredRecha) {
        this.indCredRecha = indCredRecha;
    }

    public String getFecUltiFecCrono() {
        return fecUltiFecCrono;
    }

    public void setFecUltiFecCrono(String fecUltiFecCrono) {
        this.fecUltiFecCrono = fecUltiFecCrono;
    }

    public String getTxtOtrCond() {
        return txtOtrCond;
    }

    public void setTxtOtrCond(String txtOtrCond) {
        this.txtOtrCond = txtOtrCond;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVenFactura() {
        return venFactura;
    }

    public void setVenFactura(String venFactura) {
        this.venFactura = venFactura;
    }

    public String getObseJv() {
        return obseJv;
    }

    public void setObseJv(String obseJv) {
        this.obseJv = obseJv;
    } 

    public String getCanGaraSoli() {
        return canGaraSoli;
    }

    public void setCanGaraSoli(String canGaraSoli) {
        this.canGaraSoli = canGaraSoli;
    }

    public String getIndRespAproTseg() {
        return indRespAproTseg;
    }

    public void setIndRespAproTseg(String indRespAproTseg) {
        this.indRespAproTseg = indRespAproTseg;
    }

    public String getIndSinInt() {
        return indSinInt;
    }

    public void setIndSinInt(String indSinInt) {
        this.indSinInt = indSinInt;
    }
    
}
