/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.vistacliente;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Amortizacion;

/**
 *
 * @author ebarboza
 */
public class AmortizacionPorLetrtaOperacionesProcedure extends BasePaginadoProcedure<Amortizacion> {
    
    private String CodSociedad;
    private String CodRef1;
    private String NumRefer; 

    public String getCodSociedad() {
        return CodSociedad;
    }

    public void setCodSociedad(String CodSociedad) {
        this.CodSociedad = CodSociedad;
    }

    public String getCodRef1() {
        return CodRef1;
    }

    public void setCodRef1(String CodRef1) {
        this.CodRef1 = CodRef1;
    }

    public String getNumRefer() {
        return NumRefer;
    }

    public void setNumRefer(String NumRefer) {
        this.NumRefer = NumRefer;
    }
    
    
}
