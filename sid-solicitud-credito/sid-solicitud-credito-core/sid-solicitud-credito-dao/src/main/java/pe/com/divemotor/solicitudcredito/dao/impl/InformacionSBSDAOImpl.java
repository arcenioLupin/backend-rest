/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.InformacionSBSDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarInformacionSBSProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarInformacionSBSProcedure;
import pe.com.divemotor.solicitudcredito.mapper.InformacionSBSMapper;

/**
 *
 * @author legutierrez
 */

@Repository
public class InformacionSBSDAOImpl implements InformacionSBSDAO{

    InformacionSBSMapper informacionSBSMapper;

    @Autowired
    public void setInformacionSBSMapper(InformacionSBSMapper informacionSBSMapper) {
        this.informacionSBSMapper = informacionSBSMapper;
    }
    
    @Override
    public void registrar(RegistrarInformacionSBSProcedure parametros) {
        informacionSBSMapper.registrar(parametros);
    }

    @Override
    public void listar(ListarInformacionSBSProcedure parametros) {
        informacionSBSMapper.listar(parametros);
    }
    
}
