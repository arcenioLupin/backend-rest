/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.List;

/**
 *
 * @author jaltamirano
 */
public class ReporteCreditoOtorgado {

    private String areaVenta;
    private String codCliente;
    private String nomCliente;
    private String tipoPersona;
    private String nroFichaVenta;
    private String nroUnidades;
    private String totalVenta;
    private String tipoOperacion;
    private String cuotaInicial;
    private String montoFinanciado;
    private String nroMeses;
    private String region;
    private String fecha;
    //I Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
    private String segmento;
    private String sucursal;
    private String opCronograma;
    private String cuotaInicialPorcentaje;
    private String vencimientoPrimeraLetra;
    private String vencimientoUltimaLetra;
    private String teaSinIgv;
    private String garantiasAdicionales;
    private String ratioCobertura;
    private String gastosAdministrativos;
    private String seguroDivemotor;
    private String asesorComercial;
    private String nroSolicitud;
    private String estadoSolicitud;
    private String estadoOp;
    //F Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
    private String fechaOp;//<I Req. 87567 E2.1 ID:12 avilca 16/09/2020> 
    private String fechaAprobOp;//<F Req. 87567 E2.1 ID:12 avilca 16/09/2020> 
    private List<CreditoOtorgado> listaCreditosOtorgados;
    private String usuarioReg;
    private String fechaReg;
    private String usuarioVig;
    private String fechaVig;
    private String usuarioEval;
    private String fechaEval;
    private String usuarioAprob;
    private String fechaAprob;
    private String numRuc;
    private String codFamiliaVeh;
    private String desFamiliaVeh;
    private String codTipoVeh;
    private String desTipoVeh;
    private String codMarca;
    private String nomMarca;
    private String sumaValorRealiz;
    private String usuarioAprobNivel1;
    private String fechaAprobNivel1;
    private String usuarioAprobNivel2;
    private String fechaAprobNivel2;
    private String usuarioAprobNivel3;
    private String fechaAprobNivel3;
    private String usuarioAprobNivel4;
    private String fechaAprobNivel4;
    private String usuarioAprobNivel5;
    private String fechaAprobNivel5;
    private String usuarioAprobNivel6;
    private String fechaAprobNivel6; 
    private String nivelesAprob;
    private String valGastAdm;
    //I  AVILCA 13/10/2021
    private String usuarioAprobNivelMin;
    private String fechaAprobNivelMin;
    //F  AVILCA 13/10/2021
    

    public String getAreaVenta() {
        return areaVenta;
    }

    public void setAreaVenta(String areaVenta) {
        this.areaVenta = areaVenta;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNroFichaVenta() {
        return nroFichaVenta;
    }

    public void setNroFichaVenta(String nroFichaVenta) {
        this.nroFichaVenta = nroFichaVenta;
    }

    public String getNroUnidades() {
        return nroUnidades;
    }

    public void setNroUnidades(String nroUnidades) {
        this.nroUnidades = nroUnidades;
    }

    public String getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(String totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(String cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public String getMontoFinanciado() {
        return montoFinanciado;
    }

    public void setMontoFinanciado(String montoFinanciado) {
        this.montoFinanciado = montoFinanciado;
    }

    public String getNroMeses() {
        return nroMeses;
    }

    public void setNroMeses(String nroMeses) {
        this.nroMeses = nroMeses;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<CreditoOtorgado> getListaCreditosOtorgados() {
        return listaCreditosOtorgados;
    }

    public void setListaCreditosOtorgados(List<CreditoOtorgado> listaCreditosOtorgados) {
        this.listaCreditosOtorgados = listaCreditosOtorgados;
    }
//I Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020
    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getOpCronograma() {
        return opCronograma;
    }

    public void setOpCronograma(String opCronograma) {
        this.opCronograma = opCronograma;
    }

    public String getCuotaInicialPorcentaje() {
        return cuotaInicialPorcentaje;
    }

    public void setCuotaInicialPorcentaje(String cuotaInicialPorcentaje) {
        this.cuotaInicialPorcentaje = cuotaInicialPorcentaje;
    }

    public String getVencimientoPrimeraLetra() {
        return vencimientoPrimeraLetra;
    }

    public void setVencimientoPrimeraLetra(String vencimientoPrimeraLetra) {
        this.vencimientoPrimeraLetra = vencimientoPrimeraLetra;
    }

    public String getVencimientoUltimaLetra() {
        return vencimientoUltimaLetra;
    }

    public void setVencimientoUltimaLetra(String vencimientoUltimaLetra) {
        this.vencimientoUltimaLetra = vencimientoUltimaLetra;
    }

    public String getTeaSinIgv() {
        return teaSinIgv;
    }

    public void setTeaSinIgv(String teaSinIgv) {
        this.teaSinIgv = teaSinIgv;
    }

    public String getGarantiasAdicionales() {
        return garantiasAdicionales;
    }

    public void setGarantiasAdicionales(String garantiasAdicionales) {
        this.garantiasAdicionales = garantiasAdicionales;
    }

    public String getRatioCobertura() {
        return ratioCobertura;
    }

    public void setRatioCobertura(String ratioCobertura) {
        this.ratioCobertura = ratioCobertura;
    }

    public String getGastosAdministrativos() {
        return gastosAdministrativos;
    }

    public void setGastosAdministrativos(String gastosAdministrativos) {
        this.gastosAdministrativos = gastosAdministrativos;
    }

    public String getSeguroDivemotor() {
        return seguroDivemotor;
    }

    public void setSeguroDivemotor(String seguroDivemotor) {
        this.seguroDivemotor = seguroDivemotor;
    }

    public String getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getEstadoOp() {
        return estadoOp;
    }

    public void setEstadoOp(String estadoOp) {
        this.estadoOp = estadoOp;
    }

    public String getAsesorComercial() {
        return asesorComercial;
    }

    public void setAsesorComercial(String asesorComercial) {
        this.asesorComercial = asesorComercial;
    }
   //F Req. 87567 E2.1 Nuevos campos en reportes jquintanilla 19/02/2020 
  //<I Req. 87567 E2.1 ID:12 avilca 16/09/2020> 
    public String getFechaOp() {
        return fechaOp;
    }

    public void setFechaOp(String fechaOp) {
        this.fechaOp = fechaOp;
    }

    public String getFechaAprobOp() {
        return fechaAprobOp;
    }

    public void setFechaAprobOp(String fechaAprobOp) {
        this.fechaAprobOp = fechaAprobOp;
    }
  //<F Req. 87567 E2.1 ID:12 avilca 16/09/2020>   

    public String getUsuarioReg() {
        return usuarioReg;
    }

    public void setUsuarioReg(String usuarioReg) {
        this.usuarioReg = usuarioReg;
    }

    public String getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getUsuarioVig() {
        return usuarioVig;
    }

    public void setUsuarioVig(String usuarioVig) {
        this.usuarioVig = usuarioVig;
    }

    public String getFechaVig() {
        return fechaVig;
    }

    public void setFechaVig(String fechaVig) {
        this.fechaVig = fechaVig;
    }

    public String getUsuarioEval() {
        return usuarioEval;
    }

    public void setUsuarioEval(String usuarioEval) {
        this.usuarioEval = usuarioEval;
    }

    public String getFechaEval() {
        return fechaEval;
    }

    public void setFechaEval(String fechaEval) {
        this.fechaEval = fechaEval;
    }

    public String getUsuarioAprob() {
        return usuarioAprob;
    }

    public void setUsuarioAprob(String usuarioAprob) {
        this.usuarioAprob = usuarioAprob;
    }

    public String getFechaAprob() {
        return fechaAprob;
    }

    public void setFechaAprob(String fechaAprob) {
        this.fechaAprob = fechaAprob;
    }

    public String getNumRuc() {
        return numRuc;
    }

    public void setNumRuc(String numRuc) {
        this.numRuc = numRuc;
    }

    public String getCodFamiliaVeh() {
        return codFamiliaVeh;
    }

    public void setCodFamiliaVeh(String codFamiliaVeh) {
        this.codFamiliaVeh = codFamiliaVeh;
    }

    public String getDesFamiliaVeh() {
        return desFamiliaVeh;
    }

    public void setDesFamiliaVeh(String desFamiliaVeh) {
        this.desFamiliaVeh = desFamiliaVeh;
    }

    public String getCodTipoVeh() {
        return codTipoVeh;
    }

    public void setCodTipoVeh(String codTipoVeh) {
        this.codTipoVeh = codTipoVeh;
    }

    public String getDesTipoVeh() {
        return desTipoVeh;
    }

    public void setDesTipoVeh(String desTipoVeh) {
        this.desTipoVeh = desTipoVeh;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomMarca() {
        return nomMarca;
    }

    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
    }

    public String getSumaValorRealiz() {
        return sumaValorRealiz;
    }

    public void setSumaValorRealiz(String sumaValorRealiz) {
        this.sumaValorRealiz = sumaValorRealiz;
    }

    public String getUsuarioAprobNivel1() {
        return usuarioAprobNivel1;
    }

    public void setUsuarioAprobNivel1(String usuarioAprobNivel1) {
        this.usuarioAprobNivel1 = usuarioAprobNivel1;
    }

    public String getFechaAprobNivel1() {
        return fechaAprobNivel1;
    }

    public void setFechaAprobNivel1(String fechaAprobNivel1) {
        this.fechaAprobNivel1 = fechaAprobNivel1;
    }

    public String getUsuarioAprobNivel2() {
        return usuarioAprobNivel2;
    }

    public void setUsuarioAprobNivel2(String usuarioAprobNivel2) {
        this.usuarioAprobNivel2 = usuarioAprobNivel2;
    }

    public String getFechaAprobNivel2() {
        return fechaAprobNivel2;
    }

    public void setFechaAprobNivel2(String fechaAprobNivel2) {
        this.fechaAprobNivel2 = fechaAprobNivel2;
    }

    public String getUsuarioAprobNivel3() {
        return usuarioAprobNivel3;
    }

    public void setUsuarioAprobNivel3(String usuarioAprobNivel3) {
        this.usuarioAprobNivel3 = usuarioAprobNivel3;
    }

    public String getFechaAprobNivel3() {
        return fechaAprobNivel3;
    }

    public void setFechaAprobNivel3(String fechaAprobNivel3) {
        this.fechaAprobNivel3 = fechaAprobNivel3;
    }

    public String getUsuarioAprobNivel4() {
        return usuarioAprobNivel4;
    }

    public void setUsuarioAprobNivel4(String usuarioAprobNivel4) {
        this.usuarioAprobNivel4 = usuarioAprobNivel4;
    }

    public String getFechaAprobNivel4() {
        return fechaAprobNivel4;
    }

    public void setFechaAprobNivel4(String fechaAprobNivel4) {
        this.fechaAprobNivel4 = fechaAprobNivel4;
    }

    public String getUsuarioAprobNivel5() {
        return usuarioAprobNivel5;
    }

    public void setUsuarioAprobNivel5(String usuarioAprobNivel5) {
        this.usuarioAprobNivel5 = usuarioAprobNivel5;
    }

    public String getFechaAprobNivel5() {
        return fechaAprobNivel5;
    }

    public void setFechaAprobNivel5(String fechaAprobNivel5) {
        this.fechaAprobNivel5 = fechaAprobNivel5;
    }

    public String getUsuarioAprobNivel6() {
        return usuarioAprobNivel6;
    }

    public void setUsuarioAprobNivel6(String usuarioAprobNivel6) {
        this.usuarioAprobNivel6 = usuarioAprobNivel6;
    }

    public String getFechaAprobNivel6() {
        return fechaAprobNivel6;
    }

    public void setFechaAprobNivel6(String fechaAprobNivel6) {
        this.fechaAprobNivel6 = fechaAprobNivel6;
    }

    public String getNivelesAprob() {
        return nivelesAprob;
    }

    public void setNivelesAprob(String nivelesAprob) {
        this.nivelesAprob = nivelesAprob;
    }

    public String getValGastAdm() {
        return valGastAdm;
    }

    public void setValGastAdm(String valGastAdm) {
        this.valGastAdm = valGastAdm;
    }

    public String getUsuarioAprobNivelMin() {
        return usuarioAprobNivelMin;
    }

    public void setUsuarioAprobNivelMin(String usuarioAprobNivelMin) {
        this.usuarioAprobNivelMin = usuarioAprobNivelMin;
    }

    public String getFechaAprobNivelMin() {
        return fechaAprobNivelMin;
    }

    public void setFechaAprobNivelMin(String fechaAprobNivelMin) {
        this.fechaAprobNivelMin = fechaAprobNivelMin;
    }
   
    
}

