/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.solicitudcredito.dominio.Correo;
import pe.com.divemotor.solicitudcredito.dto.base.GenericoDTO;

/**
 *
 * @author phramirez
 */
public class CorreoResponse extends GenericoDTO {

    private List<Correo> listadoCorreos;

    public List<Correo> getListadoCorreos() {
        return listadoCorreos;
    }

    public void setListadoCorreos(List<Correo> listadoCorreos) {
        this.listadoCorreos = listadoCorreos;
    }
}
