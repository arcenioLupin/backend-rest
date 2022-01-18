package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.CalculaTasaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ConsultaSimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.CuadrarCronogramaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorRequest;
import pe.com.divemotor.solicitudcredito.dto.request.SimuladorSapRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CompaniaSeguroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorConceptoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorCronogramaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorGastoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.SimuladorPropuestaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasaSeguroResponse;
import pe.com.divemotor.solicitudcredito.dto.response.TasasListadoResponse;

public interface SimuladorService {

    CompaniaSeguroListadoResponse listarCompaniaSeguro(HeaderParams headerParams, String codCiaSeg) throws Exception;

    ProformaListadoResponse listarProforma(HeaderParams headerParams, String codCiaSeg) throws Exception;

    SimuladorConceptoListadoResponse listarSimuladorConcepto(HeaderParams headerParams, Integer codConcCol, String indConcOblig) throws Exception;

    BaseResponse registrar(HeaderParams headerParams, SimuladorRequest request) throws Exception;
    
    BaseResponse registrarSap(HeaderParams headerParams, SimuladorSapRequest request) throws Exception;

    SimuladorCronogramaListadoResponse cuadrar(HeaderParams headerParams, CuadrarCronogramaRequest request) throws Exception;
    
    SimuladorCronogramaListadoResponse listarCronograma(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception;

    ReporteResponse exportarCronograma(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception;
    
    ReporteResponse exportarPropuesta(HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception;

    TasaSeguroResponse obtenerTasaSeguro(HeaderParams headerParams, String codCia, String codTipoVeh, String indTipoUso, String codCliente) throws Exception;
    
    TasaSeguroResponse calculaTasa(HeaderParams headerParams,CalculaTasaRequest request) throws Exception;
    
    SimuladorPropuestaListadoResponse listarPropuesta (HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception;
    
    SimuladorGastoListadoResponse listarGasto (HeaderParams headerParams, ConsultaSimuladorRequest request) throws Exception;
    
    TasasListadoResponse listarTasas (HeaderParams headerParams, String noCia, String moneda) throws Exception;
    
    BaseResponse registrarProforma(HeaderParams headerParams, SimuladorProformaRequest request) throws Exception;
}
