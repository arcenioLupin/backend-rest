package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.dto.request.AutorizacionExcepcionalActualizarEstadoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EstadoSeguimientoListadoResponse;
import pe.com.divemotor.generico.dto.HeaderParams;

public interface EstadoSeguimientoService {

    EstadoSeguimientoListadoResponse listarEstados(HeaderParams request) throws Exception;

    BaseResponse actualizarEstado(HeaderParams headerParams, AutorizacionExcepcionalActualizarEstadoRequest request) throws Exception;

}
