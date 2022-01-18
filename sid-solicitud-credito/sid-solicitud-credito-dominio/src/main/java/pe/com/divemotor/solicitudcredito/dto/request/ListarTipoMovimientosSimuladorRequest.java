/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author ebarboza
 */
public class ListarTipoMovimientosSimuladorRequest extends BaseRequest{
    /*Req. 87567 E2.3 ID## EBARBOZA 27/01/2020*/
    private int codIdSoliTipm;
    private String codSoliCred;
    private int codTipoMoviPago;
    private String fecMoviPago;
    private String codBanco;
    private String codMoneda;
    private int valMontoPago;
    private String txtNroDocumento;
    private String indInactivo;
    private String IndTipoDocu;
    private String codEmpresaCargo;
    private String fecCreaRegi;
    private String codUsuaCreaRegi;
    private String fecModiRegi;
    private String codUsuaModiRegi;

    public int getCodIdSoliTipm() {
        return codIdSoliTipm;
    }

    public void setCodIdSoliTipm(int codIdSoliTipm) {
        this.codIdSoliTipm = codIdSoliTipm;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public int getCodTipoMoviPago() {
        return codTipoMoviPago;
    }

    public void setCodTipoMoviPago(int codTipoMoviPago) {
        this.codTipoMoviPago = codTipoMoviPago;
    }

    public String getFecMoviPago() {
        return fecMoviPago;
    }

    public void setFecMoviPago(String fecMoviPago) {
        this.fecMoviPago = fecMoviPago;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public int getValMontoPago() {
        return valMontoPago;
    }

    public void setValMontoPago(int valMontoPago) {
        this.valMontoPago = valMontoPago;
    }

    public String getTxtNroDocumento() {
        return txtNroDocumento;
    }

    public void setTxtNroDocumento(String txtNroDocumento) {
        this.txtNroDocumento = txtNroDocumento;
    }

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }

    public String getIndTipoDocu() {
        return IndTipoDocu;
    }

    public void setIndTipoDocu(String IndTipoDocu) {
        this.IndTipoDocu = IndTipoDocu;
    }

    public String getCodEmpresaCargo() {
        return codEmpresaCargo;
    }

    public void setCodEmpresaCargo(String codEmpresaCargo) {
        this.codEmpresaCargo = codEmpresaCargo;
    }

    public String getFecCreaRegi() {
        return fecCreaRegi;
    }

    public void setFecCreaRegi(String fecCreaRegi) {
        this.fecCreaRegi = fecCreaRegi;
    }

    public String getCodUsuaCreaRegi() {
        return codUsuaCreaRegi;
    }

    public void setCodUsuaCreaRegi(String codUsuaCreaRegi) {
        this.codUsuaCreaRegi = codUsuaCreaRegi;
    }

    public String getFecModiRegi() {
        return fecModiRegi;
    }

    public void setFecModiRegi(String fecModiRegi) {
        this.fecModiRegi = fecModiRegi;
    }

    public String getCodUsuaModiRegi() {
        return codUsuaModiRegi;
    }

    public void setCodUsuaModiRegi(String codUsuaModiRegi) {
        this.codUsuaModiRegi = codUsuaModiRegi;
    }
    
    
    
}
