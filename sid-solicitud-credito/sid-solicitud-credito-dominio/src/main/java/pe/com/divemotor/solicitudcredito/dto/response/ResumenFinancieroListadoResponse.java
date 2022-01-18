package pe.com.divemotor.solicitudcredito.dto.response;

import java.util.Date;
import java.util.List;
import pe.com.divemotor.generico.dto.ListadoResponse;
import pe.com.divemotor.solicitudcredito.dominio.ResumenFinanciero;
import pe.com.divemotor.solicitudcredito.dominio.ResumenFinancieroMaturity;

public class ResumenFinancieroListadoResponse extends ListadoResponse<ResumenFinanciero>{
    private String fecSolicitudUltima;
    private List<ResumenFinancieroMaturity> resumenFinancieroMaturity;

    public String getFecSolicitudUltima() {
        return fecSolicitudUltima;
    }

    public void setFecSolicitudUltima(String fecSolicitudUltima) {
        this.fecSolicitudUltima = fecSolicitudUltima;
    }

    public List<ResumenFinancieroMaturity> getResumenFinancieroMaturity() {
        return resumenFinancieroMaturity;
    }

    public void setResumenFinancieroMaturity(List<ResumenFinancieroMaturity> resumenFinancieroMaturity) {
        this.resumenFinancieroMaturity = resumenFinancieroMaturity;
    }

    
}
