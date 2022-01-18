/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.IsTipoMovimientoOperacionExiste;

/**
 *
 * @author ebarboza
 */
public class IsTipoMovimientoOperacionExisteProcedure extends BasePaginadoProcedure<IsTipoMovimientoOperacionExiste> {
    
    private String codSoliCred;
    private String txtNroDocumento;
    private Integer codTipoMov;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTxtNroDocumento() {
        return txtNroDocumento;
    }

    public void setTxtNroDocumento(String txtNroDocumento) {
        this.txtNroDocumento = txtNroDocumento;
    }

    public Integer getCodTipoMov() {
        return codTipoMov;
    }

    public void setCodTipoMov(Integer codTipoMov) {
        this.codTipoMov = codTipoMov;
    }
    
    
    
}
