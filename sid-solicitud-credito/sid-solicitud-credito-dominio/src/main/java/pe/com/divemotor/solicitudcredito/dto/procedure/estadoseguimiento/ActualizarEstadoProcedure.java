package pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento;

import pe.com.divemotor.generico.dto.BaseProcedure;

public class ActualizarEstadoProcedure extends BaseProcedure {

    private String codigoSolicitud;
    private String codigoEstado;

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

}
