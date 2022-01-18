/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.cliente;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Cliente;

/**
 *
 * @author jaltamirano
 */
public class ListarClienteProcedure extends BasePaginadoProcedure<Cliente> {

    private String codSoliCred;
    private String codTipoCredSoli;
    private String codClie;
    private String codigoClieSap;
    private String nombClie;
    private String codTipoPersona;
    private String codTipoDocumento;
    private String dni;
    private String ruc;
    private String codAreaVta;
    private String codFilial;
    private String codZona;
    private String codCia;
    private String codPais;
    private String codDepa;
    private String codProv;
    private String codDist;
    private String codEstadoSolicitud;
    private String estadoClie;

    //Variables para listado CodOperaciones
    private String codTipoOpera;
    private String codMoneda;
    private String estadoOpera;
    //Variables para listado Garantias
    private String codOpera;
    private String codGara;
    private String tipoGara;
    private String codEstaPoli;
    private String estadoGara;
    private String codMarca;
    private String anioFabricacion;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodTipoCredSoli() {
        return codTipoCredSoli;
    }

    public void setCodTipoCredSoli(String codTipoCredSoli) {
        this.codTipoCredSoli = codTipoCredSoli;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodigoClieSap() {
        return codigoClieSap;
    }

    public void setCodigoClieSap(String codigoClieSap) {
        this.codigoClieSap = codigoClieSap;
    }

    public String getNombClie() {
        return nombClie;
    }

    public void setNombClie(String nombClie) {
        this.nombClie = nombClie;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public String getCodDepa() {
        return codDepa;
    }

    public void setCodDepa(String codDepa) {
        this.codDepa = codDepa;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getCodDist() {
        return codDist;
    }

    public void setCodDist(String codDist) {
        this.codDist = codDist;
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

    public String getCodOpera() {
        return codOpera;
    }

    public void setCodOpera(String codOpera) {
        this.codOpera = codOpera;
    }

    public String getCodGara() {
        return codGara;
    }

    public void setCodGara(String codGara) {
        this.codGara = codGara;
    }

    public String getTipoGara() {
        return tipoGara;
    }

    public void setTipoGara(String tipoGara) {
        this.tipoGara = tipoGara;
    }

    public String getCodEstaPoli() {
        return codEstaPoli;
    }

    public void setCodEstaPoli(String codEstaPoli) {
        this.codEstaPoli = codEstaPoli;
    }

    public String getCodTipoOpera() {
        return codTipoOpera;
    }

    public void setCodTipoOpera(String codTipoOpera) {
        this.codTipoOpera = codTipoOpera;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getEstadoOpera() {
        return estadoOpera;
    }

    public void setEstadoOpera(String estadoOpera) {
        this.estadoOpera = estadoOpera;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
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

    /**
     * @return the estadoGara
     */
    public String getEstadoGara() {
        return estadoGara;
    }

    /**
     * @param estadoGara the estadoGara to set
     */
    public void setEstadoGara(String estadoGara) {
        this.estadoGara = estadoGara;
    }
    
    

    
}
