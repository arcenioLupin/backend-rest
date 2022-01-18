package pe.com.divemotor.solicitudcredito.dto.procedure.evento;
//EGH

import pe.com.divemotor.generico.dto.BaseProcedure;

public class InsertarCreditoEventoProcedure extends BaseProcedure {

    private Integer codItemEvenRefe;
    private String codSoliCred;
    private String txtAsun;
    private String txtComen;
    private String listCodUsu;
    private Integer codItemEven;

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

    public String getListCodUsu() {
        return listCodUsu;
    }

    public void setListCodUsu(String listCodUsu) {
        this.listCodUsu = listCodUsu;
    }

    public String getTxtComen() {
        return txtComen;
    }

    public void setTxtComen(String txtComen) {
        this.txtComen = txtComen;
    }

    public Integer getCodItemEven() {
        return codItemEven;
    }

    public void setCodItemEven(Integer codItemEven) {
        this.codItemEven = codItemEven;
    }

}
