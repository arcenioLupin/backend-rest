/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author phramirez
 */
public class Correo {
    private long codCorreo;
    private String codRefProc;
    private String tipoRefProc;
    private String destinatarios;
    private String copia;
    private String asunto;
    private String cuerpo;
    private String correoOrigen;
    private String indEnviado;
    private String indInactivo;
    private String nombre;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    public long getCodCorreo() {
        return codCorreo;
    }

    public void setCodCorreo(long codCorreo) {
        this.codCorreo = codCorreo;
    }

    public String getCodRefProc() {
        return codRefProc;
    }

    public void setCodRefProc(String codRefProc) {
        this.codRefProc = codRefProc;
    }

    public String getTipoRefProc() {
        return tipoRefProc;
    }

    public void setTipoRefProc(String tipoRefProc) {
        this.tipoRefProc = tipoRefProc;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getCopia() {
        return copia;
    }

    public void setCopia(String copia) {
        this.copia = copia;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getCorreoOrigen() {
        return correoOrigen;
    }

    public void setCorreoOrigen(String correoOrigen) {
        this.correoOrigen = correoOrigen;
    }

    public String getIndEnviado() {
        return indEnviado;
    }

    public void setIndEnviado(String indEnviado) {
        this.indEnviado = indEnviado;
    }

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }
}
