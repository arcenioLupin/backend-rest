/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author mbardales
 */
public class SolicitudHistoricoRequest extends BaseRequest {

    private String codSoliCred;
    private double valLcActu;
    private String fecPlazo;
    private double valLcUtil;
    private double valDvencidaDc;
    private double valDvencidaDi;
    private double valPorcDc;
    private double valPorcDi;    

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public double getValLcActu() {
        return valLcActu;
    }

    public void setValLcActu(double valLcActu) {
        this.valLcActu = valLcActu;
    }

    public String getFecPlazo() {
        return fecPlazo;
    }

    public void setFecPlazo(String fecPlazo) {
        this.fecPlazo = fecPlazo;
    }

    public double getValLcUtil() {
        return valLcUtil;
    }

    public void setValLcUtil(double valLcUtil) {
        this.valLcUtil = valLcUtil;
    }

    public double getValDvencidaDc() {
        return valDvencidaDc;
    }

    public void setValDvencidaDc(double valDvencidaDc) {
        this.valDvencidaDc = valDvencidaDc;
    }

    public double getValDvencidaDi() {
        return valDvencidaDi;
    }

    public void setValDvencidaDi(double valDvencidaDi) {
        this.valDvencidaDi = valDvencidaDi;
    }

    public double getValPorcDc() {
        return valPorcDc;
    }

    public void setValPorcDc(double valPorcDc) {
        this.valPorcDc = valPorcDc;
    }

    public double getValPorcDi() {
        return valPorcDi;
    }

    public void setValPorcDi(double valPorcDi) {
        this.valPorcDi = valPorcDi;
    }
    
    

}
