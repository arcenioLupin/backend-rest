package pe.com.divemotor.solicitudcredito.dominio;
//EGH

import java.util.Date;

public class Evento {

    private Integer codItemEvenRefe;
    private String codSoliCred;
    private String txtAsun;
    private String txtComen;
    private Integer retCodItemEven;
    private String notificados; 
    private Date fecItemEven;
    private String codUsuario;

    public Integer getCodItemEvenRefe() {
        return codItemEvenRefe;
    }

    public void setCodItemEvenRefe(Integer codItemEvenRefe) {
        this.codItemEvenRefe = codItemEvenRefe;
    }

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getTxtAsun() {
        return txtAsun;
    }

    public void setTxtAsun(String txtAsun) {
        this.txtAsun = txtAsun;
    }

    public String getTxtComen() {
        return txtComen;
    }

    public void setTxtComen(String txtComen) {
        this.txtComen = txtComen;
    }

    public Integer getRetCodItemEven() {
        return retCodItemEven;
    }

    public void setRetCodItemEven(Integer retCodItemEven) {
        this.retCodItemEven = retCodItemEven;
    }

    public String getNotificados() {
        return notificados;
    }

    public void setNotificados(String notificados) {
        this.notificados = notificados;
    }

    public Date getFecItemEven() {
        return fecItemEven;
    }

    public void setFecItemEven(Date fecItemEven) {
        this.fecItemEven = fecItemEven;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    
    
     
}
