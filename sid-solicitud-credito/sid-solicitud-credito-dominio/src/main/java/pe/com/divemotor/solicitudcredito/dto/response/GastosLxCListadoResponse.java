/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxC;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxCTotales;

/**
 *
 * @author mbardales
 */
public class GastosLxCListadoResponse extends ListadoResponse<GastosLxC> {

    public List<GastosLxCTotales> listaGastosLxCTotales;

    public List<GastosLxCTotales> getListaGastosLxCTotales() {
        return listaGastosLxCTotales;
    }

    public void setListaGastosLxCTotales(List<GastosLxCTotales> listaGastosLxCTotales) {
        this.listaGastosLxCTotales = listaGastosLxCTotales;
    }

}
