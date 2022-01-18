/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarSolicitudAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.FormatoRDLProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarHistorialAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ListarMotivosAprobacionProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarAprobacionProcedure;

/**
 *
 * @author legutierrez
 */
public interface SolicitudAprobacionDAO {
    
    void registrarAprobacion (RegistrarAprobacionProcedure parametros);
    
    void actualizarSolicitudApro (ActualizarSolicitudAprobacionProcedure parametros);
    
    void listarFormatoRDL (FormatoRDLProcedure parametros);
    
    void listarFormatoLeasing (FormatoRDLProcedure parametros);
    
    void listarFormatoMutuo (FormatoRDLProcedure parametros);
    
    void listarMotivosAprobacion (ListarMotivosAprobacionProcedure parametros);//ECUBAS <I>89642
    // <I> 90690 ivelasquez 21/09/2021
    void listarHistorialAprobacion (ListarHistorialAprobacionProcedure parametros);
    
    void listarSoliAprob (RegistrarAprobacionProcedure parametros);
    
    void actualizarAprob (ActualizarSolicitudAprobacionProcedure parametros);
    // <F> 90690 ivelasquez 21/09/2021
}