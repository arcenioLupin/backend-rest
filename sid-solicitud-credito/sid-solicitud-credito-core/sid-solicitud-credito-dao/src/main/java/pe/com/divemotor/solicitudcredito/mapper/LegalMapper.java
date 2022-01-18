/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

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

/**
 *
 * @author MGRASSO
 */
public interface LegalMapper {
    
    void listar(ListarLegalProcedure parametros);

    public void listarEstados(ListarEstadoLegalProcedure parametros);

    public void listarDocumentosLegales(ListarDocumentosLegalesProcedure parametros);

    public void listarDocumentosGarantias(ListarDocumentosLegalesProcedure parametros);

    public void listarDocumentosAvales(ListarDocumentosLegalesProcedure parametros);

    public void actualizarChkListDocLegales(ActualizarChkListDocumentosProcedure parametros);

    public void actualizarChkListDocGarantias(ActualizarChkListDocumentosProcedure parametros);

    public void actualizarChkListDocAvales(ActualizarChkListDocumentosProcedure parametros);

    public void actualizarEstadoSolicitud(ActualizarChkListDocumentosProcedure parametros);

    public void listarOperacionCliente(ListarOperacionEmpresaProcedure parametros);

    public void listarPersonasFacultadas(ListarPersonasFacultadasProcedure parametros);

    public void listarOperacionesPersonas(ListarOperacionesPersonasProcedure parametros);

    public void listarOperacionesLegales(ListarOperacionLegalProcedure parametros);

    public void listarAvalCliente(ListarAvalClienteProcedure parametros);
    
    public void listarDocumentoRevision(ListarDocumentoRevisionProcedure parametros);

    public void listarCheckSinRegistro(ListarCheckDocumentoProcedure parametros);

    public void listarCheckConRegistro(ListarCheckDocumentoProcedure parametros);

    public void registrarOperacionconLegal(RegistrarOperacionLegalProcedure parametros);
     
    public void eliminarOperacionconLegal(RegistrarOperacionLegalProcedure parametros);

    public void registrarPersonaFacultada(RegistrarPersonaFacultadaProcedure parametros);

    public void registrarDocumentoRevision(RegistrarDocumentoRevisionProcedure parametros);

    public void listarOperacionesLegalesSolcre(ListarOperacionLegalProcedure parametros);

    public void listarPersonaFacultadaSolcre(ListarPersonaFacultadaSolcreProcedure parametros);

    public void listarEstructuraOperaciones(ListarEstructuraOperacionProcedure parametros);

    public void listarValidarSolicitud(ListarSolicitudLegalProcedure parametros);

    public void registarLegal(RegistrarLegalProcedure parametros);
    
    public void actualizarSolcre(RegistrarLegalProcedure parametros);

    public void listarGarantiaMobiliariaLegal(ListarGarantiaLegalProcedure parametros);
    
    public void listarGarantiaHipotecariaReg(ListarGarantiaRegProcedure parametros);
    
    public void listarGarantiaMobiliariaReg(ListarGarantiaRegProcedure parametros);
    
    public void listarDocumentosSolicitados(ListarDocumentosSolicitadosProcedure parametros);
    
    public void registarGarantiaMobiliaria (RegistrarGarantiaMobiliariaProcedure parametros);
    
    public void registarDocumentosSolicitados (RegistrarDocumentosSolicitadosProcedure parametros);
    
    public void listarGarantiaHipotecariaLegal(ListarGarantiaLegalProcedure parametros);
    
    public void registarGarantiaHipotecaria (RegistrarGarantiaHipotecariaProcedure parametros);
    
    public void listarDocumentosHip(ListarDocumentosSolicitadosProcedure parametros);
    
    public void listarFianzasSolidariasPN(ListarFianzaSolidariaPNProcedure parametros);
    
    public void listarPropsAvalFSPN(ListarFianzaSolidariaPNProcedure parametros);
    
    public void listarDocumentoFianzaSolidariaPN(ListarDocumentoRevisionProcedure parametros);
    
    public void registrarFianzaSolidariaPN (RegistrarFianzaSolidariaFSNProcedure parametros);
    
    public void listarFSNRegistradas(ListarFianzaSolidariaPNRegProcedure parametros);
    
    public void listaDocLegalHipRegistradas(ListarDocLegalesHipRegProcedure parametros);
    
    public void listaAnexosContratos(ListarAnexosContratosProcedure parametros);
    
    public void registrarRutaAnexo(RegistrarRutaAnexoProcedure parametros);
    
    public void listaFacturasAnexos (ListarFacturasAnexosProcedure parametros);
    
    public void listaDatosAnexos (ListarDatosAnexosProcedure parametros);
    
    public void listaAnexosPagos (ListarAnexosPagodProcedure parametros);
    
    public void mostrarMontoTotalPago (MostrarMontoTotalPagoProcedure parametros);
    
    public void mostrarListaGarantias(MostrarGarantiasPagosProcedure parametros);
    
    public void listaDatosCabeCron (ListarDatosCabeCronProcedure parametros);
    
}
