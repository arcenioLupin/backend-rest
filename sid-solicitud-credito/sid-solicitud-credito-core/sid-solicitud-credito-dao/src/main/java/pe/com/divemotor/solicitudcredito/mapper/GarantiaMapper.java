package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ConsultarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.InsertarGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarCoberturaGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDepartamentosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarDistritosGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasHistoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarGarantiasProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarPaisesGarantiaProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.garantia.ListarProvinciasGarantiaProcedure;

public interface GarantiaMapper {

    void listar(ListarGarantiasProcedure parametros);

    void insertar(InsertarGarantiaProcedure parametros);

    void listarHistorico(ListarGarantiasHistoProcedure parametros);

    void eliminar(InsertarGarantiaProcedure parametros);

    void eliminarByGara(InsertarGarantiaProcedure parametros);

    public void listarPaises(ListarPaisesGarantiaProcedure parametros);

    public void listarDepartamentos(ListarDepartamentosGarantiaProcedure parametros);

    public void listarProvincias(ListarProvinciasGarantiaProcedure parametros);

    public void listarDistritos(ListarDistritosGarantiaProcedure parametros);
    
    void listarCoberturaGarantia(ListarCoberturaGarantiaProcedure parametros);
    // <I> 90690 ivelasquez 21/09/2021
    void consultarGarantias(ConsultarGarantiasProcedure parametros);
    // <F> 90690 ivelasquez 21/09/2021
}
