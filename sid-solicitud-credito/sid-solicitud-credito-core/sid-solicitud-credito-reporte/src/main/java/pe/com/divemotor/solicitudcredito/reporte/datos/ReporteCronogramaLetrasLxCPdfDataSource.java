/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxC;

/**
 *
 * @author mbardales
 */
public class ReporteCronogramaLetrasLxCPdfDataSource {

    private String totalCuotas;
    private Double totalFinanciado;
    private Double totalAmortizacion;
    private Double totalInteres;
    private Double totalIgv;
    private Double totalIsc;
    private Double totalSeguro;
    private Double totalCuota;

    private String noCia;
    private String grupo;
    private String codOper;
    private String tea;
    private String estado;
    private String fechaCronograma;
    private String moneda;
    private String tipoCambio;
    private String noCliente;
    private String totalFinanciar;
    private String nroCuotas;
    private String fechaActual;
    private String nomCliente;
    private String usuario;//<Req. 87567 E2.1 ID 205 avilca 13/08/2020>


    private List<CronogramaLetrasLxC> cronogramaLetras;

    public String getTotalCuotas() {
        return totalCuotas;
    }

    public void setTotalCuotas(String totalCuotas) {
        this.totalCuotas = totalCuotas;
    }

    public Double getTotalFinanciado() {
        return totalFinanciado;
    }

    public void setTotalFinanciado(Double totalFinanciado) {
        this.totalFinanciado = totalFinanciado;
    }

    public Double getTotalAmortizacion() {
        return totalAmortizacion;
    }

    public void setTotalAmortizacion(Double totalAmortizacion) {
        this.totalAmortizacion = totalAmortizacion;
    }

    public Double getTotalInteres() {
        return totalInteres;
    }

    public void setTotalInteres(Double totalInteres) {
        this.totalInteres = totalInteres;
    }

    public Double getTotalIgv() {
        return totalIgv;
    }

    public void setTotalIgv(Double totalIgv) {
        this.totalIgv = totalIgv;
    }

    public Double getTotalIsc() {
        return totalIsc;
    }

    public void setTotalIsc(Double totalIsc) {
        this.totalIsc = totalIsc;
    }

    public Double getTotalSeguro() {
        return totalSeguro;
    }

    public void setTotalSeguro(Double totalSeguro) {
        this.totalSeguro = totalSeguro;
    }

    public Double getTotalCuota() {
        return totalCuota;
    }

    public void setTotalCuota(Double totalCuota) {
        this.totalCuota = totalCuota;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCronograma() {
        return fechaCronograma;
    }

    public void setFechaCronograma(String fechaCronograma) {
        this.fechaCronograma = fechaCronograma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }

    public String getTotalFinanciar() {
        return totalFinanciar;
    }

    public void setTotalFinanciar(String totalFinanciar) {
        this.totalFinanciar = totalFinanciar;
    }

    public String getNroCuotas() {
        return nroCuotas;
    }

    public void setNroCuotas(String nroCuotas) {
        this.nroCuotas = nroCuotas;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public List<CronogramaLetrasLxC> getCronogramaLetras() {
        return cronogramaLetras;
    }

    public void setCronogramaLetras(List<CronogramaLetrasLxC> cronogramaLetras) {
        this.cronogramaLetras = cronogramaLetras;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
}
