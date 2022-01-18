/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

/**
 *
 * @author eudo.barboza
 */
public class ListaTipoMovimientoRequest {
    
    private int codTipoMov; 
    private String codDesTipoMov;
    private String codTipoNat;

    public int getCodTipoMov() {
        return codTipoMov;
    }

    public void setCodTipoMov(int codTipoMov) {
        this.codTipoMov = codTipoMov;
    }

    /**
     * @return the codDesTipoMov
     */
    public String getCodDesTipoMov() {
        return codDesTipoMov;
    }

    /**
     * @param codDesTipoMov the codDesTipoMov to set
     */
    public void setCodDesTipoMov(String codDesTipoMov) {
        this.codDesTipoMov = codDesTipoMov;
    }

    /**
     * @return the codTipoNat
     */
    public String getCodTipoNat() {
        return codTipoNat;
    }

    /**
     * @param codTipoNat the codTipoNat to set
     */
    public void setCodTipoNat(String codTipoNat) {
        this.codTipoNat = codTipoNat;
    }

    
	
    
}
