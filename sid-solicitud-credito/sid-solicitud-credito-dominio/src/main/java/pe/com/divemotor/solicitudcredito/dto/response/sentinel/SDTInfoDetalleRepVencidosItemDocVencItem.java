/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.sentinel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author legutierrez
 */
public class SDTInfoDetalleRepVencidosItemDocVencItem {

    private String docVenNom;
    private double docVenDeuTot;
    private String docVenDiaAtr;
    private SDTInfoDetalleRepVencidosItemDocVencItem.Detalle detalle;

    public String getDocVenNom() {
        return docVenNom;
    }

    public void setDocVenNom(String docVenNom) {
        this.docVenNom = docVenNom;
    }

    public double getDocVenDeuTot() {
        return docVenDeuTot;
    }

    public void setDocVenDeuTot(double docVenDeuTot) {
        this.docVenDeuTot = docVenDeuTot;
    }

    public String getDocVenDiaAtr() {
        return docVenDiaAtr;
    }

    public void setDocVenDiaAtr(String docVenDiaAtr) {
        this.docVenDiaAtr = docVenDiaAtr;
    }

    public SDTInfoDetalleRepVencidosItemDocVencItem.Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(SDTInfoDetalleRepVencidosItemDocVencItem.Detalle detalle) {
        this.detalle = detalle;
    }

    public static class Detalle {

        private List<SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem> detalleItem;

        public List<SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem> getDetalleItem() {
            if (detalleItem == null) {
                detalleItem = new ArrayList<SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem>();
            }
            return this.detalleItem;
        }

        public void setDetalleItem(List<SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem> detalleItem) {
            this.detalleItem = detalleItem;
        }
        
        
    }

}
