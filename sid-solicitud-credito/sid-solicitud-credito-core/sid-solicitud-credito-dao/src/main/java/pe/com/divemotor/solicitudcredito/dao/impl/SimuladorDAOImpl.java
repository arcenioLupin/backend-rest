package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dao.SimuladorDAO;
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
import pe.com.divemotor.solicitudcredito.mapper.SimuladorMapper;

@Repository("simuladorDAO")
public class SimuladorDAOImpl implements SimuladorDAO {

    private SimuladorMapper simuladorMapper;

    @Autowired
    public void setSimuladorMapper(SimuladorMapper simuladorMapper) {
        this.simuladorMapper = simuladorMapper;
    }

    @Override
    public void listarCompaniaSeguro(ListarCompaniaSeguroProcedure parametros) {
        simuladorMapper.listarCompaniaSeguro(parametros);
    }

    @Override
    public void listarProforma(ListarProformaProcedure parametros) {
        simuladorMapper.listarProforma(parametros);
    }

    @Override
    public void listarSimuladorConcepto(ListarSimuladorConceptoProcedure parametros) {
        simuladorMapper.listarSimuladorConcepto(parametros);
    }

    @Override
    public void registrarSimulador(RegistrarSimuladorProcedure parametros) {
        simuladorMapper.registrarSimulador(parametros);
    }
    
    @Override
    public void registrarSimuladorSap(RegistrarSimuladorSapProcedure parametros) {
        simuladorMapper.registrarSimuladorSap(parametros);
    }    

    @Override
    public void registrarSimuladorGasto(RegistrarSimuladorGastoProcedure parametros) {
        simuladorMapper.registrarSimuladorGasto(parametros);
    }

    @Override
    public void generarCronograma(GenerarCronogramaProcedure parametros) {
        simuladorMapper.generarCronograma(parametros);
    }
    
    @Override
    public void cuadrarCronograma(ListarCronogramaProcedure parametros) {
        simuladorMapper.cuadrarCronograma(parametros);
    }    

    @Override
    public void listarCronograma(ListarCronogramaProcedure parametros) {
        simuladorMapper.listarCronograma(parametros);
    }
    
    @Override
    public void listarPropuesta(ListarPropuestaProcedure parametros) {
        simuladorMapper.listarPropuesta(parametros);
    }

    @Override
    public void listarGasto(ListarSimuladorGastoProcedure parametros) {
        simuladorMapper.listarGasto(parametros);
    }    

    @Override
    public void obtenerTasaSeguro(ObtenerTasaSeguroProcedure parametros) {
        simuladorMapper.obtenerTasaSeguro(parametros);
    }
    
    @Override
    public void calculaTasa(CalculaTasaProcedure parametros) {
        simuladorMapper.calculaTasa(parametros);
    }

    @Override
    public GenericoResponse generarPlantillaCambioTasaSeguro(GenerarPlantillaCambioTasaSeguroProcedure parametros) throws Exception {
        simuladorMapper.generarPlantillaCambioTasaSeguro(parametros);
        int statusQuery = parametros.getStatus();
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(parametros.getMensaje());
            response.setCodigo(parametros.getCodigo());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());
        }
    }    

    @Override
    public void listarTasas(ListarTasasProcedure parametros) {
        simuladorMapper.listarTasas(parametros);
    }
    
    @Override
    public void registrarSimuladorProforma(RegistrarSimuladorProformaProcedure parametros) {
        simuladorMapper.registrarSimuladorProforma(parametros);
    }
    }
