/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosAnexos;

/**
 *
 * @author USER
 */
public class ListarDatosAnexosProcedure extends BasePaginadoProcedure<DatosAnexos> {
    
    private String codOper;
    private String codSoliCred;
    private List<String> listaNumFacturas;
    

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public List<String> getListaNumFacturas() {
        return listaNumFacturas;
    }

    public void setListaNumFacturas(List<String> listaNumFacturas) {
        this.listaNumFacturas = listaNumFacturas;
    }


    
}
