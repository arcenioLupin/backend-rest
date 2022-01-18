/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author jaltamirano
 */
public class Cliente extends BaseRequest {

    private String codSoliCred;
    private String tipSoliCred;
    private String tipoCredito;
    private String codClie;
    private String codCia;
    private String nomSociedad;
    private String codigoClieSap;
    private String nombClie;
    private String codTipoPersona;
    private String tipoPersona;
    private String codTipoDocumento;
    private String dni;
    private String ruc;
    private String codAreaVta;
    private String areaVta;
    private String codFilial;
    private String nomFilial;
    private String codZona;
    private String desZona;
    private String codPais;
    private String nomPais;
    private String codDepa;
    private String nomDepa; //I Req. 87567 E2.1 ID:131 avilca 12/02/2020
    private String codProv;
    private String nomProv;//I Req. 87567 E2.1 ID:131 avilca 12/02/2020
    private String codDist;
    private String nomDist;//I Req. 87567 E2.1 ID:131 avilca 12/02/2020
    private String nomUbigeo;
    private String codVendedor;
    private String vendedor;
    private String codEstadoSolicitud;
    private String estadoSoli;
    private String estadoClie;
    private boolean seleccion;
    private String codCall; // Req Obs MBardales 14/10/2020
    private String nroCelular; // Req Obs MBardales 14/10/2020

    //Operaciones
    private String nroCia;
    private String nroOperacion;
    private String codTipoOperacion;
    private String tipoOperacion;
    private String codTipoMoneda;
    private String fechaOtorgamiento;
    private String fechaVencimientoUL;
    private String plazoDias;
    private String status;
    private String divisa;
    private Double saldoOriginal;
    private Double salgoVigente;
    private String tea;
    private Double ratioCoberturaGara;
    private String estadoOpera;
    private String rutaCartaBanco;
    private List<OperacionesCredito> listaOperaciones;

    //Garantias
    private String nroGarantia;
    private String indTipoGara;
    private String desTipoGara;
    private String codTipoCred;
    private String desTipoCred;
    private String flagGaraAdic;
    private String nroPoliza;
    private String codEstaPoliza;
    private String estadoPoliza;
    private String divisaOrigen;
    private Double valorComercial;
    private Double valorRealizacion;
    private String fechaConstitucion;
    private String codMarca;
    private String marca;
    private String modelo;
    private String codTipoVehi;
    private String nroPlaca;
    private String valAnoFab;
    private String codRangoGara;
    private String desRangoGara;
    private String indInactivo;
    private String mismaUnidad;
    private String estadoGara;

    private List<GarantiasCredito> listaGarantias;
    private Double totalSaldoVigenteOPER;
    private Double totalValorComercialGARA;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodCia() {
        return codCia;
    }

    public void setCodCia(String codCia) {
        this.codCia = codCia;
    }

    public String getNomSociedad() {
        return nomSociedad;
    }

    public void setNomSociedad(String nomSociedad) {
        this.nomSociedad = nomSociedad;
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

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
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

    public String getAreaVta() {
        return areaVta;
    }

    public void setAreaVta(String areaVta) {
        this.areaVta = areaVta;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getNomFilial() {
        return nomFilial;
    }

    public void setNomFilial(String nomFilial) {
        this.nomFilial = nomFilial;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
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

    public String getNomUbigeo() {
        return nomUbigeo;
    }

    public void setNomUbigeo(String nomUbigeo) {
        this.nomUbigeo = nomUbigeo;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCodEstadoSolicitud() {
        return codEstadoSolicitud;
    }

    public void setCodEstadoSolicitud(String codEstadoSolicitud) {
        this.codEstadoSolicitud = codEstadoSolicitud;
    }

    public String getEstadoSoli() {
        return estadoSoli;
    }

    public void setEstadoSoli(String estadoSoli) {
        this.estadoSoli = estadoSoli;
    }

    public String getEstadoClie() {
        return estadoClie;
    }

    public void setEstadoClie(String estadoClie) {
        this.estadoClie = estadoClie;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
    

    public String getNroCia() {
        return nroCia;
    }

    public void setNroCia(String nroCia) {
        this.nroCia = nroCia;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public String getCodTipoOperacion() {
        return codTipoOperacion;
    }

    public void setCodTipoOperacion(String codTipoOperacion) {
        this.codTipoOperacion = codTipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCodTipoMoneda() {
        return codTipoMoneda;
    }

    public void setCodTipoMoneda(String codTipoMoneda) {
        this.codTipoMoneda = codTipoMoneda;
    }

    public String getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(String fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public String getFechaVencimientoUL() {
        return fechaVencimientoUL;
    }

    public void setFechaVencimientoUL(String fechaVencimientoUL) {
        this.fechaVencimientoUL = fechaVencimientoUL;
    }

    public String getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(String plazoDias) {
        this.plazoDias = plazoDias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Double getSaldoOriginal() {
        return saldoOriginal;
    }

    public void setSaldoOriginal(Double saldoOriginal) {
        this.saldoOriginal = saldoOriginal;
    }

    public Double getSalgoVigente() {
        return salgoVigente;
    }

    public void setSalgoVigente(Double salgoVigente) {
        this.salgoVigente = salgoVigente;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public Double getRatioCoberturaGara() {
        return ratioCoberturaGara;
    }

    public void setRatioCoberturaGara(Double ratioCoberturaGara) {
        this.ratioCoberturaGara = ratioCoberturaGara;
    }

    public String getEstadoOpera() {
        return estadoOpera;
    }

    public void setEstadoOpera(String estadoOpera) {
        this.estadoOpera = estadoOpera;
    }

    public String getRutaCartaBanco() {
        return rutaCartaBanco;
    }

    public void setRutaCartaBanco(String rutaCartaBanco) {
        this.rutaCartaBanco = rutaCartaBanco;
    }

    public List<OperacionesCredito> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<OperacionesCredito> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }

    public String getNroGarantia() {
        return nroGarantia;
    }

    public void setNroGarantia(String nroGarantia) {
        this.nroGarantia = nroGarantia;
    }

    public String getIndTipoGara() {
        return indTipoGara;
    }

    public void setIndTipoGara(String indTipoGara) {
        this.indTipoGara = indTipoGara;
    }

    public String getDesTipoGara() {
        return desTipoGara;
    }

    public void setDesTipoGara(String desTipoGara) {
        this.desTipoGara = desTipoGara;
    }

    public String getCodTipoCred() {
        return codTipoCred;
    }

    public void setCodTipoCred(String codTipoCred) {
        this.codTipoCred = codTipoCred;
    }

    public String getDesTipoCred() {
        return desTipoCred;
    }

    public void setDesTipoCred(String desTipoCred) {
        this.desTipoCred = desTipoCred;
    }

    public String getFlagGaraAdic() {
        return flagGaraAdic;
    }

    public void setFlagGaraAdic(String flagGaraAdic) {
        this.flagGaraAdic = flagGaraAdic;
    }

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public String getCodEstaPoliza() {
        return codEstaPoliza;
    }

    public void setCodEstaPoliza(String codEstaPoliza) {
        this.codEstaPoliza = codEstaPoliza;
    }

    public String getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(String estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    public void setDivisaOrigen(String divisaOrigen) {
        this.divisaOrigen = divisaOrigen;
    }

    public Double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(Double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public Double getValorRealizacion() {
        return valorRealizacion;
    }

    public void setValorRealizacion(Double valorRealizacion) {
        this.valorRealizacion = valorRealizacion;
    }

    public String getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(String fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
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

    public String getCodTipoVehi() {
        return codTipoVehi;
    }

    public void setCodTipoVehi(String codTipoVehi) {
        this.codTipoVehi = codTipoVehi;
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca = nroPlaca;
    }

    public String getValAnoFab() {
        return valAnoFab;
    }

    public void setValAnoFab(String valAnoFab) {
        this.valAnoFab = valAnoFab;
    }

    public String getCodRangoGara() {
        return codRangoGara;
    }

    public void setCodRangoGara(String codRangoGara) {
        this.codRangoGara = codRangoGara;
    }

    public String getDesRangoGara() {
        return desRangoGara;
    }

    public void setDesRangoGara(String desRangoGara) {
        this.desRangoGara = desRangoGara;
    }

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }

    public List<GarantiasCredito> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<GarantiasCredito> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }

    public Double getTotalSaldoVigenteOPER() {
        return totalSaldoVigenteOPER;
    }

    public void setTotalSaldoVigenteOPER(Double totalSaldoVigenteOPER) {
        this.totalSaldoVigenteOPER = totalSaldoVigenteOPER;
    }

    public Double getTotalValorComercialGARA() {
        return totalValorComercialGARA;
    }

    public void setTotalValorComercialGARA(Double totalValorComercialGARA) {
        this.totalValorComercialGARA = totalValorComercialGARA;
    }
  //I Req. 87567 E2.1 ID:131 avilca 12/02/2020
    public String getNomDepa() {
        return nomDepa;
    }

    public void setNomDepa(String nomDepa) {
        this.nomDepa = nomDepa;
    }

    public String getNomProv() {
        return nomProv;
    }

    public void setNomProv(String nomProv) {
        this.nomProv = nomProv;
    }

    public String getNomDist() {
        return nomDist;
    }

    public void setNomDist(String nomDist) {
        this.nomDist = nomDist;
    }
   //F Req. 87567 E2.1 ID:131 avilca 12/02/2020 

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getDesZona() {
        return desZona;
    }

    public void setDesZona(String desZona) {
        this.desZona = desZona;
    }

    // Req. Obs 14/10/2020 MBardales
    /**
     * @return the codCall
     */
    public String getCodCall() {
        return codCall;
    }

    /**
     * @param codCall the codCall to set
     */
    public void setCodCall(String codCall) {
        this.codCall = codCall;
    }

    /**
     * @return the nroCelular
     */
    public String getNroCelular() {
        return nroCelular;
    }

    /**
     * @param nroCelular the nroCelular to set
     */
    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    /**
     * @return the mismaUnidad
     */
    public String getMismaUnidad() {
        return mismaUnidad;
    }

    /**
     * @param mismaUnidad the mismaUnidad to set
     */
    public void setMismaUnidad(String mismaUnidad) {
        this.mismaUnidad = mismaUnidad;
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
