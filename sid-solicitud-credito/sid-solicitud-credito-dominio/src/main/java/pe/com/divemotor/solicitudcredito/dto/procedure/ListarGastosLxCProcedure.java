/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxC;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxCTotales;

/**
 *
 * @author mbardales
 */
public class ListarGastosLxCProcedure extends BasePaginadoProcedure<GastosLxC> {

    private String codSoliCred;
    public List<GastosLxCTotales> listaGastosLxCTotales;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<GastosLxCTotales> getListaGastosLxCTotales() {
        return listaGastosLxCTotales;
    }

    public void setListaGastosLxCTotales(List<GastosLxCTotales> listaGastosLxCTotales) {
        this.listaGastosLxCTotales = listaGastosLxCTotales;
    }

}
