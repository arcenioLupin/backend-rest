/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.SolicitudCreditoVO;

/**
 *
 * @author jaltamirano
 */
public class ListarSolicitudCreditoVOProcedure extends BasePaginadoProcedure<SolicitudCreditoVO> {

    private String codSoliCred;
    private String numProfVehi;
    private String codOperacion;
    private String codClie;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getNumProfVehi() {
        return numProfVehi;
    }

    public void setNumProfVehi(String numProfVehi) {
        this.numProfVehi = numProfVehi;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

}
