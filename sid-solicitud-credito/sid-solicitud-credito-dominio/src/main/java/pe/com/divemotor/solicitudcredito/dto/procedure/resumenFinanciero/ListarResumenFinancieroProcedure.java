package pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero;

import java.util.Date;
import java.util.List;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.ResumenFinanciero;
import pe.com.divemotor.solicitudcredito.dominio.ResumenFinancieroMaturity;

public class ListarResumenFinancieroProcedure extends BasePaginadoProcedure<ResumenFinanciero> {
    private String codSoliCred;   
    private String codcliente;
    private String fecSolicitudUltima;
    private String anioSup;
    private String anioInf;
    private List<ResumenFinancieroMaturity> busquedaMat;
    
    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public String getFecSolicitudUltima() {
        return fecSolicitudUltima;
    }

    public void setFecSolicitudUltima(String fecSolicitudUltima) {
        this.fecSolicitudUltima = fecSolicitudUltima;
    }

    public String getAnioSup() {
        return anioSup;
    }

    public void setAnioSup(String anioSup) {
        this.anioSup = anioSup;
    }

    public String getAnioInf() {
        return anioInf;
    }

    public void setAnioInf(String anioInf) {
        this.anioInf = anioInf;
    }

    public List<ResumenFinancieroMaturity> getBusquedaMat() {
        return busquedaMat;
    }

    public void setBusquedaMat(List<ResumenFinancieroMaturity> busquedaMat) {
        this.busquedaMat = busquedaMat;
    }

    
    
    
}
