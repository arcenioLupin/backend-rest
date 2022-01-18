
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package pe.com.divemotor.solicitudcredito.services.impl;


import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.util.Base64;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dao.LegalDAO;
import pe.com.divemotor.solicitudcredito.dao.SimuladorDAO;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoLegalSolicitado;
import pe.com.divemotor.solicitudcredito.dominio.DocumentoRevision;
import pe.com.divemotor.solicitudcredito.dominio.OperacionLegal;
import pe.com.divemotor.solicitudcredito.dominio.PersonaFacultada;
import pe.com.divemotor.solicitudcredito.dominio.RevisionPoderes;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ActualizarChkListDocumentosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarAnexosContratosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarAnexosPagodProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarAvalClienteProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarCheckDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDatosAnexosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDatosCabeCronProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDocLegalesHipRegProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDocumentoRevisionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDocumentosLegalesProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarDocumentosSolicitadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarEstadoLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionEmpresaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarPersonaFacultadaSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarPersonasFacultadasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarDocumentoRevisionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarOperacionLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarPersonaFacultadaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarEstructuraOperacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFacturasAnexosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFianzaSolidariaPNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFianzaSolidariaPNRegProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarSolicitudLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarGarantiaLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarGarantiaRegProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.MostrarGarantiasPagosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.MostrarMontoTotalPagoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarDocumentosSolicitadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarFianzaSolidariaFSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarGarantiaHipotecariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarGarantiaMobiliariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarRutaAnexoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarCronogramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.AnexosContratosRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoSolicitadoRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentosLegalesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.FianzaSolidariaFSNRequest;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaHipotecariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaMobiliariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.LegalRequest;
import pe.com.divemotor.solicitudcredito.dto.request.OperacionesLegalesRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SolicitudLegalRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AnexosContratosResponse;
import pe.com.divemotor.solicitudcredito.dto.response.AvalClienteListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocLegalHipRegResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoRevisionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentosLegalesListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EstadoLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EstructuraOperacionListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaFSNResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaPJResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaPNRegResponse;
import pe.com.divemotor.solicitudcredito.dto.response.FianzaSolidariaPNResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaMobiliariaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaRegListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.LegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.OperacionLegalSolcreListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PersonaFacultadaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.RevisionPoderesListadoResponse;
import pe.com.divemotor.solicitudcredito.services.LegalService;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudLegalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SolicitudLegalResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteAnexosPdf;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteAnexosDataSource;

/**
 *
 * @author Mgrasso
 */
@Service
@Transactional
public class LegalServiceImpl  implements LegalService{
    private SimuladorDAO simuladorDAO;
    private LegalDAO legalDAO;
    private Mapper mapper;


    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setLegalDAO(LegalDAO legalDAO) {
        this.legalDAO = legalDAO;
    }
    
    @Autowired
    public void setSimuladorDAO(SimuladorDAO simuladorDAO) {
        this.simuladorDAO = simuladorDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public LegalListadoResponse listar(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
        ListarLegalProcedure parametros = mapper.map(headerParams, ListarLegalProcedure.class);
        mapper.map(request, parametros);
        this.legalDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            LegalListadoResponse response = new LegalListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public EstadoLegalListadoResponse listarEstados(HeaderPaginadoParams headerParams) throws Exception {
        ListarEstadoLegalProcedure parametros=mapper.map(headerParams, ListarEstadoLegalProcedure.class);
        //mapper.map(request, parametros);
        this.legalDAO.listarEstados(parametros);
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EstadoLegalListadoResponse response = new EstadoLegalListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public DocumentosLegalesListadoResponse listarDocumentosLegales(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
        ListarDocumentosLegalesProcedure parametros=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        mapper.map(request, parametros);
        switch (parametros.getOrdTitdoc()) {
            case "1": this.legalDAO.listarDocumentosLegales(parametros);
                      break;
            case "2": this.legalDAO.listarDocumentosLegales(parametros);
                      break;
            case "4": this.legalDAO.listarDocumentosGarantias(parametros);
                      break;
            case "5": this.legalDAO.listarDocumentosGarantias(parametros);
                      break;
            case "6": this.legalDAO.listarDocumentosAvales(parametros);
                      break;
            case "7": this.legalDAO.listarDocumentosAvales(parametros);
                      break;
        }
        
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            DocumentosLegalesListadoResponse response = new DocumentosLegalesListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public BaseResponse actualizarCheckList(HeaderPaginadoParams headerParams, DocumentosLegalesRequest request) throws Exception{
        //Integer statusQuery = parametros.getStatus();
        int flag=0;
        ListarDocumentosLegalesProcedure parametros1=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros1.setOrdTitdoc("1");
        mapper.map(request, parametros1);
        
        ListarDocumentosLegalesProcedure parametros2=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros2.setOrdTitdoc("2");
        mapper.map(request, parametros2);
        
        ListarDocumentosLegalesProcedure parametros3=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros3.setOrdTitdoc("4");
        parametros3.setIndTipoDocu("GH");
        mapper.map(request, parametros3);
        
        ListarDocumentosLegalesProcedure parametros4=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros4.setOrdTitdoc("5");
        parametros4.setIndTipoDocu("GM");
        mapper.map(request, parametros4);
        
        ListarDocumentosLegalesProcedure parametros5=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros5.setOrdTitdoc("6");
        mapper.map(request, parametros5);
        
        ListarDocumentosLegalesProcedure parametros6=mapper.map(headerParams, ListarDocumentosLegalesProcedure.class);
        parametros6.setOrdTitdoc("7");
        mapper.map(request, parametros6);
                
        this.legalDAO.listarDocumentosLegales(parametros1);
        this.legalDAO.listarDocumentosLegales(parametros2);
        this.legalDAO.listarDocumentosGarantias(parametros3);
        this.legalDAO.listarDocumentosGarantias(parametros4);
        this.legalDAO.listarDocumentosAvales(parametros5);
        this.legalDAO.listarDocumentosAvales(parametros6);
        
        ActualizarChkListDocumentosProcedure parametros7=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros8=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros9=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros10=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros11=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros12=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        ActualizarChkListDocumentosProcedure parametros13=mapper.map(headerParams, ActualizarChkListDocumentosProcedure.class);
        
        if(request.getListDocumentosLegalesJ().size()>0){
            for(int i=0; i<request.getListDocumentosLegalesJ().size(); i++){
                if(!request.getListDocumentosLegalesJ().get(i).getIndOblig().equalsIgnoreCase(parametros1.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros7.setCodSolcre(request.getCodSolcre());
                    parametros7.setCodDocleg(request.getListDocumentosLegalesJ().get(i).getCodDocleg());
                    parametros7.setIndOblig(request.getListDocumentosLegalesJ().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocLegales(parametros7);
                }
            }
        }
        
        if(request.getListDocumentosLegalesN().size()>0){
            for(int i=0; i<request.getListDocumentosLegalesN().size(); i++){
                if(!request.getListDocumentosLegalesN().get(i).getIndOblig().equalsIgnoreCase(parametros2.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros8.setCodSolcre(request.getCodSolcre());
                    parametros8.setCodDocleg(request.getListDocumentosLegalesN().get(i).getCodDocleg());
                    parametros8.setIndOblig(request.getListDocumentosLegalesN().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocLegales(parametros8);
                }
            }
        }
        
        if(request.getListDocumentosGarantiaI().size()>0){
            for(int i=0; i<request.getListDocumentosGarantiaI().size(); i++){
                if(!request.getListDocumentosGarantiaI().get(i).getIndOblig().equalsIgnoreCase(parametros3.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros9.setCodSolcre(request.getCodSolcre());
                    parametros9.setCodDocleg(request.getListDocumentosLegalesN().get(i).getCodDocleg());
                    parametros9.setIndOblig(request.getListDocumentosLegalesN().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocGarantias(parametros9);
                }
            }
        }
        
        if(request.getListDocumentosGarantiaGM().size()>0){
            for(int i=0; i<request.getListDocumentosGarantiaGM().size(); i++){
                if(!request.getListDocumentosGarantiaGM().get(i).getIndOblig().equalsIgnoreCase(parametros4.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros10.setCodSolcre(request.getCodSolcre());
                    parametros10.setCodDocleg(request.getListDocumentosLegalesN().get(i).getCodDocleg());
                    parametros10.setIndOblig(request.getListDocumentosLegalesN().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocGarantias(parametros10);
                }
            }
        }
        
        if(request.getListDocumentosAvalesJ().size()>0){
            for(int i=0; i<request.getListDocumentosAvalesJ().size(); i++){
                if(!request.getListDocumentosAvalesJ().get(i).getIndOblig().equalsIgnoreCase(parametros5.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros11.setCodSolcre(request.getCodSolcre());
                    parametros11.setCodDocleg(request.getListDocumentosAvalesJ().get(i).getCodDocleg());
                    parametros11.setIndOblig(request.getListDocumentosAvalesJ().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocAvales(parametros11);
                }
            }
        }
        
        if(request.getListDocumentosAvalesN().size()>0){
            for(int i=0; i<request.getListDocumentosAvalesN().size(); i++){
                if(!request.getListDocumentosAvalesN().get(i).getIndOblig().equalsIgnoreCase(parametros6.getBusqueda().get(i).getIndOblig())){
                    flag=1;
                    parametros12.setCodSolcre(request.getCodSolcre());
                    parametros12.setCodDocleg(request.getListDocumentosAvalesN().get(i).getCodDocleg());
                    parametros12.setIndOblig(request.getListDocumentosAvalesN().get(i).getIndOblig());
                    this.legalDAO.actualizarChkListDocAvales(parametros12);
                }
            }
        }
        
        if(flag==1){
            parametros13.setCodSolcre(request.getCodSolcre());
            parametros13.setCodEstleg("2");
            this.legalDAO.actualizarEstadoSolicitud(parametros13);
            Integer statusQuery = parametros13.getStatus();
            if (statusQuery.equals(1)) {
                BaseResponse response = new BaseResponse();
                response.setCodigo("1");
                response.setMensaje("Se guardo el nuevo checklist correctamente!");
                response.setEstadoTrama("1");   
                return response;
            } else {
                throw new Exception("");
            }
        }else{
            BaseResponse response = new BaseResponse();
            response.setCodigo("2");
            response.setMensaje("No se han encontrado cambios!");
            response.setEstadoTrama("2");   
            return response;
        }
    }

    @Override
    public RevisionPoderesListadoResponse listarRevisionPoderes(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception{
        ListarOperacionEmpresaProcedure parametros = mapper.map(headerParams, ListarOperacionEmpresaProcedure.class);
        mapper.map(request, parametros);
        parametros.setCodSolcre(request.getCodSolcre());
        this.legalDAO.listarOperacionCliente(parametros);
        
        ListarPersonasFacultadasProcedure parametros1 = mapper.map(headerParams, ListarPersonasFacultadasProcedure.class);
        mapper.map(request, parametros1);
        parametros1.setCodSolcre(request.getCodSolcre());
        this.legalDAO.listarPersonasFacultadas(parametros1);
        
        /*ListarOperacionesPersonasProcedure parametros2 = mapper.map(headerParams, ListarOperacionesPersonasProcedure.class);
        mapper.map(request, parametros2);
        parametros2.setCodSolcre(request.getCodSolcre());
        this.legalDAO.listarOperacionesPersonas(parametros2);*/
        
        Integer statusQuery = parametros.getStatus();
        Integer statusQuery1 = parametros1.getStatus();
        //Integer statusQuery2 = parametros2.getStatus();
        if (statusQuery.equals(1) && statusQuery1.equals(1) /*&& statusQuery2.equals(1)*/) {
            RevisionPoderesListadoResponse response = new RevisionPoderesListadoResponse();
            RevisionPoderes revisionPoderes= new RevisionPoderes();
            revisionPoderes.setListOperacionEmpresa(parametros.getBusqueda());
            revisionPoderes.setListPersonaFacultada(parametros1.getBusqueda());
            //revisionPoderes.setListOperacionPersona(parametros2.getBusqueda());
            List<RevisionPoderes> listaRevisionPoderes=new ArrayList<RevisionPoderes>();
            listaRevisionPoderes.add(revisionPoderes);
            response.setListado(listaRevisionPoderes);
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public OperacionLegalListadoResponse listarOperacionesLegales(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
        ListarOperacionLegalProcedure parametros = mapper.map(headerParams, ListarOperacionLegalProcedure.class);
        mapper.map(request, parametros);
        parametros.setCodSolcre(request.getCodSolcre());
        this.legalDAO.listarOperacionesLegales(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            OperacionLegalListadoResponse response = new OperacionLegalListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public AvalClienteListadoResponse listarAvalCliente(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarAvalClienteProcedure parametros = mapper.map(headerParams, ListarAvalClienteProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarAvalCliente(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    AvalClienteListadoResponse response = new AvalClienteListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }

    @Override
    public DocumentoRevisionListadoResponse listarDocumentoRevision(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {

                ListarDocumentoRevisionProcedure parametros = mapper.map(headerParams, ListarDocumentoRevisionProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                parametros.setCodTipope(request.getCodTipope());
                this.legalDAO.listarDocumentoRevision(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    ListarCheckDocumentoProcedure parametros1 = mapper.map(headerParams, ListarCheckDocumentoProcedure.class);
                    parametros1.setCodSolcre(request.getCodSolcre());
                    this.legalDAO.listarCheckConRegistro(parametros1);
                    if(parametros1.getBusqueda().size()>0){
                        for(int i=0; i <parametros.getBusqueda().size(); i++) {
                            for(int j=0; j <parametros1.getBusqueda().size(); j++) {
                                if(parametros.getBusqueda().get(i).getCodOpeleg().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodOpeleg()) && parametros.getBusqueda().get(i).getCodTipope().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodTipope())){
                                    parametros.getBusqueda().get(i).setIndConforme(parametros1.getBusqueda().get(j).getIndConforme());
                                    parametros.getBusqueda().get(i).setUtiliza(parametros1.getBusqueda().get(j).getUtiliza());
                                    parametros.getBusqueda().get(i).setCodDocrev(parametros1.getBusqueda().get(j).getCodDocrev());
                                    parametros.getBusqueda().get(i).setCodDdorev(parametros1.getBusqueda().get(j).getCodDdorev());
                                    break;
                                }
                            }
                        }
                    }else{
                        this.legalDAO.listarCheckSinRegistro(parametros1);
                        for(int i=0; i <parametros.getBusqueda().size(); i++) {
                            for(int j=0; j <parametros1.getBusqueda().size(); j++) {
                                if(parametros.getBusqueda().get(i).getCodOpeleg().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodOpeleg()) && parametros.getBusqueda().get(i).getCodTipope().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodTipope())){
                                    parametros.getBusqueda().get(i).setIndConforme(parametros1.getBusqueda().get(j).getIndConforme());
                                    parametros.getBusqueda().get(i).setUtiliza(parametros1.getBusqueda().get(j).getUtiliza());                       
                                    break;
                                }
                            }
                        }
                    }
                    
                    for (DocumentoRevision documentoRevision : parametros.getBusqueda()) {
                        if( Strings.isNullOrEmpty(documentoRevision.getUtiliza())|| !documentoRevision.getUtiliza().equals("S")){
                            documentoRevision.setUtiliza("N");
                        }
                        if( Strings.isNullOrEmpty(documentoRevision.getIndConforme()) || (!documentoRevision.getIndConforme().equals("S") && !documentoRevision.getIndConforme().equals("X"))){
                            documentoRevision.setIndConforme("N");
                        }
                    }
                    DocumentoRevisionListadoResponse response = new DocumentoRevisionListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }

    @Override
    public FianzaSolidariaPJResponse registrarRevisionPoderes(HeaderPaginadoParams headerParams, OperacionesLegalesRequest request) throws Exception {
        RegistrarOperacionLegalProcedure parametros=mapper.map(headerParams, RegistrarOperacionLegalProcedure.class);
        Integer statusQuery = 1;
        FianzaSolidariaPJResponse response = new FianzaSolidariaPJResponse();
        mapper.map(request, parametros);
        parametros.setCodSolcre(request.getCodSolcre());
        List<OperacionLegal> listaOperacionLegal = new ArrayList<>();
        for (OperacionLegal operacionLegal : request.getOperacionesLegales()) {
            if(statusQuery.equals(1)){
                parametros.setCodDocrev(operacionLegal.getCodDocrev());
                parametros.setCodTipope(operacionLegal.getCodTipope());
                parametros.setNomRevision(operacionLegal.getNomRevision());
                parametros.setObservacion(operacionLegal.getObservacion());
                parametros.setCodUsuario(headerParams.getCodUsuario());
                this.legalDAO.registrarOperacionconLegal(parametros);
                System.out.println("coddocrevout: "+parametros.getCodDocrevOut());
                operacionLegal.setCodDocrev(parametros.getCodDocrevOut());
                listaOperacionLegal.add(operacionLegal);
                
                if(parametros.getStatus().equals(1)){
                    RegistrarPersonaFacultadaProcedure parametros1=mapper.map(headerParams, RegistrarPersonaFacultadaProcedure.class);
                    
                    if(operacionLegal.getPersonasFacultadas()!=null)
                    {   
                        if(operacionLegal.getPersonasFacultadas().size()>0){
                            List<PersonaFacultada>personasFacultadas = new ArrayList<>();
                            for (PersonaFacultada personaFacultada : operacionLegal.getPersonasFacultadas()) {
                                if(statusQuery.equals(1)){
                                   parametros1.setCodFdorev(personaFacultada.getCodFdorev());
                                   parametros1.setCodSolcre(request.getCodSolcre());
                                   parametros1.setCodDocrev(parametros.getCodDocrevOut());
                                   parametros1.setCargo(personaFacultada.getCargo());
                                   parametros1.setNombre(personaFacultada.getNombre());
                                   parametros1.setDoi(personaFacultada.getDoi());
                                   parametros1.setCodUsuario(headerParams.getCodUsuario());
                                   this.legalDAO.registrarPersonaFacultada(parametros1);
                                   System.out.println("codfdorev: "+parametros1.getCodFdorevOut());
                                   personaFacultada.setCodDocrev(parametros1.getCodDocrevOut());
                                   personaFacultada.setCodFdorev(parametros1.getCodFdorevOut());
                                   personasFacultadas.add(personaFacultada);
                                }
                            }
                                response.setListaPersonasFacultadas(personasFacultadas);
                        }
                }
                if(parametros.getStatus().equals(1)){
                        RegistrarDocumentoRevisionProcedure parametros2=mapper.map(headerParams, RegistrarDocumentoRevisionProcedure.class);
                        if(operacionLegal.getDocumentos()!=null){ 
                            if(operacionLegal.getDocumentos().size()>0){
                                List<DocumentoRevision> listaDocumentos = new ArrayList<>();
                                for (DocumentoRevision documento : operacionLegal.getDocumentos()) {
                                    if(documento.getUtiliza().equalsIgnoreCase("S")){
                                        parametros2.setCodDdorev(documento.getCodDdorev());
                                        parametros2.setCodSolcre(request.getCodSolcre());
                                        parametros2.setCodDocrev(parametros.getCodDocrevOut());
                                        parametros2.setCodOpeleg(documento.getCodOpeleg());
                                        parametros2.setCodTipope(documento.getCodTipope());
                                        parametros2.setIndConforme(documento.getIndConforme());
                                        parametros2.setCodUsuario(headerParams.getCodUsuario());
                                        this.legalDAO.registrarDocumentoRevision(parametros2);
                                        documento.setCodDdorev(parametros2.getCodDdorevOut());
                                        documento.setCodDocrev(parametros2.getCodDocrevOut());
                                        listaDocumentos.add(documento);
                                        
                                    }
                                }
                                     response.setListaDocumentosRevision(listaDocumentos);
                            }
                    }
                    }
                }
            }else{
                statusQuery=parametros.getStatus();
                break;
            }
            statusQuery=parametros.getStatus();
        }
           response.setListaOperacionesLegales(listaOperacionLegal);
        if (statusQuery.equals(1)) {
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    
 @Override
    public BaseResponse eliminarOperacionLegal(HeaderPaginadoParams headerParams, OperacionesLegalesRequest request) throws Exception {
        RegistrarOperacionLegalProcedure parametros=mapper.map(headerParams, RegistrarOperacionLegalProcedure.class);
        BaseResponse response = new BaseResponse();
        mapper.map(request, parametros);
        parametros.setCodSolcre(request.getCodSolcre());
        parametros.setCodDocrev(request.getCodDocRev());  
        this.legalDAO.eliminarOperacionconLegal(parametros);
                
        Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));  
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());
                }
    }    

    @Override
    public OperacionLegalSolcreListadoResponse listarOperacionesLegalesSolcre(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception{
                ListarOperacionLegalProcedure parametros = mapper.map(headerParams, ListarOperacionLegalProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarOperacionesLegalesSolcre(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    OperacionLegalSolcreListadoResponse response = new OperacionLegalSolcreListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }

    @Override
    public PersonaFacultadaListadoResponse listarPersonaFacultadaSolcre(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception{
                ListarPersonaFacultadaSolcreProcedure parametros = mapper.map(headerParams, ListarPersonaFacultadaSolcreProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodDocrev(request.getCodDocrev());
                this.legalDAO.listarPersonaFacultadaSolcre(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    PersonaFacultadaListadoResponse response = new PersonaFacultadaListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }

    @Override
    public EstructuraOperacionListadoResponse listarEstructuraOperaciones(HeaderPaginadoParams headerParams) throws Exception {
        ListarEstructuraOperacionProcedure parametros=mapper.map(headerParams, ListarEstructuraOperacionProcedure.class);
        this.legalDAO.listarEstructuraOperaciones(parametros);
        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            EstructuraOperacionListadoResponse response = new EstructuraOperacionListadoResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());      
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public SolicitudLegalListadoResponse listarValidarSolicitud(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception{
                ListarSolicitudLegalProcedure parametros = mapper.map(headerParams, ListarSolicitudLegalProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSoliCred(request.getCodSoliCred());
                this.legalDAO.listarValidarSolicitud(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    SolicitudLegalListadoResponse response = new SolicitudLegalListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }

    @Override
    public SolicitudLegalResponse registarLegal(HeaderPaginadoParams headerParams, SolicitudLegalRequest request) throws Exception {
        RegistrarLegalProcedure parametros=mapper.map(headerParams, RegistrarLegalProcedure.class);
        SolicitudLegalResponse response = new SolicitudLegalResponse();
        mapper.map(request, parametros);
        parametros.setCodSoliCred(request.getCodSoliCred());
        parametros.setCodEstope(request.getCodEstope());
        parametros.setCodClie(request.getCodClie());
        parametros.setFechaCaduca(request.getFechaCaduca());
        parametros.setFechaRevision(request.getFechaRevision());
        parametros.setFechaSolcre(request.getFechaSolcre());
        parametros.setNoCia(request.getNoCia());
        parametros.setCodEstleg(request.getCodEstleg());
        parametros.setNroExpediente(request.getNroExpediente());
        parametros.setCodUsuario(headerParams.getCodUsuario());
        this.legalDAO.registarLegal(parametros);
        if(parametros.getStatus().equals(1)){
            parametros.setCodSolcre(parametros.getCodSolcre());
            this.legalDAO.actualizarSolcre(parametros);
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setCodSolcre(parametros.getCodSolcre());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public GarantiaListadoResponse listarGarantiaMobiliariaLegal(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarGarantiaLegalProcedure parametros = mapper.map(headerParams, ListarGarantiaLegalProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarGarantiaMobiliariaLegal(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    GarantiaListadoResponse response = new GarantiaListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }
    
    @Override
    public GarantiaRegListadoResponse listarGarantiaHipotecariaReg(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarGarantiaRegProcedure parametros = mapper.map(headerParams, ListarGarantiaRegProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarGarantiaHipotecariaReg(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    GarantiaRegListadoResponse response = new GarantiaRegListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }
    
 @Override
    public GarantiaRegListadoResponse listarGarantiaMobiliariaReg(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarGarantiaRegProcedure parametros = mapper.map(headerParams, ListarGarantiaRegProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarGarantiaMobiliariaReg(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    GarantiaRegListadoResponse response = new GarantiaRegListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }    
     
    
    @Override
    public DocumentoListadoResponse listarDocumentosSolicitados(HeaderPaginadoParams headerParams,DocumentoSolicitadoRequest request) throws Exception {
                ListarDocumentosSolicitadosProcedure parametros = mapper.map(headerParams, ListarDocumentosSolicitadosProcedure.class);
                mapper.map(request, parametros);
                this.legalDAO.listarDocumentosSolicitados(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    DocumentoListadoResponse response = new DocumentoListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }    
    
    @Override
    public GarantiaMobiliariaResponse registarGarantiaMobiliaria(HeaderPaginadoParams headerParams, GarantiaMobiliariaRequest request) throws Exception {
        RegistrarGarantiaMobiliariaProcedure parametros=mapper.map(headerParams, RegistrarGarantiaMobiliariaProcedure.class);
        GarantiaMobiliariaResponse response = new GarantiaMobiliariaResponse();
        mapper.map(request, parametros);
        parametros.setCodCanleg(request.getCodCanleg());
        parametros.setCodSoliCred(request.getCodSoliCred());
        parametros.setTipPersona(request.getTipoPersona());
        parametros.setPropietario(request.getPropietario());
        parametros.setMarca(request.getMarca());
        parametros.setPlaca(request.getPlaca());
        parametros.setModelo(request.getModelo());
        parametros.setAnio(request.getAnio());
        parametros.setTipoBien(request.getTipoBien());
        parametros.setNombrePersona(request.getListaPersonas().get(0).getNombres());
        parametros.setApPaternoPersona(request.getListaPersonas().get(0).getApellidoPat());
        parametros.setApMaternoPersona(request.getListaPersonas().get(0).getApellidoMat());
        parametros.setNombreConyuge(request.getListaPersonas().get(1).getNombres());
        parametros.setApPaternoConyuge(request.getListaPersonas().get(1).getApellidoPat());
        parametros.setApMaternoConyuge(request.getListaPersonas().get(1).getApellidoMat());
        parametros.setTipoDocPersona(request.getListaPersonas().get(0).getCodTipoDoc());
        parametros.setNroDocPersona(request.getListaPersonas().get(0).getDoi());
        parametros.setTipoDocConyuge(request.getListaPersonas().get(1).getCodTipoDoc());
        parametros.setNroDocConyuge(request.getListaPersonas().get(1).getDoi());
        parametros.setOpinionLegal(request.getOpinionLegal());
        parametros.setCodUsuario(headerParams.getCodUsuario());
        this.legalDAO.registarGarantiaMobiliaria(parametros);
        
        Integer statusQuery = parametros.getStatus();
        if(statusQuery.equals(1)){    
            List<DocumentoLegalSolicitado> listCodDanlegOut;
            listCodDanlegOut = new ArrayList<>();
            RegistrarDocumentosSolicitadosProcedure parametros2 =mapper.map(headerParams, RegistrarDocumentosSolicitadosProcedure.class);
             for(DocumentoLegalSolicitado objDocLegalSoli :request.getListaDocumentosLegales()){
                 parametros2.setCodCanleg(parametros.getCodCanlegOut());
                 parametros2.setCodDanleg(objDocLegalSoli.getCodDanleg());
                 parametros2.setCodDtipope(objDocLegalSoli.getCodDtipope());
                 parametros2.setCodTipope(objDocLegalSoli.getCodTipope());
                 parametros2.setIndConforme(objDocLegalSoli.getIndOk());
                 parametros2.setObservacion(objDocLegalSoli.getObservacion());
                 parametros2.setCodUsuario(headerParams.getCodUsuario());  
                 this.legalDAO.registarDocumentosSolicitados(parametros2);
                 objDocLegalSoli.setCodDanleg(parametros2.getCodDanlegOut());
                 objDocLegalSoli.setCodCanleg(parametros.getCodCanlegOut());
                 listCodDanlegOut.add(objDocLegalSoli);
                }
                 
                 response.setCodCanlegOut(parametros.getCodCanlegOut());
                 response.setListCodDanlegOut(listCodDanlegOut);
                 response.setCodigo(parametros.getCodigo());
                 response.setMensaje(parametros.getMensaje());
                 response.setEstadoTrama(String.valueOf(parametros.getStatus()));          
                 return response;
   
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }
    @Override
    public GarantiaListadoResponse listarGarantiaHipotecariaLegal(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarGarantiaLegalProcedure parametros = mapper.map(headerParams, ListarGarantiaLegalProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarGarantiaHipotecariaLegal(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    GarantiaListadoResponse response = new GarantiaListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }
    
  @Override
    public GarantiaMobiliariaResponse registarGarantiaHipotecaria(HeaderPaginadoParams headerParams, GarantiaHipotecariaRequest request) throws Exception {
        RegistrarGarantiaHipotecariaProcedure parametros=mapper.map(headerParams, RegistrarGarantiaHipotecariaProcedure.class);
        GarantiaMobiliariaResponse response = new GarantiaMobiliariaResponse();
        mapper.map(request, parametros);
        parametros.setCodCanleg(request.getCodCanleg());
        parametros.setCodSoliCred(request.getCodSoliCred());
        parametros.setTipPersona(request.getTipoPersona());
        parametros.setPropietario(request.getPropietario());
        parametros.setUbicacion(request.getUbicacion());
        parametros.setAreaMetro(request.getAreaMetro());
        parametros.setTipMedida(request.getTipMedida());
        parametros.setParRegistral(request.getParRegistral());
        parametros.setSedRegistral(request.getSedRegistral());
        parametros.setAsiento(request.getAsiento());    
        parametros.setTipoBien(request.getTipoBien());
        parametros.setNombrePersona(request.getListaPersonas().get(0).getNombres());
        parametros.setApPaternoPersona(request.getListaPersonas().get(0).getApellidoPat());
        parametros.setApMaternoPersona(request.getListaPersonas().get(0).getApellidoMat());
        parametros.setNombreConyuge(request.getListaPersonas().get(1).getNombres());
        parametros.setApPaternoConyuge(request.getListaPersonas().get(1).getApellidoPat());
        parametros.setApMaternoConyuge(request.getListaPersonas().get(1).getApellidoMat());
        parametros.setTipoDocPersona(request.getListaPersonas().get(0).getCodTipoDoc());
        parametros.setNroDocPersona(request.getListaPersonas().get(0).getDoi());
        parametros.setTipoDocConyuge(request.getListaPersonas().get(1).getCodTipoDoc());
        parametros.setNroDocConyuge(request.getListaPersonas().get(1).getDoi());
        parametros.setOpinionLegal(request.getOpinionLegal());
        parametros.setObservacion1(request.getObservacion1());
        parametros.setObservacion2(request.getObservacion2());
        parametros.setCodUsuario(headerParams.getCodUsuario());
        this.legalDAO.registarGarantiaHipotecaria(parametros);
        Integer statusQuery = parametros.getStatus();
        if(statusQuery.equals(1)){    
            List<DocumentoLegalSolicitado> listCodDanlegOut;
            listCodDanlegOut = new ArrayList<>();
            RegistrarDocumentosSolicitadosProcedure parametros2 =mapper.map(headerParams, RegistrarDocumentosSolicitadosProcedure.class);
             for(DocumentoLegalSolicitado objDocLegalSoli :request.getListaDocumentosLegales()){
                 parametros2.setCodCanleg(parametros.getCodCanlegOut());
                 parametros2.setCodDanleg(objDocLegalSoli.getCodDanleg());
                 parametros2.setCodDtipope(objDocLegalSoli.getCodDtipope());
                 parametros2.setCodTipope(objDocLegalSoli.getCodTipope());
                 parametros2.setIndConforme(objDocLegalSoli.getIndOk());
                 parametros2.setObservacion(objDocLegalSoli.getObservacion());
                 parametros2.setCodUsuario(headerParams.getCodUsuario());  
                 this.legalDAO.registarDocumentosSolicitados(parametros2);
                 objDocLegalSoli.setCodDanleg(parametros2.getCodDanlegOut());
                 objDocLegalSoli.setCodCanleg(parametros.getCodCanlegOut());
                 listCodDanlegOut.add(objDocLegalSoli);
             }
                 
                 response.setCodCanlegOut(parametros.getCodCanlegOut());
                 response.setListCodDanlegOut(listCodDanlegOut);
                 response.setCodigo(parametros.getCodigo());
                 response.setMensaje(parametros.getMensaje());
                 response.setEstadoTrama(String.valueOf(parametros.getStatus()));          
                 return response;
   
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }

    @Override
    public DocumentoListadoResponse listarDocumentosHip(HeaderPaginadoParams headerParams,DocumentoSolicitadoRequest request) throws Exception {
                ListarDocumentosSolicitadosProcedure parametros = mapper.map(headerParams, ListarDocumentosSolicitadosProcedure.class);
                mapper.map(request, parametros);
                this.legalDAO.listarDocumentosHip(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    DocumentoListadoResponse response = new DocumentoListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
               } else {
                    throw new Exception(parametros.getMensaje());

                }
    }     
   @Override
    public DocumentoRevisionListadoResponse listarDocumentoFianzaSolidariaPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {

                ListarDocumentoRevisionProcedure parametros = mapper.map(headerParams, ListarDocumentoRevisionProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                parametros.setCodTipope(request.getCodTipope());
                this.legalDAO.listarDocumentoFianzaSolidariaPN(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    ListarCheckDocumentoProcedure parametros1 = mapper.map(headerParams, ListarCheckDocumentoProcedure.class);
                    parametros1.setCodSolcre(request.getCodSolcre());
                    this.legalDAO.listarCheckConRegistro(parametros1);
                    if(parametros1.getBusqueda().size()>0){
                        for(int i=0; i <parametros.getBusqueda().size(); i++) {
                            for(int j=0; j <parametros1.getBusqueda().size(); j++) {
                                if(parametros.getBusqueda().get(i).getCodOpeleg().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodOpeleg()) && parametros.getBusqueda().get(i).getCodTipope().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodTipope())){
                                    parametros.getBusqueda().get(i).setIndConforme(parametros1.getBusqueda().get(j).getIndConforme());
                                    parametros.getBusqueda().get(i).setUtiliza(parametros1.getBusqueda().get(j).getUtiliza());
                                    parametros.getBusqueda().get(i).setCodDocrev(parametros1.getBusqueda().get(j).getCodDocrev());
                                    parametros.getBusqueda().get(i).setCodDdorev(parametros1.getBusqueda().get(j).getCodDdorev());
                                    break;
                                }
                            }
                        }
                    }else{
                        this.legalDAO.listarCheckSinRegistro(parametros1);
                        for(int i=0; i <parametros.getBusqueda().size(); i++) {
                            for(int j=0; j <parametros1.getBusqueda().size(); j++) {
                                if(parametros.getBusqueda().get(i).getCodOpeleg().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodOpeleg()) && parametros.getBusqueda().get(i).getCodTipope().equalsIgnoreCase(parametros1.getBusqueda().get(j).getCodTipope())){
                                    parametros.getBusqueda().get(i).setIndConforme(parametros1.getBusqueda().get(j).getIndConforme());
                                    parametros.getBusqueda().get(i).setUtiliza(parametros1.getBusqueda().get(j).getUtiliza());                       
                                    break;
                                }
                            }
                        }
                    }
                    
                    for (DocumentoRevision documentoRevision : parametros.getBusqueda()) {
                        if( Strings.isNullOrEmpty(documentoRevision.getUtiliza())|| !documentoRevision.getUtiliza().equals("S")){
                            documentoRevision.setUtiliza("N");
                        }
                        if( Strings.isNullOrEmpty(documentoRevision.getIndConforme()) || !documentoRevision.getIndConforme().equals("S")){
                            documentoRevision.setIndConforme("N");
                        }
                    }
                    DocumentoRevisionListadoResponse response = new DocumentoRevisionListadoResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }
    
@Override
    public FianzaSolidariaPNResponse
            listarPropsAvalFSPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
        ListarFianzaSolidariaPNProcedure parametros = mapper.map(headerParams, ListarFianzaSolidariaPNProcedure.class
        );
        mapper.map(request, parametros);
        parametros.setCodSolcre(request.getCodSolcre());
        this.legalDAO.listarPropsAvalFSPN(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            FianzaSolidariaPNResponse response = new FianzaSolidariaPNResponse();
            response.setCodigo(parametros.getCodigo());
            response.setMensaje(parametros.getMensaje());
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setListado(parametros.getBusqueda());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }
    }    
    
   @Override
    public FianzaSolidariaPNResponse listarFianzasSolidariasPN(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarFianzaSolidariaPNProcedure parametros = mapper.map(headerParams, ListarFianzaSolidariaPNProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarFianzasSolidariasPN(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    FianzaSolidariaPNResponse response = new FianzaSolidariaPNResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    } 
    
  @Override
    public FianzaSolidariaFSNResponse registrarFianzaSolidariaPN(HeaderPaginadoParams headerParams, FianzaSolidariaFSNRequest request) throws Exception {
        RegistrarFianzaSolidariaFSNProcedure parametros=mapper.map(headerParams, RegistrarFianzaSolidariaFSNProcedure.class);
        FianzaSolidariaFSNResponse response = new FianzaSolidariaFSNResponse();
        mapper.map(request, parametros);
        parametros.setCodCanleg(request.getCodCanleg());
        parametros.setCodSoliCred(request.getCodSoliCred());
        parametros.setPropietario(request.getPropietario());   
        parametros.setTipoBien(request.getTipoBien());
        parametros.setNombrePersona(request.getListaPersonas().get(0).getNombres());
        parametros.setApPaternoPersona(request.getListaPersonas().get(0).getApellidoPat());
        parametros.setApMaternoPersona(request.getListaPersonas().get(0).getApellidoMat());
        parametros.setNombreConyuge(request.getListaPersonas().get(1).getNombres());
        parametros.setApPaternoConyuge(request.getListaPersonas().get(1).getApellidoPat());
        parametros.setApMaternoConyuge(request.getListaPersonas().get(1).getApellidoMat());
        parametros.setTipoDocPersona(request.getListaPersonas().get(0).getCodTipoDoc());
        parametros.setNroDocPersona(request.getListaPersonas().get(0).getDoi());
        parametros.setTipoDocConyuge(request.getListaPersonas().get(1).getCodTipoDoc());
        parametros.setNroDocConyuge(request.getListaPersonas().get(1).getDoi());
        parametros.setOpinionLegal(request.getOpinionLegal());
        parametros.setObservacion1(request.getObservacion1());
        parametros.setObservacion2(request.getObservacion2());
        parametros.setCodUsuario(headerParams.getCodUsuario());
        this.legalDAO.registrarFianzaSolidariaPN(parametros);
        Integer statusQuery = parametros.getStatus();
        if(statusQuery.equals(1)){ 
                 response.setCodCanlegOut(parametros.getCodCanlegOut());
                 response.setCodigo(parametros.getCodigo());
                 response.setMensaje(parametros.getMensaje());
                 response.setEstadoTrama(String.valueOf(parametros.getStatus()));          
                 return response;
            
             }
        else {
            throw new Exception(parametros.getMensaje());
        }
    }

@Override
    public FianzaSolidariaPNRegResponse listarFSNRegistradas(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarFianzaSolidariaPNRegProcedure parametros = mapper.map(headerParams, ListarFianzaSolidariaPNRegProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSolcre(request.getCodSolcre());
                this.legalDAO.listarFSNRegistradas(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    FianzaSolidariaPNRegResponse response = new FianzaSolidariaPNRegResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }     

    @Override
    public DocLegalHipRegResponse listaDocLegalHipRegistradas(HeaderPaginadoParams headerParams, LegalRequest request) throws Exception {
                ListarDocLegalesHipRegProcedure parametros = mapper.map(headerParams, ListarDocLegalesHipRegProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodCanleg(request.getCodCanleg());
                this.legalDAO.listaDocLegalHipRegistradas(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    DocLegalHipRegResponse response = new DocLegalHipRegResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }     
    
   @Override
    public AnexosContratosResponse listaAnexosContratos(HeaderPaginadoParams headerParams, AnexosContratosRequest request) throws Exception {
                ListarAnexosContratosProcedure parametros = mapper.map(headerParams, ListarAnexosContratosProcedure.class);
                mapper.map(request, parametros);
                parametros.setCodSoliCred(request.getCodSoliCred());
                parametros.setCodOperRel(request.getCodOperRel());
                this.legalDAO.listaAnexosContratos(parametros);

                Integer statusQuery = parametros.getStatus();
                if (statusQuery.equals(1)) {
                    AnexosContratosResponse response = new AnexosContratosResponse();
                    response.setCodigo(parametros.getCodigo());
                    response.setMensaje(parametros.getMensaje());
                    response.setEstadoTrama(String.valueOf(parametros.getStatus()));
                    response.setListado(parametros.getBusqueda());      
                    return response;
                } else {
                    throw new Exception(parametros.getMensaje());

                }
    }  
    
     
  @Override
    public BaseResponse registrarRutaAnexo(HeaderPaginadoParams headerParams, AnexosContratosRequest request) throws Exception {
        RegistrarRutaAnexoProcedure parametros=mapper.map(headerParams, RegistrarRutaAnexoProcedure.class);
        BaseResponse response = new BaseResponse();
        mapper.map(request, parametros);

        parametros.setCodSoliCred(request.getCodSoliCred());
        //I Req. 87567 E2.1 ID## avilca 16/10/2020 
        parametros.setUrl(request.getUrl() == null?"":request.getUrl()); 
        parametros.setTipoDoc(request.getTipoDoc() == null?"":request.getTipoDoc());
        //F Req. 87567 E2.1 ID## avilca 16/10/2020 
        parametros.setCodUsuario(headerParams.getCodUsuario());
        this.legalDAO.registrarRutaAnexo(parametros);
        Integer statusQuery = parametros.getStatus();
        if(statusQuery.equals(1)){ 
                 response.setCodigo(parametros.getCodigo());
                 response.setMensaje(parametros.getMensaje());
                 response.setEstadoTrama(String.valueOf(parametros.getStatus()));          
                 return response;
            
             }
        else {
            throw new Exception(parametros.getMensaje());
        }
    } 

  @Override
    public ReporteResponse generarAnexosPdf(HeaderParams headerParams, String codOper, String codSoliCred,String codTipSoliCred) throws Exception {
        
        
        ReporteAnexosDataSource request = new ReporteAnexosDataSource();
        ReporteAnexosPdf reporte = new ReporteAnexosPdf();

        ListarFacturasAnexosProcedure parametrosFacturaAnexo = mapper.map(headerParams, ListarFacturasAnexosProcedure.class);
        //parametrosFacturaAnexo.setCodOper(codOper);
        parametrosFacturaAnexo.setCodSoliCred(codSoliCred);//<!-- Req. 87567 E2.1 ID## avilca 16/10/2020 -->
        this.legalDAO.listaFacturasAnexos(parametrosFacturaAnexo);
        
        ListarDatosAnexosProcedure parametrosDatosAnexo = mapper.map(headerParams, ListarDatosAnexosProcedure.class);
        parametrosDatosAnexo.setCodOper(codOper);
        parametrosDatosAnexo.setCodSoliCred(codSoliCred);
        this.legalDAO.listaDatosAnexos(parametrosDatosAnexo);
        
        ListarAnexosPagodProcedure parametrosDatosAnexoPagos = mapper.map(headerParams, ListarAnexosPagodProcedure.class);
        parametrosDatosAnexoPagos.setCodSoliCred(codSoliCred);
        this.legalDAO.listaAnexosPagos(parametrosDatosAnexoPagos);
        
        MostrarGarantiasPagosProcedure parametrosDatosGarantiaPago = mapper.map(headerParams, MostrarGarantiasPagosProcedure.class);
        parametrosDatosGarantiaPago.setCodSoliCred(codSoliCred);
        parametrosDatosGarantiaPago.setIndTipoGara("N");
        this.legalDAO.mostrarListaGarantias(parametrosDatosGarantiaPago);
        
        if(parametrosDatosGarantiaPago.getListaGarantiaMobiliaria() != null && !parametrosDatosGarantiaPago.getListaGarantiaMobiliaria().isEmpty()){
            for(int i =0; i < parametrosDatosGarantiaPago.getListaGarantiaMobiliaria().size();i++){
                parametrosDatosGarantiaPago.getListaGarantiaMobiliaria().get(i).setItem(java.lang.Integer.toString(i+1));
            }
        }
        /* LISTA DE GARANTIAS MOBILIARIAS ADICIONALES MBARDALES*/
        MostrarGarantiasPagosProcedure parametrosGarantiasAdicionales = mapper.map(headerParams, MostrarGarantiasPagosProcedure.class);
        parametrosGarantiasAdicionales.setCodSoliCred(codSoliCred);
        parametrosGarantiasAdicionales.setIndTipoGara("S");
        this.legalDAO.mostrarListaGarantias(parametrosGarantiasAdicionales);
        
      if(parametrosGarantiasAdicionales.getListaGarantiaMobiliaria() != null && !parametrosGarantiasAdicionales.getListaGarantiaMobiliaria().isEmpty()){
        for(int i =0; i < parametrosGarantiasAdicionales.getListaGarantiaMobiliaria().size();i++){
            parametrosGarantiasAdicionales.getListaGarantiaMobiliaria().get(i).setItem(java.lang.Integer.toString(i+1));
        }
      }  
        MostrarMontoTotalPagoProcedure parametrosDatosAnexoPagosTotal = mapper.map(headerParams, MostrarMontoTotalPagoProcedure.class);
        parametrosDatosAnexoPagosTotal.setCodSoliCred(codSoliCred);
        this.legalDAO.mostrarMontoTotalPago(parametrosDatosAnexoPagosTotal);
        
        ListarCronogramaProcedure parametrosListaDetalleDeuda = mapper.map(headerParams, ListarCronogramaProcedure.class);
        parametrosListaDetalleDeuda.setCodSoliCred(codSoliCred);
        parametrosListaDetalleDeuda.setNumProfVeh("");
        simuladorDAO.listarCronograma(parametrosListaDetalleDeuda);
        
        ListarDatosCabeCronProcedure parametrosDatosCabeCron = mapper.map(headerParams, ListarDatosCabeCronProcedure.class);
        parametrosDatosCabeCron.setCodSoliCred(codSoliCred);
        this.legalDAO.listaDatosCabeCron(parametrosDatosCabeCron);
        
        

        request.setListaFacturas(parametrosFacturaAnexo.getBusqueda());
        request.setNomCia(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNomCia() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getNomCia()));
        request.setNomBanco(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNomBanco() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getNomBanco()));
        //request.setTextoCantMarcaModelo(textoCantMarcaModelo);
        request.setMarca(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMarca() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getMarca()));
        request.setModelo(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getModelo()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getModelo()));
        request.setTipoVeh(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getTipoVeh() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getTipoVeh()));
        request.setNumMotor(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNumMotor()==null?"":parametrosDatosAnexo.getBusqueda().get(0).getNumMotor()));
        request.setNumChasis(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNumChasis()==null?"":parametrosDatosAnexo.getBusqueda().get(0).getNumChasis()));
        request.setNumPlaca(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNumPlaca()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getNumPlaca()));
        request.setMontoGM(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoGM()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoGM()));
        request.setMontoLetrasGM(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasGM()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasGM()));
        request.setValorGM(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getValorGM() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getValorGM()));
        request.setMontoLetrasValorGM(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasValorGM()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasValorGM()));
        //request.setListaNumFacturas("5511");
        request.setNomeMonedaCi(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda()));
        request.setMontoCi(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoCi()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoCi()));
        request.setMontoLetras(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasCi()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasCi()));
        //request.setDescripcionMoneda("");
        //request.setNumNotaCredito("F011-0000007");
        request.setNomeMonedaNotaCredito(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda()));
        //request.setMontoNotaCredito("5,000.00");
        //request.setDiaFirmaContrato("25");
        //request.setMesFirmaContrato("Diciembre");
        //request.setAnioFirmaContrato("2018");
        request.setNomeMonedaFin(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getNomMoneda()));
        request.setMontoFin(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoFin()== null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoFin()));
        request.setMontoLetrasFin(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasFin() == null?"":parametrosDatosAnexo.getBusqueda().get(0).getMontoLetrasFin()));
        //request.setDescripcionMonedaFin("");
        // ANULANDO CRONOGRAMA ANTERIOR SIMULEDE
        //request.setListaDetalleDeuda(parametrosListaDetalleDeuda.getBusqueda());
        // NUEVO CRONOGRAMA ARLCML
        request.setListaDetalleDeuda(parametrosDatosCabeCron.getListaCronograma());
        
        request.setListaAnexosPagos(parametrosDatosAnexoPagos.getListaPagos());
        request.setListaGarantiaMobiliaria(parametrosDatosGarantiaPago.getListaGarantiaMobiliaria());
        /* SETEAR GARANTIAS MOBILIARIAS ADICIONALES MBARDALES */
        request.setListaGarantiaMobiliariaAdicionales(parametrosGarantiasAdicionales.getListaGarantiaMobiliaria());
        
        request.setfMontoTextoTotal(parametrosDatosAnexoPagosTotal.getListaPagosTotal().isEmpty()? "":(parametrosDatosAnexoPagosTotal.getListaPagosTotal().get(0).getfMontoTextoTotal().replace("soles","")));
        request.setValMontoCiTotal(parametrosDatosAnexoPagosTotal.getListaPagosTotal().isEmpty()? "":(parametrosDatosAnexoPagosTotal.getListaPagosTotal().get(0).getValMontoCiTotal()));
        request.setNomeMonedaSoli(parametrosDatosAnexoPagos.getListaPagos().isEmpty()?"":(parametrosDatosAnexoPagos.getListaPagos().get(0).getNomeMoneda()));
        request.setDesLargaMoneda(parametrosDatosAnexoPagos.getListaPagos().isEmpty()?"":(parametrosDatosAnexoPagos.getListaPagos().get(0).getDesLargaMoneda()));
        request.setCliente(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getCliente()));
        request.setCodCliente(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getCodCliente()));
        request.setComiGaAdmin(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getComiGaAdmin()));
        request.setTcea(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getTcea()));
        request.setPeriodiLetras(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getPeriodiLetras()));
        request.setMoneda(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getMoneda()));
        request.setTea(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getTea()));
        // MBARDALES AGREGAR DATA AL CAMPO YA CREADO - CONTRATOS ANEXOS MUTUO
        request.setMontoPenalidad(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getMontoPenalidad()));
        request.setNumCuotas(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getNumCuotas()));
        request.setNumLetras(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getNumLetras()));
        request.setDeudaFinanciar(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getDeudaFinanciar()));
        request.setVenPriLetra(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getVenPriLetra()));
        // MBARDALES PARA DATOS DE CABECERA DE CRONOGRAMA CONTRATOS ANEXOS MUTUO
        request.setListaCuotasPerGrac(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getListaCuotasPerGrac()));
        request.setNroDiasPagoGrac(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getNroDiasPagoGrac()));
        request.setNroDiasPagoGracLetras(parametrosDatosCabeCron.getBusqueda() == null?"":(parametrosDatosCabeCron.getBusqueda().get(0).getNroDiasPagoGracLetras()));
        //
        
        // MBARDALES PARA DATOS DE CONTRATO ANEXOS LEASING
        request.setDetaLeasingUno(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getDetaLeasingUno()));
        request.setDetaListFact(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getDetaListFact()));
        request.setDetaNotaCred(parametrosDatosAnexo.getBusqueda() == null?"":(parametrosDatosAnexo.getBusqueda().get(0).getDetaNotaCred()));
        
        request.setCodTipSoliCred(codTipSoliCred);
        
        byte[] pdfByte = reporte.generarReporte(request);

        ReporteResponse reporteResponse = new ReporteResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(pdfByte);
        reporteResponse.setReporte(Base64.encodeBase64String(pdfByte));

        return reporteResponse;
    }    
}
