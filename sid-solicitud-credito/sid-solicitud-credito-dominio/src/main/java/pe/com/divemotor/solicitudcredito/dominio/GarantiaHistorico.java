/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author egonzales
 */
public class GarantiaHistorico {
    /****Inicio vve_cred_maes_gara*****/
    private String codGarantia;
    private String indTipoGarantia;
    private String indTipoBien;
    private String idOtorgante;
    private String codPersProp;
    private String codMarca;
    private String txtModelo;
    private String codTipoVeh;
    private String nroMotor;
    private String txtCarroceria;
    private String fecFabConst;
    private String nroChasis;
    private String valNroRango;
    private String nroPlaca;
    private String codTipoActividad;
    private String valConstGar;
    private String valRealizGar;
    private String codOfRegistral;
    private String valAnosDeprec;
    private String codMoneda;
    private String desDescripcion;
    private String indAdicional;
    private String numTituloRpv;
    private String nroTarjPropVeh;
    private String nroPartida;
    private String indRegMobContratos;
    private String indRegJurBien;
    private String txtInfoModGar;
    private String indRatificaGar;
    private String valNvoMonto;
    private String valNvoVal;
    private String valMontOtorHip;
    private String txtDireccion;
    private String codDistrito;
    private String codProvincia;
    private String codDepartamento;
    private String codCliente;
    private String txtMarca;
    /****Fin vve_cred_maes_gara*****/
    private String codOperRel;
    private String tipoGarantiaDesc;
    private String valAnoFab;
    private boolean seleccionado;
    /*******************************/
    private String marca;
    private String rango;
    private String actividad;
    private String tipo;
    private String desPersProp;
    private String distrito;
    private String provincia;
    private String departamento;
    //DESCRIPCION CONSTITUCION GH	OTORGANTE	TIPO PERSONA	EST.CIVIL
    private String tipoBien;
    private String tipoOtorgante;
    private String tipoPersona;
    private String estadoCivil;
    private String indPreConstMob;
    private String indSegDive;
    private String valNroAsie;
    private String codTipoFamilia;

    public String getCodGarantia() {
        return codGarantia;
    }

    public void setCodGarantia(String codGarantia) {
        this.codGarantia = codGarantia;
    }

    public String getIndTipoGarantia() {
        return indTipoGarantia;
    }

    public void setIndTipoGarantia(String indTipoGarantia) {
        this.indTipoGarantia = indTipoGarantia;
    }

    public String getIndTipoBien() {
        return indTipoBien;
    }

    public void setIndTipoBien(String indTipoBien) {
        this.indTipoBien = indTipoBien;
    }

    public String getIdOtorgante() {
        return idOtorgante;
    }

    public void setIdOtorgante(String idOtorgante) {
        this.idOtorgante = idOtorgante;
    }


    public String getCodPersProp() {
        return codPersProp;
    }

    public void setCodPersProp(String codPersProp) {
        this.codPersProp = codPersProp;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(String txtModelo) {
        this.txtModelo = txtModelo;
    }

    public String getCodTipoVeh() {
        return codTipoVeh;
    }

    public void setCodTipoVeh(String codTipoVeh) {
        this.codTipoVeh = codTipoVeh;
    }

    public String getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(String nroMotor) {
        this.nroMotor = nroMotor;
    }

    public String getTxtCarroceria() {
        return txtCarroceria;
    }

    public void setTxtCarroceria(String txtCarroceria) {
        this.txtCarroceria = txtCarroceria;
    }

    public String getFecFabConst() {
        return fecFabConst;
    }

    public void setFecFabConst(String fecFabConst) {
        this.fecFabConst = fecFabConst;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getValNroRango() {
        return valNroRango;
    }

    public void setValNroRango(String valNroRango) {
        this.valNroRango = valNroRango;
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca = nroPlaca;
    }

    public String getCodTipoActividad() {
        return codTipoActividad;
    }

    public void setCodTipoActividad(String codTipoActividad) {
        this.codTipoActividad = codTipoActividad;
    }

    public String getValConstGar() {
        return valConstGar;
    }

    public void setValConstGar(String valConstGar) {
        this.valConstGar = valConstGar;
    }

    public String getValRealizGar() {
        return valRealizGar;
    }

    public void setValRealizGar(String valRealizGar) {
        this.valRealizGar = valRealizGar;
    }

    public String getCodOfRegistral() {
        return codOfRegistral;
    }

    public void setCodOfRegistral(String codOfRegistral) {
        this.codOfRegistral = codOfRegistral;
    }

    public String getValAnosDeprec() {
        return valAnosDeprec;
    }

    public void setValAnosDeprec(String valAnosDeprec) {
        this.valAnosDeprec = valAnosDeprec;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getDesDescripcion() {
        return desDescripcion;
    }

    public void setDesDescripcion(String desDescripcion) {
        this.desDescripcion = desDescripcion;
    }

    public String getIndAdicional() {
        return indAdicional;
    }

    public void setIndAdicional(String indAdicional) {
        this.indAdicional = indAdicional;
    }

    public String getNumTituloRpv() {
        return numTituloRpv;
    }

    public void setNumTituloRpv(String numTituloRpv) {
        this.numTituloRpv = numTituloRpv;
    }

    public String getNroTarjPropVeh() {
        return nroTarjPropVeh;
    }

    public void setNroTarjPropVeh(String nroTarjPropVeh) {
        this.nroTarjPropVeh = nroTarjPropVeh;
    }

    public String getNroPartida() {
        return nroPartida;
    }

    public void setNroPartida(String nroPartida) {
        this.nroPartida = nroPartida;
    }

    public String getIndRegMobContratos() {
        return indRegMobContratos;
    }

    public void setIndRegMobContratos(String indRegMobContratos) {
        this.indRegMobContratos = indRegMobContratos;
    }

    public String getIndRegJurBien() {
        return indRegJurBien;
    }

    public void setIndRegJurBien(String indRegJurBien) {
        this.indRegJurBien = indRegJurBien;
    }

    public String getTxtInfoModGar() {
        return txtInfoModGar;
    }

    public void setTxtInfoModGar(String txtInfoModGar) {
        this.txtInfoModGar = txtInfoModGar;
    }

    public String getIndRatificaGar() {
        return indRatificaGar;
    }

    public void setIndRatificaGar(String indRatificaGar) {
        this.indRatificaGar = indRatificaGar;
    }

    public String getValNvoMonto() {
        return valNvoMonto;
    }

    public void setValNvoMonto(String valNvoMonto) {
        this.valNvoMonto = valNvoMonto;
    }

    public String getValNvoVal() {
        return valNvoVal;
    }

    public void setValNvoVal(String valNvoVal) {
        this.valNvoVal = valNvoVal;
    }

    public String getValMontOtorHip() {
        return valMontOtorHip;
    }

    public void setValMontOtorHip(String valMontOtorHip) {
        this.valMontOtorHip = valMontOtorHip;
    }

    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(String txtMarca) {
        this.txtMarca = txtMarca;
    }

    
    /****Fin vve_cred_maes_gara*****/
    public String getCodOperRel() {
        return codOperRel;
    }

    public void setCodOperRel(String codOperRel) {
        this.codOperRel = codOperRel;
    }

    public String getTipoGarantiaDesc() {
        return tipoGarantiaDesc;
    }

    public void setTipoGarantiaDesc(String tipoGarantiaDesc) {
        this.tipoGarantiaDesc = tipoGarantiaDesc;
    }

    public String getValAnoFab() {
        return valAnoFab;
    }

    public void setValAnoFab(String valAnoFab) {
        this.valAnoFab = valAnoFab;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesPersProp() {
        return desPersProp;
    }

    public void setDesPersProp(String desPersProp) {
        this.desPersProp = desPersProp;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getTipoOtorgante() {
        return tipoOtorgante;
    }

    public void setTipoOtorgante(String tipoOtorgante) {
        this.tipoOtorgante = tipoOtorgante;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getIndPreConstMob() {
        return indPreConstMob;
    }

    public void setIndPreConstMob(String indPreConstMob) {
        this.indPreConstMob = indPreConstMob;
    }

    public String getIndSegDive() {
        return indSegDive;
    }

    public void setIndSegDive(String indSegDive) {
        this.indSegDive = indSegDive;
    }

    public String getValNroAsie() {
        return valNroAsie;
    }

    public void setValNroAsie(String valNroAsie) {
        this.valNroAsie = valNroAsie;
    }
    
    // REQ. OBS REG GARANTIA MBARDALES
    public String getCodTipoFamilia() {
        return codTipoFamilia;
    }

    public void setCodTipoFamilia(String codTipoFamilia) {
        this.codTipoFamilia = codTipoFamilia;
    }
    
  
}
