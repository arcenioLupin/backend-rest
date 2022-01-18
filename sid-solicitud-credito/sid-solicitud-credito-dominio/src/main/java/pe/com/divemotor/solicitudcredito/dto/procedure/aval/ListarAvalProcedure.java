package pe.com.divemotor.solicitudcredito.dto.procedure.aval;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Aval;

public class ListarAvalProcedure extends BasePaginadoProcedure<Aval> {
    private String codSoliCred;
    private Integer retCantidad;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }



}
