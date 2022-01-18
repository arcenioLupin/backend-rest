/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCaja;

/**
 *
 * @author mbardales
 */
public class ParametrosFlujoCajaRequest extends BaseRequest {

    private String codSoliCred;
    private String noCia;
    private List<ParametrosFlujoCaja> parametrosFlujoCaja;
    private String indiFlujCaja;

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

    public List<ParametrosFlujoCaja> getParametrosFlujoCaja() {
        return parametrosFlujoCaja;
    }

    public void setParametrosFlujoCaja(List<ParametrosFlujoCaja> parametrosFlujoCaja) {
        this.parametrosFlujoCaja = parametrosFlujoCaja;
    }

    public String getIndiFlujCaja() {
        return indiFlujCaja;
    }

    public void setIndiFlujCaja(String indiFlujCaja) {
        this.indiFlujCaja = indiFlujCaja;
    }

}
