package pe.com.divemotor.solicitudcredito.dto.procedure.documento;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Documento;

public class ListarDocumentosProcedure extends BasePaginadoProcedure<Documento> {

    private String codSoliCred;
    private String indMancomunado;
    private String codTipoPerso;
    private String codEstadoCivil;
    private Integer codUsuaSid;
    private String codUsuaWeb;
    private Integer retCantidad;
    private String indOblig;
    //general
    private String desDocuEval;
    private String tipoDocu;
    private String codigoProceso;
    private String indTipoDocu;
    //<!--I-90028-->
    private Integer codSecArchivo; 
    private String txtDesArchivo; 
    private Integer codDocuEval;
    //<!--F-90028-->  
    
   private String codDocLeg;
   
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndMancomunado() {
        return indMancomunado;
    }

    public void setIndMancomunado(String indMancomunado) {
        this.indMancomunado = indMancomunado;
    }

    public String getCodTipoPerso() {
        return codTipoPerso;
    }

    public void setCodTipoPerso(String codTipoPerso) {
        this.codTipoPerso = codTipoPerso;
    }

    public String getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Integer getCodUsuaSid() {
        return codUsuaSid;
    }

    public void setCodUsuaSid(Integer codUsuaSid) {
        this.codUsuaSid = codUsuaSid;
    }

    public String getCodUsuaWeb() {
        return codUsuaWeb;
    }

    public void setCodUsuaWeb(String codUsuaWeb) {
        this.codUsuaWeb = codUsuaWeb;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

    public String getIndOblig() {
        return indOblig;
    }

    public void setIndOblig(String indOblig) {
        this.indOblig = indOblig;
    }

    public String getDesDocuEval() {
        return desDocuEval;
    }

    public void setDesDocuEval(String desDocuEval) {
        this.desDocuEval = desDocuEval;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(String codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

    public String getIndTipoDocu() {
        return indTipoDocu;
    }

    public void setIndTipoDocu(String indTipoDocu) {
        this.indTipoDocu = indTipoDocu;
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

    /**
     * @return the codDocuEval
     */
    public Integer getCodDocuEval() {
        return codDocuEval;
    }

    /**
     * @param codDocuEval the codDocuEval to set
     */
    public void setCodDocuEval(Integer codDocuEval) {
        this.codDocuEval = codDocuEval;
    }

    public String getCodDocLeg() {
        return codDocLeg;
    }

    public void setCodDocLeg(String codDocLeg) {
        this.codDocLeg = codDocLeg;
    }

}
