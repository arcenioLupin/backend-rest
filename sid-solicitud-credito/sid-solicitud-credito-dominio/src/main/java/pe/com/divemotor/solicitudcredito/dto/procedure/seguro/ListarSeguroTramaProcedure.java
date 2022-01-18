/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.TramaSeguro;

/**
 *
 * @author USER
 */
public class ListarSeguroTramaProcedure extends BasePaginadoProcedure<TramaSeguro> {
    
     private String codSoliCred;
     private List<TramaSeguro> listaGarantias;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<TramaSeguro> getListaGarantias() {
        return listaGarantias;
    }

    public void setListaGarantias(List<TramaSeguro> listaGarantias) {
        this.listaGarantias = listaGarantias;
    }
     
     
}
