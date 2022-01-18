/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ActualizarProyeParamPresuProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ListarProyeParamPresuProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ProyeParamPresuMapper {
    
    void listarProyeccion(ListarProyeParamPresuProcedure parametros);

    void actualizarProyeccion(ActualizarProyeParamPresuProcedure parametros);
    
}
