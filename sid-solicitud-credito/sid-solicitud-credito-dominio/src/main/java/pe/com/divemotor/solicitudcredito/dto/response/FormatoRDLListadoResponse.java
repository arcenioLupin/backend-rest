/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLAval;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliaria;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantiaMobiliariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLGarantias;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLHipotecariaAdicional;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLInfoRefinanciamiento;
import pe.com.divemotor.solicitudcredito.dominio.FormatoRDLPrincipal;

/**
 *
 * @author legutierrez
 */
public class FormatoRDLListadoResponse extends ListadoResponse<FormatoRDLPrincipal> {

    private List<FormatoRDLAval> listaAvales;
    private List<FormatoRDLGarantiaMobiliaria> listaGarantiasMob;
    private List<FormatoRDLGarantiaMobiliariaAdicional> listaGarantiasMobAdic;
    private List<FormatoRDLHipotecariaAdicional> listaGarantiasHipAdic;
    private List<FormatoRDLGarantias> listaGarantias;
    private List<FormatoRDLInfoRefinanciamiento> listaInfoRefinanciamiento;

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

}
