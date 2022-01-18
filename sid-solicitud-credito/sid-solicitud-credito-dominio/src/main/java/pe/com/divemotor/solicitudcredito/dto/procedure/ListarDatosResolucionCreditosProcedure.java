/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.DatosResolucionCreditos;

/**
 *
 * @author legutierrez
 */
public class ListarDatosResolucionCreditosProcedure extends BasePaginadoProcedure<DatosResolucionCreditos> {

    private String codSoliCred;
    private String fecVencPrimLet;
    private String fecAproClie;
    private String txtInfoAdic;
    private String txtInfoOper;
    private String fechaContrato;
    private String plazoFacCredito;
     private Double montoFinanciar;/**Req. 87567 E2.1 ID: 309 - avilca 24/03/2020 **/

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getFecVencPrimLet() {
        return fecVencPrimLet;
    }

    public void setFecVencPrimLet(String fecVencPrimLet) {
        this.fecVencPrimLet = fecVencPrimLet;
    }

    public String getFecAproClie() {
        return fecAproClie;
    }

    public void setFecAproClie(String fecAproClie) {
        this.fecAproClie = fecAproClie;
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

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getPlazoFacCredito() {
        return plazoFacCredito;
    }

    public void setPlazoFacCredito(String plazoFacCredito) {
        this.plazoFacCredito = plazoFacCredito;
    }

    public Double getMontoFinanciar() {
        return montoFinanciar;
    }

    public void setMontoFinanciar(Double montoFinanciar) {
        this.montoFinanciar = montoFinanciar;
    }


}
