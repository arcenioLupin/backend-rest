/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import java.util.Map;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;

/**
 *
 * @author phramirez
 */
public interface MaestroMapper {

    Map crearPlantillaEvento(Map parametros);

    Map obtenerPlantillaCorreo(Map parametros);

    Map actualizarEstadoEnvio(Map parametros);

    Map listar(ListarMaestroProcedure parametros);
    
    Map listarFilialZona(ListarMaestroProcedure parametros);

    Map crearPlantillaAprobacion(Map parametros);

    Map crearPlantillaSegAprobacion(Map parametros);
    //I Req. 87567 E2.1 ID## avilca 06/10/2020 
    Map crearPlantillaSegRechazo(Map parametros);   
    
    Map crearPlantillaSegAprob(Map parametros);
    //F Req. 87567 E2.1 ID## avilca 06/10/2020 
    Map crearPlantillaSoliAprobacionCredito(Map parametros);
    
    Map crearPlantillaOperacionLxC(Map parametros);
    
    Map crearPlantillaSoliAprobacionCreditoUsu(Map parametros);
    
    Map crearPlantillaVencimientoPoliza(Map parametros);

}
