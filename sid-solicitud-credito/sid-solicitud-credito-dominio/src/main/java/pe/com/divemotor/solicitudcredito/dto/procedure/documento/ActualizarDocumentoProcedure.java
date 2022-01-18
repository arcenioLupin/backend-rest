package pe.com.divemotor.solicitudcredito.dto.procedure.documento;
//EGH

import pe.com.divemotor.generico.dto.BaseProcedure;

public class ActualizarDocumentoProcedure extends BaseProcedure {

    private Integer codDocuEval;
    private String desDocuEval;
    private String codSoliCred;
    private String txtRutaDoc;
    private String fecEmisDoc;
    private String operacion;
    private String indOblig;
    private String indObligatorioLegal;//Req. 87567 E2.1 ID## avilca 01/02/2021
    private Integer codDocuLegal;
    //general
    private String tipoDocu;
    private String codProceso;
   //<!--I-90028-->
    private Integer codSecArchivo; 
    private String txtDesArchivo; 
    //<!--F-90028-->
    private String codDocLegal;
    private String valDiasVig; /*Req. 87567 E2.1 ID## avilca 23/11/2020*/
    
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

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTxtRutaDoc() {
        return txtRutaDoc;
    }

    public void setTxtRutaDoc(String txtRutaDoc) {
        this.txtRutaDoc = txtRutaDoc;
    }

    public String getFecEmisDoc() {
        return fecEmisDoc;
    }

    public void setFecEmisDoc(String fecEmisDoc) {
        this.fecEmisDoc = fecEmisDoc;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
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

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(String codProceso) {
        this.codProceso = codProceso;
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

    public String getCodDocLegal() {
        return codDocLegal;
    }

    public void setCodDocLegal(String codDocLegal) {
        this.codDocLegal = codDocLegal;
    }

    public String getValDiasVig() {
        return valDiasVig;
    }

    public void setValDiasVig(String valDiasVig) {
        this.valDiasVig = valDiasVig;
    }

    public String getIndObligatorioLegal() {
        return indObligatorioLegal;
    }

    public void setIndObligatorioLegal(String indObligatorioLegal) {
        this.indObligatorioLegal = indObligatorioLegal;
    }

    
}
