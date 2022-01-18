package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BaseProcedure;

public class RegistrarSimuladorGastoProcedure extends BaseProcedure {

    private Integer codConcCol;
    private String codSimu;
    private Double valMonTotal;
    private String indFin;
    private Double valMonPer;
    private String codMoneda;

    public Integer getCodConcCol() {
        return codConcCol;
    }

    public void setCodConcCol(Integer codConcCol) {
        this.codConcCol = codConcCol;
    }

    public String getCodSimu() {
        return codSimu;
    }

    public void setCodSimu(String codSimu) {
        this.codSimu = codSimu;
    }

    public Double getValMonTotal() {
        return valMonTotal;
    }

    public void setValMonTotal(Double valMonTotal) {
        this.valMonTotal = valMonTotal;
    }

    public String getIndFin() {
        return indFin;
    }

    public void setIndFin(String indFin) {
        this.indFin = indFin;
    }

    public Double getValMonPer() {
        return valMonPer;
    }

    public void setValMonPer(Double valMonPer) {
        this.valMonPer = valMonPer;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

}
