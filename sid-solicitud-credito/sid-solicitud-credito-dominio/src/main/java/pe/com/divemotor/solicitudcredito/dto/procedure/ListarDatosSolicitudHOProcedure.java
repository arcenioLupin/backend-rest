/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosSolicitudHistoricoOpe;

/**
 *
 * @author legutierrez
 */
public class ListarDatosSolicitudHOProcedure extends BasePaginadoProcedure<DatosSolicitudHistoricoOpe> {

    private String codOpera;
    private String codClie;
    private String noCia;

    public String getCodOpera() {
        return codOpera;
    }

    public void setCodOpera(String codOpera) {
        this.codOpera = codOpera;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

}
