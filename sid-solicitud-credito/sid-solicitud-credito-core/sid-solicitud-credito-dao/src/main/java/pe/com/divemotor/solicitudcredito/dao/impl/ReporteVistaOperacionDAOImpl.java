/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ReporteVistaOperacionDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion.ListarReporteVistaOperacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.vistaoperacion.ListarSolicitudCreditoVOProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ReporteVistaOperacionMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class ReporteVistaOperacionDAOImpl implements ReporteVistaOperacionDAO {
    
    private ReporteVistaOperacionMapper reporteVOMapper;
    
    @Autowired
    public void setReporteVOMapper(ReporteVistaOperacionMapper reporteVOMapper) {
        this.reporteVOMapper = reporteVOMapper;
    }
    
    @Override
    public void listar(ListarReporteVistaOperacionProcedure parametros) {
        reporteVOMapper.listar(parametros);
    }

    @Override
    public void listarSolcreByCodOper(ListarSolicitudCreditoVOProcedure parametros) {
        reporteVOMapper.listarSolcreByCodOper(parametros);
    }
    
}
