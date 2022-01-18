package pe.com.divemotor.solicitudcredito.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.AvalDAO;
import pe.com.divemotor.solicitudcredito.dominio.Aval;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.EliminarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.InsertarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDepartamentosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDistritosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarPaisesAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarProvinciasAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.AvalRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AvalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.AvalService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

@Service
@Transactional
public class AvalServiceImpl implements AvalService {

    private AvalDAO avalDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setAvalDAO(AvalDAO avalDAO) {
        this.avalDAO = avalDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public AvalListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception {

        ListarAvalProcedure parametros = mapper.map(headerParams, ListarAvalProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            AvalListadoResponse response = new AvalListadoResponse();
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
    public AvalListadoResponse listarAvalesHistorico(HeaderParams headerParams, String codSoliCred) throws Exception {

        ListarAvalProcedure parametros = mapper.map(headerParams, ListarAvalProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listarAvalesHistorico(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            AvalListadoResponse response = new AvalListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
    
    @Override
    public BaseResponse insertar(HeaderParams headerParams, AvalRequest request) throws Exception {
        InsertarAvalProcedure procedureParams = new InsertarAvalProcedure();
        String codSoliCred = request.getCodSoliCred();
        String direccion = request.getTxtdireccion() == null?"":request.getTxtdireccion();
        String codDepartamento = request.getCoddepartamento() == null?"":request.getCoddepartamento();
        String codProvincia = request.getCodprovincia()== null?"":request.getCodprovincia();
        String codDistrito= request.getCoddistrito()== null?"":request.getCoddistrito();
        
        procedureParams.setCodSoliCred(codSoliCred);
        procedureParams.setCodperaval(request.getCodperaval());
        procedureParams.setIndtipopersona(request.getIndtipopersona());
        procedureParams.setIndestadocivil(request.getIndestadocivil());
        procedureParams.setIndtiporelacion(request.getIndtiporelacion());

        procedureParams.setCodmoneda(request.getCodmoneda());

        if (StringUtils.isNotEmpty(request.getValmontofianza())) {
            procedureParams.setValmontofianza(Double.parseDouble(request.getValmontofianza()));
        }

        if (StringUtils.isNotEmpty(request.getCoddepartamento())) {
            procedureParams.setCoddepartamento(Integer.parseInt(request.getCoddepartamento()));
        }
        if (StringUtils.isNotEmpty(request.getCodprovincia())) {
            procedureParams.setCodprovincia(Integer.parseInt(request.getCodprovincia()));
        }
        if (StringUtils.isNotEmpty(request.getCoddistrito())) {
            procedureParams.setCoddistrito(Integer.parseInt(request.getCoddistrito()));
        }

        procedureParams.setTxtdireccion(request.getTxtdireccion());
        procedureParams.setCodempr(request.getCodempr());
        procedureParams.setCodpais(request.getCodpais());
        procedureParams.setCodzona(request.getCodzona());
        procedureParams.setTxtnombpers(request.getTxtnombpers());
        procedureParams.setTxtapelpatepers(request.getTxtapelpatepers());
        procedureParams.setTxtapelmatepers(request.getTxtapelmatepers());
        procedureParams.setCodperrelaval(request.getCodperrelaval());
        procedureParams.setTxtdoi(request.getTxtdoi());
        procedureParams.setAvalHisto(request.getAvalHisto());
        procedureParams.setCodTipoOtor(request.getCodTipoOtor());
        procedureParams.setTelefono(request.getTelefono()); // I Req. 87567 E1.1 ID 53 AVILCA 12/11/2020
        procedureParams.setFlagCopropEliminado(request.getFlagCopropEliminado());

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        avalDAO.insertar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        String codAvalPadre = procedureParams.getCodperavalret();
        if (statusQuery.equals(Constantes.ESTADO_TRAMA_OK)) {
            BaseResponse response = new BaseResponse();
            response.setCodigo(procedureParams.getCodperavalret());
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            if (request.getListaAvalCopropietarios() != null && request.getListaAvalCopropietarios().size() > 0) {
                for (Aval aval : request.getListaAvalCopropietarios()) {
                    InsertarAvalProcedure procedureParams2 = new InsertarAvalProcedure();
                    procedureParams2.setCodperaval(aval.getCodperaval());
                    procedureParams2.setCodperrelaval(codAvalPadre);
                    procedureParams2.setCodSoliCred(codSoliCred);
                    procedureParams2.setCodpais(aval.getIdPais());
                    procedureParams2.setCodmoneda(aval.getIdMoneda());
                    procedureParams2.setTxtnombpers(aval.getNombres());
                    procedureParams2.setTxtapelpatepers(aval.getApellidoPaterno());
                    procedureParams2.setTxtapelmatepers(aval.getApellidoMaterno());
                    procedureParams2.setIndtipopersona(aval.getIdTipoPersona());
                    procedureParams2.setIndtiporelacion(aval.getIdTipoRelacion());
                    procedureParams2.setTxtdoi(aval.getDocumentoIdentidad());
                    procedureParams2.setAvalHisto(request.getAvalHisto());
                   // I Req. 87567 E1.1 ID 53 AVILCA 01/10/2020
                    if(!aval.getIdEstadoCivil().equals("S")){
                        procedureParams2.setTxtdireccion(direccion);
                       if (StringUtils.isNotEmpty(codDepartamento)) {
                          procedureParams2.setCoddepartamento(Integer.parseInt(codDepartamento));
                        }
                       if (StringUtils.isNotEmpty(codProvincia)) {
                          procedureParams2.setCodprovincia(Integer.parseInt(codProvincia));
                         }
                       if (StringUtils.isNotEmpty(codDistrito)) {
                        procedureParams2.setCoddistrito(Integer.parseInt(codDistrito));
                        }
                       
                        if(aval.getIdEstadoCivil().equals("C")){
                       // I Req. 87567 E1.1 ID 53 AVILCA 12/11/2020
                        procedureParams2.setIndestadocivil(aval.getIdEstadoCivil());
                        procedureParams2.setTelefono(aval.getTelefono());
                       // F Req. 87567 E1.1 ID 53 AVILCA 12/11/2020
                        }
                    }

                    // F Req. 87567 E1.1 ID 53 AVILCA 01/10/2020
                    
                    // I Req. 87567 E1.1 ID 53 AVILCA 12/11/2020
                    procedureParams2.setCodzona(aval.getIdZona());
                    // F Req. 87567 E1.1 ID 53 AVILCA 12/11/2020
                    procedureParams2.setFlagCopropEliminado(aval.getFlagCopropEliminado());
                    mapper.map(headerParams, procedureParams2);
                    avalDAO.insertar(procedureParams2);
                    if (procedureParams2.getStatus().equals(Constantes.ESTADO_TRAMA_ERROR_PROCEDURE)) {
                        throw new Exception(procedureParams2.getMensaje());
                    }
                }
            }
            
           if (request.getListaCopropietariosEliminados() != null && request.getListaCopropietariosEliminados().size() > 0) {
                for (Aval aval : request.getListaCopropietariosEliminados()) {
                    InsertarAvalProcedure procedureParam3 = new InsertarAvalProcedure();
                    procedureParam3.setCodperaval(aval.getCodperaval());
                    procedureParam3.setCodperrelaval(codAvalPadre);
                    procedureParam3.setCodSoliCred(codSoliCred);
                    procedureParam3.setCodpais(aval.getIdPais());
                    procedureParam3.setCodmoneda(aval.getIdMoneda());
                    procedureParam3.setTxtnombpers(aval.getNombres());
                    procedureParam3.setTxtapelpatepers(aval.getApellidoPaterno());
                    procedureParam3.setTxtapelmatepers(aval.getApellidoMaterno());
                    procedureParam3.setIndtipopersona(aval.getIdTipoPersona());
                    procedureParam3.setIndtiporelacion(aval.getIdTipoRelacion());
                    procedureParam3.setTxtdoi(aval.getDocumentoIdentidad());
                    procedureParam3.setAvalHisto(request.getAvalHisto());
                    procedureParam3.setFlagCopropEliminado(aval.getFlagCopropEliminado());
                    procedureParam3.setTxtdireccion(direccion);
                    if (StringUtils.isNotEmpty(codDepartamento)) {
                          procedureParam3.setCoddepartamento(Integer.parseInt(codDepartamento));
                        }
                    if (StringUtils.isNotEmpty(codProvincia)) {
                          procedureParam3.setCodprovincia(Integer.parseInt(codProvincia));
                         }
                    if (StringUtils.isNotEmpty(codDistrito)) {
                        procedureParam3.setCoddistrito(Integer.parseInt(codDistrito));
                     }
                       
                   
                    procedureParam3.setCodzona(aval.getIdZona());

                    mapper.map(headerParams, procedureParam3);
                    avalDAO.insertar(procedureParam3);
                    if (procedureParam3.getStatus().equals(Constantes.ESTADO_TRAMA_ERROR_PROCEDURE)) {
                        throw new Exception(procedureParam3.getMensaje());
                    }
                }
            }            
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }

    }

    @Transactional(readOnly = true)
    @Override
    public BaseResponse eliminar(HeaderParams headerParams, AvalRequest request) throws Exception {
        InsertarAvalProcedure procedureParams = new InsertarAvalProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setListaAvales(request.getListaAvales());
        procedureParams.setTipo(request.getTipo());
        mapper.map(headerParams, procedureParams);
        avalDAO.eliminar(procedureParams);

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
    public BaseResponse eliminarbyaval(HeaderParams headerParams, AvalRequest request) throws Exception {
        EliminarAvalProcedure procedureParams = new EliminarAvalProcedure();
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setCodperaval(request.getCodperaval());
        mapper.map(headerParams, procedureParams);
        avalDAO.eliminarbyaval(procedureParams);

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
        ListarPaisesAvalProcedure parametros = mapper.map(headerParams, ListarPaisesAvalProcedure.class);
        parametros.setCodCia(codCia);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listarPaises(parametros);

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
        ListarDepartamentosAvalProcedure parametros = mapper.map(headerParams, ListarDepartamentosAvalProcedure.class);
        parametros.setCodPais(codPais);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listarDepartamentos(parametros);

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
        ListarProvinciasAvalProcedure parametros = mapper.map(headerParams, ListarProvinciasAvalProcedure.class);
        parametros.setCodDepa(codDepa);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listarProvincias(parametros);

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
    public DistritoListadoResponse listarDistritos(HeaderParams headerParams, String codProv) throws Exception {
        ListarDistritosAvalProcedure parametros = mapper.map(headerParams, ListarDistritosAvalProcedure.class);
        parametros.setCodProv(codProv);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.avalDAO.listarDistritos(parametros);

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

}
