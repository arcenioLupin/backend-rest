/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author legutierrez
 */
public class SDTInfoDetalleRepresentanteLegalItem {
    
    private String tipoDocumento;
    private String nroDocumento;
    private String razonSocial;
    private String fechaNacimiento;
    private String cargo;
    private String fechaInicioCargo;
    private SDTInfoDetalleRepresentanteLegalItem.EmpresasRelacionadas empresasRelacionadas;

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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public SDTInfoDetalleRepresentanteLegalItem.EmpresasRelacionadas getEmpresasRelacionadas() {
        return empresasRelacionadas;
    }

    public void setEmpresasRelacionadas(SDTInfoDetalleRepresentanteLegalItem.EmpresasRelacionadas empresasRelacionadas) {
        this.empresasRelacionadas = empresasRelacionadas;
    }
    
    
    
    public static class EmpresasRelacionadas {
        
        private List<SDTInfoDetalleRepresentanteLegalItemEmpresasRelacionadasItem> empresasRelacionadasItem;

        public List<SDTInfoDetalleRepresentanteLegalItemEmpresasRelacionadasItem> getEmpresasRelacionadasItem() {
            if (empresasRelacionadasItem == null) {
                empresasRelacionadasItem = new ArrayList<SDTInfoDetalleRepresentanteLegalItemEmpresasRelacionadasItem>();
            }
            return this.empresasRelacionadasItem;
        }

        public void setEmpresasRelacionadasItem(List<SDTInfoDetalleRepresentanteLegalItemEmpresasRelacionadasItem> empresasRelacionadasItem) {
            this.empresasRelacionadasItem = empresasRelacionadasItem;
        }
        
        
    }
}
