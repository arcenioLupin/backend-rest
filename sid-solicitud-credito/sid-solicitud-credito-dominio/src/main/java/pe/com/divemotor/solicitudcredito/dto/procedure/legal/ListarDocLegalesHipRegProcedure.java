/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DocLegalHipReg;


/**
 *
 * @author USER
 */
public class ListarDocLegalesHipRegProcedure extends BasePaginadoProcedure<DocLegalHipReg> {
    
    private String codSoliCred;
    private String codCanleg;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodCanleg() {
        return codCanleg;
    }

    public void setCodCanleg(String codCanleg) {
        this.codCanleg = codCanleg;
    }
    
    
    
}
