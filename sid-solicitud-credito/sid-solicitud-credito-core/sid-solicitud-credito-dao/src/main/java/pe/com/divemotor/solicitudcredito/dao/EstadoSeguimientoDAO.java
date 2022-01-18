package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ActualizarEstadoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.estadoseguimiento.ListarEstadosProcedure;

public interface EstadoSeguimientoDAO {

    void listar(ListarEstadosProcedure parametros);

    void actualizarEstado(ActualizarEstadoProcedure parametros);

}
