/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author ebarboza
 */
public class DatosAnexosPagos {
    
        private String desMovi;
        private String fecMovi;
        private String desBcoMovi;
        private String nomeMoneda;
        private String montoMovi;
        private String fMontoTexto;
        private String desLargaMoneda;
        private String nroDocMovi;
        private String desFecMovi;
        private String tipoDocMovi;
        private String desCiaCargo;
        

    public String getDesMovi() {
        return desMovi;
    }

    public void setDesMovi(String desMovi) {
        this.desMovi = desMovi;
    }

    public String getFecMovi() {
        return fecMovi;
    }

    public void setFecMovi(String fecMovi) {
        this.fecMovi = fecMovi;
    }

    public String getDesBcoMovi() {
        return desBcoMovi;
    }

    public void setDesBcoMovi(String desBcoMovi) {
        this.desBcoMovi = desBcoMovi;
    }

    public String getNomeMoneda() {
        return nomeMoneda;
    }

    public void setNomeMoneda(String nomeMoneda) {
        this.nomeMoneda = nomeMoneda;
    }

    public String getMontoMovi() {
        return montoMovi;
    }

    public void setMontoMovi(String montoMovi) {
        this.montoMovi = montoMovi;
    }

    public String getfMontoTexto() {
        return fMontoTexto;
    }

    public void setfMontoTexto(String fMontoTexto) {
        this.fMontoTexto = fMontoTexto.replace("soles","");
    }

    public String getDesLargaMoneda() {
        return desLargaMoneda;
    }

    public void setDesLargaMoneda(String desLargaMoneda) {
        this.desLargaMoneda = desLargaMoneda;
    }

    public String getNroDocMovi() {
        return nroDocMovi;
    }

    public void setNroDocMovi(String nroDocMovi) {
        this.nroDocMovi = nroDocMovi;
    }

    public String getDesFecMovi() {
        return desFecMovi;
    }

    public void setDesFecMovi(String desFecMovi) {
        this.desFecMovi = desFecMovi;
    }

    public String getTipoDocMovi() {
        return tipoDocMovi;
    }

    public void setTipoDocMovi(String tipoDocMovi) {
        this.tipoDocMovi = tipoDocMovi;
    }

    public String getDesCiaCargo() {
        return desCiaCargo;
    }

    public void setDesCiaCargo(String desCiaCargo) {
        this.desCiaCargo = desCiaCargo;
    }
   
    
}
