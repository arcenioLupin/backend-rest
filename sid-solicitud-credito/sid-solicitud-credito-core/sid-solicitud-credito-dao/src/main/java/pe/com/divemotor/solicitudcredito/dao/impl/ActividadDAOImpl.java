package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.ActividadDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActividadEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividaTipoCredProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.ActualizarActividadProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadAllProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesEtapaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesPorTipoCreditoProcedure;

import pe.com.divemotor.solicitudcredito.dto.procedure.actividad.ListarActividadesProcedure;
import pe.com.divemotor.solicitudcredito.mapper.ActividadMapper;

@Repository
public class ActividadDAOImpl implements ActividadDAO {

    private ActividadMapper actividadMapper;

    @Autowired
    public void setActividadMapper(ActividadMapper actividadMapper) {
        this.actividadMapper = actividadMapper;
    }

    @Override
    public void listar(ListarActividadesProcedure parametros){
        actividadMapper.listar(parametros);
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public void listarActividadesEtapa(ListarActividadesEtapaProcedure parametros) {
        actividadMapper.listarActividadesEtapa(parametros);
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public void listarActividadesEtapaAll(ListarActividadAllProcedure parametros) {
        actividadMapper.listarActividadesEtapaAll(parametros);
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public void crearActividaEtapa(ActividadEtapaProcedure parametros) {
         actividadMapper.crearActividaEtapa(parametros);
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public void actualizarActividad(ActualizarActividadProcedure parametros) {
         actividadMapper.actualizarActividad(parametros);
    }
    //Req. 87567 E2.3 ID340 EBARBOZA 13/04/2020
    @Override
    public void actualizarActividadTipoCred(ActualizarActividaTipoCredProcedure parametros) {
        actividadMapper.actualizarActividadTipoCred(parametros);
    }

    @Override
    public void listarActividadesPorTipoCredito(ListarActividadesPorTipoCreditoProcedure parametros) {
        actividadMapper.listarActividadesPorTipoCredito(parametros);
    }
}
    