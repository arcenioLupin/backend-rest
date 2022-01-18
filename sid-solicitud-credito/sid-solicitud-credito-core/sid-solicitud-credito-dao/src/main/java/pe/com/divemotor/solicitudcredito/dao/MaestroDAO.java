/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import java.util.Map;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.CorreoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;

/**
 *
 * @author phramirez
 */
public interface MaestroDAO {

    GenericoResponse crearPlantillaEvento(Map parametros) throws Exception;

    CorreoResponse obtenerPlantillaCorreo(Map parametros) throws Exception;

    GenericoResponse actualizarEstadoEnvio(Map parametros) throws Exception;

    void listar(ListarMaestroProcedure parametros);
    
    void listarFilialZona(ListarMaestroProcedure parametros);

    GenericoResponse crearPlantillaAprobacion(Map parametros) throws Exception;
    
    GenericoResponse crearPlantillaSegAprobacion(Map parametros) throws Exception;
    //I Req. 87567 E2.1 ID## avilca 06/10/2020>    
    GenericoResponse crearPlantillaSegRechazo(Map parametros) throws Exception; 
    
    GenericoResponse crearPlantillaSegAprob(Map parametros) throws Exception;
    //F Req. 87567 E2.1 ID## avilca 06/10/2020>   
    GenericoResponse crearPlantillaSoliAprobacionCredito(Map parametros) throws Exception;
    
    GenericoResponse crearPlantillaOperacionLxC(Map parametros) throws Exception;
    
    GenericoResponse crearPlantillaSoliAprobacionCreditoUsu(Map parametros) throws Exception;
    
    GenericoResponse crearPlantillaVencimientoPoliza(Map parametros) throws Exception;
            
}
