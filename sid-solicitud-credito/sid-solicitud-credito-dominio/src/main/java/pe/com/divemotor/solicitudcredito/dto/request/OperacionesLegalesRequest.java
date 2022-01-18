/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.OperacionLegal;

/**
 *
 * @author USER
 */
public class OperacionesLegalesRequest extends BaseRequest {

    private String codSolcre;
    private List<OperacionLegal> operacionesLegales;
    private int codDocRev;

    /**
     * @return the codSolcre
     */
    public String getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSolcre to set
     */
    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

    /**
     * @return the operacionesLegales
     */
    public List<OperacionLegal> getOperacionesLegales() {
        return operacionesLegales;
    }

    /**
     * @param operacionesLegales the operacionesLegales to set
     */
    public void setOperacionesLegales(List<OperacionLegal> operacionesLegales) {
        this.operacionesLegales = operacionesLegales;
    }

    public int getCodDocRev() {
        return codDocRev;
    }

    public void setCodDocRev(int codDocRev) {
        this.codDocRev = codDocRev;
    }

}
