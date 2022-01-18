package pe.com.divemotor.solicitudcredito.dto.procedure.reporteCreditos;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ReporteCredito;

public class ListarReporteCreditosProcedure extends BasePaginadoProcedure<ReporteCredito> {
    private String tipCred;
    private String areaVta;
    private String zona;
    private String fechIni;
    private String fechFin;
    private Integer retCantidad;

    public String getTipCred() {
        return tipCred;
    }

    public void setTipCred(String tipCred) {
        this.tipCred = tipCred;
    }

    public String getAreaVta() {
        return areaVta;
    }

    public void setAreaVta(String areaVta) {
        this.areaVta = areaVta;
    }

    

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getFechIni() {
        return fechIni;
    }

    public void setFechIni(String fechIni) {
        this.fechIni = fechIni;
    }

    public String getFechFin() {
        return fechFin;
    }

    public void setFechFin(String fechFin) {
        this.fechFin = fechFin;
    }
    
    
    
    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

}
