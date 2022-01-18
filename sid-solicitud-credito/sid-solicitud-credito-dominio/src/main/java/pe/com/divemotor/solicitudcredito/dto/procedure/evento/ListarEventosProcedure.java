package pe.com.divemotor.solicitudcredito.dto.procedure.evento;

import java.util.Date;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.*;
import pe.com.divemotor.solicitudcredito.dominio.EstadoSeguimiento;
import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Evento;

public class ListarEventosProcedure extends BasePaginadoProcedure<Evento> {
    private String codSoliCred;
    private String fecItemEvenIni;
    private String fecItemEvenFin;
    private Integer codUsuaSid;
    private String codUsuaWeb;       
    private Integer retCantidad;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getFecItemEvenIni() {
        return fecItemEvenIni;
    }

    public void setFecItemEvenIni(String fecItemEvenIni) {
        this.fecItemEvenIni = fecItemEvenIni;
    }

    public String getFecItemEvenFin() {
        return fecItemEvenFin;
    }

    public void setFecItemEvenFin(String fecItemEvenFin) {
        this.fecItemEvenFin = fecItemEvenFin;
    }

    
    
    public Integer getCodUsuaSid() {
        return codUsuaSid;
    }

    public void setCodUsuaSid(Integer codUsuaSid) {
        this.codUsuaSid = codUsuaSid;
    }

    public String getCodUsuaWeb() {
        return codUsuaWeb;
    }

    public void setCodUsuaWeb(String codUsuaWeb) {
        this.codUsuaWeb = codUsuaWeb;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }
    
    
}
