/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Vehiculos;

/**
 *
 * @author legutierrez
 */
public class ListarVehiculosProcedure extends BasePaginadoProcedure<Vehiculos> {

    private String codSoliCred;
    private String indConsulta;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndConsulta() {
        return indConsulta;
    }

    public void setIndConsulta(String indConsulta) {
        this.indConsulta = indConsulta;
    }

}
