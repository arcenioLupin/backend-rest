package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ConsultarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.InsertarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDepartamentosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDistritosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasHistoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarPaisesGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarProvinciasGarantiaProcedure;

public interface GarantiaDAO {

    public void listar(ListarGarantiasProcedure parametros);
    
    public void insertar(InsertarGarantiaProcedure parametros);
    
    public void listarHistorico(ListarGarantiasHistoProcedure parametros);
    
    public void eliminar(InsertarGarantiaProcedure parametros);
    
    public void eliminarByGara(InsertarGarantiaProcedure parametros);
    
    void listarPaises(ListarPaisesGarantiaProcedure parametros) throws Exception;

    void listarDepartamentos(ListarDepartamentosGarantiaProcedure parametros) throws Exception;

    void listarProvincias(ListarProvinciasGarantiaProcedure parametros) throws Exception;

    void listarDistritos(ListarDistritosGarantiaProcedure parametros) throws Exception;
    
    void listarCoberturaGarantia(ListarCoberturaGarantiaProcedure parametros)throws Exception;
    // <I> 90690 ivelasquez 21/09/2021
    public void consultarGarantias(ConsultarGarantiasProcedure parametros);
    // <F> 90690 ivelasquez 21/09/2021
}
