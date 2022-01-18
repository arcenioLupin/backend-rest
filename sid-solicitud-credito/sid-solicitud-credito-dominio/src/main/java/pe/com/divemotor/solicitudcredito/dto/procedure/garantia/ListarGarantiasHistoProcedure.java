package pe.com.divemotor.solicitudcredito.dto.procedure.garantia;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Garantia;
import pe.com.divemotor.solicitudcredito.dominio.GarantiaHistorico;

public class ListarGarantiasHistoProcedure extends BasePaginadoProcedure<GarantiaHistorico> {
    private String codSoliCred;
    private String indTipoGarantia;
    private String codCliente;
    private String numPedidoVeh;
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

    public String getIndTipoGarantia() {
        return indTipoGarantia;
    }

    public void setIndTipoGarantia(String indTipoGarantia) {
        this.indTipoGarantia = indTipoGarantia;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNumPedidoVeh() {
        return numPedidoVeh;
    }

    public void setNumPedidoVeh(String numPedidoVeh) {
        this.numPedidoVeh = numPedidoVeh;
    }
    
    
}
