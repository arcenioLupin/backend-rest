/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dto.request;

import pe.com.divemotor.generico.dto.BaseRequest;

/**
 *
 * @author legutierrez
 */
public class ActualizarIndiVehiculoRequest extends BaseRequest {

    private String numPedidoVeh;
    private String indiInactivo;

    public String getNumPedidoVeh() {
        return numPedidoVeh;
    }

    public void setNumPedidoVeh(String numPedidoVeh) {
        this.numPedidoVeh = numPedidoVeh;
    }

    public String getIndiInactivo() {
        return indiInactivo;
    }

    public void setIndiInactivo(String indiInactivo) {
        this.indiInactivo = indiInactivo;
    }

    }
