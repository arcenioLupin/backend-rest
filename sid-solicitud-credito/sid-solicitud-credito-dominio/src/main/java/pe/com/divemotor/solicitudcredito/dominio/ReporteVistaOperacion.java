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
public class ReporteVistaOperacion {

    private String codSoliCred;
    private String codOperRel;
    private String codEmpresa;
    private String nombreCliente;
    private String region;
    private String sucursal;
    private String totalUnidadesVendidas;
    private String unidades;
    private String fechaOtorgamiento;
    private Double valorTotalVenta;
    private String tipoFinanciamiento;
    private String tea;
    private String plazo;
    private String cuotaInicial;
    private Double comisionAdministrativa;
    private String gpsTotal;
    private String montoFinanciado;
    private String fechaVencimiento1Letra;
    private String periodoGracia;
    private String tipoPeriodoGracia;
    private Double seguroTotal;
    private Double saldoTotalPagar;
    private Double valorRealizGarantias;
    private Double saldoCapitalPagar;
    private Double ratioCobertGarantias;
    private String nroLetrasVencidas;
    private String asesorComercial;
    private Double montoDeudaVencida;
    private String jefeFinanzas;
    private String diasAtrazo;
    private String nivelAutonomiaCredi;
    private String sancionCredito;
    private String estadoOperacion;
    private String codClieSap;
  
   private String lcActual;
   private String ruc;
   private String existeGaraAdic;
   private String valorRealizacionAdic;
   private String fechaVencUltLet; //< Req. 87567 E2.1 ID## avilca 16/12/2020>

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTotalUnidadesVendidas() {
        return totalUnidadesVendidas;
    }

    public void setTotalUnidadesVendidas(String totalUnidadesVendidas) {
        this.totalUnidadesVendidas = totalUnidadesVendidas;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(String fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public Double getValorTotalVenta() {
        return valorTotalVenta;
    }

    public void setValorTotalVenta(Double valorTotalVenta) {
        this.valorTotalVenta = valorTotalVenta;
    }

    public String getTipoFinanciamiento() {
        return tipoFinanciamiento;
    }

    public void setTipoFinanciamiento(String tipoFinanciamiento) {
        this.tipoFinanciamiento = tipoFinanciamiento;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(String cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public Double getComisionAdministrativa() {
        return comisionAdministrativa;
    }

    public void setComisionAdministrativa(Double comisionAdministrativa) {
        this.comisionAdministrativa = comisionAdministrativa;
    }

    public String getGpsTotal() {
        return gpsTotal;
    }

    public void setGpsTotal(String gpsTotal) {
        this.gpsTotal = gpsTotal;
    }

    public String getMontoFinanciado() {
        return montoFinanciado;
    }

    public void setMontoFinanciado(String montoFinanciado) {
        this.montoFinanciado = montoFinanciado;
    }

    public String getFechaVencimiento1Letra() {
        return fechaVencimiento1Letra;
    }

    public void setFechaVencimiento1Letra(String fechaVencimiento1Letra) {
        this.fechaVencimiento1Letra = fechaVencimiento1Letra;
    }

    public String getPeriodoGracia() {
        return periodoGracia;
    }

    public void setPeriodoGracia(String periodoGracia) {
        this.periodoGracia = periodoGracia;
    }

    public String getTipoPeriodoGracia() {
        return tipoPeriodoGracia;
    }

    public void setTipoPeriodoGracia(String tipoPeriodoGracia) {
        this.tipoPeriodoGracia = tipoPeriodoGracia;
    }

    public Double getSeguroTotal() {
        return seguroTotal;
    }

    public void setSeguroTotal(Double seguroTotal) {
        this.seguroTotal = seguroTotal;
    }

    public Double getSaldoTotalPagar() {
        return saldoTotalPagar;
    }

    public void setSaldoTotalPagar(Double saldoTotalPagar) {
        this.saldoTotalPagar = saldoTotalPagar;
    }

    public Double getValorRealizGarantias() {
        return valorRealizGarantias;
    }

    public void setValorRealizGarantias(Double valorRealizGarantias) {
        this.valorRealizGarantias = valorRealizGarantias;
    }

    public Double getSaldoCapitalPagar() {
        return saldoCapitalPagar;
    }

    public void setSaldoCapitalPagar(Double saldoCapitalPagar) {
        this.saldoCapitalPagar = saldoCapitalPagar;
    }

    public Double getRatioCobertGarantias() {
        return ratioCobertGarantias;
    }

    public void setRatioCobertGarantias(Double ratioCobertGarantias) {
        this.ratioCobertGarantias = ratioCobertGarantias;
    }

    public String getNroLetrasVencidas() {
        return nroLetrasVencidas;
    }

    public void setNroLetrasVencidas(String nroLetrasVencidas) {
        this.nroLetrasVencidas = nroLetrasVencidas;
    }

    public String getAsesorComercial() {
        return asesorComercial;
    }

    public void setAsesorComercial(String asesorComercial) {
        this.asesorComercial = asesorComercial;
    }

    public Double getMontoDeudaVencida() {
        return montoDeudaVencida;
    }

    public void setMontoDeudaVencida(Double montoDeudaVencida) {
        this.montoDeudaVencida = montoDeudaVencida;
    }

    public String getJefeFinanzas() {
        return jefeFinanzas;
    }

    public void setJefeFinanzas(String jefeFinanzas) {
        this.jefeFinanzas = jefeFinanzas;
    }

    public String getDiasAtrazo() {
        return diasAtrazo;
    }

    public void setDiasAtrazo(String diasAtrazo) {
        this.diasAtrazo = diasAtrazo;
    }

    public String getNivelAutonomiaCredi() {
        return nivelAutonomiaCredi;
    }

    public void setNivelAutonomiaCredi(String nivelAutonomiaCredi) {
        this.nivelAutonomiaCredi = nivelAutonomiaCredi;
    }

    public String getSancionCredito() {
        return sancionCredito;
    }

    public void setSancionCredito(String sancionCredito) {
        this.sancionCredito = sancionCredito;
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public String getCodClieSap() {
        return codClieSap;
    }

    public void setCodClieSap(String codClieSap) {
        this.codClieSap = codClieSap;
    }

    public String getLcActual() {
        return lcActual;
    }

    public void setLcActual(String lcActual) {
        this.lcActual = lcActual;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getExisteGaraAdic() {
        return existeGaraAdic;
    }

    public void setExisteGaraAdic(String existeGaraAdic) {
        this.existeGaraAdic = existeGaraAdic;
    }

    public String getValorRealizacionAdic() {
        return valorRealizacionAdic;
    }

    public void setValorRealizacionAdic(String valorRealizacionAdic) {
        this.valorRealizacionAdic = valorRealizacionAdic;
    }

    public String getFechaVencUltLet() {
        return fechaVencUltLet;
    }

    public void setFechaVencUltLet(String fechaVencUltLet) {
        this.fechaVencUltLet = fechaVencUltLet;
    }

   
}
