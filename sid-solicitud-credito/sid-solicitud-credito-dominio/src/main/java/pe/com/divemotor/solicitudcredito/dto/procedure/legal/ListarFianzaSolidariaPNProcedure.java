/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.FianzaSolidariaPN;

/**
 *
 * @author USER
 */
public class ListarFianzaSolidariaPNProcedure extends BasePaginadoProcedure<FianzaSolidariaPN>{
   
    private String codSolcre;
   //I Req. 87567 E2.1 ID 127 avilca 21/01/2020
    private String codPerAval;
   //F Req. 87567 E2.1 ID 127 avilca 21/01/2020

    public String getCodSolcre() {
        return codSolcre;
    }

    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

    public String getCodPerAval() {
        return codPerAval;
    }

    public void setCodPerAval(String codPerAval) {
        this.codPerAval = codPerAval;
    }
    
}
