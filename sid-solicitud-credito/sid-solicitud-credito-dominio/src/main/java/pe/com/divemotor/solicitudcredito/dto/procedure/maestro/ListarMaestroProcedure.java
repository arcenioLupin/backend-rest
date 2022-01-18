package pe.com.divemotor.solicitudcredito.dto.procedure.maestro;

import pe.com.divemotor.generico.dto.BasePaginadoProcedure;
import pe.com.divemotor.solicitudcredito.dominio.Maestro;

public class ListarMaestroProcedure extends BasePaginadoProcedure<Maestro> {
    private String tipo;
    private Integer retCantidad;
    private String codDepa; // Req. Obs Consulta cliente MBardales 15/10/2020
    private String codProv; // Req. Obs Consulta cliente MBardales 15/10/2020
    private String codDist; // Req. Obs Consulta cliente MBardales 15/10/2020

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getRetCantidad() {
        return retCantidad;
    }

    public void setRetCantidad(Integer retCantidad) {
        this.retCantidad = retCantidad;
    }

    /**
     * @return the codDepa
     */
    public String getCodDepa() {
        return codDepa;
    }

    /**
     * @param codDepa the codDepa to set
     */
    public void setCodDepa(String codDepa) {
        this.codDepa = codDepa;
    }

    /**
     * @return the codProv
     */
    public String getCodProv() {
        return codProv;
    }

    /**
     * @param codProv the codProv to set
     */
    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    /**
     * @return the codDist
     */
    public String getCodDist() {
        return codDist;
    }

    /**
     * @param codDist the codDist to set
     */
    public void setCodDist(String codDist) {
        this.codDist = codDist;
    }
    
    
    
}
