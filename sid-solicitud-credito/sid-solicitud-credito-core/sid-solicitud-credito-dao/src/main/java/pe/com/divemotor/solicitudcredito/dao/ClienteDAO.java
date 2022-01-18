/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ActualizarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ListarClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ClienteDAO {

    void listarClientes(ListarClienteProcedure parametros);
    
    void listarTodosClientes(ListarClienteProcedure parametros);

    void listarCodigosOperPorCliente(ListarClienteProcedure parametros);

    void listarOperacionesPorCliente(ListarClienteProcedure parametros);

    void listarGarantiasPorCliente(ListarClienteProcedure parametros);

    void updateGarantia(ActualizarGarantiaProcedure parametros);

    //void validarGarantiaCliente(ActualizarGarantiaProcedure parametros);
    
    void listarPaises(ListarMaestroProcedure parametros) throws Exception;

    void listarDepartamentos(ListarMaestroProcedure parametros) throws Exception;

    void listarProvincias(ListarMaestroProcedure parametros) throws Exception;

    void listarDistritos(ListarMaestroProcedure parametros) throws Exception;

}
