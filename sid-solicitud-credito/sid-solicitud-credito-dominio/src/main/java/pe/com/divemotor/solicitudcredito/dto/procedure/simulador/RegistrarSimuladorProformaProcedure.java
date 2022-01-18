package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BaseProcedure;

public class RegistrarSimuladorProformaProcedure extends BaseProcedure {

    private String codSoliCred;
    private String numProfVeh;
    private Integer canVehFin;
    private Double valVtaTotFin;
    private String indRegistro;

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

    public Integer getCanVehFin() {
        return canVehFin;
    }

    public void setCanVehFin(Integer canVehFin) {
        this.canVehFin = canVehFin;
    }

    public Double getValVtaTotFin() {
        return valVtaTotFin;
    }

    public void setValVtaTotFin(Double valVtaTotFin) {
        this.valVtaTotFin = valVtaTotFin;
    }

    public String getIndRegistro() {
        return indRegistro;
    }

    public void setIndRegistro(String indRegistro) {
        this.indRegistro = indRegistro;
    }

}
