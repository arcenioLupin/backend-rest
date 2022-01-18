/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ProformaDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarProformaProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ProformaMapper;

/**
 *
 * @author legutierrez
 */

@Repository
public class ProformaDAOImpl implements ProformaDAO{
    
    ProformaMapper proformaMapper;

    @Autowired
    public void setProformaMapper(ProformaMapper proformaMapper) {
        this.proformaMapper = proformaMapper;
    }

    @Override
    public void listar(ListarProformaProcedure parametros) {
        proformaMapper.listar(parametros);
    }
    
}
