/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.seguro;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class ActualizarSeguroProcedure extends BaseProcedure{
    
    private String codSoliCred;
    private String indRespAproTseg;
    private String txtObseRechTseg;
    private String codUsuaGestSeg;
    private String nroPoliSeg;
    private String fecInicVigePoli;
    private String fecFinVigePoli;
    private String fecPrimPagoPoliEndo;
    private String fecUltiPagoPoliEndo;
    private String txtRutaPoliEndo;
    private String txtRutaFactura;
    private String fecActPoli;
    //I Req. 87567 E2.1 ID## avilca 07/10/2020
    private String codCiaSeg;
    private Double valPorcTeaSigv;
   //F Req. 87567 E2.1 ID## avilca 07/10/2020
    
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
     * @return the indRespAproTseg
     */
    public String getIndRespAproTseg() {
        return indRespAproTseg;
    }

    /**
     * @param indRespAproTseg the indRespAproTseg to set
     */
    public void setIndRespAproTseg(String indRespAproTseg) {
        this.indRespAproTseg = indRespAproTseg;
    }

    /**
     * @return the txtObseRechTseg
     */
    public String getTxtObseRechTseg() {
        return txtObseRechTseg;
    }

    /**
     * @param txtObseRechTseg the txtObseRechTseg to set
     */
    public void setTxtObseRechTseg(String txtObseRechTseg) {
        this.txtObseRechTseg = txtObseRechTseg;
    }

    /**
     * @return the codUsuaGestSeg
     */
    public String getCodUsuaGestSeg() {
        return codUsuaGestSeg;
    }

    /**
     * @param codUsuaGestSeg the codUsuaGestSeg to set
     */
    public void setCodUsuaGestSeg(String codUsuaGestSeg) {
        this.codUsuaGestSeg = codUsuaGestSeg;
    }

    /**
     * @return the nroPoliSeg
     */
    public String getNroPoliSeg() {
        return nroPoliSeg;
    }

    /**
     * @param nroPoliSeg the nroPoliSeg to set
     */
    public void setNroPoliSeg(String nroPoliSeg) {
        this.nroPoliSeg = nroPoliSeg;
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
     * @return the fecPrimPagoPoliEndo
     */
    public String getFecPrimPagoPoliEndo() {
        return fecPrimPagoPoliEndo;
    }

    /**
     * @param fecPrimPagoPoliEndo the fecPrimPagoPoliEndo to set
     */
    public void setFecPrimPagoPoliEndo(String fecPrimPagoPoliEndo) {
        this.fecPrimPagoPoliEndo = fecPrimPagoPoliEndo;
    }

    /**
     * @return the fecUltiPagoPoliEndo
     */
    public String getFecUltiPagoPoliEndo() {
        return fecUltiPagoPoliEndo;
    }

    /**
     * @param fecUltiPagoPoliEndo the fecUltiPagoPoliEndo to set
     */
    public void setFecUltiPagoPoliEndo(String fecUltiPagoPoliEndo) {
        this.fecUltiPagoPoliEndo = fecUltiPagoPoliEndo;
    }

    /**
     * @return the txtRutaPoliEndo
     */
    public String getTxtRutaPoliEndo() {
        return txtRutaPoliEndo;
    }

    /**
     * @param txtRutaPoliEndo the txtRutaPoliEndo to set
     */
    public void setTxtRutaPoliEndo(String txtRutaPoliEndo) {
        this.txtRutaPoliEndo = txtRutaPoliEndo;
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

    public String getTxtRutaFactura() {
        return txtRutaFactura;
    }

    public void setTxtRutaFactura(String txtRutaFactura) {
        this.txtRutaFactura = txtRutaFactura;
    }

    public String getFecActPoli() {
        return fecActPoli;
    }

    public void setFecActPoli(String fecActPoli) {
        this.fecActPoli = fecActPoli;
    }

    public String getCodCiaSeg() {
        return codCiaSeg;
    }

    public void setCodCiaSeg(String codCiaSeg) {
        this.codCiaSeg = codCiaSeg;
    }

    public Double getValPorcTeaSigv() {
        return valPorcTeaSigv;
    }

    public void setValPorcTeaSigv(Double valPorcTeaSigv) {
        this.valPorcTeaSigv = valPorcTeaSigv;
    }
   
}
