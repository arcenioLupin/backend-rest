/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

/**
 *
 * @author legutierrez
 */
public class CuadrarCronogramaRequest extends BaseRequest {

    private String codSoliCred;
    private String numProfVeh;
    private String codSimu;
    private String codTipoOpe;
    private List<SimuladorCronograma> cronograma;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }    

    public String getCodTipoOpe() {
        return codTipoOpe;
    }

    public void setCodTipoOpe(String codTipoOpe) {
        this.codTipoOpe = codTipoOpe;
    }

    public List<SimuladorCronograma> getCronograma() {
        return cronograma;
    }

    public void setCronograma(List<SimuladorCronograma> cronograma) {
        this.cronograma = cronograma;
    }
}
