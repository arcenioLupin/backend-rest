/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ActualizarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ListarClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;

/**
 *
 * @author jaltamirano
 */
public interface ClienteMapper {

    public void listarClientes(ListarClienteProcedure parametros);
    
    public void listarTodosClientes(ListarClienteProcedure parametros);

    public void listarCodigosOperPorCliente(ListarClienteProcedure parametros);

    public void listarOperacionesPorCliente(ListarClienteProcedure parametros);

    public void listarGarantiasPorCliente(ListarClienteProcedure parametros);

    //public void validarGarantiaCliente(ActualizarGarantiaProcedure parametros);

    public void updateGarantia(ActualizarGarantiaProcedure parametros);
    
    /* Req Obs Consulta cliente MBardales 16/10/2020 */
    public void listarPaises(ListarMaestroProcedure parametros) throws Exception;

    public void listarDepartamentos(ListarMaestroProcedure parametros) throws Exception;

    public void listarProvincias(ListarMaestroProcedure parametros) throws Exception;

    public void listarDistritos(ListarMaestroProcedure parametros) throws Exception;

}
