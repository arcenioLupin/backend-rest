/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.aval;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Departamento;

/**
 *
 * @author jaltamirano
 */
public class ListarDepartamentosAvalProcedure extends BasePaginadoProcedure<Departamento> {

    private String codPais;
    private Integer retCantidad;

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

}
