/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaGarantia;

/**
 *
 * @author egonzales
 */
public class CoberturaGarantiaResponse extends BasePaginadoProcedure<CoberturaGarantia> {

    private String codigo;
    private String estadoTrama;
    private String mensaje;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstadoTrama() {
        return estadoTrama;
    }

    public void setEstadoTrama(String estadoTrama) {
        this.estadoTrama = estadoTrama;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
