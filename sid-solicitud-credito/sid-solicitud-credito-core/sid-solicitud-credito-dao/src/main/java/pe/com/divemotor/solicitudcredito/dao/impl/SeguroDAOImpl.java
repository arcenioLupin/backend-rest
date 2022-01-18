/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dao.SeguroDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroDetalleVehiculoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ActualizarSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarPolizaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.VencimientoSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.seguro.ListarSeguroTramaProcedure;
import pe.com.divemotor.solicitudcredito.mapper.SeguroMapper;

/**
 *
 * @author Mgrasso
 */
@Repository
public class SeguroDAOImpl implements SeguroDAO{

    private SeguroMapper solicitudCreditoSeguroMapper;
    
    @Autowired
    public void setSolicitudCreditoSeguroMapper(SeguroMapper solicitudCreditoSeguroMapper) {
        this.solicitudCreditoSeguroMapper = solicitudCreditoSeguroMapper;
    }
    
    @Override
    public void listar(ListarSeguroProcedure parametros) {
        
        solicitudCreditoSeguroMapper.listar(parametros);
    }

    @Override
    public void actualizar(ActualizarSeguroProcedure parametros) {
        solicitudCreditoSeguroMapper.actualizar(parametros);
    
    }

    @Override
    public void actualizarPlaca(ActualizarSeguroDetalleVehiculoProcedure parametros) {
        solicitudCreditoSeguroMapper.actualizarPlaca(parametros);
    }

    @Override
    public void actualizarPoliza(ActualizarSeguroProcedure parametros) {
        solicitudCreditoSeguroMapper.actualizarPoliza(parametros);
    }

    @Override
    public void listarPoliza(ListarPolizaProcedure parametros) {
        solicitudCreditoSeguroMapper.listarPoliza(parametros);
    }
    
    @Override
    public void vencimientoSeguro(VencimientoSeguroProcedure parametros) {
        solicitudCreditoSeguroMapper.vencimientoSeguro(parametros);
    }

    @Override
    public void listarTramaSeguro(ListarSeguroTramaProcedure parametros){
        solicitudCreditoSeguroMapper.listarTramaSeguro(parametros);
    }
    
}
