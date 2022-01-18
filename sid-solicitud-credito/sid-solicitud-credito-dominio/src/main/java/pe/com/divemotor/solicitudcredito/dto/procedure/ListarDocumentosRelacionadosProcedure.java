/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionados;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionadosTotales;

/**
 *
 * @author mbardales
 */
public class ListarDocumentosRelacionadosProcedure extends BasePaginadoProcedure<DocumentosRelacionados> {

    private String codCliente;
    private String codSoliCred;
    private String noCia;
    private List<DocumentosRelacionadosTotales> listadoTotalesDocuRela;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public List<DocumentosRelacionadosTotales> getListadoTotalesDocuRela() {
        return listadoTotalesDocuRela;
    }

    public void setListadoTotalesDocuRela(List<DocumentosRelacionadosTotales> listadoTotalesDocuRela) {
        this.listadoTotalesDocuRela = listadoTotalesDocuRela;
    }

}
