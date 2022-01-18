package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.GarantiaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.CoberturaGarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaHistoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GarantiaResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;

public interface GarantiaService {

    public GarantiaListadoResponse listar(HeaderParams headerParams, String codSoliCred, String indTipoGarantia) throws Exception;
    
    public GarantiaResponse insertar(HeaderParams headerParams, GarantiaRequest request) throws Exception;
    
    public GarantiaHistoListadoResponse listarHistorico(HeaderParams headerParams, String codSoliCred, String indTipoGarantia, String codCliente, String numPedidoVeh) throws Exception;

    public BaseResponse eliminar(HeaderParams headerParams, GarantiaRequest request) throws Exception;
    public BaseResponse eliminarByGara(HeaderParams headerParams, GarantiaRequest request) throws Exception;
    
     public PaisListadoResponse listarPaises(HeaderParams headerParams, String codCia) throws Exception;
    
    public DepartamentoListadoResponse listarDepartamentos(HeaderParams headerParams, String codPais) throws Exception;
    
    public ProvinciaListadoResponse listarProvincias(HeaderParams headerParams, String codDepa) throws Exception;
    // I Req. 87567 E2.1 ID avilca 03/06/2020
    public DistritoListadoResponse listarDistritos(HeaderParams headerParams, String codProv,String codDepa) throws Exception;
    // F Req. 87567 E2.1 ID avilca 03/06/2020
    // <I> 90690 ivelasquez 21/09/2021
    public BaseResponse consultarGarantias(HeaderParams headerParams, String codSoliCred) throws Exception;
    // <F> 90690 ivelasquez 21/09/2021
    // <I> 89645 ivelasquez 22/09/2021
    public CoberturaGarantiaResponse listarCoberturaGarantia(HeaderParams headerParams, String codSoliCred);
    // <F> 89645 ivelasquez 22/09/2021
}
