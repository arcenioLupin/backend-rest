/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.procedure.legal;

import pe.com.divemotor.generico.dto.BaseProcedure;

/**
 *
 * @author USER
 */
public class RegistrarPersonaFacultadaProcedure extends BaseProcedure{
    
    private String codSolcre;
    private int codFdorev;
    private int codFdorevOut;
    private int codDocrev;
    private int codDocrevOut;
    private String cargo;
    private String nombre;
    private String doi;

    /**
     * @return the codFdorev
     */
    public int getCodFdorev() {
        return codFdorev;
    }

    /**
     * @param codFdorev the codFdorev to set
     */
    public void setCodFdorev(int codFdorev) {
        this.codFdorev = codFdorev;
    }

   
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the codSolcre
     */
    public String getCodSolcre() {
        return codSolcre;
    }

    /**
     * @param codSolcre the codSolcre to set
     */
    public void setCodSolcre(String codSolcre) {
        this.codSolcre = codSolcre;
    }

    public int getCodFdorevOut() {
        return codFdorevOut;
    }

    public void setCodFdorevOut(int codFdorevOut) {
        this.codFdorevOut = codFdorevOut;
    }

    public int getCodDocrevOut() {
        return codDocrevOut;
    }

    public void setCodDocrevOut(int codDocrevOut) {
        this.codDocrevOut = codDocrevOut;
    }

    public int getCodDocrev() {
        return codDocrev;
    }

    public void setCodDocrev(int codDocrev) {
        this.codDocrev = codDocrev;
    }
    
    
}
