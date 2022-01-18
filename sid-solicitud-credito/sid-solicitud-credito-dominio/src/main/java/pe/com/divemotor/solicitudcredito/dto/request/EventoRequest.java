package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;

public class EventoRequest extends BaseRequest {

    private Integer codItemEvenRefe;
    private String codSoliCred;
    private String txtAsun;
    private String txtComen;
    private List<String> listDestinatarios;

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

    public List<String> getListDestinatarios() {
        return listDestinatarios;
    }

    public void setListDestinatarios(List<String> listDestinatarios) {
        this.listDestinatarios = listDestinatarios;
    }

}
