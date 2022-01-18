package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.Aval;

public class AvalRequest extends BaseRequest {

    private String codSoliCred;
    private String codperaval;
    private String indtipopersona;
    private String indestadocivil;
    private String indtiporelacion;
    //private String indcony;
    //private String codcoprop;
    private String codmoneda;
    private String valmontofianza;
    private String txtdireccion;
    private String coddistrito;
    private String codprovincia;
    private String coddepartamento;
    private String codempr;
    private String codpais;
    private String codzona;
    private String txtnombpers;
    private String txtapelpatepers;
    private String txtapelmatepers;
    private String codperrelaval;
    private String txtdoi;
    private String avalHisto;
    private String listaAvales;
    private String tipo;
    private List<Aval> listaAvalCopropietarios;
    private List<Aval> listaCopropietariosEliminados;
    private String flagCopropEliminado;
    private String codTipoOtor;
    private String telefono; // I Req. 87567 E1.1 ID 53 AVILCA 12/11/2020

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodperaval() {
        return codperaval;
    }

    public void setCodperaval(String codperaval) {
        this.codperaval = codperaval;
    }

    public String getIndtipopersona() {
        return indtipopersona;
    }

    public void setIndtipopersona(String indtipopersona) {
        this.indtipopersona = indtipopersona;
    }

    public String getIndestadocivil() {
        return indestadocivil;
    }

    public void setIndestadocivil(String indestadocivil) {
        this.indestadocivil = indestadocivil;
    }

    public String getIndtiporelacion() {
        return indtiporelacion;
    }

    public void setIndtiporelacion(String indtiporelacion) {
        this.indtiporelacion = indtiporelacion;
    }

    public String getCodmoneda() {
        return codmoneda;
    }

    public void setCodmoneda(String codmoneda) {
        this.codmoneda = codmoneda;
    }

    public String getValmontofianza() {
        return valmontofianza;
    }

    public void setValmontofianza(String valmontofianza) {
        this.valmontofianza = valmontofianza;
    }

    public String getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(String txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public String getCoddistrito() {
        return coddistrito;
    }

    public void setCoddistrito(String coddistrito) {
        this.coddistrito = coddistrito;
    }

    public String getCodprovincia() {
        return codprovincia;
    }

    public void setCodprovincia(String codprovincia) {
        this.codprovincia = codprovincia;
    }

    public String getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(String coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public String getCodempr() {
        return codempr;
    }

    public void setCodempr(String codempr) {
        this.codempr = codempr;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getCodzona() {
        return codzona;
    }

    public void setCodzona(String codzona) {
        this.codzona = codzona;
    }

    public String getTxtnombpers() {
        return txtnombpers;
    }

    public void setTxtnombpers(String txtnombpers) {
        this.txtnombpers = txtnombpers;
    }

    public String getTxtapelpatepers() {
        return txtapelpatepers;
    }

    public void setTxtapelpatepers(String txtapelpatepers) {
        this.txtapelpatepers = txtapelpatepers;
    }

    public String getTxtapelmatepers() {
        return txtapelmatepers;
    }

    public void setTxtapelmatepers(String txtapelmatepers) {
        this.txtapelmatepers = txtapelmatepers;
    }

    public String getCodperrelaval() {
        return codperrelaval;
    }

    public void setCodperrelaval(String codperrelaval) {
        this.codperrelaval = codperrelaval;
    }

    public String getTxtdoi() {
        return txtdoi;
    }

    public void setTxtdoi(String txtdoi) {
        this.txtdoi = txtdoi;
    }

    public String getAvalHisto() {
        return avalHisto;
    }

    public void setAvalHisto(String avalHisto) {
        this.avalHisto = avalHisto;
    }

    public String getListaAvales() {
        return listaAvales;
    }

    public void setListaAvales(String listaAvales) {
        this.listaAvales = listaAvales;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Aval> getListaAvalCopropietarios() {
        return listaAvalCopropietarios;
    }

    public void setListaAvalCopropietarios(List<Aval> listaAvalCopropietarios) {
        this.listaAvalCopropietarios = listaAvalCopropietarios;
    }

    public String getCodTipoOtor() {
        return codTipoOtor;
    }

    public void setCodTipoOtor(String codTipoOtor) {
        this.codTipoOtor = codTipoOtor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Aval> getListaCopropietariosEliminados() {
        return listaCopropietariosEliminados;
    }

    public void setListaCopropietariosEliminados(List<Aval> listaCopropietariosEliminados) {
        this.listaCopropietariosEliminados = listaCopropietariosEliminados;
    }

    public String getFlagCopropEliminado() {
        return flagCopropEliminado;
    }

    public void setFlagCopropEliminado(String flagCopropEliminado) {
        this.flagCopropEliminado = flagCopropEliminado;
    }
    
    

}
