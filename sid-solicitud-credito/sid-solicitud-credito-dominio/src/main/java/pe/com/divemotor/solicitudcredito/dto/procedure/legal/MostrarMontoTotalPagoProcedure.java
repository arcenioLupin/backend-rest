/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexosPagosTotal;

/**
 *
 * @author ebarboza
 */
public class MostrarMontoTotalPagoProcedure extends BasePaginadoProcedure<DatosAnexosPagosTotal>{
    
    private String codSoliCred;
    private List<DatosAnexosPagosTotal> listaPagosTotal;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<DatosAnexosPagosTotal> getListaPagosTotal() {
        return listaPagosTotal;
    }

    public void setListaPagosTotal(List<DatosAnexosPagosTotal> listaPagosTotal) {
        this.listaPagosTotal = listaPagosTotal;
    }
    
    
    
}
