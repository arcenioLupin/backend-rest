/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxC;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCDatosGenerales;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCTotales;

/**
 *
 * @author mbardales
 */
public class CronogramaLetrasLxCResponse extends ListadoResponse<CronogramaLetrasLxC> {

    private List<CronogramaLetrasLxCTotales> cronogramaTotales;
    private List<CronogramaLetrasLxCDatosGenerales> datosGenerales;

    public List<CronogramaLetrasLxCTotales> getCronogramaTotales() {
        return cronogramaTotales;
    }

    public void setCronogramaTotales(List<CronogramaLetrasLxCTotales> cronogramaTotales) {
        this.cronogramaTotales = cronogramaTotales;
    }

    public List<CronogramaLetrasLxCDatosGenerales> getDatosGenerales() {
        return datosGenerales;
    }

    public void setDatosGenerales(List<CronogramaLetrasLxCDatosGenerales> datosGenerales) {
        this.datosGenerales = datosGenerales;
    }

}
