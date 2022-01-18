/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.GarantiasCredito;
import pe.com.divemotor.solicitudcredito.dominio.OperacionesCredito;

/**
 *
 * @author jaltamirano
 */
public class ReporteVistaClienteExcelDataSource {

    private String codCliente;
    private String nomCliente;
    private String tipoDocumento;
    private String nroDocumento;
    private String asesorComercial;
    private String region;
    private String fechaReporte;
    private String fechaReporteGen;

    private List<OperacionesCredito> listaOperaciones;
    private List<GarantiasCredito> listaGarantias;

    private Double totalSaldoVigenteOPER;
    private Double totalValorComercialGARA;

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

    public List<OperacionesCredito> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<OperacionesCredito> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
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

}
