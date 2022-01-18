/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;

/**
 *
 * @author jaltamirano
 */
public class ReporteVistaCliente {

    //Datos Generales
    private String codCliente; //
    private String nomCliente;
    private String tipoDocumento;
    private String nroDocumento;
    private String asesorComercial;
    private String region;
    private String fechaReporte;
    private String fechaReporteGen;

    //Operaciones
    private String nroCia;
    private String nroOperacion;
    private String tipoOperacion;
    private String fechaOtorgamiento;
    private String fechaVencimientoUL;
    private String plazoDias;
    private String status;
    private String divisa;
    private Double saldoOriginal;
    private Double salgoVigente;
    private String tea;
    private Double ratioCoberturaGara;
    private List<OperacionesCredito> listaOperaciones;

    //Garantias
    //private String nroOperacion;
    private String nroGarantia;
    private String tipoGarantia;
    private String nroPoliza;
    private String codEstaPoliza;
    private String estadoPoliza;
    private String divisaOrigen;
    private Double valorComercial;
    private Double valorRealizacion;
    private String fechaConstitucion;
    private List<GarantiasCredito> listaGarantias;
    private Double totalSaldoVigenteOPER;
    private Double totalValorComercialGARA;
    private Double valMonFin;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getAsesorComercial() {
        return asesorComercial;
    }

    public void setAsesorComercial(String asesorComercial) {
        this.asesorComercial = asesorComercial;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getFechaReporteGen() {
        return fechaReporteGen;
    }

    public void setFechaReporteGen(String fechaReporteGen) {
        this.fechaReporteGen = fechaReporteGen;
    }

    public String getNroCia() {
        return nroCia;
    }

    public void setNroCia(String nroCia) {
        this.nroCia = nroCia;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(String fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public String getFechaVencimientoUL() {
        return fechaVencimientoUL;
    }

    public void setFechaVencimientoUL(String fechaVencimientoUL) {
        this.fechaVencimientoUL = fechaVencimientoUL;
    }

    public String getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(String plazoDias) {
        this.plazoDias = plazoDias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Double getSaldoOriginal() {
        return saldoOriginal;
    }

    public void setSaldoOriginal(Double saldoOriginal) {
        this.saldoOriginal = saldoOriginal;
    }

    public Double getSalgoVigente() {
        return salgoVigente;
    }

    public void setSalgoVigente(Double salgoVigente) {
        this.salgoVigente = salgoVigente;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public Double getRatioCoberturaGara() {
        return ratioCoberturaGara;
    }

    public void setRatioCoberturaGara(Double ratioCoberturaGara) {
        this.ratioCoberturaGara = ratioCoberturaGara;
    }

    public List<OperacionesCredito> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<OperacionesCredito> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }

    public String getNroGarantia() {
        return nroGarantia;
    }

    public void setNroGarantia(String nroGarantia) {
        this.nroGarantia = nroGarantia;
    }

    public String getTipoGarantia() {
        return tipoGarantia;
    }

    public void setTipoGarantia(String tipoGarantia) {
        this.tipoGarantia = tipoGarantia;
    }

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public String getCodEstaPoliza() {
        return codEstaPoliza;
    }

    public void setCodEstaPoliza(String codEstaPoliza) {
        this.codEstaPoliza = codEstaPoliza;
    }

    public String getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(String estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    public void setDivisaOrigen(String divisaOrigen) {
        this.divisaOrigen = divisaOrigen;
    }

    public Double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(Double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public Double getValorRealizacion() {
        return valorRealizacion;
    }

    public void setValorRealizacion(Double valorRealizacion) {
        this.valorRealizacion = valorRealizacion;
    }

    public String getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(String fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public List<GarantiasCredito> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<GarantiasCredito> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }

    public Double getTotalSaldoVigenteOPER() {
        return totalSaldoVigenteOPER;
    }

    public void setTotalSaldoVigenteOPER(Double totalSaldoVigenteOPER) {
        this.totalSaldoVigenteOPER = totalSaldoVigenteOPER;
    }

    public Double getTotalValorComercialGARA() {
        return totalValorComercialGARA;
    }

    public void setTotalValorComercialGARA(Double totalValorComercialGARA) {
        this.totalValorComercialGARA = totalValorComercialGARA;
    }

    public Double getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(Double valMonFin) {
        this.valMonFin = valMonFin;
    }
    
    
}
