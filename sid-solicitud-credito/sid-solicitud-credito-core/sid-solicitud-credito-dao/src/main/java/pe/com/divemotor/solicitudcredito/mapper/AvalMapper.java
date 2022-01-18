package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.aval.EliminarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.InsertarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDepartamentosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDistritosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarPaisesAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarProvinciasAvalProcedure;

public interface AvalMapper {

    public void insertar(InsertarAvalProcedure parametros);

    public void eliminar(InsertarAvalProcedure parametros);

    public void eliminarbyaval(EliminarAvalProcedure parametros);

    public void listar(ListarAvalProcedure parametros);

    public void listarAvalesHistorico(ListarAvalProcedure parametros);

    public void listarPaises(ListarPaisesAvalProcedure parametros);

    public void listarDepartamentos(ListarDepartamentosAvalProcedure parametros);

    public void listarProvincias(ListarProvinciasAvalProcedure parametros);

    public void listarDistritos(ListarDistritosAvalProcedure parametros);

}
