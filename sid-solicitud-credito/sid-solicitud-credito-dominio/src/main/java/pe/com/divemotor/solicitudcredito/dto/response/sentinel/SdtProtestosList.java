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
public class SdtProtestosList {
    
    //<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
    private List<SdtProtestosListItem> sdtProtestosListItem;

    public List<SdtProtestosListItem> getSdtProtestosListItem() {
        if (sdtProtestosListItem == null) {
            sdtProtestosListItem = new ArrayList<SdtProtestosListItem>();
        }
        return this.sdtProtestosListItem;
    }

    public void setSdtProtestosListItem(List<SdtProtestosListItem> sdtProtestosListItem) {
        this.sdtProtestosListItem = sdtProtestosListItem;
    }
    //<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
    
}
