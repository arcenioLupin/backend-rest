package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.Map;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;
import pe.com.divemotor.solicitudcredito.services.DocumentoService;
import pe.com.divemotor.solicitudcredito.dao.DocumentoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoRequest;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    private DocumentoDAO documentoDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setEventoDAO(DocumentoDAO documentoDAO) {
        this.documentoDAO = documentoDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public DocumentoListadoResponse listar(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndMancomunado(indMancomunado);
        parametros.setCodEstadoCivil(codEstadoCivil);
        parametros.setCodTipoPerso(codTipoPerso);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.documentoDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
//---I-90028:Dante Artica
    @Transactional(readOnly = true)
    @Override
    public DocumentoListadoResponse listarTiposDocumeto(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndMancomunado(indMancomunado);
        parametros.setCodTipoPerso(codTipoPerso);  
        parametros.setCodEstadoCivil(codEstadoCivil);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.documentoDAO.listarTiposDocumeto(parametros);
        
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
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
    public DocumentoListadoResponse listarAdjuntosAnteriores(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndMancomunado(indMancomunado);
        parametros.setCodTipoPerso(codTipoPerso);  
        parametros.setCodEstadoCivil(codEstadoCivil);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.documentoDAO.listarAdjuntosAnteriores(parametros);
        
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
    
//---F-90028:Dante Artica    
    @Override
    public BaseResponse actualizar(HeaderParams headerParams, DocumentoRequest request) throws Exception {
        ActualizarDocumentoProcedure procedureParams = new ActualizarDocumentoProcedure();
        procedureParams.setCodDocuEval(request.getCodDocuEval());
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setTxtRutaDoc(request.getTxtRutaDoc());
        procedureParams.setFecEmisDoc(request.getFecEmisDoc());
          //<!--I-90028-->
        procedureParams.setCodSecArchivo(request.getCodSecArchivo());
        procedureParams.setTxtDesArchivo(request.getTxtDesArchivo());
           //<!--F-90028-->
        procedureParams.setOperacion("A");

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        documentoDAO.actualizar(procedureParams);

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
    public BaseResponse eliminar(HeaderParams headerParams, DocumentoRequest request) throws Exception {
        ActualizarDocumentoProcedure procedureParams = new ActualizarDocumentoProcedure();
        procedureParams.setCodDocuEval(request.getCodDocuEval());
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        //--I-90028:Dante Artica
        procedureParams.setCodSecArchivo(request.getCodSecArchivo());
        //--F-90028:Dante Artica
//        procedureParams.setTxtRutaDoc(request.getTxtRutaDoc());
//        procedureParams.setFecEmisDoc(request.getFecEmisDoc());
        procedureParams.setOperacion("E");

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        documentoDAO.actualizar(procedureParams);

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
    public DocumentoListadoResponse listarGeneral(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil, String tipoDocu, String codProceso, String indTipoDocu) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setIndMancomunado(indMancomunado);
        parametros.setCodEstadoCivil(codEstadoCivil);
        parametros.setCodTipoPerso(codTipoPerso);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        //genericos
        parametros.setTipoDocu(tipoDocu);
        parametros.setIndTipoDocu(indTipoDocu);
        parametros.setCodigoProceso(codProceso);
        this.documentoDAO.listarGeneral(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }

    @Override
    public BaseResponse actualizarGeneral(HeaderParams headerParams, DocumentoRequest request) throws Exception {
        ActualizarDocumentoProcedure procedureParams = new ActualizarDocumentoProcedure();
        procedureParams.setCodDocuEval(request.getCodDocuEval());
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setTxtRutaDoc(request.getTxtRutaDoc());
        procedureParams.setFecEmisDoc(request.getFecEmisDoc());
        procedureParams.setCodProceso(request.getCodProceso());
        procedureParams.setTipoDocu(request.getTipoDocu());
        procedureParams.setOperacion("A");

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        documentoDAO.actualizarGeneral(procedureParams);

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
    public BaseResponse eliminarGeneral(HeaderParams headerParams, DocumentoRequest request) throws Exception {
        ActualizarDocumentoProcedure procedureParams = new ActualizarDocumentoProcedure();
        procedureParams.setCodDocuEval(request.getCodDocuEval());
        procedureParams.setCodUsuario(headerParams.getCodUsuario());
        procedureParams.setCodSoliCred(request.getCodSoliCred());
        procedureParams.setCodProceso(request.getCodProceso());
        procedureParams.setTipoDocu(request.getTipoDocu());
        procedureParams.setOperacion("E");

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        documentoDAO.actualizarGeneral(procedureParams);

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
    public DocumentoListadoResponse listarConsulta(HeaderPaginadoParams headerParams, DocumentoRequest request) throws Exception {
        ListarDocumentosProcedure procedureParams = new ListarDocumentosProcedure();
        Map<String, Integer> limites = Util.determinarLimites(headerParams.getNroPag(), headerParams.getCantidadxPag());
        procedureParams.setLiminf(limites.get("liminf"));
        procedureParams.setLimsup(limites.get("limsup"));

        String desDocuEval = request.getDesDocuEval();
        String indTipoDocu = request.getIndTipoDocu();
        String indInactivo = request.getIndInactivo();
        String indOblig = request.getIndOblig();

        procedureParams.setDesDocuEval(desDocuEval);
        procedureParams.setIndTipoDocu(indTipoDocu);
        procedureParams.setIndInactivo(indInactivo);
        procedureParams.setIndOblig(indOblig);

        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);

        documentoDAO.listarConsulta(procedureParams);

        if (procedureParams.getStatus().equals(Constantes.ESTADO_TRAMA_OK)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            response.setListado(procedureParams.getBusqueda());
            response.setCantidad(procedureParams.getRetCantidad());
            int numerodePaginas = Util.determinarNroPaginas(response.getCantidad(), headerParams.getCantidadxPag());
            response.setCantidadPaginas(numerodePaginas);
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());
        }
    }
    
    @Override
    public BaseResponse actualizarDocumento(HeaderParams headerParams, DocumentoRequest request) throws Exception {
        ActualizarDocumentoProcedure parametros = mapper.map(headerParams, ActualizarDocumentoProcedure.class);

        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        
        /*I Req. 87567 E2.1 ID## avilca 23/11/2020*/
        parametros.setCodDocuEval(request.getCodDocuEval());
        parametros.setIndOblig(request.getIndOblig());
        parametros.setIndObligatorioLegal(request.getIndObligatorioLegal());
        parametros.setIndInactivo(request.getIndInactivo());
        parametros.setDesDocuEval(request.getDesDocuEval());
        parametros.setTipoDocu(request.getIndTipoDocu());
        parametros.setCodDocuLegal(request.getCodDocuLegal());
        parametros.setCodDocLegal(request.getCodDocLegal());
        parametros.setValDiasVig(request.getValDiasVig());
      /*F Req. 87567 E2.1 ID## avilca 23/11/2020*/
     
        documentoDAO.actualizarDocumento(parametros);

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
    
    
   @Transactional(readOnly = true)
    @Override
    public DocumentoListadoResponse listarDocLegales(HeaderParams headerParams,String indTipoDocu) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setIndTipoDocu(indTipoDocu);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
 
        this.documentoDAO.listarDocLegales(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
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
    public DocumentoListadoResponse listarDocLegalesXCodLeg(HeaderParams headerParams,String codDocLeg) throws Exception {

        ListarDocumentosProcedure parametros = mapper.map(headerParams, ListarDocumentosProcedure.class);
        parametros.setCodDocLeg(codDocLeg);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
 
        this.documentoDAO.listarDocLegalesXCodLeg(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentoListadoResponse response = new DocumentoListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }    
}
