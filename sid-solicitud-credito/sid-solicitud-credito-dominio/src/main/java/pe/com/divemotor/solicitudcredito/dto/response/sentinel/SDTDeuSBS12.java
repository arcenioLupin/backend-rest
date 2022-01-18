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
public class SDTDeuSBS12 {

    private List<SDTDeuSBS12SDTDeuSBS12Item> sdtdeuSBS12SDTDeuSBS12Item;

    public List<SDTDeuSBS12SDTDeuSBS12Item> getSdtdeuSBS12SDTDeuSBS12Item() {
        if (sdtdeuSBS12SDTDeuSBS12Item == null) {
            sdtdeuSBS12SDTDeuSBS12Item = new ArrayList<SDTDeuSBS12SDTDeuSBS12Item>();
        }
        return sdtdeuSBS12SDTDeuSBS12Item;
    }

    public void setSdtdeuSBS12SDTDeuSBS12Item(List<SDTDeuSBS12SDTDeuSBS12Item> sdtdeuSBS12SDTDeuSBS12Item) {
        this.sdtdeuSBS12SDTDeuSBS12Item = sdtdeuSBS12SDTDeuSBS12Item;
    }

}
