package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroMaturityRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenFinancieroListadoResponse;

public interface ResumenFinancieroService {

    public ResumenFinancieroListadoResponse listar(HeaderParams headerParams, String codSoliCred, String codcliente) throws Exception;
    
    public BaseResponse insertar(HeaderParams headerParams, ResumenFinancieroRequest request) throws Exception;
    
    public BaseResponse insertarMaturity(HeaderParams headerParams, ResumenFinancieroMaturityRequest request) throws Exception;
    
    public ResumenFinancieroListadoResponse listarRangos(HeaderParams headerParams, String codSoliCred, String codcliente,String anioSup,String anioInf) throws Exception;
}
