/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.creditoOtorgado;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ReporteCreditoOtorgado;

/**
 *
 * @author jaltamirano
 */
public class ListarReporteCreditoOtorgadoProcedure extends BasePaginadoProcedure<ReporteCreditoOtorgado> {

    private String codRegion;
    private String codAreaVenta;
    private String codTipoOperacion;
    private String fechaFactuInicio;
    private String fechaFactuFin;
    private String opAprobados;
    private Integer retCantidad;
    private String cliente;
    private String rucCliente;
    private String fechaOpeInicio;
    private String fechaOpeFin;    

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getCodAreaVenta() {
        return codAreaVenta;
    }

    public void setCodAreaVenta(String codAreaVenta) {
        this.codAreaVenta = codAreaVenta;
    }

    public String getCodTipoOperacion() {
        return codTipoOperacion;
    }

    public void setCodTipoOperacion(String codTipoOperacion) {
        this.codTipoOperacion = codTipoOperacion;
    }

    public String getFechaFactuInicio() {
        return fechaFactuInicio;
    }

    public void setFechaFactuInicio(String fechaFactuInicio) {
        this.fechaFactuInicio = fechaFactuInicio;
    }

    public String getFechaFactuFin() {
        return fechaFactuFin;
    }

    public void setFechaFactuFin(String fechaFactuFin) {
        this.fechaFactuFin = fechaFactuFin;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

    public String getOpAprobados() {
        return opAprobados;
    }

    public void setOpAprobados(String opAprobados) {
        this.opAprobados = opAprobados;
    }
//<I Req. 87567 E2.1 ID:12 avilca 16/09/2020> 
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getFechaOpeInicio() {
        return fechaOpeInicio;
    }

    public void setFechaOpeInicio(String fechaOpeInicio) {
        this.fechaOpeInicio = fechaOpeInicio;
    }

    public String getFechaOpeFin() {
        return fechaOpeFin;
    }

    public void setFechaOpeFin(String fechaOpeFin) {
        this.fechaOpeFin = fechaOpeFin;
    }
  //<F Req. 87567 E2.1 ID:12 avilca 16/09/2020>   
}
