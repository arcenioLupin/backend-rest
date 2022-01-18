/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;
import pe.com.divemotor.solicitudcredito.dominio.SeguroDetalleVehiculo;

/**
 *
 * @author USER
 */
public class SeguroRequest extends BaseRequest{

    private String codSoliCred;
    private String indRespAproTseg;
    private String txtObseRechTseg;
    private String nroPoliza;
    private String fecInicVigePoli;
    private String fecFinVigePoli;
    private String fecPrimPagoPoliEndo;
    private String fecUltiPagoPoliEndo;
    private String txtRutaPoliEndo;
    private String txtRutaFactura;
    private String codUsuaGestSeg;
    private String codAreaVta;
    private String indTipoSegu;
    private String codEstaPoli;
    //I Req. 87567 E2.1 ID## avilca 07/10/2020
    private String codCiaSeg;
    private Double valPorcTeaSigv;
    //F Req. 87567 E2.1 ID## avilca 07/10/2020-->
    private List<SeguroDetalleVehiculo> listDetalleVehiculo;
    private String tipoAccion;
    private String fecActPoli;
    private String diasConsulta;
 

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
     * @return the listDetalleVehiculo
     */
    public List<SeguroDetalleVehiculo> getListDetalleVehiculo() {
        return listDetalleVehiculo;
    }

    /**
     * @param listDetalleVehiculo the listDetalleVehiculo to set
     */
    public void setListDetalleVehiculo(List<SeguroDetalleVehiculo> listDetalleVehiculo) {
        this.listDetalleVehiculo = listDetalleVehiculo;
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

    public String getTxtRutaFactura() {
        return txtRutaFactura;
    }

    public void setTxtRutaFactura(String txtRutaFactura) {
        this.txtRutaFactura = txtRutaFactura;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getFecActPoli() {
        return fecActPoli;
    }

    public void setFecActPoli(String fecActPoli) {
        this.fecActPoli = fecActPoli;
    }

    public String getDiasConsulta() {
        return diasConsulta;
    }

    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public Double getValPorcTeaSigv() {
        return valPorcTeaSigv;
    }

    public void setValPorcTeaSigv(Double valPorcTeaSigv) {
        this.valPorcTeaSigv = valPorcTeaSigv;
    }

  
}
