package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ActividadEtapaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividaTipoCreddRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ActualizarActividadRequest;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadAllListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadEtapaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ActividadPorTipoCreditoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;

public interface ActividadService {

    public ActividadListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    public ActividadEtapaListadoResponse listarActividadesEtapa(HeaderParams headerParams, String codActividad, String codEtapa) throws Exception;
    
    //Inicio Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    public ActividadAllListadoResponse listarActividadesEtapaAll(HeaderParams headerParams) throws Exception;
    
    public BaseResponse crearActividaEtapa(HeaderParams headerParams, ActividadEtapaRequest request) throws Exception;
    
    public BaseResponse actualizarActividad(HeaderParams headerParams, ActualizarActividadRequest request) throws Exception;
    
    public BaseResponse actualizarActividadTipoCred(HeaderParams headerParams,ActualizarActividaTipoCreddRequest request) throws Exception;
    
    // BUSQUEDA DE ACTIVIDADES / ETAPAS / TIPO CREDITO
    public ActividadPorTipoCreditoResponse listarActividadPorTipoCredito (HeaderParams headerParams, String codActividad, String codEtapa, String codTipoCredito) throws Exception;
    
}//Fin Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
