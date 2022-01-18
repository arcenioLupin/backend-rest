/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexosPagos;

/**
 *
 * @author ebarboza
 */
public class ListarAnexosPagodProcedure extends BasePaginadoProcedure<DatosAnexosPagos>{
    
    private String codSoliCred;
    private List<DatosAnexosPagos> listaPagos;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<DatosAnexosPagos> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(List<DatosAnexosPagos> listaPagos) {
        this.listaPagos = listaPagos;
    }
    
    
    
    
}
