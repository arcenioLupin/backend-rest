/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLAval;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliaria;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantias;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLHipotecariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoFinanciamiento;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoGarantes;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoRefinanciamiento;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLPrincipal;

/**
 *
 * @author legutierrez
 */
public class FormatoRDLProcedure extends BasePaginadoProcedure<FormatoRDLPrincipal> {

    private String codSoliCred;
    private List<FormatoRDLAval> listaAvales;
    private List<FormatoRDLGarantiaMobiliaria> listaGarantiasMob;
    private List<FormatoRDLGarantiaMobiliariaAdicional> listaGarantiasMobAdic;
    private List<FormatoRDLHipotecariaAdicional> listaGarantiasHipAdic;
    private List<FormatoRDLGarantias> listaGarantias;
    private List<FormatoRDLInfoRefinanciamiento> listaInfoRefinanciamiento;
    private List<FormatoRDLInfoGarantes> listaInfoGarantes;
    private List<FormatoRDLInfoFinanciamiento> listaInformacionFinanciamiento;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<FormatoRDLAval> getListaAvales() {
        return listaAvales;
    }

    public void setListaAvales(List<FormatoRDLAval> listaAvales) {
        this.listaAvales = listaAvales;
    }

    public List<FormatoRDLGarantiaMobiliaria> getListaGarantiasMob() {
        return listaGarantiasMob;
    }

    public void setListaGarantiasMob(List<FormatoRDLGarantiaMobiliaria> listaGarantiasMob) {
        this.listaGarantiasMob = listaGarantiasMob;
    }

    public List<FormatoRDLGarantiaMobiliariaAdicional> getListaGarantiasMobAdic() {
        return listaGarantiasMobAdic;
    }

    public void setListaGarantiasMobAdic(List<FormatoRDLGarantiaMobiliariaAdicional> listaGarantiasMobAdic) {
        this.listaGarantiasMobAdic = listaGarantiasMobAdic;
    }

    public List<FormatoRDLHipotecariaAdicional> getListaGarantiasHipAdic() {
        return listaGarantiasHipAdic;
    }

    public void setListaGarantiasHipAdic(List<FormatoRDLHipotecariaAdicional> listaGarantiasHipAdic) {
        this.listaGarantiasHipAdic = listaGarantiasHipAdic;
    }

    public List<FormatoRDLGarantias> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<FormatoRDLGarantias> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }

    public List<FormatoRDLInfoRefinanciamiento> getListaInfoRefinanciamiento() {
        return listaInfoRefinanciamiento;
    }

    public void setListaInfoRefinanciamiento(List<FormatoRDLInfoRefinanciamiento> listaInfoRefinanciamiento) {
        this.listaInfoRefinanciamiento = listaInfoRefinanciamiento;
    }

    /**
     * @return the listaInfoGarantes
     */
    public List<FormatoRDLInfoGarantes> getListaInfoGarantes() {
        return listaInfoGarantes;
    }

    /**
     * @param listaInfoGarantes the listaInfoGarantes to set
     */
    public void setListaInfoGarantes(List<FormatoRDLInfoGarantes> listaInfoGarantes) {
        this.listaInfoGarantes = listaInfoGarantes;
    }

    /**
     * @return the listaInformacionFinanciamiento
     */
    public List<FormatoRDLInfoFinanciamiento> getListaInformacionFinanciamiento() {
        return listaInformacionFinanciamiento;
    }

    /**
     * @param listaInformacionFinanciamiento the listaInformacionFinanciamiento to set
     */
    public void setListaInformacionFinanciamiento(List<FormatoRDLInfoFinanciamiento> listaInformacionFinanciamiento) {
        this.listaInformacionFinanciamiento = listaInformacionFinanciamiento;
    }

}
