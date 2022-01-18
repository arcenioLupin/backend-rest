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
 * @author avilca
 */
public class SDTDeudaSBS12Item {

    private short anio;
    private short mes;
    private SDTDeudaSBS12Item.Detalle detalle;

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public SDTDeudaSBS12Item.Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(SDTDeudaSBS12Item.Detalle detalle) {
        this.detalle = detalle;
    }

    public static class Detalle {

        private List<SDTDeudaSBS12ItemDetalleItem> detalleItem;

        public List<SDTDeudaSBS12ItemDetalleItem> getDetalleItem() {
            if (detalleItem == null) {
                detalleItem = new ArrayList<SDTDeudaSBS12ItemDetalleItem>();
            }
            return this.detalleItem;
        }

        public void setDetalleItem(List<SDTDeudaSBS12ItemDetalleItem> detalleItem) {
            this.detalleItem = detalleItem;
        }

    }

}
