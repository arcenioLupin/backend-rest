package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorConcepto;

public class ListarSimuladorConceptoProcedure extends BasePaginadoProcedure<SimuladorConcepto> {

    private Integer codConcCol;
    private String indConcOblig;

    public int getCodConcCol() {
        return codConcCol;
    }

    public void setCodConcCol(Integer codConcCol) {
        this.codConcCol = codConcCol;
    }

    public String getIndConcOblig() {
        return indConcOblig;
    }

    public void setIndConcOblig(String indConcOblig) {
        this.indConcOblig = indConcOblig;
    }        
}
