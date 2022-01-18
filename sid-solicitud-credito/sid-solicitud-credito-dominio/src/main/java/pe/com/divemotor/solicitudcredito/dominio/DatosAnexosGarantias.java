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
public class DatosAnexosGarantias {
    
    private String item;
    private String cliente;
    private String marca;
    private String modelo;
    private String tipoVeh;
    private String numeroMotor;
    private String numeroChasis;
    private String numeroPlaca;
    private String montoGarantia;
    private String nomeMone;
    private String montoTexto;
    private String nomeMoneLargo;
    private String montoValorizacion;
    private String montoValorizacionTexto;
    private String desProvincia;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getMontoGarantia() {
        return montoGarantia;
    }

    public void setMontoGarantia(String montoGarantia) {
        this.montoGarantia = montoGarantia;
    }

    public String getNomeMone() {
        return nomeMone;
    }

    public void setNomeMone(String nomeMone) {
        this.nomeMone = nomeMone;
    }

    public String getMontoTexto() {
        return montoTexto;
    }

    public void setMontoTexto(String montoTexto) {
        this.montoTexto = montoTexto.replace("soles","");
    }

    public String getNomeMoneLargo() {
        return nomeMoneLargo;
    }

    public void setNomeMoneLargo(String nomeMoneLargo) {
        this.nomeMoneLargo = nomeMoneLargo;
    }

    public String getMontoValorizacion() {
        return montoValorizacion;
    }

    public void setMontoValorizacion(String montoValorizacion) {
        this.montoValorizacion = montoValorizacion;
    }

    public String getMontoValorizacionTexto() {
        return montoValorizacionTexto;
    }

    public void setMontoValorizacionTexto(String montoValorizacionTexto) {
        this.montoValorizacionTexto = montoValorizacionTexto.replace("soles","");
    }

    /**
     * @return the desProvincia
     */
    public String getDesProvincia() {
        return desProvincia;
    }

    /**
     * @param desProvincia the desProvincia to set
     */
    public void setDesProvincia(String desProvincia) {
        this.desProvincia = desProvincia;
    }
    
    
    
}
