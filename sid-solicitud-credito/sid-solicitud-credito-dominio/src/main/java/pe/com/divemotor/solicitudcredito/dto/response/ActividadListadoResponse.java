package pe.com.divemotor.solicitudcredito.dto.response;

import pe.com.divemotor.solicitudcredito.dominio.Actividad;
import pe.com.divemotor.generico.dto.ListadoResponse;

public class ActividadListadoResponse extends ListadoResponse<Actividad>{
    private String actActual;
    private String actSiguiente;

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
