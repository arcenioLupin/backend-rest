/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

/**
 *
 * @author legutierrez
 */
public class SDTInfoDetalleRepresentanteLegalItemEmpresasRelacionadasItem {

    private String tipoDocumento;
    private String nroDocumento;
    private String razonSocial;
    private String cargo;
    private String fechaInicioCargo;
    private String estado;

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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaInicioCargo() {
        return fechaInicioCargo;
    }

    public void setFechaInicioCargo(String fechaInicioCargo) {
        this.fechaInicioCargo = fechaInicioCargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
