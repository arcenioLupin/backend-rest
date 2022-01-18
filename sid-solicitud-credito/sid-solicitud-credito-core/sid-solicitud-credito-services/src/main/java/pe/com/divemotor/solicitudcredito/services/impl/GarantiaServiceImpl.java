package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.GarantiaService;
import pe.com.divemotor.solicitudcredito.dao.GarantiaDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ConsultarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.InsertarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDepartamentosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDistritosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasHistoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarPaisesGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarProvinciasGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CoberturaGarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaHistoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;


@Service
@Transactional
public class GarantiaServiceImpl implements GarantiaService {

    private GarantiaDAO garantiaDAO;
    private Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setGarantiaDAO(GarantiaDAO garantiaDAO) {
        this.garantiaDAO = garantiaDAO;
    }
    
    @Transactional(readOnly = true)
    @Override
    public GarantiaListadoResponse listar(HeaderParams headerParams, String codSoliCred, String indTipoGarantia) throws Exception {
	ListarGarantiasProcedure parametros = mapper.map(headerParams, ListarGarantiasProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndTipoGarantia(indTipoGarantia);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            GarantiaListadoResponse response = new GarantiaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
    @Override
    public GarantiaResponse insertar(HeaderParams headerParams, GarantiaRequest request) throws Exception {
        InsertarGarantiaProcedure procedureParams = new InsertarGarantiaProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred()!=null?request.getCodSoliCred():"");
        procedureParams.setCodGarantia(request.getCodGarantia()!=null?request.getCodGarantia():"");
        procedureParams.setIndTipoGarantia(request.getIndTipoGarantia()!=null?request.getIndTipoGarantia():"");
        procedureParams.setIndTipoBien(request.getIndTipoBien()!=null?request.getIndTipoBien():"");
        procedureParams.setIndOtor(request.getIndOtor()!=null?request.getIndOtor():"");
        procedureParams.setCodPersProp(request.getCodPersProp()!=null?request.getCodPersProp():"");
        procedureParams.setCodMarca(request.getCodMarca()!=null?request.getCodMarca():"");
        procedureParams.setTxtMarca(request.getTxtMarca()!=null?request.getTxtMarca():"");
        procedureParams.setTxtModelo(request.getTxtModelo()!=null?request.getTxtModelo():"");
        procedureParams.setCodTipoVeh(request.getCodTipoVeh()!=null?request.getCodTipoVeh():"");
        procedureParams.setNroMotor(request.getNroMotor()!=null?request.getNroMotor():"");
        procedureParams.setTxtCarroceria(request.getTxtCarroceria()!=null?request.getTxtCarroceria():"");
        procedureParams.setFecFabConst(request.getFecFabConst()!=null?request.getFecFabConst():"");
        procedureParams.setNroChasis(request.getNroChasis()!=null?request.getNroChasis():"");
        procedureParams.setValNroRango(request.getValNroRango()!=null?request.getValNroRango():"");
        procedureParams.setNroPlaca(request.getNroPlaca()!=null?request.getNroPlaca():"");
        procedureParams.setTipoActividad(request.getTipoActividad()!=null?request.getTipoActividad():"");
        procedureParams.setValConstGar(request.getValConstGar());
        procedureParams.setValRealizGar(request.getValRealizGar());
        procedureParams.setCodOfRegistral(request.getCodOfRegistral());
        procedureParams.setValAnosDeprec(request.getValAnosDeprec()!=null?request.getValAnosDeprec():"");
        procedureParams.setCodMoneda(request.getCodMoneda()!=null?request.getCodMoneda():"");
        procedureParams.setDesDescripcion(request.getDesDescripcion()!=null?request.getDesDescripcion():"");
        procedureParams.setIndAdicional(request.getIndAdicional()!=null?request.getIndAdicional():"");
        procedureParams.setNumTituloRpv(request.getNumTituloRpv()!=null?request.getNumTituloRpv():"");
        procedureParams.setNroTarjPropVeh(request.getNroTarjPropVeh()!=null?request.getNroTarjPropVeh():"");
        procedureParams.setNroPartida(request.getNroPartida()!=null?request.getNroPartida():"");
        procedureParams.setIndRegMobContratos(request.getIndRegMobContratos()!=null?request.getIndRegMobContratos():"");
        procedureParams.setIndRegJurBien(request.getIndRegJurBien()!=null?request.getIndRegJurBien():"");
        procedureParams.setTxtInfoModGar(request.getTxtInfoModGar()!=null?request.getTxtInfoModGar():"");
        procedureParams.setIndRatificaGar(request.getIndRatificaGar()!=null?request.getIndRatificaGar():"");
        procedureParams.setValNvoMonto(request.getValNvoMonto());
        procedureParams.setValNvoVal(request.getValNvoVal());
        procedureParams.setValMontOtorHip(request.getValMontOtorHip());
        procedureParams.setTxtDireccion(request.getTxtDireccion()!=null?request.getTxtDireccion():"");
        procedureParams.setCodDistrito(request.getCodDistrito()!=null?request.getCodDistrito():"");
        procedureParams.setCodProvincia(request.getCodProvincia()!=null?request.getCodProvincia():"");
        procedureParams.setCodDepartamento(request.getCodDepartamento()!=null?request.getCodDepartamento():"");
        procedureParams.setCodCliente(request.getCodCliente()!=null?request.getCodCliente():"");
        procedureParams.setValAnoFab(request.getValAnoFab()!=null?request.getValAnoFab():"");
        procedureParams.setNumPedidoVeh(request.getNumPedidoVeh()!=null?request.getNumPedidoVeh():"");
        procedureParams.setNuevo(request.getNuevo()!=null?request.getNuevo():"");
        procedureParams.setIndSegDive(request.getIndSegDive());
        procedureParams.setIndPreConstMob(request.getIndPreConstMob());
        // SE AGREGAN CAMPOS NUEVOS
        procedureParams.setNumAsiento(request.getNumAsiento());
        procedureParams.setCodTipoFamilia(request.getCodTipoFamilia());
        
//        procedureParams.setCodDocuEval(request.getCodDocuEval());
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        garantiaDAO.insertar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            GarantiaResponse response = new GarantiaResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setCodGarantiaOut(procedureParams.getCodGarantiaOut());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }

    }
    
    @Transactional(readOnly = true)
    @Override
    public GarantiaHistoListadoResponse listarHistorico(HeaderParams headerParams, String codSoliCred, String indTipoGarantia, String codCliente, String numPedidoVeh) throws Exception {
	ListarGarantiasHistoProcedure parametros = mapper.map(headerParams, ListarGarantiasHistoProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndTipoGarantia(indTipoGarantia);
        parametros.setNumPedidoVeh(numPedidoVeh);
        parametros.setCodCliente(codCliente);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listarHistorico(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            GarantiaHistoListadoResponse response = new GarantiaHistoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
    @Transactional(readOnly = true)
    @Override
    public BaseResponse eliminar(HeaderParams headerParams, GarantiaRequest request) throws Exception {
        InsertarGarantiaProcedure procedureParams = new InsertarGarantiaProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setListaGarantias(request.getListaGarantias());
        procedureParams.setListaGarantiasEliminadas(request.getListaGarantiasEliminadas());
        procedureParams.setIndTipoGarantia(request.getIndTipoGarantia());
        mapper.map(headerParams, procedureParams);
        garantiaDAO.eliminar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }
    }
    
    @Transactional(readOnly = true)
    @Override
    public BaseResponse eliminarByGara(HeaderParams headerParams, GarantiaRequest request) throws Exception {
        InsertarGarantiaProcedure procedureParams = new InsertarGarantiaProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setCodGarantia(request.getCodGarantia());
        procedureParams.setIndTipoGarantia(request.getIndTipoGarantia());
        
        mapper.map(headerParams, procedureParams);
        garantiaDAO.eliminarByGara(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }
    }
    
    @Override
    public PaisListadoResponse listarPaises(HeaderParams headerParams, String codCia) throws Exception {
        ListarPaisesGarantiaProcedure parametros = mapper.map(headerParams, ListarPaisesGarantiaProcedure.class);
        parametros.setCodCia(codCia);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listarPaises(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            PaisListadoResponse response = new PaisListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public DepartamentoListadoResponse listarDepartamentos(HeaderParams headerParams, String codPais) throws Exception {
        ListarDepartamentosGarantiaProcedure parametros = mapper.map(headerParams, ListarDepartamentosGarantiaProcedure.class);
        parametros.setCodPais(codPais);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listarDepartamentos(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DepartamentoListadoResponse response = new DepartamentoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public ProvinciaListadoResponse listarProvincias(HeaderParams headerParams, String codDepa) throws Exception {
        ListarProvinciasGarantiaProcedure parametros = mapper.map(headerParams, ListarProvinciasGarantiaProcedure.class);
        parametros.setCodDepa(codDepa);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listarProvincias(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ProvinciaListadoResponse response = new ProvinciaListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }

    @Override
    public DistritoListadoResponse listarDistritos(HeaderParams headerParams, String codProv,String codDepa) throws Exception {
        ListarDistritosGarantiaProcedure parametros = mapper.map(headerParams, ListarDistritosGarantiaProcedure.class);
        parametros.setCodProv(codProv);
        parametros.setCodDepa(codDepa);// Req. 87567 E2.1 ID avilca 03/06/2020
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.garantiaDAO.listarDistritos(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DistritoListadoResponse response = new DistritoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }

    }
    
    // <I> 90690 ivelasquez 21/09/2021
    @Override
    public BaseResponse consultarGarantias(HeaderParams headerParams, String codSoliCred) throws Exception {
        ConsultarGarantiasProcedure procedureParams = new ConsultarGarantiasProcedure();
        procedureParams.setCodSoliCred(codSoliCred);
        mapper.map(headerParams, procedureParams);
        
        garantiaDAO.consultarGarantias(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setCodigo(String.valueOf(procedureParams.getCantidad()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    // <F> 90690 ivelasquez 21/09/2021
    
    // <I> 89645 ivelasquez 22/09/2021
    @Override
    public CoberturaGarantiaResponse listarCoberturaGarantia(HeaderParams headerParams, String codSoliCred)  {
      
         CoberturaGarantiaResponse response = new CoberturaGarantiaResponse();
        try {           
            ListarCoberturaGarantiaProcedure parametrosCobertura = mapper.map(headerParams, ListarCoberturaGarantiaProcedure.class);
            parametrosCobertura.setCodSoliCred(codSoliCred);
            this.garantiaDAO.listarCoberturaGarantia(parametrosCobertura);
            
            Integer statusQuery = parametrosCobertura.getStatus();
            if (statusQuery.equals(1)) {                
                response.setEstadoTrama(String.valueOf(parametrosCobertura.getStatus()));
                response.setMensaje(parametrosCobertura.getMensaje());
                response.setBusqueda(parametrosCobertura.getBusqueda());
                return response;
            } else {
                try {
                    throw new Exception(parametrosCobertura.getMensaje());
                } catch (Exception ex) {
                    Logger.getLogger(GarantiaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GarantiaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return response;
    }
    // <F> 89645 ivelasquez 22/09/2021
}
