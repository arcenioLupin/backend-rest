/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author 90690 ivelasquez 21/09/2021
 */
public class DatosAprobacion {
    
    private String codAprob;
    private String nivAprob;
    private String usuAprob;
    private String desAprob;
    private String fecAprob;
    private String comentario;
    private String codCritApro;
    public String getCodAprob() {
        return codAprob;
    }

    public void setCodAprob(String codAprob) {
        this.codAprob = codAprob;
    }

    public String getNivAprob() {
        return nivAprob;
    }

    public void setNivAprob(String nivAprob) {
        this.nivAprob = nivAprob;
    }

    public String getUsuAprob() {
        return usuAprob;
    }

    public void setUsuAprob(String usuAprob) {
        this.usuAprob = usuAprob;
    }

    public String getDesAprob() {
        return desAprob;
    }

    public void setDesAprob(String desAprob) {
        this.desAprob = desAprob;
    }

    public String getFecAprob() {
        return fecAprob;
    }

    public void setFecAprob(String fecAprob) {
        this.fecAprob = fecAprob;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the codCritApro
     */
    public String getCodCritApro() {
        return codCritApro;
    }

    /**
     * @param codCritApro the codCritApro to set
     */
    public void setCodCritApro(String codCritApro) {
        this.codCritApro = codCritApro;
    }
    
}
