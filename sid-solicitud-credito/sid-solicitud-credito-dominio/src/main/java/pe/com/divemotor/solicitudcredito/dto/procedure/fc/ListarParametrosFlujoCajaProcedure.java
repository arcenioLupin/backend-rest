/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.fc;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCaja;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;
import pe.com.divemotor.solicitudcredito.dominio.FactorConstanteFlujoCaja;
import pe.com.divemotor.solicitudcredito.dominio.FactorPorMesFlujoCaja;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCajaCabeceraUrbano;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCajaCamiInteUrba;

/**
 *
 * @author mbardales
 */
public class ListarParametrosFlujoCajaProcedure extends BasePaginadoProcedure<ParametrosFlujoCajaCamiInteUrba> {

    private String codSoliCred;
    private String indTipoFc;
    private List<ParametrosFlujoCajaCabeceraUrbano> cabecerasUrbano;
    private List<FactorConstanteFlujoCaja> factoresConstantesFlujoCajaIF;
    private List<FactorConstanteFlujoCaja> factoresConstantesFlujoCajaEF;    
    private List<FactorPorMesFlujoCaja> factoresPorMesFlujoCajaIF;
    private List<FactorPorMesFlujoCaja> factoresPorMesFlujoCajaEF;
    private List<CoberturaFlujoCaja> listaAnios;
    private List<CoberturaFlujoCajaValAnios> listaValProyPorAnios;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndTipoFc() {
        return indTipoFc;
    }

    public void setIndTipoFc(String indTipoFc) {
        this.indTipoFc = indTipoFc;
    }

    public List<ParametrosFlujoCajaCabeceraUrbano> getCabecerasUrbano() {
        return cabecerasUrbano;
    }

    public void setCabecerasUrbano(List<ParametrosFlujoCajaCabeceraUrbano> cabecerasUrbano) {
        this.cabecerasUrbano = cabecerasUrbano;
    }

    public List<FactorConstanteFlujoCaja> getFactoresConstantesFlujoCajaIF() {
        return factoresConstantesFlujoCajaIF;
    }

    public void setFactoresConstantesFlujoCajaIF(List<FactorConstanteFlujoCaja> factoresConstantesFlujoCajaIF) {
        this.factoresConstantesFlujoCajaIF = factoresConstantesFlujoCajaIF;
    }

    public List<FactorConstanteFlujoCaja> getFactoresConstantesFlujoCajaEF() {
        return factoresConstantesFlujoCajaEF;
    }

    public void setFactoresConstantesFlujoCajaEF(List<FactorConstanteFlujoCaja> factoresConstantesFlujoCajaEF) {
        this.factoresConstantesFlujoCajaEF = factoresConstantesFlujoCajaEF;
    }

    public List<FactorPorMesFlujoCaja> getFactoresPorMesFlujoCajaIF() {
        return factoresPorMesFlujoCajaIF;
    }

    public void setFactoresPorMesFlujoCajaIF(List<FactorPorMesFlujoCaja> factoresPorMesFlujoCajaIF) {
        this.factoresPorMesFlujoCajaIF = factoresPorMesFlujoCajaIF;
    }

    public List<FactorPorMesFlujoCaja> getFactoresPorMesFlujoCajaEF() {
        return factoresPorMesFlujoCajaEF;
    }

    public void setFactoresPorMesFlujoCajaEF(List<FactorPorMesFlujoCaja> factoresPorMesFlujoCajaEF) {
        this.factoresPorMesFlujoCajaEF = factoresPorMesFlujoCajaEF;
    }

    public List<CoberturaFlujoCaja> getListaAnios() {
        return listaAnios;
    }

    public void setListaAnios(List<CoberturaFlujoCaja> listaAnios) {
        this.listaAnios = listaAnios;
    }

    public List<CoberturaFlujoCajaValAnios> getListaValProyPorAnios() {
        return listaValProyPorAnios;
    }

    public void setListaValProyPorAnios(List<CoberturaFlujoCajaValAnios> listaValProyPorAnios) {
        this.listaValProyPorAnios = listaValProyPorAnios;
    }

}
