/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dominio;

/**
 *
 * @author legutierrez
 */
public class SolicitudCreditoParam {

    private String codSoliCred;
    private String codParamFC;
    private double reunionPromIngDia;
    private double reunionPonderado;
    private double reunionTotalDiario;
    private double ruteoPromIngDia;
    private double ruteoPonderado;
    private double ruteoTotalDiario;
    private double encuestaPromIngDia;
    private double encuestaPonderado;
    private double encuestaTotalDiario;
    private double promIngDiario;
    private double promIngMes;
    private double promIngAnual;
    private double sensibilizacion;
    private double ventas;
    private double variacionVtas;
    private double cambioAceiteCostoProm;
    private double llantasCostoProm;
    private double frenosPastillasFajasCostoProm;
    private double pinturaCostoProm;
    private double reparacionesMotorCostoProm;
    private double adicionalesCostoProm;
    private double cambioAceiteFrecProm;
    private double llantasFrecProm;
    private double frenosPastillasFajasFrecProm;
    private double pinturaFrecProm;
    private double reparacionesMotorFrecProm;
    private double adicionalesFrecProm;
    private String codTipoFrecCambAcei;
    private String codTipoFrecLlant;
    private String codTipoFrecFren;
    private String codTipoFrecPint;
    private String codTipoFrecRep;
    private String codTipoFrecAdic;
    private double cambioAceiteCostoPromAnual;
    private double llantasCostoPromAnual;
    private double frenosPastillasFajasCostoPromAnual;
    private double pinturaCostoPromAnual;
    private double reparacionesMotorCostoPromAnual;
    private double adicionalesCostoPromAnual;
    private double soatAfocatCostoProm;
    private double revisionTecinaCostoProm;
    private double tarjetaCirculacionCostoProm;
    private double soatAfocatFrecProm;
    private double revisionTecnicaFrecProm;
    private double tarjetaCirculacionFrecProm;
    private String codTipoFrecSoat;
    private String codTipoFrecRevTec;
    private String codTipoFrecTarjCirc;
    private double soatAfocatCostoPromAnual;
    private double revisionTecinaCostoPromAnual;
    private double tarjetaCirculacionCostoPromAnual;
    private double remChofCostoVtaDiario;
    private double remCobrCostoVtaDiario;
    private double combustCostoVtaDiario;
    private double cochCostoVtaDiario;
    private double viaticCostoVtaDiario;
    private double impstosCostoVtaDiario;
    private double remChofVtaAnual;
    private double remCobrCostoVtaAnual;
    private double combustCostoVtaAnual;
    private double cochCostoVtaAnual;
    private double viaticCostoVtaAnual;
    private double impstosCostoVtaAnual;
    private double costoVenta;
    private double gastosAdministrativos;
    private double gastosVentas;
    private double kilometrosRecorridos;
    private double cantidadFiltroAceite;
    private double cantidadFiltroAire;
    private double cantidadFiltroPetroleo;
    private double cantidadAceiteMotor;
    private double cantidadAceiteCaja;
    private double cantidadAceiteCorona;
    private double cantidadFiltroSeparador;
    private double cantidadHidrolina;
    private double cantidadFiltroHidrolina;
    private double cantidadGrasaMP;
    private double cantidadConjuntoCompleto;
    private double cantidadBombinBomba;
    private double cantidadDelantero;
    private double cantidadPosterior;
    private double cantidadFajaVentilador;
    private double cantidadBombaAgua;
    private double cantidadLlantasx6_1;
    private double cantidadRodajesx8;
    private double cantidadBateria;
    private double cantidadAmortiguadores;
    private double kilometrajeFiltroAceite;
    private double kilometrajeFiltroAire;
    private double kilometrajeFiltroPetroleo;
    private double kilometrajeAceiteMotor;
    private double kilometrajeAceiteCaja;
    private double kilometrajeAceiteCorona;
    private double kilometrajeFiltroSeparador;
    private double kilometrajeHidrolina;
    private double kilometrajeFiltroHidrolina;
    private double kilometrajeGrasaMP;
    private double kilometrajeConjuntoCompleto;
    private double kilometrajeBombinBomba;
    private double kilometrajeDelantero;
    private double kilometrajePosterior;
    private double kilometrajeFajaVentilador;
    private double kilometrajeBombaAgua;
    private double kilometrajeLlantasx6_1;
    private double kilometrajeRodajesx8;
    private double kilometrajeBateria;
    private double kilometrajeAmortiguadores;
    private double costoUnitFiltroAceite;
    private double costoUnitFiltroAire;
    private double costoUnitFiltroPetroleo;
    private double costoUnitAceiteMotor;
    private double costoUnitAceiteCaja;
    private double costoUnitAceiteCorona;
    private double costoUnitFiltroSeparador;
    private double costoUnitHidrolina;
    private double costoUnitFiltroHidrolina;
    private double costoUnitGrasaMP;
    private double costoUnitConjuntoCompleto;
    private double costoUnitBombinBomba;
    private double costoUnitDelantero;
    private double costoUnitPosterior;
    private double costoUnitFajaVentilador;
    private double costoUnitBombaAgua;
    private double costoUnitLlantasx6_1;
    private double costoUnitRodajesx8;
    private double costoUnitBateria;
    private double costoUnitAmortiguadores;
    private double costoKmFiltroAceite;
    private double costoKmFiltroAire;
    private double costoKmFiltroPetroleo;
    private double costoKmAceiteMotor;
    private double costoKmAceiteCaja;
    private double costoKmAceiteCorona;
    private double costoKmFiltroSeparador;
    private double costoKmHidrolina;
    private double costoKmFiltroHidrolina;
    private double costoKmGrasaMP;
    private double costoKmConjuntoCompleto;
    private double costoKmBombinBomba;
    private double costoKmDelantero;
    private double costoKmPosterior;
    private double costoKmFajaVentilador;
    private double costoKmBombaAgua;
    private double costoKmLlantasx6_1;
    private double costoKmRodajesx8;
    private double costoKmBateria;
    private double costoKmAmortiguadores;
    private double costoSolesKm;
    private double costoSolesUnidxDia;
    private double costoSolesUnidMes;
    private double cargaReunion;
    private double cargaContrato;
    private double cargaEncuesta;
    private double nroViajesMesReunion;
    private double nroViajesMesContrato;
    private double nroViajesMesEncuesta;
    private double tarifaReunion;
    private double tarifaContrato;
    private double tarifaEncuesta;
    private double promMesReunion;
    private double promMesContrato;
    private double promMesEncuesta;
    private double ponderacionReunion;
    private double ponderacionContrato;
    private double ponderacionEncuesta;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodParamFC() {
        return codParamFC;
    }

    public void setCodParamFC(String codParamFC) {
        this.codParamFC = codParamFC;
    }

    public double getReunionPromIngDia() {
        return reunionPromIngDia;
    }

    public void setReunionPromIngDia(double reunionPromIngDia) {
        this.reunionPromIngDia = reunionPromIngDia;
    }

    public double getReunionPonderado() {
        return reunionPonderado;
    }

    public void setReunionPonderado(double reunionPonderado) {
        this.reunionPonderado = reunionPonderado;
    }

    public double getReunionTotalDiario() {
        return reunionTotalDiario;
    }

    public void setReunionTotalDiario(double reunionTotalDiario) {
        this.reunionTotalDiario = reunionTotalDiario;
    }

    public double getRuteoPromIngDia() {
        return ruteoPromIngDia;
    }

    public void setRuteoPromIngDia(double ruteoPromIngDia) {
        this.ruteoPromIngDia = ruteoPromIngDia;
    }

    public double getRuteoPonderado() {
        return ruteoPonderado;
    }

    public void setRuteoPonderado(double ruteoPonderado) {
        this.ruteoPonderado = ruteoPonderado;
    }

    public double getRuteoTotalDiario() {
        return ruteoTotalDiario;
    }

    public void setRuteoTotalDiario(double ruteoTotalDiario) {
        this.ruteoTotalDiario = ruteoTotalDiario;
    }

    public double getEncuestaPromIngDia() {
        return encuestaPromIngDia;
    }

    public void setEncuestaPromIngDia(double encuestaPromIngDia) {
        this.encuestaPromIngDia = encuestaPromIngDia;
    }

    public double getEncuestaPonderado() {
        return encuestaPonderado;
    }

    public void setEncuestaPonderado(double encuestaPonderado) {
        this.encuestaPonderado = encuestaPonderado;
    }

    public double getEncuestaTotalDiario() {
        return encuestaTotalDiario;
    }

    public void setEncuestaTotalDiario(double encuestaTotalDiario) {
        this.encuestaTotalDiario = encuestaTotalDiario;
    }

    public double getPromIngDiario() {
        return promIngDiario;
    }

    public void setPromIngDiario(double promIngDiario) {
        this.promIngDiario = promIngDiario;
    }

    public double getPromIngMes() {
        return promIngMes;
    }

    public void setPromIngMes(double promIngMes) {
        this.promIngMes = promIngMes;
    }

    public double getPromIngAnual() {
        return promIngAnual;
    }

    public void setPromIngAnual(double promIngAnual) {
        this.promIngAnual = promIngAnual;
    }

    public double getSensibilizacion() {
        return sensibilizacion;
    }

    public void setSensibilizacion(double sensibilizacion) {
        this.sensibilizacion = sensibilizacion;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getVariacionVtas() {
        return variacionVtas;
    }

    public void setVariacionVtas(double variacionVtas) {
        this.variacionVtas = variacionVtas;
    }

    public double getCambioAceiteCostoProm() {
        return cambioAceiteCostoProm;
    }

    public void setCambioAceiteCostoProm(double cambioAceiteCostoProm) {
        this.cambioAceiteCostoProm = cambioAceiteCostoProm;
    }

    public double getLlantasCostoProm() {
        return llantasCostoProm;
    }

    public void setLlantasCostoProm(double llantasCostoProm) {
        this.llantasCostoProm = llantasCostoProm;
    }

    public double getFrenosPastillasFajasCostoProm() {
        return frenosPastillasFajasCostoProm;
    }

    public void setFrenosPastillasFajasCostoProm(double frenosPastillasFajasCostoProm) {
        this.frenosPastillasFajasCostoProm = frenosPastillasFajasCostoProm;
    }

    public double getPinturaCostoProm() {
        return pinturaCostoProm;
    }

    public void setPinturaCostoProm(double pinturaCostoProm) {
        this.pinturaCostoProm = pinturaCostoProm;
    }

    public double getReparacionesMotorCostoProm() {
        return reparacionesMotorCostoProm;
    }

    public void setReparacionesMotorCostoProm(double reparacionesMotorCostoProm) {
        this.reparacionesMotorCostoProm = reparacionesMotorCostoProm;
    }

    public double getAdicionalesCostoProm() {
        return adicionalesCostoProm;
    }

    public void setAdicionalesCostoProm(double adicionalesCostoProm) {
        this.adicionalesCostoProm = adicionalesCostoProm;
    }

    public double getCambioAceiteFrecProm() {
        return cambioAceiteFrecProm;
    }

    public void setCambioAceiteFrecProm(double cambioAceiteFrecProm) {
        this.cambioAceiteFrecProm = cambioAceiteFrecProm;
    }

    public double getLlantasFrecProm() {
        return llantasFrecProm;
    }

    public void setLlantasFrecProm(double llantasFrecProm) {
        this.llantasFrecProm = llantasFrecProm;
    }

    public double getFrenosPastillasFajasFrecProm() {
        return frenosPastillasFajasFrecProm;
    }

    public void setFrenosPastillasFajasFrecProm(double frenosPastillasFajasFrecProm) {
        this.frenosPastillasFajasFrecProm = frenosPastillasFajasFrecProm;
    }

    public double getPinturaFrecProm() {
        return pinturaFrecProm;
    }

    public void setPinturaFrecProm(double pinturaFrecProm) {
        this.pinturaFrecProm = pinturaFrecProm;
    }

    public double getReparacionesMotorFrecProm() {
        return reparacionesMotorFrecProm;
    }

    public void setReparacionesMotorFrecProm(double reparacionesMotorFrecProm) {
        this.reparacionesMotorFrecProm = reparacionesMotorFrecProm;
    }

    public double getAdicionalesFrecProm() {
        return adicionalesFrecProm;
    }

    public void setAdicionalesFrecProm(double adicionalesFrecProm) {
        this.adicionalesFrecProm = adicionalesFrecProm;
    }

    public String getCodTipoFrecCambAcei() {
        return codTipoFrecCambAcei;
    }

    public void setCodTipoFrecCambAcei(String codTipoFrecCambAcei) {
        this.codTipoFrecCambAcei = codTipoFrecCambAcei;
    }

    public String getCodTipoFrecLlant() {
        return codTipoFrecLlant;
    }

    public void setCodTipoFrecLlant(String codTipoFrecLlant) {
        this.codTipoFrecLlant = codTipoFrecLlant;
    }

    public String getCodTipoFrecFren() {
        return codTipoFrecFren;
    }

    public void setCodTipoFrecFren(String codTipoFrecFren) {
        this.codTipoFrecFren = codTipoFrecFren;
    }

    public String getCodTipoFrecPint() {
        return codTipoFrecPint;
    }

    public void setCodTipoFrecPint(String codTipoFrecPint) {
        this.codTipoFrecPint = codTipoFrecPint;
    }

    public String getCodTipoFrecRep() {
        return codTipoFrecRep;
    }

    public void setCodTipoFrecRep(String codTipoFrecRep) {
        this.codTipoFrecRep = codTipoFrecRep;
    }

    public String getCodTipoFrecAdic() {
        return codTipoFrecAdic;
    }

    public void setCodTipoFrecAdic(String codTipoFrecAdic) {
        this.codTipoFrecAdic = codTipoFrecAdic;
    }

    public double getCambioAceiteCostoPromAnual() {
        return cambioAceiteCostoPromAnual;
    }

    public void setCambioAceiteCostoPromAnual(double cambioAceiteCostoPromAnual) {
        this.cambioAceiteCostoPromAnual = cambioAceiteCostoPromAnual;
    }

    public double getLlantasCostoPromAnual() {
        return llantasCostoPromAnual;
    }

    public void setLlantasCostoPromAnual(double llantasCostoPromAnual) {
        this.llantasCostoPromAnual = llantasCostoPromAnual;
    }

    public double getFrenosPastillasFajasCostoPromAnual() {
        return frenosPastillasFajasCostoPromAnual;
    }

    public void setFrenosPastillasFajasCostoPromAnual(double frenosPastillasFajasCostoPromAnual) {
        this.frenosPastillasFajasCostoPromAnual = frenosPastillasFajasCostoPromAnual;
    }

    public double getPinturaCostoPromAnual() {
        return pinturaCostoPromAnual;
    }

    public void setPinturaCostoPromAnual(double pinturaCostoPromAnual) {
        this.pinturaCostoPromAnual = pinturaCostoPromAnual;
    }

    public double getReparacionesMotorCostoPromAnual() {
        return reparacionesMotorCostoPromAnual;
    }

    public void setReparacionesMotorCostoPromAnual(double reparacionesMotorCostoPromAnual) {
        this.reparacionesMotorCostoPromAnual = reparacionesMotorCostoPromAnual;
    }

    public double getAdicionalesCostoPromAnual() {
        return adicionalesCostoPromAnual;
    }

    public void setAdicionalesCostoPromAnual(double adicionalesCostoPromAnual) {
        this.adicionalesCostoPromAnual = adicionalesCostoPromAnual;
    }

    public double getSoatAfocatCostoProm() {
        return soatAfocatCostoProm;
    }

    public void setSoatAfocatCostoProm(double soatAfocatCostoProm) {
        this.soatAfocatCostoProm = soatAfocatCostoProm;
    }

    public double getRevisionTecinaCostoProm() {
        return revisionTecinaCostoProm;
    }

    public void setRevisionTecinaCostoProm(double revisionTecinaCostoProm) {
        this.revisionTecinaCostoProm = revisionTecinaCostoProm;
    }

    public double getTarjetaCirculacionCostoProm() {
        return tarjetaCirculacionCostoProm;
    }

    public void setTarjetaCirculacionCostoProm(double tarjetaCirculacionCostoProm) {
        this.tarjetaCirculacionCostoProm = tarjetaCirculacionCostoProm;
    }

    public double getSoatAfocatFrecProm() {
        return soatAfocatFrecProm;
    }

    public void setSoatAfocatFrecProm(double soatAfocatFrecProm) {
        this.soatAfocatFrecProm = soatAfocatFrecProm;
    }

    public double getRevisionTecnicaFrecProm() {
        return revisionTecnicaFrecProm;
    }

    public void setRevisionTecnicaFrecProm(double revisionTecnicaFrecProm) {
        this.revisionTecnicaFrecProm = revisionTecnicaFrecProm;
    }

    public double getTarjetaCirculacionFrecProm() {
        return tarjetaCirculacionFrecProm;
    }

    public void setTarjetaCirculacionFrecProm(double tarjetaCirculacionFrecProm) {
        this.tarjetaCirculacionFrecProm = tarjetaCirculacionFrecProm;
    }

    public String getCodTipoFrecSoat() {
        return codTipoFrecSoat;
    }

    public void setCodTipoFrecSoat(String codTipoFrecSoat) {
        this.codTipoFrecSoat = codTipoFrecSoat;
    }

    public String getCodTipoFrecRevTec() {
        return codTipoFrecRevTec;
    }

    public void setCodTipoFrecRevTec(String codTipoFrecRevTec) {
        this.codTipoFrecRevTec = codTipoFrecRevTec;
    }

    public String getCodTipoFrecTarjCirc() {
        return codTipoFrecTarjCirc;
    }

    public void setCodTipoFrecTarjCirc(String codTipoFrecTarjCirc) {
        this.codTipoFrecTarjCirc = codTipoFrecTarjCirc;
    }

    public double getSoatAfocatCostoPromAnual() {
        return soatAfocatCostoPromAnual;
    }

    public void setSoatAfocatCostoPromAnual(double soatAfocatCostoPromAnual) {
        this.soatAfocatCostoPromAnual = soatAfocatCostoPromAnual;
    }

    public double getRevisionTecinaCostoPromAnual() {
        return revisionTecinaCostoPromAnual;
    }

    public void setRevisionTecinaCostoPromAnual(double revisionTecinaCostoPromAnual) {
        this.revisionTecinaCostoPromAnual = revisionTecinaCostoPromAnual;
    }

    public double getTarjetaCirculacionCostoPromAnual() {
        return tarjetaCirculacionCostoPromAnual;
    }

    public void setTarjetaCirculacionCostoPromAnual(double tarjetaCirculacionCostoPromAnual) {
        this.tarjetaCirculacionCostoPromAnual = tarjetaCirculacionCostoPromAnual;
    }

    public double getRemChofCostoVtaDiario() {
        return remChofCostoVtaDiario;
    }

    public void setRemChofCostoVtaDiario(double remChofCostoVtaDiario) {
        this.remChofCostoVtaDiario = remChofCostoVtaDiario;
    }

    public double getRemCobrCostoVtaDiario() {
        return remCobrCostoVtaDiario;
    }

    public void setRemCobrCostoVtaDiario(double remCobrCostoVtaDiario) {
        this.remCobrCostoVtaDiario = remCobrCostoVtaDiario;
    }

    public double getCombustCostoVtaDiario() {
        return combustCostoVtaDiario;
    }

    public void setCombustCostoVtaDiario(double combustCostoVtaDiario) {
        this.combustCostoVtaDiario = combustCostoVtaDiario;
    }

    public double getCochCostoVtaDiario() {
        return cochCostoVtaDiario;
    }

    public void setCochCostoVtaDiario(double cochCostoVtaDiario) {
        this.cochCostoVtaDiario = cochCostoVtaDiario;
    }

    public double getViaticCostoVtaDiario() {
        return viaticCostoVtaDiario;
    }

    public void setViaticCostoVtaDiario(double viaticCostoVtaDiario) {
        this.viaticCostoVtaDiario = viaticCostoVtaDiario;
    }

    public double getImpstosCostoVtaDiario() {
        return impstosCostoVtaDiario;
    }

    public void setImpstosCostoVtaDiario(double impstosCostoVtaDiario) {
        this.impstosCostoVtaDiario = impstosCostoVtaDiario;
    }

    public double getRemChofVtaAnual() {
        return remChofVtaAnual;
    }

    public void setRemChofVtaAnual(double remChofVtaAnual) {
        this.remChofVtaAnual = remChofVtaAnual;
    }

    public double getRemCobrCostoVtaAnual() {
        return remCobrCostoVtaAnual;
    }

    public void setRemCobrCostoVtaAnual(double remCobrCostoVtaAnual) {
        this.remCobrCostoVtaAnual = remCobrCostoVtaAnual;
    }

    public double getCombustCostoVtaAnual() {
        return combustCostoVtaAnual;
    }

    public void setCombustCostoVtaAnual(double combustCostoVtaAnual) {
        this.combustCostoVtaAnual = combustCostoVtaAnual;
    }

    public double getCochCostoVtaAnual() {
        return cochCostoVtaAnual;
    }

    public void setCochCostoVtaAnual(double cochCostoVtaAnual) {
        this.cochCostoVtaAnual = cochCostoVtaAnual;
    }

    public double getViaticCostoVtaAnual() {
        return viaticCostoVtaAnual;
    }

    public void setViaticCostoVtaAnual(double viaticCostoVtaAnual) {
        this.viaticCostoVtaAnual = viaticCostoVtaAnual;
    }

    public double getImpstosCostoVtaAnual() {
        return impstosCostoVtaAnual;
    }

    public void setImpstosCostoVtaAnual(double impstosCostoVtaAnual) {
        this.impstosCostoVtaAnual = impstosCostoVtaAnual;
    }

    public double getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public double getGastosAdministrativos() {
        return gastosAdministrativos;
    }

    public void setGastosAdministrativos(double gastosAdministrativos) {
        this.gastosAdministrativos = gastosAdministrativos;
    }

    public double getGastosVentas() {
        return gastosVentas;
    }

    public void setGastosVentas(double gastosVentas) {
        this.gastosVentas = gastosVentas;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getCantidadFiltroAceite() {
        return cantidadFiltroAceite;
    }

    public void setCantidadFiltroAceite(double cantidadFiltroAceite) {
        this.cantidadFiltroAceite = cantidadFiltroAceite;
    }

    public double getCantidadFiltroAire() {
        return cantidadFiltroAire;
    }

    public void setCantidadFiltroAire(double cantidadFiltroAire) {
        this.cantidadFiltroAire = cantidadFiltroAire;
    }

    public double getCantidadFiltroPetroleo() {
        return cantidadFiltroPetroleo;
    }

    public void setCantidadFiltroPetroleo(double cantidadFiltroPetroleo) {
        this.cantidadFiltroPetroleo = cantidadFiltroPetroleo;
    }

    public double getCantidadAceiteMotor() {
        return cantidadAceiteMotor;
    }

    public void setCantidadAceiteMotor(double cantidadAceiteMotor) {
        this.cantidadAceiteMotor = cantidadAceiteMotor;
    }

    public double getCantidadAceiteCaja() {
        return cantidadAceiteCaja;
    }

    public void setCantidadAceiteCaja(double cantidadAceiteCaja) {
        this.cantidadAceiteCaja = cantidadAceiteCaja;
    }

    public double getCantidadAceiteCorona() {
        return cantidadAceiteCorona;
    }

    public void setCantidadAceiteCorona(double cantidadAceiteCorona) {
        this.cantidadAceiteCorona = cantidadAceiteCorona;
    }

    public double getCantidadFiltroSeparador() {
        return cantidadFiltroSeparador;
    }

    public void setCantidadFiltroSeparador(double cantidadFiltroSeparador) {
        this.cantidadFiltroSeparador = cantidadFiltroSeparador;
    }

    public double getCantidadHidrolina() {
        return cantidadHidrolina;
    }

    public void setCantidadHidrolina(double cantidadHidrolina) {
        this.cantidadHidrolina = cantidadHidrolina;
    }

    public double getCantidadFiltroHidrolina() {
        return cantidadFiltroHidrolina;
    }

    public void setCantidadFiltroHidrolina(double cantidadFiltroHidrolina) {
        this.cantidadFiltroHidrolina = cantidadFiltroHidrolina;
    }

    public double getCantidadGrasaMP() {
        return cantidadGrasaMP;
    }

    public void setCantidadGrasaMP(double cantidadGrasaMP) {
        this.cantidadGrasaMP = cantidadGrasaMP;
    }

    public double getCantidadConjuntoCompleto() {
        return cantidadConjuntoCompleto;
    }

    public void setCantidadConjuntoCompleto(double cantidadConjuntoCompleto) {
        this.cantidadConjuntoCompleto = cantidadConjuntoCompleto;
    }

    public double getCantidadBombinBomba() {
        return cantidadBombinBomba;
    }

    public void setCantidadBombinBomba(double cantidadBombinBomba) {
        this.cantidadBombinBomba = cantidadBombinBomba;
    }

    public double getCantidadDelantero() {
        return cantidadDelantero;
    }

    public void setCantidadDelantero(double cantidadDelantero) {
        this.cantidadDelantero = cantidadDelantero;
    }

    public double getCantidadPosterior() {
        return cantidadPosterior;
    }

    public void setCantidadPosterior(double cantidadPosterior) {
        this.cantidadPosterior = cantidadPosterior;
    }

    public double getCantidadFajaVentilador() {
        return cantidadFajaVentilador;
    }

    public void setCantidadFajaVentilador(double cantidadFajaVentilador) {
        this.cantidadFajaVentilador = cantidadFajaVentilador;
    }

    public double getCantidadBombaAgua() {
        return cantidadBombaAgua;
    }

    public void setCantidadBombaAgua(double cantidadBombaAgua) {
        this.cantidadBombaAgua = cantidadBombaAgua;
    }

    public double getCantidadLlantasx6_1() {
        return cantidadLlantasx6_1;
    }

    public void setCantidadLlantasx6_1(double cantidadLlantasx6_1) {
        this.cantidadLlantasx6_1 = cantidadLlantasx6_1;
    }

    public double getCantidadRodajesx8() {
        return cantidadRodajesx8;
    }

    public void setCantidadRodajesx8(double cantidadRodajesx8) {
        this.cantidadRodajesx8 = cantidadRodajesx8;
    }

    public double getCantidadBateria() {
        return cantidadBateria;
    }

    public void setCantidadBateria(double cantidadBateria) {
        this.cantidadBateria = cantidadBateria;
    }

    public double getCantidadAmortiguadores() {
        return cantidadAmortiguadores;
    }

    public void setCantidadAmortiguadores(double cantidadAmortiguadores) {
        this.cantidadAmortiguadores = cantidadAmortiguadores;
    }

    public double getKilometrajeFiltroAceite() {
        return kilometrajeFiltroAceite;
    }

    public void setKilometrajeFiltroAceite(double kilometrajeFiltroAceite) {
        this.kilometrajeFiltroAceite = kilometrajeFiltroAceite;
    }

    public double getKilometrajeFiltroAire() {
        return kilometrajeFiltroAire;
    }

    public void setKilometrajeFiltroAire(double kilometrajeFiltroAire) {
        this.kilometrajeFiltroAire = kilometrajeFiltroAire;
    }

    public double getKilometrajeFiltroPetroleo() {
        return kilometrajeFiltroPetroleo;
    }

    public void setKilometrajeFiltroPetroleo(double kilometrajeFiltroPetroleo) {
        this.kilometrajeFiltroPetroleo = kilometrajeFiltroPetroleo;
    }

    public double getKilometrajeAceiteMotor() {
        return kilometrajeAceiteMotor;
    }

    public void setKilometrajeAceiteMotor(double kilometrajeAceiteMotor) {
        this.kilometrajeAceiteMotor = kilometrajeAceiteMotor;
    }

    public double getKilometrajeAceiteCaja() {
        return kilometrajeAceiteCaja;
    }

    public void setKilometrajeAceiteCaja(double kilometrajeAceiteCaja) {
        this.kilometrajeAceiteCaja = kilometrajeAceiteCaja;
    }

    public double getKilometrajeAceiteCorona() {
        return kilometrajeAceiteCorona;
    }

    public void setKilometrajeAceiteCorona(double kilometrajeAceiteCorona) {
        this.kilometrajeAceiteCorona = kilometrajeAceiteCorona;
    }

    public double getKilometrajeFiltroSeparador() {
        return kilometrajeFiltroSeparador;
    }

    public void setKilometrajeFiltroSeparador(double kilometrajeFiltroSeparador) {
        this.kilometrajeFiltroSeparador = kilometrajeFiltroSeparador;
    }

    public double getKilometrajeHidrolina() {
        return kilometrajeHidrolina;
    }

    public void setKilometrajeHidrolina(double kilometrajeHidrolina) {
        this.kilometrajeHidrolina = kilometrajeHidrolina;
    }

    public double getKilometrajeFiltroHidrolina() {
        return kilometrajeFiltroHidrolina;
    }

    public void setKilometrajeFiltroHidrolina(double kilometrajeFiltroHidrolina) {
        this.kilometrajeFiltroHidrolina = kilometrajeFiltroHidrolina;
    }

    public double getKilometrajeGrasaMP() {
        return kilometrajeGrasaMP;
    }

    public void setKilometrajeGrasaMP(double kilometrajeGrasaMP) {
        this.kilometrajeGrasaMP = kilometrajeGrasaMP;
    }

    public double getKilometrajeConjuntoCompleto() {
        return kilometrajeConjuntoCompleto;
    }

    public void setKilometrajeConjuntoCompleto(double kilometrajeConjuntoCompleto) {
        this.kilometrajeConjuntoCompleto = kilometrajeConjuntoCompleto;
    }

    public double getKilometrajeBombinBomba() {
        return kilometrajeBombinBomba;
    }

    public void setKilometrajeBombinBomba(double kilometrajeBombinBomba) {
        this.kilometrajeBombinBomba = kilometrajeBombinBomba;
    }

    public double getKilometrajeDelantero() {
        return kilometrajeDelantero;
    }

    public void setKilometrajeDelantero(double kilometrajeDelantero) {
        this.kilometrajeDelantero = kilometrajeDelantero;
    }

    public double getKilometrajePosterior() {
        return kilometrajePosterior;
    }

    public void setKilometrajePosterior(double kilometrajePosterior) {
        this.kilometrajePosterior = kilometrajePosterior;
    }

    public double getKilometrajeFajaVentilador() {
        return kilometrajeFajaVentilador;
    }

    public void setKilometrajeFajaVentilador(double kilometrajeFajaVentilador) {
        this.kilometrajeFajaVentilador = kilometrajeFajaVentilador;
    }

    public double getKilometrajeBombaAgua() {
        return kilometrajeBombaAgua;
    }

    public void setKilometrajeBombaAgua(double kilometrajeBombaAgua) {
        this.kilometrajeBombaAgua = kilometrajeBombaAgua;
    }

    public double getKilometrajeLlantasx6_1() {
        return kilometrajeLlantasx6_1;
    }

    public void setKilometrajeLlantasx6_1(double kilometrajeLlantasx6_1) {
        this.kilometrajeLlantasx6_1 = kilometrajeLlantasx6_1;
    }

    public double getKilometrajeRodajesx8() {
        return kilometrajeRodajesx8;
    }

    public void setKilometrajeRodajesx8(double kilometrajeRodajesx8) {
        this.kilometrajeRodajesx8 = kilometrajeRodajesx8;
    }

    public double getKilometrajeBateria() {
        return kilometrajeBateria;
    }

    public void setKilometrajeBateria(double kilometrajeBateria) {
        this.kilometrajeBateria = kilometrajeBateria;
    }

    public double getKilometrajeAmortiguadores() {
        return kilometrajeAmortiguadores;
    }

    public void setKilometrajeAmortiguadores(double kilometrajeAmortiguadores) {
        this.kilometrajeAmortiguadores = kilometrajeAmortiguadores;
    }

    public double getCostoUnitFiltroAceite() {
        return costoUnitFiltroAceite;
    }

    public void setCostoUnitFiltroAceite(double costoUnitFiltroAceite) {
        this.costoUnitFiltroAceite = costoUnitFiltroAceite;
    }

    public double getCostoUnitFiltroAire() {
        return costoUnitFiltroAire;
    }

    public void setCostoUnitFiltroAire(double costoUnitFiltroAire) {
        this.costoUnitFiltroAire = costoUnitFiltroAire;
    }

    public double getCostoUnitFiltroPetroleo() {
        return costoUnitFiltroPetroleo;
    }

    public void setCostoUnitFiltroPetroleo(double costoUnitFiltroPetroleo) {
        this.costoUnitFiltroPetroleo = costoUnitFiltroPetroleo;
    }

    public double getCostoUnitAceiteMotor() {
        return costoUnitAceiteMotor;
    }

    public void setCostoUnitAceiteMotor(double costoUnitAceiteMotor) {
        this.costoUnitAceiteMotor = costoUnitAceiteMotor;
    }

    public double getCostoUnitAceiteCaja() {
        return costoUnitAceiteCaja;
    }

    public void setCostoUnitAceiteCaja(double costoUnitAceiteCaja) {
        this.costoUnitAceiteCaja = costoUnitAceiteCaja;
    }

    public double getCostoUnitAceiteCorona() {
        return costoUnitAceiteCorona;
    }

    public void setCostoUnitAceiteCorona(double costoUnitAceiteCorona) {
        this.costoUnitAceiteCorona = costoUnitAceiteCorona;
    }

    public double getCostoUnitFiltroSeparador() {
        return costoUnitFiltroSeparador;
    }

    public void setCostoUnitFiltroSeparador(double costoUnitFiltroSeparador) {
        this.costoUnitFiltroSeparador = costoUnitFiltroSeparador;
    }

    public double getCostoUnitHidrolina() {
        return costoUnitHidrolina;
    }

    public void setCostoUnitHidrolina(double costoUnitHidrolina) {
        this.costoUnitHidrolina = costoUnitHidrolina;
    }

    public double getCostoUnitFiltroHidrolina() {
        return costoUnitFiltroHidrolina;
    }

    public void setCostoUnitFiltroHidrolina(double costoUnitFiltroHidrolina) {
        this.costoUnitFiltroHidrolina = costoUnitFiltroHidrolina;
    }

    public double getCostoUnitGrasaMP() {
        return costoUnitGrasaMP;
    }

    public void setCostoUnitGrasaMP(double costoUnitGrasaMP) {
        this.costoUnitGrasaMP = costoUnitGrasaMP;
    }

    public double getCostoUnitConjuntoCompleto() {
        return costoUnitConjuntoCompleto;
    }

    public void setCostoUnitConjuntoCompleto(double costoUnitConjuntoCompleto) {
        this.costoUnitConjuntoCompleto = costoUnitConjuntoCompleto;
    }

    public double getCostoUnitBombinBomba() {
        return costoUnitBombinBomba;
    }

    public void setCostoUnitBombinBomba(double costoUnitBombinBomba) {
        this.costoUnitBombinBomba = costoUnitBombinBomba;
    }

    public double getCostoUnitDelantero() {
        return costoUnitDelantero;
    }

    public void setCostoUnitDelantero(double costoUnitDelantero) {
        this.costoUnitDelantero = costoUnitDelantero;
    }

    public double getCostoUnitPosterior() {
        return costoUnitPosterior;
    }

    public void setCostoUnitPosterior(double costoUnitPosterior) {
        this.costoUnitPosterior = costoUnitPosterior;
    }

    public double getCostoUnitFajaVentilador() {
        return costoUnitFajaVentilador;
    }

    public void setCostoUnitFajaVentilador(double costoUnitFajaVentilador) {
        this.costoUnitFajaVentilador = costoUnitFajaVentilador;
    }

    public double getCostoUnitBombaAgua() {
        return costoUnitBombaAgua;
    }

    public void setCostoUnitBombaAgua(double costoUnitBombaAgua) {
        this.costoUnitBombaAgua = costoUnitBombaAgua;
    }

    public double getCostoUnitLlantasx6_1() {
        return costoUnitLlantasx6_1;
    }

    public void setCostoUnitLlantasx6_1(double costoUnitLlantasx6_1) {
        this.costoUnitLlantasx6_1 = costoUnitLlantasx6_1;
    }

    public double getCostoUnitRodajesx8() {
        return costoUnitRodajesx8;
    }

    public void setCostoUnitRodajesx8(double costoUnitRodajesx8) {
        this.costoUnitRodajesx8 = costoUnitRodajesx8;
    }

    public double getCostoUnitBateria() {
        return costoUnitBateria;
    }

    public void setCostoUnitBateria(double costoUnitBateria) {
        this.costoUnitBateria = costoUnitBateria;
    }

    public double getCostoUnitAmortiguadores() {
        return costoUnitAmortiguadores;
    }

    public void setCostoUnitAmortiguadores(double costoUnitAmortiguadores) {
        this.costoUnitAmortiguadores = costoUnitAmortiguadores;
    }

    public double getCostoKmFiltroAceite() {
        return costoKmFiltroAceite;
    }

    public void setCostoKmFiltroAceite(double costoKmFiltroAceite) {
        this.costoKmFiltroAceite = costoKmFiltroAceite;
    }

    public double getCostoKmFiltroAire() {
        return costoKmFiltroAire;
    }

    public void setCostoKmFiltroAire(double costoKmFiltroAire) {
        this.costoKmFiltroAire = costoKmFiltroAire;
    }

    public double getCostoKmFiltroPetroleo() {
        return costoKmFiltroPetroleo;
    }

    public void setCostoKmFiltroPetroleo(double costoKmFiltroPetroleo) {
        this.costoKmFiltroPetroleo = costoKmFiltroPetroleo;
    }

    public double getCostoKmAceiteMotor() {
        return costoKmAceiteMotor;
    }

    public void setCostoKmAceiteMotor(double costoKmAceiteMotor) {
        this.costoKmAceiteMotor = costoKmAceiteMotor;
    }

    public double getCostoKmAceiteCaja() {
        return costoKmAceiteCaja;
    }

    public void setCostoKmAceiteCaja(double costoKmAceiteCaja) {
        this.costoKmAceiteCaja = costoKmAceiteCaja;
    }

    public double getCostoKmAceiteCorona() {
        return costoKmAceiteCorona;
    }

    public void setCostoKmAceiteCorona(double costoKmAceiteCorona) {
        this.costoKmAceiteCorona = costoKmAceiteCorona;
    }

    public double getCostoKmFiltroSeparador() {
        return costoKmFiltroSeparador;
    }

    public void setCostoKmFiltroSeparador(double costoKmFiltroSeparador) {
        this.costoKmFiltroSeparador = costoKmFiltroSeparador;
    }

    public double getCostoKmHidrolina() {
        return costoKmHidrolina;
    }

    public void setCostoKmHidrolina(double costoKmHidrolina) {
        this.costoKmHidrolina = costoKmHidrolina;
    }

    public double getCostoKmFiltroHidrolina() {
        return costoKmFiltroHidrolina;
    }

    public void setCostoKmFiltroHidrolina(double costoKmFiltroHidrolina) {
        this.costoKmFiltroHidrolina = costoKmFiltroHidrolina;
    }

    public double getCostoKmGrasaMP() {
        return costoKmGrasaMP;
    }

    public void setCostoKmGrasaMP(double costoKmGrasaMP) {
        this.costoKmGrasaMP = costoKmGrasaMP;
    }

    public double getCostoKmConjuntoCompleto() {
        return costoKmConjuntoCompleto;
    }

    public void setCostoKmConjuntoCompleto(double costoKmConjuntoCompleto) {
        this.costoKmConjuntoCompleto = costoKmConjuntoCompleto;
    }

    public double getCostoKmBombinBomba() {
        return costoKmBombinBomba;
    }

    public void setCostoKmBombinBomba(double costoKmBombinBomba) {
        this.costoKmBombinBomba = costoKmBombinBomba;
    }

    public double getCostoKmDelantero() {
        return costoKmDelantero;
    }

    public void setCostoKmDelantero(double costoKmDelantero) {
        this.costoKmDelantero = costoKmDelantero;
    }

    public double getCostoKmPosterior() {
        return costoKmPosterior;
    }

    public void setCostoKmPosterior(double costoKmPosterior) {
        this.costoKmPosterior = costoKmPosterior;
    }

    public double getCostoKmFajaVentilador() {
        return costoKmFajaVentilador;
    }

    public void setCostoKmFajaVentilador(double costoKmFajaVentilador) {
        this.costoKmFajaVentilador = costoKmFajaVentilador;
    }

    public double getCostoKmBombaAgua() {
        return costoKmBombaAgua;
    }

    public void setCostoKmBombaAgua(double costoKmBombaAgua) {
        this.costoKmBombaAgua = costoKmBombaAgua;
    }

    public double getCostoKmLlantasx6_1() {
        return costoKmLlantasx6_1;
    }

    public void setCostoKmLlantasx6_1(double costoKmLlantasx6_1) {
        this.costoKmLlantasx6_1 = costoKmLlantasx6_1;
    }

    public double getCostoKmRodajesx8() {
        return costoKmRodajesx8;
    }

    public void setCostoKmRodajesx8(double costoKmRodajesx8) {
        this.costoKmRodajesx8 = costoKmRodajesx8;
    }

    public double getCostoKmBateria() {
        return costoKmBateria;
    }

    public void setCostoKmBateria(double costoKmBateria) {
        this.costoKmBateria = costoKmBateria;
    }

    public double getCostoKmAmortiguadores() {
        return costoKmAmortiguadores;
    }

    public void setCostoKmAmortiguadores(double costoKmAmortiguadores) {
        this.costoKmAmortiguadores = costoKmAmortiguadores;
    }

    public double getCostoSolesKm() {
        return costoSolesKm;
    }

    public void setCostoSolesKm(double costoSolesKm) {
        this.costoSolesKm = costoSolesKm;
    }

    public double getCostoSolesUnidxDia() {
        return costoSolesUnidxDia;
    }

    public void setCostoSolesUnidxDia(double costoSolesUnidxDia) {
        this.costoSolesUnidxDia = costoSolesUnidxDia;
    }

    public double getCostoSolesUnidMes() {
        return costoSolesUnidMes;
    }

    public void setCostoSolesUnidMes(double costoSolesUnidMes) {
        this.costoSolesUnidMes = costoSolesUnidMes;
    }

    public double getCargaReunion() {
        return cargaReunion;
    }

    public void setCargaReunion(double cargaReunion) {
        this.cargaReunion = cargaReunion;
    }

    public double getCargaContrato() {
        return cargaContrato;
    }

    public void setCargaContrato(double cargaContrato) {
        this.cargaContrato = cargaContrato;
    }

    public double getCargaEncuesta() {
        return cargaEncuesta;
    }

    public void setCargaEncuesta(double cargaEncuesta) {
        this.cargaEncuesta = cargaEncuesta;
    }

    public double getNroViajesMesReunion() {
        return nroViajesMesReunion;
    }

    public void setNroViajesMesReunion(double nroViajesMesReunion) {
        this.nroViajesMesReunion = nroViajesMesReunion;
    }

    public double getNroViajesMesContrato() {
        return nroViajesMesContrato;
    }

    public void setNroViajesMesContrato(double nroViajesMesContrato) {
        this.nroViajesMesContrato = nroViajesMesContrato;
    }

    public double getNroViajesMesEncuesta() {
        return nroViajesMesEncuesta;
    }

    public void setNroViajesMesEncuesta(double nroViajesMesEncuesta) {
        this.nroViajesMesEncuesta = nroViajesMesEncuesta;
    }

    public double getTarifaReunion() {
        return tarifaReunion;
    }

    public void setTarifaReunion(double tarifaReunion) {
        this.tarifaReunion = tarifaReunion;
    }

    public double getTarifaContrato() {
        return tarifaContrato;
    }

    public void setTarifaContrato(double tarifaContrato) {
        this.tarifaContrato = tarifaContrato;
    }

    public double getTarifaEncuesta() {
        return tarifaEncuesta;
    }

    public void setTarifaEncuesta(double tarifaEncuesta) {
        this.tarifaEncuesta = tarifaEncuesta;
    }

    public double getPromMesReunion() {
        return promMesReunion;
    }

    public void setPromMesReunion(double promMesReunion) {
        this.promMesReunion = promMesReunion;
    }

    public double getPromMesContrato() {
        return promMesContrato;
    }

    public void setPromMesContrato(double promMesContrato) {
        this.promMesContrato = promMesContrato;
    }

    public double getPromMesEncuesta() {
        return promMesEncuesta;
    }

    public void setPromMesEncuesta(double promMesEncuesta) {
        this.promMesEncuesta = promMesEncuesta;
    }

    public double getPonderacionReunion() {
        return ponderacionReunion;
    }

    public void setPonderacionReunion(double ponderacionReunion) {
        this.ponderacionReunion = ponderacionReunion;
    }

    public double getPonderacionContrato() {
        return ponderacionContrato;
    }

    public void setPonderacionContrato(double ponderacionContrato) {
        this.ponderacionContrato = ponderacionContrato;
    }

    public double getPonderacionEncuesta() {
        return ponderacionEncuesta;
    }

    public void setPonderacionEncuesta(double ponderacionEncuesta) {
        this.ponderacionEncuesta = ponderacionEncuesta;
    }

}
