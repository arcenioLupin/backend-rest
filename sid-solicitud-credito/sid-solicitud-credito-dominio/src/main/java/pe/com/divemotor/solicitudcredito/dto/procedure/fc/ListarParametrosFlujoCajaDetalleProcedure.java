/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.fc;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCajaxAnio;

/**
 *
 * @author mbardales
 */
public class ListarParametrosFlujoCajaDetalleProcedure extends BasePaginadoProcedure<ParametrosFlujoCajaxAnio> {

    private String codSoliCred;
    private String indTipoFc;
    private List<ParametrosFlujoCajaxAnio> listaEgresos;
    private List<ParametrosFlujoCajaxAnio> listaDetalleFlujoCaja;
    private List<CoberturaFlujoCajaValAnios> listaProyectado;
    private String comentarios;

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndTipoFc() {
        return indTipoFc;
    }

    public void setIndTipoFc(String indTipoFc) {
        this.indTipoFc = indTipoFc;
    }

    public List<ParametrosFlujoCajaxAnio> getListaEgresos() {
        return listaEgresos;
    }

    public void setListaEgresos(List<ParametrosFlujoCajaxAnio> listaEgresos) {
        this.listaEgresos = listaEgresos;
    }

    public List<ParametrosFlujoCajaxAnio> getListaDetalleFlujoCaja() {
        return listaDetalleFlujoCaja;
    }

    public void setListaDetalleFlujoCaja(List<ParametrosFlujoCajaxAnio> listaDetalleFlujoCaja) {
        this.listaDetalleFlujoCaja = listaDetalleFlujoCaja;
    }

    public List<CoberturaFlujoCajaValAnios> getListaProyectado() {
        return listaProyectado;
    }

    public void setListaProyectado(List<CoberturaFlujoCajaValAnios> listaProyectado) {
        this.listaProyectado = listaProyectado;
    }

}
