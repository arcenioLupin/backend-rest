/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosAprobacion;

/**
 *
 * @author legutierrez
 */
public class RegistrarAprobacionProcedure extends BaseProcedure {

    private String codSoliCred;
    private String numProfVeh;
    // <I> 90690 ivelasquez 21/09/2021
    private Integer confirmacion;
    private List<DatosAprobacion> listaAprobacion;
    // <F> 90690 ivelasquez 21/09/2021
    
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public Integer getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Integer confirmacion) {
        this.confirmacion = confirmacion;
    }

    public List<DatosAprobacion> getListaAprobacion() {
        return listaAprobacion;
    }

    public void setListaAprobacion(List<DatosAprobacion> listaAprobacion) {
        this.listaAprobacion = listaAprobacion;
    }

}
