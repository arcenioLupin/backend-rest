/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.actividad;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ActividadPorTipoCredito;

/**
 *
 * @author mbardalest
 */
public class ListarActividadesPorTipoCreditoProcedure extends BasePaginadoProcedure<ActividadPorTipoCredito>{
    
    private String codActividad;
    private String codEtapa;
    private String codTipoCredito;

    /**
     * @return the codActividad
     */
    public String getCodActividad() {
        return codActividad;
    }

    /**
     * @param codActividad the codActividad to set
     */
    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    /**
     * @return the codEtapa
     */
    public String getCodEtapa() {
        return codEtapa;
    }

    /**
     * @param codEtapa the codEtapa to set
     */
    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
    }

    /**
     * @return the codTipoCredito
     */
    public String getCodTipoCredito() {
        return codTipoCredito;
    }

    /**
     * @param codTipoCredito the codTipoCredito to set
     */
    public void setCodTipoCredito(String codTipoCredito) {
        this.codTipoCredito = codTipoCredito;
    }
    
    
}
