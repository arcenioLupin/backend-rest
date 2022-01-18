/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCaja;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;

/**
 *
 * @author mbardales
 */
public class ProyeccionFlujoCajaListadoResponse extends ListadoResponse<CoberturaFlujoCajaValAnios> {

    private List<CoberturaFlujoCaja> listaNroAnios;

    public List<CoberturaFlujoCaja> getListaNroAnios() {
        return listaNroAnios;
    }

    public void setListaNroAnios(List<CoberturaFlujoCaja> listaNroAnios) {
        this.listaNroAnios = listaNroAnios;
    }

}
