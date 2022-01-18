/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ProyeParamPresuDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ActualizarProyeParamPresuProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.proyeparampresu.ListarProyeParamPresuProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ProyeParamPresuMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class ProyeParamPresuDAOImpl implements ProyeParamPresuDAO {

    private ProyeParamPresuMapper mapper;

    @Autowired
    public void setMapper(ProyeParamPresuMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void listarProyeccion(ListarProyeParamPresuProcedure parametros) {
        mapper.listarProyeccion(parametros);
    }

    @Override
    public void actualizarProyeccion(ActualizarProyeParamPresuProcedure parametros) {
        mapper.actualizarProyeccion(parametros);
    }

}
