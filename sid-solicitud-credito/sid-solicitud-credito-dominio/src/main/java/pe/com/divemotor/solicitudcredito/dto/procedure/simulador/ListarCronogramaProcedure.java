package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorConcepto;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorProceso;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorTotal;

public class ListarCronogramaProcedure extends BasePaginadoProcedure<SimuladorCronograma> {

    private String codSimu;
    private String codSoliCred;
    private String numProfVeh;
    private String codTipoOpe;
    private List<SimuladorCronograma> cronograma;
    private List<SimuladorConcepto> listadoColumna;
    private List<SimuladorTotal> total;
    private List<SimuladorProceso> proceso;

    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }    

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public String getCodTipoOpe() {
        return codTipoOpe;
    }

    public void setCodTipoOpe(String codTipoOpe) {
        this.codTipoOpe = codTipoOpe;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public List<SimuladorCronograma> getCronograma() {
        return cronograma;
    }

    public void setCronograma(List<SimuladorCronograma> cronograma) {
        this.cronograma = cronograma;
    }

    public List<SimuladorConcepto> getListadoColumna() {
        return listadoColumna;
    }

    public void setListadoColumna(List<SimuladorConcepto> listadoColumna) {
        this.listadoColumna = listadoColumna;
    }

    public List<SimuladorTotal> getTotal() {
        return total;
    }

    public void setTotal(List<SimuladorTotal> total) {
        this.total = total;
    }

    public List<SimuladorProceso> getProceso() {
        return proceso;
    }

    public void setProceso(List<SimuladorProceso> proceso) {
        this.proceso = proceso;
    }

}
