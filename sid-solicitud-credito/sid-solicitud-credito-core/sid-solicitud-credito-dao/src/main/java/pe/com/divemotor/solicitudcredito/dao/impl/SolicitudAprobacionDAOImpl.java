/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.SolicitudAprobacionDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.FormatoRDLProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarHistorialAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarMotivosAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.mapper.SolicitudAprobacionMapper;

/**
 *
 * @author legutierrez
 */

@Repository
public class SolicitudAprobacionDAOImpl implements SolicitudAprobacionDAO{

    SolicitudAprobacionMapper solicitudAprobacionMapper;

    @Autowired
    public void setSolicitudAprobacionMapper(SolicitudAprobacionMapper solicitudAprobacionMapper) {
        this.solicitudAprobacionMapper = solicitudAprobacionMapper;
    }
    
    @Override
    public void registrarAprobacion(RegistrarAprobacionProcedure parametros) {
        solicitudAprobacionMapper.registrarAprobacion(parametros);
    }

    @Override
    public void actualizarSolicitudApro(ActualizarSolicitudAprobacionProcedure parametros) {
        solicitudAprobacionMapper.actualizarSolicitudApro(parametros);
    }

    @Override
    public void listarFormatoRDL(FormatoRDLProcedure parametros) {
        solicitudAprobacionMapper.listarFormatoRDL(parametros);
    }
    
    @Override
    public void listarFormatoMutuo(FormatoRDLProcedure parametros) {
        solicitudAprobacionMapper.listarFormatoMutuo(parametros);
    }
    
    @Override
    public void listarFormatoLeasing(FormatoRDLProcedure parametros) {
        solicitudAprobacionMapper.listarFormatoLeasing(parametros);
    }    
    
    @Override
    public void listarMotivosAprobacion(ListarMotivosAprobacionProcedure parametros) {
        solicitudAprobacionMapper.listarMotivosAprobacion(parametros);
    }
    // <I> 90690 ivelasquez 21/09/2021
    @Override
    public void listarHistorialAprobacion(ListarHistorialAprobacionProcedure parametros) {
        solicitudAprobacionMapper.listarHistorialAprobacion(parametros);
    }
    
    @Override
    public void listarSoliAprob(RegistrarAprobacionProcedure parametros) {
        solicitudAprobacionMapper.listarSoliAprob(parametros);
    }

    @Override
    public void actualizarAprob(ActualizarSolicitudAprobacionProcedure parametros) {
      solicitudAprobacionMapper.actualizarAprob(parametros);
    }
    // <F> 90690 ivelasquez 21/09/2021
}
