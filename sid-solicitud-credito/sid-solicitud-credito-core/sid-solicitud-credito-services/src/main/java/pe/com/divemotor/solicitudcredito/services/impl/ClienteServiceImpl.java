/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.ClienteDAO;
import pe.com.divemotor.solicitudcredito.dominio.Cliente;
import pe.com.divemotor.solicitudcredito.dominio.GarantiasCredito;
import pe.com.divemotor.solicitudcredito.dominio.OperacionesCredito;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ActualizarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.cliente.ListarClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ClienteRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ClienteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.movimientos.WSInfoDetalleMovClieResponse;
import pe.com.divemotor.solicitudcredito.services.ClienteService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

/**
 *
 * @author jaltamirano
 */
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final Logger LOGGER = Logger.getLogger(getClass());
    private ClienteDAO dao;
    private Mapper mapper;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ClienteListadoResponse listarClientes(HeaderPaginadoParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure procedureParams = new ListarClienteProcedure();
        Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
        procedureParams.setLiminf(limites.get("liminf"));
        procedureParams.setLimsup(headerParams.getCantidadxPag());

        String codTipoCredito = request.getCodTipoCredito();
        String codSoliCred = request.getNroSolicitud();
        String codCliente = request.getCodCliente();
        String codClieSap = request.getCodClieSap();
        String nombreCliente = request.getNombreCliente();
        String codTipoPersona = request.getCodTipoPersona();
        String codTipoDocumento = request.getCodTipoDocumento();
        String nroDocumento = request.getNroDocumento();
        String codAreaVta = request.getCodAreaVta();
        String codFilial = request.getCodFilial();
        String codZona  = request.getCodZona();
        String codCia = request.getCodCia();
        String codPais = request.getCodPais();
        String codDepartamento = request.getCodDepartamento();
        String codProvincia = request.getCodProvincia();
        String codDistrito = request.getCodDistrito();
        String codEstadoSolicitud = request.getCodEstadoSolicitud();
        //String codVendedor = request.getCodVendedor();
        String estadoClie = request.getEstadoClie();

        procedureParams.setCodTipoCredSoli(codTipoCredito);
        procedureParams.setCodSoliCred(codSoliCred);
        procedureParams.setCodClie(codCliente);
        procedureParams.setCodigoClieSap(codClieSap);
        procedureParams.setNombClie(nombreCliente);
        procedureParams.setCodTipoPersona(codTipoPersona);

        if (StringUtils.isNotEmpty(codTipoDocumento)) {
            if (codTipoDocumento.equals(Constantes.TIPO_DOC_DNI)) {//DNI

                procedureParams.setCodTipoDocumento(Constantes.TIPO_DOC_DNI);
                procedureParams.setDni(nroDocumento);

            } else if (codTipoDocumento.equals(Constantes.TIPO_DOC_RUC)) {//RUC

                procedureParams.setCodTipoDocumento(null);
                procedureParams.setRuc(nroDocumento);

            } else {//CE

                procedureParams.setCodTipoDocumento(Constantes.TIPO_DOC_CE);
                //procedureParams.setCe(nroDocumento);
            }

        } else {
            procedureParams.setCodTipoDocumento(null);
            procedureParams.setDni(null);
            procedureParams.setRuc(null);
        }

        procedureParams.setCodAreaVta(codAreaVta);
        procedureParams.setCodFilial(codFilial);
        procedureParams.setCodZona(codZona);
        procedureParams.setCodCia(codCia);
        procedureParams.setCodPais(codPais);
        procedureParams.setCodDepa(codDepartamento);
        procedureParams.setCodProv(codProvincia);
        procedureParams.setCodDist(codDistrito);
        //procedureParams.setCodVendedor(codVendedor);
        procedureParams.setCodEstadoSolicitud(codEstadoSolicitud);
        procedureParams.setEstadoClie(estadoClie);

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        dao.listarClientes(procedureParams);

        if (procedureParams.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
            ClienteListadoResponse response = new ClienteListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getCantidad());
            int numerodePaginas = Util.determinarNroPaginas(response.getCantidad(), headerParams.getCantidadxPag());
            response.setCantidadPaginas(numerodePaginas);
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
  @Override
    public ClienteListadoResponse listarTodosClientes(HeaderPaginadoParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure procedureParams = new ListarClienteProcedure();
        //Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
       // procedureParams.setLiminf(limites.get("liminf"));
       // procedureParams.setLimsup(limites.get("limsup"));

        String nombreCliente = request.getNombreCliente();  
        procedureParams.setNombClie(nombreCliente);

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        dao.listarTodosClientes(procedureParams);

        if (procedureParams.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
            ClienteListadoResponse response = new ClienteListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
           // response.setCantidad(procedureParams.getCantidad());
           // int numerodePaginas = Util.determinarNroPaginas(response.getCantidad(), headerParams.getCantidadxPag());
            //response.setCantidadPaginas(numerodePaginas);
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }    

    @Override
    public ClienteListadoResponse getDetalleInfoCliente(HeaderParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure parametros = mapper.map(headerParams, ListarClienteProcedure.class);
        ListarClienteProcedure parametros2 = mapper.map(headerParams, ListarClienteProcedure.class);
        ListarClienteProcedure parametros3 = mapper.map(headerParams, ListarClienteProcedure.class);

        Cliente cliente = new Cliente();
        List<Cliente> listaCliente = new ArrayList<>();
        List<OperacionesCredito> listaOperaciones = new ArrayList<>();
        List<GarantiasCredito> listaGarantias = new ArrayList<>();

        Double totalOperSaldoOriginal = 0.00;
        Double totalOperSaldoCapital = 0.00;
        Double totalValorComercial = 0.00;
        String nroCompañia = "";

        String codCliente = request.getCodCliente();
        String nombreCliente = request.getNombreCliente();
        String codTipoDocumento = request.getCodTipoDocumento();
        String nroDocumento = request.getNroDocumento();

        parametros.setCodClie(codCliente);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());

        ClienteListadoResponse response = new ClienteListadoResponse();
        RestTemplate restTemplate = new RestTemplate();
        WSInfoDetalleMovClieResponse jsonMovResponse = new WSInfoDetalleMovClieResponse();

        try {
            // HEADERS PARA LLAMAR AL SERVICIO MOVIMIENTOS X CLIENTE
            HttpHeaders headers = new HttpHeaders();
            headers.add("codUsuario", headerParams.getCodUsuario());
            headers.add("token", headerParams.getToken());
            headers.add("idUsuario", String.valueOf(headerParams.getIdUsuario()));
            HttpEntity entity = new HttpEntity<>(headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SAP_MOVIMIENTOS_CLI, null, null))
                    .queryParam("codClie", request.getCodClieSap());

            jsonMovResponse = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    WSInfoDetalleMovClieResponse.class).getBody();

            dao.listarCodigosOperPorCliente(parametros);

            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                response.setMensaje(parametros.getMensaje());

                //codigos de operacion x cliente
                for (Cliente clienteCodOPER : parametros.getBusqueda()) {
                    String nroOperacion = clienteCodOPER.getNroOperacion();
                    if (StringUtils.isNotEmpty(nroOperacion)) {
                        parametros2.setCodClie(codCliente);
                        parametros2.setCodOpera(nroOperacion);
                        dao.listarOperacionesPorCliente(parametros2);

                        //Lista Operaciones x Cliente
                        if (parametros2.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                            if (parametros2.getBusqueda() != null && parametros2.getBusqueda().size() > 0) {
                                for (Cliente clienteOPER : parametros2.getBusqueda()) {
                                    String codMonDoc = ""; //divisaOrigen(tipoMoneda)

                                    //codigos cia equivalencias
                                    if (clienteOPER.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVEIMPORT)) {//06
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVEIMPORT_SAP; //3000
                                    } else if (clienteOPER.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVECENTER)) {//09
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVECENTER_SAP; //3100
                                    }
                                    OperacionesCredito operCredito = new OperacionesCredito();
                                    operCredito.setNroOperacion(clienteOPER.getNroOperacion());
                                    operCredito.setTipoOperacion(clienteOPER.getTipoOperacion());
                                    operCredito.setFechaOtorgamiento(clienteOPER.getFechaOtorgamiento());
                                    operCredito.setFechaVencimientoUL(clienteOPER.getFechaVencimientoUL());
                                    operCredito.setPlazoDias(clienteOPER.getPlazoDias());
                                    operCredito.setTea(StringUtils.isEmpty(clienteOPER.getTea()) ? 0.00 : Double.parseDouble(clienteOPER.getTea().replace(",", ".")));
                                    operCredito.setRutaCartaBanco(clienteOPER.getRutaCartaBanco());

                                    //Recorrer Movimientos por ClienteSAP, para obtener totales saldos por c/operacion
                                    if (jsonMovResponse != null && jsonMovResponse.getItems() != null) {

                                        for (WSInfoDetalleMovClieResponse.Items.Item it : jsonMovResponse.getItems().getItem()) {
                                            if (it.getClaseDoc().equals("LT") || it.getClaseDoc().equals("MT")) {
                                                if (StringUtils.isEmpty(it.getCodPago())) {
                                                    if (it.getCodRef1().equals(nroOperacion) && it.getCodSociedad().equals(nroCompañia)) {
                                                        //Acumulador SaldosTotales
                                                        totalOperSaldoOriginal = totalOperSaldoOriginal + Double.parseDouble(it.getImpMonDoc());
                                                        if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                                            totalOperSaldoCapital = totalOperSaldoCapital + Double.parseDouble(it.getImpMonDoc());
                                                        }

                                                        codMonDoc = it.getCodMonDoc();
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    operCredito.setDivisa(codMonDoc);
                                    operCredito.setSaldoOriginal(round(totalOperSaldoOriginal, 2));
                                    operCredito.setSaldoVigente(round(totalOperSaldoCapital, 2));
                                    operCredito.setStatus(totalOperSaldoOriginal > 0 ? Constantes.STATUS_VIGENTE : Constantes.STATUS_CERRADO);
                                    operCredito.setRatioCoberturaGara(round(totalOperSaldoCapital, 2));
                                    listaOperaciones.add(operCredito);
                                }
                            }
                        }

                        parametros3.setCodClie(codCliente);
                        parametros3.setCodOpera(nroOperacion);
                        dao.listarGarantiasPorCliente(parametros3);

                        //Lista Garantias x Cliente
                        if (parametros3.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                            if (parametros3.getBusqueda() != null && parametros3.getBusqueda().size() > 0) {
                                for (Cliente clienteGARA : parametros3.getBusqueda()) {
                                    GarantiasCredito garaCredito = new GarantiasCredito();
                                    garaCredito.setCodSoliCred(clienteGARA.getCodSoliCred());
                                    garaCredito.setNroOperacion(clienteGARA.getNroOperacion());
                                    garaCredito.setNroGarantia(clienteGARA.getNroGarantia());
                                    garaCredito.setIndTipoGara(clienteGARA.getIndTipoGara());
                                    garaCredito.setDesTipoGara(clienteGARA.getDesTipoGara());
                                    garaCredito.setCodTipoCred(clienteGARA.getCodTipoCred());
                                    garaCredito.setDesTipoCred(clienteGARA.getDesTipoCred());
                                    garaCredito.setFlagGaraAdic(clienteGARA.getFlagGaraAdic());
                                    garaCredito.setNroPoliza(clienteGARA.getNroPoliza());
                                    garaCredito.setCodEstaPoliza(clienteGARA.getCodEstaPoliza());
                                    garaCredito.setEstadoPoliza(clienteGARA.getEstadoPoliza());
                                    garaCredito.setDivisaOrigen(clienteGARA.getDivisaOrigen());
                                    garaCredito.setValorComercial(round(clienteGARA.getValorComercial(), 2));
                                    garaCredito.setValorRealizacion(round(clienteGARA.getValorRealizacion(), 2));
                                    garaCredito.setFechaConstitucion(clienteGARA.getFechaConstitucion());
                                    garaCredito.setCodMarca(clienteGARA.getCodMarca());
                                    garaCredito.setMarca(clienteGARA.getMarca());
                                    garaCredito.setModelo(clienteGARA.getModelo());
                                    garaCredito.setCodTipoVehi(clienteGARA.getCodTipoVehi());
                                    garaCredito.setNroPlaca(clienteGARA.getNroPlaca());
                                    garaCredito.setValAnoFab(clienteGARA.getValAnoFab());
                                    garaCredito.setCodRangoGara(clienteGARA.getCodRangoGara());
                                    garaCredito.setDesRangoGara(clienteGARA.getDesRangoGara());
                                    garaCredito.setIndInactivo(clienteGARA.getIndInactivo());

                                    totalValorComercial = totalValorComercial + round(clienteGARA.getValorComercial(), 2);

                                    listaGarantias.add(garaCredito);
                                }
                            }
                        }

                    }
                }

                cliente.setCodClie(codCliente);
                cliente.setNombClie(nombreCliente);

                if (StringUtils.isNotEmpty(codTipoDocumento)) {
                    if (codTipoDocumento.equals(Constantes.TIPO_DOC_DNI)) {//DNI
                        cliente.setCodTipoDocumento(Constantes.TIPO_DOC_DNI);
                        cliente.setDni(nroDocumento);

                    } else if (codTipoDocumento.equals(Constantes.TIPO_DOC_RUC)) {//RUC

                        cliente.setCodTipoDocumento(null);
                        cliente.setRuc(nroDocumento);

                    } else {//CE

                        cliente.setCodTipoDocumento(Constantes.TIPO_DOC_CE);
                        //cliente.setCe(nroDocumento);
                    }

                } else {
                    cliente.setCodTipoDocumento(null);
                    cliente.setDni(null);
                    cliente.setRuc(null);
                }

                cliente.setListaOperaciones(listaOperaciones);
                cliente.setListaGarantias(listaGarantias);
                cliente.setTotalSaldoVigenteOPER(round(totalOperSaldoOriginal, 2));
                cliente.setTotalValorComercialGARA(round(totalValorComercial, 2));
                listaCliente.add(cliente);
                response.setListado(listaCliente);

            } else {
                throw new Exception(parametros.getMensaje());

            }

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @Override
    public ClienteListadoResponse listarOperacionesPorCliente(HeaderParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure parametros1 = mapper.map(headerParams, ListarClienteProcedure.class);
        ListarClienteProcedure parametros2 = mapper.map(headerParams, ListarClienteProcedure.class);

        ClienteListadoResponse response = new ClienteListadoResponse();
        List<OperacionesCredito> listaOperaciones = new ArrayList<>();
        List<OperacionesCredito> listaOperacionesFinded = new ArrayList<>();
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente clienteRes = new Cliente();
        //Parametros de Request
        String codCliente = request.getCodCliente();
        String codOperacion = request.getCodOperacion();
        String codTipoOpera = request.getCodTipoCredito();
        String codMoneda = request.getCodMoneda();
        String codEstadoOper = request.getCodEstaOper();
        ////
        Double totalOperSaldoOriginal = 0.00;
        Double totalOperSaldoCapital = 0.00;
        String nroCompañia = "";
        parametros1.setCodClie(codCliente);
        parametros1.setCodOpera(codOperacion);
        parametros1.setCodTipoOpera(codTipoOpera);
        parametros1.setCodMoneda(codMoneda);
        parametros1.setEstadoOpera(codEstadoOper);

        RestTemplate restTemplate = new RestTemplate();
        WSInfoDetalleMovClieResponse jsonMovResponse = new WSInfoDetalleMovClieResponse();

        try {
            // HEADERS PARA LLAMAR AL SERVICIO MOVIMIENTOS X CLIENTE
            HttpHeaders headers = new HttpHeaders();
            headers.add("codUsuario", headerParams.getCodUsuario());
            headers.add("token", headerParams.getToken());
            headers.add("idUsuario", String.valueOf(headerParams.getIdUsuario()));
            HttpEntity entity = new HttpEntity<>(headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SAP_MOVIMIENTOS_CLI, null, null))
                    .queryParam("codClie", request.getCodClieSap());

            jsonMovResponse = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    WSInfoDetalleMovClieResponse.class).getBody();

            dao.listarCodigosOperPorCliente(parametros1);

            if (parametros1.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                response.setEstadoTrama(String.valueOf(parametros1.getStatus()));
                response.setMensaje(parametros1.getMensaje());

                if (parametros1.getBusqueda() != null && parametros1.getBusqueda().size() > 0) {
                    for (Cliente cliente1 : parametros1.getBusqueda()) {
                        String nroOperacion = cliente1.getNroOperacion();

                        parametros2.setCodClie(codCliente);
                        parametros2.setCodOpera(nroOperacion);
                        dao.listarOperacionesPorCliente(parametros2);

                        //Lista Operaciones x Cliente
                        if (parametros2.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                            if (parametros2.getBusqueda() != null && parametros2.getBusqueda().size() > 0) {
                                for (Cliente cliente2 : parametros2.getBusqueda()) {
                                    String codMonDoc = ""; //divisaOrigen(tipoMoneda)

                                    //codigos cia equivalencias
                                    if (cliente2.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVEIMPORT)) {//06
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVEIMPORT_SAP; //3000
                                    } else if (cliente2.getNroCia().equals(Constantes.COD_SOCIEDAD_CIA_DIVECENTER)) {//09
                                        nroCompañia = Constantes.COD_SOCIEDAD_DIVECENTER_SAP; //3100
                                    }
                                    OperacionesCredito operCredito = new OperacionesCredito();
                                    operCredito.setNroOperacion(cliente2.getNroOperacion());
                                    operCredito.setTipoOperacion(cliente2.getTipoOperacion());
                                    operCredito.setFechaOtorgamiento(cliente2.getFechaOtorgamiento());
                                    operCredito.setFechaVencimientoUL(cliente2.getFechaVencimientoUL());
                                    operCredito.setPlazoDias(cliente2.getPlazoDias());
                                    operCredito.setTea(StringUtils.isEmpty(cliente2.getTea()) ? 0.00 : Double.parseDouble(cliente2.getTea().replace(",", ".")));
                                    operCredito.setRutaCartaBanco(cliente2.getRutaCartaBanco()); //url carta banco 

                                    //Recorrer Movimientos por ClienteSAP, para obtener totales saldos por c/operacion
                                    if (jsonMovResponse != null && jsonMovResponse.getItems() != null) {

                                        for (WSInfoDetalleMovClieResponse.Items.Item it : jsonMovResponse.getItems().getItem()) {
                                            if (it.getClaseDoc().equals("LT") || it.getClaseDoc().equals("MT")) {
                                                if (StringUtils.isEmpty(it.getCodPago())) {
                                                    if (it.getCodRef1().equals(nroOperacion) && it.getCodSociedad().equals(nroCompañia)) {
                                                        //Acumulador SaldosTotales
                                                        totalOperSaldoOriginal = totalOperSaldoOriginal + Double.parseDouble(it.getImpMonDoc());
                                                        if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                                            totalOperSaldoCapital = totalOperSaldoCapital + Double.parseDouble(it.getImpMonDoc());
                                                        }

                                                        codMonDoc = it.getCodMonDoc();
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    operCredito.setDivisa(codMonDoc);
                                    operCredito.setSaldoOriginal(round(totalOperSaldoOriginal, 2));
                                    operCredito.setSaldoVigente(round(totalOperSaldoCapital, 2));
                                    operCredito.setStatus(totalOperSaldoOriginal > 0 ? Constantes.STATUS_VIGENTE : Constantes.STATUS_CERRADO);
                                    operCredito.setRatioCoberturaGara(round(totalOperSaldoCapital, 2));
                                    listaOperaciones.add(operCredito);
                                }//for operaciones
                            }
                        }

                    }//for codigosOper
                }//if

                clienteRes.setListaOperaciones(listaOperaciones);
                listaCliente.add(clienteRes);
                response.setListado(listaCliente);

            } else {
                throw new Exception(parametros1.getMensaje());
            }

        } catch (Exception ex) {
            response = new ClienteListadoResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @Override
    public ClienteListadoResponse listarGarantiasPorCliente(HeaderParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure parametros = mapper.map(headerParams, ListarClienteProcedure.class);
        ClienteListadoResponse response = new ClienteListadoResponse();
        List<GarantiasCredito> listaGarantias = new ArrayList<>();
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente clienteRes = new Cliente();

        String codCliente = request.getCodCliente();
        String codTipoCredito = request.getCodTipoCredito();
        String estadoGarantia = request.getEstadoGarantia();
        String tipoGarantia = request.getTipoGarantia();
        String codMarca = request.getCodMarca();
        String nroSoliCred = request.getNroSolicitud();
        String anioFab = request.getAnioFabricacion();

        parametros.setCodClie(codCliente);
        parametros.setCodTipoCredSoli(codTipoCredito);
        parametros.setEstadoGara(estadoGarantia);
        parametros.setCodMarca(codMarca);
        parametros.setCodSoliCred(nroSoliCred);
        parametros.setAnioFabricacion(anioFab);

        if (StringUtils.isNotEmpty(tipoGarantia)) {
            if (tipoGarantia.equals("Hipotecaria")) {
                parametros.setTipoGara("H");
            } else {
                parametros.setTipoGara("M");
            }
        } else {
            parametros.setTipoGara(tipoGarantia);
        }

        dao.listarGarantiasPorCliente(parametros);

        if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());

            if (parametros.getBusqueda() != null && parametros.getBusqueda().size() > 0) {
                for (Cliente cliente : parametros.getBusqueda()) {
                    GarantiasCredito garaCredito = new GarantiasCredito();
                    garaCredito.setCodSoliCred(cliente.getCodSoliCred());
                    garaCredito.setNroOperacion(cliente.getNroOperacion());
                    garaCredito.setNroGarantia(cliente.getNroGarantia());
                    garaCredito.setIndTipoGara(cliente.getIndTipoGara());
                    garaCredito.setDesTipoGara(cliente.getDesTipoGara());
                    garaCredito.setCodTipoCred(cliente.getCodTipoCred());
                    garaCredito.setDesTipoCred(cliente.getDesTipoCred());
                    garaCredito.setFlagGaraAdic(cliente.getFlagGaraAdic());
                    garaCredito.setNroPoliza(cliente.getNroPoliza());
                    garaCredito.setCodEstaPoliza(cliente.getCodEstaPoliza());
                    garaCredito.setEstadoPoliza(cliente.getEstadoPoliza());
                    garaCredito.setDivisaOrigen(cliente.getDivisaOrigen());
                    garaCredito.setValorComercial(round(cliente.getValorComercial(), 2));
                    garaCredito.setValorRealizacion(round(cliente.getValorRealizacion(), 2));
                    garaCredito.setFechaConstitucion(cliente.getFechaConstitucion());
                    garaCredito.setCodMarca(cliente.getCodMarca());
                    garaCredito.setMarca(cliente.getMarca());
                    garaCredito.setModelo(cliente.getModelo());
                    garaCredito.setCodTipoVehi(cliente.getCodTipoVehi());
                    garaCredito.setNroPlaca(cliente.getNroPlaca());
                    garaCredito.setValAnoFab(cliente.getValAnoFab());
                    garaCredito.setCodRangoGara(cliente.getCodRangoGara());
                    garaCredito.setDesRangoGara(cliente.getDesRangoGara());
                    garaCredito.setIndInactivo(cliente.getIndInactivo());
                    garaCredito.setMismaUnidad(cliente.getMismaUnidad());
                    garaCredito.setEstadoGara(cliente.getEstadoGara());

                    listaGarantias.add(garaCredito);
                }

                clienteRes.setListaGarantias(listaGarantias);
                listaCliente.add(clienteRes);
                response.setListado(listaCliente);
            }

            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }

    }

    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public ClienteResponse exportarCliente(HeaderPaginadoParams headerParams, Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseResponse validarGarantiaCliente(HeaderParams headerParams, ClienteRequest request) throws Exception {
        ListarClienteProcedure parametros = mapper.map(headerParams, ListarClienteProcedure.class);

        String codCliente = request.getCodCliente();
        String codOperacion = request.getCodOperacion();
        String codCia = request.getCodCia();
        String codGarantia = request.getCodGarantia();

        Double totalOperSaldoOriginal = 0.00;
        Double totalOperSaldoCapital = 0.00;
        Double totalValorComercial = 0.00;
        Double totalValorRealizable = 0.00;
        String nroCompañia = "";

        if (codCia.equals(Constantes.COD_SOCIEDAD_CIA_DIVEIMPORT)) {//06
            nroCompañia = Constantes.COD_SOCIEDAD_DIVEIMPORT_SAP; //3000
        } else if (codCia.equals(Constantes.COD_SOCIEDAD_CIA_DIVECENTER)) {//09
            nroCompañia = Constantes.COD_SOCIEDAD_DIVECENTER_SAP; //3100
        }

        BaseResponse response = new BaseResponse();
        RestTemplate restTemplate = new RestTemplate();
        WSInfoDetalleMovClieResponse jsonMovResponse = new WSInfoDetalleMovClieResponse();

        try {
            // HEADERS PARA LLAMAR AL SERVICIO MOVIMIENTOS X CLIENTE
            HttpHeaders headers = new HttpHeaders();
            headers.add("codUsuario", headerParams.getCodUsuario());
            headers.add("token", headerParams.getToken());
            headers.add("idUsuario", String.valueOf(headerParams.getIdUsuario()));
            HttpEntity entity = new HttpEntity<>(headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SAP_MOVIMIENTOS_CLI, null, null))
                    .queryParam("codClie", request.getCodClieSap());

            jsonMovResponse = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    WSInfoDetalleMovClieResponse.class).getBody();

            //Recorrer Movimientos por ClienteSAP, para obtener totales saldos por c/operacion
            if (jsonMovResponse != null && jsonMovResponse.getItems() != null) {

                for (WSInfoDetalleMovClieResponse.Items.Item it : jsonMovResponse.getItems().getItem()) {
                    if (it.getClaseDoc().equals("LT") || it.getClaseDoc().equals("MT")) {
                        if (StringUtils.isEmpty(it.getCodPago())) {
                            if (it.getCodRef1().equals(codOperacion) && it.getCodSociedad().equals(nroCompañia)) {
                                //Acumulador SaldosTotales
                                totalOperSaldoOriginal = totalOperSaldoOriginal + Double.parseDouble(it.getImpMonDoc());
                                if (StringUtils.isEmpty(it.getNumDocComp()) && StringUtils.isEmpty(it.getFecComp())) {
                                    totalOperSaldoCapital = totalOperSaldoCapital + Double.parseDouble(it.getImpMonDoc());
                                }

                            }
                        }
                    }
                }
            }

            parametros.setCodClie(codCliente);
            parametros.setCodOpera(codOperacion);
            dao.listarGarantiasPorCliente(parametros);

            //Lista Garantias x Cliente
            if (parametros.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
                if (parametros.getBusqueda() != null && parametros.getBusqueda().size() > 0) {
                    for (Cliente clienteGARA : parametros.getBusqueda()) {
                        if (clienteGARA.getNroGarantia().equals(codGarantia)) {
                            totalValorComercial = round(clienteGARA.getValorComercial(), 2);
                            totalValorRealizable = round(clienteGARA.getValorRealizacion(), 2);
                            break;
                        }
                    }
                }
            }

            Double valorEvaluar = round(totalValorRealizable / totalOperSaldoOriginal, 2);

            if (valorEvaluar > 1) {

                response.setEstadoTrama(String.valueOf(Constantes.ESTADO_TRAMA_OK));
                response.setMensaje(Constantes.RESPUESTA_RATIO_GARA_OK);

            } else {
                response.setEstadoTrama(String.valueOf(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO));
                response.setMensaje(Constantes.RESPUESTA_RATIO_GARA_FAIL);
            }

        } catch (Exception ex) {
            response = new BaseResponse();
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }

        return response;

    }

    @Override
    public BaseResponse updateGarantia(HeaderParams headerParams, ClienteRequest request) throws Exception {
        ActualizarGarantiaProcedure parametros = mapper.map(headerParams, ActualizarGarantiaProcedure.class);
        parametros.setCodSoliCred(request.getNroSolicitud());
        parametros.setCodGarantia(request.getCodGarantia());
        parametros.setCodClie(request.getCodCliente());

        dao.updateGarantia(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    /* Req Obs Consulta Cliente MBardales 16/10/2020 */
    
    @Override
    public MaestroListadoResponse listarPaises(HeaderParams headerParams, String tipo) throws Exception {
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        dao.listarPaises(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public MaestroListadoResponse listarDepartamentos(HeaderParams headerParams, String tipo) throws Exception {
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        dao.listarDepartamentos(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public MaestroListadoResponse listarProvincias(HeaderParams headerParams, String tipo) throws Exception {
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        dao.listarProvincias(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public MaestroListadoResponse listarDistritos(HeaderParams headerParams, String tipo) throws Exception {
        ListarMaestroProcedure parametros = mapper.map(headerParams, ListarMaestroProcedure.class);
        parametros.setTipo(tipo);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        dao.listarDistritos(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            MaestroListadoResponse response = new MaestroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

}
