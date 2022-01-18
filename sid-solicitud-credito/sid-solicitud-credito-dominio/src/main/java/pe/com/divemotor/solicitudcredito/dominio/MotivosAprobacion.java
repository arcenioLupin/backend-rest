/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author //ECUBAS <I>89642
 */
public class MotivosAprobacion {
    private String fechaAprobacion;
    private String nombres;
    private String comentarioAprobacion;
    
    public void setFechaAprobacion(String fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getFechaAprobacion() {
        return fechaAprobacion;
    }
    
    public void setFechaNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }
    
    public void setComentarioAprobacionn(String comentarioAprobacion) {
        this.comentarioAprobacion = comentarioAprobacion;
    }

    public String getComentarioAprobacion() {
        return comentarioAprobacion;
    }
}
