package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.AvalRequest;
import pe.com.divemotor.solicitudcredito.dto.response.AvalListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DepartamentoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.DistritoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.PaisListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ProvinciaListadoResponse;

public interface AvalService {

    public BaseResponse insertar(HeaderParams headerParams, AvalRequest request) throws Exception;
    
    public BaseResponse eliminar(HeaderParams headerParams, AvalRequest request) throws Exception;
    
    public BaseResponse eliminarbyaval(HeaderParams headerParams, AvalRequest request) throws Exception;
    
    public AvalListadoResponse listar(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    public AvalListadoResponse listarAvalesHistorico(HeaderParams headerParams, String codSoliCred) throws Exception;
    
    public PaisListadoResponse listarPaises(HeaderParams headerParams, String codCia) throws Exception;
    
    public DepartamentoListadoResponse listarDepartamentos(HeaderParams headerParams, String codPais) throws Exception;
    
    public ProvinciaListadoResponse listarProvincias(HeaderParams headerParams, String codDepa) throws Exception;
    
    public DistritoListadoResponse listarDistritos(HeaderParams headerParams, String codProv) throws Exception;
    
}
