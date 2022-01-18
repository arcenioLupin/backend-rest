/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

/**
 *
 * @author jaltamirano
 */
public class ClienteRequest {

    private String codCliente;
    private String nroSolicitud;
    private String codClieSap;
    private String nombreCliente;
    private String codTipoDocumento;
    private String nroDocumento;
    private String codTipoPersona;
    private String codTipoCredito;
    private String codAreaVta;
    private String codFilial;
    private String codZona;
    private String codCia;
    private String codPais;
    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String codEstadoSolicitud;
    private String estadoClie;

    //Variables para listadoGarantias
    //codCliente
    private String codOperacion;
    private String codGarantia;
    private String tipoGarantia;
    private String codEstaPoliza;
    private String codEstaGarantia;
    
    private String estadoGarantia;
    private String codMarca;
    private String anioFabricacion;
    
    //Variables para listadoOperaciones
    //codCliente
    //codOperacion
    //codTipoCredito
    private String codMoneda;
    private String codEstaOper;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public String getCodClieSap() {
        return codClieSap;
    }

    public void setCodClieSap(String codClieSap) {
        this.codClieSap = codClieSap;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getCodTipoCredito() {
        return codTipoCredito;
    }

    public void setCodTipoCredito(String codTipoCredito) {
        this.codTipoCredito = codTipoCredito;
    }

    public String getCodAreaVta() {
        return codAreaVta;
    }

    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodEstadoSolicitud() {
        return codEstadoSolicitud;
    }

    public void setCodEstadoSolicitud(String codEstadoSolicitud) {
        this.codEstadoSolicitud = codEstadoSolicitud;
    }

    public String getEstadoClie() {
        return estadoClie;
    }

    public void setEstadoClie(String estadoClie) {
        this.estadoClie = estadoClie;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getCodGarantia() {
        return codGarantia;
    }

    public void setCodGarantia(String codGarantia) {
        this.codGarantia = codGarantia;
    }

    public String getTipoGarantia() {
        return tipoGarantia;
    }

    public void setTipoGarantia(String tipoGarantia) {
        this.tipoGarantia = tipoGarantia;
    }

    public String getCodEstaPoliza() {
        return codEstaPoliza;
    }

    public void setCodEstaPoliza(String codEstaPoliza) {
        this.codEstaPoliza = codEstaPoliza;
    }

    public String getCodEstaGarantia() {
        return codEstaGarantia;
    }

    public void setCodEstaGarantia(String codEstaGarantia) {
        this.codEstaGarantia = codEstaGarantia;
    }
    
    

    public String getCodEstaOper() {
        return codEstaOper;
    }

    public void setCodEstaOper(String codEstaOper) {
        this.codEstaOper = codEstaOper;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    /**
     * @return the estadoGarantia
     */
    public String getEstadoGarantia() {
        return estadoGarantia;
    }

    /**
     * @param estadoGarantia the estadoGarantia to set
     */
    public void setEstadoGarantia(String estadoGarantia) {
        this.estadoGarantia = estadoGarantia;
    }

    /**
     * @return the codMarca
     */
    public String getCodMarca() {
        return codMarca;
    }

    /**
     * @param codMarca the codMarca to set
     */
    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    /**
     * @return the anioFabricacion
     */
    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * @param anioFabricacion the anioFabricacion to set
     */
    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

}
