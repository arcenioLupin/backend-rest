/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.TipoMovimiento;

/**
 *
 * @author eudo.barboza
 */ 
public class ListarTipoMovimientoProcedure extends BasePaginadoProcedure<TipoMovimiento> {
    /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
    private int codTipoMov;
    private String codDesTipoMov;
    private String codTipoNat;

    public int getCodTipoMov() {
        return codTipoMov;
    }

    public void setCodTipoMov(int codTipoMov) {
        this.codTipoMov = codTipoMov;
    }

    /**
     * @return the codDesTipoMov
     */
    public String getCodDesTipoMov() {
        return codDesTipoMov;
    }

    /**
     * @param codDesTipoMov the codDesTipoMov to set
     */
    public void setCodDesTipoMov(String codDesTipoMov) {
        this.codDesTipoMov = codDesTipoMov;
    }

    /**
     * @return the codTipoNat
     */
    public String getCodTipoNat() {
        return codTipoNat;
    }

    /**
     * @param codTipoNat the codTipoNat to set
     */
    public void setCodTipoNat(String codTipoNat) {
        this.codTipoNat = codTipoNat;
    }

    
    
    
    
}
