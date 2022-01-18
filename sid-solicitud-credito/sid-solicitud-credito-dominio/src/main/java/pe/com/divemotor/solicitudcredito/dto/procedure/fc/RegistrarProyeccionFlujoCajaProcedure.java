/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.fc;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCaja;
import pe.com.divemotor.solicitudcredito.dominio.CoberturaFlujoCajaValAnios;

/**
 *
 * @author mbardales
 */
public class RegistrarProyeccionFlujoCajaProcedure extends BasePaginadoProcedure<CoberturaFlujoCajaValAnios> {

    private String codSoliCred;
    private String indTipoFc;
    private List<CoberturaFlujoCaja> listaNroAnios;

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

    public List<CoberturaFlujoCaja> getListaNroAnios() {
        return listaNroAnios;
    }

    public void setListaNroAnios(List<CoberturaFlujoCaja> listaNroAnios) {
        this.listaNroAnios = listaNroAnios;
    }

}
