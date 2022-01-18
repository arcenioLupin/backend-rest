/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ParametroRegistroSolcre;

/**
 *
 * @author avilca
 */
public class ListarParamRegSolcreProcedure extends BasePaginadoProcedure<ParametroRegistroSolcre> {
    
    private String codCredSoliPara;

    public String getCodCredSoliPara() {
        return codCredSoliPara;
    }

    public void setCodCredSoliPara(String codCredSoliPara) {
        this.codCredSoliPara = codCredSoliPara;
    }
    
    
    
}
