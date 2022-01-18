/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosCabeceraCronograma;
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

/**
 *
 * @author USER
 */
public class ListarDatosCabeCronProcedure extends BasePaginadoProcedure<DatosCabeceraCronograma> {
    
    private String codSoliCred;
    private List<SimuladorCronograma> listaCronograma;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    /**
     * @return the listaCronograma
     */
    public List<SimuladorCronograma> getListaCronograma() {
        return listaCronograma;
    }

    /**
     * @param listaCronograma the listaCronograma to set
     */
    public void setListaCronograma(List<SimuladorCronograma> listaCronograma) {
        this.listaCronograma = listaCronograma;
    }
    
    
    
}
