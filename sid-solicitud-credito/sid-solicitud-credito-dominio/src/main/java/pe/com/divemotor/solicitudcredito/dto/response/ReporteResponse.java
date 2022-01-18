/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.com.divemotor.generico.dto.BaseResponse;

/**
 *
 * @author phramirez
 */
public class ReporteResponse extends BaseResponse {

    private String reporte;

    @JsonIgnore
    private byte[] reporteBytes;

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public byte[] getReporteBytes() {
        return reporteBytes;
    }

    public void setReporteBytes(byte[] reporteBytes) {
        this.reporteBytes = reporteBytes;
    }

}
