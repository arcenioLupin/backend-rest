/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.LegalDAO;
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
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarEstructuraOperacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFacturasAnexosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFianzaSolidariaPNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarFianzaSolidariaPNRegProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarGarantiaLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarGarantiaRegProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionEmpresaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarOperacionesPersonasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarPersonaFacultadaSolcreProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarPersonasFacultadasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.ListarSolicitudLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.MostrarGarantiasPagosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.MostrarMontoTotalPagoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarDocumentoRevisionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarDocumentosSolicitadosProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarFianzaSolidariaFSNProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarGarantiaHipotecariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarGarantiaMobiliariaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarOperacionLegalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarPersonaFacultadaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.legal.RegistrarRutaAnexoProcedure;
import pe.com.divemotor.solicitudcredito.mapper.LegalMapper;

/**
 *
 * @author Mgrasso
 */
@Repository
public class LegalDAOImpl implements LegalDAO{

    private LegalMapper legalMapper;
    
    @Autowired
    public void setLegalMapper(LegalMapper legalMapper) {
        this.legalMapper = legalMapper;
    }
    
    @Override
    public void listar(ListarLegalProcedure parametros) {
        legalMapper.listar(parametros);
    }

    @Override
    public void listarEstados(ListarEstadoLegalProcedure parametros) {
        legalMapper.listarEstados(parametros);
    }

    @Override
    public void listarDocumentosLegales(ListarDocumentosLegalesProcedure parametros) {
        legalMapper.listarDocumentosLegales(parametros);
    }

    @Override
    public void listarDocumentosGarantias(ListarDocumentosLegalesProcedure parametros) {
        legalMapper.listarDocumentosGarantias(parametros);
    }

    @Override
    public void listarDocumentosAvales(ListarDocumentosLegalesProcedure parametros) {
        legalMapper.listarDocumentosAvales(parametros);
    }

    @Override
    public void actualizarChkListDocLegales(ActualizarChkListDocumentosProcedure parametros) {
        legalMapper.actualizarChkListDocLegales(parametros);
    }

    @Override
    public void actualizarChkListDocGarantias(ActualizarChkListDocumentosProcedure parametros) {
        legalMapper.actualizarChkListDocGarantias(parametros);
    }

    @Override
    public void actualizarChkListDocAvales(ActualizarChkListDocumentosProcedure parametros) {
        legalMapper.actualizarChkListDocAvales(parametros);
    }

    @Override
    public void actualizarEstadoSolicitud(ActualizarChkListDocumentosProcedure parametros) {
        legalMapper.actualizarEstadoSolicitud(parametros);
    }

    @Override
    public void listarOperacionCliente(ListarOperacionEmpresaProcedure parametros) {
        legalMapper.listarOperacionCliente(parametros);
    }

    @Override
    public void listarPersonasFacultadas(ListarPersonasFacultadasProcedure parametros) {
        legalMapper.listarPersonasFacultadas(parametros);
    }

    @Override
    public void listarOperacionesPersonas(ListarOperacionesPersonasProcedure parametros) {
        legalMapper.listarOperacionesPersonas(parametros);
    }

    @Override
    public void listarOperacionesLegales(ListarOperacionLegalProcedure parametros) {
        legalMapper.listarOperacionesLegales(parametros);
    }

    @Override
    public void listarAvalCliente(ListarAvalClienteProcedure parametros) {
        legalMapper.listarAvalCliente(parametros);
    }

    @Override
    public void listarDocumentoRevision(ListarDocumentoRevisionProcedure parametros) {
        legalMapper.listarDocumentoRevision(parametros);
    }

    @Override
    public void listarCheckSinRegistro(ListarCheckDocumentoProcedure parametros) {
        legalMapper.listarCheckSinRegistro(parametros);
    }

    @Override
    public void listarCheckConRegistro(ListarCheckDocumentoProcedure parametros) {
        legalMapper.listarCheckConRegistro(parametros);
    }

    @Override
    public void registrarOperacionconLegal(RegistrarOperacionLegalProcedure parametros) {
        legalMapper.registrarOperacionconLegal(parametros);
    }
    
    @Override
    public void eliminarOperacionconLegal(RegistrarOperacionLegalProcedure parametros) {
        legalMapper.eliminarOperacionconLegal(parametros);
    }


    @Override
    public void registrarPersonaFacultada(RegistrarPersonaFacultadaProcedure parametros) {
        legalMapper.registrarPersonaFacultada(parametros);
    }

    @Override
    public void registrarDocumentoRevision(RegistrarDocumentoRevisionProcedure parametros) {
        legalMapper.registrarDocumentoRevision(parametros);
    }

    @Override
    public void listarOperacionesLegalesSolcre(ListarOperacionLegalProcedure parametros) {
        legalMapper.listarOperacionesLegalesSolcre(parametros);
    }

    @Override
    public void listarPersonaFacultadaSolcre(ListarPersonaFacultadaSolcreProcedure parametros) {
        legalMapper.listarPersonaFacultadaSolcre(parametros);
    }

    @Override
    public void listarEstructuraOperaciones(ListarEstructuraOperacionProcedure parametros) {
        legalMapper.listarEstructuraOperaciones(parametros);
    }

    @Override
    public void listarValidarSolicitud(ListarSolicitudLegalProcedure parametros) {
        legalMapper.listarValidarSolicitud(parametros);
    }

    @Override
    public void registarLegal(RegistrarLegalProcedure parametros) {
        legalMapper.registarLegal(parametros);
    }

    @Override
    public void actualizarSolcre(RegistrarLegalProcedure parametros) {
        legalMapper.actualizarSolcre(parametros);
    }

    @Override
    public void listarGarantiaMobiliariaLegal(ListarGarantiaLegalProcedure parametros) {
        legalMapper.listarGarantiaMobiliariaLegal(parametros);
    }
    
    @Override
    public void listarGarantiaHipotecariaReg(ListarGarantiaRegProcedure parametros) {
        legalMapper.listarGarantiaHipotecariaReg(parametros);
    }
    
    @Override
    public void listarGarantiaMobiliariaReg(ListarGarantiaRegProcedure parametros) {
        legalMapper.listarGarantiaMobiliariaReg(parametros);
    }
    
    @Override
    public void listarDocumentosSolicitados(ListarDocumentosSolicitadosProcedure parametros) {
        legalMapper.listarDocumentosSolicitados(parametros);
    }
    
    @Override
    public void registarGarantiaMobiliaria(RegistrarGarantiaMobiliariaProcedure parametros) {
        legalMapper.registarGarantiaMobiliaria(parametros);
    }
    
    @Override
    public void registarDocumentosSolicitados(RegistrarDocumentosSolicitadosProcedure parametros) {
        legalMapper.registarDocumentosSolicitados(parametros);
    }
    
    @Override
    public void listarGarantiaHipotecariaLegal(ListarGarantiaLegalProcedure parametros) {
        legalMapper.listarGarantiaHipotecariaLegal(parametros);
    }
    
   @Override
    public void registarGarantiaHipotecaria(RegistrarGarantiaHipotecariaProcedure parametros) {
        legalMapper.registarGarantiaHipotecaria(parametros);
    } 
    
    @Override
    public void listarDocumentosHip(ListarDocumentosSolicitadosProcedure parametros) {
        legalMapper.listarDocumentosHip(parametros);
    }  
    
    @Override
    public void listarFianzasSolidariasPN(ListarFianzaSolidariaPNProcedure parametros) {
        legalMapper.listarFianzasSolidariasPN(parametros);
    }    
    
    @Override
    public void listarPropsAvalFSPN(ListarFianzaSolidariaPNProcedure parametros) {
        legalMapper.listarPropsAvalFSPN(parametros);
    }      
    
    @Override
    public void listarDocumentoFianzaSolidariaPN(ListarDocumentoRevisionProcedure parametros) {
        legalMapper.listarDocumentoFianzaSolidariaPN(parametros);
    }   
    
    @Override
    public void registrarFianzaSolidariaPN(RegistrarFianzaSolidariaFSNProcedure parametros) {
        legalMapper.registrarFianzaSolidariaPN(parametros);
    } 

    @Override
    public void listarFSNRegistradas(ListarFianzaSolidariaPNRegProcedure parametros) {
        legalMapper.listarFSNRegistradas(parametros);
    } 
    
    @Override
    public void listaDocLegalHipRegistradas(ListarDocLegalesHipRegProcedure parametros) {
        legalMapper.listaDocLegalHipRegistradas(parametros);
    }
    
    @Override
    public void listaAnexosContratos(ListarAnexosContratosProcedure parametros) {
        legalMapper.listaAnexosContratos(parametros);
    }
    
    @Override
    public void registrarRutaAnexo(RegistrarRutaAnexoProcedure parametros){
        legalMapper.registrarRutaAnexo(parametros);
    }
    
    @Override
    public void listaFacturasAnexos (ListarFacturasAnexosProcedure parametros){   
        legalMapper.listaFacturasAnexos(parametros);
    }
    
    @Override
    public void listaAnexosPagos (ListarAnexosPagodProcedure parametros){   
        legalMapper.listaAnexosPagos(parametros);
    }
    
    @Override
    public void listaDatosAnexos (ListarDatosAnexosProcedure parametros){
       legalMapper.listaDatosAnexos(parametros);
    }
    
    @Override
    public void mostrarMontoTotalPago(MostrarMontoTotalPagoProcedure parametros){
        legalMapper.mostrarMontoTotalPago(parametros);
    }
    
    @Override
    public void mostrarListaGarantias(MostrarGarantiasPagosProcedure parametros){
        
        legalMapper.mostrarListaGarantias(parametros);
    }
    
    @Override
    public void listaDatosCabeCron (ListarDatosCabeCronProcedure parametros){
      legalMapper.listaDatosCabeCron(parametros); 
    
    }
    
    
    } 
