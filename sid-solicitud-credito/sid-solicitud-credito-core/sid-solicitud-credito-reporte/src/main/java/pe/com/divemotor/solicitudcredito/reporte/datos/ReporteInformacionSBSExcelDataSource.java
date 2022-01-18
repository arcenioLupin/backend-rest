/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.reporte.datos;

import java.util.ArrayList;
import java.util.List;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTDeuSBS12;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTDeudaSBS12;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalle;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalleRepVencidosItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalleRepresentanteLegalItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SdtProtestosList;


/**
 *
 * @author legutierrez
 */
public class ReporteInformacionSBSExcelDataSource {

    private String nomRazSoc;

    private String condicionContribuyente;

    private String calificativo;

    private SDTDeudaSBS12 sbsMicrof12M;

    private SDTDeuSBS12 sbsMicrof3D;

    private SdtProtestosList protestosAceptantesSinRegularizar;

    private SdtProtestosList protestosAceptantesRegularizado;

    private SdtProtestosList protestosGiradorSinRegularizar;

    private SdtProtestosList protestosGiradorRegularizado;

    private SDTInfoDetalle.RepVencidos repVencidos;

    private SDTInfoDetalle.RepresentanteLegal representanteLegal;

    public String getNomRazSoc() {
        return nomRazSoc;
    }

    public void setNomRazSoc(String nomRazSoc) {
        this.nomRazSoc = nomRazSoc;
    }

    public String getCondicionContribuyente() {
        return condicionContribuyente;
    }

    public void setCondicionContribuyente(String condicionContribuyente) {
        this.condicionContribuyente = condicionContribuyente;
    }

    public String getCalificativo() {
        return calificativo;
    }

    public void setCalificativo(String calificativo) {
        this.calificativo = calificativo;
    }

    public SDTDeudaSBS12 getSbsMicrof12M() {
        return sbsMicrof12M;
    }

    public void setSbsMicrof12M(SDTDeudaSBS12 sbsMicrof12M) {
        this.sbsMicrof12M = sbsMicrof12M;
    }

    public SDTDeuSBS12 getSbsMicrof3D() {
        return sbsMicrof3D;
    }

    public void setSbsMicrof3D(SDTDeuSBS12 sbsMicrof3D) {
        this.sbsMicrof3D = sbsMicrof3D;
    }

    public SdtProtestosList getProtestosAceptantesSinRegularizar() {
        return protestosAceptantesSinRegularizar;
    }

    public void setProtestosAceptantesSinRegularizar(SdtProtestosList protestosAceptantesSinRegularizar) {
        this.protestosAceptantesSinRegularizar = protestosAceptantesSinRegularizar;
    }

    public SdtProtestosList getProtestosAceptantesRegularizado() {
        return protestosAceptantesRegularizado;
    }

    public void setProtestosAceptantesRegularizado(SdtProtestosList protestosAceptantesRegularizado) {
        this.protestosAceptantesRegularizado = protestosAceptantesRegularizado;
    }

    public SdtProtestosList getProtestosGiradorSinRegularizar() {
        return protestosGiradorSinRegularizar;
    }

    public void setProtestosGiradorSinRegularizar(SdtProtestosList protestosGiradorSinRegularizar) {
        this.protestosGiradorSinRegularizar = protestosGiradorSinRegularizar;
    }

    public SdtProtestosList getProtestosGiradorRegularizado() {
        return protestosGiradorRegularizado;
    }

    public void setProtestosGiradorRegularizado(SdtProtestosList protestosGiradorRegularizado) {
        this.protestosGiradorRegularizado = protestosGiradorRegularizado;
    }

    public SDTInfoDetalle.RepVencidos getRepVencidos() {
        return repVencidos;
    }

    public void setRepVencidos(SDTInfoDetalle.RepVencidos repVencidos) {
        this.repVencidos = repVencidos;
    }

    public SDTInfoDetalle.RepresentanteLegal getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(SDTInfoDetalle.RepresentanteLegal representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public static class RepVencidos {

        private List<SDTInfoDetalleRepVencidosItem> repVencidosItem;

        public List<SDTInfoDetalleRepVencidosItem> getRepVencidosItem() {
            if (repVencidosItem == null) {
                repVencidosItem = new ArrayList<SDTInfoDetalleRepVencidosItem>();
            }
            return this.repVencidosItem;
        }

        public void setRepVencidosItem(List<SDTInfoDetalleRepVencidosItem> repVencidosItem) {
            this.repVencidosItem = repVencidosItem;
        }

    }

    public static class RepresentanteLegal {

        private List<SDTInfoDetalleRepresentanteLegalItem> representanteLegalItem;

        public List<SDTInfoDetalleRepresentanteLegalItem> getRepresentanteLegalItem() {
            if (representanteLegalItem == null) {
                representanteLegalItem = new ArrayList<SDTInfoDetalleRepresentanteLegalItem>();
            }
            return this.representanteLegalItem;
        }

        public void setRepresentanteLegalItem(List<SDTInfoDetalleRepresentanteLegalItem> representanteLegalItem) {
            this.representanteLegalItem = representanteLegalItem;
        }

    }

}
