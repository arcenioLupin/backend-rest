/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoRevision;
import pe.com.divemotor.solicitudcredito.dominio.OperacionLegal;
import pe.com.divemotor.solicitudcredito.dominio.PersonaFacultada;

/**
 *
 * @author USER
 */
public class FianzaSolidariaPJResponse extends BaseResponse{
    
    private List<PersonaFacultada> listaPersonasFacultadas;
    private List<DocumentoRevision> listaDocumentosRevision;
    private List<OperacionLegal> listaOperacionesLegales;

    public List<PersonaFacultada> getListaPersonasFacultadas() {
        return listaPersonasFacultadas;
    }

    public void setListaPersonasFacultadas(List<PersonaFacultada> listaPersonasFacultadas) {
        this.listaPersonasFacultadas = listaPersonasFacultadas;
    }

    public List<DocumentoRevision> getListaDocumentosRevision() {
        return listaDocumentosRevision;
    }

    public void setListaDocumentosRevision(List<DocumentoRevision> listaDocumentosRevision) {
        this.listaDocumentosRevision = listaDocumentosRevision;
    }

    public List<OperacionLegal> getListaOperacionesLegales() {
        return listaOperacionesLegales;
    }

    public void setListaOperacionesLegales(List<OperacionLegal> listaOperacionesLegales) {
        this.listaOperacionesLegales = listaOperacionesLegales;
    }
    
    
    
}
