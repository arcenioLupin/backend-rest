/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.EntidadFinancieraDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.cartabanco.ListarEntidadFinancieraProcedure;
import pe.com.divemotor.solicitudcredito.mapper.EntidadFinancieraMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class EntidadFinancieraDAOImpl implements EntidadFinancieraDAO {
    
    private EntidadFinancieraMapper entidadFinancieraMapper;
    
    @Autowired
    public void setEntidadFinancieraMapper(EntidadFinancieraMapper entidadFinancieraMapper) {
        this.entidadFinancieraMapper = entidadFinancieraMapper;
    }
    
    @Override
    public void listar(ListarEntidadFinancieraProcedure parametros) {
        this.entidadFinancieraMapper.listar(parametros);
    }
    
}
