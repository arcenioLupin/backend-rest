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
public class SDTInfoDetalleRepVencidosItem {
    
    private String anio;
    private String mes;
    private SDTInfoDetalleRepVencidosItem.DocVen docVen;

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public SDTInfoDetalleRepVencidosItem.DocVen getDocVen() {
        return docVen;
    }

    public void setDocVen(SDTInfoDetalleRepVencidosItem.DocVen docVen) {
        this.docVen = docVen;
    }
    
    
    
    public static class DocVen {
        
        private List<SDTInfoDetalleRepVencidosItemDocVencItem> docVencItem;

        public List<SDTInfoDetalleRepVencidosItemDocVencItem> getDocVencItem() {
            if (docVencItem == null) {
                docVencItem = new ArrayList<SDTInfoDetalleRepVencidosItemDocVencItem>();
            }
            return this.docVencItem;
        }

        public void setDocVencItem(List<SDTInfoDetalleRepVencidosItemDocVencItem> docVencItem) {
            this.docVencItem = docVencItem;
        }
        
        
    }
}
