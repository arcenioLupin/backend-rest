/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

/**
 *
 * @author legutierrez
 */
public class WSInfoDetalleExecuteResponse {

    private SDTInfoDetalle infodetalle;
    private String codigows;

    public SDTInfoDetalle getInfodetalle() {
        return infodetalle;
    }

    public void setInfodetalle(SDTInfoDetalle infodetalle) {
        this.infodetalle = infodetalle;
    }

    public String getCodigows() {
        return codigows;
    }

    public void setCodigows(String codigows) {
        this.codigows = codigows;
    }

}
