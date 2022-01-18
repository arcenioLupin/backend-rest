/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexosGarantias;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexosPagos;
import pe.com.divemotor.solicitudcredito.dominio.FacturaAnexo;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

/**
 *
 * @author USER
 */
public class ReporteAnexosDataSource {
    
    private String pathLogo;
    private String nomCia;
    private String nomBanco;
    private String cantTipoVeh;
    private String tipoVeh;
    private String marca;
    private String modelo;
    private String numMotor;
    private String numChasis;
    private String numPlaca;
    private String nomeMonedaCi;
    private String montoCi;
    private String montoLetras;
    private String descripcionMoneda;
    private String numNotaCredito;
    private String nomeMonedaNotaCredito;
    private String montoNotaCredito;
    private String diaFirmaContrato;
    private String mesFirmaContrato;
    private String anioFirmaContrato;
    private String nomeMonedaFin;
    private String montoFin;
    private String montoLetrasFin;
    private String descripcionMonedaFin;
    private String textoCantMarcaModelo;
    private String listaNumFacturas;
    private List<FacturaAnexo> listaFacturas;
    private List<SimuladorCronograma> listaDetalleDeuda;
    private List<DatosAnexosPagos> listaAnexosPagos;
    private List<DatosAnexosGarantias> listaGarantiaMobiliaria;
    
    /* AGREGAR LISTA DE GARANTIAS ADICIONALES */
    private List<DatosAnexosGarantias> listaGarantiaMobiliariaAdicionales;
    
    private String nomeMonedaSoli;
    private String valMontoCiTotal;
    private String fMontoTextoTotal;
    private String desLargaMoneda;
    private String cliente;
    private String codCliente;
    private String comiGaAdmin;
    private String tcea;
    private String periodiLetras;
    private String moneda;
    private String montoPenalidad;
    private String numCuotas;
    private String numLetras;
    private String deudaFinanciar;
    private String venPriLetra;
    private String tea;
     private String montoGM;
    private String montoLetrasGM;
    private String valorGM;
    private String montoLetrasValorGM;
    private String codTipSoliCred;
    // MBARDALES CONTRATOS ANEXOS MUTUO
    private String listaCuotasPerGrac;
    private String nroDiasPagoGrac;
    private String nroDiasPagoGracLetras;
    // MBARDALES CONTRATOS ANEXOS LEASING
    private String detaLeasingUno;
    private String detaListFact;
    private String detaNotaCred;

    public String getPathLogo() {
        return pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    public List<FacturaAnexo> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<FacturaAnexo> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public List<DatosAnexosPagos> getListaAnexosPagos() {
        return listaAnexosPagos;
    }

    public void setListaAnexosPagos(List<DatosAnexosPagos> listaAnexosPagos) {
        this.listaAnexosPagos = listaAnexosPagos;
    }

    public List<DatosAnexosGarantias> getListaGarantiaMobiliaria() {
        return listaGarantiaMobiliaria;
    }

    public void setListaGarantiaMobiliaria(List<DatosAnexosGarantias> listaGarantiaMobiliaria) {
        this.listaGarantiaMobiliaria = listaGarantiaMobiliaria;
    }
    
    

    public String getNomeMonedaSoli() {
        return nomeMonedaSoli;
    }

    public void setNomeMonedaSoli(String nomeMonedaSoli) {
        this.nomeMonedaSoli = nomeMonedaSoli;
    }

    public String getValMontoCiTotal() {
        return valMontoCiTotal;
    }

    public void setValMontoCiTotal(String valMontoCiTotal) {
        this.valMontoCiTotal = valMontoCiTotal;
    }

    public String getfMontoTextoTotal() {
        return fMontoTextoTotal;
    }

    public void setfMontoTextoTotal(String fMontoTextoTotal) {
        this.fMontoTextoTotal = fMontoTextoTotal;
    }

   

    public String getDesLargaMoneda() {
        return desLargaMoneda;
    }

    public void setDesLargaMoneda(String desLargaMoneda) {
        this.desLargaMoneda = desLargaMoneda;
    }
    
    

    public String getNomCia() {
        return nomCia;
    }

    public void setNomCia(String nomCia) {
        this.nomCia = nomCia;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getCantTipoVeh() {
        return cantTipoVeh;
    }

    public void setCantTipoVeh(String cantTipoVeh) {
        this.cantTipoVeh = cantTipoVeh;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
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

    public String getNomeMonedaCi() {
        return nomeMonedaCi;
    }

    public void setNomeMonedaCi(String nomeMonedaCi) {
        this.nomeMonedaCi = nomeMonedaCi;
    }

    public String getMontoCi() {
        return montoCi;
    }

    public void setMontoCi(String montoCi) {
        this.montoCi = montoCi;
    }

    public String getMontoLetras() {
        return montoLetras;
    }

    public void setMontoLetras(String montoLetras) {
        this.montoLetras = montoLetras;
    }

    public String getDescripcionMoneda() {
        return descripcionMoneda;
    }

    public void setDescripcionMoneda(String descripcionMoneda) {
        this.descripcionMoneda = descripcionMoneda;
    }

    public String getNumNotaCredito() {
        return numNotaCredito;
    }

    public void setNumNotaCredito(String numNotaCredito) {
        this.numNotaCredito = numNotaCredito;
    }

    public String getNomeMonedaNotaCredito() {
        return nomeMonedaNotaCredito;
    }

    public void setNomeMonedaNotaCredito(String nomeMonedaNotaCredito) {
        this.nomeMonedaNotaCredito = nomeMonedaNotaCredito;
    }

    public String getMontoNotaCredito() {
        return montoNotaCredito;
    }

    public void setMontoNotaCredito(String montoNotaCredito) {
        this.montoNotaCredito = montoNotaCredito;
    }

    public String getDiaFirmaContrato() {
        return diaFirmaContrato;
    }

    public void setDiaFirmaContrato(String diaFirmaContrato) {
        this.diaFirmaContrato = diaFirmaContrato;
    }

    public String getMesFirmaContrato() {
        return mesFirmaContrato;
    }

    public void setMesFirmaContrato(String mesFirmaContrato) {
        this.mesFirmaContrato = mesFirmaContrato;
    }

    public String getAnioFirmaContrato() {
        return anioFirmaContrato;
    }

    public void setAnioFirmaContrato(String anioFirmaContrato) {
        this.anioFirmaContrato = anioFirmaContrato;
    }

    public String getNomeMonedaFin() {
        return nomeMonedaFin;
    }

    public void setNomeMonedaFin(String nomeMonedaFin) {
        this.nomeMonedaFin = nomeMonedaFin;
    }

    public String getMontoFin() {
        return montoFin;
    }

    public void setMontoFin(String montoFin) {
        this.montoFin = montoFin;
    }

    public String getMontoLetrasFin() {
        return montoLetrasFin;
    }

    public void setMontoLetrasFin(String montoLetrasFin) {
        this.montoLetrasFin = montoLetrasFin;
    }

    public String getDescripcionMonedaFin() {
        return descripcionMonedaFin;
    }

    public void setDescripcionMonedaFin(String descripcionMonedaFin) {
        this.descripcionMonedaFin = descripcionMonedaFin;
    }

    public String getTextoCantMarcaModelo() {
        return textoCantMarcaModelo;
    }

    public void setTextoCantMarcaModelo(String textoCantMarcaModelo) {
        this.textoCantMarcaModelo = textoCantMarcaModelo;
    }

    public String getListaNumFacturas() {
        return listaNumFacturas;
    }

    public void setListaNumFacturas(String listaNumFacturas) {
        this.listaNumFacturas = listaNumFacturas;
    }

    public List<SimuladorCronograma> getListaDetalleDeuda() {
        return listaDetalleDeuda;
    }

    public void setListaDetalleDeuda(List<SimuladorCronograma> listaDetalleDeuda) {
        this.listaDetalleDeuda = listaDetalleDeuda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getComiGaAdmin() {
        return comiGaAdmin;
    }

    public void setComiGaAdmin(String comiGaAdmin) {
        this.comiGaAdmin = comiGaAdmin;
    }

    public String getTcea() {
        return tcea;
    }

    public void setTcea(String tcea) {
        this.tcea = tcea;
    }

    public String getPeriodiLetras() {
        return periodiLetras;
    }

    public void setPeriodiLetras(String periodiLetras) {
        this.periodiLetras = periodiLetras;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMontoPenalidad() {
        return montoPenalidad;
    }

    public void setMontoPenalidad(String montoPenalidad) {
        this.montoPenalidad = montoPenalidad;
    }

    public String getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(String numCuotas) {
        this.numCuotas = numCuotas;
    }

    public String getNumLetras() {
        return numLetras;
    }

    public void setNumLetras(String numLetras) {
        this.numLetras = numLetras;
    }

    public String getDeudaFinanciar() {
        return deudaFinanciar;
    }

    public void setDeudaFinanciar(String deudaFinanciar) {
        this.deudaFinanciar = deudaFinanciar;
    }

    public String getVenPriLetra() {
        return venPriLetra;
    }

    public void setVenPriLetra(String venPriLetra) {
        this.venPriLetra = venPriLetra;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getMontoGM() {
        return montoGM;
    }

    public void setMontoGM(String montoGM) {
        this.montoGM = montoGM;
    }

    public String getMontoLetrasGM() {
        return montoLetrasGM;
    }

    public void setMontoLetrasGM(String montoLetrasGM) {
        this.montoLetrasGM = montoLetrasGM;
    }

    public String getValorGM() {
        return valorGM;
    }

    public void setValorGM(String valorGM) {
        this.valorGM = valorGM;
    }

    public String getMontoLetrasValorGM() {
        return montoLetrasValorGM;
    }

    public void setMontoLetrasValorGM(String montoLetrasValorGM) {
        this.montoLetrasValorGM = montoLetrasValorGM;
    }

    public String getCodTipSoliCred() {
        return codTipSoliCred;
    }

    public void setCodTipSoliCred(String codTipSoliCred) {
        this.codTipSoliCred = codTipSoliCred;
    }

    /**
     * @return the listaCuotasPerGrac
     */
    public String getListaCuotasPerGrac() {
        return listaCuotasPerGrac;
    }

    /**
     * @param listaCuotasPerGrac the listaCuotasPerGrac to set
     */
    public void setListaCuotasPerGrac(String listaCuotasPerGrac) {
        this.listaCuotasPerGrac = listaCuotasPerGrac;
    }

    /**
     * @return the nroDiasPagoGrac
     */
    public String getNroDiasPagoGrac() {
        return nroDiasPagoGrac;
    }

    /**
     * @param nroDiasPagoGrac the nroDiasPagoGrac to set
     */
    public void setNroDiasPagoGrac(String nroDiasPagoGrac) {
        this.nroDiasPagoGrac = nroDiasPagoGrac;
    }

    /**
     * @return the nroDiasPagoGracLetras
     */
    public String getNroDiasPagoGracLetras() {
        return nroDiasPagoGracLetras;
    }

    /**
     * @param nroDiasPagoGracLetras the nroDiasPagoGracLetras to set
     */
    public void setNroDiasPagoGracLetras(String nroDiasPagoGracLetras) {
        this.nroDiasPagoGracLetras = nroDiasPagoGracLetras;
    }

    /**
     * @return the listaGarantiaMobiliariaAdicionales
     */
    public List<DatosAnexosGarantias> getListaGarantiaMobiliariaAdicionales() {
        return listaGarantiaMobiliariaAdicionales;
    }

    /**
     * @param listaGarantiaMobiliariaAdicionales the listaGarantiaMobiliariaAdicionales to set
     */
    public void setListaGarantiaMobiliariaAdicionales(List<DatosAnexosGarantias> listaGarantiaMobiliariaAdicionales) {
        this.listaGarantiaMobiliariaAdicionales = listaGarantiaMobiliariaAdicionales;
    }

    /**
     * @return the detaLeasingUno
     */
    public String getDetaLeasingUno() {
        return detaLeasingUno;
    }

    /**
     * @param detaLeasingUno the detaLeasingUno to set
     */
    public void setDetaLeasingUno(String detaLeasingUno) {
        this.detaLeasingUno = detaLeasingUno;
    }

    /**
     * @return the detaListFact
     */
    public String getDetaListFact() {
        return detaListFact;
    }

    /**
     * @param detaListFact the detaListFact to set
     */
    public void setDetaListFact(String detaListFact) {
        this.detaListFact = detaListFact;
    }

    /**
     * @return the detaNotaCred
     */
    public String getDetaNotaCred() {
        return detaNotaCred;
    }

    /**
     * @param detaNotaCred the detaNotaCred to set
     */
    public void setDetaNotaCred(String detaNotaCred) {
        this.detaNotaCred = detaNotaCred;
    }
         
}
