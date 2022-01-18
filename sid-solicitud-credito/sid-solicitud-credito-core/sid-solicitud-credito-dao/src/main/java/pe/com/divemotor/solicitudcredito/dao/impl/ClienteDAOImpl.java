/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ClienteDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ActualizarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ListarClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ClienteMapper;

/**
 *
 * @author jaltamirano
 */
@Repository
public class ClienteDAOImpl implements ClienteDAO {

    private ClienteMapper mapper;

    @Autowired
    public void setMapper(ClienteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void listarClientes(ListarClienteProcedure parametros) {
        mapper.listarClientes(parametros);
    }
    
    @Override
    public void listarTodosClientes(ListarClienteProcedure parametros) {
        mapper.listarTodosClientes(parametros);
    }

    @Override
    public void listarCodigosOperPorCliente(ListarClienteProcedure parametros) {
        mapper.listarCodigosOperPorCliente(parametros);
    }

    @Override
    public void listarOperacionesPorCliente(ListarClienteProcedure parametros) {
        mapper.listarOperacionesPorCliente(parametros);
    }

    @Override
    public void listarGarantiasPorCliente(ListarClienteProcedure parametros) {
        mapper.listarGarantiasPorCliente(parametros);
    }
    
    /*@Override
    public void validarGarantiaCliente(ActualizarGarantiaProcedure parametros) {
        mapper.validarGarantiaCliente(parametros);
    }*/

    @Override
    public void updateGarantia(ActualizarGarantiaProcedure parametros) {
        mapper.updateGarantia(parametros);
    }

    /* Req Obs Consulta cliente MBardales 16/10/2020 */
    @Override
    public void listarPaises(ListarMaestroProcedure parametros) throws Exception {
        mapper.listarPaises(parametros);
    }

    @Override
    public void listarDepartamentos(ListarMaestroProcedure parametros) throws Exception {
        mapper.listarDepartamentos(parametros);
    }

    @Override
    public void listarProvincias(ListarMaestroProcedure parametros) throws Exception {
        mapper.listarProvincias(parametros);
    }

    @Override
    public void listarDistritos(ListarMaestroProcedure parametros) throws Exception {
        mapper.listarDistritos(parametros);
    }

}
