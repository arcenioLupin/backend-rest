package pe.com.divemotor.solicitudcredito.dto.base;

import java.io.Serializable;

public class GenericoDTO implements Serializable {

    private String estadoTrama;
    private String mensaje; 
  
    public String getEstadoTrama() {
        return estadoTrama;
    }

    public void setEstadoTrama(String estadoTrama) {
        this.estadoTrama = estadoTrama;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
