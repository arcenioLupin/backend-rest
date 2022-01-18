package pe.com.divemotor.solicitudcredito.dto.procedure.simulador;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CompaniaSeguro;

public class ListarCompaniaSeguroProcedure extends BasePaginadoProcedure<CompaniaSeguro> {

    private String codCiaSeg;

    public String getCodCiaSeg() {
        return codCiaSeg;
    }

    public void setCodCiaSeg(String codCiaSeg) {
        this.codCiaSeg = codCiaSeg;
    }

}
