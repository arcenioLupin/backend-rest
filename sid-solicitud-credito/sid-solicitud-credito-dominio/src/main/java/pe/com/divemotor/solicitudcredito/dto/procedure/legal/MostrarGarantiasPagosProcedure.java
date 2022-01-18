/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexosGarantias;

/**
 *
 * @author ebarboza
 */
public class MostrarGarantiasPagosProcedure extends BasePaginadoProcedure<DatosAnexosGarantias>{
    
    private String codSoliCred;
    private String indTipoGara;
    private List<DatosAnexosGarantias> listaGarantiaMobiliaria;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<DatosAnexosGarantias> getListaGarantiaMobiliaria() {
        return listaGarantiaMobiliaria;
    }

    public void setListaGarantiaMobiliaria(List<DatosAnexosGarantias> listaGarantiaMobiliaria) {
        this.listaGarantiaMobiliaria = listaGarantiaMobiliaria;
    }

    /**
     * @return the indTipoGara
     */
    public String getIndTipoGara() {
        return indTipoGara;
    }

    /**
     * @param indTipoGara the indTipoGara to set
     */
    public void setIndTipoGara(String indTipoGara) {
        this.indTipoGara = indTipoGara;
    }
    
    
    
}
