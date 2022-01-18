/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author legutierrez
 */
public class FormatoRDLHipotecariaAdicional {

    private String otorgante;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private String valMontOtorHip;
    private String valRealizGar;
    private String codRangoGar;
    private String desTipoActividad;

    public String getOtorgante() {
        return otorgante;
    }

    public void setOtorgante(String otorgante) {
        this.otorgante = otorgante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getValMontOtorHip() {
        return valMontOtorHip;
    }

    public void setValMontOtorHip(String valMontOtorHip) {
        this.valMontOtorHip = valMontOtorHip;
    }

    public String getValRealizGar() {
        return valRealizGar;
    }

    public void setValRealizGar(String valRealizGar) {
        this.valRealizGar = valRealizGar;
    }

    public String getCodRangoGar() {
        return codRangoGar;
    }

    public void setCodRangoGar(String codRangoGar) {
        this.codRangoGar = codRangoGar;
    }

    public String getDesTipoActividad() {
        return desTipoActividad;
    }

    public void setDesTipoActividad(String desTipoActividad) {
        this.desTipoActividad = desTipoActividad;
    }

}
