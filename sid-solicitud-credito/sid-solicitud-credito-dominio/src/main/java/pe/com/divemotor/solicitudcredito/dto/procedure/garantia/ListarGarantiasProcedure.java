package pe.com.divemotor.solicitudcredito.dto.procedure.garantia;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Garantia;

public class ListarGarantiasProcedure extends BasePaginadoProcedure<Garantia> {
    private String codSoliCred;
    private String indTipoGarantia;
    private Integer retCantidad;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndTipoGarantia() {
        return indTipoGarantia;
    }

    public void setIndTipoGarantia(String indTipoGarantia) {
        this.indTipoGarantia = indTipoGarantia;
    }

    
    
    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }
    
    
}
