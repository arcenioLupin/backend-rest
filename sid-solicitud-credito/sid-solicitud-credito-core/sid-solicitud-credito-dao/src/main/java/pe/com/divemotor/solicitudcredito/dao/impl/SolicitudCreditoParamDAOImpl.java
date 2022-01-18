/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.SolicitudCreditoParamDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarFlujoCajaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarSolicitudCreditoParamProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSolicitudCreditoParamProcedure;
import pe.com.divemotor.solicitudcredito.mapper.SolicitudCreditoParamMapper;

/**
 *
 * @author legutierrez
 */
@Repository
public class SolicitudCreditoParamDAOImpl implements SolicitudCreditoParamDAO{
    
    SolicitudCreditoParamMapper solicitudCreditoParamMapper; 

    @Autowired
    public void setSolicitudCreditoParamMapper(SolicitudCreditoParamMapper solicitudCreditoParamMapper) {
        this.solicitudCreditoParamMapper = solicitudCreditoParamMapper;
    }
    
   
    @Override
    public void registrar(RegistrarSolicitudCreditoParamProcedure parametros) {
       solicitudCreditoParamMapper.registrar(parametros);
    }

    @Override
    public void listar(ListarSolicitudCreditoParamProcedure parametros) {
        solicitudCreditoParamMapper.listar(parametros);
    }

    @Override
    public void listarFlujoCaja(ListarFlujoCajaProcedure parametros) {
        solicitudCreditoParamMapper.listarFlujoCaja(parametros);
    }
    
}
