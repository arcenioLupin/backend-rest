/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.OperacionLxCDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarDocumentosRelacionadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarRepresentanteLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarReprogramacionOperacionesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposDocumentosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarTiposGastosLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarCronogramaLetrasLxCProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.ListarOperacionLxCRegistradaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.lxc.RegistrarOperacionLxCProcedure;
import pe.com.divemotor.solicitudcredito.mapper.OperacionLxCMapper;

/**
 *
 * @author mbardales
 */

@Repository
public class OperacionLxCDAOImpl implements OperacionLxCDAO{

    OperacionLxCMapper operacionLxCMapper;

    @Autowired
    public void setOperacionLxCMapper(OperacionLxCMapper operacionLxCMapper) {
        this.operacionLxCMapper = operacionLxCMapper;
    }
    
    @Override
    public void listar(ListarDocumentosRelacionadosProcedure parametros) {
        operacionLxCMapper.listar(parametros);
    }

    @Override
    public void listarTiposDocumentos(ListarTiposDocumentosLxCProcedure parametros) {
        operacionLxCMapper.listarTiposDocumentos(parametros);
    }

    @Override
    public void listarTiposGastos(ListarTiposGastosLxCProcedure parametros) {
        operacionLxCMapper.listarTiposGastos(parametros);
    }

    @Override
    public void listarGastos(ListarGastosLxCProcedure parametros) {
        operacionLxCMapper.listarGastos(parametros);
    }

    @Override
    public void listarRepresentanteLegal(ListarRepresentanteLegalProcedure parametros) {
        operacionLxCMapper.listarRepresentanteLegal(parametros);
    }

    @Override
    public void listarReprogramacionOperaciones(ListarReprogramacionOperacionesProcedure parametros) {
        operacionLxCMapper.listarReprogramacionOperaciones(parametros);
    }

    @Override
    public void registrarOperacionLxC(RegistrarOperacionLxCProcedure parametros) {
        operacionLxCMapper.registrarOperacionLxC(parametros);
    }

    @Override
    public void listarOperacionLxCRegistrado(ListarOperacionLxCRegistradaProcedure parametros) {
        operacionLxCMapper.listarOperacionLxCRegistrado(parametros);
    }

    @Override
    public void listarCronogramaLetrasLxC(ListarCronogramaLetrasLxCProcedure parametros) {
        operacionLxCMapper.listarCronogramaLetrasLxC(parametros);
    }
    
}
