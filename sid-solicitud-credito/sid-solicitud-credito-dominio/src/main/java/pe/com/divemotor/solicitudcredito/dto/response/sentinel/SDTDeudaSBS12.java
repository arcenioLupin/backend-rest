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
public class SDTDeudaSBS12 {

//<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>    
    private List<SDTDeudaSBS12Item> sdtdeudaSBS12Item;

    public List<SDTDeudaSBS12Item> getSDTDeudaSBS12Item() {
        if (sdtdeudaSBS12Item == null) {
            sdtdeudaSBS12Item = new ArrayList<SDTDeudaSBS12Item>();
        }
        return this.sdtdeudaSBS12Item;
    }

    public void setSdtDeudaSBS12Item(List<SDTDeudaSBS12Item> sdtdeudaSBS12Item) {
        this.sdtdeudaSBS12Item = sdtdeudaSBS12Item;
    }
//<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
}
