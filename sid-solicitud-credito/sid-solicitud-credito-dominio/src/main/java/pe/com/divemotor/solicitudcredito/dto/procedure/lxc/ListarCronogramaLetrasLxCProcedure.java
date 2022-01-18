/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.lxc;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxC;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCDatosGenerales;
import pe.com.divemotor.solicitudcredito.dominio.CronogramaLetrasLxCTotales;

/**
 *
 * @author mbardales
 */
public class ListarCronogramaLetrasLxCProcedure extends BasePaginadoProcedure<CronogramaLetrasLxC> {

    private String codSoliCred;
    private List<CronogramaLetrasLxCTotales> cronogramaTotales;
    private List<CronogramaLetrasLxCDatosGenerales> datosGenerales;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

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
