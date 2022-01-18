/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dominio.Cliente;
import pe.com.divemotor.solicitudcredito.dto.request.ClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ClienteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;

/**
 *
 * @author jaltamirano
 */
public interface ClienteService {

    public ClienteListadoResponse listarClientes(HeaderPaginadoParams headerParams, ClienteRequest request) throws Exception;

    public ClienteListadoResponse listarTodosClientes(HeaderPaginadoParams headerParams, ClienteRequest request) throws Exception;
    
    public ClienteListadoResponse getDetalleInfoCliente(HeaderParams headerParams, ClienteRequest request) throws Exception;

    public ClienteListadoResponse listarOperacionesPorCliente(HeaderParams headerParams, ClienteRequest request) throws Exception;

    public ClienteListadoResponse listarGarantiasPorCliente(HeaderParams headerParams, ClienteRequest request) throws Exception;

    public ClienteResponse exportarCliente(HeaderPaginadoParams headerParams, Cliente cliente) throws Exception;

    public BaseResponse validarGarantiaCliente(HeaderParams headerParams, ClienteRequest request) throws Exception;

    public BaseResponse updateGarantia(HeaderParams headerParams, ClienteRequest request) throws Exception;

    /* Req Obs Consulta cliente MBardales 16/10/2020 */
    public MaestroListadoResponse listarPaises(HeaderParams headerParams, String tipo) throws Exception;
    
    public MaestroListadoResponse listarDepartamentos(HeaderParams headerParams, String tipo) throws Exception;
    
    public MaestroListadoResponse listarProvincias(HeaderParams headerParams, String tipo) throws Exception;

    public MaestroListadoResponse listarDistritos(HeaderParams headerParams, String tipo) throws Exception;
}
