/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionados;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionadosTotales;

/**
 *
 * @author mbardales
 */
public class DocumentosRelacionadosListadoResponse extends ListadoResponse<DocumentosRelacionados> {

    private List<DocumentosRelacionadosTotales> listadoTotalesDocuRela;

    public List<DocumentosRelacionadosTotales> getListadoTotalesDocuRela() {
        return listadoTotalesDocuRela;
    }

    public void setListadoTotalesDocuRela(List<DocumentosRelacionadosTotales> listadoTotalesDocuRela) {
        this.listadoTotalesDocuRela = listadoTotalesDocuRela;
    }

}
