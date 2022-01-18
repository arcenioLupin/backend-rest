/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

/**
 *
 * @author avilca
 */
public class SdtProtestosListItem {

    private String tipoDocumentoAcre;
    private String nroDocumentoAcre;
    private String razonSocialAcre;
    private String nroDocumetos;
    private String monedaDocumento;
    private double montoDocumento;
    private double montoSoles;
    private String tipoDocumentoProtestado;
    private String fechaProtesto;
    private String fechaVencimiento;
    private String diaVencidos;

    public String getTipoDocumentoAcre() {
        return tipoDocumentoAcre;
    }

    public void setTipoDocumentoAcre(String tipoDocumentoAcre) {
        this.tipoDocumentoAcre = tipoDocumentoAcre;
    }

    public String getNroDocumentoAcre() {
        return nroDocumentoAcre;
    }

    public void setNroDocumentoAcre(String nroDocumentoAcre) {
        this.nroDocumentoAcre = nroDocumentoAcre;
    }

    public String getRazonSocialAcre() {
        return razonSocialAcre;
    }

    public void setRazonSocialAcre(String razonSocialAcre) {
        this.razonSocialAcre = razonSocialAcre;
    }

    public String getNroDocumetos() {
        return nroDocumetos;
    }

    public void setNroDocumetos(String nroDocumetos) {
        this.nroDocumetos = nroDocumetos;
    }

    public String getMonedaDocumento() {
        return monedaDocumento;
    }

    public void setMonedaDocumento(String monedaDocumento) {
        this.monedaDocumento = monedaDocumento;
    }

    public double getMontoDocumento() {
        return montoDocumento;
    }

    public void setMontoDocumento(double montoDocumento) {
        this.montoDocumento = montoDocumento;
    }

    public double getMontoSoles() {
        return montoSoles;
    }

    public void setMontoSoles(double montoSoles) {
        this.montoSoles = montoSoles;
    }

    public String getTipoDocumentoProtestado() {
        return tipoDocumentoProtestado;
    }

    public void setTipoDocumentoProtestado(String tipoDocumentoProtestado) {
        this.tipoDocumentoProtestado = tipoDocumentoProtestado;
    }

    public String getFechaProtesto() {
        return fechaProtesto;
    }

    public void setFechaProtesto(String fechaProtesto) {
        this.fechaProtesto = fechaProtesto;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDiaVencidos() {
        return diaVencidos;
    }

    public void setDiaVencidos(String diaVencidos) {
        this.diaVencidos = diaVencidos;
    }

}
