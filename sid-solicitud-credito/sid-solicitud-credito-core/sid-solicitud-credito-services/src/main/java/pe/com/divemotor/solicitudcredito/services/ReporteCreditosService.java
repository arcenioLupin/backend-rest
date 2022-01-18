package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.response.MaestroListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.ReporteCreditosListadoResponse;

public interface ReporteCreditosService {

    public ReporteCreditosListadoResponse listar(HeaderParams headerParams,String tipCred,String areaVta,String zona,String fechIni,String fechFin) throws Exception;
    
    public ReporteCreditoResponse exportarCreditos(HeaderParams headerParams,String tipCred,String areaVta,String zona,String fechIni,String fechFin) throws Exception;
    
    public MaestroListadoResponse listarComboMaestro(HeaderParams headerParams,String tipo) throws Exception;
    
    public MaestroListadoResponse listarFilialZona(HeaderParams headerParams,String tipo, String codDepa, String codProv, String codDist) throws Exception;

}
