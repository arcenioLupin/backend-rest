/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author jaltamirano
 */
public class ReporteCreditoOtorgadoRequest extends BaseRequest {

    private String codAreaVenta;
    private String codRegion;
    private String codTipoOperacion;
    private String fechaFactuInicio;
    private String fechaFactuFin;
    private String opAprobados;
    //I Req. 87567 E2.1 ID:12 avilca 16/09/2020
    private String cliente;
    private String rucCliente;
    private String fechaOpeInicio;
    private String fechaOpeFin;
    //F Req. 87567 E2.1 ID:12 avilca 16/09/2020
    public String getCodAreaVenta() {
        return codAreaVenta;
    }

    public void setCodAreaVenta(String codAreaVenta) {
        this.codAreaVenta = codAreaVenta;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
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

    public String getOpAprobados() {
        return opAprobados;
    }

    public void setOpAprobados(String opAprobados) {
        this.opAprobados = opAprobados;
    }
//I Req. 87567 E2.1 ID:12 avilca 16/09/2020
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
   //F Req. 87567 E2.1 ID:12 avilca 16/09/2020
}
