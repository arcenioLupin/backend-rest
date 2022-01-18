package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorGasto;

public class ListarSimuladorGastoProcedure extends BasePaginadoProcedure<SimuladorGasto> {

    private String codSimu;
    private String codSoliCred;
    private String numProfVeh;

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

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }
}
