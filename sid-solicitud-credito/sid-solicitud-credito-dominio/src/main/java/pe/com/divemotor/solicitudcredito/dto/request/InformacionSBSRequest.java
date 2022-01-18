/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import java.math.BigDecimal;
import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author legutierrez
 */
public class InformacionSBSRequest extends BaseRequest{
    
    private String codClasifSbsClie;
    private String codClasifSbsRepr;
    private String codPersonaClie;
    private String codPersonaRepr;
    private String codRiesDiveClie;
    private String codRiesDiveRepr;
    private String codSoliCred;
    private String indCondRucClie;
    private String indCondRucRepr;
    private String txtLinkSbsClie;
    private String txtLinkSbsRepr;
    private BigDecimal valDeudActuClie;
    private double valDeudActuRepr;
    private BigDecimal valDeudCierAnoActuClie;
    private double valDeudCierAnoActuRepr;
    private BigDecimal valDeudCierAnoAnteClie;
    private double valDeudCierAnoAnteRepr;
    private double valDeudVenciClie;
    private double valDeudVenciRepr;
    private double valImpaClie;
    private double valImpaRepr;
    private double valProtSinReguClie;
    private double valProtSinReguRepr;
    private double valProtReguClie;
    private double valProtReguRepr;

    public double getValProtReguClie() {
        return valProtReguClie;
    }

    public void setValProtReguClie(double valProtReguClie) {
        this.valProtReguClie = valProtReguClie;
    }

    public double getValProtReguRepr() {
        return valProtReguRepr;
    }

    public void setValProtReguRepr(double valProtReguRepr) {
        this.valProtReguRepr = valProtReguRepr;
    }

    public String getCodClasifSbsClie() {
        return codClasifSbsClie;
    }

    public void setCodClasifSbsClie(String codClasifSbsClie) {
        this.codClasifSbsClie = codClasifSbsClie;
    }

    public String getCodClasifSbsRepr() {
        return codClasifSbsRepr;
    }

    public void setCodClasifSbsRepr(String codClasifSbsRepr) {
        this.codClasifSbsRepr = codClasifSbsRepr;
    }

    public String getCodPersonaClie() {
        return codPersonaClie;
    }

    public void setCodPersonaClie(String codPersonaClie) {
        this.codPersonaClie = codPersonaClie;
    }

    public String getCodPersonaRepr() {
        return codPersonaRepr;
    }

    public void setCodPersonaRepr(String codPersonaRepr) {
        this.codPersonaRepr = codPersonaRepr;
    }

    public String getCodRiesDiveClie() {
        return codRiesDiveClie;
    }

    public void setCodRiesDiveClie(String codRiesDiveClie) {
        this.codRiesDiveClie = codRiesDiveClie;
    }

    public String getCodRiesDiveRepr() {
        return codRiesDiveRepr;
    }

    public void setCodRiesDiveRepr(String codRiesDiveRepr) {
        this.codRiesDiveRepr = codRiesDiveRepr;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getIndCondRucClie() {
        return indCondRucClie;
    }

    public void setIndCondRucClie(String indCondRucClie) {
        this.indCondRucClie = indCondRucClie;
    }

    public String getIndCondRucRepr() {
        return indCondRucRepr;
    }

    public void setIndCondRucRepr(String indCondRucRepr) {
        this.indCondRucRepr = indCondRucRepr;
    }

    public String getTxtLinkSbsClie() {
        return txtLinkSbsClie;
    }

    public void setTxtLinkSbsClie(String txtLinkSbsClie) {
        this.txtLinkSbsClie = txtLinkSbsClie;
    }

    public String getTxtLinkSbsRepr() {
        return txtLinkSbsRepr;
    }

    public void setTxtLinkSbsRepr(String txtLinkSbsRepr) {
        this.txtLinkSbsRepr = txtLinkSbsRepr;
    }



    public double getValDeudActuRepr() {
        return valDeudActuRepr;
    }

    public void setValDeudActuRepr(double valDeudActuRepr) {
        this.valDeudActuRepr = valDeudActuRepr;
    }

    public double getValDeudCierAnoActuRepr() {
        return valDeudCierAnoActuRepr;
    }

    public void setValDeudCierAnoActuRepr(double valDeudCierAnoActuRepr) {
        this.valDeudCierAnoActuRepr = valDeudCierAnoActuRepr;
    }

    public double getValDeudCierAnoAnteRepr() {
        return valDeudCierAnoAnteRepr;
    }

    public void setValDeudCierAnoAnteRepr(double valDeudCierAnoAnteRepr) {
        this.valDeudCierAnoAnteRepr = valDeudCierAnoAnteRepr;
    }

    public double getValDeudVenciClie() {
        return valDeudVenciClie;
    }

    public void setValDeudVenciClie(double valDeudVenciClie) {
        this.valDeudVenciClie = valDeudVenciClie;
    }

    public double getValDeudVenciRepr() {
        return valDeudVenciRepr;
    }

    public void setValDeudVenciRepr(double valDeudVenciRepr) {
        this.valDeudVenciRepr = valDeudVenciRepr;
    }

    public double getValImpaClie() {
        return valImpaClie;
    }

    public void setValImpaClie(double valImpaClie) {
        this.valImpaClie = valImpaClie;
    }

    public double getValImpaRepr() {
        return valImpaRepr;
    }

    public void setValImpaRepr(double valImpaRepr) {
        this.valImpaRepr = valImpaRepr;
    }

    public double getValProtSinReguClie() {
        return valProtSinReguClie;
    }

    public void setValProtSinReguClie(double valProtSinReguClie) {
        this.valProtSinReguClie = valProtSinReguClie;
    }

    public double getValProtSinReguRepr() {
        return valProtSinReguRepr;
    }

    public void setValProtSinReguRepr(double valProtSinReguRepr) {
        this.valProtSinReguRepr = valProtSinReguRepr;
    }

    public BigDecimal getValDeudActuClie() {
        return valDeudActuClie;
    }

    public void setValDeudActuClie(BigDecimal valDeudActuClie) {
        this.valDeudActuClie = valDeudActuClie;
    }

    public BigDecimal getValDeudCierAnoActuClie() {
        return valDeudCierAnoActuClie;
    }

    public void setValDeudCierAnoActuClie(BigDecimal valDeudCierAnoActuClie) {
        this.valDeudCierAnoActuClie = valDeudCierAnoActuClie;
    }

    public BigDecimal getValDeudCierAnoAnteClie() {
        return valDeudCierAnoAnteClie;
    }

    public void setValDeudCierAnoAnteClie(BigDecimal valDeudCierAnoAnteClie) {
        this.valDeudCierAnoAnteClie = valDeudCierAnoAnteClie;
    }
     
}
