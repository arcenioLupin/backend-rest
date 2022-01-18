package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarTasasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.GenerarCronogramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.GenerarPlantillaCambioTasaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarCompaniaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarCronogramaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarProformaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarPropuestaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarSimuladorConceptoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ListarSimuladorGastoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.ObtenerTasaSeguroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorGastoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorProformaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarSimuladorTipoMovimientoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.CalculaTasaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.RegistrarSimuladorSapProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;

public interface SimuladorDAO {

    void listarCompaniaSeguro(ListarCompaniaSeguroProcedure parametros);

    void listarProforma(ListarProformaProcedure parametros);

    void listarSimuladorConcepto(ListarSimuladorConceptoProcedure parametros);

    void registrarSimulador(RegistrarSimuladorProcedure parametros);
    
    void registrarSimuladorSap(RegistrarSimuladorSapProcedure parametros);

    void registrarSimuladorGasto(RegistrarSimuladorGastoProcedure parametros);

    void generarCronograma(GenerarCronogramaProcedure parametros);

    void cuadrarCronograma(ListarCronogramaProcedure parametros);

    void listarCronograma(ListarCronogramaProcedure parametros);

    void listarPropuesta(ListarPropuestaProcedure parametros);
    
    void listarGasto(ListarSimuladorGastoProcedure parametros);

    void obtenerTasaSeguro(ObtenerTasaSeguroProcedure parametros);
    
    void calculaTasa(CalculaTasaProcedure parametros);

    GenericoResponse generarPlantillaCambioTasaSeguro(GenerarPlantillaCambioTasaSeguroProcedure parametros) throws Exception;

    void listarTasas(ListarTasasProcedure parametros);
    
    void registrarSimuladorProforma(RegistrarSimuladorProformaProcedure parametros);
}
