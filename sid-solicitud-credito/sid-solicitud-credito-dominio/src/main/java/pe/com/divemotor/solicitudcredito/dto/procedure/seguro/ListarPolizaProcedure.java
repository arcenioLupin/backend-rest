/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Seguro;

/**
 *
 * @author MGRASSO
 */
public class ListarPolizaProcedure extends BasePaginadoProcedure<Seguro> {

    private String codSoliCred;
    private String nroPoliza;
    private String fecInicVigePoli;
    private String fecFinVigePoli;
    private String indTipoSegu;
    private String codCiaSeg;
    private String codAreaVta;
    private String codEstaPoli;

    /**
     * @return the codSoliCred
     */
    public String getCodSoliCred() {
        return codSoliCred;
    }

    /**
     * @param codSoliCred the codSoliCred to set
     */
    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    /**
     * @return the nroPoliza
     */
    public String getNroPoliza() {
        return nroPoliza;
    }

    /**
     * @param nroPoliza the nroPoliza to set
     */
    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    /**
     * @return the fecInicVigePoli
     */
    public String getFecInicVigePoli() {
        return fecInicVigePoli;
    }

    /**
     * @param fecInicVigePoli the fecInicVigePoli to set
     */
    public void setFecInicVigePoli(String fecInicVigePoli) {
        this.fecInicVigePoli = fecInicVigePoli;
    }

    /**
     * @return the fecFinVigePoli
     */
    public String getFecFinVigePoli() {
        return fecFinVigePoli;
    }

    /**
     * @param fecFinVigePoli the fecFinVigePoli to set
     */
    public void setFecFinVigePoli(String fecFinVigePoli) {
        this.fecFinVigePoli = fecFinVigePoli;
    }

    /**
     * @return the indTipoSegu
     */
    public String getIndTipoSegu() {
        return indTipoSegu;
    }

    /**
     * @param indTipoSegu the indTipoSegu to set
     */
    public void setIndTipoSegu(String indTipoSegu) {
        this.indTipoSegu = indTipoSegu;
    }

    /**
     * @return the codCiaSeg
     */
    public String getCodCiaSeg() {
        return codCiaSeg;
    }

    /**
     * @param codCiaSeg the codCiaSeg to set
     */
    public void setCodCiaSeg(String codCiaSeg) {
        this.codCiaSeg = codCiaSeg;
    }

    /**
     * @return the codAreaVta
     */
    public String getCodAreaVta() {
        return codAreaVta;
    }

    /**
     * @param codAreaVta the codAreaVta to set
     */
    public void setCodAreaVta(String codAreaVta) {
        this.codAreaVta = codAreaVta;
    }

    /**
     * @return the codEstaPoli
     */
    public String getCodEstaPoli() {
        return codEstaPoli;
    }

    /**
     * @param codEstaPoli the codEstaPoli to set
     */
    public void setCodEstaPoli(String codEstaPoli) {
        this.codEstaPoli = codEstaPoli;
    }

}
