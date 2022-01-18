/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.Aval;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionados;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxC;

/**
 *
 * @author mbardales
 */
public class OperacionLxCRequest extends BaseRequest {

    private String noCia;
    private String codClie;
    private String codSoliCred;
    private String codTipoCred;
    private String codTipoOper;
    private String fechaContrato;
    private String fechaEntrega;
    private String tipoCuota;
    private String fechaAut;
    private String usuarioAprob;
    private List<DocumentosRelacionados> documentosRelacionados;
    private List<GastosLxC> gastos;
    private List<Aval> avales;
    private String tipoCorreo;

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }


    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodTipoCred() {
        return codTipoCred;
    }

    public void setCodTipoCred(String codTipoCred) {
        this.codTipoCred = codTipoCred;
    }

    public String getCodTipoOper() {
        return codTipoOper;
    }

    public void setCodTipoOper(String codTipoOper) {
        this.codTipoOper = codTipoOper;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getTipoCuota() {
        return tipoCuota;
    }

    public void setTipoCuota(String tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    public String getFechaAut() {
        return fechaAut;
    }

    public void setFechaAut(String fechaAut) {
        this.fechaAut = fechaAut;
    }

    public String getUsuarioAprob() {
        return usuarioAprob;
    }

    public void setUsuarioAprob(String usuarioAprob) {
        this.usuarioAprob = usuarioAprob;
    }

    public List<DocumentosRelacionados> getDocumentosRelacionados() {
        return documentosRelacionados;
    }

    public void setDocumentosRelacionados(List<DocumentosRelacionados> documentosRelacionados) {
        this.documentosRelacionados = documentosRelacionados;
    }

    public List<GastosLxC> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastosLxC> gastos) {
        this.gastos = gastos;
    }

    public List<Aval> getAvales() {
        return avales;
    }

    public void setAvales(List<Aval> avales) {
        this.avales = avales;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(String tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }
    
}
