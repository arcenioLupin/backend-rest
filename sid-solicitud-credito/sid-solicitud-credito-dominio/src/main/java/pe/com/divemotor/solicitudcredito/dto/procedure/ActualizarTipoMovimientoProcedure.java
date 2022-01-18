/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author ebarboza
 */
public class ActualizarTipoMovimientoProcedure extends BaseProcedure{
        /*Req. 87567 E2.1 ID## EBARBOZA 21/01/2020*/
        private int codTipoMov; 
	private String txtDescTipoMovi; 
	private String indNatuTipoMovi; 
	private String indInactivo;  
	private String fecCreaRegi;  
	private String codUsuaRegi; 
	private String fecModiRegi;  
	private String codUsuaModi;

    public int getCodTipoMov() {
        return codTipoMov;
    }

    public void setCodTipoMov(int codTipoMov) {
        this.codTipoMov = codTipoMov;
    }

    public String getTxtDescTipoMovi() {
        return txtDescTipoMovi;
    }

    public void setTxtDescTipoMovi(String txtDescTipoMovi) {
        this.txtDescTipoMovi = txtDescTipoMovi;
    }

    public String getIndNatuTipoMovi() {
        return indNatuTipoMovi;
    }

    public void setIndNatuTipoMovi(String indNatuTipoMovi) {
        this.indNatuTipoMovi = indNatuTipoMovi;
    }

    public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }

    public String getFecCreaRegi() {
        return fecCreaRegi;
    }

    public void setFecCreaRegi(String fecCreaRegi) {
        this.fecCreaRegi = fecCreaRegi;
    }

    public String getCodUsuaRegi() {
        return codUsuaRegi;
    }

    public void setCodUsuaRegi(String codUsuaRegi) {
        this.codUsuaRegi = codUsuaRegi;
    }

    public String getFecModiRegi() {
        return fecModiRegi;
    }

    public void setFecModiRegi(String fecModiRegi) {
        this.fecModiRegi = fecModiRegi;
    }

    public String getCodUsuaModi() {
        return codUsuaModi;
    }

    public void setCodUsuaModi(String codUsuaModi) {
        this.codUsuaModi = codUsuaModi;
    }
        
        
    
}
