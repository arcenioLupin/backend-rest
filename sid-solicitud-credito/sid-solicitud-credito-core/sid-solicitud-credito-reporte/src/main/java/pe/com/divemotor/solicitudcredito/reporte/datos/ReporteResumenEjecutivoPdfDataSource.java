/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.List;

/**
 *
 * @author legutierrez
 */
public class ReporteResumenEjecutivoPdfDataSource {

    private String valPorCi;
    private String valCi;
    private String montoCred;
    private String canPlazMes;
    private String valPorcTeaSigv;
    private String canDiasVencPrimLetr;
    private String canVehFin;
    private String desAreaVta;
    private String desMarca;
    private String precTotal;
    private String descripcion;
    private String nroLetras;
    private String codSociedad;
    private String nomSociedad;
    private String valAnoFab;
    private String gps;
    private String gpsDetalle;
    private String seguro;
    private String seguroDetalle;
    private String nomCliente;
    private String codClasifSbsClie;
    private String valDeudActuClie;
    private String valLineaCredito;//<I Req. 87567 E2.1 ID## AVILCA 19/02/2021>
    private String valDeudaDeta;
    private String txtInfoAdic;
    private String txtInfoOper;
    private String valAnio1;
    private String valAnio2;
    private String valMutuo;
    private String valDirecto;
    private String valMutuoDirecto;
    private String valGastAdmi;
    private String codRespFina;
    
    private String anio1;
    private String anio2;
    private String anio3;
    private String anio4;
    private String anio5;
    private String anio6;
    private String anio7;
    private String anio8;
    private String anio9;
    private String anio10;

    private String valCoberGara1;
    private String valCoberGara2;
    private String valCoberGara3;
    private String valCoberGara4;
    private String valCoberGara5;
    private String valCoberGara6;
    private String valCoberGara7;
    private String valCoberGara8;
    private String valCoberGara9;
    private String valCoberGara10;

    private String valRatioCober1;
    private String valRatioCober2;
    private String valRatioCober3;
    private String valRatioCober4;
    private String valRatioCober5;
    private String valRatioCober6;
    private String valRatioCober7;
    private String valRatioCober8;
    private String valRatioCober9;
    private String valRatioCober10;  
    private String canDiasFactCred;//Req. 87567 E2.1 ID 36 AVILCA 15/06/220

    public String getValPorCi() {
        return valPorCi;
    }

    public void setValPorCi(String valPorCi) {
        this.valPorCi = valPorCi;
    }

    public String getValCi() {
        return valCi;
    }

    public void setValCi(String valCi) {
        this.valCi = valCi;
    }

    public String getMontoCred() {
        return montoCred;
    }

    public void setMontoCred(String montoCred) {
        this.montoCred = montoCred;
    }

    public String getCanPlazMes() {
        return canPlazMes;
    }

    public void setCanPlazMes(String canPlazMes) {
        this.canPlazMes = canPlazMes;
    }

    public String getValPorcTeaSigv() {
        return valPorcTeaSigv;
    }

    public void setValPorcTeaSigv(String valPorcTeaSigv) {
        this.valPorcTeaSigv = valPorcTeaSigv;
    }

    public String getCanDiasVencPrimLetr() {
        return canDiasVencPrimLetr;
    }

    public void setCanDiasVencPrimLetr(String canDiasVencPrimLetr) {
        this.canDiasVencPrimLetr = canDiasVencPrimLetr;
    }

    public String getCanVehFin() {
        return canVehFin;
    }

    public void setCanVehFin(String canVehFin) {
        this.canVehFin = canVehFin;
    }

    public String getDesAreaVta() {
        return desAreaVta;
    }

    public void setDesAreaVta(String desAreaVta) {
        this.desAreaVta = desAreaVta;
    }

    public String getDesMarca() {
        return desMarca;
    }

    public void setDesMarca(String desMarca) {
        this.desMarca = desMarca;
    }

    public String getPrecTotal() {
        return precTotal;
    }

    public void setPrecTotal(String precTotal) {
        this.precTotal = precTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNroLetras() {
        return nroLetras;
    }

    public void setNroLetras(String nroLetras) {
        this.nroLetras = nroLetras;
    }

    public String getCodSociedad() {
        return codSociedad;
    }

    public void setCodSociedad(String codSociedad) {
        this.codSociedad = codSociedad;
    }

    public String getNomSociedad() {
        return nomSociedad;
    }

    public void setNomSociedad(String nomSociedad) {
        this.nomSociedad = nomSociedad;
    }

    public String getValAnoFab() {
        return valAnoFab;
    }

    public void setValAnoFab(String valAnoFab) {
        this.valAnoFab = valAnoFab;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getGpsDetalle() {
        return gpsDetalle;
    }

    public void setGpsDetalle(String gpsDetalle) {
        this.gpsDetalle = gpsDetalle;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getSeguroDetalle() {
        return seguroDetalle;
    }

    public void setSeguroDetalle(String seguroDetalle) {
        this.seguroDetalle = seguroDetalle;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getCodClasifSbsClie() {
        return codClasifSbsClie;
    }

    public void setCodClasifSbsClie(String codClasifSbsClie) {
        this.codClasifSbsClie = codClasifSbsClie;
    }

    public String getValDeudActuClie() {
        return valDeudActuClie;
    }

    public void setValDeudActuClie(String valDeudActuClie) {
        this.valDeudActuClie = valDeudActuClie;
    }

    public String getValDeudaDeta() {
        return valDeudaDeta;
    }

    public void setValDeudaDeta(String valDeudaDeta) {
        this.valDeudaDeta = valDeudaDeta;
    }

    public String getTxtInfoAdic() {
        return txtInfoAdic;
    }

    public void setTxtInfoAdic(String txtInfoAdic) {
        this.txtInfoAdic = txtInfoAdic;
    }

    public String getTxtInfoOper() {
        return txtInfoOper;
    }

    public void setTxtInfoOper(String txtInfoOper) {
        this.txtInfoOper = txtInfoOper;
    }

    public String getValAnio1() {
        return valAnio1;
    }

    public void setValAnio1(String valAnio1) {
        this.valAnio1 = valAnio1;
    }

    public String getValAnio2() {
        return valAnio2;
    }

    public void setValAnio2(String valAnio2) {
        this.valAnio2 = valAnio2;
    }

    public String getValMutuo() {
        return valMutuo;
    }

    public void setValMutuo(String valMutuo) {
        this.valMutuo = valMutuo;
    }

    public String getValDirecto() {
        return valDirecto;
    }

    public void setValDirecto(String valDirecto) {
        this.valDirecto = valDirecto;
    }

    public String getValMutuoDirecto() {
        return valMutuoDirecto;
    }

    public void setValMutuoDirecto(String valMutuoDirecto) {
        this.valMutuoDirecto = valMutuoDirecto;
    }

    public String getValGastAdmi() {
        return valGastAdmi;
    }

    public void setValGastAdmi(String valGastAdmi) {
        this.valGastAdmi = valGastAdmi;
    }

    public String getCodRespFina() {
        return codRespFina;
    }

    public void setCodRespFina(String codRespFina) {
        this.codRespFina = codRespFina;
    }

    public String getAnio1() {
        return anio1;
    }

    public void setAnio1(String anio1) {
        this.anio1 = anio1;
    }

    public String getAnio2() {
        return anio2;
    }

    public void setAnio2(String anio2) {
        this.anio2 = anio2;
    }

    public String getAnio3() {
        return anio3;
    }

    public void setAnio3(String anio3) {
        this.anio3 = anio3;
    }

    public String getAnio4() {
        return anio4;
    }

    public void setAnio4(String anio4) {
        this.anio4 = anio4;
    }

    public String getAnio5() {
        return anio5;
    }

    public void setAnio5(String anio5) {
        this.anio5 = anio5;
    }

    public String getAnio6() {
        return anio6;
    }

    public void setAnio6(String anio6) {
        this.anio6 = anio6;
    }

    public String getAnio7() {
        return anio7;
    }

    public void setAnio7(String anio7) {
        this.anio7 = anio7;
    }

    public String getAnio8() {
        return anio8;
    }

    public void setAnio8(String anio8) {
        this.anio8 = anio8;
    }

    public String getAnio9() {
        return anio9;
    }

    public void setAnio9(String anio9) {
        this.anio9 = anio9;
    }

    public String getAnio10() {
        return anio10;
    }

    public void setAnio10(String anio10) {
        this.anio10 = anio10;
    }

    public String getValCoberGara1() {
        return valCoberGara1;
    }

    public void setValCoberGara1(String valCoberGara1) {
        this.valCoberGara1 = valCoberGara1;
    }

    public String getValCoberGara2() {
        return valCoberGara2;
    }

    public void setValCoberGara2(String valCoberGara2) {
        this.valCoberGara2 = valCoberGara2;
    }

    public String getValCoberGara3() {
        return valCoberGara3;
    }

    public void setValCoberGara3(String valCoberGara3) {
        this.valCoberGara3 = valCoberGara3;
    }

    public String getValCoberGara4() {
        return valCoberGara4;
    }

    public void setValCoberGara4(String valCoberGara4) {
        this.valCoberGara4 = valCoberGara4;
    }

    public String getValCoberGara5() {
        return valCoberGara5;
    }

    public void setValCoberGara5(String valCoberGara5) {
        this.valCoberGara5 = valCoberGara5;
    }

    public String getValCoberGara6() {
        return valCoberGara6;
    }

    public void setValCoberGara6(String valCoberGara6) {
        this.valCoberGara6 = valCoberGara6;
    }

    public String getValCoberGara7() {
        return valCoberGara7;
    }

    public void setValCoberGara7(String valCoberGara7) {
        this.valCoberGara7 = valCoberGara7;
    }

    public String getValCoberGara8() {
        return valCoberGara8;
    }

    public void setValCoberGara8(String valCoberGara8) {
        this.valCoberGara8 = valCoberGara8;
    }

    public String getValCoberGara9() {
        return valCoberGara9;
    }

    public void setValCoberGara9(String valCoberGara9) {
        this.valCoberGara9 = valCoberGara9;
    }

    public String getValCoberGara10() {
        return valCoberGara10;
    }

    public void setValCoberGara10(String valCoberGara10) {
        this.valCoberGara10 = valCoberGara10;
    }

    public String getValRatioCober1() {
        return valRatioCober1;
    }

    public void setValRatioCober1(String valRatioCober1) {
        this.valRatioCober1 = valRatioCober1;
    }

    public String getValRatioCober2() {
        return valRatioCober2;
    }

    public void setValRatioCober2(String valRatioCober2) {
        this.valRatioCober2 = valRatioCober2;
    }

    public String getValRatioCober3() {
        return valRatioCober3;
    }

    public void setValRatioCober3(String valRatioCober3) {
        this.valRatioCober3 = valRatioCober3;
    }

    public String getValRatioCober4() {
        return valRatioCober4;
    }

    public void setValRatioCober4(String valRatioCober4) {
        this.valRatioCober4 = valRatioCober4;
    }

    public String getValRatioCober5() {
        return valRatioCober5;
    }

    public void setValRatioCober5(String valRatioCober5) {
        this.valRatioCober5 = valRatioCober5;
    }

    public String getValRatioCober6() {
        return valRatioCober6;
    }

    public void setValRatioCober6(String valRatioCober6) {
        this.valRatioCober6 = valRatioCober6;
    }

    public String getValRatioCober7() {
        return valRatioCober7;
    }

    public void setValRatioCober7(String valRatioCober7) {
        this.valRatioCober7 = valRatioCober7;
    }

    public String getValRatioCober8() {
        return valRatioCober8;
    }

    public void setValRatioCober8(String valRatioCober8) {
        this.valRatioCober8 = valRatioCober8;
    }

    public String getValRatioCober9() {
        return valRatioCober9;
    }

    public void setValRatioCober9(String valRatioCober9) {
        this.valRatioCober9 = valRatioCober9;
    }

    public String getValRatioCober10() {
        return valRatioCober10;
    }

    public void setValRatioCober10(String valRatioCober10) {
        this.valRatioCober10 = valRatioCober10;
    }

    public String getCanDiasFactCred() {
        return canDiasFactCred;
    }

    public void setCanDiasFactCred(String canDiasFactCred) {
        this.canDiasFactCred = canDiasFactCred;
    }

    public String getValLineaCredito() {
        return valLineaCredito;
    }

    public void setValLineaCredito(String valLineaCredito) {
        this.valLineaCredito = valLineaCredito;
    }
        
}
