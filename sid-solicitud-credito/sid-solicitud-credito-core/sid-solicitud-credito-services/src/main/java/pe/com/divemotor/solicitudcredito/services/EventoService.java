package pe.com.divemotor.solicitudcredito.services;

import java.util.Date;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRegistroRequest;
import pe.com.divemotor.solicitudcredito.dto.request.EventoNotariaRequest;
import pe.com.divemotor.solicitudcredito.dto.request.EventoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.EventoListadoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.EventoNotariaListadoResponse;

public interface EventoService {

    public EventoListadoResponse listarEventos(HeaderParams headerParams, String codSoliCred, String fecItemEvenIni, String fecItemEvenFin,int pagina, int cantidadxPagina) throws Exception;
    
    BaseResponse insertar(HeaderParams headerParams, EventoRequest request) throws Exception;
    //inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    public EventoNotariaListadoResponse listarEventoNotaria(HeaderParams headerParams,EventoNotariaRequest request)throws Exception;
    
    public BaseResponse registrarEvenNota (HeaderParams headerParams,EventoNotariaRegistroRequest request)throws Exception;
    //fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
}
