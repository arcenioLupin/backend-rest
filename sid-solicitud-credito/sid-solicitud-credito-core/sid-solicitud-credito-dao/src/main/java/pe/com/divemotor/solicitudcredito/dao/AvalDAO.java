package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.aval.EliminarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.InsertarAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDepartamentosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarDistritosAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarPaisesAvalProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.aval.ListarProvinciasAvalProcedure;

public interface AvalDAO {

    public void insertar(InsertarAvalProcedure parametros);

    public void eliminar(InsertarAvalProcedure parametros);

    public void eliminarbyaval(EliminarAvalProcedure parametros);

    void listar(ListarAvalProcedure parametros);
    
    void listarAvalesHistorico(ListarAvalProcedure parametros);            

    void listarPaises(ListarPaisesAvalProcedure parametros) throws Exception;

    void listarDepartamentos(ListarDepartamentosAvalProcedure parametros) throws Exception;

    void listarProvincias(ListarProvinciasAvalProcedure parametros) throws Exception;

    void listarDistritos(ListarDistritosAvalProcedure parametros) throws Exception;
}
