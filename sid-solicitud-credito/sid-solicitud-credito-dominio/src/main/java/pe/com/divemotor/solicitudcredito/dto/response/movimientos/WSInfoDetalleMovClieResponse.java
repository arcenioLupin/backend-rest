/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.response.movimientos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaltamirano
 */
public class WSInfoDetalleMovClieResponse {

    private WSInfoDetalleMovClieResponse.Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public static class Items {

        private List<WSInfoDetalleMovClieResponse.Items.Item> item;

        public List<WSInfoDetalleMovClieResponse.Items.Item> getItem() {
            if (item == null) {
                item = new ArrayList<WSInfoDetalleMovClieResponse.Items.Item>();
            }
            return this.item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

        public static class Item {

            private String codSociedad;
            private String codClie;
            private String numPeriodo;
            private String claseDoc;
            private String numDoc;
            private String numRefer;
            private String fecDoc;
            private String fecBase;
            private String codPago;
            private String diaCondPago;
            private String codICME;
            private String codCuenta;
            private String codMonDoc;
            private String impMonDoc;
            private String impMonDol;
            private String codRef1;
            private String codRef2;
            private String codRef3;
            private String txtDoc;
            private String numDocComp;
            private String fecComp;
            private String txtAsignacion;

            public String getCodSociedad() {
                return codSociedad;
            }

            public void setCodSociedad(String codSociedad) {
                this.codSociedad = codSociedad;
            }

            public String getCodClie() {
                return codClie;
            }

            public void setCodClie(String codClie) {
                this.codClie = codClie;
            }

            public String getNumPeriodo() {
                return numPeriodo;
            }

            public void setNumPeriodo(String numPeriodo) {
                this.numPeriodo = numPeriodo;
            }

            public String getClaseDoc() {
                return claseDoc;
            }

            public void setClaseDoc(String claseDoc) {
                this.claseDoc = claseDoc;
            }

            public String getNumDoc() {
                return numDoc;
            }

            public void setNumDoc(String numDoc) {
                this.numDoc = numDoc;
            }

            public String getNumRefer() {
                return numRefer;
            }

            public void setNumRefer(String numRefer) {
                this.numRefer = numRefer;
            }

            public String getFecDoc() {
                return fecDoc;
            }

            public void setFecDoc(String fecDoc) {
                this.fecDoc = fecDoc;
            }

            public String getFecBase() {
                return fecBase;
            }

            public void setFecBase(String fecBase) {
                this.fecBase = fecBase;
            }

            public String getCodPago() {
                return codPago;
            }

            public void setCodPago(String codPago) {
                this.codPago = codPago;
            }

            public String getDiaCondPago() {
                return diaCondPago;
            }

            public void setDiaCondPago(String diaCondPago) {
                this.diaCondPago = diaCondPago;
            }

            public String getCodICME() {
                return codICME;
            }

            public void setCodICME(String codICME) {
                this.codICME = codICME;
            }

            public String getCodCuenta() {
                return codCuenta;
            }

            public void setCodCuenta(String codCuenta) {
                this.codCuenta = codCuenta;
            }

            public String getCodMonDoc() {
                return codMonDoc;
            }

            public void setCodMonDoc(String codMonDoc) {
                this.codMonDoc = codMonDoc;
            }

            public String getImpMonDoc() {
                return impMonDoc;
            }

            public void setImpMonDoc(String impMonDoc) {
                this.impMonDoc = impMonDoc;
            }

            public String getImpMonDol() {
                return impMonDol;
            }

            public void setImpMonDol(String impMonDol) {
                this.impMonDol = impMonDol;
            }

            public String getCodRef1() {
                return codRef1;
            }

            public void setCodRef1(String codRef1) {
                this.codRef1 = codRef1;
            }

            public String getCodRef2() {
                return codRef2;
            }

            public void setCodRef2(String codRef2) {
                this.codRef2 = codRef2;
            }

            public String getCodRef3() {
                return codRef3;
            }

            public void setCodRef3(String codRef3) {
                this.codRef3 = codRef3;
            }

            public String getTxtDoc() {
                return txtDoc;
            }

            public void setTxtDoc(String txtDoc) {
                this.txtDoc = txtDoc;
            }

            public String getNumDocComp() {
                return numDocComp;
            }

            public void setNumDocComp(String numDocComp) {
                this.numDocComp = numDocComp;
            }

            public String getFecComp() {
                return fecComp;
            }

            public void setFecComp(String fecComp) {
                this.fecComp = fecComp;
            }

            public String getTxtAsignacion() {
                return txtAsignacion;
            }

            public void setTxtAsignacion(String txtAsignacion) {
                this.txtAsignacion = txtAsignacion;
            }
        }

    }

}
