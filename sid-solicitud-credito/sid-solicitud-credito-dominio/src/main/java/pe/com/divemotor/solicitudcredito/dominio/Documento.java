/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

import java.util.Date;
import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author egonzales, jaltamirano
 */
public class Documento extends BaseRequest {

    private String codSoliCred;
    private Integer codDocuEval;
    private String desDocuEval;
    //private String indInactivo;
    private Integer valDiasVig;
    private String indTipoDocu;
    private String desTipoDocu;
    private Integer codUsuaCreaReg;
    private String indOblig;
    private String indObligLegal;//Req. 87567 E2.1 ID## avilca 01/02/2021
    private Integer codDocuLegal;
    private String txtRutaDoc;
    private Date fecRegDocu;
    private Date fecEmisDoc;
    private String codUsuaWeb;
    //generico
    private String codItemDocu;
    private String codProceso;
    private Date fecModDocu;
    private String codModUsua;
    private Date fecMinVig;
    
      //<!--I-90028-->
    private Integer codSecArchivo; 
    private String txtDesArchivo; 
    //<!--F-90028-->
    
   private String desDocLegal;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public Integer getCodDocuEval() {
        return codDocuEval;
    }

    public void setCodDocuEval(Integer codDocuEval) {
        this.codDocuEval = codDocuEval;
    }

    public String getDesDocuEval() {
        return desDocuEval;
    }

    public void setDesDocuEval(String desDocuEval) {
        this.desDocuEval = desDocuEval;
    }

    /*public String getIndInactivo() {
        return indInactivo;
    }

    public void setIndInactivo(String indInactivo) {
        this.indInactivo = indInactivo;
    }*/
    public Integer getValDiasVig() {
        return valDiasVig;
    }

    public void setValDiasVig(Integer valDiasVig) {
        this.valDiasVig = valDiasVig;
    }

    public String getIndTipoDocu() {
        return indTipoDocu;
    }

    public void setIndTipoDocu(String indTipoDocu) {
        this.indTipoDocu = indTipoDocu;
    }

    public String getDesTipoDocu() {
        return desTipoDocu;
    }

    public void setDesTipoDocu(String desTipoDocu) {
        this.desTipoDocu = desTipoDocu;
    }

    public Integer getCodUsuaCreaReg() {
        return codUsuaCreaReg;
    }

    public void setCodUsuaCreaReg(Integer codUsuaCreaReg) {
        this.codUsuaCreaReg = codUsuaCreaReg;
    }

    public String getIndOblig() {
        return indOblig;
    }

    public void setIndOblig(String indOblig) {
        this.indOblig = indOblig;
    }

    public Integer getCodDocuLegal() {
        return codDocuLegal;
    }

    public void setCodDocuLegal(Integer codDocuLegal) {
        this.codDocuLegal = codDocuLegal;
    }

    public String getTxtRutaDoc() {
        return txtRutaDoc;
    }

    public void setTxtRutaDoc(String txtRutaDoc) {
        this.txtRutaDoc = txtRutaDoc;
    }

    public Date getFecRegDocu() {
        return fecRegDocu;
    }

    public void setFecRegDocu(Date fecRegDocu) {
        this.fecRegDocu = fecRegDocu;
    }

    public Date getFecEmisDoc() {
        return fecEmisDoc;
    }

    public void setFecEmisDoc(Date fecEmisDoc) {
        this.fecEmisDoc = fecEmisDoc;
    }

    public String getCodUsuaWeb() {
        return codUsuaWeb;
    }

    public void setCodUsuaWeb(String codUsuaWeb) {
        this.codUsuaWeb = codUsuaWeb;
    }

    public String getCodItemDocu() {
        return codItemDocu;
    }

    public void setCodItemDocu(String codItemDocu) {
        this.codItemDocu = codItemDocu;
    }

    public String getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(String codProceso) {
        this.codProceso = codProceso;
    }

    public Date getFecModDocu() {
        return fecModDocu;
    }

    public void setFecModDocu(Date fecModDocu) {
        this.fecModDocu = fecModDocu;
    }

    public String getCodModUsua() {
        return codModUsua;
    }

    public void setCodModUsua(String codModUsua) {
        this.codModUsua = codModUsua;
    }

    public Date getFecMinVig() {
        return fecMinVig;
    }

    public void setFecMinVig(Date fecMinVig) {
        this.fecMinVig = fecMinVig;
    }

    /**
     * @return the codSecArchivo
     */
    public Integer getCodSecArchivo() {
        return codSecArchivo;
    }

    /**
     * @param codSecArchivo the codSecArchivo to set
     */
    public void setCodSecArchivo(Integer codSecArchivo) {
        this.codSecArchivo = codSecArchivo;
    }

    /**
     * @return the txtDesArchivo
     */
    public String getTxtDesArchivo() {
        return txtDesArchivo;
    }

    /**
     * @param txtDesArchivo the txtDesArchivo to set
     */
    public void setTxtDesArchivo(String txtDesArchivo) {
        this.txtDesArchivo = txtDesArchivo;
    }

    public String getDesDocLegal() {
        return desDocLegal;
    }

    public void setDesDocLegal(String desDocLegal) {
        this.desDocLegal = desDocLegal;
    }

    public String getIndObligLegal() {
        return indObligLegal;
    }

    public void setIndObligLegal(String indObligLegal) {
        this.indObligLegal = indObligLegal;
    }

    
}
