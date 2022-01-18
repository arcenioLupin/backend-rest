package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ActualizarEstadoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ListarEstadosProcedure;

public interface EstadoSeguimientoMapper {

    void listarEstados(ListarEstadosProcedure parametros);

    void actualizarEstado(ActualizarEstadoProcedure parametros);

}
