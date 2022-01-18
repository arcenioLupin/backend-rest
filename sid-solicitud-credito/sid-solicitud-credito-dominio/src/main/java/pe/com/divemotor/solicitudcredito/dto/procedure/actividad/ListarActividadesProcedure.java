package pe.com.divemotor.solicitudcredito.dto.procedure.actividad;

import java.util.Date;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.*;
import pe.com.divemotor.solicitudcredito.dominio.EstadoSeguimiento;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Actividad;
import pe.com.divemotor.solicitudcredito.dominio.Documento;

public class ListarActividadesProcedure extends BasePaginadoProcedure<Actividad> {
    private String codSoliCred;   
    private Integer retCantidad;
    private String actActual;
    private String actSiguiente;
    
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

    public String getActActual() {
        return actActual;
    }

    public void setActActual(String actActual) {
        this.actActual = actActual;
    }

    public String getActSiguiente() {
        return actSiguiente;
    }

    public void setActSiguiente(String actSiguiente) {
        this.actSiguiente = actSiguiente;
    }
    
    
}
