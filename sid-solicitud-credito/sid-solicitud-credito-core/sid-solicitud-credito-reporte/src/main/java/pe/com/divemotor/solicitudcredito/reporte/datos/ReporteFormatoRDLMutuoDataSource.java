/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;

/**
 *
 * @author legutierrez
 */
public class ReporteFormatoRDLMutuoDataSource {
    
    private String titulo;
    private String indNuevoUsado;
    private String nomEmpresa;
    private String codClie;
    private String nomPerso;
    private String numDocu;
    private String dirDomicilio;
    private String distrito;
    private String provincia;
    private String departamento;
    private String tea;
    private String periGracia;
    private String nomRespoFina;
    private String codClasifSbsClie;
    private String nomPersAval;
    private String doiAval;
    private String direccionAval;
    private String distritoAval;
    private String provinciaAval;
    private String departamentoAval;
    private String valMontoFianzaAval;
    List<ReporteFormatoRDLGarantiasMobiAdicDataSource> listaGarantiasMobiliariasAdic;
    List<ReporteFormatoRDLGarantiasHipoAdicDataSource> listaGarantiasHipotecariasAdic;
    // NUEVOS CAMPOS
    private String indInfo;
    private String tipoPersona;
    private String indNroOpe;
    private String periGracSinInt;
    private String diasPeriGrac;
    private String fecFirmaCont;
    private String fecEntreLeg;
    private String tipoPersAval;
    private String tipoVeh;
    private String infoDetMutuo;
    private String nomBancoMutuo;
    
    // NUEVOS CAMPOS PARA LEASING 1 Y 2
    private String tipoPersGarante;
    private String nomPersGarante;
    private String doiGarante;
    private String direccionGarante;
    private String distritoGarante;
    private String provinciaGarante;
    private String departamentoGarante;
    
    private List<ReporteFormatoRDLInfoFinanciamiento> listaInformacionFinanciamiento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIndNuevoUsado() {
        return indNuevoUsado;
    }

    public void setIndNuevoUsado(String indNuevoUsado) {
        this.indNuevoUsado = indNuevoUsado;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNomPerso() {
        return nomPerso;
    }

    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }

    public String getNumDocu() {
        return numDocu;
    }

    public void setNumDocu(String numDocu) {
        this.numDocu = numDocu;
    }

    public String getDirDomicilio() {
        return dirDomicilio;
    }

    public void setDirDomicilio(String dirDomicilio) {
        this.dirDomicilio = dirDomicilio;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getPeriGracia() {
        return periGracia;
    }

    public void setPeriGracia(String periGracia) {
        this.periGracia = periGracia;
    }

    public String getNomRespoFina() {
        return nomRespoFina;
    }

    public void setNomRespoFina(String nomRespoFina) {
        this.nomRespoFina = nomRespoFina;
    }

    public String getCodClasifSbsClie() {
        return codClasifSbsClie;
    }

    public void setCodClasifSbsClie(String codClasifSbsClie) {
        this.codClasifSbsClie = codClasifSbsClie;
    }

    public String getNomPersAval() {
        return nomPersAval;
    }

    public void setNomPersAval(String nomPersAval) {
        this.nomPersAval = nomPersAval;
    }

    public String getDoiAval() {
        return doiAval;
    }

    public void setDoiAval(String doiAval) {
        this.doiAval = doiAval;
    }

    public String getDireccionAval() {
        return direccionAval;
    }

    public void setDireccionAval(String direccionAval) {
        this.direccionAval = direccionAval;
    }

    public String getDistritoAval() {
        return distritoAval;
    }

    public void setDistritoAval(String distritoAval) {
        this.distritoAval = distritoAval;
    }

    public String getProvinciaAval() {
        return provinciaAval;
    }

    public void setProvinciaAval(String provinciaAval) {
        this.provinciaAval = provinciaAval;
    }

    public String getDepartamentoAval() {
        return departamentoAval;
    }

    public void setDepartamentoAval(String departamentoAval) {
        this.departamentoAval = departamentoAval;
    }

    public String getValMontoFianzaAval() {
        return valMontoFianzaAval;
    }

    public void setValMontoFianzaAval(String valMontoFianzaAval) {
        this.valMontoFianzaAval = valMontoFianzaAval;
    }

    public List<ReporteFormatoRDLGarantiasMobiAdicDataSource> getListaGarantiasMobiliariasAdic() {
        return listaGarantiasMobiliariasAdic;
    }

    public void setListaGarantiasMobiliariasAdic(List<ReporteFormatoRDLGarantiasMobiAdicDataSource> listaGarantiasMobiliariasAdic) {
        this.listaGarantiasMobiliariasAdic = listaGarantiasMobiliariasAdic;
    }

    public List<ReporteFormatoRDLGarantiasHipoAdicDataSource> getListaGarantiasHipotecariasAdic() {
        return listaGarantiasHipotecariasAdic;
    }

    public void setListaGarantiasHipotecariasAdic(List<ReporteFormatoRDLGarantiasHipoAdicDataSource> listaGarantiasHipotecariasAdic) {
        this.listaGarantiasHipotecariasAdic = listaGarantiasHipotecariasAdic;
    }

    /**
     * @return the indInfo
     */
    public String getIndInfo() {
        return indInfo;
    }

    /**
     * @param indInfo the indInfo to set
     */
    public void setIndInfo(String indInfo) {
        this.indInfo = indInfo;
    }

    /**
     * @return the tipoPersona
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    /**
     * @return the indNroOpe
     */
    public String getIndNroOpe() {
        return indNroOpe;
    }

    /**
     * @param indNroOpe the indNroOpe to set
     */
    public void setIndNroOpe(String indNroOpe) {
        this.indNroOpe = indNroOpe;
    }

    /**
     * @return the periGracSinInt
     */
    public String getPeriGracSinInt() {
        return periGracSinInt;
    }

    /**
     * @param periGracSinInt the periGracSinInt to set
     */
    public void setPeriGracSinInt(String periGracSinInt) {
        this.periGracSinInt = periGracSinInt;
    }

    /**
     * @return the diasPeriGrac
     */
    public String getDiasPeriGrac() {
        return diasPeriGrac;
    }

    /**
     * @param diasPeriGrac the diasPeriGrac to set
     */
    public void setDiasPeriGrac(String diasPeriGrac) {
        this.diasPeriGrac = diasPeriGrac;
    }

    /**
     * @return the fecFirmaCont
     */
    public String getFecFirmaCont() {
        return fecFirmaCont;
    }

    /**
     * @param fecFirmaCont the fecFirmaCont to set
     */
    public void setFecFirmaCont(String fecFirmaCont) {
        this.fecFirmaCont = fecFirmaCont;
    }

    /**
     * @return the fecEntreLeg
     */
    public String getFecEntreLeg() {
        return fecEntreLeg;
    }

    /**
     * @param fecEntreLeg the fecEntreLeg to set
     */
    public void setFecEntreLeg(String fecEntreLeg) {
        this.fecEntreLeg = fecEntreLeg;
    }

    /**
     * @return the tipoPersAval
     */
    public String getTipoPersAval() {
        return tipoPersAval;
    }

    /**
     * @param tipoPersAval the tipoPersAval to set
     */
    public void setTipoPersAval(String tipoPersAval) {
        this.tipoPersAval = tipoPersAval;
    }

    /**
     * @return the tipoVeh
     */
    public String getTipoVeh() {
        return tipoVeh;
    }

    /**
     * @param tipoVeh the tipoVeh to set
     */
    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    /**
     * @return the infoDetMutuo
     */
    public String getInfoDetMutuo() {
        return infoDetMutuo;
    }

    /**
     * @param infoDetMutuo the infoDetMutuo to set
     */
    public void setInfoDetMutuo(String infoDetMutuo) {
        this.infoDetMutuo = infoDetMutuo;
    }

    /**
     * @return the nomBancoMutuo
     */
    public String getNomBancoMutuo() {
        return nomBancoMutuo;
    }

    /**
     * @param nomBancoMutuo the nomBancoMutuo to set
     */
    public void setNomBancoMutuo(String nomBancoMutuo) {
        this.nomBancoMutuo = nomBancoMutuo;
    }

    /**
     * @return the tipoPersGarante
     */
    public String getTipoPersGarante() {
        return tipoPersGarante;
    }

    /**
     * @param tipoPersGarante the tipoPersGarante to set
     */
    public void setTipoPersGarante(String tipoPersGarante) {
        this.tipoPersGarante = tipoPersGarante;
    }

    /**
     * @return the nomPersGarante
     */
    public String getNomPersGarante() {
        return nomPersGarante;
    }

    /**
     * @param nomPersGarante the nomPersGarante to set
     */
    public void setNomPersGarante(String nomPersGarante) {
        this.nomPersGarante = nomPersGarante;
    }

    /**
     * @return the doiGarante
     */
    public String getDoiGarante() {
        return doiGarante;
    }

    /**
     * @param doiGarante the doiGarante to set
     */
    public void setDoiGarante(String doiGarante) {
        this.doiGarante = doiGarante;
    }

    /**
     * @return the direccionGarante
     */
    public String getDireccionGarante() {
        return direccionGarante;
    }

    /**
     * @param direccionGarante the direccionGarante to set
     */
    public void setDireccionGarante(String direccionGarante) {
        this.direccionGarante = direccionGarante;
    }

    /**
     * @return the distritoGarante
     */
    public String getDistritoGarante() {
        return distritoGarante;
    }

    /**
     * @param distritoGarante the distritoGarante to set
     */
    public void setDistritoGarante(String distritoGarante) {
        this.distritoGarante = distritoGarante;
    }

    /**
     * @return the provinciaGarante
     */
    public String getProvinciaGarante() {
        return provinciaGarante;
    }

    /**
     * @param provinciaGarante the provinciaGarante to set
     */
    public void setProvinciaGarante(String provinciaGarante) {
        this.provinciaGarante = provinciaGarante;
    }

    /**
     * @return the departamentoGarante
     */
    public String getDepartamentoGarante() {
        return departamentoGarante;
    }

    /**
     * @param departamentoGarante the departamentoGarante to set
     */
    public void setDepartamentoGarante(String departamentoGarante) {
        this.departamentoGarante = departamentoGarante;
    }

    /**
     * @return the listaInformacionFinanciamiento
     */
    public List<ReporteFormatoRDLInfoFinanciamiento> getListaInformacionFinanciamiento() {
        return listaInformacionFinanciamiento;
    }

    /**
     * @param listaInformacionFinanciamiento the listaInformacionFinanciamiento to set
     */
    public void setListaInformacionFinanciamiento(List<ReporteFormatoRDLInfoFinanciamiento> listaInformacionFinanciamiento) {
        this.listaInformacionFinanciamiento = listaInformacionFinanciamiento;
    }
    
    
}
