/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ReporteCreditoOtorgadoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.creditoOtorgado.ListarReporteCreditoOtorgadoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ReporteCreditoOtorgadoMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class ReporteCreditoOtorgadoDAOImpl implements ReporteCreditoOtorgadoDAO{
    
    private ReporteCreditoOtorgadoMapper mapper;

    @Autowired
    public void setMapper(ReporteCreditoOtorgadoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void listarCreditoOtorgado(ListarReporteCreditoOtorgadoProcedure parametros) {
        mapper.listarCreditoOtorgado(parametros);
    }
    
    
    
}
