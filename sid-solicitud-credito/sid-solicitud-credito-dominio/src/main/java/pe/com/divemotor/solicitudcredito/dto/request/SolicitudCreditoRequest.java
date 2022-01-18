package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

public class SolicitudCreditoRequest extends BaseRequest {

    private String codClie;
    private String tipSoliCred;
    private String codMoneda;
    private String codBanco;
    private String estado;
    private double valMonFin;
    private int canPlazMes;
    private String txtObseCrea;
    private String codResFina;
    private String numTelfMovil;
    private String numTeleFijoEjec;
    private String codSucursal;
    private String codFilial;
    private String codAreaVenta;
    private String codVendedor;
    private String codZona;
    private String dirCorreo;
    private String numProfVeh;
    private double valVtaProf;
    private String flagRegistro;
    private String compania;
    private String venFactura; /** Req. 87567 E2.1 ID: 309 - avilca 25/03/2020 **/

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getTipSoliCred() {
        return tipSoliCred;
    }

    public void setTipSoliCred(String tipSoliCred) {
        this.tipSoliCred = tipSoliCred;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValMonFin() {
        return valMonFin;
    }

    public void setValMonFin(double valMonFin) {
        this.valMonFin = valMonFin;
    }

    public int getCanPlazMes() {
        return canPlazMes;
    }

    public void setCanPlazMes(int canPlazMes) {
        this.canPlazMes = canPlazMes;
    }

    public String getTxtObseCrea() {
        return txtObseCrea;
    }

    public void setTxtObseCrea(String txtObseCrea) {
        this.txtObseCrea = txtObseCrea;
    }

    public String getCodResFina() {
        return codResFina;
    }

    public void setCodResFina(String codResFina) {
        this.codResFina = codResFina;
    }

    public String getNumTelfMovil() {
        return numTelfMovil;
    }

    public void setNumTelfMovil(String numTelfMovil) {
        this.numTelfMovil = numTelfMovil;
    }

    public String getNumTeleFijoEjec() {
        return numTeleFijoEjec;
    }

    public void setNumTeleFijoEjec(String numTeleFijoEjec) {
        this.numTeleFijoEjec = numTeleFijoEjec;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCodAreaVenta() {
        return codAreaVenta;
    }

    public void setCodAreaVenta(String codAreaVenta) {
        this.codAreaVenta = codAreaVenta;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getDirCorreo() {
        return dirCorreo;
    }

    public void setDirCorreo(String dirCorreo) {
        this.dirCorreo = dirCorreo;
    }

    public String getNumProfVeh() {
        return numProfVeh;
    }

    public void setNumProfVeh(String numProfVeh) {
        this.numProfVeh = numProfVeh;
    }

    public double getValVtaProf() {
        return valVtaProf;
    }

    public void setValVtaProf(double valVtaProf) {
        this.valVtaProf = valVtaProf;
    }

    public String getFlagRegistro() {
        return flagRegistro;
    }

    public void setFlagRegistro(String flagRegistro) {
        this.flagRegistro = flagRegistro;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
/** I Req. 87567 E2.1 ID: 309 - avilca 25/03/2020 **/
    public String getVenFactura() {
        return venFactura;
    }

    public void setVenFactura(String venFactura) {
        this.venFactura = venFactura;
    }
/** F Req. 87567 E2.1 ID: 309 - avilca 25/03/2020 **/
    
}
